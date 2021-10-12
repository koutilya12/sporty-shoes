CREATE DATABASE sportyshoes2;
USE sportyshoes2;

CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `mobileNum` varchar(30) NOT NULL,
  `emailId` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `userType` char(1) NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `brand` (
  `brandId` int NOT NULL AUTO_INCREMENT,
  `brandName` varchar(15) NOT NULL,
  PRIMARY KEY (`brandId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `category` (
  `categoryId` int NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(15) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product` (
  `productId` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(15) NOT NULL,
  `brandID` int NOT NULL,
  `size` int NOT NULL,
  `categoryId` int NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`productId`),
  KEY `brandId` (`brandID`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`brandID`) REFERENCES `brand` (`brandId`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product_stock` (
  `skuId` int NOT NULL AUTO_INCREMENT,
  `productId` int DEFAULT NULL,
  `stock` int NOT NULL,
  `batchNum` varchar(30) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`skuId`),
  KEY `productId` (`productId`),
  CONSTRAINT `product_stock_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cart` (
  `cartId` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `totPrice` double(12,2) NOT NULL,
  `totQuantity` int NOT NULL,
  `status` char(1) NOT NULL,
  `bookingTime` datetime NOT NULL,
  PRIMARY KEY (`cartId`),
  KEY `userId` (`userId`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `cart_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cartId` int DEFAULT NULL,
  `skuId` int DEFAULT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cartId` (`cartId`),
  KEY `skuId` (`skuId`),
  CONSTRAINT `cart_details_ibfk_1` FOREIGN KEY (`cartId`) REFERENCES `cart` (`cartId`),
  CONSTRAINT `cart_details_ibfk_2` FOREIGN KEY (`skuId`) REFERENCES `product_stock` (`skuId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `orders` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `totPrice` double(12,2) NOT NULL,
  `totQuantity` int NOT NULL,
  `status` char(1) NOT NULL,
  `bookingTime` datetime NOT NULL,
  `transactionId` varchar(30) DEFAULT NULL,
  `cartId` int DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `userId` (`userId`),
  KEY `cartId` (`cartId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orderId` int DEFAULT NULL,
  `skuId` int DEFAULT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  KEY `skuId` (`skuId`),
  CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`),
  CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`skuId`) REFERENCES `product_stock` (`skuId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
