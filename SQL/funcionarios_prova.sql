-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: funcionarios_prova
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `ID_FUNCIONARIO` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(150) DEFAULT NULL,
  `FK_SETOR` int NOT NULL,
  `NU_SALARIO` double DEFAULT NULL,
  `DS_EMAIL` varchar(99) DEFAULT NULL,
  `NU_IDADE` int DEFAULT NULL,
  PRIMARY KEY (`ID_FUNCIONARIO`,`FK_SETOR`),
  KEY `fk_Funcionario_Setor_idx` (`FK_SETOR`),
  CONSTRAINT `FK2peemlj28pdi3f8sp2ef28hhf` FOREIGN KEY (`FK_SETOR`) REFERENCES `setor` (`ID_SETOR`),
  CONSTRAINT `fk_Funcionario_Setor` FOREIGN KEY (`FK_SETOR`) REFERENCES `setor` (`ID_SETOR`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Bruce Banner',2,5000,'brucebanner@email.com',32),(2,'Barry Allen',1,5000,'barryallen@email.com',26),(4,'Peter Parker',2,2000,'peterparker@email.com',19),(5,'Natasha Romannoff',3,6000,'natasharomannoff@email.com',32),(8,'Adam Jensen',4,4000,'adamjensen@email.com',34),(26,'Paulo Vitor',6,4000,'paulovitor@email.com',34),(31,'Panam Palmer',5,3000,'panampalmer@email.com',24);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setor` (
  `ID_SETOR` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`ID_SETOR`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setor`
--

LOCK TABLES `setor` WRITE;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
INSERT INTO `setor` VALUES (1,'Recursos Humanos'),(2,'Tecnologia da Informa????o'),(3,'Financeiro'),(4,'Seguran??a'),(5,'Entregas'),(6,'Administrativo');
/*!40000 ALTER TABLE `setor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-29 18:12:02
