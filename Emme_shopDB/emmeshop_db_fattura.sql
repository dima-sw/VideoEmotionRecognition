CREATE DATABASE  IF NOT EXISTS `emmeshop_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `emmeshop_db`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: emmeshop_db
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `fattura`
--

DROP TABLE IF EXISTS `fattura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fattura` (
  `numeroFattura` int(20) NOT NULL AUTO_INCREMENT,
  `username_Cliente` varchar(255) NOT NULL,
  `dataOrdine` datetime NOT NULL,
  `viaDestinazione` varchar(45) NOT NULL,
  `cittàDestinazione` varchar(45) NOT NULL,
  `capDestinazione` varchar(5) NOT NULL,
  `nomeUtente` int(11) DEFAULT NULL,
  `cognomeUtente` int(11) DEFAULT NULL,
  `nomeVenditore` int(11) DEFAULT NULL,
  `cognomeVenditore` int(11) DEFAULT NULL,
  `viaPartenza` int(11) DEFAULT NULL,
  `cittàPartenza` int(11) DEFAULT NULL,
  `capPartenza` int(11) DEFAULT NULL,
  PRIMARY KEY (`numeroFattura`),
  KEY `usernameCliente_idx` (`username_Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fattura`
--

LOCK TABLES `fattura` WRITE;
/*!40000 ALTER TABLE `fattura` DISABLE KEYS */;
INSERT INTO `fattura` VALUES (28,'sorrentino','2019-06-10 12:10:18','Via paupasia','Bagnoli','80521',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,'ritafrancese','2019-06-10 12:18:33','nonso','nonso','00000',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,'sorrentino','2019-06-22 09:59:39','Via paupasia','Bagnoli','80521',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,'sorrentino','2019-06-26 10:24:31','Via paupasia','Bagnoli','80521',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,'mario','2019-06-26 12:31:33','vonf egwgweg','wegwg','80433',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,'mario','2019-06-26 12:32:23','vonf egwgweg','wegwg','80433',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,'mario','2019-06-26 12:37:49','vonf egwgweg','wegwg','80433',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,'sorrentino','2019-06-26 21:36:57','Via paupasia','Bagnoli','80521',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,'capo','2019-07-21 07:44:58','treryte','retert','54565',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,'mario','2019-10-20 21:04:33','vonf egwgweg','wegwg','80433',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,'mario','2019-10-20 21:08:39','vonf egwgweg','wegwg','80433',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,'quot','2019-10-29 10:29:31','fsdfsdf','sdfsdf','31232',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `fattura` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-23  9:24:21
