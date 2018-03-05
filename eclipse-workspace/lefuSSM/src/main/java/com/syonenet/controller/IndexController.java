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
 * ǰ̨ҳ��
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
	 * չʾ��ҳ
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index.html")
	public String index(HttpServletRequest request) {
		// ��ȡ������
		ServletContext application = request.getServletContext();
		Count count = (Count) application.getAttribute("count");
		// ��ȡ��ֵ
		int day = Integer.parseInt(count.getCountDay()) + 1;
		int total = Integer.parseInt(count.getCountTotal()) + 1;
		// ������ֵ
		count.setCountDay(day + "");
		count.setCountTotal(total + "");
		countService.updateCount(count);
		application.setAttribute("count", count);
		// ��ȡ��ǰʱ�����
		Object obj = application.getAttribute("nowTime");
		if (obj == null) {
			application.setAttribute("nowTime", System.currentTimeMillis());
		}
		// ��ת
		return "index";
	}
	// =================================================================

	@RequestMapping(value = "/navigationTableList.html")
	public String navigationTableList(Integer typeId, Integer newsId, Integer page, HttpServletRequest request) {

		ServletContext application = request.getServletContext();

		@SuppressWarnings("unchecked")
		List<NewsType> typeList = (List<NewsType>) application.getAttribute("newsTypes");


		// ��ȡ��ǰ����
		NewsType newsTypeNow = typeService.findNewsTypeById(typeId);
		if (newsTypeNow != null) {

			// ��ȡ�㼶����
			List<NewsType> linkList = TreeBuilder.getParents(typeList, newsTypeNow.getTypeId());

			for (NewsType newsType2 : linkList) {
				if (newsType2.getTypePid() == 1) {
					// ��ȡ��������
					request.setAttribute("newsType", newsType2);
				}
			}

			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < linkList.size(); i++) {
				sb.append(linkList.get(i).getTypeId() + ",");
			}

			// ��ȡ��������
			request.setAttribute("typeIdArr", sb.toString());
			request.setAttribute("linkList", linkList);
		}

		return "navigationTableList";

	}
	// =================================================================

	@RequestMapping(value = "/code.html")
	public String code(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ���û��棬ÿ�η��ʴ�ҳ�棬����������
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// ������֤���ʵ������
		Code code = new Code();
		// ��������ķ��������ص������ɵ���֤���е��ַ���
		String codeStr = code.getEnsure(0, 0, response.getOutputStream());
		// ���ַ���������session��
		request.getSession().setAttribute("LOG_CODE", codeStr);
		return null;
	}

	/**
	 * �û���¼
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login.html")
	public String login(User user, HttpServletRequest request, HttpSession session) {

		// ����
		String jumpUrl = "forward:/system/login.jsp";

		// ��ȡsession �е���֤��
		String code = (String) session.getAttribute("LOG_CODE");

		// ��֤���Ƿ����
		if (code == null) {
			returnMessage(user, "��֤�벻��ȷ��������ˢ�£�", request);
			return jumpUrl;
		}

		// ��֤����֤
		if (!code.equals(user.getLogCode())) {
			returnMessage(user, "��֤�벻��ȷ��������ˢ�£�", request);
			return jumpUrl;
		}

		// ��ѯ�˺���Ϣ
		User userData = userService.findUserByUserLogId(user.getUserLogId());

		// �������ʺ�
		if (userData == null) {
			returnMessage(user, "���˺Ų����ڣ������³��ԣ�", request);
			return jumpUrl;
		}

		// ��֤�˺�״̬
		if (userData.getStatusId() != 1) {
			returnMessage(user, "���˺��ѱ����ã�����ϵ����Ա��", request);
			return jumpUrl;
		}

		// ������������
		if (userData.getErrorTime() != null && userData.getErrorTime() != "") {
			// ��ȡ����ʱ��
			long lastTime = 0;
			try {
				lastTime = Long.parseLong(userData.getErrorTime());
			} catch (Exception e) {
			}

			long time = System.currentTimeMillis() - lastTime;

			// ����ʱ��С��1Сʱ
			if (time < 3600000) {
				returnMessage(user, "1-���˺��ѱ���������1Сʱ���ٴγ��Ի���ϵ����Ա��", request);
				return jumpUrl;
			}
		}

		// ��֤�����Ƿ����
		if (!userData.getUserPassword().equals(Encryption.MD5(user.getUserPassword()))) {

			int number = userData.getErrorCount();

			if (number >= 5) {
				userData.setErrorTime(System.currentTimeMillis() + "");
				userService.updateUserError(userData);
				returnMessage(user, "2-���˺��ѱ���������1Сʱ���ٴγ��Ի���ϵ����Ա��", request);
				return jumpUrl;
			} else {
				userData.setErrorCount(number + 1);
				userService.updateUserError(userData);
				returnMessage(user, "���벻��ȷ��ʣ��" + (5 - number) + "�Σ�", request);
				return jumpUrl;
			}

		}

		// ��ȡ����ʱ��
		long lastTime = 0;
		try {
			lastTime = Long.parseLong(userData.getErrorTime());
		} catch (Exception e) {
		}

		long time = System.currentTimeMillis() - lastTime;

		// ����ʱ��С��1Сʱ
		if (time < 3600000) {
			returnMessage(user, "���˺��ѱ���������1Сʱ���ٴγ��Ի���ϵ����Ա��", request);
			return jumpUrl;
		}

		// ����������Ե�¼�����浽SESSION��
		session.setAttribute("USER", userData);

		// ���������ʴ�����Ϊ0������
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
