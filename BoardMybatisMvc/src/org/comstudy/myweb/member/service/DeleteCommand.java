package org.comstudy.myweb.member.service;

import javax.servlet.http.HttpServletRequest;

import org.comstudy.myweb.board.BoardCommand;
import org.comstudy.myweb.board.BoardDTO;

public class DeleteCommand implements BoardCommand{
	
	@Override
	public void execute(HttpServletRequest req) {
		int num = Integer.parseInt(req.getParameter("num"));
		boardDAO.delete(new BoardDTO(num));

		req.setAttribute("viewName", "member/delete");
	}
}
