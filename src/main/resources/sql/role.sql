/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : cashloan

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-10-15 15:18:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `cashloan`.`role` (`id`, `rolename`, `description`) VALUES ('1', 'ADMIN', '管理员');
INSERT INTO `cashloan`.`role` (`id`, `rolename`, `description`) VALUES ('2', 'DBA', '数据库管理员');
INSERT INTO `cashloan`.`role` (`id`, `rolename`, `description`) VALUES ('3', 'USER', '普通用户');

