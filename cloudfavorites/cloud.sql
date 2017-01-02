CREATE DATABASE IF NOT EXISTS cloud DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
drop database cloud
commit
use cloud;
create database cloud

create table tag(
	t_id int primary key auto_increment,
	t_name varchar(50),
	t_count int
)
update tag set t_count=2 where t_name='java'
delete from tag
commit;
insert into tag(t_name,t_count) values('java',0);
insert into tag(t_name,t_count) values('jdbc',0);
insert into tag(t_name,t_count) values('orcle',0);
insert into tag(t_name,t_count) values('mybatis',0);
insert into tag(t_name,t_count) values('百度',0);
select t_id,t_name,t_count from tag
create table favorite(
	f_id int primary key auto_increment,
	f_label varchar(50),
	f_url varchar(50), 
	f_tags varchar(50),
	f_desc varchar(200)
)
select * from favorite where f_tags='' IS NULL
insert into favorite(f_id,f_label,f_url,f_tags,f_desc) values('百度',0);
show tabels ;