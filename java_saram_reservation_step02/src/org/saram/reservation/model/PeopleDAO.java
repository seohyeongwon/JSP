package org.saram.reservation.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.saram.reservation.mapper.PeopleMapper;
import org.saram.reservation.mapper.ProductMapper;
import org.saram.reservation.mybatis.service.FactoryService;

public class PeopleDAO {
	public static List<PeopleVO> selectAll() {
		List<PeopleVO> list = null;
		SqlSession mybatis = FactoryService.getFactory().openSession();
		PeopleMapper peopleMapper = mybatis.getMapper(PeopleMapper.class);
		ProductMapper productMapper = mybatis.getMapper(ProductMapper.class);
		list = peopleMapper.selectAll();
		for(PeopleVO people : list) {
			people.setProductVo(productMapper.selectProduct(people.getRno()));
		}
		mybatis.close();
		return list;
	}
	
	public static void insert(PeopleVO vo) {
		SqlSession mybatis = FactoryService.getFactory().openSession(true);
		PeopleMapper peopleMapper = mybatis.getMapper(PeopleMapper.class);
		peopleMapper.insert(vo);
		mybatis.close();
	}
	
	public static void main(String[] args) {
		insert(new PeopleVO(0, "TEST", "010-1212-3333", "T", 106));
		System.out.println(selectAll());
	}
}
