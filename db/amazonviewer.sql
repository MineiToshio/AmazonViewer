CREATE DATABASE  IF NOT EXISTS `amazonviewer` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `amazonviewer`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: amazonviewer
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'movie'),(2,'serie'),(3,'chapter'),(4,'book'),(5,'magazine');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `creator` varchar(255) NOT NULL,
  `duration` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (6,'Coco','Animación','Pixart',120,2017),(7,'Titanic','Drama','James Cameron',195,1997),(8,'Avatar','Ficción','James Cameron',161,2009),(9,'Amélie','Romance','Jean-Pierre Jeunet',123,2001),(10,'Sombra del Agua','Drama-Fantasía','Guillermo del Toro',123,2017);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ann');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viewed`
--

DROP TABLE IF EXISTS `viewed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `viewed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_material` int(11) NOT NULL,
  `id_element` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viewed`
--

LOCK TABLES `viewed` WRITE;
/*!40000 ALTER TABLE `viewed` DISABLE KEYS */;
INSERT INTO `viewed` VALUES (5,1,7,1,'2018-06-25 13:09:36'),(6,1,6,1,'2018-06-25 13:10:37'),(7,1,0,1,'2018-06-25 14:29:43'),(8,1,0,1,'2018-06-25 14:29:53'),(9,1,0,1,'2018-06-25 14:30:15'),(10,1,0,1,'2018-06-25 14:30:24'),(11,1,0,1,'2018-06-25 15:15:03'),(12,1,0,1,'2018-06-25 15:25:16'),(13,1,0,1,'2018-06-25 15:28:21'),(14,1,0,1,'2018-06-25 15:29:25'),(15,1,0,1,'2018-06-25 15:29:57'),(16,1,0,1,'2018-06-25 15:38:36'),(17,1,0,1,'2018-06-25 15:40:12'),(18,1,0,1,'2018-06-25 15:41:29'),(19,1,0,1,'2018-06-25 16:49:20'),(20,1,0,1,'2018-06-25 16:50:47'),(21,1,0,1,'2018-06-25 17:20:06'),(22,1,0,1,'2018-06-25 17:27:44'),(23,1,0,1,'2018-06-25 17:37:29'),(24,1,0,1,'2018-06-25 17:43:50'),(25,1,0,1,'2018-06-26 00:27:03'),(26,1,0,1,'2018-06-26 00:29:01'),(27,1,0,1,'2018-06-26 00:29:18'),(28,1,0,1,'2018-06-26 01:01:09'),(29,1,0,1,'2018-06-26 01:03:04'),(30,1,0,1,'2018-06-26 01:05:38');
/*!40000 ALTER TABLE `viewed` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-26 17:22:13
