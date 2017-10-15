/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : cashloan

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-10-15 15:20:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `cashloan`.`user` (`id`, `username`, `password`, `enabled`) VALUES ('1', 'wuketao', '$2a$10$6izW/j7MAPR9JSK5NGbUCOkKB2UJ25mnVacw3WQV5vf2PAgEPAHpC', '1');
INSERT INTO `cashloan`.`user` (`id`, `username`, `password`, `enabled`) VALUES ('2', 'yuling', '$2a$10$6izW/j7MAPR9JSK5NGbUCOkKB2UJ25mnVacw3WQV5vf2PAgEPAHpC', '1');
