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
-- Table structure for table `negozio`
--

DROP TABLE IF EXISTS `negozio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `negozio` (
  `nome` varchar(45) NOT NULL,
  `usernameVenditore` varchar(255) NOT NULL,
  `design` varchar(45) NOT NULL,
  `colore` varchar(45) NOT NULL,
  `Piva` varchar(50) DEFAULT NULL,
  `dataIscrizione` date NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `via` varchar(45) NOT NULL,
  `città` varchar(45) NOT NULL,
  `cap` varchar(5) NOT NULL,
  `logo` varchar(255) NOT NULL,
  PRIMARY KEY (`nome`),
  KEY `usernameVanditore_idx` (`usernameVenditore`),
  CONSTRAINT `usernameVanditore` FOREIGN KEY (`usernameVenditore`) REFERENCES `venditore` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `negozio`
--

LOCK TABLES `negozio` WRITE;
/*!40000 ALTER TABLE `negozio` DISABLE KEYS */;
INSERT INTO `negozio` VALUES ('Adidas','adidas','left','Verde','03456128949','2019-05-01','Adidas nasce nel 1920, a Herzogenaurach, nel Novimberga GE. Adolf Dassler comincia a pensare come realizzare delle scarpe specifiche per sport. Oggi il marchio ha una vasta gamma di capi accessori.','Corso Buenos Aires','Milano','20121','images/negozi/Adidas/Adidas.png'),('AyurvedaBook','ayurvedico','left','Verde','09854215155','2019-05-17','Tipografia, venditore autorizzato di libri antichi, e manufatti originali. Dispone di un laboratorio per ristrutturare libri antichi. Un marchio che dal 1830 offre agli italiani e a tutto il mondo di appassionati, molti libri d\'epoca...','Via Cristallo III','Como','20150','images/negozi/AyurvedaBook/AyurvedaBook.jpg'),('McDonald','mcdonald','top','Yellow','09851244531','2019-05-10','McDonald Ã¨ la piÃ¹ grande catena al mondo di ristoranti di fast food. Fondata nel 1940 come ristorante barbecue gestito da Dick e Mac Donald, nel 1948 Ã¨ diventato un ristorante di Hamburger','Duomo','Milano','05121','images/negozi/McDonald/McDonald.jpg');
/*!40000 ALTER TABLE `negozio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-23  9:24:24
