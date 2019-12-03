package com.oracle.filter;

import com.oracle.shiro.AuthenticationToKen;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest req, ServletResponse res) throws Exception {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
			response.addHeader("loginStatus", "accessDenied");
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		return super.onAccessDenied(request, response);
	}

	/**
	 * 监听 表单提交  然后再表单 中 获取  登录名 和密码  及 验证码
	 * @Title: createToken
	 * @param [request, response]
	 * @return org.apache.shiro.authc.AuthenticationToken
	 * @author: Flame
	 * @since: 2019/7/15 11:55
	 */
	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		boolean bln=true;
		String loginName=getUsername(request);
		String password=getPassword(request);
		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session=req.getSession();
		String captCode=request.getParameter("code");
		String sessionCaptCode=(String) session.getAttribute("valcode");

		// 验证是否 正确
		if((null==sessionCaptCode)||(null==captCode)) {
			bln=false;
		}
		if(sessionCaptCode!=null&&captCode!=null) {
			if(!sessionCaptCode.equals(captCode)) {
				bln=false;
			}
		}
		return new AuthenticationToKen(loginName, password,bln);
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		WebUtils.issueRedirect(request, response, getSuccessUrl());
		return false;
	}
}
