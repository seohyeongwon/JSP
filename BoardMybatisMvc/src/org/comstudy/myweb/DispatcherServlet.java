package org.comstudy.myweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myweb.board.BoardController;

public class DispatcherServlet extends HttpServlet {
	ViewResolver viewResolver;
	public DispatcherServlet() {
		viewResolver = new ViewResolver();
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// path 분리하는 구문
		
		// Controller에서 처리
		BoardController ctrl = new BoardController();
		ctrl.doProcess(req);
		
		viewResolver.setPrefix(getInitParameter("prefix"));
		viewResolver.setSuffix(getInitParameter("suffix"));
		viewResolver.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
