package com.syonenet.util;

import javax.servlet.http.HttpServletResponse;

/**
 * �ַ���������
 * 
 * @author Administrator
 * 
 */
public class StringUtil {

	/**
	 * ����Ի���
	 * 
	 * @param content
	 * @param url
	 * @param response
	 * @throws Exception
	 */
	public static void outPutAlert(String content, String url, HttpServletResponse response) throws Exception {
		String message = null;
		if (url == null || url == "") {
			message = "<script type='text/javascript'>alert('" + content + "');</script>";
			
		} else {
			message = "<script type='text/javascript'>alert('" + content + "');window.location.href='" + url
					+ "';</script>";
		}
		ResponseUtil.write(response, message);
	}

}
