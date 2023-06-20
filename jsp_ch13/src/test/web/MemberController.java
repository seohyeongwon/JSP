package test.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static List<MemberBean> list = new ArrayList<MemberBean>();
	static {
		list.add(new MemberBean("HONG", "23", "85", "180", "M"));
		list.add(new MemberBean("KIM", "20", "65", "160", "F"));
		list.add(new MemberBean("LEE", "27", "75", "170", "F"));
		list.add(new MemberBean("PARK", "25", "80", "185", "M"));
		list.add(new MemberBean("KANG", "24", "95", "180", "M"));
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setAttribute("list", list);

		String path = "/WEB-INF/views/member/list.jsp";
		RequestDispatcher view = request.getRequestDispatcher(path);
		view.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}