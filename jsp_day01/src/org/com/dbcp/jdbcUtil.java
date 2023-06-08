package org.com.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//web-web-inf-lib 빌드패스
public class jdbcUtil {
	public static Connection getConnection() {
		//ojdbc6.jar 필요	
		String url="jdbc:oracle:thin:@127.0.0.1:1521:";
		String user="comstudy";
		String password="comstudy";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 검색 성공");
			
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			System.err.println("드라이버 검색 실패");
		} catch (SQLException e){
			System.err.println("드라이버 db 실패");
		}
		return null;
		
	}
	
	  public static void close(Connection obj) {
	      if(obj != null) {
	         try {
	            obj.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }
	   
	   public static void close(Statement obj) {
	      if(obj != null) {
	         try {
	            obj.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }
	   
	   public static void close(ResultSet obj) {
	      if(obj != null) {
	         try {
	            obj.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }
	   
	   public static void close(Connection conn, Statement stmt, ResultSet rs) {
	      close(conn);
	      close(stmt);
	      close(rs);
	   }

	
	
}
