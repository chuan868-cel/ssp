package com.oracle.asp;

//定义一个切面类

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.oracle.log.service.api.LogService;
import com.oracle.common.utils.HttpServletRequestUtils;
import com.oracle.common.utils.IPUtils;
import com.oracle.pojo.Log;
import com.oracle.shiro.Principal;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component //交给spring管理
public class JournalAspect {

    //定义切面规则
    @Pointcut("execution (* com.oracle.controller.*.*(..))")
    public void pointcutMethod(){}

    @Autowired
    private LogService logService;

    //环绕切入
    @Around("pointcutMethod()")
    public Object aroundMethod(ProceedingJoinPoint pjp){
        Object object = null;
        HttpServletRequest request = HttpServletRequestUtils.getRequest();
        Principal principal = (Principal) SecurityUtils.getSubject().getPrincipal();
        //获取开始的时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //参数列表信息
        Log log = new Log();
        long startTime=System.currentTimeMillis();
        String time=(System.currentTimeMillis()-startTime)+"ms";
        log.setExecutemethodname(pjp.getSignature().getDeclaringTypeName() +
                "." + pjp.getSignature().getName());
        log.setRequestime(df.format(new Date()));
        log.setExecutetime(time);
        log.setRequestdesc((pjp.getSignature().getName().equals("main"))?"主页面请求":"系统信息统计");
        log.setExecutorname(principal.getLoginName());
        Object[] args = pjp.getArgs();//参数列表
        if(args.length>0){
            String argsString = JSON.toJSONString(args[0]);
            log.setExecuteargs(argsString);
        }
        log.setRequestip(IPUtils.getIpAddr(request));
        //根据包名比对是否是访问日志
        if ((pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName()).indexOf("LogController")==-1){
            this.logService.save(log);
        }
        System.out.println("@AfterReturning：执行目标方法为：" +
                pjp.getSignature().getDeclaringTypeName() +
                " -> " + pjp.getSignature().getName());
        System.out.println("执行时间:"+time);
        System.out.println("@AfterReturning：实现人员名称为：" +
                principal.getLoginName());
        System.out.println("@AfterReturning：请求IP地址：" +
                IPUtils.getIpAddr(request));
        System.out.println("@AfterReturning：请求描述：" +
                "(pjp.getSignature().getName().equals(\"main\"))?\"主页面请求\":\"系统信息统计\"");
        System.out.println("@AfterReturning：参数列表信息：" +
                Arrays.toString(pjp.getArgs()));
        System.out.println("@AfterReturning：被织入的目标对象为：" + pjp.getTarget());
        try {
            object = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }
}
