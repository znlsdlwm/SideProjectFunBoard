ALTER TABLE BOARD_ASJ DROP WRITER;
DROP TABLE BOARD_ASJ;
CREATE TABLE MEMBER();
CREATE TABLE admin_BOARD_ASJ(
NUM NUMBER(4) primary key,
WRITER VARCHAR2(21),
TITLE VARCHAR2(60),
CONTENT VARCHAR2(1000),
WRITEDAY DATE DEFAULT SYSDATE,
readcnt number(4) default 0,
REPROOT NUMBER(4),
repStep number(4),
repIndent number(4)
);
select *from ALL_TAB_COLUMNS where table_name = 'member_asj';
select *from BOARD_ASJ;
drop table board_asj;
create table upload_ASJ(
alter table member_asj add foreign key(id)references admin_asj(id);
select count(num) from board_asj;
alter table admin_asj modify id not null;
select id from member_asj
)
select *from member_asj
alter table board_asj add  fileName varchar2(1000);
alter table board_asj add fileRealName varchar2(1000);
select *from member_asj;
select *from(select rownum rnum, num, title, writer, writeday, readcnt from(select *from board_asj order by repRoot desc, repStep asc))where rnum>=1 and rnum<=10
alter table member_asj modify column id varchar2(22) primary key
alter table board_asj 
select *from admin_asj
select *from board_asj
insert into admin_asj values ('admin',123)
