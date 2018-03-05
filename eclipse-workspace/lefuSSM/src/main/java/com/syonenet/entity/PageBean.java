package com.syonenet.entity;

/**
 * ��ҳ������
 * 
 * @author yzls
 * 
 */
public class PageBean {

	private int page; // �ڼ�ҳ
	private int pageSize; // ÿҳ��¼��
	@SuppressWarnings("unused")
	private int start; // ��ʼҳ

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

	// ��ȡ��ҳ��
	public static int maxPage(int count, int num) {
		if (count != 0) {
			return (count - 1 + num) / num;
		}
		return 1;
	}
}
