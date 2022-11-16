-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: group
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cuisine`
--

DROP TABLE IF EXISTS `cuisine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuisine` (
  `id_cuisine` varchar(15) NOT NULL,
  `id_shop` varchar(15) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `pic` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_cuisine`),
  KEY `cuisine` (`id_shop`),
  CONSTRAINT `cuisine_ibfk_1` FOREIGN KEY (`id_shop`) REFERENCES `shop` (`id_shop`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuisine`
--

LOCK TABLES `cuisine` WRITE;
/*!40000 ALTER TABLE `cuisine` DISABLE KEYS */;
INSERT INTO `cuisine` VALUES ('005556','084123.png','鸡蛋培根',7.5,'005556.jfif'),('021815','072570','面条',3.5,'021815.jfif'),('200378','475015','盖浇饭',9,'200378.jfif'),('543737','072570','牛排',10,'543737.jfif'),('573830','072570','荷包蛋',2,'573830.jfif'),('781538','475015','轻食',7.5,'781538.jfif');
/*!40000 ALTER TABLE `cuisine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant`
--

DROP TABLE IF EXISTS `merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant` (
  `id` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant`
--

LOCK TABLES `merchant` WRITE;
/*!40000 ALTER TABLE `merchant` DISABLE KEYS */;
INSERT INTO `merchant` VALUES ('1000','1000','赵孰','13686668794'),('1001','1001','王明','15578747246'),('1002','1002','李红','17513136835');
/*!40000 ALTER TABLE `merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_cuisine`
--

DROP TABLE IF EXISTS `order_cuisine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_cuisine` (
  `id_order` varchar(15) NOT NULL,
  `id_cuisine` varchar(15) NOT NULL,
  `count` int NOT NULL,
  `total` double NOT NULL,
  `time_order` varchar(30) NOT NULL,
  `flag` tinyint NOT NULL,
  `name_cuisine` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_order`,`id_cuisine`),
  KEY `order_cuisine` (`id_cuisine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_cuisine`
--

LOCK TABLES `order_cuisine` WRITE;
/*!40000 ALTER TABLE `order_cuisine` DISABLE KEYS */;
INSERT INTO `order_cuisine` VALUES ('575788','543737',1,10,'2022-11-15 18:08:42',1,'牛排'),('575788','573830',1,2,'2022-11-15 18:08:42',1,'荷包蛋'),('605328','200378',1,9,'2022-11-15 18:08:55',1,'盖浇饭');
/*!40000 ALTER TABLE `order_cuisine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_merchant`
--

DROP TABLE IF EXISTS `order_merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_merchant` (
  `id_order` varchar(15) NOT NULL,
  `id_merchant` varchar(15) NOT NULL,
  `count` int NOT NULL,
  `total` double NOT NULL,
  `time_order` varchar(30) NOT NULL,
  `flag` tinyint NOT NULL,
  `id_shop` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_order`,`id_merchant`),
  KEY `order_merchant` (`id_merchant`),
  CONSTRAINT `order_merchant_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id_order`) ON UPDATE CASCADE,
  CONSTRAINT `order_merchant_ibfk_2` FOREIGN KEY (`id_merchant`) REFERENCES `merchant` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_merchant`
--

LOCK TABLES `order_merchant` WRITE;
/*!40000 ALTER TABLE `order_merchant` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_shop`
--

DROP TABLE IF EXISTS `order_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_shop` (
  `id_order` varchar(15) NOT NULL,
  `id_shop` varchar(15) NOT NULL,
  `count` int NOT NULL,
  `total` double NOT NULL,
  `time_order` varchar(30) NOT NULL,
  `flag` tinyint NOT NULL,
  `name_shop` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_order`,`id_shop`),
  KEY `order_shop` (`id_shop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_shop`
--

LOCK TABLES `order_shop` WRITE;
/*!40000 ALTER TABLE `order_shop` DISABLE KEYS */;
INSERT INTO `order_shop` VALUES ('575788','072570',2,12,'2022-11-15 18:08:42',1,'小赵的A店'),('605328','475015',1,9,'2022-11-15 18:08:55',1,'小赵的B店');
/*!40000 ALTER TABLE `order_shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_user`
--

DROP TABLE IF EXISTS `order_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_user` (
  `id_order` varchar(15) NOT NULL,
  `id_user` varchar(15) NOT NULL,
  `count` int NOT NULL,
  `total` double NOT NULL,
  `time_order` varchar(30) NOT NULL,
  `flag` tinyint NOT NULL,
  `name_shop` varchar(15) DEFAULT NULL,
  `time_scheduled` varchar(30) DEFAULT NULL,
  `id_shop` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_order`,`id_user`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_user`
--

LOCK TABLES `order_user` WRITE;
/*!40000 ALTER TABLE `order_user` DISABLE KEYS */;
INSERT INTO `order_user` VALUES ('575788','202016040201',2,12,'2022-11-15 18:08:42',1,'小赵的A店','2022-11-15 18:14:47','072570'),('605328','202016040201',1,9,'2022-11-15 18:08:55',1,'小赵的B店','2022-11-15 18:08:59','475015');
/*!40000 ALTER TABLE `order_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id_order` varchar(15) NOT NULL,
  `id_user` varchar(15) NOT NULL,
  `id_shop` varchar(15) NOT NULL,
  `name_shop` varchar(15) NOT NULL,
  `id_cuisine` varchar(15) NOT NULL,
  `name_cuisine` varchar(15) NOT NULL,
  `price` double NOT NULL,
  `count` int NOT NULL,
  `amount` double NOT NULL,
  `time_scheduled` varchar(30) NOT NULL,
  `time_order` varchar(30) NOT NULL,
  `flag` tinyint NOT NULL,
  PRIMARY KEY (`id_order`,`id_user`,`id_shop`,`name_shop`,`id_cuisine`,`name_cuisine`),
  KEY `id_shop` (`id_shop`),
  KEY `id_cuisine` (`id_cuisine`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `users` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`id_shop`) REFERENCES `shop` (`id_shop`) ON UPDATE CASCADE,
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`id_cuisine`) REFERENCES `cuisine` (`id_cuisine`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `id_shop` varchar(15) NOT NULL,
  `id_merchant` varchar(15) NOT NULL,
  `name` varchar(15) DEFAULT NULL,
  `pic` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_shop`,`id_merchant`),
  KEY `shop` (`id_merchant`),
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`id_merchant`) REFERENCES `merchant` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES ('072570','1000','小赵的A店','072570.png'),('084123.png','1001','小王的店','084123.png.'),('237407','1002','李红的店铺','237407.jfif'),('475015','1000','小赵的B店','475015.png');
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('202016040201','2020','黎铭杰','13686668794','');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-15 20:10:57
