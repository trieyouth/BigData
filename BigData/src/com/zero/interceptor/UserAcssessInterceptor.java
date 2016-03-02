package com.zero.interceptor;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zero.common.Global;
import com.zero.service.UserService;

/*
 * created by youth on 16-2-20
 * */

public class UserAcssessInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		String contextPath = request.getContextPath();
		String url = request.getServletPath().toString();
		String method = request.getMethod();
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute(Global.USERNAME);
		System.out.println("debug : " + "request url : " + url + "     method : " + method);
		if (username != null) {

			if (userService.findAuthority(username, 1)) {
				if (Pattern.matches("/ccas/([a-z]|/|-|[0-9]|[A-Z]|.)*", url)) {
					return true;
				}
			}

			if (userService.findAuthority(username, 2)) {
				if (Pattern.matches("/icpas/([a-z]|/|-|[0-9]|[A-Z]|.)*", url)) {
					return true;
				}
			}

			if (userService.findAuthority(username, 3)) {
				if (Pattern.matches("/manager/([a-z]|/|-|[0-9]|[A-Z]|.)*", url)) {
					return true;
				}
			}
		} else {
			response.sendRedirect(contextPath + "/login");
			return false;
		}
		response.sendRedirect(contextPath + "/error");// ��ʱû��
		return false;
	}
}
