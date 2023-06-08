package org.com.person.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.com.dbcp.jdbcUtil;

public class PersonDAO {
	public static final String SELECT_ALL = "SELECT * FROM won";

	public static final String SELECT_ONE = "SELECT * FROM won WHERE SEQ=?";
	public static final String INSERT = "INSERT INTO won * FROM won(SEQ, ID, NAME, AGE, EMAIL) VALUES(?,?,?,?,?)";
	public static final String UPDATE = "UPDATE won SET ID=?, NAME=?, AGE=?, WHERE SEQ=?";
	public static final String DELETE = "DELETE FROM won WHERE SEQ=?";

	private static final Statement JdbcUtil = null;

	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;

	public List<PersonDTO> selectAll() {
		List<PersonDTO> list = new ArrayList<PersonDTO>();

		conn = jdbcUtil.getConnection();

		try {
			stmt = conn.prepareStatement(SELECT_ALL);

			rs = stmt.executeQuery();

			while (rs.next()) {
				int seq = rs.getInt("seq");
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				list.add(new PersonDTO(seq, id, name, age, email));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.close(conn, stmt, rs);
		}

		return list;

	}

	public PersonDTO selectOne(PersonDTO dto) {
		PersonDTO won = null;
		conn = jdbcUtil.getConnection();
		
		
		try {
			stmt = conn.prepareStatement(SELECT_ONE);
			stmt.setInt(1, dto.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				int seq = rs.getInt("seq");
				String id = rs.getString("id");
				String name = rs.getString("name");
				
				int age = rs.getInt("age");
				String email = rs.getString("email");
				won = new PersonDTO(seq, id, name, age, email);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.close(conn, stmt, rs);
		}

		// 중요
		return won;
	}
	
	  public PersonDTO findBySeq(int seq) throws SQLException {
		  PersonDTO won = null;
	      conn = JdbcUtil.getConnection();
	      try {
	         stmt = conn.prepareStatement(SELECT_ONE);
	         stmt.setInt(1, seq);
	         rs = stmt.executeQuery();
	         if(rs.next()) {
	            String id = rs.getString("id");
	            String name = rs.getString("name");
	            int age = rs.getInt("age");
	            String email = rs.getString("email");
	            won = new PersonDTO(seq, id, name, age, email);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JdbcUtil.close();
	      }
	      return won;
	   }


	public void insert(PersonDTO dto) {
		conn = jdbcUtil.getConnection();
		//PersonDTO won = null;
		try {
	         stmt = conn.prepareStatement(INSERT);
	         stmt.setString(1, dto.getId());
	         stmt.setString(2, dto.getName());
	         //stmt.setInt(3, dto.getAge());
	         stmt.setString(3, dto.getEmail());
	         int cnt = stmt.executeUpdate();
	         if(cnt > 0) {
	             System.out.println("입력 완료!");
	             conn.commit(); // 트랜젝션 처리
	          } else {
	             System.out.println("입력 실패!");
	             conn.rollback();
	          }

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.close(conn, stmt, rs);
		}

		// 중요
		//return won;
	}

	public void update(PersonDTO dto) {
		conn = jdbcUtil.getConnection();
		PersonDTO won = null;
		try {
	         stmt = conn.prepareStatement(UPDATE);
	         stmt.setString(1, dto.getId());
	         stmt.setString(2, dto.getName());
	         stmt.setInt(3, dto.getAge());
	         stmt.setString(4, dto.getEmail());
	         int cnt = stmt.executeUpdate();
	         if(cnt > 0) {
	             System.out.println("mod 완료!");
	             conn.commit(); // 트랜젝션 처리
	          } else {
	             System.out.println("mod 실패!");
	             conn.rollback();
	          }


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.close(conn, stmt, rs);
		}
	}

	public void delete(PersonDTO dto) {
		conn = jdbcUtil.getConnection();
		PersonDTO won = null;
		try {
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, dto.getSeq());
		
			int cnt = stmt.executeUpdate();
	         if(cnt > 0) {
	             System.out.println("del 완료!");
	             conn.commit(); // 트랜젝션 처리
	          } else {
	             System.out.println("del 실패!");
	             conn.rollback();
	          }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.close(conn, stmt, rs);
		}

	}

	public static void main1(String[] args) {
		PersonDAO dao = new PersonDAO();
		PersonDTO won = dao.selectOne(new PersonDTO(2, null, null, 0, null));
		System.out.println(won);
	}

	public static void main(String[] args) {
		// jdbc 사용하기 때매 오라클이 반드씨 실행
		PersonDAO dao = new PersonDAO();
		List<PersonDTO> list = dao.selectAll();
		for (PersonDTO dto : list) {
			System.out.println(dto);
		}
	}



}
