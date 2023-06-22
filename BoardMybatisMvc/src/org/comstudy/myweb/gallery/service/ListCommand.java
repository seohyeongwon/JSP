package org.comstudy.myweb.gallery.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comstudy.myweb.board.BoardCommand;
import org.comstudy.myweb.board.BoardDTO;

public class ListCommand implements BoardCommand {
	@Override
	public void execute(HttpServletRequest req) {
		List<BoardDTO> list = boardDAO.selectAll();
		req.setAttribute("list", list);
		req.setAttribute("viewName", "gallery/list");
	}

}
