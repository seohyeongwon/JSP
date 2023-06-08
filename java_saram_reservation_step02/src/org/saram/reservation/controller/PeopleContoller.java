package org.saram.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.saram.reservation.model.PeopleDAO;
import org.saram.reservation.model.PeopleVO;
import org.saram.reservation.model.ProductDAO;
import org.saram.reservation.model.ProductVO;

@WebServlet("/people/*")
public class PeopleContoller extends HttpServlet {
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
		if("POST".equals( req.getMethod()) ) {
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String rpay = req.getParameter("rpay");
			int rno = Integer.parseInt(req.getParameter("rno"));
			PeopleDAO.insert(new PeopleVO(0, name, phone, rpay, rno));
			MappingUtil.redirect(req, resp, "/list.saram");
			return;
		}
		req.setAttribute("productList", ProductDAO.selectAll());
		MappingUtil.forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("delete() - PeopleController");
		MappingUtil.redirect(req, resp, "/list.saram");
	}

	private void search(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("search() - PeopleController");
		MappingUtil.forward(req, resp);
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("list() - PeopleController");
		
		List<PeopleVO> list = PeopleDAO.selectAll();
		req.setAttribute("list", list);
		
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
