package test.web;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.*;

public class BoardDAO {

	private DataSource dataFactoy;
	Connection con;
	Statement stmt;
	ResultSet rs;

	public BoardDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			dataFactoy = (DataSource) ctx.lookup("java:comp/env/jdbc/EmployeeDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end BoardDAO

	public ArrayList list() {

		ArrayList list = new ArrayList<BoardDAO>();

		try {
			con = dataFactoy.getConnection();
			stmt = con.createStatement();
			String query = "SELECT*FROM board";

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String num = Integer.toString(rs.getInt("num"));
				String title = rs.getString("title");
				String author = rs.getString("author");
				String email = rs.getString("email");
				int writeday = rs.getInt("writeday");

				BoardTO data = new BoardTO();
				data.setNum(num);
				data.setTitle(title);
				data.setAuthor(author);
				data.setEmail(email);
				data.setWriteday(writeday);
				list.add(data);
			} // end while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

}
