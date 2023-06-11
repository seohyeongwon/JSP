--member 테이블 삭제
drop table member;

--member 테이블 생성
create table member(
seq number primary key,
name varchar2(20) not null,
height number(3) not null,
weight number(3) not null,
age number(3),
gender char(3) default '여' check(gender in('남','여'))

);

--sequence 생성
create sequence  mem_seq start with 100 increment by 1;

--내용입력
insert into member(seq,name,height,weight,age)
values (mem_seq.nextval, 'qwe',167,45,18);
insert into member(seq,name,height,weight,age)
values (mem_seq.nextval, 'qwe2',167,45,18);
insert into member(seq,name,height,weight,age,gender)
values (mem_seq.nextval, 'qwe3',167,45,18,'남');
insert into member(seq,name,height,weight,age,gender)
values (mem_seq.nextval, 'qwe4',167,45,18,'남');

--데이터 수정
update MEMBER set name='asd', height=170,weight=76,age=34,gender='남'
where seq=103;

--삭제 기능
delete from member where seq=103;

--검색 기능
select*from member where seq=103;


--내용확인
select*from member;

commit