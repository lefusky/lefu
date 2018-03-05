package com.syonenet.entity;

public class demo {
    private Integer id;

    private String name;

    private Integer pid;

    private String demo_url;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return demo_url;
    }

    public void setUrl(String demo_url) {
        this.demo_url = demo_url == null ? null : demo_url.trim();
    }

	@Override
	public String toString() {
		return "demo [id=" + id + ", name=" + name + ", pid=" + pid + ", demo_url=" + demo_url + "]";
	}
}