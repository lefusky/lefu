package com.syonenet.entity;

import java.util.Date;

public class Monitoring {
	private Integer id;
	private String type;
	private String specification;
	private Double price;
	private String night_sight;
	private String focal_length;
	private String standard_power;
	private String catena;
	private Integer one_level_id;
	private String one_level_name;
	private Integer two_level_id;
	private String two_level_name;
	private String picture_url1;
	private String picture_name1;
	private String state;
	private Date add_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getNight_sight() {
		return night_sight;
	}
	public void setNight_sight(String night_sight) {
		this.night_sight = night_sight;
	}
	public String getFocal_length() {
		return focal_length;
	}
	public void setFocal_length(String focal_length) {
		this.focal_length = focal_length;
	}
	public String getStandard_power() {
		return standard_power;
	}
	public void setStandard_power(String standard_power) {
		this.standard_power = standard_power;
	}
	public String getCatena() {
		return catena;
	}
	public void setCatena(String catena) {
		this.catena = catena;
	}
	public Integer getOne_level_id() {
		return one_level_id;
	}
	public void setOne_level_id(Integer one_level_id) {
		this.one_level_id = one_level_id;
	}
	public String getOne_level_name() {
		return one_level_name;
	}
	public void setOne_level_name(String one_level_name) {
		this.one_level_name = one_level_name;
	}
	public Integer getTwo_level_id() {
		return two_level_id;
	}
	public void setTwo_level_id(Integer two_level_id) {
		this.two_level_id = two_level_id;
	}
	public String getTwo_level_name() {
		return two_level_name;
	}
	public void setTwo_level_name(String two_level_name) {
		this.two_level_name = two_level_name;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
}
