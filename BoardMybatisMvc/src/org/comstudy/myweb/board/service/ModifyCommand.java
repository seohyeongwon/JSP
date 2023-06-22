package org.comstudy.myweb.board.service;

import javax.servlet.http.HttpServletRequest;

import org.comstudy.myweb.board.BoardCommand;
import org.comstudy.myweb.board.BoardDTO;

public class ModifyCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest req) {
		if("GET".equals(req.getMethod())) {
			int num = Integer.parseInt(req.getParameter("num"));
			BoardDTO board = boardDAO.selectOne(new BoardDTO(num));
			req.setAttribute("board", board);
			req.setAttribute("viewName", "board/modify");
		} else if("POST".equals(req.getMethod())) {
			int num = Integer.parseInt(req.getParameter("num"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BoardDTO board = new BoardDTO(num, title, content); 
			boardDAO.update(board);
			req.setAttribute("viewName", "redirect:list.do");
		}
		
	}

	

	
}
