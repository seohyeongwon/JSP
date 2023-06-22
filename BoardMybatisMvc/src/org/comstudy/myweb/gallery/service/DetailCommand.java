package org.comstudy.myweb.gallery.service;

import javax.servlet.http.HttpServletRequest;

import org.comstudy.myweb.Command;
import org.comstudy.myweb.board.BoardCommand;
import org.comstudy.myweb.board.BoardDTO;

public class DetailCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest req) {
		int num = Integer.parseInt(req.getParameter("num"));
		BoardDTO board = boardDAO.selectOne(new BoardDTO(num));
		req.setAttribute("board", board);
		req.setAttribute("viewName", "gallery/detail");
	}

}
