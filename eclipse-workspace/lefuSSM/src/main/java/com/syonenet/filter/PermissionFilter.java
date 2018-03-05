package com.syonenet.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.syonenet.entity.Permission;
import com.syonenet.entity.User;
import com.syonenet.util.ResponseUtil;
import com.syonenet.util.StringUtil;

public class PermissionFilter implements Filter {

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
		
		if (path.indexOf("login.jsp") > -1) {
			arg2.doFilter(req, resp);
			return;
		}

		if (user == null) {
			// 跳转到登陆页面
			resp.sendRedirect("login.jsp");
		} else {
			
			if (path.indexOf("index.jsp") > -1) {
				arg2.doFilter(req, resp);
				return;
			}
			
			if (path.indexOf("doUserPwdModify.do") > -1) {
				arg2.doFilter(req, resp);
				return;
			}
			
			if (path.indexOf("doUserExit.do") > -1) {
				arg2.doFilter(req, resp);
				return;
			}
			
			if (path.indexOf("navigationBrowse.do") > -1) {
				arg2.doFilter(req, resp);
				return;
			}
			
			if (path.indexOf("newsBrowse.do") > -1) {
				arg2.doFilter(req, resp);
				return;
			}
			
			if(user.getRoleId() == 1){
				arg2.doFilter(req, resp);
				return;
			}
			
			List<Permission> permissionList = user.getPermissionList();
			List<String> urlList = null;
			
			if(permissionList == null || permissionList.size() == 0){
				try {
					StringUtil.outPutAlert("您没有权限访问该页面或执行该操作，如需要该权限请联系管理员！", "", resp);
				} catch (Exception e) {
					
				}
			}else{
				urlList = new ArrayList<>();
				
				for(Permission permission: permissionList){
					urlList.add(permission.getPermissionUrl());
				}				
			}

			String  url = path.substring(path.lastIndexOf('/')+1 ,path.length());

				if (!urlList.contains(url)) {
					JSONObject object = new JSONObject();
					object.put("error", "您没有权限访问该页面或执行该操作，如需要该权限请联系管理员！");
					try {
						ResponseUtil.write(resp, object);
						return;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}


	        // 如果有，则则放行
			arg2.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
