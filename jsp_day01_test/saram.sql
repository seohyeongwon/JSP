select * from SARAM;

drop table won;

create table won(
seq number not null primary key,
id varchar2(20) not null,
name varchar2(20) not null,
age number not null,
email varchar2(20) not null
);

create sequence swon;

select swon.nextval from dual;

insert into won(seq, id, name, age, email)
values(swon.nextval, 'kim1', 'qwe', 33, 'qwe@qwe');

insert into won(seq, id, name, age, email)
values(swon.nextval, 'kim2', 'asd', 43, 'asd@asd');

insert into won(seq, id, name, age, email)
values(swon.nextval, 'kim3', 'zxc', 53, 'zxc@zxc');

UPDATE won SET ID='kim5', NAME='qwer', AGE=13, EMAIL='kim5@qwer' WHERE SEQ=1;

commit

select * from won;