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
-- Table structure for table `riferimento`
--

DROP TABLE IF EXISTS `riferimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `riferimento` (
  `ID_Prodotto` int(11) NOT NULL,
  `numero_Fattura` int(20) NOT NULL,
  `Nome_Negozio` varchar(45) NOT NULL,
  `Nome_Categoria` varchar(45) NOT NULL,
  `nota` varchar(45) NOT NULL DEFAULT ' ',
  `QtaOrdinata` int(11) NOT NULL,
  `sconto` int(11) NOT NULL,
  `prezzoUnitario` float NOT NULL,
  `IVA` int(11) NOT NULL,
  PRIMARY KEY (`ID_Prodotto`,`numero_Fattura`,`Nome_Negozio`,`Nome_Categoria`),
  KEY `nome_prodotto_idx` (`Nome_Negozio`,`Nome_Categoria`),
  KEY `numero_Fattura_idx` (`numero_Fattura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riferimento`
--

LOCK TABLES `riferimento` WRITE;
/*!40000 ALTER TABLE `riferimento` DISABLE KEYS */;
INSERT INTO `riferimento` VALUES (16,30,'McDonald','Panini','',3,18,12.5,22),(17,30,'McDonald','Panini','',4,15,15.5,22),(41,32,'McDonald','Nuggets','',3,1,15,22),(44,33,'McDonald','Coffee','',3,2,1,22),(49,31,'McDonald','Dessert','',1,5,5,22),(50,36,'McDonald','Dessert','88yuo',5,5,6,22),(51,31,'McDonald','Dessert','',1,5,5.5,22),(52,32,'McDonald','Dessert','',20,8,5.4,22),(61,28,'Adidas','Felpa','',3,22,33,22),(61,31,'Adidas','Felpa','',1,22,33,22),(62,31,'Adidas','Felpa','',1,20,35,22),(63,28,'Adidas','Felpa','',1,15,33,22),(63,31,'Adidas','Felpa','',1,15,33,22),(65,31,'Adidas','Felpa','',1,10,22,22),(66,31,'Adidas','Felpa','',1,18,30,22),(67,31,'Adidas','Completi','',1,10,35,22),(68,31,'Adidas','Completi','',1,10,35,22),(74,31,'Adidas','Felpa','',1,15,22.5,22),(75,31,'Adidas','Felpa','',1,5,25,22),(77,28,'Adidas','Felpa','',4,10,22,22),(78,31,'Adidas','Completi','',1,10,30,22),(87,28,'Adidas','Zaino','',1,5,32,22),(89,28,'Adidas','Cappelli','',3,15,18,22),(89,31,'Adidas','Cappelli','',1,15,18,22),(90,30,'Adidas','Calzini','',3,20,10,22),(91,31,'Adidas','Cappelli','',1,10,15,22),(92,31,'Adidas','Cappelli','',1,15,19,22),(92,32,'Adidas','Cappelli','medium\nmedium',2,15,19,22),(93,28,'Adidas','Zaino','',1,1,25,22),(95,31,'Adidas','Cappelli','',1,12,18,20),(100,28,'Adidas','Scarpe','',1,20,89.99,22),(104,29,'AyurvedaBook','Design','',4,22,45.5,22),(104,31,'AyurvedaBook','Design','',1,22,45.5,22),(104,32,'AyurvedaBook','Design','',3,22,45.5,22),(104,35,'AyurvedaBook','Design','',1,22,45.5,22),(104,38,'AyurvedaBook','Design','',1,22,45.5,22),(105,29,'AyurvedaBook','Design','',3,18,38,22),(107,31,'AyurvedaBook','Design','\n',2,20,48,22);
/*!40000 ALTER TABLE `riferimento` ENABLE KEYS */;
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
