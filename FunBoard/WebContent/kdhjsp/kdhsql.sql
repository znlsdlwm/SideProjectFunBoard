select * from member
select * from board
select * from v_listBoard


select * from board where title like '%수정%' order by repRoot desc, repStep

select * from (select rownum rnum, num, title, writer, writeday, readcnt, repIndent from (
				select * from board where writer like '%%' order by repRoot desc , repStep)) 
				where rnum>=0 and rnum<=10
				
select count(num) from board where title like '%%'