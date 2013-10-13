/*
Navicat MySQL Data Transfer

Source Server         : MYSQL_5
Source Server Version : 50533
Source Host           : localhost:3309
Source Database       : automindmap_db

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2013-10-10 21:39:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `input`
-- ----------------------------
DROP TABLE IF EXISTS `input`;
CREATE TABLE `input` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `input` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of input
-- ----------------------------
INSERT INTO `input` VALUES ('2', '1', '1', 'java');
INSERT INTO `input` VALUES ('3', '1', '1', 'java');
INSERT INTO `input` VALUES ('4', '1', '1', 'java');
INSERT INTO `input` VALUES ('5', '1', '1', 'wee');
INSERT INTO `input` VALUES ('6', '1', '1', 'wee');
INSERT INTO `input` VALUES ('7', '1', '1', 'wee');
INSERT INTO `input` VALUES ('8', '1', '1', 'wee');
INSERT INTO `input` VALUES ('9', '1', '1', 'wee');
INSERT INTO `input` VALUES ('10', '1', '1', 'ew');
INSERT INTO `input` VALUES ('11', '1', '1', 'twtwtw');
INSERT INTO `input` VALUES ('12', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('13', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('14', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('15', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('16', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('17', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('18', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('19', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('20', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('21', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('22', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('23', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('24', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('25', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('26', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('27', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('28', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('29', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('30', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('31', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('32', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('33', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('34', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('35', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('36', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('37', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('38', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('39', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('40', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('41', '1', '1', 'java is language.');
INSERT INTO `input` VALUES ('42', '3', '1', 'java is language.');
INSERT INTO `input` VALUES ('43', '3', '1', 'java is language.');
INSERT INTO `input` VALUES ('44', '3', '1', 'java is language.');

-- ----------------------------
-- Table structure for `map`
-- ----------------------------
DROP TABLE IF EXISTS `map`;
CREATE TABLE `map` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of map
-- ----------------------------

-- ----------------------------
-- Table structure for `node`
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_id` int(11) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES ('1', '1', 'java', '0');
INSERT INTO `node` VALUES ('2', '1', 'java', '0');
INSERT INTO `node` VALUES ('3', '1', 'language', '0');
INSERT INTO `node` VALUES ('4', '3', 'java', '0');
INSERT INTO `node` VALUES ('5', '3', 'language', '0');
INSERT INTO `node` VALUES ('6', '3', 'java', '0');
INSERT INTO `node` VALUES ('7', '3', 'language', '0');
INSERT INTO `node` VALUES ('8', '3', 'java', '0');
INSERT INTO `node` VALUES ('9', '3', 'language', '0');

-- ----------------------------
-- Table structure for `sentence`
-- ----------------------------
DROP TABLE IF EXISTS `sentence`;
CREATE TABLE `sentence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_id` int(11) DEFAULT NULL,
  `input_id` int(11) DEFAULT NULL,
  `sentence` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sentence
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'milina');
INSERT INTO `user` VALUES ('2', 'admin');
INSERT INTO `user` VALUES ('3', 'udara');
INSERT INTO `user` VALUES ('13', 'test');
INSERT INTO `user` VALUES ('14', 'test');
INSERT INTO `user` VALUES ('15', 'test');
INSERT INTO `user` VALUES ('16', 'test');
INSERT INTO `user` VALUES ('17', 'test');
INSERT INTO `user` VALUES ('18', 'test');
INSERT INTO `user` VALUES ('19', 'test');
INSERT INTO `user` VALUES ('20', 'teset');
INSERT INTO `user` VALUES ('21', 'teset3');
