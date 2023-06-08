select * from SARAM;

drop table person;

create table person(
seq number not null primary key,
id varchar2(20) not null,
name varchar2(20) not null,
age number(3)
);

--squence 자동증가
drop sequence seq_person;
create sequence seq_person;

select seq_person.nextval from dual;

insert into person(seq, id, name, age)
values(seq_person.nextval, 'hong', 'qwe', 33);

insert into person(seq, id, name, age)
values(seq_person.nextval, 'kim', 'asd', 43);

insert into person(seq, id, name, age)
values(seq_person.nextval, 'kim2', 'asd', 53);

commit

select * from person;