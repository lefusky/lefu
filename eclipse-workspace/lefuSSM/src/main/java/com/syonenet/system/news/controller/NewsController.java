package com.syonenet.system.news.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;

import com.syonenet.entity.Department;
import com.syonenet.entity.News;
import com.syonenet.entity.PageBean;
import com.syonenet.entity.User;
import com.syonenet.system.init.AdminInitComponent;
import com.syonenet.system.news.service.NewsService;
import com.syonenet.util.DateJsonValueProcessor;
import com.syonenet.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * ��Ϣ����
 * 
 * @author yzls
 *
 */
@Controller
@RequestMapping(value = "/system")
public class NewsController {

	@Autowired
	private NewsService newsService;
	@Autowired
	private AdminInitComponent initComponent;

	// ͼƬ����

	/**
	 * �б�
	 * 
	 * @param page
	 * @param rows
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsPicList.do")
	public String newsPicList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "newsTitle", required = false) String newsTitle, HttpSession session,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());

		if (newsTitle != null && newsTitle.trim() != "") {
			map.put("newsTitle", newsTitle);
		}

		User user = (User) session.getAttribute("USER");
		if (user.getRoleId() == 1) {

		} else if (user.getRoleId() == 2) {

			List<Department> departmentList = user.getDepartmentList();
			if (departmentList != null && departmentList.size() > 0) {
				map.put("departmentList", departmentList);
			} else {
				map.put("userId", "0");
			}

		} else {
			map.put("userId", user.getUserId());
		}

		map.put("typeId", 2);

		int total = newsService.findNewsCount(map);
		List<News> newsList = newsService.findNewsList(map);
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(newsList, jsonConfig);
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ����
	 * 
	 * @param news
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsPicSave.do")
	public String doNewsPicSave(News news, HttpSession session, HttpServletResponse response) throws Exception {
		int total = 0;

		// ���⸳ֵ
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			news.setUserId(user.getUserId());
			news.setUserNick(user.getUserNick());
			news.setDepartmentId(user.getDepartmentId());
		}
		news.setTypePid(0);
		news.setTypeId(2);
		news.setAddTime(new Date());
		news.setAddDate(new Date().getTime());
		news.setStatusId(0);
		if (news.getNewsRed() == null) {
			news.setNewsRed(0);
		}
		if (news.getIsJump() == null) {
			news.setIsJump(0);
			news.setJumpUrl("");
		}

		if (news.getNewsId() == null) {
			// ���
			total = newsService.addNews(news);
		} else {
			// �޸�
			total = newsService.updateNews(news);
		}
		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ɾ��
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsPicDelete.do")
	public String doNewsPicDelete(@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			newsService.deleteNews(Integer.parseInt(idsStr[i]));
		}

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ��ѯ
	 * 
	 * @param newsId
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findNewsPicById.do")
	public String findNewsPicById(@RequestParam(value = "newsId", required = true) String newsId, HttpSession session,
			HttpServletResponse response) throws Exception {

		User user = (User) session.getAttribute("USER");
		News news = null;
		Map<String, Object> map = null;

		if (user.getRoleId() == 1 || user.getRoleId() == 2) {
			news = newsService.findNewsById(Integer.parseInt(newsId));
		} else {
			map = new HashMap<>();
			map.put("newsId", newsId);
			map.put("userId", user.getUserId());
			news = newsService.findNewsByCondition(map);
		}

		JSONObject jsonObject = JSONObject.fromObject(news);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

	/**
	 * ���
	 * 
	 * @param newsId
	 * @param statusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsPicAudit.do")
	public String doNewsPicAudit(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "statusId", required = true) String statusId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setStatusId(Integer.parseInt(statusId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * �ö�
	 * 
	 * @param newsId
	 * @param topId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsPicTop.do")
	public String doNewsPicTop(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "topId", required = true) String topId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setTopId(Integer.parseInt(topId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	// ֪ͨ��ʼ

	/**
	 * �б�
	 * 
	 * @param page
	 * @param rows
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsNoticList.do")
	public String newsNoticList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "newsTitle", required = false) String newsTitle, HttpSession session,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());

		if (newsTitle != null && newsTitle.trim() != "") {
			map.put("newsTitle", newsTitle);
		}

		User user = (User) session.getAttribute("USER");
		if (user.getRoleId() == 1) {

		} else if (user.getRoleId() == 2) {

			List<Department> departmentList = user.getDepartmentList();
			if (departmentList != null && departmentList.size() > 0) {
				map.put("departmentList", departmentList);
			} else {
				map.put("userId", "0");
			}

		} else {
			map.put("userId", user.getUserId());
		}

		map.put("typeId", 3);

		int total = newsService.findNewsCount(map);
		List<News> newsList = newsService.findNewsList(map);
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(newsList, jsonConfig);
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ����
	 * 
	 * @param news
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsNoticSave.do")
	public String doNewsNoticSave(News news, HttpSession session, HttpServletResponse response) throws Exception {
		int total = 0;

		// ���⸳ֵ
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			news.setUserId(user.getUserId());
			news.setUserNick(user.getUserNick());
			news.setDepartmentId(user.getDepartmentId());
		}
		news.setTypePid(0);
		news.setTypeId(3);
		news.setAddTime(new Date());
		news.setAddDate(new Date().getTime());
		news.setStatusId(0);
		if (news.getNewsRed() == null) {
			news.setNewsRed(0);
		}
		if (news.getIsJump() == null) {
			news.setIsJump(0);
			news.setJumpUrl("");
		}

		if (news.getNewsId() == null) {
			// ���
			total = newsService.addNews(news);
		} else {
			// �޸�
			total = newsService.updateNews(news);
		}
		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ɾ��
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsNoticDelete.do")
	public String doNewsNoticDelete(@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			newsService.deleteNews(Integer.parseInt(idsStr[i]));
		}

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ��ѯ
	 * 
	 * @param newsId
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findNewsNoticById.do")
	public String findNewsNoticById(@RequestParam(value = "newsId", required = true) String newsId, HttpSession session,
			HttpServletResponse response) throws Exception {

		User user = (User) session.getAttribute("USER");
		News news = null;
		Map<String, Object> map = null;

		if (user.getRoleId() == 1 || user.getRoleId() == 2) {
			news = newsService.findNewsById(Integer.parseInt(newsId));
		} else {
			map = new HashMap<>();
			map.put("newsId", newsId);
			map.put("userId", user.getUserId());
			news = newsService.findNewsByCondition(map);
		}

		JSONObject jsonObject = JSONObject.fromObject(news);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

	/**
	 * ���
	 * 
	 * @param newsId
	 * @param statusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsNoticAudit.do")
	public String doNewsNoticAudit(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "statusId", required = true) String statusId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setStatusId(Integer.parseInt(statusId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * �ö�
	 * 
	 * @param newsId
	 * @param topId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsNoticTop.do")
	public String doNewsNoticTop(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "topId", required = true) String topId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setTopId(Integer.parseInt(topId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	// ���濪ʼ

	/**
	 * �б�
	 * 
	 * @param page
	 * @param rows
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsAfficheList.do")
	public String newsAfficheList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "newsTitle", required = false) String newsTitle, HttpSession session,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());

		if (newsTitle != null && newsTitle.trim() != "") {
			map.put("newsTitle", newsTitle);
		}

		User user = (User) session.getAttribute("USER");
		if (user.getRoleId() == 1) {

		} else if (user.getRoleId() == 1) {

			List<Department> departmentList = user.getDepartmentList();
			if (departmentList != null && departmentList.size() > 0) {
				map.put("departmentList", departmentList);
			} else {
				map.put("userId", "0");
			}

		} else {
			map.put("userId", user.getUserId());
		}

		map.put("typeId", 4);

		int total = newsService.findNewsCount(map);
		List<News> newsList = newsService.findNewsList(map);
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(newsList, jsonConfig);
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ����
	 * 
	 * @param news
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsAfficheSave.do")
	public String doNewsAfficheSave(News news, HttpSession session, HttpServletResponse response) throws Exception {
		int total = 0;

		// ���⸳ֵ
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			news.setUserId(user.getUserId());
			news.setUserNick(user.getUserNick());
			news.setDepartmentId(user.getDepartmentId());
		}
		news.setTypePid(0);
		news.setTypeId(4);
		news.setAddTime(new Date());
		news.setAddDate(new Date().getTime());
		news.setStatusId(0);
		if (news.getNewsRed() == null) {
			news.setNewsRed(0);
		}
		if (news.getIsJump() == null) {
			news.setIsJump(0);
			news.setJumpUrl("");
		}

		if (news.getNewsId() == null) {
			// ���
			total = newsService.addNews(news);
		} else {
			// �޸�
			total = newsService.updateNews(news);
		}
		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ɾ��
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsAfficheDelete.do")
	public String doNewsAfficheDelete(@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			newsService.deleteNews(Integer.parseInt(idsStr[i]));
		}

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ��ѯ
	 * 
	 * @param newsId
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findNewsAfficheById.do")
	public String findNewsAfficheById(@RequestParam(value = "newsId", required = true) String newsId,
			HttpSession session, HttpServletResponse response) throws Exception {

		User user = (User) session.getAttribute("USER");
		News news = null;
		Map<String, Object> map = null;

		if (user.getRoleId() == 1 || user.getRoleId() == 2) {
			news = newsService.findNewsById(Integer.parseInt(newsId));
		} else {
			map = new HashMap<>();
			map.put("newsId", newsId);
			map.put("userId", user.getUserId());
			news = newsService.findNewsByCondition(map);
		}

		JSONObject jsonObject = JSONObject.fromObject(news);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

	/**
	 * ���
	 * 
	 * @param newsId
	 * @param statusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsAfficheAudit.do")
	public String doNewsAfficheAudit(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "statusId", required = true) String statusId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setStatusId(Integer.parseInt(statusId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * �ö�
	 * 
	 * @param newsId
	 * @param topId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsAfficheTop.do")
	public String doNewsAfficheTop(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "topId", required = true) String topId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setTopId(Integer.parseInt(topId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	// ��ѧ������о���ʼ

	/**
	 * �б�
	 * 
	 * @param page
	 * @param rows
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsResearchList.do")
	public String newsResearchList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "newsTitle", required = false) String newsTitle, HttpSession session,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());

		if (newsTitle != null && newsTitle.trim() != "") {
			map.put("newsTitle", newsTitle);
		}

		User user = (User) session.getAttribute("USER");
		if (user.getRoleId() == 1) {

		} else if (user.getRoleId() == 2) {

			List<Department> departmentList = user.getDepartmentList();
			if (departmentList != null && departmentList.size() > 0) {
				map.put("departmentList", departmentList);
			} else {
				map.put("userId", "0");
			}

		} else {
			map.put("userId", user.getUserId());
		}

		map.put("typeId", 5);

		int total = newsService.findNewsCount(map);
		List<News> newsList = newsService.findNewsList(map);
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(newsList, jsonConfig);
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ����
	 * 
	 * @param news
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsResearchSave.do")
	public String doNewsResearchSave(News news, HttpSession session, HttpServletResponse response) throws Exception {
		int total = 0;

		// ���⸳ֵ
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			news.setUserId(user.getUserId());
			news.setUserNick(user.getUserNick());
			news.setDepartmentId(user.getDepartmentId());
		}
		news.setTypePid(0);
		news.setTypeId(5);
		news.setAddTime(new Date());
		news.setAddDate(new Date().getTime());
		news.setStatusId(0);
		if (news.getNewsRed() == null) {
			news.setNewsRed(0);
		}
		if (news.getIsJump() == null) {
			news.setIsJump(0);
			news.setJumpUrl("");
		}

		if (news.getNewsId() == null) {
			// ���
			total = newsService.addNews(news);
		} else {
			// �޸�
			total = newsService.updateNews(news);
		}
		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ɾ��
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsResearchDelete.do")
	public String doNewsResearchDelete(@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			newsService.deleteNews(Integer.parseInt(idsStr[i]));
		}

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ��ѯ
	 * 
	 * @param newsId
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findNewsResearchById.do")
	public String findNewsResearchById(@RequestParam(value = "newsId", required = true) String newsId,
			HttpSession session, HttpServletResponse response) throws Exception {

		User user = (User) session.getAttribute("USER");
		News news = null;
		Map<String, Object> map = null;

		if (user.getRoleId() == 1 || user.getRoleId() == 2) {
			news = newsService.findNewsById(Integer.parseInt(newsId));
		} else {
			map = new HashMap<>();
			map.put("newsId", newsId);
			map.put("userId", user.getUserId());
			news = newsService.findNewsByCondition(map);
		}

		JSONObject jsonObject = JSONObject.fromObject(news);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

	/**
	 * ���
	 * 
	 * @param newsId
	 * @param statusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsResearchAudit.do")
	public String doNewsResearchAudit(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "statusId", required = true) String statusId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setStatusId(Integer.parseInt(statusId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * �ö�
	 * 
	 * @param newsId
	 * @param topId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsResearchTop.do")
	public String doNewsResearchTop(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "topId", required = true) String topId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setTopId(Integer.parseInt(topId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	// ���ʽ�����ʼ

	/**
	 * �б�
	 * 
	 * @param page
	 * @param rows
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsQualityList.do")
	public String newsQualityList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "newsTitle", required = false) String newsTitle, HttpSession session,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());

		if (newsTitle != null && newsTitle.trim() != "") {
			map.put("newsTitle", newsTitle);
		}

		User user = (User) session.getAttribute("USER");
		if (user.getRoleId() == 1) {

		} else if (user.getRoleId() == 2) {

			List<Department> departmentList = user.getDepartmentList();
			if (departmentList != null && departmentList.size() > 0) {
				map.put("departmentList", departmentList);
			} else {
				map.put("userId", "0");
			}

		} else {
			map.put("userId", user.getUserId());
		}

		map.put("typeId", 6);

		int total = newsService.findNewsCount(map);
		List<News> newsList = newsService.findNewsList(map);
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(newsList, jsonConfig);
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ����
	 * 
	 * @param news
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsQualitySave.do")
	public String doNewsQualitySave(News news, HttpSession session, HttpServletResponse response) throws Exception {
		int total = 0;

		// ���⸳ֵ
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			news.setUserId(user.getUserId());
			news.setUserNick(user.getUserNick());
			news.setDepartmentId(user.getDepartmentId());
		}
		news.setTypePid(0);
		news.setTypeId(6);
		news.setAddTime(new Date());
		news.setAddDate(new Date().getTime());
		news.setStatusId(0);
		if (news.getNewsRed() == null) {
			news.setNewsRed(0);
		}
		if (news.getIsJump() == null) {
			news.setIsJump(0);
			news.setJumpUrl("");
		}

		if (news.getNewsId() == null) {
			// ���
			total = newsService.addNews(news);
		} else {
			// �޸�
			total = newsService.updateNews(news);
		}
		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ɾ��
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsQualityDelete.do")
	public String doNewsQualityDelete(@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			newsService.deleteNews(Integer.parseInt(idsStr[i]));
		}

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ��ѯ
	 * 
	 * @param newsId
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findNewsQualityById.do")
	public String findNewsQualityById(@RequestParam(value = "newsId", required = true) String newsId,
			HttpSession session, HttpServletResponse response) throws Exception {

		User user = (User) session.getAttribute("USER");
		News news = null;
		Map<String, Object> map = null;

		if (user.getRoleId() == 1 || user.getRoleId() == 2) {
			news = newsService.findNewsById(Integer.parseInt(newsId));
		} else {
			map = new HashMap<>();
			map.put("newsId", newsId);
			map.put("userId", user.getUserId());
			news = newsService.findNewsByCondition(map);
		}

		JSONObject jsonObject = JSONObject.fromObject(news);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

	/**
	 * ���
	 * 
	 * @param newsId
	 * @param statusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsQualityAudit.do")
	public String doNewsQualityAudit(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "statusId", required = true) String statusId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setStatusId(Integer.parseInt(statusId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * �ö�
	 * 
	 * @param newsId
	 * @param topId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsQualityTop.do")
	public String doNewsQualityTop(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "topId", required = true) String topId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setTopId(Integer.parseInt(topId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	// �ĵ����ؿ�ʼ

	/**
	 * �б�
	 * 
	 * @param page
	 * @param rows
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsDownloadList.do")
	public String newsDownloadList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "newsTitle", required = false) String newsTitle, HttpSession session,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());

		if (newsTitle != null && newsTitle.trim() != "") {
			map.put("newsTitle", newsTitle);
		}

		User user = (User) session.getAttribute("USER");
		if (user.getRoleId() == 1) {

		} else if (user.getRoleId() == 2) {

			List<Department> departmentList = user.getDepartmentList();
			if (departmentList != null && departmentList.size() > 0) {
				map.put("departmentList", departmentList);
			} else {
				map.put("userId", "0");
			}

		} else {
			map.put("userId", user.getUserId());
		}

		map.put("typePid", 7);

		int total = newsService.findNewsCount(map);
		List<News> newsList = newsService.findNewsList(map);
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(newsList, jsonConfig);
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ����
	 * 
	 * @param news
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsDownloadSave.do")
	public String doNewsDownloadSave(News news, HttpSession session, HttpServletResponse response) throws Exception {
		int total = 0;

		// ���⸳ֵ
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			news.setUserId(user.getUserId());
			news.setUserNick(user.getUserNick());
			news.setDepartmentId(user.getDepartmentId());
		}
		// �ĵ�����
		news.setTypePid(7);
		news.setAddTime(new Date());
		news.setAddDate(new Date().getTime());
		news.setStatusId(0);
		if (news.getNewsRed() == null) {
			news.setNewsRed(0);
		}
		if (news.getIsJump() == null) {
			news.setIsJump(0);
			news.setJumpUrl("");
		}

		if (news.getNewsId() == null) {
			// ���
			total = newsService.addNews(news);
		} else {
			// �޸�
			total = newsService.updateNews(news);
		}
		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ɾ��
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsDownloadDelete.do")
	public String doNewsDownloadDelete(@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			newsService.deleteNews(Integer.parseInt(idsStr[i]));
		}

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ��ѯ
	 * 
	 * @param newsId
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findNewsDownloadById.do")
	public String findNewsDownloadById(@RequestParam(value = "newsId", required = true) String newsId,
			HttpSession session, HttpServletResponse response) throws Exception {

		User user = (User) session.getAttribute("USER");
		News news = null;
		Map<String, Object> map = null;

		if (user.getRoleId() == 1 || user.getRoleId() == 2) {
			news = newsService.findNewsById(Integer.parseInt(newsId));
		} else {
			map = new HashMap<>();
			map.put("newsId", newsId);
			map.put("userId", user.getUserId());
			news = newsService.findNewsByCondition(map);
		}

		JSONObject jsonObject = JSONObject.fromObject(news);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

	/**
	 * ���
	 * 
	 * @param newsId
	 * @param statusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsDownloadAudit.do")
	public String doNewsDownloadAudit(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "statusId", required = true) String statusId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setStatusId(Integer.parseInt(statusId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * �ö�
	 * 
	 * @param newsId
	 * @param topId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsDownloadTop.do")
	public String doNewsDownloadTop(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "topId", required = true) String topId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setTopId(Integer.parseInt(topId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	// ѧ������ʼ

	/**
	 * �б�
	 * 
	 * @param page
	 * @param rows
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsStudentList.do")
	public String newsStudentList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "newsTitle", required = false) String newsTitle, HttpSession session,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());

		if (newsTitle != null && newsTitle.trim() != "") {
			map.put("newsTitle", newsTitle);
		}

		User user = (User) session.getAttribute("USER");
		if (user.getRoleId() == 1) {

		} else if (user.getRoleId() == 2) {

			List<Department> departmentList = user.getDepartmentList();
			if (departmentList != null && departmentList.size() > 0) {
				map.put("departmentList", departmentList);
			} else {
				map.put("userId", "0");
			}

		} else {
			map.put("userId", user.getUserId());
		}

		map.put("typeId", 8);

		int total = newsService.findNewsCount(map);
		List<News> newsList = newsService.findNewsList(map);
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(newsList, jsonConfig);
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ����
	 * 
	 * @param news
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsStudentSave.do")
	public String doNewsStudentSave(News news, HttpSession session, HttpServletResponse response) throws Exception {
		int total = 0;

		// ���⸳ֵ
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			news.setUserId(user.getUserId());
			news.setUserNick(user.getUserNick());
			news.setDepartmentId(user.getDepartmentId());
		}
		news.setTypePid(0);
		news.setTypeId(8);
		news.setAddTime(new Date());
		news.setAddDate(new Date().getTime());
		news.setStatusId(0);
		if (news.getNewsRed() == null) {
			news.setNewsRed(0);
		}
		if (news.getIsJump() == null) {
			news.setIsJump(0);
			news.setJumpUrl("");
		}

		if (news.getNewsId() == null) {
			// ���
			total = newsService.addNews(news);
		} else {
			// �޸�
			total = newsService.updateNews(news);
		}
		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ɾ��
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsStudentDelete.do")
	public String doNewsStudentDelete(@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			newsService.deleteNews(Integer.parseInt(idsStr[i]));
		}

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ��ѯ
	 * 
	 * @param newsId
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findNewsStudentById.do")
	public String findNewsStudentById(@RequestParam(value = "newsId", required = true) String newsId,
			HttpSession session, HttpServletResponse response) throws Exception {

		User user = (User) session.getAttribute("USER");
		News news = null;
		Map<String, Object> map = null;

		if (user.getRoleId() == 1 || user.getRoleId() == 2) {
			news = newsService.findNewsById(Integer.parseInt(newsId));
		} else {
			map = new HashMap<>();
			map.put("newsId", newsId);
			map.put("userId", user.getUserId());
			news = newsService.findNewsByCondition(map);
		}

		JSONObject jsonObject = JSONObject.fromObject(news);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

	/**
	 * ���
	 * 
	 * @param newsId
	 * @param statusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsStudentAudit.do")
	public String doNewsStudentAudit(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "statusId", required = true) String statusId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setStatusId(Integer.parseInt(statusId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * �ö�
	 * 
	 * @param newsId
	 * @param topId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsStudentTop.do")
	public String doNewsStudentTop(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "topId", required = true) String topId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setTopId(Integer.parseInt(topId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	// ��ʦ����ʼ

	/**
	 * �б�
	 * 
	 * @param page
	 * @param rows
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsTeacherList.do")
	public String newsTeacherList(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "newsTitle", required = false) String newsTitle, HttpSession session,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());

		if (newsTitle != null && newsTitle.trim() != "") {
			map.put("newsTitle", newsTitle);
		}

		User user = (User) session.getAttribute("USER");
		if (user.getRoleId() == 1) {

		} else if (user.getRoleId() == 2) {

			List<Department> departmentList = user.getDepartmentList();
			if (departmentList != null && departmentList.size() > 0) {
				map.put("departmentList", departmentList);
			} else {
				map.put("userId", "0");
			}

		} else {
			map.put("userId", user.getUserId());
		}

		map.put("typeId", 9);

		int total = newsService.findNewsCount(map);
		List<News> newsList = newsService.findNewsList(map);
		JSONObject object = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(newsList, jsonConfig);
		object.put("rows", jsonArray);
		object.put("total", total);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ����
	 * 
	 * @param news
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsTeacherSave.do")
	public String doNewsTeacherSave(News news, HttpSession session, HttpServletResponse response) throws Exception {
		int total = 0;

		// ���⸳ֵ
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			news.setUserId(user.getUserId());
			news.setUserNick(user.getUserNick());
			news.setDepartmentId(user.getDepartmentId());
		}
		news.setTypePid(0);
		news.setTypeId(9);
		news.setAddTime(new Date());
		news.setAddDate(new Date().getTime());
		news.setStatusId(0);
		if (news.getNewsRed() == null) {
			news.setNewsRed(0);
		}
		if (news.getIsJump() == null) {
			news.setIsJump(0);
			news.setJumpUrl("");
		}

		if (news.getNewsId() == null) {
			// ���
			total = newsService.addNews(news);
		} else {
			// �޸�
			total = newsService.updateNews(news);
		}
		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ɾ��
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsTeacherDelete.do")
	public String doNewsTeacherDelete(@RequestParam(value = "ids", required = false) String ids,
			HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(",");
		JSONObject object = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			newsService.deleteNews(Integer.parseInt(idsStr[i]));
		}

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ��ѯ
	 * 
	 * @param newsId
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findNewsTeacherById.do")
	public String findNewsTeacherById(@RequestParam(value = "newsId", required = true) String newsId,
			HttpSession session, HttpServletResponse response) throws Exception {

		User user = (User) session.getAttribute("USER");
		News news = null;
		Map<String, Object> map = null;

		if (user.getRoleId() == 1 || user.getRoleId() == 2) {
			news = newsService.findNewsById(Integer.parseInt(newsId));
		} else {
			map = new HashMap<>();
			map.put("newsId", newsId);
			map.put("userId", user.getUserId());
			news = newsService.findNewsByCondition(map);
		}

		JSONObject jsonObject = JSONObject.fromObject(news);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

	/**
	 * ���
	 * 
	 * @param newsId
	 * @param statusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsTeacherAudit.do")
	public String doNewsTeacherAudit(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "statusId", required = true) String statusId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setStatusId(Integer.parseInt(statusId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);

		// ˢ������
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * �ö�
	 * 
	 * @param newsId
	 * @param topId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doNewsTeacherTop.do")
	public String doNewsTeacherTop(@RequestParam(value = "newsId", required = true) String newsId,
			@RequestParam(value = "topId", required = true) String topId, HttpServletResponse response)
			throws Exception {

		News news = new News();
		news.setNewsId(Integer.parseInt(newsId));
		news.setTopId(Integer.parseInt(topId));

		JSONObject object = new JSONObject();
		newsService.updateNews(news);
		object.put("success", true);
		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * ���
	 * 
	 * @param newsId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/newsBrowse.do")
	public String newsBrowse(@RequestParam(value = "newsId", required = true) String newsId,
			HttpServletRequest request) {
		News news = newsService.findNewsById(Integer.parseInt(newsId));
		request.setAttribute("news", news);
		return "forward:/news.jsp";
	}

}
