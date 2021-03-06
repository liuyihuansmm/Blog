/***
 	2017-02-25
	初始化数据库，建部分表
 */

1.create database blog;

2.use blog;

3.create table user(
`uid` varchar(100) NOT NULL COMMENT '主键:用户id(登录账号)',
`innerid` INT NOT NULL AUTO_INCREMENT COMMENT '用户内码：方便构建restful api',
`nickname` varchar(100) NOT NULL COMMENT '用户昵称', 
`password` varchar(100) NOT NULL COMMENT '用户密码',
`email` varchar(100) NOT NULL COMMENT '用户邮箱',
`head_picture` varchar(100) COMMENT '用户头像',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
primary key(uid),
KEY(innerid),
KEY idx_user_nickname(nickname),
KEY idx_user_createtime(create_time)
)ENGINE=Innodb AUTO_INCREMENT 1 DEFAULT CHARSET=utf8 COMMENT='用户表';

4.create table friendship(
`fid` INT AUTO_INCREMENT NOT NULL COMMENT '主键',
`hostid` varchar(100) NOT NULL COMMENT '外键:主人id',
`friendid` varchar(100) NOT NULL COMMENT '朋友id',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
primary key(fid),
KEY idx_friendship_hostid(hostid),
KEY idx_friendship_createtime(create_time),
FOREIGN KEY(hostid) REFERENCES user(uid)
)ENGINE=Innodb AUTO_INCREMENT 1 DEFAULT CHARSET=utf8 COMMENT='好友关系表';

5.create table log(
`lid` INT AUTO_INCREMENT NOT NULL COMMENT '日志主键', 
`hostid` varchar(100) NOT NULL COMMENT '日志所属用户id',
`title` varchar(50) NOT NULL COMMENT '日志标题',
`content` blob COMMENT '日志内容',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
primary key(lid),
KEY idx_log_title(title),
KEY idx_log_createtime(create_time),
FOREIGN KEY(hostid) REFERENCES user(uid)	
)ENGINE=Innodb AUTO_INCREMENT 1 DEFAULT CHARSET=utf8 COMMENT='日志表';

6.create table logxcomment(
`lgcommentid` INT AUTO_INCREMENT NOT NULL COMMENT '日志评论主键', 
`lid` INT NOT NULL COMMENT '评论所属日志',
`content` varchar(200) COMMENT '评论内容',
`fromid` varchar(100) NOT NULL COMMENT '评论来自哪个用户',
`toid` varchar(100) NOT NULL COMMENT '评论给哪个用户',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
primary key(lgcommentid),
FOREIGN KEY(fromid) REFERENCES user(uid),
FOREIGN KEY(toid) REFERENCES user(uid)
)ENGINE=Innodb AUTO_INCREMENT 1 DEFAULT CHARSET=utf8 COMMENT='日志评论表';


/**
	2017-02-26
	报错用户lyh无权限连接mysql，新建了lyh用户并授权
*/
1.create user 'lyh'@'localhost' identified by '123';

2.grant all on *.* to 'lyh'@'localhost';

/*
  2017-03-09
  增加评论表logxcomment和日志的主外键关系
 */
1.alter table logxcomment add CONSTRAINT `logxcomment_ibfk_3` FOREIGN key(`lid`) REFERENCES `log`(`lid`);

/**
  2017-03-22
  新增系统通知表notice
 */
create table notice(
`nid` INT NOT NULL AUTO_INCREMENT COMMENT '通知主键',
`hostid` INT COMMENT '被通知的用户',
`status` INT default 0 COMMENT '通知状态:0 未读,1 已读',
`content` varchar(200) COMMENT '通知内容',
`url` varchar(200) COMMENT '跳转到对应发生的位置',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
primary key(nid),
FOREIGN KEY(hostid) REFERENCES user(innerid),
KEY idx_notice_createtime(create_time)
)ENGINE = INNODB AUTO_INCREMENT 1 DEFAULT CHARSET=UTF8 COMMENT '系统通知表';