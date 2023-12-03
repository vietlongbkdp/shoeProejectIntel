-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: shoeproject
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `cart_details`
--

DROP TABLE IF EXISTS `cart_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `cart_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9rlic3aynl3g75jvedkx84lhv` (`product_id`),
  KEY `FKkcochhsa891wv0s9wrtf36wgt` (`cart_id`),
  CONSTRAINT `FK9rlic3aynl3g75jvedkx84lhv` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FKkcochhsa891wv0s9wrtf36wgt` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_details`
--

LOCK TABLES `cart_details` WRITE;
/*!40000 ALTER TABLE `cart_details` DISABLE KEYS */;
INSERT INTO `cart_details` VALUES (1,200.00,1,1,24),(2,200.00,1,1,23),(3,100.00,1,1,18),(4,100.00,1,1,15),(5,150.00,3,1,28),(6,150.00,2,1,14);
/*!40000 ALTER TABLE `cart_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `total_amount` decimal(19,2) DEFAULT NULL,
  `customer_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8ba3sryid5k8a9kidpkvqipyt` (`customer_id`),
  CONSTRAINT `FK8ba3sryid5k8a9kidpkvqipyt` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES (1,0.00,1);
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorys`
--

DROP TABLE IF EXISTS `categorys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorys` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name_category` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorys`
--

LOCK TABLES `categorys` WRITE;
/*!40000 ALTER TABLE `categorys` DISABLE KEYS */;
INSERT INTO `categorys` VALUES (1,'Sneakers'),(2,'Flats'),(3,'Sandals'),(4,'Heels');
/*!40000 ALTER TABLE `categorys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colors`
--

DROP TABLE IF EXISTS `colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name_color` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
INSERT INTO `colors` VALUES (1,'black'),(2,'blue'),(3,'red'),(4,'green'),(5,'white');
/*!40000 ALTER TABLE `colors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companys`
--

DROP TABLE IF EXISTS `companys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companys` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name_company` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companys`
--

LOCK TABLES `companys` WRITE;
/*!40000 ALTER TABLE `companys` DISABLE KEYS */;
INSERT INTO `companys` VALUES (1,'Nike'),(2,'Adidas'),(3,'Puma'),(4,'Vans');
/*!40000 ALTER TABLE `companys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'13 Trần Quý Khoáng','vietlongbkdp@gmail.com','Nguyễn Viết Long','0913331916');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `img` varchar(255) NOT NULL,
  `new_price` decimal(19,2) NOT NULL,
  `prev_price` decimal(19,2) NOT NULL,
  `reviews` int DEFAULT NULL,
  `star` int DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `category_id` bigint NOT NULL,
  `color_id` bigint NOT NULL,
  `company_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr638shrnkkh3wy5llr9cwyi4t` (`category_id`),
  KEY `FKebociq5k3b2tkcxh3q5dg4eed` (`color_id`),
  KEY `FK96m0mnyfjlgmxi61v42sjkbut` (`company_id`),
  CONSTRAINT `FK96m0mnyfjlgmxi61v42sjkbut` FOREIGN KEY (`company_id`) REFERENCES `companys` (`id`),
  CONSTRAINT `FKebociq5k3b2tkcxh3q5dg4eed` FOREIGN KEY (`color_id`) REFERENCES `colors` (`id`),
  CONSTRAINT `FKr638shrnkkh3wy5llr9cwyi4t` FOREIGN KEY (`category_id`) REFERENCES `categorys` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'https://m.media-amazon.com/images/I/6125yAfsJKL._AC_UX575_.jpg',200.00,140.00,123,4,'Nike Air Monarch IV',1,5,1),(2,'https://m.media-amazon.com/images/I/519MRhRKGFL._AC_UX575_.jpg',200.00,140.00,123,4,'Nike Air Vapormax Plus',1,3,1),(3,'https://m.media-amazon.com/images/I/51+P9uAvb1L._AC_UY695_.jpg',200.00,140.00,123,4,'Nike Waffle One Sneaker',1,4,1),(4,'https://m.media-amazon.com/images/I/71oEKkghg-L._AC_UX575_.jpg',200.00,140.00,123,4,'Nike Running Shoe',1,1,2),(5,'https://m.media-amazon.com/images/I/41M54ztS6IL._AC_SY625._SX._UX._SY._UY_.jpg',200.00,140.00,123,4,'Flat Slip On Pumps',2,4,4),(6,'https://m.media-amazon.com/images/I/71zKuNICJAL._AC_UX625_.jpg',150.00,140.00,123,4,'Knit Ballet Flat',2,2,1),(7,'https://m.media-amazon.com/images/I/61V9APfz97L._AC_UY695_.jpg',150.00,140.00,123,4,'Loafer Flats',2,5,4),(8,'https://m.media-amazon.com/images/I/71VaQ+V6XnL._AC_UY695_.jpg',200.00,140.00,123,4,'Nike Zoom Freak',1,4,1),(9,'https://m.media-amazon.com/images/I/61-cBsLhJHL._AC_UY695_.jpg',200.00,140.00,123,4,'Nike Men\'s Sneaker',2,2,2),(10,'https://m.media-amazon.com/images/I/81xXDjojYKS._AC_UX575_.jpg',150.00,140.00,123,4,'PUMA BLACK-OCE',1,4,3),(11,'https://m.media-amazon.com/images/I/71E75yRwCDL._AC_UY575_.jpg',150.00,140.00,123,4,'Pacer Future Sneaker',1,3,3),(12,'https://m.media-amazon.com/images/I/71jeoX0rMBL._AC_UX575_.jpg',150.00,140.00,123,4,'Unisex-Adult Super',1,1,3),(13,'https://m.media-amazon.com/images/I/61TM6Q9dvxL._AC_UX575_.jpg',150.00,140.00,123,4,'Roma Basic Sneaker',1,5,3),(14,'https://m.media-amazon.com/images/I/7128-af7joL._AC_UY575_.jpg',150.00,140.00,123,4,'Pacer Future Doubleknit',1,1,3),(15,'https://m.media-amazon.com/images/I/81xXDjojYKS._AC_UX575_.jpg',100.00,140.00,123,4,'Fusion Evo Golf Shoe',1,4,3),(16,'https://m.media-amazon.com/images/I/719gdz8lsTS._AC_UX575_.jpg',100.00,140.00,123,4,'Rainbow Chex Skate',2,3,4),(17,'https://m.media-amazon.com/images/I/71gpFHJlnoL._AC_UX575_.jpg',100.00,140.00,123,4,'Low-Top Trainers',3,5,4),(18,'https://m.media-amazon.com/images/I/71pf7VFs9CL._AC_UX575_.jpg',100.00,140.00,123,4,'Vans Unisex Low-Top',3,2,4),(19,'https://m.media-amazon.com/images/I/61N4GyWcHPL._AC_UY575_.jpg',150.00,140.00,123,4,'Classic Bandana Sneakers',3,1,1),(20,'https://m.media-amazon.com/images/I/61bncQ44yML._AC_UX695_.jpg',50.00,40.00,123,4,'Chunky High Heel',4,1,4),(21,'https://m.media-amazon.com/images/I/71czu7WgGuL._AC_UY695_.jpg',100.00,140.00,123,4,'Slip On Stiletto High Heel',4,1,3),(22,'https://m.media-amazon.com/images/I/61men05KRxL._AC_UY625_.jpg',150.00,140.00,123,4,'DREAM PAIRS Court Shoes',4,3,1),(23,'https://m.media-amazon.com/images/I/519MRhRKGFL._AC_UX575_.jpg',200.00,140.00,123,4,'Nike Air Vapormax Plus',1,3,1),(24,'https://m.media-amazon.com/images/I/51PGWTXgf-L._AC_UY625_.jpg',200.00,140.00,123,4,'Low Mid Block Heels',4,1,1),(25,'https://m.media-amazon.com/images/I/616sA5XUKtL._AC_UY675_.jpg',50.00,40.00,123,4,'Chunky High Heel',4,1,2),(26,'https://m.media-amazon.com/images/I/71h5+MbEK7L._AC_UY625_.jpg',150.00,140.00,123,4,'Amore Fashion Stilettos',4,5,2),(27,'https://m.media-amazon.com/images/I/61uw5RDxKQL._AC_UY625_.jpg',150.00,140.00,123,4,'Bridal Sandals Glitter',2,1,2),(28,'https://m.media-amazon.com/images/I/71yhoZP0l6L._AC_UY695_.jpg',150.00,140.00,123,4,'Wedding Prom Bridal',2,1,2);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shoeproject'
--

--
-- Dumping routines for database 'shoeproject'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-04  1:10:37
