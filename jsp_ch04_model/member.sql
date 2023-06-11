-- member 테이블 삭제
drop table member;
-- member 테이블 생성
create table member(
seq number primary key,
name varchar2(20) not null,
height number(3) not null,
weight number(3) not null,
age number(3),
gender char(3) default '여' check(gender in('남','여'))
);

-- sequence 생성
drop sequence mem_seq;
create sequence mem_seq start with 1 increment by 1;

-- 내용 입력
insert into member(seq, name, height, weight, age)
values (mem_seq.nextval, '유관순', 167, 45, 18);
insert into member(seq, name, height, weight, age)
values (mem_seq.nextval, '유관순2', 157, 65, 19);
insert into member(seq, name, height, weight, age, gender)
values (mem_seq.nextval, '이순신', 178, 67, 23, '남');
insert into member(seq, name, height, weight, age, gender)
values (mem_seq.nextval, '이순신2', 160, 45, 20, '남');

-- 데이터 수정
update MEMBER set name='강감찬', height=170, weight=75, age=25, gender='남'
where seq=3;

-- 삭제 기능
delete from member where seq=3;

-- 검색 기능
select * from member where seq=3;

-- 내용 확인
select * from member;

commit
