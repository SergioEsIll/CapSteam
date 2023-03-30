CREATE DATABASE juegosdb;

USE juegosdb;

CREATE TABLE `juegos` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `rank` INT(11),
    `name` VARCHAR(255),
    `platform` VARCHAR(255),
    `year` INT(4),
    `genre` VARCHAR(255),
    `publisher` VARCHAR(255),
    `na_sales` DECIMAL(4 , 2 ),
    `eu_sales` DECIMAL(4 , 2 ),
    `lp_sales` DECIMAL(4 , 2 ),
    `other_sales` DECIMAL(4 , 2 ),
    `global_sales` DECIMAL(4 , 2 ),
    PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=16 DEFAULT CHARSET=LATIN1