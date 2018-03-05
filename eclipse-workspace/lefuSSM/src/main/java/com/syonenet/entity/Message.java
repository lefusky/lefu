package com.syonenet.entity;

import java.util.Date;

public class Message {
	private Integer messageId;
	private String messageQuestion;
	private String messageAnswer;
	private Integer messageCount;
	private Date addTime;
	private Integer userId;
	private String userNick;
	private Integer departmentId;
	private Integer statusId;
	private Integer topId;
	private String departmentIds;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessageQuestion() {
		return messageQuestion;
	}

	public void setMessageQuestion(String messageQuestion) {
		this.messageQuestion = messageQuestion;
	}

	public String getMessageAnswer() {
		return messageAnswer;
	}

	public void setMessageAnswer(String messageAnswer) {
		this.messageAnswer = messageAnswer;
	}

	public Integer getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getTopId() {
		return topId;
	}

	public void setTopId(Integer topId) {
		this.topId = topId;
	}

	public String getDepartmentIds() {
		return departmentIds;
	}

	public void setDepartmentIds(String departmentIds) {
		this.departmentIds = departmentIds;
	}

}
