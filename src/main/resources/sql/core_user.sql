/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50720
Source Host           : 192.168.1.2:3306
Source Database       : eee

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-11-10 00:40:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for core_user
-- ----------------------------
DROP TABLE IF EXISTS `core_user`;
CREATE TABLE `core_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户名称',
  `pwd` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createrId` int(11) DEFAULT NULL,
  `updaterId` int(11) DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL COMMENT '最近一次登陆时间',
  `logoutTime` datetime DEFAULT NULL COMMENT '最近一次登出时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
