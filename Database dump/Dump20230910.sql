CREATE DATABASE  IF NOT EXISTS `online_clothing_store` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `online_clothing_store`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: online_clothing_store
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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `line1` varchar(100) DEFAULT NULL,
  `line2` varchar(100) DEFAULT NULL,
  `pin_code` int DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1fa36y2oqhao3wgg2rw1pi459` (`user_id`),
  CONSTRAINT `FK1fa36y2oqhao3wgg2rw1pi459` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offers`
--

DROP TABLE IF EXISTS `offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `minimum_purchase_amount` double DEFAULT NULL,
  `offer_description` varchar(255) DEFAULT NULL,
  `offer_name` varchar(255) DEFAULT NULL,
  `promo_code` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offers`
--

LOCK TABLES `offers` WRITE;
/*!40000 ALTER TABLE `offers` DISABLE KEYS */;
/*!40000 ALTER TABLE `offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_amount` double DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `tax` double DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`),
  CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1000,'2023-08-29','PLACED',100,1),(2,5000,'2023-08-29','PLACED',500,2),(3,10000,'2023-08-29','PLACED',555,2);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_products`
--

DROP TABLE IF EXISTS `orders_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_products` (
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  KEY `FK43vke5jd6eyasd92t3k24kdxq` (`product_id`),
  KEY `FKe4y1sseio787e4o5hrml7omt5` (`order_id`),
  CONSTRAINT `FK43vke5jd6eyasd92t3k24kdxq` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FKe4y1sseio787e4o5hrml7omt5` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_products`
--

LOCK TABLES `orders_products` WRITE;
/*!40000 ALTER TABLE `orders_products` DISABLE KEYS */;
INSERT INTO `orders_products` VALUES (1,1),(1,1),(2,3),(2,3),(3,1);
/*!40000 ALTER TABLE `orders_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `payment_timestamp` date DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlouu98csyullos9k25tbpk4va` (`order_id`),
  KEY `FKmi2669nkjesvp7cd257fptl6f` (`user_id`),
  CONSTRAINT `FKlouu98csyullos9k25tbpk4va` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKmi2669nkjesvp7cd257fptl6f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,10001,'UPI','PENDING','2023-08-29',1,1),(2,5000,'NET_BANKNG','COMPLETED','2023-08-29',2,2);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_images`
--

DROP TABLE IF EXISTS `product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` longblob,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqnq71xsohugpqwf3c9gxmsuy` (`product_id`),
  CONSTRAINT `FKqnq71xsohugpqwf3c9gxmsuy` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_images`
--

LOCK TABLES `product_images` WRITE;
/*!40000 ALTER TABLE `product_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_offer`
--

DROP TABLE IF EXISTS `product_offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_offer` (
  `product_id` int NOT NULL,
  `offer_id` int NOT NULL,
  KEY `FKa7pqj5t1r2ma1qysqbh43q43q` (`offer_id`),
  KEY `FKfc56r9trqgvlovuclmnxd917j` (`product_id`),
  CONSTRAINT `FKa7pqj5t1r2ma1qysqbh43q43q` FOREIGN KEY (`offer_id`) REFERENCES `offers` (`id`),
  CONSTRAINT `FKfc56r9trqgvlovuclmnxd917j` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_offer`
--

LOCK TABLES `product_offer` WRITE;
/*!40000 ALTER TABLE `product_offer` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `occasion` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'SHIRT','BLUE','shirt',20,'MALE','images/shirt2.jpg','COTTON','Shirt','CASUAL',1000,'M',8,'FORMAL'),(2,'TROUSER','BLACK','Trousers for men',20,'MALE','images/04b2b0be3618630099e2b6c65624ab23.jpg','COTTON','Trousers','CASUAL',1000,'M',10,'FORMAL'),(3,'JACKET','BLACK','Jacket for men',20,'MALE','images/c38855739c8271f7f9accef444469823.jpg','LEATHER','Jacket','CASUAL',1000,'M',9,'FORMAL'),(4,'SHIRT','PINK','Pink Shirt for men',10,'MALE','images/shirt1.jpg','COTTON','Pink Shirt','CASUAL',1000,'M',10,'FORMAL'),(5,'CAP','RED','red had for men',20,'MALE','images/red_hat.jpg','COTTON','Red Hat ','CASUAL',5000,'M',10,'CASUAL'),(6,'SAREE','BLUE','Blue Saree for women',20,'FEMALE','images/blue_saree.jpg','COTTON','Blue Saree','TRADITIONAL',4000,'M',5,'CLASSIC'),(7,'SAREE','RED','Red Saree for women',15,'FEMALE','images/pink_saree.jpg','COTTON','Red Saree','TRADITIONAL',5000,'L',10,'CLASSIC'),(8,'DRESS','YELLO','Yellow dress for women',15,'FEMALE','images/yellow_dress.jpg','POLYSTER','Yellow Dress','TRADITIONAL',2500,'M',10,'CLASSIC'),(9,'HAT','BROWN','Brown hat for men',15,'MALE','images/brown_hat_men.jpg','COTTON','Brown Hat','CASUAL',499,'L',3,'CASUAL'),(10,'HAT','PURPLE','Purple hat for men',20,'MALE','images/purple_hat.jpg','POLYSTER','Purple Hat','CASUAL',399,'L',5,'CASUAL'),(11,'T_SHIRT','ORANGE','Orangle T-Shirt for men',20,'MALE','images/orange_tshirt.jpg','COTTON','Orange T-Shirt ','CASUAL',899,'XL',10,'CASUAL'),(12,'T_SHIRT','PINK','PinkT-Shirt for men',20,'MALE','images/pink_tshirt.jpg','COTTON','Pink T-Shirt ','CASUAL',999,'M',10,'CASUAL'),(13,'KURTA','BROWN','Brown Kurta for men',10,'MALE','images/brown_kurta.jpg','COTTON','Brown Kurta','TRADITIONAL',799,'L',5,'ETHNIC'),(14,'SWEATER','BROWN','Checked Sweater for men',15,'MALE','images/checked_sweater.jpg','WOOL','Checked Sweater','CASUAL',1299,'XL',10,'CASUAL'),(15,'JEANS','BLUE','Blue jeans fro men',25,'MALE','images/blue_jeans.jpg','COTTON','Blue Jeans','CASUAL',1499,'L',3,'CASUAL'),(16,'SHORTS','BLUE','Brown Shorts for men',35,'MALE','images/brown_shorts.jpg','COTTON','Brown Shorts','CASUAL',1299,'XL',4,'CASUAL'),(17,'PAJAMAS','BLUE','White pajamas for men',25,'MALE','images/white_pajamas.jpg','COTTON','White Pajamas','CASUAL',1399,'L',10,'CASUAL');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_and_exchange`
--

DROP TABLE IF EXISTS `return_and_exchange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `return_and_exchange` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reason_for_return` varchar(255) DEFAULT NULL,
  `return_status` varchar(255) DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKto2lp2637vrk0w1olwbjpldcq` (`order_id`),
  KEY `FKdw323d5djd0hiqygxjypswonb` (`user_id`),
  CONSTRAINT `FKdw323d5djd0hiqygxjypswonb` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKto2lp2637vrk0w1olwbjpldcq` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_and_exchange`
--

LOCK TABLES `return_and_exchange` WRITE;
/*!40000 ALTER TABLE `return_and_exchange` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_and_exchange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review_images`
--

DROP TABLE IF EXISTS `review_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review_images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` longblob,
  `name` varchar(255) DEFAULT NULL,
  `review_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3aayo5bjciyemf3bvvt987hkr` (`review_id`),
  CONSTRAINT `FK3aayo5bjciyemf3bvvt987hkr` FOREIGN KEY (`review_id`) REFERENCES `reviews` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review_images`
--

LOCK TABLES `review_images` WRITE;
/*!40000 ALTER TABLE `review_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `review_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpl51cejpw4gy5swfar8br9ngi` (`product_id`),
  KEY `FKcgy7qjc1r99dp117y9en6lxye` (`user_id`),
  CONSTRAINT `FKcgy7qjc1r99dp117y9en6lxye` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKpl51cejpw4gy5swfar8br9ngi` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_info`
--

DROP TABLE IF EXISTS `shipping_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shipping_carrier` varchar(255) DEFAULT NULL,
  `shipping_cost` double DEFAULT NULL,
  `shipping_date` date DEFAULT NULL,
  `shipping_method` varchar(255) DEFAULT NULL,
  `shipping_status` varchar(255) DEFAULT NULL,
  `tracking_number` bigint DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `add_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK45idk6acnnfditxgyyk613m6r` (`order_id`),
  KEY `FK5e5tnvd3jyffarltfy7i01sh2` (`add_id`),
  KEY `FKokw6bplftwitsoh1utl05eyk8` (`user_id`),
  CONSTRAINT `FK45idk6acnnfditxgyyk613m6r` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK5e5tnvd3jyffarltfy7i01sh2` FOREIGN KEY (`add_id`) REFERENCES `addresses` (`id`),
  CONSTRAINT `FKokw6bplftwitsoh1utl05eyk8` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_info`
--

LOCK TABLES `shipping_info` WRITE;
/*!40000 ALTER TABLE `shipping_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr1irjigmqcpfrvggavnr7vjyv` (`user_id`),
  CONSTRAINT `FKr1irjigmqcpfrvggavnr7vjyv` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart_products`
--

DROP TABLE IF EXISTS `shopping_cart_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart_products` (
  `cart_id` int NOT NULL,
  `product_id` int NOT NULL,
  KEY `FKnf1xjkiucco0nm5kva0aknqto` (`product_id`),
  KEY `FK3rsavyu0gugjrwrb9g7qrlvtd` (`cart_id`),
  CONSTRAINT `FK3rsavyu0gugjrwrb9g7qrlvtd` FOREIGN KEY (`cart_id`) REFERENCES `shopping_cart` (`id`),
  CONSTRAINT `FKnf1xjkiucco0nm5kva0aknqto` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart_products`
--

LOCK TABLES `shopping_cart_products` WRITE;
/*!40000 ALTER TABLE `shopping_cart_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_cart_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `coins` int DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `date_of_joining` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` bigint DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_9q63snka3mdh91as4io72espi` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,100,'2000-08-29','2023-08-29','ramesh@gmail.com','Ramesh','MALE','Kumar','12345678',9999988888,0),(2,200,'1998-08-29','2023-08-29','suresh@gmail.com','Suresh','MALE','Kumar','87654321',7777546255,1),(3,10,'2023-08-29','2023-08-30','string@gmail.com','string','MALE','string','stringst',111111110,0),(4,NULL,'2023-08-29','2023-08-30','sadf@gmail.com','asdsdf ','MALE','asdf sdf ','34234234',34234234,NULL),(5,NULL,'2023-08-29','2023-08-30','suraj@gmail.com','Suraj','MALE','Barjatia','1234123434',3216549871,1),(6,NULL,'2023-08-30','2023-08-30','sadsd@gmail.com','sfsdf','MALE','sadfsd','123123211',12312312,1),(7,NULL,'2023-08-01','2023-08-30','asdsd@gmail.com','qerqwer','MALE','qwerwqer','23423423',234234,1),(8,NULL,'1998-04-21','2023-08-30','asd@gmail.com','asd','MALE','asd','1231231231',1231231231,1),(9,NULL,'2023-07-21','2023-08-30','zxcv@gmail.com','zxcv','MALE','zxcv','1234',1234123412,1),(10,NULL,'2022-06-29','2023-08-30','ashu@gmail.com','ashu','MALE','tosh','12345678',98765123,1),(11,NULL,'2023-05-11','2023-08-30','ankush@gmail.com','Ankush','MALE','jain','12345678',9999999999,1),(12,NULL,'2023-02-15','2023-08-30','abc@gmail.com','abc','MALE','xyz','12345678',1234567891,1),(14,NULL,'2022-05-06','2023-09-06','piyush@gmail.com','piyush','MALE','darekar','12345',9999987887,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtrd6335blsefl2gxpb8lr0gr7` (`user_id`),
  CONSTRAINT `FKtrd6335blsefl2gxpb8lr0gr7` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist_products`
--

DROP TABLE IF EXISTS `wishlist_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist_products` (
  `wishlist_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`wishlist_id`,`product_id`),
  KEY `FKpj5y3q6hyu53f8q4pd6n7rndc` (`product_id`),
  CONSTRAINT `FKhlq0ylq5sxd70s0pembuumc1d` FOREIGN KEY (`wishlist_id`) REFERENCES `wishlist` (`id`),
  CONSTRAINT `FKpj5y3q6hyu53f8q4pd6n7rndc` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist_products`
--

LOCK TABLES `wishlist_products` WRITE;
/*!40000 ALTER TABLE `wishlist_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-10 20:11:49
