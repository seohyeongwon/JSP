package org.comstudy.myweb.gallery.service;

import javax.servlet.http.HttpServletRequest;

import org.comstudy.myweb.Command;
import org.comstudy.myweb.board.BoardCommand;
import org.comstudy.myweb.board.BoardDTO;

public class WriteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest req) {
		if("GET".equals(req.getMethod())) {
			req.setAttribute("viewName", "gallery/write");
		} else if("POST".equals(req.getMethod())) {
			String author = req.getParameter("author");
			String email = req.getParameter("email");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String password = req.getParameter("password");
			
			BoardDTO board = new BoardDTO(author, email, title, content, password);
			boardDAO.insert(board);
			req.setAttribute("viewName", "redirect:list.do");
		}
	}

}
