use hrdb2019;
select database();

/********************************************
		book_market_books : 도서 테이블
		book_market_cart : 장바구니 테이블
		book_market_member : 회원 테이블
********************************************/

-- book_market_books 테이블 생성
create table book_market_books(
	bid			char(8) 	primary key,
    title 		varchar(20) not null,
    author		varchar(10),
    price 		int,
    category	varchar(10),
    content		varchar(100),
    bdate	date
);

-- book_market_member 테이블 생성
create table book_market_member(
	mid		char(5)		primary key,
    name 	varchar(10)	not null,
    phone	char(11) not null,
    addr	varchar(50)
);

insert into book_market_member(mid, name, phone) values('M0001', '김소현', '01012341234');

drop table book_market_books;

select count(*) from book_market_member where name = '김소현' and phone = '01012341234';



desc book_market_books;
select * from book_market_member;
-- book_market_cart 테이블 생성
create table book_market_cart(
	order_id	int auto_increment primary key,	-- 주문 번호
    bid			char(8),
    mid			char(5),
    order_date	datetime,
    delivery	datetime,
	constraint fk_bid_book_market_cart foreign key(bid)
		references book_market_books(bid),
     constraint fk_mid_book_market_member foreign key(mid)
		references book_market_member(mid)
);

drop table book_market_cart;
drop trigger trg_book_market_books;

-- delimiter $$
-- create trigger trg_book_market_books
-- before insert on book_market_books
-- for each row
-- begin
-- declare max_code int;

-- select ifnull(max(cast(right(bid,4) as unsigned)), 0)
-- into max_code
-- from book_market_books;

-- set new.bid = concat('B', LPAD(max_code + 1 , 4, '0'));


-- end $$
-- delimiter ;


delimiter $$
create trigger trg_book_market_member
before insert on book_market_member
for each row
begin
declare max_code int;

select ifnull(max(cast(right(mid,4) as unsigned)), 0)
into max_code
from book_market_member;

set new.mid = concat('M', LPAD(max_code + 1 , 4, '0'));


end $$
delimiter ;



select * from information_schema.triggers;
select * from book_market_books;

 insert into book_market_books(bid, title, author, price, category, content, bdate) 
 values('ISBN1234', '쉽게 배우는 JSP 웹 프로그래밍', '송미영', 27000, 'IT전문서', '단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍', 20181008);

 insert into book_market_books(bid, title, author, price, category, content, bdate) 
 values('ISBN1235', '안드로이드 프로그래밍', '우재남', 33000, 'IT전문서', '실습 단계별 명쾌한 멘토링!', 20220122);


 insert into book_market_books(bid, title, author, price, category, content, bdate) 
 values('ISBN1236', '스크래치', '고광일', 22000, '컴퓨터입문', '컴퓨팅 사고력을 키우는 블록코딩', 20190610);


select bid, count(*), sum(price)
from book_market_cart a, book_market_books b
where a.bid = b.bid
group by bid;
;

update book_market_cart set bid = 'ISBN0001' WHERE ORDER_ID = 1;

select * from book_market_cart;

select a.bid, count(a.bid) as count, sum(b.price) as price
from book_market_cart a inner join book_market_books b 
on a.bid = b.bid
group by a.bid;

select su.sname
from subject su inner join student st
	on su.sid = st.sid
where st.sname = '홍길동';

truncate table book_market_member;
select * from book_market_member; 
show tables;
