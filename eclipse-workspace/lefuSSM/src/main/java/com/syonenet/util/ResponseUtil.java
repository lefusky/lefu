package com.syonenet.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 输出到视图
 * 
 * @author lefu
 * 
 */
public class ResponseUtil {

	public static void write(HttpServletResponse response, Object o)throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
}
