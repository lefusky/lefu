package com.syonenet.entity;

import java.util.Date;

public class NewsIndexPicture {
	private Integer id;
	private String name;
	private String picture_url1;
	private String picture_name1;
	private Date add_time;
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
	public String getPicture_url1() {
		return picture_url1;
	}
	public void setPicture_url1(String picture_url1) {
		this.picture_url1 = picture_url1;
	}
	public String getPicture_name1() {
		return picture_name1;
	}
	public void setPicture_name1(String picture_name1) {
		this.picture_name1 = picture_name1;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	
}
