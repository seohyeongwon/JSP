drop table board2;

create table board2(
num number(10) primary key,
author varchar2(100) not null,
email varchar2(200) not null,
title varchar2(500) not null,
content varchar2(4000),
password varchar2(12) not null,
writeday date default sysdate,
readcnt number(10) default 0,
rep_root number(10) default 0,
rep_step number(10) default 0,
rep_indent number(10) default 0
);

drop sequence board2_seq;

create sequence board2_seq start with 1 increment by 1;

insert into board2(num, author,email,title,content,password)
values(board2_seq.nextval,'user01','user01@saram.com','test', 'test test','test');
insert into board2(num, author,email,title,content,password)
values(board2_seq.nextval,'user02','user02@saram.com','test2', 'test2 test','test2');
insert into board2(num, author,email,title,content,password)
values(board2_seq.nextval,'user03','user03@saram.com','test3', 'test3 test','test3');
insert into board2(num, author,email,title,content,password)
values(board2_seq.nextval,'user04','user04@saram.com','test4', 'test4 test','test4');
insert into board2(num, author,email,title,content,password)
values(board2_seq.nextval,'user05','user05@saram.com','test5', 'test5 test','test5');

commit

select*from board2 order by num desc;

update board2 set title='수정 연습', content='수정 연습입니다' where num=5;

select*from board2 where num=5;

delete from board2 where num=5;
