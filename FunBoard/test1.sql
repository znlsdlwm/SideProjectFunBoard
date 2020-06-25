create table member_rjs(
r_id varchar2(10) primary key not null,
r_name varchar2(4) not null,
r_age number(3) not null,
r_pw varchar2(10) 
);

create table board_rjs(
r_num number(4) primary key,
r_writer varchar2(21) not null,
r_title varchar2(60) not null,
r_content varchar2(1000), 
r_writeday date default sysdate,
r_readcnt number(4) default 0, 
r_repRoot number(4),
r_repStep number(4),
r_repIndent number(4)
);

drop table member_rjs

insert into board_rjs
(r_num, r_writer, r_title, r_content, r_repRoot, r_repStep, r_repIndent)
values
(1, 'kim', 'test1', 'ok', 1, 0, 0);

select* from board_rjs order by r_num(r_repRoot) desc, r_repStep asc

select * from (select rownum rnum, r_num, r_title, r_writer, r_writeday, r_readcnt from(select * from board_rjs order by r_repRoot desc, r_repStep asc))
where rnum>=1 and rnum <=10

alter table member_rjs add CONSTRAINT r_id foreign key (r_id) references member_rjs(r_id)

alter table board_rjs add constraint member_rjs 

select r_writer from board_rjs minus select from member_rjs

select * from member_rjs

select * from board_rjs

select * from board_rjs where r_num like 2

select * from(select rownum rnum, r_num, r_title, r_writer, r_writeday, r_readcnt  from(select * from board_rjs where r_title like '%%' order by r_repRoot desc, r_repStep asc)) where rnum between 1 and 10
select * from(select rownum rnum, r_num, r_title, r_writer, r_writeday, r_readcnt, r_repIndent from(select * from board_rjs where "+keyField+" like ? order by r_repRoot desc, r_repStep asc)) where rnum between ? and ?


select * from(select rownum rnum, r_num, r_title, r_writer, r_writeday, r_readcnt, r_repIndent from(select * from board_rjs where r_title like '%e%' order by r_repRoot desc, r_repStep asc)) where rnum between 1 and 10
select * from(select rownum rnum, r_num, r_title, r_writer, r_writeday, r_readcnt, r_repIndent from(select * from board_rjs where r_writer like '%e%' order by r_repRoot desc, r_repStep asc)) where rnum between 1 and 10