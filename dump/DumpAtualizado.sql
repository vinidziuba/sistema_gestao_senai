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
  CONSTRAINT `agendaColaboradorPK` FOREIGN KEY (`codigoColaboradorAgenda`) REFERENCES `colaborador` (`idColaborador`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `agendaEquipePK` FOREIGN KEY (`codigoEquipeAgenda`) REFERENCES `equipe` (`idEquipe`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES ('2019-03-16','31/22/1321',NULL,NULL,'sadasds','sadasd'),('2019-03-16','32/13/2132',2,5,'sdsad','sadsad'),('2019-03-16','32/13/2132',2,1,'sdsad','sadsad'),('2019-03-16','32/13/2132',2,2,'sdsad','sadsad'),('2019-03-16','12/31/2312',2,4,'assad','asdsad'),('2019-03-16','16/03/1999',2,1,'Titulo','Descrição'),('2019-03-16','12/32/1321',2,1,'aaaaa','aaaaa');
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
  `cepColaborador` int(12) DEFAULT NULL,
  PRIMARY KEY (`idColaborador`),
  KEY `equipeColaboradorPK_idx` (`equipeColaborador`),
  CONSTRAINT `equipeColaboradorPK` FOREIGN KEY (`equipeColaborador`) REFERENCES `equipe` (`idEquipe`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colaborador`
--

LOCK TABLES `colaborador` WRITE;
/*!40000 ALTER TABLE `colaborador` DISABLE KEYS */;
INSERT INTO `colaborador` VALUES (2,'Cristian Ratzmann',23,'Selecione','097.977.949-97','cristianratzmann@gmail.com','(  )     -    ','Cristian','123456',1,'Erico Fucnker','Cedrinho','Brusque','Casa',88358045);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (1,'Vendas','Vendedores'),(2,'Rh','Contratações'),(3,'Almoxarifado','Cuidar Estoque'),(4,'Contabilidade','Contas a pagar'),(5,'Vendas','vendas'),(6,'cristian','cristian'),(7,'Recepção','Atendimento'),(8,'Logística','Cargas');
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sistema_gestao'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-20 18:54:15
