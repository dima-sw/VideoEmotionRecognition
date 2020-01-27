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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `nomeNeg` varchar(45) NOT NULL,
  `nomeCategoria` varchar(45) NOT NULL,
  `descrizione` varchar(2000) DEFAULT NULL,
  `path` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`nomeNeg`,`nomeCategoria`),
  CONSTRAINT `nomeNeg` FOREIGN KEY (`nomeNeg`) REFERENCES `negozio` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES ('Adidas','Calzini','Stupendi calzini unisex ','images/negozi/Adidas/Calzini.jpg'),('Adidas','Cappelli','Comodi capMpelli per tutti gli eventi','images/negozi/Adidas/Cappelli.jpg'),('Adidas','Completi','Bellisimi completi offerta promozionale','images/negozi/Adidas/Completi.jpg'),('Adidas','Felpa','Queste felpe rendono omaggio alla tradizione con un logo del Trifoglio','images/negozi/Adidas/Felpa.jpg'),('Adidas','Giubino','Piova o ci sia il sole, con questi fantastici indumenti non rinunci a nulla','images/negozi/Adidas/Giubino.jpg'),('Adidas','Scarpe','Migliori scarpe al mondo per soddisfare qualunque sportivo o per stile','images/negozi/Adidas/Scarpe.jpg_640x640.webp'),('Adidas','Short','Pantaloncini belli da indossare e comodi da vestire','images/negozi/Adidas/Short.jpg'),('Adidas','T Short Unisex','Per tutta la famiglia, ottimo tessuto in cotone o sintetici. Per sportivi o per Stile','images/negozi/Adidas/T Short Unisex.jpg'),('Adidas','Zaino','Bellissimi zaini sponsorizzati per la scuola lavoro e sport','images/negozi/Adidas/Zaino.jpg'),('AyurvedaBook','Design','Libri di Design per architettura siti web, colori ...','images/negozi/AyurvedaBook/Design._SX371_BO1,204,203,200_.jpg'),('AyurvedaBook','Informatica','Libri Universitari per ambiente informatica, molti libri di testo o enciclopedie','images/negozi/AyurvedaBook/Informatica.jpg'),('AyurvedaBook','Letteratura','Classici e non della letteratura italiana da quelli medievali a quelli contemporanei','images/negozi/AyurvedaBook/Letteratura.jpg'),('AyurvedaBook','Storia','Libri di storia dalla preistoria alla contemporanea passando per le grandi guerre modiali ...','images/negozi/AyurvedaBook/Storia.jpg'),('McDonald','Coffee','Ora puoi gustare ottimi caffÃ¨ stesso in mcdonald, fornito da Ottolina.','images/negozi/McDonald/Coffee.jpg'),('McDonald','Dessert','Ti aspettiamo con tante proposte golosissime che ti conquisteranno','images/negozi/McDonald/Dessert.jpg'),('McDonald','Insalate','Cosi leggere, cosi buone','images/negozi/McDonald/Insalate.jpg'),('McDonald','Nuggets','Detti anche boccocini di pollo fritti o pepite di pollo','images/negozi/McDonald/Nuggets.jpg'),('McDonald','Panini','valorizza eccellenza italiana','images/negozi/McDonald/Panini.jpg'),('McDonald','Wrap','Termine utilizzato negli Stati Uniti per indicare un alimento che consiste in una sfoglia morbida arrotolata intorno a un ripieno con carne affumicata a freddo o pesce accompagnati da verdure e salse','images/negozi/McDonald/Wrap.jpg');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
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
