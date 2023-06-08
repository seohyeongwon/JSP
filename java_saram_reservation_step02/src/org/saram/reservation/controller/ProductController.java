package org.saram.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/product/*")
public class ProductController extends HttpServlet {
	protected String ctxPath = "";
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ctxPath = req.getContextPath();
		req.setAttribute("ctxPath", ctxPath);
		
		System.out.println("doProcess() - ProductController");
		MappingUtil.setEncoding(req, resp);		
		String path = MappingUtil.pathMaker(req, resp);
		//String path = (String)req.getAttribute("path");

		System.out.println("path => " + path);
		switch(path ) {
		case "/input" : input(req, resp); break;
		case "/delete" : delete(req, resp); break;
		case "/search" : search(req, resp); break;
		default : list(req, resp);
		}
	}
	
	private void input(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("input() - PeopleController");
		MappingUtil.redirect(req, resp, "/list.saram");
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("delete() - ProductController");
		MappingUtil.redirect(req, resp, "/list.saram");
	}

	private void search(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("search() - ProductController");
		MappingUtil.forward(req, resp);
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("list() - ProductController");
		MappingUtil.forward(req, resp);
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
