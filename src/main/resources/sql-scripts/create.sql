CREATE DATABASE IF NOT EXISTS `gb_rest_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `gb_rest_db`;

DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_author` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `message_text` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

