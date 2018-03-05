package com.syonenet.entity;

/**
 * 分页工具类
 * 
 * @author yzls
 * 
 */
public class PageBean {

	private int page; // 第几页
	private int pageSize; // 每页记录数
	@SuppressWarnings("unused")
	private int start; // 起始页

	public PageBean(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {
		return (page - 1) * pageSize;
	}

	// 获取总页数
	public static int maxPage(int count, int num) {
		if (count != 0) {
			return (count - 1 + num) / num;
		}
		return 1;
	}
}
