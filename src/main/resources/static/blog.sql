/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.31-log : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` longtext,
  `firstPicture` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `apperciation` tinyint(4) DEFAULT NULL,
  `shareStatement` tinyint(4) DEFAULT NULL,
  `commentabled` tinyint(4) DEFAULT NULL,
  `published` tinyint(4) DEFAULT NULL,
  `recommened` tinyint(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `isDelete` tinyint(4) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_blog` */

insert  into `t_blog`(`id`,`title`,`content`,`firstPicture`,`flag`,`views`,`apperciation`,`shareStatement`,`commentabled`,`published`,`recommened`,`createTime`,`updateTime`,`type_id`,`user_id`,`isDelete`,`description`) values 
(1,'111','111','111','1',11,1,1,1,1,1,'2020-09-03 12:07:34','2020-09-11 08:58:53',10,4,1,NULL),
(2,'222信息','222嘻嘻嘻嘻嘻嘻嘻','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599966699261&di=aaae20d2d537c2065717b20a84406a95&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fb%2F57a2a20321de9.jpg','原创',26,0,1,1,1,1,'2020-09-04 12:08:53','2020-09-13 00:23:46',10,4,0,'asdasd'),
(3,'HashMap','HashMap比较复杂，其插入和删除操作涉及到扩容，链表与树转换操作。这里主要研究下插入，顺便看下遍历与删除。插入流程：\r\n\r\n1.判断table数组是否为空，如果为空调用resize方法进行新建\r\n\r\n2.判断数组对应元素是否为空，即之前是否插入过节点\r\n\r\n3.判断是否为树结构\r\n\r\n4.链表插入，插入后是否达到转换成红黑树的阈值\r\n\r\n5.链表转换位红黑树','https://picsum.photos/800/450','',5,1,1,1,1,1,'2019-06-12 06:50:32','2020-09-11 11:53:02',10,4,0,NULL),
(4,'xxx','xxxxxxx','https://picsum.photos/800/450','',6,1,1,1,1,1,'2020-09-11 06:53:29','2020-09-13 00:18:36',10,4,0,'xxxxxxxxxxxxxx'),
(5,'啊啊啊','爱仕达多所','https://picsum.photos/800/450','原创',33,0,0,1,1,1,'2019-01-08 07:05:58','2020-09-13 00:21:48',10,4,0,'xxx'),
(6,'aaa','下实现啊飒飒撒出','https://picsum.photos/800/450','',1,1,1,1,1,1,'2020-09-11 07:06:50','2020-09-13 00:24:42',12,4,0,'asdad'),
(7,'张三','少时诵诗书所','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599966679896&di=4e985cee5fb04b624ead76e1926f2376&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201205%2F20%2F20120520113807_ZhnCB.jpeg','',1,1,1,1,1,1,'2018-10-03 07:10:07','2020-09-13 00:23:26',10,4,0,'asdasd'),
(8,'计划奥术大师多','计划奥术大师多奥术大师大所','https://picsum.photos/800/450','',0,1,1,1,1,1,'2018-10-17 07:13:58','2020-09-13 00:22:57',10,4,0,'asdasd'),
(9,'三生三世','阿达的奥术大师多','https://picsum.photos/800/450','原创',0,1,0,1,1,1,'2020-09-11 11:25:10','2020-09-11 11:34:41',12,4,1,NULL),
(10,'aaaa','测试测试后','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599965987015&di=ce234763a6e6db9d683956103fffa381&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201312%2F03%2F165620x7cknad7vruvec1z.jpg','原创',0,0,1,1,1,1,'2020-09-13 00:11:58','2020-09-13 00:22:04',10,4,0,'xxx'),
(11,'asdas','adasdasd','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599966729883&di=d30566995c43b6c0b884bd4c3fc030ec&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fc%2F570cc78a98f32.jpg','转载',2,1,1,0,1,1,'2020-09-13 00:24:18','2020-09-13 00:24:18',10,4,0,NULL),
(12,'yyyy','yyyyyyyyyyyy','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599965987015&di=ce234763a6e6db9d683956103fffa381&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201312%2F03%2F165620x7cknad7vruvec1z.jpg','原创',0,1,0,1,1,1,'2020-09-13 02:25:56','2020-09-13 02:25:56',12,4,1,NULL),
(13,'yyyy','xxxxx','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599966679896&di=4e985cee5fb04b624ead76e1926f2376&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201205%2F20%2F20120520113807_ZhnCB.jpeg','原创',0,1,1,1,1,1,'2020-09-13 02:35:58','2020-09-13 02:36:20',11,4,0,'zzczczc');

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `isDelete` tinyint(4) DEFAULT NULL,
  `blog_id` int(11) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `addminComment` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

