package org.comstudy21.travel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.travel.dbcp.JdbcUtil;

public class ReservationDAO {
	final String SQL_INSERT = "insert into reservation(rno, rjumin, rname, rphone1, rphone2, rphone3, remail, rstat, tcode) values(?,?,?,?,?,?,?,?,?)";
	final String SQL_SELECT_ALL = "SELECT * FROM reservation";
	final String SQL_SELECT_rno = "SELECT * FROM reservation WHERE rno=?";
	final String SQL_SELECT_NAME = "SELECT * FROM reservation WHERE NAME=?";
	final String SQL_UPDATE = "UPDATE reservation SET rjumin=?, rname=?, rphone1=?, rphone2=?, rphone3=?, remail=?, rstat=?, tcode=? WHERE rno=?";
	final String SQL_DELETE = "DELETE FROM reservation WHERE rno=?";

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	TravelDAO travelDao = new TravelDAO();

	public void insert(ReservationVO vo) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_INSERT);
			//rno, rjumin, rname, rphone1, rphone2, rphone3, remail, rstat, tcode
			stmt.setString(1, vo.getRno());
			stmt.setString(2, vo.getRjumin());
			stmt.setString(3, vo.getRname());
			stmt.setString(4, vo.getRphone1());
			stmt.setString(5, vo.getRphone2());
			stmt.setString(6, vo.getRphone3());
			stmt.setString(7, vo.getRemail());
			stmt.setString(8, vo.getRstat());
			stmt.setString(9, vo.getTcode());
			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}

	public List<ReservationVO> selectAll() {
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				//rno, rjumin, rname, rphone1, rphone2, rphone3, remail, rstat, tcode
				String rno = rs.getNString("rno");
				String rjumin = rs.getNString("rjumin");
				String rname = rs.getNString("rname");
				String rphone1 = rs.getNString("rphone1");
				String rphone2 = rs.getNString("rphone2");
				String rphone3 = rs.getNString("rphone3");
				String remail = rs.getNString("remail");
				String rstat = rs.getNString("rstat");
				String tcode = rs.getNString("tcode");
				TravelVO travelVO = travelDao.selectBytcode(tcode);
				list.add(new ReservationVO(rno, rjumin, rname, rphone1, rphone2, rphone3, remail, rstat, tcode, travelVO));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return list;
	}

	public void update(ReservationVO vo) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_UPDATE);
			//rno, rjumin, rname, rphone1, rphone2, rphone3, remail, rstat, tcode
			stmt.setString(1, vo.getRjumin());
			stmt.setString(2, vo.getRname());
			stmt.setString(3, vo.getRphone1());
			stmt.setString(4, vo.getRphone2());
			stmt.setString(5, vo.getRphone3());
			stmt.setString(6, vo.getRemail());
			stmt.setString(7, vo.getRstat());
			stmt.setString(8, vo.getTcode());
			stmt.setString(9, vo.getRno());
			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}

	public void delete(ReservationVO vo) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setString(1, vo.getRno());
			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}

	public ReservationVO selectByName(ReservationVO vo) {

		return null;
	}

	public ReservationVO selectByrno(ReservationVO vo) {
		ReservationVO reservation = null;

		return reservation;
	}

	public ReservationVO selectByrno(String rno) {
		ReservationVO reservation = null;
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_rno);
			stmt.setString(1, rno);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String rjumin = rs.getNString("rjumin");
				String rname = rs.getNString("rname");
				String rphone1 = rs.getNString("rphone1");
				String rphone2 = rs.getNString("rphone2");
				String rphone3 = rs.getNString("rphone3");
				String remail = rs.getNString("remail");
				String rstat = rs.getNString("rstat");
				String tcode = rs.getNString("tcode");
				TravelVO travelVO = travelDao.selectBytcode(tcode);
				reservation = new ReservationVO(rno, rjumin, rname, rphone1, rphone2, rphone3, remail, rstat, tcode, travelVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}

		return reservation;
	}
}
