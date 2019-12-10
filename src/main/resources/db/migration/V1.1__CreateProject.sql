
# 创建教改项目表
create table project
(
	pno int(6) not null COMMENT '项目编号',
	pname varchar(50) null COMMENT '项目名称',
	manager int(11) null COMMENT '负责人',
	rank varchar(50) null  COMMENT '等级：国家级（001）、市级重点（002）、市级一般（003），校级重点（004）、校级一般（005）',
	rankno int(3) not null  COMMENT '等级编号',
	isconfirmed tinyint(1) NULL DEFAULT NULL COMMENT '是否被确认',
	constraint project_pk
		primary key (pno)
);

# 插入项目信息
insert into project values(100001,"项目1",2012012010,"国家级",001,0);
insert into project values(100002,"项目2",2012012011,"市级重点", 002, 1);
insert into project values(100003,"项目3",2012012012,"市级一般",003, 0);
insert into project values(100004,"项目4",2012012013,"国家级",001,0);
insert into project values(100005,"项目5",2012012014,"校级重点",004,1);
insert into project values(100006,"项目6",2012012010,"国家级",001,1);
insert into project values(100007,"项目7",2012012015,"校级重点",004,1);
insert into project values(100008,"项目8",2012012015,"校级一般",005,1);
insert into project values(100009,"项目9",2012012016,"国家级",001,1);
