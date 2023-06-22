package org.comstudy.myweb.board;

import org.comstudy.myweb.Command;

public interface BoardCommand extends Command {
	BoardDAO boardDAO = new BoardDAO();
}
