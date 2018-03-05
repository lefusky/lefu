package com.syonenet.entity;

public class Permission {

	private Integer permissionId;
	private Integer permissionPid;
	private String permissionName;
	private Integer permissionEnd;
	private String permissionUrl;
	private String permissionDesc;

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Integer getPermissionPid() {
		return permissionPid;
	}

	public void setPermissionPid(Integer permissionPid) {
		this.permissionPid = permissionPid;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Integer getPermissionEnd() {
		return permissionEnd;
	}

	public void setPermissionEnd(Integer permissionEnd) {
		this.permissionEnd = permissionEnd;
	}

	public String getPermissionUrl() {
		return permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	public String getPermissionDesc() {
		return permissionDesc;
	}

	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}

}
