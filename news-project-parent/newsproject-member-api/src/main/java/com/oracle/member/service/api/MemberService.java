package com.oracle.member.service.api;

import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Member;

public interface MemberService {

    // 注册
    ServiceEntity register(Member member);

    // 校验手机号
    ServiceEntity checkedMobile(String mobile);

    // 获取手机验证码
    ServiceEntity getMobileCode(String mobile);// 手机验证  一般是 2 分钟 或 3分钟

    // 校验手机验证码
    ServiceEntity checkedMobileCode(String mobile, String code);

    ServiceEntity checkedLoginname(String loginname);
}
