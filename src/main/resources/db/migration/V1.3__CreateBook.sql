# 创建出版专著表
create table book
(
	bno int(6) not null COMMENT '专著编号',
	bname varchar(50) null COMMENT '专著名称',
	author int(11) null COMMENT '作者',
	type varchar(50) null COMMENT '大类别：自然科学、社会科学',
	pubdate bigint(11) null COMMENT '出版日期',
	rank varchar(50) null  COMMENT '编著、译著、教材',
	rankno int(3) not null  COMMENT '等级编号：自然科学编著(012)、自然科学译著(013)、自然科学教材(014)、社会科学编著(015)、社会科学译著(016)、社会科学教材(017)',
	burl varchar(100) null COMMENT '封面图片地址',
	isconfirmed tinyint(1) NULL DEFAULT NULL COMMENT '是否被确认:未确认(0),已确认(1)',
	constraint book_pk primary key (bno)
);

# 插入出版专著信息
insert into book values(500001,"专著1",2012012010,"自然科学",1567343905303,"编著",012,"",1);
insert into book values(500002,"专著2",2012012011,"自然科学",1567343905303,"编著",012,"",1);
insert into book values(500003,"专著3",2012012010,"自然科学",1567343905303,"编著",012,"",0);
insert into book values(500004,"专著4",2012012013,"自然科学",1567343905303,"译著",013,"",1);
insert into book values(500005,"专著5",2012012016,"自然科学",1567343905303,"译著",013,"",1);
insert into book values(500006,"专著6",2012012011,"社会科学",1567343905303,"译著",013,"",1);
insert into book values(500007,"专著7",2012012011,"社会科学",1567343905303,"教材",016,"",0);
insert into book values(500008,"专著8",2012012010,"社会科学",1567343905303,"教材",016,"",1);
insert into book values(500009,"专著9",2012012012,"社会科学",1567343905303,"教材",016,"",1);
insert into book values(500010,"专著10",2012012013,"社会科学",1567343905303,"教材",016,"",1);
insert into book values(500011,"专著11",2012012014,"社会科学",1567343905303,"教材",016,"",0);