insert  into `t_comment`(`id`,`content`,`createTime`,`parent`,`nickname`,`email`,`isDelete`,`blog_id`,`avatar`,`addminComment`) values 
(1,'test3.......','2020-09-12 05:38:37',-1,'coco','123@qq.com',1,5,'/images/tx/tx8.jpg',0),
(2,'test.....','2020-09-12 05:40:48',-1,'ccccc','123@qq.com',1,5,'/images/tx/tx6.jpg',0),
(3,'xxxx','2020-09-12 05:42:11',-1,'xxx','123@qq.com',1,5,'/images/tx/tx10.jpg',0),
(5,'xxxx','2020-09-12 05:44:51',-1,'xx','xxx@qq.com',0,5,'/images/tx/tx11.jpg',1),
(6,'xasasas','2020-09-12 05:49:01',-1,'asda','asasd@xx.com',1,5,'/images/tx/tx10.jpg',0),
(7,'回复coco','2020-09-12 05:49:20',1,'asda','asasd@xx.com',0,5,'/images/tx/tx4.jpg',0),
(8,'回复asda','2020-09-12 07:19:30',6,'ccccc','123@qq.com',1,5,'/images/tx/tx14.jpg',1),
(9,'奥术大师大所多','2020-09-13 02:02:49',-1,'ccccc','123@qq.com',1,7,'/images/tx/tx13.jpg',0),
(10,'奥术大师大所多','2020-09-13 02:03:06',9,'aaaa','123@qq.com',1,7,'/images/tx/tx11.jpg',0),
(11,'asdas','2020-09-13 02:03:15',-1,'aaaa','123@qq.com',0,7,'/images/tx/tx14.jpg',0);

/*Table structure for table `t_tag` */

DROP TABLE IF EXISTS `t_tag`;

CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `isDelete` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_tag` */

insert  into `t_tag`(`id`,`NAME`,`isDelete`) values 
(1,'java',1),
(2,'MySQL',1),
(3,'Spring',0),
(4,'SpringMVC',0),
(5,'SpringBoot',0),
(6,'SpringCloud',0),
(7,'MyBatic',0),
(8,'JavaScript',0),
(9,'java',0),
(10,'张三',1),
(11,'kaka',1);

/*Table structure for table `t_tag_blog` */

DROP TABLE IF EXISTS `t_tag_blog`;

CREATE TABLE `t_tag_blog` (
  `tag_id` int(11) NOT NULL,
  `blog_id` int(11) NOT NULL,
  `isDelete` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`tag_id`,`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_tag_blog` */

insert  into `t_tag_blog`(`tag_id`,`blog_id`,`isDelete`) values 
(4,2,0),
(4,13,0),
(5,3,0),
(5,4,0),
(5,5,0),
(5,11,0),
(6,2,0),
(6,6,0),
(6,8,0),
(6,11,0),
(7,3,0),
(7,4,0),
(7,5,0),
(7,7,0),
(7,13,0),
(8,2,0),
(8,8,0),
(8,10,0),
(9,2,0),
(9,4,0),
(9,5,0),
(9,6,0),
(9,7,0),
(9,10,0),
(9,11,0);

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `isDelete` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`,`isDelete`) values 
(8,'日记',1),
(9,'随笔',0),
(10,'笔记',0),
(11,'计划',0),
(12,'想法',0),
(13,'美食',0),
(14,'攻略',0),
(15,'java',0),
(16,'asdasd',1),
(17,'CCC',1),
(18,'xxx',1),
(19,'',1),
(20,'张三',1),
(21,'xxxx',1),
(22,'dddd',1),
(23,'噢噢噢噢',1),
(24,'CCC',1),
(25,'kaka',1);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `admin` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `start` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `isDelete` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`nickname`,`phone`,`password`,`email`,`avatar`,`admin`,`code`,`start`,`createTime`,`updateTime`,`isDelete`) values 
(4,'coco','123','202cb962ac59075b964b07152d234b70','123','/images/tx/tx2.jpg',1,'123',1,'2020-09-02 13:14:58','2020-09-03 13:15:02',0),
(5,'mack','111','202cb962ac59075b964b07152d234b70','111','/images/tx/tx6.jpg',0,'111',1,'2020-09-10 13:15:33','2020-09-02 13:15:36',1),
(6,'杰克','222','bcbe3365e6ac95ea2c0343a2395834dd','333','/images/tx/tx12.jpg',0,'111',1,'2020-09-10 23:17:53','2020-09-10 23:23:02',0);

/*Table structure for table `t_visit` */

DROP TABLE IF EXISTS `t_visit`;

CREATE TABLE `t_visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_visit` */

insert  into `t_visit`(`id`,`ip`,`createTime`) values 
(1,'127.136.1.1','2020-09-13 04:13:11'),
(2,'127.136.1.1','2020-09-13 04:17:41'),
(3,'169.254.136.185','2020-09-13 04:34:23'),
(4,'169.254.136.185','2020-09-13 04:34:25'),
(5,'169.254.136.185','2020-09-13 04:34:43'),
(6,'169.254.136.185','2020-09-13 04:34:43'),
(7,'169.254.136.185','2020-09-13 04:37:46'),
(8,'169.254.136.185','2020-09-13 04:37:46'),
(9,'169.254.136.185','2020-09-13 04:38:00'),
(10,'169.254.136.185','2020-09-13 04:38:00'),
(11,'169.254.136.185','2020-09-13 04:38:23'),
(12,'169.254.136.185','2020-09-13 04:38:23');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
