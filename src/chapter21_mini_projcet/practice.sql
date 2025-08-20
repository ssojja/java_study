use hrdb2019;
select database();

select emp_id, emp_name, dept_id, salary from employee;

select 
	row_number() over() as rno,
    emp_id, 
    emp_name, 
    dept_id, 
    salary 
from employee where dept_id = 'SYS';

select * from employee;
desc employee;

select 
	dept_id, 
    dept_name, 
    unit_id, 
    start_date 
from department;

delete from employee where emp_id = 'S0024';

desc member;
select * from member;

update member
set email = 'leee@example.com', name = '이순신'
where member_id = 2;

-- 	private int rno;
-- 	private String mid; // 학번
-- 	private String name;
-- 	private String department;
-- 	private int kor;
-- 	private int eng;
-- 	private int math;
-- 	private String mdate;

-- srcore_member 테이블 생성
create table score_member(
	mid		char(5)		primary key,
    name	varchar(10)	not null,
    department	varchar(20),
    kor		decimal(6,2) default 0.0,
    eng		decimal(6,2) default 0.0,
    math	decimal(6,2) default 0.0,
    mdate	datetime
);

select * from score_member;

-- 트리거 생성
delimiter $$
create trigger trg_score_member_mid
before insert on score_member
for each row
begin
declare max_code int;

select ifnull(max(cast(right(mid,4) as unsigned)),0)
into max_code
from score_member;

SET NEW.mid = concat('E', LPAD((max_code+1), 4, '0'));

end $$
delimiter ;

select * from information_schema.triggers;

select curdate() from dual;

select * from score_member;
select count(*) from score_member;

select mid, name, department, kor, eng, math, mdate from score_member where mid = 'E0001';

update score_member set kor = 1, eng = 2, math = 3 where mid = 'E0001';

delete from score_member where mid = 'e0004';

select mid, name, department, kor, eng, math, mdate from score_member;
show tables;
