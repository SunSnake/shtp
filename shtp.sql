-- MySQL dump 10.13  Distrib 5.5.15, for Win32 (x86)
--
-- Host: localhost    Database: shtp
-- ------------------------------------------------------
-- Server version	5.5.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `askbuy`
--

DROP TABLE IF EXISTS `askbuy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `askbuy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `date` varchar(255) DEFAULT NULL COMMENT '发布日期',
  `description` varchar(255) DEFAULT NULL COMMENT '信息描述',
  PRIMARY KEY (`id`),
  KEY `userid` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `askbuy`
--

LOCK TABLES `askbuy` WRITE;
/*!40000 ALTER TABLE `askbuy` DISABLE KEYS */;
INSERT INTO `askbuy` VALUES (5,'李白','2019-05-05 21:33','求护发素'),(6,'李白','2019-05-05 21:37','求购冰箱，要中型的，有冷冻层'),(13,'曾巩','2019-05-06 21:27','我喜欢唱'),(17,'曾巩','2019-05-06 21:34','zzzzz'),(18,'曾巩','2019-05-06 21:35','可还行？'),(27,'系统管理员','2019-05-10 12:37','的萨芬');
/*!40000 ALTER TABLE `askbuy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msgcontent`
--

DROP TABLE IF EXISTS `msgcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msgcontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msgcontent`
--

LOCK TABLES `msgcontent` WRITE;
/*!40000 ALTER TABLE `msgcontent` DISABLE KEYS */;
INSERT INTO `msgcontent` VALUES (14,'2222222222','11111111111111111','2019-04-13 12:46:19'),(15,'22222222','3333333333333333333333','2019-04-13 13:45:57'),(16,'通知标题1','通知内容1','2019-04-14 03:41:39'),(17,'通知标题2','通知内容2','2019-04-14 03:52:37'),(18,'通知标题3','通知内容3','2019-04-14 04:19:41'),(19,'gdsf','gdsfgdsfg','2019-04-23 03:29:42'),(20,'ethr','rtyh','2019-04-23 03:32:06'),(21,'哈哈哈','？？？','2019-04-23 03:33:48'),(22,'test','test','2019-04-23 03:37:47'),(23,'再来一个','哈哈哈','2019-04-23 03:42:17'),(24,'测试','哈哈哈哈哈哈哈','2019-04-23 13:28:59');
/*!40000 ALTER TABLE `msgcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personalizeduser`
--

DROP TABLE IF EXISTS `personalizeduser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personalizeduser` (
  `cuid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`cuid`,`userid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personalizeduser`
--

LOCK TABLES `personalizeduser` WRITE;
/*!40000 ALTER TABLE `personalizeduser` DISABLE KEYS */;
INSERT INTO `personalizeduser` VALUES (3,5),(5,3),(5,12),(12,5);
/*!40000 ALTER TABLE `personalizeduser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productunit`
--

DROP TABLE IF EXISTS `productunit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productunit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `price` varchar(20) DEFAULT NULL COMMENT '价格',
  `description` varchar(64) DEFAULT NULL COMMENT '说明',
  `imageUrl` varchar(255) DEFAULT NULL COMMENT '图片url',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `productunit_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productunit`
--

LOCK TABLES `productunit` WRITE;
/*!40000 ALTER TABLE `productunit` DISABLE KEYS */;
INSERT INTO `productunit` VALUES (1,5,'799.20','MAXFEEL休闲男士手包真皮手拿包大容量信封包手抓包夹包软韩版潮','http://how2j.cn/tmall/img/productSingle_middle/7058.jpg'),(2,12,'511.20','宾度 男士手包真皮大容量手拿包牛皮个性潮男包手抓包软皮信封包','http://how2j.cn/tmall/img/productSingle_middle/7047.jpg'),(3,5,'448.20','唯美诺新款男士手包男包真皮大容量小羊皮手拿包信封包软皮夹包潮','http://how2j.cn/tmall/img/productSingle_middle/7036.jpg'),(4,12,'411.60','英伦邦纹男士手包牛皮大容量真皮手拿包手抓包双拉链商务正品软皮','http://how2j.cn/tmall/img/productSingle_middle/7025.jpg'),(6,5,'268.20','帕朗尼男士手拿包真皮手包商务休闲头层牛皮软牛皮大容量休闲钱包','http://how2j.cn/tmall/img/productSingle_middle/7003.jpg'),(33,12,'3.5','出喜福会图片一张','http://localhost:8080/static/截图.jpg'),(34,12,'5.5','这是一张图片','http://localhost:8080/static/timg.jpg'),(35,12,'50.0','录取通知书一张，有意私聊，价格可以','http://localhost:8080/static/20181010132556_1.jpg'),(36,5,'15.0','干干干干干干','http://localhost:8080/static/151页第三大题.jpg'),(37,5,'55.0','可还行','http://localhost:8080/static/59页第二大题.jpg'),(38,3,'12.0','软工开题报告','http://localhost:8080/static/QQ图片20180917165418.jpg');
/*!40000 ALTER TABLE `productunit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `nameZh` varchar(64) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_admin','系统管理员'),(14,'ROLE_normal','普通角色');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sysmsg`
--

DROP TABLE IF EXISTS `sysmsg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sysmsg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL COMMENT '消息id',
  `type` int(11) DEFAULT '0' COMMENT '0表示群发消息',
  `userid` int(11) DEFAULT NULL COMMENT '这条消息是给谁的',
  `state` int(11) DEFAULT '0' COMMENT '0 未读 1 已读',
  PRIMARY KEY (`id`),
  KEY `hrid` (`userid`),
  KEY `sysmsg_ibfk_1` (`mid`),
  CONSTRAINT `sysmsg_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `msgcontent` (`id`),
  CONSTRAINT `sysmsg_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sysmsg`
--

LOCK TABLES `sysmsg` WRITE;
/*!40000 ALTER TABLE `sysmsg` DISABLE KEYS */;
INSERT INTO `sysmsg` VALUES (57,14,0,3,1),(58,14,0,5,1),(59,14,0,10,1),(60,14,0,11,0),(61,14,0,12,1),(62,15,0,3,1),(63,15,0,5,1),(64,15,0,10,1),(65,15,0,11,0),(66,15,0,12,1),(67,16,0,3,1),(68,16,0,5,1),(69,16,0,10,1),(70,16,0,11,0),(71,16,0,12,1),(72,17,0,3,1),(73,17,0,5,1),(74,17,0,10,1),(75,17,0,11,0),(76,17,0,12,1),(77,18,0,3,1),(78,18,0,5,1),(79,18,0,10,0),(80,18,0,11,0),(81,18,0,12,1),(82,19,0,3,1),(83,19,0,5,1),(84,19,0,10,0),(85,19,0,11,0),(86,19,0,12,1),(87,20,0,3,1),(88,20,0,5,1),(89,20,0,10,0),(90,20,0,11,0),(91,20,0,12,1),(92,21,0,3,1),(93,21,0,5,1),(94,21,0,10,0),(95,21,0,11,0),(96,21,0,12,1),(97,22,0,3,1),(98,22,0,5,1),(99,22,0,10,0),(100,22,0,11,0),(101,22,0,12,1),(102,23,0,3,1),(103,23,0,5,1),(104,23,0,10,0),(105,23,0,11,0),(106,23,0,12,1),(107,24,0,3,1),(108,24,0,5,1),(109,24,0,10,0),(110,24,0,11,0),(111,24,0,12,1);
/*!40000 ALTER TABLE `sysmsg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `enabled` tinyint(1) DEFAULT '1',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'系统管理员',1,'admin','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm','http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg',NULL),(5,'李白',1,'libai','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg',NULL),(10,'韩愈',1,'hanyu','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1406745149,1563524794&fm=27&gp=0.jpg',NULL),(11,'柳宗元',1,'liuzongyuan','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515233756&di=0856d923a0a37a87fd26604a2c871370&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2014-09-27%2F041716704.jpg',NULL),(12,'曾巩',1,'zenggong','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id\r\n',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `rid` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `hr_role_ibfk_1` (`userid`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,3,1),(9,5,14),(37,12,14),(43,11,14),(49,10,14);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-09 12:27:01
