-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_gestao
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `agenda` (
  `dataCriacaoAgenda` date DEFAULT NULL,
  `dataCompromissoAgenda` varchar(20) DEFAULT NULL,
  `codigoColaboradorAgenda` int(3) DEFAULT NULL,
  `codigoEquipeAgenda` int(3) DEFAULT NULL,
  `tituloAgenda` varchar(30) DEFAULT NULL,
  `descricaoAgenda` varchar(50) DEFAULT NULL,
  KEY `agendaColaboradorPK_idx` (`codigoColaboradorAgenda`),
  KEY `agendaEquipePK_idx` (`codigoEquipeAgenda`),
  CONSTRAINT `agendaColaboradorPK` FOREIGN KEY (`codigoColaboradorAgenda`) REFERENCES `colaborador` (`idColaborador`),
  CONSTRAINT `agendaEquipePK` FOREIGN KEY (`codigoEquipeAgenda`) REFERENCES `equipe` (`idEquipe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colaborador`
--

DROP TABLE IF EXISTS `colaborador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `colaborador` (
  `idColaborador` int(2) NOT NULL AUTO_INCREMENT,
  `nomeColaborador` varchar(40) DEFAULT NULL,
  `idadeColaborador` int(3) DEFAULT NULL,
  `tipoColaborador` varchar(20) DEFAULT NULL,
  `cpfColaborador` varchar(30) DEFAULT NULL,
  `emailColaborador` varchar(30) DEFAULT NULL,
  `celularColaborador` varchar(30) DEFAULT NULL,
  `usuarioColaborador` varchar(20) DEFAULT NULL,
  `senhaColaborador` varchar(20) DEFAULT NULL,
  `equipeColaborador` int(4) DEFAULT NULL,
  `ruaColaborador` varchar(40) DEFAULT NULL,
  `bairroColaborador` varchar(30) DEFAULT NULL,
  `cidadeColaborador` varchar(30) DEFAULT NULL,
  `complementoColaborador` varchar(40) DEFAULT NULL,
  `cepColaborador` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idColaborador`),
  KEY `equipeColaboradorPK_idx` (`equipeColaborador`),
  CONSTRAINT `equipeColaboradorPK` FOREIGN KEY (`equipeColaborador`) REFERENCES `equipe` (`idEquipe`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colaborador`
--

LOCK TABLES `colaborador` WRITE;
/*!40000 ALTER TABLE `colaborador` DISABLE KEYS */;
INSERT INTO `colaborador` VALUES (1,'Cristian',23,'Gerente','097.977.949-97','cristianratzmann@gmail.com','989180446','Cristian','123456',1,'Rua Francisco Jacob Khnis','Limoeiro','Brusque','Casa','88318-520');
/*!40000 ALTER TABLE `colaborador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `equipe` (
  `idEquipe` int(4) NOT NULL AUTO_INCREMENT,
  `nomeEquipe` varchar(20) DEFAULT NULL,
  `descricaoEquipe` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idEquipe`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (1,'Vendas','Vendedores');
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-07 21:30:27
