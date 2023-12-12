CREATE TABLE `booking` (
  `booking_Id` int NOT NULL AUTO_INCREMENT,
  `show_Id` int NOT NULL,
  `booking_Date` date DEFAULT NULL,
  `customer_Id` int NOT NULL,
  PRIMARY KEY (`booking_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `booking_seat_mapping` (
  `booking_seat_id` int NOT NULL AUTO_INCREMENT,
  `booking_id` int NOT NULL,
  `seat_Id` int NOT NULL,
  PRIMARY KEY (`booking_seat_id`),
  KEY `seat_Id` (`seat_Id`),
  KEY `booking_id` (`booking_id`),
  CONSTRAINT `booking_seat_mapping_ibfk_1` FOREIGN KEY (`seat_Id`) REFERENCES `seat` (`seat_Id`),
  CONSTRAINT `booking_seat_mapping_ibfk_2` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `movie_show` (
  `show_Id` int NOT NULL AUTO_INCREMENT,
  `show_Time` datetime DEFAULT NULL,
  `movie_Id` int NOT NULL,
  `screen_Number` int NOT NULL,
  PRIMARY KEY (`show_Id`),
  KEY `screen_Number` (`screen_Number`),
  KEY `movie_Id` (`movie_Id`),
  CONSTRAINT `movie_show_ibfk_1` FOREIGN KEY (`screen_Number`) REFERENCES `screen` (`screen_Number`),
  CONSTRAINT `movie_show_ibfk_2` FOREIGN KEY (`movie_Id`) REFERENCES `movie` (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `review` (
  `review_id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int NOT NULL,
  `review_comment` longtext,
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `movie` (
  `movie_id` int NOT NULL AUTO_INCREMENT,
  `movie_title` varchar(45) DEFAULT NULL,
  `movie_description` longtext,
  `movie_genre` varchar(45) DEFAULT NULL,
  `movie_duration` int DEFAULT NULL,
  PRIMARY KEY (`movie_id`),
  UNIQUE KEY `movie_id_UNIQUE` (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `screen` (
  `screen_Number` int NOT NULL AUTO_INCREMENT,
  `seating_Capacity` int DEFAULT NULL,
  PRIMARY KEY (`screen_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `seat` (
  `seat_Id` int NOT NULL AUTO_INCREMENT,
  `seat_Number` int NOT NULL,
  `seat_Row` varchar(45) NOT NULL,
  `seat_Class` varchar(45) DEFAULT NULL,
  `screen_Number` int NOT NULL,
  PRIMARY KEY (`seat_Id`),
  KEY `screen_Number` (`screen_Number`),
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`screen_Number`) REFERENCES `screen` (`screen_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `seat_availability` (
  `id` int NOT NULL AUTO_INCREMENT,
  `seat_Id` int NOT NULL,
  `availability` tinyint(1) DEFAULT '1',
  `show_Id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `seat_Id` (`seat_Id`),
  KEY `show_Id` (`show_Id`),
  CONSTRAINT `seat_availability_ibfk_1` FOREIGN KEY (`seat_Id`) REFERENCES `seat` (`seat_Id`),
  CONSTRAINT `seat_availability_ibfk_2` FOREIGN KEY (`show_Id`) REFERENCES `movie_show` (`show_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `theatre` (
  `theatre_Id` int NOT NULL AUTO_INCREMENT,
  `theatre_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`theatre_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `theatre_screen_mapping` (
  `theatre_screen_id` int NOT NULL AUTO_INCREMENT,
  `theatre_id` int NOT NULL,
  `screen_Number` int NOT NULL,
  PRIMARY KEY (`theatre_screen_id`),
  KEY `theatre_id` (`theatre_id`),
  KEY `screen_Number` (`screen_Number`),
  CONSTRAINT `theatre_screen_mapping_ibfk_1` FOREIGN KEY (`theatre_id`) REFERENCES `theatre` (`theatre_Id`),
  CONSTRAINT `theatre_screen_mapping_ibfk_2` FOREIGN KEY (`screen_Number`) REFERENCES `screen` (`screen_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



