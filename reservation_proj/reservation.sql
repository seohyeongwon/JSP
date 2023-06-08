-- 여행 상품 테이블
create table travel (
tcode char(4) primary key,
tarea varchar2(30),
tdate char(8),
ttime char(4),
tday number(2),
thotel varchar2(30),
tmoney number(7),
tair varchar2(30)
);

insert into travel(tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair)
values('JJ01','제주','20181201','0930',0,'J호텔',360000,'J항공');
insert into travel(tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair)
values('JJ02','부산','20181202','1000',0,'B호텔',280000,'B항공');
insert into travel(tcode,tarea,tdate,ttime,tday,thotel,tmoney,tair)
values('JJ03','제주','20181204','1000',0,'J호텔',360000,'J항공');

select * from TRAVEL;

------------------------------------------------------------------------------------------
-- 예약 테이블
drop table reservation;
create table reservation (
	rno char(8) primary key,
	rjumin varchar2(13),
	rname varchar2(20),
	rphone1 char(3) default('010'),
	rphone2 char(4),
	rphone3 char(4),
	remail varchar2(30),
	rstat char(1) default('F'),
	tcode char(4),
	CONSTRAINT tcode_ref
    FOREIGN KEY (tcode) -- 해당 테이블의 FK 설정
    REFERENCES travel(tcode) -- MOTHER 테이블의 PK와 연결
    ON DELETE CASCADE  -- MOTHER TABLE의 값 삭제시 연결된 값 삭제
);

truncate table reservation;

insert into reservation (rno, rjumin, rname, rphone1, rphone2, rphone3, remail, rstat, tcode)
values('20180001','9901011000001','김고객','010','1111','2221','kim@gmail.com', 'F', 'JJ01');
insert into reservation (rno, rjumin, rname, rphone1, rphone2, rphone3, remail, rstat, tcode)
values('20180002','9902011000001','이고객','010','1111','2222','lee@naver.com', 'F', 'JJ02');

select * from reservation;

commit

---------------------------------------------------------------------------------------------
-- 테이블 JOIN 결과 뷰 생성 (사용 안 함)
create view travel_reservation as
select r.rno, r.rjumin, r.rname, r.rphone1, r.rphone2, r.rphone3, r.remail, r.rstat,
t.tcode,t.tarea,t.tdate,t.ttime,t.tday,t.thotel,t.tmoney,t.tair
from reservation r
join travel t
on r.tcode = t.tcode;


select * from travel_reservation where rno='20180001';