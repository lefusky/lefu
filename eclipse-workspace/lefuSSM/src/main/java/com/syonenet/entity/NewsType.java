package com.syonenet.entity;

public class NewsType {

	private Integer typeId;
	private String typeName;
	private Integer typePid;
	private String level;
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	private String typeUrl;
	private Integer isNavigation;
	private Integer isNext;

	public NewsType() {
		super();
	}

	public NewsType(Integer typeId) {
		super();
		this.typeId = typeId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getTypePid() {
		return typePid;
	}

	public void setTypePid(Integer typePid) {
		this.typePid = typePid;
	}

	public String getTypeUrl() {
		return typeUrl;
	}

	public void setTypeUrl(String typeUrl) {
		this.typeUrl = typeUrl;
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

}
