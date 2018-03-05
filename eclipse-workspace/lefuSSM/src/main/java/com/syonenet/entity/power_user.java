package com.syonenet.entity;

import java.util.Date;

public class power_user {
    private Integer userId;

    private String userName;
    
    private Date userTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

	public Date getUserTime() {
		return userTime;
	}

	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}
}