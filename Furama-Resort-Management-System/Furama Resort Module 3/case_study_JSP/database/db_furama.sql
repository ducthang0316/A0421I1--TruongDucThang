-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: furama
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attach_service`
--

DROP TABLE IF EXISTS `attach_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attach_service` (
  `attach_service_id` int NOT NULL AUTO_INCREMENT,
  `attach_service_name` varchar(45) NOT NULL,
  `attach_service_cost` double NOT NULL,
  `attach_service_unit` int NOT NULL,
  `attach_service_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`attach_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attach_service`
--

LOCK TABLES `attach_service` WRITE;
/*!40000 ALTER TABLE `attach_service` DISABLE KEYS */;
INSERT INTO `attach_service` VALUES (1,'Karaoke',500000,1,'Yes'),(2,'Massage',700000,2,'Yes'),(3,'Food',500000,1,'Yes'),(4,'Baverage',300000,1,'Yes');
/*!40000 ALTER TABLE `attach_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `contract_id` int NOT NULL AUTO_INCREMENT,
  `contract_start_date` date NOT NULL,
  `contract_end_date` date NOT NULL,
  `contract_deposit` double NOT NULL,
  `contract_total_money` double NOT NULL,
  `employee_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `service_id` int NOT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `employee_id` (`employee_id`),
  KEY `customer_id` (`customer_id`),
  KEY `service_id` (`service_id`),
  CONSTRAINT `contract_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `contract_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `contract_ibfk_3` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (9,'2021-11-14','2021-11-11',99999,66,5,6,5),(10,'2021-11-13','2021-11-06',99999,66,5,7,1),(11,'2021-11-14','2021-11-26',455555,55555,8,6,1),(12,'2021-11-19','2021-11-30',12000,13000,4,7,3),(13,'2021-11-12','2021-11-30',78000,14900,5,6,3),(14,'2021-11-05','2021-11-26',12000,16000,8,8,4),(16,'2021-11-08','2021-11-09',10000,100000,5,7,5),(17,'2021-11-11','2021-11-30',20000,1000000,5,7,7),(18,'2021-11-03','2021-11-10',20000,300000,7,6,4),(19,'2021-11-15','2021-11-09',20000,100000,7,5,7),(20,'2021-11-16','2021-11-17',20000,100000,16,15,12);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_detail`
--

DROP TABLE IF EXISTS `contract_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_detail` (
  `contract_detail_id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `contract_id` int NOT NULL,
  `attach_service_id` int NOT NULL,
  PRIMARY KEY (`contract_detail_id`),
  KEY `contract_id` (`contract_id`),
  KEY `attach_service_id` (`attach_service_id`),
  CONSTRAINT `contract_detail_ibfk_1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`contract_id`),
  CONSTRAINT `contract_detail_ibfk_2` FOREIGN KEY (`attach_service_id`) REFERENCES `attach_service` (`attach_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_detail`
--

LOCK TABLES `contract_detail` WRITE;
/*!40000 ALTER TABLE `contract_detail` DISABLE KEYS */;
INSERT INTO `contract_detail` VALUES (2,5,9,3),(5,9,10,3),(6,2,10,2),(7,2,14,1),(8,2,11,3),(9,2,11,3),(10,3,13,3),(11,2,10,3),(13,3,12,3),(14,4,12,3);
/*!40000 ALTER TABLE `contract_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(45) NOT NULL,
  `customer_birthday` date NOT NULL,
  `customer_gender` bit(1) NOT NULL,
  `customer_id_card` varchar(45) NOT NULL,
  `customer_phone` varchar(45) NOT NULL,
  `customer_email` varchar(45) DEFAULT NULL,
  `customer_address` varchar(45) DEFAULT NULL,
  `customer_type_id` int NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `customer_type_id` (`customer_type_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`customer_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Tran Van Minh Nhat','2021-11-06',_binary '\0','123456789','09023452435','nhat.tranvanminh@gmail.com','Quang Nam',3),(5,'Nguyen Cong Toan','2021-11-12',_binary '\0','3254362352354','2345324623542','toan@gmail.com','Quang Ninh',2),(6,'Huynh Tuan Tai','2021-11-04',_binary '','2345255235','23452342353','tai@gmail.com','Khanh Ha',3),(7,'Nguyen Minh Nhat','2021-11-12',_binary '','2542323453254','23452345234','nhatnguyen@gmail.com','Ha Noi',1),(8,'Tran Dai Nghia','2021-11-13',_binary '','5234623452345','2345326235','nghia@gmail.com','Binh Duong',2),(10,'Tran Cong Quang','2021-11-11',_binary '','8723498579832','32589723895','quang@gmail.com','Quang Nam',2),(11,'Tran Quoc Tuan','2021-11-04',_binary '\0','98758923745','732985943235','tuan@gmail.com','Quang Tri',2),(12,'Lai Xuan Tao','2021-11-03',_binary '\0','8239579823475','872983457235','tao@gmail.com','Hue',3),(13,'Le Vuong Tu Trinh','2021-11-04',_binary '','97823985723','897598237598','trinh@gmail.com','Dong Nai',1),(14,'Nguyen Van Trong','2021-11-03',_binary '\0','234634252243','2345234523456','trong@gmail.com','Da Nang',2),(15,'Tu Tai Tinh','2021-11-03',_binary '\0','734825352524','52346252436','tu@gmail.com','Tuyen Quang',2),(18,'Tráº§n VÄn Minh Nháº­t','2021-11-04',_binary '\0','784673987','0907876543','tranvanminhnhat99@gmail.com','Khanh Ha',2),(19,'Tráº§n VÄn Minh Nháº­t','2021-11-04',_binary '\0','784673987','0907876543','tranvanminhnhat99@gmail.com','Khanh Ha',2),(20,'Tráº§n VÄn Minh Nháº­t','2021-11-10',_binary '\0','879087643','0917876543','tranvanminhnhat99@gmail.com','Khanh Ha',1),(21,'Tráº§n VÄn Minh Nháº­t','2021-11-10',_binary '\0','879087643','0917876543','tranvanminhnhat99@gmail.com','Khanh Ha',1),(22,'tu tai','2021-11-10',_binary '','678987234','0398765478','tutaitinh@yopmail.com','Khanh Ha',1),(24,'tu tai','2021-11-02',_binary '\0','123456789','0398765478','tutaitinh@yopmail.com','Khanh Ha',1),(25,'Le Vi','2021-11-02',_binary '\0','234234567','09078987656','nhat.tranvanminh@codegym.com.vn','Bien Hoa',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_type` (
  `customer_type_id` int NOT NULL AUTO_INCREMENT,
  `customer_type_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'Silver'),(2,'Gold'),(3,'Diamond');
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `division` (
  `division_id` int NOT NULL AUTO_INCREMENT,
  `division_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`division_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,'accounting'),(2,'technical'),(3,'marketing');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_degree`
--

DROP TABLE IF EXISTS `education_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education_degree` (
  `education_degree_id` int NOT NULL AUTO_INCREMENT,
  `education_degree_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`education_degree_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_degree`
--

LOCK TABLES `education_degree` WRITE;
/*!40000 ALTER TABLE `education_degree` DISABLE KEYS */;
INSERT INTO `education_degree` VALUES (1,'High School'),(2,'College'),(3,'University');
/*!40000 ALTER TABLE `education_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(45) NOT NULL,
  `employee_birthday` date NOT NULL,
  `employee_id_card` varchar(45) NOT NULL,
  `employee_salary` double NOT NULL,
  `employee_phone` varchar(45) NOT NULL,
  `employee_email` varchar(45) DEFAULT NULL,
  `employee_address` varchar(45) DEFAULT NULL,
  `position_id` int NOT NULL,
  `education_degree_id` int NOT NULL,
  `division_id` int NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `division_id` (`division_id`),
  KEY `education_degree_id` (`education_degree_id`),
  KEY `position_id` (`position_id`),
  KEY `username` (`username`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`division_id`) REFERENCES `division` (`division_id`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`education_degree_id`) REFERENCES `education_degree` (`education_degree_id`),
  CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`),
  CONSTRAINT `employee_ibfk_4` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (4,'Tran Tuan An','2021-11-09','4575467457',20000,'0333365864','anh@gmail.com','Quang Nam',1,3,2,NULL),(5,'Nguyen Thi Hoa','2021-11-05','90023532452',20000,'0333365864','hoa@gmail.com','Quang Ngai',1,1,1,NULL),(7,'Ngo Thanh Long','2021-11-05','02835032753',90000,'236262343264','long@gmail.com','TPHCM',2,3,3,NULL),(8,'Tran Duc Minh','2021-11-07','8293593252345',60000,'234634523235','minh@gmail.com','Khanh Hoa',2,3,3,NULL),(11,'Tran Minh Duc','2021-11-03','52346232454',1000000,'87234976984','duc@gmail.com','Quang Nam',1,2,1,NULL),(12,'Huynh Van Nghe','2021-11-02','96248732945',1000000,'87234976984','nghe@gmail.com','Ha Giang',2,2,3,NULL),(13,'Ho Van Tuyen','2021-11-10','96248732945',1000000,'87234976984','tuyen@gmail.com','Ca Mau',3,3,1,NULL),(14,'Tran Huu Hung','2021-11-10','252342346243',2000000,'26345245234','hung@gmail.com','Quang Nam',1,2,3,NULL),(15,'Tran Thi Kim Xuyen','2021-11-04','96248732945',1000000,'87234976984','xuyen@gmail.com','Quang Nam',3,2,3,NULL),(16,'Tran Thi Kim Ngoc','2021-11-02','96248732945',1000000,'87234976984','ngoc@gmail.com','Da Nang',3,2,1,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `position_id` int NOT NULL AUTO_INCREMENT,
  `position_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Manager'),(2,'Director'),(3,'Chairman');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_type`
--

DROP TABLE IF EXISTS `rent_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_type` (
  `rent_type_id` int NOT NULL AUTO_INCREMENT,
  `rent_type_name` varchar(45) DEFAULT NULL,
  `rent_type_cost` double DEFAULT NULL,
  PRIMARY KEY (`rent_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_type`
--

LOCK TABLES `rent_type` WRITE;
/*!40000 ALTER TABLE `rent_type` DISABLE KEYS */;
INSERT INTO `rent_type` VALUES (1,'Week',7000000),(2,'Month',25000000),(3,'Year',250000000);
/*!40000 ALTER TABLE `rent_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `service_id` int NOT NULL AUTO_INCREMENT,
  `service_name` varchar(45) NOT NULL,
  `service_area` int DEFAULT NULL,
  `service_cost` double NOT NULL,
  `service_max_people` int DEFAULT NULL,
  `standard_room` varchar(45) DEFAULT NULL,
  `description_other_convenience` varchar(45) DEFAULT NULL,
  `pool_area` double DEFAULT NULL,
  `number_of_floors` int DEFAULT NULL,
  `rent_type_id` int NOT NULL,
  `service_type_id` int NOT NULL,
  PRIMARY KEY (`service_id`),
  KEY `rent_type_id` (`rent_type_id`),
  KEY `service_type_id` (`service_type_id`),
  CONSTRAINT `service_ibfk_1` FOREIGN KEY (`rent_type_id`) REFERENCES `rent_type` (`rent_type_id`),
  CONSTRAINT `service_ibfk_2` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`service_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'VILLA',1000,2000,5,'Superior','Thoat mat',100,3,2,1),(3,'HOUSE',2000,200,4,'Deluxe','De Chiu',200,3,2,2),(4,'ROOM',1000,300,5,'Connecting room','Mat me',150,2,3,1),(5,'HOTEL',200,40000,12,'Deluxe','Thoat mat',30,4,3,2),(7,'HOTEL 5 Star',2000,1000000000,30,'Superior ','De Chiu',500,10,3,1),(8,'MOTEL',500,5000,10,'Superior ','Thoat mat',30,4,2,2),(9,'RESORT',50000,300000,60,'Superior ','Gan bien',1000,6,3,1),(10,'RESORT 2 Star',2000,10000,15,'Superior ','De Chiu',200,4,3,2),(11,'MOTEL Modern',2000,40000,10,'Superior ','De Chiu',200,10,3,1),(12,'VILLA Large',2000,300000,10,'Superior ','De Chiu',200,10,3,2);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_type` (
  `service_type_id` int NOT NULL AUTO_INCREMENT,
  `service_type_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`service_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (1,'VIP'),(2,'NORMAL');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('anh@gmail.com','123'),('duc@gmail.com','123'),('hoa@gmail.com','123'),('hung@gmail.com','123'),('long@gmail.com','123'),('minh@gmail.com','123'),('minhtuan@gmail.com','123'),('nghe@gmail.com','123'),('ngoc@gmail.com','123'),('nhat.tranvanminh@gmail.com','123'),('nhat@g.c','123'),('nhat@gmail.com','123'),('quang@gmail.com','123'),('tuyen@gmail.com','123'),('xuyen@gmail.com','123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `role_id` int NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`,`username`),
  KEY `username` (`username`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
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

-- Dump completed on 2021-11-22 15:04:10
