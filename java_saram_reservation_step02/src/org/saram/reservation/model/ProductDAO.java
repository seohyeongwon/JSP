package org.saram.reservation.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.saram.reservation.mapper.ProductMapper;
import org.saram.reservation.mybatis.service.FactoryService;

public class ProductDAO {
	public static List<ProductVO> selectAll() {
		SqlSession mybatis = FactoryService.getFactory().openSession();
		ProductMapper productMapper = mybatis.getMapper(ProductMapper.class);
		List<ProductVO> list = productMapper.selectAll();
		mybatis.close();
		return list;
	}
}
