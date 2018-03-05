package com.syonenet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.syonenet.entity.User;

public class LoginFilter implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession session = req.getSession();
		
		// 获得用户请求的URI
		String path = req.getRequestURI();
		
		// 从session取得已经登录验证的凭证
		User user = (User) session.getAttribute("USER");
		
		// login.jsp页面无需过滤(根据自己项目的要求来),include文件夹中的资源无需过滤
		// 也可以path.contains("login.jsp") 反正怎么精确怎么来就不多说了
		if (path.indexOf("login.jsp") > -1||path.indexOf("include") > -1) {
			arg2.doFilter(req, resp);
			return;
		} else {// 如果不是login.jsp进行过滤
			if (user == null) {
				// 跳转到登陆页面
				resp.sendRedirect("../system/login.jsp");
			} else {
				// 已经登陆,继续此次请求
				arg2.doFilter(req, resp);
			}
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
