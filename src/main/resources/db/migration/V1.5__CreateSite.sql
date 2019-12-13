# 创建参数设置表
create table site
(
	rankno int(6) not null COMMENT '级别编号',
	gain varchar(50) null COMMENT '教学成果名称',
	type varchar(50) null COMMENT '大类别',
	rank varchar(50) null  COMMENT '小类别：一等奖，二等奖，三等奖，市级，校级，国家级',
	proportion int(2) null  COMMENT '系数',
	constraint site_pk primary key (rankno)
);

# 插入参数设置信息
## 教改项目
insert into site values(001,"教改项目","","国家级",10);
insert into site values(002,"教改项目","","市级重点",8);
insert into site values(003,"教改项目","","市级一般",6);
insert into site values(004,"教改项目","","校级重点",4);
insert into site values(005,"教改项目","","市级一般",2);
## 教改论文
insert into site values(006,"教改论文","","SCI",10);
insert into site values(007,"教改论文","","EI(JA)",8);
insert into site values(008,"教改论文","","EI(CA)",8);
insert into site values(009,"教改论文","","核心",6);
insert into site values(010,"教改论文","","计算机教育",5);
insert into site values(011,"教改论文","","一般",4);
## 出版专著
insert into site values(012,"出版专著","自然科学","编著",8);
insert into site values(013,"出版专著","自然科学","译著",5);
insert into site values(014,"出版专著","自然科学","教材",6);
insert into site values(015,"出版专著","社会科学","编著",8);
insert into site values(016,"出版专著","社会科学","译著",5);
insert into site values(017,"出版专著","社会科学","教材",6);
## 教师比赛
# 青年基本功
insert into site values(018,"教学比赛","青年基本功","一等奖",8);
insert into site values(019,"教学比赛","青年基本功","二等奖",6);
insert into site values(020,"教学比赛","青年基本功","三等奖",4);
# 教学名师
insert into site values(021,"教学比赛","教学名师","一等奖",8);
insert into site values(022,"教学比赛","教学名师","二等奖",6);
insert into site values(023,"教学比赛","教学名师","三等奖",4);
# 优秀主讲
insert into site values(024,"教学比赛","优秀主讲","国家级",9);
insert into site values(025,"教学比赛","优秀主讲","市级",6);
insert into site values(026,"教学比赛","优秀主讲","校级",3);
