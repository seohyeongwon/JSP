package org.comstudy.myweb.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy.myweb.dbcp.JdbcUtil;

public class BoardDAO_JDBC {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	final String SELECT_ALL = "select*from board2 order by num desc";
	final String SELECT_ONE = "select*from board2 WHERE num=?";
	final String INSERT = "insert into board2(num, author,email,title,content,password) values(board2_seq.nextval,?,?,?,?,?)";
	final String UPDATE = "update board2 set title=?, content=? where num=?;";
	final String DELETE = "delete from board2 where num=?";
	
	public List<BoardDTO> selectAll() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(SELECT_ALL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String email = rs.getString("email");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String password = rs.getString("password");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int rep_root = rs.getInt("rep_root");
				int rep_step = rs.getInt("rep_step");
				int rep_indent = rs.getInt("rep_indent");
				list.add(new BoardDTO(num,author, email, title, content, password, writeday, readcnt, rep_root, rep_step, rep_indent));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return list;
	}
	
	public BoardDTO selectOne(BoardDTO dto) {
		BoardDTO board = null;
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(SELECT_ONE);
			stmt.setInt(1, dto.getNum());
			rs = stmt.executeQuery();
			if(rs.next()) {
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String email = rs.getString("email");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String password = rs.getString("password");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int rep_root = rs.getInt("rep_root");
				int rep_step = rs.getInt("rep_step");
				int rep_indent = rs.getInt("rep_indent");
				board = new BoardDTO(num,author, email, title, content, password, writeday, readcnt, rep_root, rep_step, rep_indent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return board;
	}
	
	public void insert(BoardDTO dto) {
		BoardDTO board = null;
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, dto.getAuthor());
			stmt.setString(2, dto.getEmail());
			stmt.setString(3, dto.getTitle());
			stmt.setString(4, dto.getContent());
			stmt.setString(5, dto.getPassword());
			int cnt = stmt.executeUpdate();
			
			if(cnt>0) {
				conn.commit();
			}else {
				System.err.println("입력실패!!");
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update(BoardDTO dto) {
		BoardDTO board = null;
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, dto.getAuthor());
			stmt.setString(2, dto.getEmail());
			stmt.setString(3, dto.getTitle());

			int cnt = stmt.executeUpdate();
			
			if(cnt>0) {
				conn.commit();
			}else {
				System.err.println("수정실패!!");
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void DELETE(BoardDTO dto) {
		BoardDTO board = null;
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(INSERT);
			stmt.setInt(1, dto.getNum());
			
			int cnt = stmt.executeUpdate();
			
			if(cnt>0) {
				conn.commit();
			}else {
				System.err.println("삭제실패!!");
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
