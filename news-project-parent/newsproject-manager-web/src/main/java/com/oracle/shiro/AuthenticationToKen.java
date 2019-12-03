package com.oracle.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义令牌
 * @author zhaoran
	2017年12月31日
 *
 */
public class AuthenticationToKen extends UsernamePasswordToken{
	private boolean isValid;
	public AuthenticationToKen(String loginName,String password,boolean isValid) {
		super(loginName, password);
		this.isValid=isValid;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	
}
