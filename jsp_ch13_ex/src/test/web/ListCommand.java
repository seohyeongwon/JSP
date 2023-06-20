package test.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ListCommand 호출");
		
		BoardDAO dao = new BoardDAO();
		ArrayList list = dao.list();
		System.out.println("list.size()"+list.size());
		
		request.setAttribute("list", list);
		
	}

}
