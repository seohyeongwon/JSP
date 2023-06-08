package org.com.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {

	public static Connection getConnection() {
		String url="jdbc:oracle:thin:@127.0.0.1:1521:";
		String user="shw";
		String password="1234";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("driver ok");
			
			Connection conn = DriverManager.getConnection(url, user,password);
			System.out.println(conn);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("driver no");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("driver db no");
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
	   
	   public static void main(String[] args) {
		   System.out.println(getConnection());

	}

}
