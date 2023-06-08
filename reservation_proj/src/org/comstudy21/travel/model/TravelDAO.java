package org.comstudy21.travel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.travel.dbcp.JdbcUtil;

public class TravelDAO {
	final String SQL_INSERT = "insert into travel(tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair) values(?,?,?,?,?,?,?,?)";
	final String SQL_SELECT_ALL = "SELECT * FROM travel";
	final String SQL_SELECT_tcode = "SELECT * FROM travel WHERE tcode=?";
	final String SQL_SELECT_tarea = "SELECT * FROM travel WHERE tarea=?";
	final String SQL_UPDATE = "UPDATE travel SET tarea=?,tdate=?,ttime=?,tday=?,thotel=?,tmoney=?,tair=? WHERE tcode=?";
	final String SQL_DELETE = "DELETE FROM travel WHERE tcode=?";

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;

	public void insert(TravelVO vo) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, vo.getTarea());
			stmt.setString(2, vo.getTarea());
			stmt.setString(3, vo.getTdate());
			stmt.setString(4, vo.getTtime());
			stmt.setInt(5, vo.getTday());
			stmt.setString(6, vo.getThotel());
			stmt.setInt(7, vo.getTmoney());
			stmt.setString(8, vo.getTair());
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

	public List<TravelVO> selectAll() {
		ArrayList<TravelVO> list = new ArrayList<TravelVO>();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String tcode = rs.getNString("tcode");
				String tarea = rs.getNString("tarea");
				String tdate = rs.getNString("tdate");
				String ttime = rs.getNString("ttime");
				int tday = rs.getInt("tday");
				String thotel = rs.getNString("thotel");
				int tmoney = rs.getInt("tmoney");
				String tair = rs.getNString("tair");
				list.add(new TravelVO(tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return list;
	}

	public void update(TravelVO vo) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_UPDATE);
			// tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair
			stmt.setString(1, vo.getTarea());
			stmt.setString(2, vo.getTdate());
			stmt.setString(3, vo.getTtime());
			stmt.setInt(4, vo.getTday());
			stmt.setString(5, vo.getThotel());
			stmt.setInt(6, vo.getTmoney());
			stmt.setString(7, vo.getTair());
			stmt.setString(8, vo.getTcode());
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

	public void delete(TravelVO vo) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setString(1, vo.getTcode());
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

	public TravelVO selectByTarea(TravelVO vo) {
		TravelVO travel = null;
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_tcode);
			stmt.setString(1, vo.getTarea());
			rs = stmt.executeQuery();
			if (rs.next()) {
				// tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair
				String tcode = rs.getNString("tcode");
				String tarea = rs.getNString("tarea");
				String tdate = rs.getNString("tdate");
				String ttime = rs.getNString("ttime");
				int tday = rs.getInt("tday");
				String thotel = rs.getNString("thotel");
				int tmoney = rs.getInt("tmoney");
				String tair = rs.getNString("tair");
				travel = new TravelVO(tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}

		return travel;
	}

	public TravelVO selectByTcode(TravelVO vo) {
		TravelVO travel = null;
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_tcode);
			stmt.setString(1, vo.getTcode());
			rs = stmt.executeQuery();
			if (rs.next()) {
				// tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair
				String tarea = rs.getNString("tarea");
				String tdate = rs.getNString("tdate");
				String ttime = rs.getNString("ttime");
				int tday = rs.getInt("tday");
				String thotel = rs.getNString("thotel");
				int tmoney = rs.getInt("tmoney");
				String tair = rs.getNString("tair");
				travel = new TravelVO(vo.getTcode(),tarea,tdate,ttime,tday,thotel,tmoney,tair);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}

		return travel;
	}

	public TravelVO selectBytcode(String tcode) {
		TravelVO travel = null;
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_tcode);
			stmt.setString(1, tcode);
			rs = stmt.executeQuery();
			if (rs.next()) {
				// tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair
				String tarea = rs.getNString("tarea");
				String tdate = rs.getNString("tdate");
				String ttime = rs.getNString("ttime");
				int tday = rs.getInt("tday");
				String thotel = rs.getNString("thotel");
				int tmoney = rs.getInt("tmoney");
				String tair = rs.getNString("tair");
				travel = new TravelVO(tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}

		return travel;
	}
}
