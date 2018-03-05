package com.syonenet.entity;

import java.util.List;

public class TreeNode {

	private Integer id; // 节点ID
	private String text; // 节点文本
	private Integer pid; // 父ID
	private Integer isEnd; // 是否是最终节点
	private String url; // 访问地址
	private String desc; // 描述
	private Integer isNavigation; // 是否主导航分类
	private Integer isNext; // 是否有下级分类
	private List<TreeNode> children;

	public TreeNode() {

	}

	public TreeNode(Integer id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public TreeNode(Integer id, String text, Integer pid) {
		this.id = id;
		this.text = text;
		this.pid = pid;
	}

	public TreeNode(Integer id, String text, Integer pid, String url) {
		this.id = id;
		this.text = text;
		this.pid = pid;
		this.url = url;
	}
	
	public TreeNode(Integer id, String text, Integer pid, Integer isEnd) {
		this.id = id;
		this.text = text;
		this.pid = pid;
		this.isEnd = isEnd;
	}

	public TreeNode(Integer id, String text, Integer pid, Integer isEnd, String url, String desc) {
		super();
		this.id = id;
		this.text = text;
		this.pid = pid;
		this.isEnd = isEnd;
		this.url = url;
		this.desc = desc;
	}

	public TreeNode(Integer id, String text, Integer pid, String url, Integer isNavigation, Integer isNext) {
		super();
		this.id = id;
		this.text = text;
		this.pid = pid;
		this.url = url;
		this.isNavigation = isNavigation;
		this.isNext = isNext;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getIsEnd() {
		return isEnd;
	}

	public void setIsEnd(Integer isEnd) {
		this.isEnd = isEnd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getIsNavigation() {
		return isNavigation;
	}

	public void setIsNavigation(Integer isNavigation) {
		this.isNavigation = isNavigation;
	}

	public Integer getIsNext() {
		return isNext;
	}

	public void setIsNext(Integer isNext) {
		this.isNext = isNext;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

}
