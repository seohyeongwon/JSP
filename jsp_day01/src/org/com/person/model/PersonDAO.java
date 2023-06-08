package org.com.person.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.com.dbcp.jdbcUtil;

public class PersonDAO {
	final String SELECT_ALL = "SELECT * FROM PERSON";
	final String SELECT_ONE = "SELECT * FROM PERSON WHERE SEQ=?";
	final String INSERT = "INSERT INTO PERSON(SEQ, ID, NAME, AGE) VALUES(?,?,?,?)";
	final String UPDATE = "UPDATE PERSON SET ID=?, NAME=?, AGE=?, WHERE SEQ=?";
	final String DELETE = "DELETE FROM PERSON WHERE SEQ=?";
	
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
	
	
	 // CRUD가 되도록 한다.
	   
	   public List<PersonDTO> selectAll() {
	      List<PersonDTO> list = new ArrayList();
	      
	      conn = jdbcUtil.getConnection();
	      try {
	    	stmt = conn.prepareStatement(SELECT_ALL);    
			rs = stmt.executeQuery();
	         while(rs.next()) {
	             int seq = rs.getInt("seq");
	             String name = rs.getString("name");
	             String id = rs.getString("id");
	             int age = rs.getInt("age");
	             list.add(new PersonDTO(seq, id, name, age));
	          }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      
	      return list;
	   }
	   
	   public PersonDTO selectOne(PersonDTO dto) {
		   
		   PersonDTO person = null;
		   
		      conn = jdbcUtil.getConnection();
		      try {
		    	stmt = conn.prepareStatement(SELECT_ONE);
		    	stmt.setInt(1,dto.getSeq());
				rs = stmt.executeQuery();
		         while(rs.next()) {
		             int seq = rs.getInt("seq");
		             String name = rs.getString("name");
		             String id = rs.getString("id");
		             int age = rs.getInt("age");
		             person = new PersonDTO(seq, id, name, age);
		          }

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      //중요
	      return person;
	   }
	   
	   public void insert(PersonDTO dto) {
	      
	   }
	   
	   public void update(PersonDTO dto) {
	         
	   }
	   
	   public void delete(PersonDTO dto) {
	      
	   }
	   
	   
	   public static void main1(String[] args) {
		PersonDAO dao = new PersonDAO();
		PersonDTO person = dao.selectOne(new PersonDTO(2, null, null, 0));
		System.out.println(person);
	}
	   
	   public static void main(String[] args) {
		//jdbc 사용하기 때매 오라클이 반드씨 실행
		   PersonDAO dao = new PersonDAO();
		   List<PersonDTO> list = dao.selectAll();
		      for(PersonDTO dto : list) {
		          System.out.println(dto);
		       }
	}

}
