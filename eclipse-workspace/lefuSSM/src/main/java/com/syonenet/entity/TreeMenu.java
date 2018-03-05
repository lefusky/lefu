package com.syonenet.entity;

import java.util.List;

public class TreeMenu {

	private Integer id;
	private String name;
	private String url;
	private Integer pid;
	private List<TreeMenu> submenu;

	public TreeMenu(Integer id, String name, String url, Integer pid) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.pid = pid;
	}
	
	public TreeMenu(Integer id, String name, Integer pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<TreeMenu> getSubmenu() {
		return submenu;
	}

	public void setSubmenu(List<TreeMenu> submenu) {
		this.submenu = submenu;
	}

}
