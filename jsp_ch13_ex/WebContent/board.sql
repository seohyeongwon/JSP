drop table board;

create table board(
num number(30) primary key,
title varchar2(100) not null,
author varchar2(100) not null,
email varchar2(50) not null,
writeday number(31)

);

create sequence bo_seq start with 100 increment by 1;

insert into board(num, title, author, email, writeday)
values(bo_seq.nextval, 'qwe','qwe','qwe@qwe',3);
insert into board(num, title, author, email, writeday)
values(bo_seq.nextval, 'asd','asd','asd@asd',13);
insert into board(num, title, author, email, writeday)
values(bo_seq.nextval, 'zxc','zxc','zxc@zxc',23);
insert into board(num, title, author, email, writeday)
values(bo_seq.nextval, 'qaz','qaz','qazx@qwe',23);

select 'num', 'title','author','email','writeday' from BOARD;

update board set title='제목수정' where num=1;

delete from BOARD where num=1;

select*from board;

commit
