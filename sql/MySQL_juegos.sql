CREATE DATABASE juegosdb;

USE juegosdb;

CREATE TABLE `juegos` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `rank` INT(11) NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `platform` VARCHAR(45) NOT NULL,
    `year` INT(4) NOT NULL,
    `genre` VARCHAR(45) NOT NULL,
    `publisher` VARCHAR(45) NOT NULL,
    `na_sales` DECIMAL(4 , 2 ) NOT NULL,
    `eu_sales` DECIMAL(4 , 2 ) NOT NULL,
    `lp_sales` DECIMAL(4 , 2 ) NOT NULL,
    `other_sales` DECIMAL(4 , 2 ) NOT NULL,
    `global_sales` DECIMAL(4 , 2 ) NOT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=16 DEFAULT CHARSET=LATIN1