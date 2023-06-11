package org.comstudy.dbcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	// JNDI 활용 - 톰캣 실행 환경에서만 사용 가능
	// JNDI는 톰캣에서 제공 되기 때문에 main() 어플리케이션에서 사용 불가능.
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/MemberDB");

			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}

	public static void close(Connection obj) throws SQLException {
		if (obj != null) {
			obj.close();
		}
	}

	public static void close(Statement obj) throws SQLException {
		if (obj != null) {
			obj.close();
		}
	}

	public static void close(ResultSet obj) throws SQLException {
		if (obj != null) {
			obj.close();
		}
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			close(conn);
			close(stmt);
			close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}