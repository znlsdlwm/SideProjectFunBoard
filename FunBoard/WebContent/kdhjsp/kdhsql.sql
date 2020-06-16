select * from member
select * from board
select * from b_comment
create table b_comment(
c_num number(4) not null primary key,
c_writer varchar2(21) not null,
c_content varchar2(1000) not null,
c_password varchar2(8),
c_writeday DATE default sysdate,
c_good number(4) default 0,
c_bad number(4) default 0,
c_warning number(4) default 0,
c_Root number(4),
c_Step number(4),
c_Indent number(4),
b_num not null,
constraint fk_bnum foreign key(b_num) references board(num)
)

alter table b_comment add constraint fk_b_num foreign key(num) references board
ALTER TABLE board add(
good number(4) default 0,
bad number(4) default 0
)


select * from board order by repRoot desc, repStep

select * from (select rownum rnum, num, title, writer, writeday, readcnt, repIndent from (
				select * from board where writer like '%%' order by repRoot desc , repStep)) 
				where rnum>=0 and rnum<=10
				
select count(num) from board where title like '%%'


select * from (select rownum rnum writer from (
				select * from board order by repRoot desc , repStep)) where writer='m003' and rnum=1
				
select * from (select num, writer from (select * from board order by repRoot desc , repStep)) where writer='m003'