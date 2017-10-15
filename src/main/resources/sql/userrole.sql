/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : cashloan

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-10-15 15:20:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `rolename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
INSERT INTO `cashloan`.`userrole` (`id`, `username`, `rolename`) VALUES ('1', 'wuketao', 'ADMIN');
INSERT INTO `cashloan`.`userrole` (`id`, `username`, `rolename`) VALUES ('2', 'yuling', 'USER');
