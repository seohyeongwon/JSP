package org.comstudy.myweb.board;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	private SqlSession mybatis;
	
	public BoardDAO() {
		try {
			String resource = "org/comstudy/myweb/mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			mybatis = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardDTO> selectAll() {
		return mybatis.selectList("BoardMapper.selectAll");
	}

	public BoardDTO selectOne(BoardDTO dto) {
		return mybatis.selectOne("BoardMapper.selectOne", dto);
	}

	public void insert(BoardDTO dto) {
		System.out.println(dto);
		mybatis.insert("BoardMapper.insertBoard", dto);
	}

	public void update(BoardDTO dto) {
		mybatis.update("BoardMapper.updateBoard", dto);
	}

	public void delete(BoardDTO dto) {
		mybatis.delete("BoardMapper.deleteBoard", dto);
	}
}
