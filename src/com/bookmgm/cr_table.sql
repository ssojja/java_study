use hrdb2019;

-- 테이블 3개 생성(book_tj, book_yes24, book_aladin)
-- bid : pk('b001', 트리거 생성), title, author, price, isbn(랜덤 정수4자리 생성), bdate

drop table book_aladin;
create table book_tj(
	bid		char(4)			primary key,
    title	varchar(50)		not null,
    author	varchar(10),
    price	int,
    isbn	int,
    bdate	datetime
);

create table book_yes24(
	bid		char(4)			primary key,
    title	varchar(50)		not null,
    author	varchar(10),
    price	int,
    isbn	int,
    bdate	datetime
);

create table book_aladin(
	bid		char(4)			primary key,
    title	varchar(50)		not null,
    author	varchar(10),
    price	int,
    isbn	int,
    bdate	datetime
);

delimiter $$
create trigger trg_book_aladin_bid
before insert on book_aladin
for each row
begin
declare max_code int;

select ifnull(max(cast(right(bid, 3) as unsigned)), 0)
into max_code
from book_tj;

set new.bid = concat('B', LPAD(max_code+1 ,3, '0'));

end $$
delimiter ;

drop trigger trg_book_aladin_bid;
select * from information_schema.triggers;

select * from book_tj;
insert into book_tj(title, author, price, isbn, bdate) values(?, ?, ?, (rand() * 10000, now()));

insert into book_tj(title, author, price, isbn, bdate) values('타이틀', '작가', 50000, rand() * 10000, now());

delete from book_tj where bid = 'B001';


select 
row_number() over() as rno,
bid, title, author, price, isbn, bdate from book_tj;


select count(*) from book_tj;



select bid, title, author, price, isbn, bdate 
					from book_tj 
					where bid = 'b001';
update book_tj set title = '테스트111', author = '킴소현', price = 90000 where bid = 'B001';

-- Connection 확인
show status like 'Threads_connected';	-- 접속 커넥션 수
show processlist;						-- 활성중인 커넥션
show variables like 'max_connections';	-- 최대 접속 가능 커넥션 수

select * from book_yes24;











