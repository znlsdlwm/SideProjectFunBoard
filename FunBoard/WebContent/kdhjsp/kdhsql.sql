select * from member
select * from board
select * from v_listBoard
select max(repStep) from board where repRoot=213 and repIndent=0
select * from board where num = 213
select * from board order by repRoot desc, repStep

select * from (select rownum rnum, num, title, writer, writeday, readcnt, repIndent from (
				select * from board where writer like '%%' order by repRoot desc , repStep)) 
				where rnum>=0 and rnum<=10
				
select count(num) from board where title like '%%'


select * from (select rownum rnum writer from (
				select * from board order by repRoot desc , repStep)) where writer='m003' and rnum=1
				
select * from (select num, writer from (select * from board order by repRoot desc , repStep)) where writer='m003' and num=217