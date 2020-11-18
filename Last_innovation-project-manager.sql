/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.29-log : Database - innovation-project-master
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`innovation-project-master` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `innovation-project-master`;

/*Table structure for table `adjudicator` */

DROP TABLE IF EXISTS `adjudicator`;

CREATE TABLE `adjudicator` (
  `adjudicator_id` varchar(20) NOT NULL COMMENT '评审员号',
  `adjudicator_password` varchar(20) NOT NULL DEFAULT '123456' COMMENT '评审员密码',
  `adjudicator_name` varchar(20) NOT NULL COMMENT '评审员姓名',
  PRIMARY KEY (`adjudicator_id`),
  KEY `adju_name_index` (`adjudicator_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `adjudicator` */

insert  into `adjudicator`(`adjudicator_id`,`adjudicator_password`,`adjudicator_name`) values ('201601','1234','王美人'),('201602','123456','小张'),('201603','123456','高育良'),('201620','123456','沈腾');

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `admin_id` varchar(8) NOT NULL COMMENT '管理员号',
  `admin_password` varchar(20) NOT NULL DEFAULT '123456' COMMENT '管理员密码',
  `admin_name` varchar(20) NOT NULL COMMENT '管理员姓名',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `administrator` */

insert  into `administrator`(`admin_id`,`admin_password`,`admin_name`) values ('20160101','1234','王美人'),('20160102','123456','管理员华哥'),('20160103','123456','李向斌'),('20160201','123456','管理员沙瑞金'),('20160202','123456','詹姆斯'),('20160301','123456','刘晓华'),('20160401','123456','管理员志华');

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `student_id` varchar(20) NOT NULL COMMENT '学生号',
  `project_id` varchar(20) NOT NULL COMMENT '项目号',
  `teacher_id` varchar(20) NOT NULL COMMENT '教师号',
  `student_name` varchar(20) NOT NULL COMMENT '学生名',
  `project_name` varchar(200) NOT NULL COMMENT '项目名',
  `teacher_name` varchar(20) NOT NULL COMMENT '教师名',
  `project_content` varchar(6000) NOT NULL COMMENT '申报内容',
  `project_progress` varchar(20) NOT NULL DEFAULT '待辅导' COMMENT '申报进度',
  `project_teach` varchar(6000) NOT NULL DEFAULT '未指导' COMMENT '指导内容',
  `pass_status` varchar(20) NOT NULL DEFAULT '未通过' COMMENT '通过状态',
  `project_total_score` varchar(20) NOT NULL DEFAULT '0' COMMENT '评审总分',
  `has_scored_adju_number` int(20) NOT NULL DEFAULT '0' COMMENT '已经打分的评审员数',
  `adju_number` int(20) NOT NULL DEFAULT '0' COMMENT '评审员数',
  `project_info` varchar(8000) NOT NULL COMMENT '项目描述',
  KEY `teacher_name` (`teacher_name`),
  KEY `project_id` (`project_id`),
  KEY `student_name` (`student_name`),
  KEY `project_name` (`project_name`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `apply` */

insert  into `apply`(`student_id`,`project_id`,`teacher_id`,`student_name`,`project_name`,`teacher_name`,`project_content`,`project_progress`,`project_teach`,`pass_status`,`project_total_score`,`has_scored_adju_number`,`adju_number`,`project_info`) values ('201607070101','202001','2016010101','王美人','制作油田管道检测系统','刘小军','好好学习，天天向上','已辅导，已评分，未通过','加油哈，小王同学。','已通过','10.722222',9,2,'为管道设置摄像拍照，检测是否漏油，实时监测。完成20000字论文，描述项目总体架构'),('201607070102','202002','2016010120','刘小琴','研究人工智能','黄渤','请黄渤老师为我指点，我想给你端茶倒水！','已辅导，已评分，已通过','老师可以通过','已通过','89.0',1,1,'研究人工智能的发展前沿，写出详细的报告，作为一篇论文，要准备好30000字论文文档，要有数据支持。'),('201607070131','202002','2016010120','谢宝伟','研究人工智能','黄渤','黄老师，我想申请你的项目。','已辅导，已评分，未通过','好的，从几方面描述的不错，可以通过的。','已通过','83.5',2,1,'研究人工智能的发展前沿，写出详细的报告，作为一篇论文，要准备好30000字论文文档，要有数据支持。'),('201607070122','202002','2016010120','刘行斌','研究人工智能','黄渤','老师，您好，关于您的项目，我详细看了，我将在文档中叙述，请您查看。','已辅导，未评分，未通过','项目还不错','未通过','0',0,1,'研究人工智能的发展前沿，写出详细的报告，作为一篇论文，要准备好30000字论文文档，要有数据支持。'),('201607070103','202003','2016010101','刘晓华','制作油田管道检测系统','刘小军','老师，我先申请你的项目','待辅导','未指导','未通过','0',0,0,'为管道设置摄像拍照，检测是否漏油，实时监测。完成20000字论文，描述项目总体架构');

/*Table structure for table `file_info` */

DROP TABLE IF EXISTS `file_info`;

CREATE TABLE `file_info` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件编号',
  `file_name` varchar(225) DEFAULT NULL COMMENT '文件名称',
  `file_url` varchar(225) DEFAULT NULL COMMENT '文件地址',
  `student_id` varchar(20) DEFAULT NULL COMMENT '学生学号',
  `teacher_id` varchar(20) DEFAULT NULL COMMENT '教师编号',
  `jury_id` varchar(20) DEFAULT NULL COMMENT '评审员编号',
  `manager_id` varchar(20) DEFAULT NULL COMMENT '管理员编号',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

/*Data for the table `file_info` */

insert  into `file_info`(`file_id`,`file_name`,`file_url`,`student_id`,`teacher_id`,`jury_id`,`manager_id`) values (1,'创新创业项目论文模板.doc','D:\\eclipse_workspace1\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Innovation-project-master\\upload\\1589793224396创新创业项目论文模板.doc',NULL,NULL,NULL,'20160101'),(41,'201607070131_谢宝伟_研究人工智能.doc','D:\\eclipse_workspace1\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Innovation-project-master\\upload\\1589797528873201607070131_谢宝伟_研究人工智能.doc','201607070131',NULL,NULL,NULL),(43,'谢宝伟-Java软件开发工程师-简历.pdf','D:\\eclipse_workspace1\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Innovation-project-master\\upload\\1591578203492谢宝伟-Java软件开发工程师-简历.pdf','201607070122','2016010120',NULL,NULL),(45,'201607070122_刘行斌_研究人工智能.doc','D:\\eclipse_workspace1\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Innovation-project-master\\upload\\1590748892946201607070122_刘行斌_研究人工智能.doc','201607070122',NULL,NULL,NULL),(48,'已签约名单.pdf','D:\\eclipse_workspace1\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Innovation-project-master\\upload\\1591593693400已签约名单.pdf',NULL,NULL,NULL,'20160101'),(49,'中信文化学习笔记（第三期）.pdf','D:\\eclipse_workspace1\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Innovation-project-master\\upload\\1591593718496中信文化学习笔记（第三期）.pdf',NULL,NULL,NULL,'20160101');

/*Table structure for table `judge` */

DROP TABLE IF EXISTS `judge`;

CREATE TABLE `judge` (
  `judge_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评审号',
  `student_id` varchar(20) NOT NULL COMMENT '学生号',
  `project_id` varchar(20) NOT NULL COMMENT '项目号',
  `adju_id` varchar(20) NOT NULL COMMENT '评审员号',
  `project_score` varchar(20) DEFAULT 'NULL' COMMENT '评审分',
  `is_judged` varchar(20) NOT NULL DEFAULT '未评分' COMMENT '评分标记',
  `adju_name` varchar(20) NOT NULL COMMENT '评审员姓名',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  `project_name` varchar(20) NOT NULL COMMENT '项目名称',
  PRIMARY KEY (`judge_id`),
  KEY `student_id` (`student_id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `judge` */

insert  into `judge`(`judge_id`,`student_id`,`project_id`,`adju_id`,`project_score`,`is_judged`,`adju_name`,`student_name`,`project_name`) values (1,'201607070101','202003','201601',NULL,'未评分','李美人','王美人','制作油田管道检测系统'),(2,'201607070101','202003','201602',NULL,'未评分','小张','王美人','制作油田管道检测系统'),(4,'201607070102','202002','201601',NULL,'未评分','李美人','刘小琴','研究人工智能'),(7,'201607070102','202002','201602',NULL,'未评分','小张','刘小琴','研究人工智能'),(8,'201607070131','202002','201620','NULL','未评分','沈腾','谢宝伟','研究人工智能'),(12,'201607070131','202002','201601','NULL','未评分','王美人','谢宝伟','研究人工智能'),(13,'201607070122','202002','201601','NULL','未评分','王美人','刘行斌','研究人工智能');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `project_id` varchar(20) NOT NULL COMMENT '项目号',
  `project_name` varchar(20) NOT NULL COMMENT '项目名',
  `project_info` varchar(20000) NOT NULL COMMENT '项目介绍',
  `teacher_id` varchar(20) DEFAULT NULL COMMENT '教师编号',
  `teacher_name` varchar(20) NOT NULL COMMENT '教师姓名',
  KEY `project_name_index` (`project_name`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`project_id`,`project_name`,`project_info`,`teacher_id`,`teacher_name`) values ('202002','研究人工智能','研究人工智能的发展前沿，写出详细的报告，作为一篇论文，要准备好30000字论文文档，要有数据支持。','2016010120','黄渤'),('202003','制作油田管道检测系统','为管道设置摄像拍照，检测是否漏油，实时监测。完成20000字论文，描述项目总体架构','2016010101','刘小军'),('202004','讲故事','讲一个故事','2016050101','王志华'),('202001','研究云','云计算研究','2016010120','黄渤');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `student_id` varchar(20) NOT NULL COMMENT '学生号',
  `student_password` varchar(20) NOT NULL DEFAULT '123456' COMMENT '学生密码',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  `student_sex` varchar(20) DEFAULT '未知' COMMENT '性别',
  `student_class` varchar(20) DEFAULT '未知' COMMENT '学生班级',
  `student_college` varchar(20) NOT NULL COMMENT '所在院系',
  `student_phonenumber` varchar(20) DEFAULT '未知' COMMENT '学生电话号码',
  PRIMARY KEY (`student_id`),
  KEY `student_name_index` (`student_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`student_id`,`student_password`,`student_name`,`student_sex`,`student_class`,`student_college`,`student_phonenumber`) values ('201607070101','1234','王美人','女','会计1601','经济管理学院','17809563478'),('201607070102','123456','刘小琴','女','会计1601','经济管理学院','18993802378'),('201607070103','123456','刘晓华','女','软件1601','外国语学院','13834638436'),('201607070106','123456','刘科国','女','计科1603','计算机学院','13834638895'),('201607070122','123456','刘行斌','男','计科1601','计算机学院','18977654676'),('201607070124','123456','刘行斌','男','计科1601','计算机学院','18977654676'),('201607070131','123456','谢宝伟','男','软件1601','计算机学院','13834638990');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `teacher_id` varchar(20) NOT NULL COMMENT '教师号',
  `teacher_password` varchar(20) NOT NULL DEFAULT '123456' COMMENT '教师密码',
  `teacher_name` varchar(20) NOT NULL COMMENT '教师名',
  `teacher_college` varchar(20) NOT NULL COMMENT '所在院系',
  `teacher_phonenumber` varchar(20) NOT NULL DEFAULT '未知' COMMENT '教师电话号码',
  PRIMARY KEY (`teacher_id`),
  KEY `teacher_name` (`teacher_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`teacher_id`,`teacher_password`,`teacher_name`,`teacher_college`,`teacher_phonenumber`) values ('2016010101','1234','刘小军','计算机学院','18993808976'),('2016010120','1234','黄渤','计算机学院','18995678945'),('2016020201','123456','少年张三丰','化学化工学院','17899785634'),('2016030302','123456','李达康','机械工程学院','17899785634'),('2016040101','123456','王老师','外国语学院','17899775634'),('2016050101','123456','王志华','经济管理学院','17899785634'),('2016070101','123456','教师小王','计算机学院','17899789634');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
