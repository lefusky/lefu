package com.syonenet.system.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syonenet.entity.TreeNode;
import com.syonenet.entity.demo;
import com.syonenet.util.ResponseUtil;
import com.syonenet.util.TreeBuilder;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/system")
public class DemoController {
	@RequestMapping(value = "/demoList.do")
	public String typeList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ServletContext application = request.getServletContext();
		
	@SuppressWarnings("unchecked")
	List<demo> demoList = (List<demo>) application.getAttribute("demoList");
	List<TreeNode> treeNodes = new ArrayList<>();

	for (demo demo : demoList) {
		TreeNode treeNode = new TreeNode(demo.getId(), demo.getName(), demo.getPid(), demo.getUrl());
		treeNodes.add(treeNode);
	}

	JSONArray array = JSONArray.fromObject(TreeBuilder.bulid(treeNodes));
	ResponseUtil.write(response, array);
	return null;
	}
}
