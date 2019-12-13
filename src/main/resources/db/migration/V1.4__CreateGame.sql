# 创建比赛表
create table game
(
	gno int(6) not null COMMENT '比赛编号',
	gname varchar(50) null COMMENT '比赛名称',
	winner int(11) null COMMENT '获奖人' ,
	type varchar(50) null COMMENT '大类别：青年基本功、教学名师、优秀主讲',
	rank varchar(50) null  COMMENT '一等奖，二等奖，三等奖，市级，校级，国家级',
	rankno int(3) not null  COMMENT '等级编号：青年基本功<一等奖（018），二等奖（019），三等奖（020）>,
    教学名师<一等奖（021），二等奖（022），三等奖（023）>,优秀主讲<校级（024），市级（025），国家级（026）>',
	gurl varchar(100) null COMMENT '封面图片地址',
	isconfirmed tinyint(1) NULL DEFAULT NULL COMMENT '是否被确认:未确认(0),已确认(1)',
	constraint game_pk primary key (gno)
);

# 插入比赛息
insert into game values(700001,"比赛1",2012012010,"青年基本功","一等奖",018,"",1);
insert into game values(700002,"比赛2",2012012011,"青年基本功","二等奖",019,"",1);
insert into game values(700003,"比赛3",2012012010,"青年基本功","三等奖",020,"",0);
insert into game values(700004,"比赛4",2012012013,"教学名师","一等奖",021,"",1);
insert into game values(700005,"比赛5",2012012016,"教学名师","二等奖",022,"",1);
insert into game values(700006,"比赛6",2012012011,"教学名师","三等奖",023,"",1);
insert into game values(700007,"比赛7",2012012011,"优秀主讲","市级",025,"",0);
insert into game values(700008,"比赛8",2012012010,"优秀主讲","市级",025,"",1);
insert into game values(700009,"比赛9",2012012012,"优秀主讲","校级",026,"",1);
insert into game values(700010,"比赛10",2012012013,"优秀主讲","国家级",024,"",1);
insert into game values(700011,"比赛11",2012012014,"优秀主讲","国家级",024,"",0);