select * from(
  select a.*, rownum rn from 
    (select u.*, r.roleid, r.rolename, r.detial, r.menuid 
     from sys_user u inner join user_link_role l on u.userid = l.userid
     inner join user_role r on l.roleid = r.roleid 
     order by u.userid desc) a
  where username like '%Ů%' and roleid in (2, 5) and rownum <= 5
 ) where rn >= 2
 
select * from 
    		(select u.*, r.roleid, r.rolename, r.detial, r.menuid 
     		from sys_user u inner join user_link_role l on u.userid = l.userid
     		inner join user_role r on l.roleid = r.roleid 
     		order by u.userid desc)
  		where username like '%Ů%' and roleid in (2, 5)
