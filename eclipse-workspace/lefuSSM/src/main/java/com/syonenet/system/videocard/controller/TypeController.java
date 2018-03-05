package com.syonenet.system.videocard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;

import com.syonenet.entity.NewsType;
import com.syonenet.entity.TreeNode;
import com.syonenet.system.init.AdminInitComponent;
import com.syonenet.system.videocard.service.TypeService;
import com.syonenet.util.ResponseUtil;
import com.syonenet.util.TreeBuilder;

@Controller
@RequestMapping(value = "/system")
public class TypeController {

	@Autowired
	private TypeService typeService;
	@Autowired
	private AdminInitComponent initComponent;

	/**
	 * 获取所有分类
	 * 
	 * @param page
	 * @param rows
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/typeList.do")
	public String typeList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ServletContext application = request.getServletContext();

		@SuppressWarnings("unchecked")
		List<NewsType> typeList = (List<NewsType>) application.getAttribute("typeTypes");
		List<TreeNode> treeNodes = new ArrayList<>();

		for (NewsType newsType : typeList) {
			TreeNode treeNode = new TreeNode(newsType.getTypeId(), newsType.getTypeName(), newsType.getTypePid(), newsType.getTypeUrl(), newsType.getIsNavigation(), newsType.getIsNext());
			treeNodes.add(treeNode);
		}

		JSONArray array = JSONArray.fromObject(TreeBuilder.bulid(treeNodes));
		System.out.println(array);
		ResponseUtil.write(response, array);
		return null;
	}

	/**
	 * 添加修改分类
	 * 
	 * @param newsType
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doTypeSave.do")
	public String doTypeSave(NewsType newsType, HttpSession session, HttpServletResponse response) throws Exception {
		int total = 0;

		if (newsType.getTypeId() == null) {
			// 添加
			total = typeService.addNewsType(newsType);
		} else {
			// 修改
			total = typeService.updateNewsType(newsType);
		}

		JSONObject object = new JSONObject();
		if (total > 0) {
			object.put("success", true);
		} else {
			object.put("success", false);
		}

		// 刷新数据
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		ResponseUtil.write(response, object);
		return null;
	}

	/**
	 * 获取该分类下的所有子分类
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findTypeListById.do")
	public String findTypeListById(@RequestParam(value = "typeId", required = false) String typeId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ServletContext application = request.getServletContext();
		
		// 刷新数据
		initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());

		@SuppressWarnings("unchecked")
		List<NewsType> typeList = (List<NewsType>) application.getAttribute("newsTypes");
		List<TreeNode> treeNodes = new ArrayList<>();

		for (NewsType newsType : typeList) {
			TreeNode treeNode = new TreeNode(newsType.getTypeId(), newsType.getTypeName(), newsType.getTypePid());
			treeNodes.add(treeNode);
		}

		JSONArray array = JSONArray.fromObject(TreeBuilder.bulidNew(treeNodes, Integer.parseInt(typeId)));
		ResponseUtil.write(response, array);
		return null;
	}

	/**
	 * 删除分类
	 * 
	 * @param typeId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doTypeDelete.do")
	public String doTypeDelete(@RequestParam(value = "typeId", required = false) String typeId,
			HttpServletResponse response) throws Exception {

		JSONObject object = new JSONObject();

		List<NewsType> newsTypeList = typeService.findNewsTypeListByPid(Integer.parseInt(typeId));

		if (newsTypeList == null || newsTypeList.size() == 0) {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("typeId", Integer.parseInt(typeId));
			
			typeService.deleteNewsType(Integer.parseInt(typeId));
			// ˢ������
			initComponent.initData(ContextLoader.getCurrentWebApplicationContext().getServletContext());
			object.put("success", true);
		
		} else {
			object.put("success", true);
			object.put("exist", "该分类下含有子分类，禁止删除！");
		}

		ResponseUtil.write(response, object);
		return null;
	}

}
