
# 创建教师表
create table tuser
(tno int(11) not null,
	tname varchar(50) null,
	tpassword varchar(50) null,
	age int null,
	email varchar(50) null,
	rank varchar(50) null,
	constraint tuser_pk primary key (tno));

# 插入教师信息
insert into tuser values(2012012010,"tp","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012011,"wrm","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012012,"cyl","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012013,"cja","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012014,"shr","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012015,"yry","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012016,"小明","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012017,"小红","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012018,"小强","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012019,"小美","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012020,"小法","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012021,"陈玉立","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012022,"谭胖","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012023,"陈雨里","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012024,"陈于丽","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012025,"陈玉丽","123",36,"295585335@qq.com","副教授");
insert into tuser values(2012012094,"陈玉立","123",36,"295585335@qq.com","教授");