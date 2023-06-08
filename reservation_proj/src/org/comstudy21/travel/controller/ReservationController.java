package org.comstudy21.travel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.comstudy21.travel.model.ReservationDAO;
import org.comstudy21.travel.model.ReservationVO;
import org.comstudy21.travel.model.TravelDAO;
import org.comstudy21.travel.model.TravelVO;

@WebServlet("/reservation/*")
public class ReservationController extends HttpServlet {
	ReservationDAO reservationDao = new ReservationDAO();
	TravelDAO travelDao = new TravelDAO();
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String method = req.getMethod();
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		int beginIndex = ctxPath.length();
		int endIndex = reqUri.indexOf(".");
		String path = reqUri.substring(beginIndex);
		if(endIndex != -1) {
			path = reqUri.substring(beginIndex, endIndex);
		}
		
		//System.out.println(">>> path : " + path);
		String viewName = "/WEB-INF/views/reservation/list.jsp";
		if("/reservation/input".equals(path)) {
			if("GET".equals(method)) {
				viewName = "/WEB-INF/views/reservation/input.jsp";
				List<TravelVO> travelList = travelDao.selectAll();
				req.setAttribute("travelList", travelList);
			} else if("POST".equals(method)) {
				String rno = req.getParameter("rno");
				String tcode = req.getParameter("tcode");
				String rjumin1 = req.getParameter("rjumin1");
				String rjumin2 = req.getParameter("rjumin2");
				String rjumin = rjumin1 + rjumin2;
				String rname = req.getParameter("rname");
				String rphone1 = req.getParameter("rphone1");
				String rphone2 = req.getParameter("rphone2");
				String rphone3 = req.getParameter("rphone3");
				String remail = req.getParameter("remail");
				String rstat = req.getParameter("rstat");
				System.out.println();
				ReservationVO reservationVO = new ReservationVO(rno, rjumin, rname, rphone1, rphone2, rphone3, remail, rstat, tcode, null);
				System.out.println(reservationVO);
				reservationDao.insert(reservationVO);
				resp.sendRedirect(req.getContextPath() + "/reservation/list");
				return;
			}
		} else if("/reservation/delete".equals(path)) {
			reservationDao.delete(new ReservationVO(req.getParameter("rno")));
			resp.sendRedirect(req.getContextPath() + "/reservation/list");
			return;
		} else {
			List<ReservationVO> reservationList = reservationDao.selectAll();
			req.setAttribute("reservationList", reservationList);
		}
		
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
