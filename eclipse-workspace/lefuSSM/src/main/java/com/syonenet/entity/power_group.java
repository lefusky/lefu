package com.syonenet.entity;

public class power_group {
    private Integer groupId;

    private String groupName;

    private String groupPid;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupPid() {
        return groupPid;
    }

    public void setGroupPid(String groupPid) {
        this.groupPid = groupPid == null ? null : groupPid.trim();
    }
}