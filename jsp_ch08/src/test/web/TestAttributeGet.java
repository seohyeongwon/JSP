package test.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class TestAttributeGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글
		response.setContentType("text/html; charset=UTF-8");

		response.getWriter().append("Served at: ").append(request.getContextPath());

		// setAttribute()로 바인딩 한 데이터를 getAttribute()로 가져오기

		ServletContext application = getServletContext();
		HttpSession session = request.getSession();

		String ctxMsg = (String) application.getAttribute("context");
		String sesMsg = (String) session.getAttribute("session");
		String reqMsg = (String) request.getAttribute("request");

		response.getWriter()
		.append("ctxMsg: " + ctxMsg)
		.append(", sesMsg: " + sesMsg)
		.append(", reqMsg: " + reqMsg);

	}

}