package org.saram.reservation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.saram.reservation.model.PeopleVO;

@Mapper
public interface PeopleMapper {
	@Select("SELECT * FROM PEOPLE WHERE rno=#{pno}")
	PeopleVO selectProduct(int rno);
	
	@Select("SELECT * FROM PEOPLE ORDER BY pno DESC")
	List<PeopleVO> selectAll();
	
	@Insert("insert into PEOPLE(pno, name, phone, rpay, rno)values(seq_people.nextval, #{name}, #{phone}, #{rpay}, #{rno})")
	void insert(PeopleVO vo);
	
	@Delete("DELETE FROM PEOPLE WHERE pno = #{pno}")
	void delete(PeopleVO vo);
}
