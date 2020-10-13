-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: kinoxp
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinema` (
  `cinema_id` int NOT NULL AUTO_INCREMENT,
  `seats` int NOT NULL,
  PRIMARY KEY (`cinema_id`),
  UNIQUE KEY `cinema_id_UNIQUE` (`cinema_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema`
--

LOCK TABLES `cinema` WRITE;
/*!40000 ALTER TABLE `cinema` DISABLE KEYS */;
INSERT INTO `cinema` VALUES (1,40),(2,70),(3,120);
/*!40000 ALTER TABLE `cinema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genres` (
  `genres_id` int NOT NULL AUTO_INCREMENT,
  `genre` varchar(45) NOT NULL,
  PRIMARY KEY (`genres_id`),
  UNIQUE KEY `genres_id_UNIQUE` (`genres_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (1,'Sci-Fi'),(2,'Erotic'),(3,'Action'),(4,'Romance Comedy'),(5,'Comedy');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `movie_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `duration` time NOT NULL,
  `age_limit` int NOT NULL,
  `genres_id` int NOT NULL,
  PRIMARY KEY (`movie_id`),
  UNIQUE KEY `Movie_ID_UNIQUE` (`movie_id`),
  KEY `fk_movies_genres1_idx` (`genres_id`),
  CONSTRAINT `fk_movies_genres1` FOREIGN KEY (`genres_id`) REFERENCES `genres` (`genres_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Invaders from the Moon','Joey thought it was just another normal day at the farm. He was so wrong ...','01:25:00',12,1),(2,'The new coworker','He never thought it can rise so high, but then he met her.','00:50:00',18,2),(3,'Payday','What should you do when the gouvernment steals from you. Johan took a bloody approach.','01:45:00',12,3),(4,'How I met your step-brother','Anna and Zoey thought that puberty is bad, until they have met Zoey new step-brother. Their lives were not the same.','01:00:00',12,4),(5,'What I did in Vegas','So what is in Vegas? There is desert, there are casinos, there are cheap hookers, and then ther is Mr. Chau.','01:15:00',12,5);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies_has_schedule`
--

DROP TABLE IF EXISTS `movies_has_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies_has_schedule` (
  `movies_movie_id` int NOT NULL,
  `schedule_schedule_id` int NOT NULL,
  PRIMARY KEY (`movies_movie_id`,`schedule_schedule_id`),
  KEY `fk_movies_has_schedule_schedule1_idx` (`schedule_schedule_id`),
  KEY `fk_movies_has_schedule_movies_idx` (`movies_movie_id`),
  CONSTRAINT `fk_movies_has_schedule_movies` FOREIGN KEY (`movies_movie_id`) REFERENCES `movies` (`movie_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_movies_has_schedule_schedule1` FOREIGN KEY (`schedule_schedule_id`) REFERENCES `schedule` (`schedule_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies_has_schedule`
--

LOCK TABLES `movies_has_schedule` WRITE;
/*!40000 ALTER TABLE `movies_has_schedule` DISABLE KEYS */;
INSERT INTO `movies_has_schedule` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `movies_has_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `start` timestamp NOT NULL,
  `end` timestamp NOT NULL,
  `cinema_id` int DEFAULT NULL,
  PRIMARY KEY (`schedule_id`),
  UNIQUE KEY `schedule_id_UNIQUE` (`schedule_id`),
  KEY `cinema_id_idx` (`cinema_id`),
  CONSTRAINT `cinema_id` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`cinema_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'2020-10-15 08:00:00','2020-10-15 09:25:00',1),(2,'2020-10-15 10:00:00','2020-10-15 10:50:00',1),(3,'2020-10-15 11:00:00','2020-10-15 12:45:00',1),(4,'2020-10-15 13:00:00','2020-10-15 14:00:00',2),(5,'2020-10-15 14:15:00','2020-10-15 15:30:00',3);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `ticket_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `seat_name` varchar(45) NOT NULL,
  `movie_id` int NOT NULL,
  `schedule_id` int NOT NULL,
  PRIMARY KEY (`ticket_id`),
  UNIQUE KEY `ticket_id_UNIQUE` (`ticket_id`),
  KEY `movie_id_idx` (`movie_id`),
  KEY `schedule_id_idx` (`schedule_id`),
  CONSTRAINT `movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`),
  CONSTRAINT `schedule_id` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'Thomas','A12',1,1),(2,'Dorin','A13',1,1),(3,'Christian','C15',1,1),(4,'Nesrin','B7',2,2),(5,'Marianna','B8',2,2),(6,'Ilias ','C12',4,4),(7,'Dagmara','D19',5,5),(8,'Alexandru','E4',3,3),(9,'Marianne Teacher','D9',5,5);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-13 10:40:09

DROP TABLE IF EXISTS `extras`;

CREATE TABLE `kinoxp`.`extras` (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  price DOUBLE NOT NULL,
  stock INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
  UNIQUE INDEX name_UNIQUE (name ASC) VISIBLE)
ENGINE = InnoDB;

INSERT INTO kinoxp.`extras` VALUES
(1, "popcorn", 25.0, 100),
(2, "soda", 10, 500),
(3, "cola", 30, 50),
(4, "nachos", 80, 30),
(5, "candy floss", 50, 80);