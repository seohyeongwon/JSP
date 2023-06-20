package test.web;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class BoardFrontController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		doProcess(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("FrontContriller 호출");
		//목록보기
		ListCommand command = new ListCommand();
		command.execute(request,response);
		
		RequestDispatcher dis = request.getRequestDispatcher("/list.jsp");
		try {
			dis.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
