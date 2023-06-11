package org.comstudy.member.modei;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.com.dbcp.jdbcUtil;
import org.comstudy.dbcp.JdbcUtil;

public class MemberDAO {
   private String SELECT_ALL = "SELECT * FROM MEMBER ORDER BY SEQ DESC";
   private String SELECT_ONE = "SELECT * FROM MEMBER WHERE SEQ=?";
   private String FIND_BY_NAME = "SELECT * FROM MEMBER WHERE NAME LIKE ?";
   private String INSERT = "insert into member(seq, name, height, weight, age, gender) VALUES(mem_seq.nextval, ?, ?, ?, ?, ?)";
   private String UPDATE = "update MEMBER set name=?, height=?, weight=?, age=?, gender=? WHERE SEQ=?";
   private String DELETE = "DELETE FROM MEMBER WHERE SEQ=?";

   private Connection conn;
   private PreparedStatement stmt;
   private ResultSet rs;
private JdbcUtil jdbcUtil;

   public List<MemberDTO> selectAll() {
      List<MemberDTO> list = new ArrayList<MemberDTO>();
      // JDBC로 구현
      conn = JdbcUtil.getConnection();
      try {
         stmt = conn.prepareStatement(SELECT_ALL);
         rs = stmt.executeQuery();
         while(rs.next()) {
            int seq = rs.getInt(1);
            String name = rs.getString(2);
            int height = rs.getInt(3);
            int weight = rs.getInt(4);
            int age = rs.getInt(5);
            String gender = rs.getString(6);
            list.add(new MemberDTO(seq, name, height, weight, age, gender));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }

   public MemberDTO selectOne(MemberDTO dto) {
      MemberDTO member = null;
      // JDBC로 구현
      conn = JdbcUtil.getConnection();
      try {
         stmt = conn.prepareStatement(SELECT_ONE);
         rs = stmt.executeQuery();
         while(rs.next()) {
            int seq = rs.getInt(1);
            String name = rs.getString(2);
            int height = rs.getInt(3);
            int weight = rs.getInt(4);
            int age = rs.getInt(5);
            String gender = rs.getString(6);
            member=new MemberDTO(seq, name, height, weight, age, gender);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
			jdbcUtil.close(conn, stmt, rs);
		}
      return member;
   }

   public void insert(MemberDTO dto) {
	      MemberDTO member = null;
	      // JDBC로 구현
	      conn = JdbcUtil.getConnection();
	      try {
	         stmt = conn.prepareStatement(INSERT);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            int seq = rs.getInt(1);
	            String name = rs.getString(2);
	            int height = rs.getInt(3);
	            int weight = rs.getInt(4);
	            int age = rs.getInt(5);
	            String gender = rs.getString(6);
	            member=new MemberDTO(seq, name, height, weight, age, gender);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
				jdbcUtil.close(conn, stmt, rs);
			}
	      return ;
   }

   public void update(MemberDTO dto) {
	      MemberDTO member = null;
	      // JDBC로 구현
	      conn = JdbcUtil.getConnection();
	      try {
	         stmt = conn.prepareStatement(INSERT);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            int seq = rs.getInt(1);
	            String name = rs.getString(2);
	            int height = rs.getInt(3);
	            int weight = rs.getInt(4);
	            int age = rs.getInt(5);
	            String gender = rs.getString(6);
	            member=new MemberDTO(seq, name, height, weight, age, gender);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
				jdbcUtil.close(conn, stmt, rs);
			}
	      return ;
   }

   public void delete(MemberDTO dto) {
	      MemberDTO member = null;
	      // JDBC로 구현
	      conn = JdbcUtil.getConnection();
	      try {
	         stmt = conn.prepareStatement(INSERT);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            int seq = rs.getInt(1);
	            String name = rs.getString(2);
	            int height = rs.getInt(3);
	            int weight = rs.getInt(4);
	            int age = rs.getInt(5);
	            String gender = rs.getString(6);
	            member=new MemberDTO(seq, name, height, weight, age, gender);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
				jdbcUtil.close(conn, stmt, rs);
			}
	      return ;
   }
   
   public static void main(String[] args) {
	MemberDAO dao = new MemberDAO();
	List<MemberDTO> list = dao.selectAll();
	for(MemberDTO dto : list) {
		System.out.println(dto);
	}
}
}
