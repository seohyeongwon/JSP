package org.saram.reservation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.saram.reservation.model.ProductVO;

@Mapper
public interface ProductMapper {
	@Select("SELECT * FROM PRODUCT WHERE rno=#{rno}")
	ProductVO selectProduct(int rno);
	
	@Select("SELECT * FROM PRODUCT ORDER BY rno DESC")
	List<ProductVO> selectAll();
	
	@Insert("insert into product(rno, rtitle, rprice)values(seq_product.nextval, #{rtitle}, #{rprice})")
	void insert(ProductVO vo);
	
	@Delete("DELETE FROM PRODUCT WHERE rno = #{rno}")
	void delete(ProductVO vo);
}
