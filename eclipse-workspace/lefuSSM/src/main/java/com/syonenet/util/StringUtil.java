package com.syonenet.util;

import javax.servlet.http.HttpServletResponse;

/**
 * 字符串工具类
 * 
 * @author Administrator
 * 
 */
public class StringUtil {

	/**
	 * 输出对话框
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
