package com.syonenet.entity;

public class power_function {
    private Integer functionId;

    private String functionName;

    private String functionCode;

    private String functionUrl;

    private Integer functionPid;

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl == null ? null : functionUrl.trim();
    }

    public Integer getFunctionPid() {
        return functionPid;
    }

    public void setFunctionPid(Integer functionPid) {
        this.functionPid = functionPid;
    }
}