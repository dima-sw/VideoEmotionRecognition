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

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sesso` varchar(6) DEFAULT NULL,
  `telefono` varchar(15) NOT NULL,
  `via` varchar(45) NOT NULL,
  `città` varchar(45) NOT NULL,
  `cap` char(5) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `Indirizzo` (`via`,`città`,`cap`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('capo','Capo1#','m','asda','sdgsg@gns.com','M','4115451511','treryte','retert','54565'),('mario','Mario1#','Mario','Egidio','egidio@gmail.com','M','3451222224','vonf egwgweg','wegwg','80433'),('quot','Ciaomondo0#','mmm','dfsf','sdfsdf@gma.af','M','2332313332','fsdfsdf','sdfsdf','31232'),('ritafrancese','Ritafrancese1#','Rita','Francese','ritafrancese@gmail.com','F','3458964254','Via Giovann ','Fisciano','84084'),('sorrentino','Sorrentino2#','Carmine','Sorrentino','sorrentino@gmail.com','M','3458952478','Via paupasia','Bagnoli','80521');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `gestoreaccouting`
--

DROP TABLE IF EXISTS `gestoreaccouting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestoreaccouting` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sesso` varchar(6) DEFAULT NULL,
  `telefono` varchar(15) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestoreaccouting`
--

LOCK TABLES `gestoreaccouting` WRITE;
/*!40000 ALTER TABLE `gestoreaccouting` DISABLE KEYS */;
INSERT INTO `gestoreaccouting` VALUES ('admin1','admin1','Mario','Cetrangolo','cetrangolomario98@gmail.com','M','3402117514'),('admin2','admin2','Mario ','Egidio','egidio','M','3459945621'),('admin3','admin3','Manlio','Santonastasio','manlio','M','6445465464');
/*!40000 ALTER TABLE `gestoreaccouting` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodotto` (
  `IdProdotto` int(11) NOT NULL AUTO_INCREMENT,
  `Nome_Negozio` varchar(45) NOT NULL,
  `Nome_Categoria` varchar(45) NOT NULL,
  `iva` int(11) NOT NULL,
  `path` varchar(400) DEFAULT NULL,
  `prezzo` float NOT NULL,
  `nome` varchar(45) NOT NULL,
  `qta` int(11) NOT NULL,
  `sconto` int(11) NOT NULL,
  `descrizione` varchar(2500) DEFAULT NULL,
  PRIMARY KEY (`IdProdotto`,`Nome_Negozio`,`Nome_Categoria`),
  KEY `NomeCategoria_idx` (`Nome_Categoria`),
  KEY `nomenegozio_idx` (`Nome_Negozio`,`Nome_Categoria`),
  CONSTRAINT `nome_negozio_categoria` FOREIGN KEY (`Nome_Negozio`, `Nome_Categoria`) REFERENCES `categoria` (`nomeNeg`, `nomeCategoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (14,'McDonald','Panini',22,'images/negozi/McDonald/14.jpg',10,'Junior Chicken',10,15,'Dall\'incontro del petto di pollo italiano cotto alla piastra con la dolcezza del ketchup nasce il Junior Chicken'),(15,'McDonald','Panini',22,'images/negozi/McDonald/15.jpg',12,'Crispy McBacon  egg',10,15,'Goditi il gusto delle uova fresche italiane unito al bacon croccante e carne bovina'),(16,'McDonald','Panini',22,'images/negozi/McDonald/16.jpg',12.5,'My Selection Chicken',7,18,'Petto di pollo italiano impanato, Speck alto adige, fontina, salsa con funghi porcini, pomodoro, insalata e pane con semi di sesamo e papavero'),(17,'McDonald','Panini',22,'images/negozi/McDonald/17.jpg',15.5,'My Selection Smoky',11,15,'Hamburger 180g da soli allevamenti italiani, scamorza affumicata con latte 100% italiano, bacon croccante, senape delicata, pomodoro, cipolla e pane con semi di sesamo'),(18,'McDonald','Panini',22,'images/negozi/McDonald/18.jpg',18,'My Selection BBQ',22,20,'Hamburger 180g da soli allevamenti italiani, salsa BBQ con Cipolla Rossa di Tropea Calabria IGP e Aceto Balsamico di Modena IGP, bacon croccante, gouda stagionato, coleslaw, insalata e pane con semi di sesamo e papavero.'),(19,'McDonald','Panini',22,'images/negozi/McDonald/19.jpg',10.5,'Chickenburger',20,10,'Pollo italiano e gustosa salsa Caesar tra due morbide fette di pane. Nella sua semplicitÃ  il Chickenburger Ã¨ davvero sorprendente, forse perchÃ© non serve altro per godersi la sua panatura croccante?'),(20,'McDonald','Panini',22,'images/negozi/McDonald/20.jpg',15,'Chicken Country',18,20,'Un panino pensato per chi ama la semplicitÃ , ma non vuole rinunciare a nulla: il petto di pollo alla piastra incontra tutto il gusto del bacon e della cipolla croccante per un mix di sapori unici.'),(21,'McDonald','Panini',22,'images/negozi/McDonald/21.jpg',12.5,'McMuffin bacon e egg',8,10,'Prova il nuovo McMuffin Bacon & Egg: tutto il gusto delle uova fresche italiane, del bacon e del formaggio, per un pieno di energia.'),(22,'McDonald','Panini',22,'images/negozi/McDonald/22.jpg',14.5,'Double Chicken BBQ',14,1,'Il gusto raddoppia con Double Chicken BBQ: due fette di pollo impanato, insalata fresca, cipolla croccante e formaggio fuso.'),(23,'McDonald','Panini',22,'images/negozi/McDonald/23.jpg',18.5,'Gran Crispy McBacon',10,25,'Carne bovina da allevamenti italiani, bacon croccante e la sua mitica salsa. Se amate il gusto del Crispy McBacon a tal punto da riconoscerlo ad occhi chiusi, Ã¨ per voi che torna il Gran Crispy McBacon.'),(24,'McDonald','Panini',22,'images/negozi/McDonald/24.jpg',15.5,'Gran Crispy McBacon Chicken',14,22,'Petto di pollo, bacon croccante e la sua mitica salsa'),(25,'McDonald','Wrap',22,'images/negozi/McDonald/25.jpg',8,'McWrap Caesar Cheese ',6,5,'Petto di pollo croccante, insalata, pomodoro e scaglie di formaggio, avvolti in una fragrante tortilla: la semplicitÃ  non Ã¨ mai stata cosÃ¬ croccante.'),(26,'McDonald','Wrap',22,'images/negozi/McDonald/26.jpg',9,'McWrap con petto di pollo',10,4,'Petto di pollo croccante, insalata, pomodoro e scaglie di formaggio, avvolti in una fragrante tortilla: la semplicitÃ  non Ã¨ mai stata cosÃ¬ croccante.'),(27,'McDonald','Panini',22,'images/negozi/McDonald/27.jpg',14.5,'Double Cheeseburger',7,12,'Lasciati tentare dal panino con due fette di formaggio fuso e due di carne bovina'),(28,'McDonald','Panini',22,'images/negozi/McDonald/28.jpg',14.5,'Crispy McBacon',12,13,'Carne bovina, due fette di bacon accompagnate dalla deliziosa salsa bacon e formaggio filante. Non serve altro per incoronare Crispy McBacon re della croccantezza e del gusto. Un classico che non tramonterÃ  mai.'),(29,'McDonald','Panini',22,'images/negozi/McDonald/29.jpg',12.8,'Gluten free Burger',10,8,'Due fette di formaggio filante si uniscono a due fette di gustosa carne bovina. Il tutto racchiuso in un morbido pane senza glutine. Finalmente con Gluten Free Burger puoi goderti tutto il gusto di un burger, senza pensieri.'),(30,'McDonald','Panini',22,'images/negozi/McDonald/30.jpg',12.75,'McChicken',10,10,'PER GLI AMANTI DEL POLLO, UNA VERA ISTITUZIONE. La nostra specialitÃ  con petto di pollo impanato, insalata croccante e deliziosa salsa.'),(31,'McDonald','Panini',22,'images/negozi/McDonald/31.jpg',20,'Big Mac',30,15,'Carne cucinata alla piastra con solo sale e pepe, cipolla a cubetti, la croccante lattuga iceberg, formaggio fuso'),(32,'McDonald','Nuggets',22,'images/negozi/McDonald/32.jpg',8,'Chicken Nuggets',30,22,'Da gustare come vuoi, da solo o in compagnia, con o senza salsa'),(33,'McDonald','Panini',22,'images/negozi/McDonald/33.jpg',12,'Filet Fish',22,22,'Delicato pesce bianco impanato, ricoperto di formaggio fuso e deliziosa salsa tartara'),(34,'McDonald','Panini',22,'images/negozi/McDonald/34.jpg',11,'Cheeseburger',22,22,'Soffice panino a base di carne bovina, cetriolo, cipolle, senape, ketchup e formaggio'),(35,'McDonald','Panini',22,'images/negozi/McDonald/35.jpg',12,'Hamburger',22,15,'Il piÃ¹ piccolo della gamma, panino semplice carne bovina, cetriolo, cipolle, senape e ketchup'),(36,'McDonald','Insalate',22,'images/negozi/McDonald/36.jpg',12,'Caesar Salad con pollo',12,1,'Caesar Salad con petto di pollo alla piastra: petto di pollo servito caldo, accompagnato da una ricca insalata con pomodorini ciliegia, scaglie di formaggio e grissini. Il tutto accompagnato dalla salsa Caesar.'),(37,'McDonald','Insalate',22,'images/negozi/McDonald/37.jpg',12.5,'Insalata verde con pomodori',13,2,'insalata verde con pomodori Ã¨ un concentrato di freschezza e leggerezza'),(38,'McDonald','Insalate',22,'images/negozi/McDonald/38.jpg',12.5,'Insalata Mista',15,4,'ricca di pomodori olive finocchi mais e carote, una varietÃ  di ingredienti sani e genuini'),(39,'McDonald','Insalate',22,'images/negozi/McDonald/39.jpg',14.5,'Salad con pollo croccante',22,5,'pollo servito caldo, accompagnato da una ricca insalata con pomodorini cielegia, scaglia di formaggi e grissini.'),(40,'McDonald','Nuggets',22,'images/negozi/McDonald/40.jpg',8,'Pepite Asiago e Speck',22,5,'Filanti e gustosi bocconcini di Asiago Dop e Speck Alto Adige IGP, racchiusi in una croccante panatura'),(41,'McDonald','Nuggets',22,'images/negozi/McDonald/41.jpg',15,'Tasty Basket',19,1,'6 alette di pollo, 8 croccanti chicken, 6 pepite con asiago e Speck'),(42,'McDonald','Nuggets',22,'images/negozi/McDonald/42.jpg',9,'Chiken Wings',22,5,'Croccanti alette di pollo'),(43,'McDonald','Nuggets',22,'images/negozi/McDonald/43.jpg',6,'Snack Parmigiano reggiano',22,1,'Una barretta di vero Parmigiano Reggiano DOP in una comoda confezione monodose.'),(44,'McDonald','Coffee',22,'images/negozi/McDonald/44.jpg',1,'Coffee Espresso',8,2,'Lungo, corto, macchiato, decaffeinato.'),(45,'McDonald','Coffee',22,'images/negozi/McDonald/45.jpg',1.2,'Coffee Americano',22,2,'Il sapore del caffÃ¨ nel piÃ¹ classico dei formati a stelle e strisce.'),(46,'McDonald','Coffee',22,'images/negozi/McDonald/46.jpg',1.2,'Cappuccino',22,2,'Immergiti nella schiuma del nostro cappuccino e lasciati ingolosire dalla sua cremositÃ '),(47,'McDonald','Coffee',22,'images/negozi/McDonald/47.jpg',0.5,'Latte',22,2,'Per tutti scremato, intero'),(48,'McDonald','Coffee',22,'images/negozi/McDonald/48.jpg',1,'Te Caldo',22,10,'Scegli un bel tÃ¨ per riscaldarti, avvolgerti e darti la carica giusta per affrontare la giornata.'),(49,'McDonald','Dessert',22,'images/negozi/McDonald/49.jpg',5,'McFlurry Oreo',21,5,'Lasciati incantare da un cremoso vortice di gelato, fatti conquistare dai suoi biscotti al cacao croccante, perditi nella dolcezza della sua crema al latte. '),(50,'McDonald','Dessert',22,'images/negozi/McDonald/50.jpg',6,'McFlurry Snickers',45,5,'Le arachidi croccanti e il caramello si sono uniti al vortice di gelato.'),(51,'McDonald','Dessert',22,'images/negozi/McDonald/51.jpg',5.5,'McFlurry Baci Perugina',21,5,'Cioccolato e croccanti noci'),(52,'McDonald','Dessert',22,'images/negozi/McDonald/52.jpg',5.4,'McFlurry Smarties',2,8,'Vortice di gustoso cioccolato smarties'),(53,'McDonald','Dessert',22,'images/negozi/McDonald/53.jpg',3.5,'Sweet Temptation cioccolato',22,1,'Quattro strati, Cremoso gelato fiordilatte, granella croccante, topping al gusto cioccolato e soffice panna '),(54,'McDonald','Dessert',22,'images/negozi/McDonald/54.jpg',3.5,'Sweet Temptation frutti di bosco',22,1,'Cremoso gelato fiordilatte, granella croccante, topping al gusto frutti di bosco e soffice panna '),(55,'McDonald','Dessert',22,'images/negozi/McDonald/55.jpg',3.8,'Sundae',22,1,'Disponibile fiordilatte oppure affogato ai gusti Cioccolato, Caramello, CaffÃ¨, baci peruggina e frutti di bosco'),(56,'McDonald','Dessert',22,'images/negozi/McDonald/56.jpg',2,'MilkShake',22,5,'che preferisci tra: fragola, cioccolato, vaniglia e banana'),(57,'Adidas','T Short Unisex',22,'images/negozi/Adidas/57.jpg',25,'Maglia 3 Stripes',100,10,'Modello piÃ¹ amato fin dal suo debutto, nel 1973. Modello uomo'),(58,'Adidas','Short',22,'images/negozi/Adidas/58.jpg',22,'Short 3 Stripes',50,20,'Pantoloncini con tre linee classici '),(59,'Adidas','Short',22,'images/negozi/Adidas/59.jpg',18,'Short nuoto ',40,15,'design semlice e pulito di questi short da nuoto per indossare al mare o in piscina'),(61,'Adidas','Felpa',22,'images/negozi/Adidas/61.jpg',33,'Felpa Trefoil',26,22,'La struttura confortevole Ã¨ realizzata in morbidissima spugna di cotone'),(62,'Adidas','Felpa',22,'images/negozi/Adidas/62.jpg',35,'Hoodie Fast Release',34,20,'Realizzata in tessuto morbido e leggero, con cappuccio e collo alto ad imbuto'),(63,'Adidas','Felpa',22,'images/negozi/Adidas/63.jpg',33,'Hoddie Adidas',33,15,'Felpa con cappuccio a collo alto, ottimo per affrontare la partita'),(64,'Adidas','Giubino',22,'images/negozi/Adidas/64.jpg',42,'Giacca Idrorepellente',20,22,'Cappuccio e zip integrale, inclusa fodera mesh migliora la ventilazione e mantiene la pelle asciutta'),(65,'Adidas','Felpa',22,'images/negozi/Adidas/65.jpg',22,'Felpa Trefoil ',9,10,'Struttura confortevole Ã¨ realizzata in morbidissima spugna di cotone'),(66,'Adidas','Felpa',22,'images/negozi/Adidas/66.jpg',30,'Felpa Crewneck',21,18,'Collezione moderna, la collezione Adicolor trae spunto dalla storia'),(67,'Adidas','Completi',22,'images/negozi/Adidas/67.jpg',35,'Completo Gift',19,10,'comprende T Short con logo a trifoglio oversize'),(68,'Adidas','Completi',22,'images/negozi/Adidas/68.jpg',35,'Completo Trefoil Shorts tee',21,10,'Un classico dallo spirito moderno, Struttura in jersey di cotone assicura una sensazione di grande morbidenza'),(69,'Adidas','Short',22,'images/negozi/Adidas/69.jpg',18,'Track Pants SST',31,15,'Da donna , con 3 linee donano al capo uno stile inconfondibile. Realizzati in tricot'),(70,'Adidas','Giubino',22,'images/negozi/Adidas/70.jpg',28,'Track Jacket BB',22,20,'Nata nel 1967, track originale che rimane fedele al design originale grazie al collo alla coreana.'),(71,'Adidas','Short',22,'images/negozi/Adidas/71.jpg',15,'Short Fleece',22,5,'Short Junior con cordino regolabile sul girovita incarnano l\'autentico stile Adidas'),(72,'Adidas','Short',22,'images/negozi/Adidas/72.jpg',20,'Trank Pants',22,14,'Questi pantaloni assicurano una vestibilitÃ  stabile e avvolgente grazie ai pratici orli elasticizzati'),(73,'Adidas','Short',22,'images/negozi/Adidas/73.jpg',18,'Trunk Pants SST ',22,14,'Sfoggiano elemeti autentici 3 Stripes che donano al capo uno stile inconfondibile.'),(74,'Adidas','Felpa',22,'images/negozi/Adidas/74.jpg',22.5,'Hoddie Trefoil',21,15,'Questa felpa da donna sfoggia un logo del trifoglio anteriore'),(75,'Adidas','Felpa',22,'images/negozi/Adidas/75.jpg',25,'Hoddie Cropped',21,5,'Taglio corto, i loghi a vista su petto e maniche e il motivo con blocco di colore a contrasto sono i tratti distintivi di questa felpa con cappuccio'),(76,'Adidas','Giubino',22,'images/negozi/Adidas/76.jpg',28,'Hoddie Adidas Towel',18,15,'Giacca realizzata con cappuccio  Ã¨ realizzata in spugna di cotone'),(77,'Adidas','Felpa',22,'images/negozi/Adidas/77.jpg',22,'Felpa Trefoil Crewneck',10,10,'Struttura di spugna di cotone assicura morbidezza e comfort.'),(78,'Adidas','Completi',22,'images/negozi/Adidas/78.jpg',30,'Hoddie Tropicalage Cropped',14,10,'Vivace stampa Tropicale realizzata in ottima spugna di cotone.'),(79,'Adidas','T Short Unisex',22,'images/negozi/Adidas/79.jpg',18,'T Shirt pride',22,20,'T shirt si distingue per il profilo del Trifoglio in versione arcobaleno'),(80,'Adidas','T Short Unisex',22,'images/negozi/Adidas/80.jpg',16,'Top ',15,5,'Il design estivo senza maniche Ã¨ rifinito da 3 strisce a contrasto'),(81,'Adidas','T Short Unisex',22,'images/negozi/Adidas/81.jpg',18,'T Shirt Boyfriend',15,10,'Taglio ampio e la struttura in cotone assicura morbidezza e comfort'),(82,'Adidas','Giubino',22,'images/negozi/Adidas/82.jpg',28,'Giacca imbottita Varlite',18,15,'Giacca che assicura pracitÃ , leggerezza e protezione dal freddo, imbottitura in piumino offre calore e comfort'),(86,'Adidas','Zaino',22,'images/negozi/Adidas/86.jpg',35,'Zaino 3D Roll Top',30,5,'Motivo geometrico allover e pannelli in finta pelle che donano uno splendido effetto 3D. Include tasca aperta per pc, e tasca interne per telefono chiavi...'),(87,'Adidas','Zaino',22,'images/negozi/Adidas/87.jpg',32,'Zaino Linear Classic Daily',19,5,'Zaino capiente e robusto presenta una tasca esterna chiusura zip'),(88,'Adidas','Zaino',22,'images/negozi/Adidas/88.jpg',33,'Zaino 3 Stripes Power',25,1,'Il design di medie dimensioni con confortevoli spallacci ergonomici realizzati in mesh traspirante'),(89,'Adidas','Cappelli',22,'images/negozi/Adidas/89.jpg',18,'Berretto alla Blacks',4,15,'Berretto da rugby tessuto da knit elestacizzato'),(90,'Adidas','Calzini',22,'images/negozi/Adidas/90.jpg',10,'Calze Mid Cut',0,20,'Tre paia , versatile design e confortovole struttura leggermente elasticizzato'),(91,'Adidas','Cappelli',22,'images/negozi/Adidas/91.jpg',15,'Classic Six Panel',8,10,'Cappellino a sei pannelli offre tutta la protezione di cui hai bisogno. Dotato di fascia interna traspirante'),(92,'Adidas','Cappelli',22,'images/negozi/Adidas/92.jpg',19,'Sic Panel Classic 3 Stripes',12,15,'Realizzato in Climalite allontana l\'umiditÃ  dalla pelle offrendo un comfort ottimale.'),(93,'Adidas','Zaino',22,'images/negozi/Adidas/93.jpg',25,'Trefoil Classic',14,1,'Zaino  confortevole  molto spazioso adatto per la scuola'),(94,'Adidas','Zaino',22,'images/negozi/Adidas/94.jpg',15,'Mini Bag Vintage',15,20,'Borsello portatile molto leggero con doppia tasca'),(95,'Adidas','Cappelli',20,'images/negozi/Adidas/95.jpg',18,'Adicolor Bucket',21,12,'Essenziale e robusto, presenta una struttura in twill di cotone'),(96,'Adidas','Scarpe',22,'images/negozi/Adidas/96.webp',70,'Scarpe Sabalo',100,20,'Esclusivo look per immortalare trick e acrobazie sullo skate, realizzate in tela leggera, traspiranti'),(97,'Adidas','Scarpe',22,'images/negozi/Adidas/97.webp',80,'Scarpe Gazelle ',150,15,'Rendono omaggio al modello del 1991, tomaia in pelle e un rinforzo sul tallone'),(98,'Adidas','Scarpe',18,'images/negozi/Adidas/98.webp',120,'Scaroe Marathone Teck',69,30,'Tomaia retro combina mesh traspirante e suede sintetico, ideale per la corsa'),(99,'Adidas','Scarpe',22,'images/negozi/Adidas/99.webp',99.99,'Scarpe Deepurt Runner',50,20,'Rivestimento a rete avvolge la tomaia e l\'intersuola, struttura flessibile e ripiegabile le rende facilmente trasportabili'),(100,'Adidas','Scarpe',22,'images/negozi/Adidas/100.webp',89.99,'Scarpe Busenitz Pro',34,20,'Dotate di collo con ammortizzazione GEOFIT e occhielli rinforzati'),(101,'Adidas','Scarpe',22,'images/negozi/Adidas/101.webp',150,'Scarpe NMD CS1',45,22,'Scarpe futuristiche sono caratterizzate da una tomaia '),(102,'AyurvedaBook','Informatica',22,'images/negozi/AyurvedaBook/102.action.jfif',42.5,'Reti di calcolatori',20,10,'La piÃ¹ classica e apprezzata introduzione al mondo delle reti, che tratta le tecnologie chiave nel mondo delle telecomunicazioni.'),(103,'AyurvedaBook','Informatica',22,'images/negozi/AyurvedaBook/103.action (1).jfif',38.9,'Linguaggio C',10,15,'Scritto dall\'inventore del linguaggio Ritchie, Ã¨ un classico universalmente noto e apprezzato, su cui si sono formate generazioni di studenti e programmatori'),(104,'AyurvedaBook','Design',22,'images/negozi/AyurvedaBook/104.action (2).jfif',45.5,'Responsive Design',5,22,'Questo libro mostra come adattarsi al nuovo'),(105,'AyurvedaBook','Design',22,'images/negozi/AyurvedaBook/105.action (3).jfif',38,'Game Design',15,18,'In questo momento storico il gioco risulta essere sempre piÃ¹ presente nelle nostre vite, non solo quale attivitÃ  diffusa e praticata, ma anche come veicolo per la comunicazione di contenuti e la trasmissione di buone pratiche.'),(106,'AyurvedaBook','Informatica',22,'images/negozi/AyurvedaBook/106.action (4).jfif',36.5,'Strutture di dati e algoritmi',20,10,'Strutture dati spiegate in modo approfondito e come servono a risolvere problemi classici, con algoritmi basati su di essi.'),(107,'AyurvedaBook','Design',22,'images/negozi/AyurvedaBook/107.action (5).jfif',48,'Dreamweaver CSS',18,20,'Dato il numero sempre maggiore di utenti che accedono a Internet tramite dispositivi mobili, gli sviluppatori web devono creare siti Web e applicazioni che funzionino in modo coerente su tutte le principali piattaforme mobili. '),(108,'AyurvedaBook','Informatica',22,'images/negozi/AyurvedaBook/108.action (6).jfif',29.99,'Siti Web ',24,10,'L\'uso di dispositivi mobili sta per superclassare dispositivi come pc e laptop per utilizzi quotidiani e nella navigazione web'),(109,'AyurvedaBook','Informatica',22,'images/negozi/AyurvedaBook/109.action (7).jfif',36,'Html 5',5,1,'Una guida pratica, per tutti elementi di HTML 4 e 5 e XHTML, esempi di codice e molto altro...'),(110,'AyurvedaBook','Informatica',22,'images/negozi/AyurvedaBook/110.action (8).jfif',22,'XML',20,1,'illustra in modo dettagliato, chiaro e approfondito tutte le tematiche del XML'),(111,'AyurvedaBook','Letteratura',22,'images/negozi/AyurvedaBook/111.jpg',25,'Divina Commedia',20,10,'Libro di Dante Alighieri, descrive il suo sogno vissuto nell\'aldila.'),(112,'AyurvedaBook','Letteratura',22,'images/negozi/AyurvedaBook/112.jpg',22,'Ultime lettere di Jacopo Ortis',13,15,'Romanzo incentrato  sulla drammatica vicenda sentimentale del giovane protagonista, perdutamente innamorato'),(113,'AyurvedaBook','Letteratura',22,'images/negozi/AyurvedaBook/113.jpg',29,'I Promessi Sposi',20,1,'Alessandro Manzoni publica un romanzo tratto da una storia vera, due ragazzi decisi a sposarsi vedono imporsi contro un ricco benestante Don rodirigo...'),(114,'AyurvedaBook','Letteratura',22,'images/negozi/AyurvedaBook/114.jpg',42,'Decamerone',20,20,'Boccaccio scrisse 100 novelle per dieci giorni, dove narra di un gruppo di ragazzi e le loro vicende'),(115,'AyurvedaBook','Letteratura',22,'images/negozi/AyurvedaBook/115.jpg',45,'Il fu Mattia Pascal',20,10,'Pirandello, pubblico il romanzo nel 1904, narra la storia di un timido provinciale Mattia Pascal, che si allontana di casa dopo una delle solite liti con la moglie, si allontana e simula la sua morte per rifarsi la vita.'),(116,'AyurvedaBook','Letteratura',22,'images/negozi/AyurvedaBook/116.jpg',35,'Se questo e un uomo',10,10,'Riassunto della terribile seconda guerra, vissuta in prima persona dal narrattore Primo Levi, nei campi di concentramento di Aushwitz'),(117,'AyurvedaBook','Letteratura',22,'images/negozi/AyurvedaBook/117.jpg',28,'Il Principe',15,1,'Nel prezioso trattato di Machiavelli si mescolano razionalitÃ  e passione, per dare vita al capolavoro ineguagliabile della letteratura politica. Introduzione di Nino Borsellino.'),(118,'AyurvedaBook','Letteratura',22,'images/negozi/AyurvedaBook/118.jpg',36,'I Malavoglia',5,5,'Giovanni Verga, descrive i piÃ¹ deboli della societa'),(119,'AyurvedaBook','Letteratura',22,'images/negozi/AyurvedaBook/119.jpg',39.99,'Uno nessuno e centomila',10,15,'Pirandello, A tutti Ã¨ capitato di stupirsi nello scoprire come gli altri possano avere un\'immagine di noi diversa dalla nostra, visto che noi sappiamo cosa c\'Ã¨ sotto la maschera e gli altri non vedono che questa, dal di fuori. '),(120,'AyurvedaBook','Storia',20,'images/negozi/AyurvedaBook/120.jpg',45,'Mondo Contemporaneo',10,22,'Parla del Novecento, e degli ultimi decenni'),(121,'AyurvedaBook','Storia',22,'images/negozi/AyurvedaBook/121.jpg',48,'archivio segreto di mussolini',20,25,'I carteggi personali e Dossier dell\'OVRA, ricatti e favori, intercettazioni e documenti privati di Benito Mussolini.'),(122,'AyurvedaBook','Storia',22,'images/negozi/AyurvedaBook/122.jpg',38,'La Grande Guerra',25,30,'Nell\'agosto 1914 ha inizio la prima guerra di massa della storia, un conflitto che lascerÃ  nelle coscienze dei protagonisti il segno di un cambiamento epocale. Simbolo '),(123,'AyurvedaBook','Storia',22,'images/negozi/AyurvedaBook/123.jpg',38,'Storia Contemporanea',25,25,'Il Novecento, un secolo che si apre col trauma originario della Grande Guerra e si chiude con le trasformazioni seguite alla caduta del muro di Berlino. '),(124,'AyurvedaBook','Storia',22,'images/negozi/AyurvedaBook/124.jpg',45,'Storia Romana',22,40,'Parla del Grande Impero Romano da sotto tutti i punti artistico '),(125,'AyurvedaBook','Storia',22,'images/negozi/AyurvedaBook/125.jpg',39.6,'Storia Moderna',10,23,'Dalle scoperte geografiche e dall\'espansione economica del 500 all\'eta napoleonica');
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `riferimento` VALUES (16,30,'McDonald','Panini','',3,18,12.5,22),(17,30,'McDonald','Panini','',4,15,15.5,22),(41,32,'McDonald','Nuggets','',3,1,15,22),(44,33,'McDonald','Coffee','',3,2,1,22),(49,31,'McDonald','Dessert','',1,5,5,22),(50,36,'McDonald','Dessert','88yuo',5,5,6,22),(51,31,'McDonald','Dessert','',1,5,5.5,22),(52,32,'McDonald','Dessert','',20,8,5.4,22),(60,31,'Adidas','bikini e short','',1,15,18,22),(61,28,'Adidas','Felpa','',3,22,33,22),(61,31,'Adidas','Felpa','',1,22,33,22),(62,31,'Adidas','Felpa','',1,20,35,22),(63,28,'Adidas','Felpa','',1,15,33,22),(63,31,'Adidas','Felpa','',1,15,33,22),(65,31,'Adidas','Felpa','',1,10,22,22),(66,31,'Adidas','Felpa','',1,18,30,22),(67,31,'Adidas','Completi','',1,10,35,22),(68,31,'Adidas','Completi','',1,10,35,22),(74,31,'Adidas','Felpa','',1,15,22.5,22),(75,31,'Adidas','Felpa','',1,5,25,22),(77,28,'Adidas','Felpa','',4,10,22,22),(78,31,'Adidas','Completi','',1,10,30,22),(83,31,'Adidas','bikini e short','',1,5,22,22),(84,31,'Adidas','bikini e short','',1,8,29,22),(85,31,'Adidas','bikini e short','',1,1,22,22),(87,28,'Adidas','Zaino','',1,5,32,22),(89,28,'Adidas','Cappelli','',3,15,18,22),(89,31,'Adidas','Cappelli','',1,15,18,22),(90,30,'Adidas','Calzini','',3,20,10,22),(91,31,'Adidas','Cappelli','',1,10,15,22),(92,31,'Adidas','Cappelli','',1,15,19,22),(92,32,'Adidas','Cappelli','medium\nmedium',2,15,19,22),(93,28,'Adidas','Zaino','',1,1,25,22),(95,31,'Adidas','Cappelli','',1,12,18,20),(100,28,'Adidas','Scarpe','',1,20,89.99,22),(104,29,'AyurvedaBook','Design','',4,22,45.5,22),(104,31,'AyurvedaBook','Design','',1,22,45.5,22),(104,32,'AyurvedaBook','Design','',3,22,45.5,22),(104,35,'AyurvedaBook','Design','',1,22,45.5,22),(104,38,'AyurvedaBook','Design','',1,22,45.5,22),(105,29,'AyurvedaBook','Design','',3,18,38,22),(107,31,'AyurvedaBook','Design','\n',2,20,48,22),(127,34,'Manlio','afssdfsad','',3,22,33,33);
/*!40000 ALTER TABLE `riferimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venditore`
--

DROP TABLE IF EXISTS `venditore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venditore` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sesso` varchar(6) DEFAULT NULL,
  `telefono` varchar(15) NOT NULL,
  `via` varchar(45) NOT NULL,
  `città` varchar(45) NOT NULL,
  `cap` varchar(5) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `Indirizzo` (`via`,`città`,`cap`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venditore`
--

LOCK TABLES `venditore` WRITE;
/*!40000 ALTER TABLE `venditore` DISABLE KEYS */;
INSERT INTO `venditore` VALUES ('aaaaa','Aaaaa98#','aefsda','asdad','csdfsfgs@gmail.com','M','4234234243','dssdg','sdfsdg','34322'),('aaaaaa','Aaaaa98#','aa','asfad','asdfasd@gasdg.it','M','32342343212','dfasdf','sdfsdf','32432'),('adidas','Adidas2#','Adolf','Dassler','adidasstore@gmail.com','M','0000000000','Shoutd','Herzogenaurach','30124'),('ayurvedico','Ayurvedico3#','Vector','Exudus','exudus@gmail.com','M','3249989234','Piazza Duomo ','Milano','20121'),('manlio','Manlio1#','manlio','ccc','ccc@gmail.com','M','3245445454','fafdaf','sfsdfsd','55555'),('mcdonald','Mcdonald1#','DickMac','McDonald','mcdonald@gmail.com','M','0000000000','Oki Broown','Chicago','10020');
/*!40000 ALTER TABLE `venditore` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-20 16:36:10
