package com.oracle.member.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.oracle.common.utils.RandomCodeUtils;
import com.oracle.data.ServiceEntity;
import com.oracle.mapper.MemberMapper;
import com.oracle.member.service.api.MemberService;
import com.oracle.pojo.Member;
import com.oracle.pojo.MemberExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JmsTemplate jmsQueueTemplate;

    @Autowired
    private Destination mobileDestination;

    private static final String CACHE_PREFIX = "member:";

    @Override
    public ServiceEntity register(Member member) {
        ServiceEntity serviceEntity =new ServiceEntity();
        int rows=  memberMapper.insert(member);
        if (rows>0){
            serviceEntity.setCode(0);
            return serviceEntity;
        }else {
            serviceEntity.setCode(-1);
            return serviceEntity;
        }
    }

    @Override
    public ServiceEntity checkedMobile(String mobile) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(mobile);
        List<Member> list = this.memberMapper.selectByExample(example);
        ServiceEntity serviceEntity = new ServiceEntity();
        if(list.isEmpty()){
            serviceEntity.setCode(0);
            serviceEntity.setMsg("手机号码可以使用");
        }else{
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("手机号已被注册，请更换");
        }
        return serviceEntity;
    }

    @Override
    public ServiceEntity getMobileCode(String mobile) {
        // 1 生产一个验证码
        // 2 存放进redis 中 进行缓存 时间是1 分钟
        // 3 短信发送() 应用解耦 -> 把发送的消息  推进MQ中
        //  Application 凡是 第三方服务 都会在 这个模块中进行定义 短信 邮件
        String randomCode = RandomCodeUtils.createRegisterCode().toString();
        final String CACHE_KEY = CACHE_PREFIX+mobile;
        this.redisTemplate.boundValueOps(CACHE_KEY).set(randomCode,1,TimeUnit.MINUTES);
        // 将这个消息内容推送MQ
        jmsQueueTemplate.send(mobileDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(mobile+"#"+randomCode);
            }
        });
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setCode(0);
        return serviceEntity;
    }

    @Override
    public ServiceEntity checkedMobileCode(String mobile, String code) {
        ServiceEntity serviceEntity=new ServiceEntity();
        // code 不能为空
        if (code==null || "".equals(code)){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("验证码不能为空");
            return serviceEntity;
        }
        // 1.从redis中获取   code
        final String CHACH_KEY=CACHE_PREFIX+mobile;
        System.out.println(CHACH_KEY);
        String redisCode= (String) this.redisTemplate.boundValueOps(CHACH_KEY).get();
        System.out.println(redisCode);
        // 2.判断
        if (redisCode==null){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("验证码已经超时");
            return serviceEntity;
        }
        if (!code.equals(redisCode)){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("验证码不正确");
            return serviceEntity;
        }
        serviceEntity.setCode(0);
        return serviceEntity;
    }

    @Override
    public ServiceEntity checkedLoginname(String loginname) {
        Member member= memberMapper.findMemberByLoginName(loginname);
        ServiceEntity serviceEntity =new ServiceEntity();
        if (member==null){
            serviceEntity.setCode(0);
            return serviceEntity;
        }else {
            serviceEntity.setCode(-1);
            return serviceEntity;
        }
    }
}
