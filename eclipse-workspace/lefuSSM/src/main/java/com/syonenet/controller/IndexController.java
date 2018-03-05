package com.syonenet.controller;


import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.Count;
import com.syonenet.entity.NewsType;
import com.syonenet.entity.User;
import com.syonenet.service.CountService;
import com.syonenet.system.user.service.UserService;
import com.syonenet.system.videocard.service.TypeService;
import com.syonenet.util.Code;
import com.syonenet.util.Encryption;
import com.syonenet.util.TreeBuilder;

/**
 * 前台页面
 * 
 * @author yzls
 * 
 */
@Controller
public class IndexController {

	@Autowired
	private UserService userService;	
	@Autowired
	private CountService countService;
	
	@Autowired
	private TypeService typeService;


	/**
	 * 展示首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index.html")
	public String index(HttpServletRequest request) {
		// 获取作用域
		ServletContext application = request.getServletContext();
		Count count = (Count) application.getAttribute("count");
		// 获取数值
		int day = Integer.parseInt(count.getCountDay()) + 1;
		int total = Integer.parseInt(count.getCountTotal()) + 1;
		// 更新数值
		count.setCountDay(day + "");
		count.setCountTotal(total + "");
		countService.updateCount(count);
		application.setAttribute("count", count);
		// 获取当前时间对象
		Object obj = application.getAttribute("nowTime");
		if (obj == null) {
			application.setAttribute("nowTime", System.currentTimeMillis());
		}
		// 跳转
		return "index";
	}
	// =================================================================

	@RequestMapping(value = "/navigationTableList.html")
	public String navigationTableList(Integer typeId, Integer newsId, Integer page, HttpServletRequest request) {

		ServletContext application = request.getServletContext();

		@SuppressWarnings("unchecked")
		List<NewsType> typeList = (List<NewsType>) application.getAttribute("newsTypes");


		// 获取当前类型
		NewsType newsTypeNow = typeService.findNewsTypeById(typeId);
		if (newsTypeNow != null) {

			// 获取层级父类
			List<NewsType> linkList = TreeBuilder.getParents(typeList, newsTypeNow.getTypeId());

			for (NewsType newsType2 : linkList) {
				if (newsType2.getTypePid() == 1) {
					// 获取导航分类
					request.setAttribute("newsType", newsType2);
				}
			}

			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < linkList.size(); i++) {
				sb.append(linkList.get(i).getTypeId() + ",");
			}

			// 获取导航分类
			request.setAttribute("typeIdArr", sb.toString());
			request.setAttribute("linkList", linkList);
		}

		return "navigationTableList";

	}
	// =================================================================

	@RequestMapping(value = "/code.html")
	public String code(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 禁用缓存，每次访问此页面，都重新生成
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 生成验证码的实例对象
		Code code = new Code();
		// 调用里面的方法，返回的是生成的验证码中的字符串
		String codeStr = code.getEnsure(0, 0, response.getOutputStream());
		// 把字符串保存在session中
		request.getSession().setAttribute("LOG_CODE", codeStr);
		return null;
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login.html")
	public String login(User user, HttpServletRequest request, HttpSession session) {

		// 返回
		String jumpUrl = "forward:/system/login.jsp";

		// 获取session 中的验证码
		String code = (String) session.getAttribute("LOG_CODE");

		// 验证码是否存在
		if (code == null) {
			returnMessage(user, "验证码不正确，请重新刷新！", request);
			return jumpUrl;
		}

		// 验证码验证
		if (!code.equals(user.getLogCode())) {
			returnMessage(user, "验证码不正确，请重新刷新！", request);
			return jumpUrl;
		}

		// 查询账号信息
		User userData = userService.findUserByUserLogId(user.getUserLogId());

		// 不存在帐号
		if (userData == null) {
			returnMessage(user, "该账号不存在，请重新尝试！", request);
			return jumpUrl;
		}

		// 验证账号状态
		if (userData.getStatusId() != 1) {
			returnMessage(user, "该账号已被禁用，请联系管理员！", request);
			return jumpUrl;
		}

		// 超过锁定次数
		if (userData.getErrorTime() != null && userData.getErrorTime() != "") {
			// 获取错误时间
			long lastTime = 0;
			try {
				lastTime = Long.parseLong(userData.getErrorTime());
			} catch (Exception e) {
			}

			long time = System.currentTimeMillis() - lastTime;

			// 冻结时间小于1小时
			if (time < 3600000) {
				returnMessage(user, "1-该账号已被锁定，请1小时后再次尝试或联系管理员！", request);
				return jumpUrl;
			}
		}

		// 验证密码是否相等
		if (!userData.getUserPassword().equals(Encryption.MD5(user.getUserPassword()))) {

			int number = userData.getErrorCount();

			if (number >= 5) {
				userData.setErrorTime(System.currentTimeMillis() + "");
				userService.updateUserError(userData);
				returnMessage(user, "2-该账号已被锁定，请1小时后再次尝试或联系管理员！", request);
				return jumpUrl;
			} else {
				userData.setErrorCount(number + 1);
				userService.updateUserError(userData);
				returnMessage(user, "密码不正确，剩余" + (5 - number) + "次！", request);
				return jumpUrl;
			}

		}

		// 获取错误时间
		long lastTime = 0;
		try {
			lastTime = Long.parseLong(userData.getErrorTime());
		} catch (Exception e) {
		}

		long time = System.currentTimeMillis() - lastTime;

		// 冻结时间小于1小时
		if (time < 3600000) {
			returnMessage(user, "该账号已被锁定，请1小时后再次尝试或联系管理员！", request);
			return jumpUrl;
		}

		// 其它情况可以登录，保存到SESSION中
		session.setAttribute("USER", userData);

		// 如果错误访问次数不为0更新下
		if (userData.getErrorCount() != 0) {
			userService.modifyUserMessage(userData.getUserId());
		}

		return "redirect:/system/index.jsp";
	}

	private void returnMessage(User user, String message, HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("user", user);
		request.setAttribute("errorMsg", message);
	}

}
