package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter out = resp.getWriter();

		out.append("Served at: ").append(req.getContextPath());
		out.print("<p>Redriect 된다!!!</p>");

		// 주소가 같은 forward일때는 request 바인된다
		req.setAttribute("name", "qweasd");
	
		// 주소가 달라 질때는 request가 아닌 session에 바인딩 해야 한다
		HttpSession session = req.getSession();
		session.setAttribute("name_session", "qweasd2");

		// session(브라우저)가 달라져도 데이터가 남있다.
		ServletContext application = req.getServletContext();
		application.setAttribute("name_app", "qweasd3");

		//resp.sendRedirect("toHello");

		// forward
		RequestDispatcher view = req.getRequestDispatcher("toHello");
		view.forward(req, resp);

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
