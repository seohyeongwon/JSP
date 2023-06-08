package org.saram.reservation.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MappingUtil {

	public static String pathMaker(HttpServletRequest req, HttpServletResponse resp) {
		// path 만들기
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		int beginIndex = ctxPath.length();
		int endIndex = reqUri.lastIndexOf(".");
		String path = reqUri.substring(beginIndex);
		if(endIndex != -1) {
			path = reqUri.substring(beginIndex, endIndex);
		}
		req.setAttribute("path", path);
		//String path = (String)req.getAttribute("path");
		int endIndex2 = path.lastIndexOf("/");
		String category = "";
		if(endIndex != 0) {
			category = path.substring(0, endIndex2);
		}
		req.setAttribute("category", category);
		path = path.substring(category.length() );
		return path;
	}

	public static void setEncoding(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void forward(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String path = (String)req.getAttribute("path");
			String viewName = "/WEB-INF/views" + path + ".jsp";
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void redirect(HttpServletRequest req, HttpServletResponse resp, String location) {
		String category = (String)req.getAttribute("category");
		String ctxPath = (String)req.getAttribute("ctxPath");
		String viewName =  ctxPath + category+ location;
		try {
			resp.sendRedirect(viewName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
