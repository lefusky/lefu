package com.syonenet.entity;

public class power_right {
    private Integer rightId;

    private String rightType;

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public String getRightType() {
        return rightType;
    }

    public void setRightType(String rightType) {
        this.rightType = rightType == null ? null : rightType.trim();
    }
}