/*
Navicat MySQL Data Transfer

Source Server         : kevin
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : ticketmanager

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2014-03-11 14:06:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `loginid` varchar(50) NOT NULL,
  `loginpwd` varchar(50) DEFAULT NULL,
  `adminname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`loginid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `bus`
-- ----------------------------
DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus` (
  `busid` int(11) NOT NULL AUTO_INCREMENT,
  `vehicleno` varchar(50) DEFAULT NULL,
  `drivername` varchar(50) DEFAULT NULL,
  `seatcount` int(11) DEFAULT NULL,
  `busstationid` int(11) DEFAULT NULL,
  `busstate` int(11) DEFAULT NULL,
  PRIMARY KEY (`busid`),
  KEY `fk_bus_station` (`busstationid`),
  CONSTRAINT `fk_bus_station` FOREIGN KEY (`busstationid`) REFERENCES `station` (`stationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus
-- ----------------------------

-- ----------------------------
-- Table structure for `route`
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `routeid` int(11) NOT NULL AUTO_INCREMENT,
  `routename` varchar(50) DEFAULT NULL,
  `startstationid` int(11) DEFAULT NULL,
  `endstationid` int(11) DEFAULT NULL,
  PRIMARY KEY (`routeid`),
  KEY `fk_route_station_start` (`startstationid`),
  KEY `fk_route_station_end` (`endstationid`),
  CONSTRAINT `fk_route_station_end` FOREIGN KEY (`endstationid`) REFERENCES `station` (`stationid`),
  CONSTRAINT `fk_route_station_start` FOREIGN KEY (`startstationid`) REFERENCES `station` (`stationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of route
-- ----------------------------

-- ----------------------------
-- Table structure for `routeschedule`
-- ----------------------------
DROP TABLE IF EXISTS `routeschedule`;
CREATE TABLE `routeschedule` (
  `scheduleid` int(11) NOT NULL AUTO_INCREMENT,
  `schedulerouteid` int(11) DEFAULT NULL,
  `schedulename` varchar(50) DEFAULT NULL,
  `schedulebusid` int(11) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  PRIMARY KEY (`scheduleid`),
  KEY `fk_schedule_route` (`schedulerouteid`),
  KEY `fk_schedule_bus` (`schedulebusid`),
  CONSTRAINT `fk_schedule_bus` FOREIGN KEY (`schedulebusid`) REFERENCES `bus` (`busid`),
  CONSTRAINT `fk_schedule_route` FOREIGN KEY (`schedulerouteid`) REFERENCES `route` (`routeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of routeschedule
-- ----------------------------

-- ----------------------------
-- Table structure for `station`
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `stationid` int(11) NOT NULL AUTO_INCREMENT,
  `stationname` varchar(50) DEFAULT NULL,
  `locationx` double DEFAULT NULL,
  `locationy` double DEFAULT NULL,
  PRIMARY KEY (`stationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------

-- ----------------------------
-- Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `ticketid` int(11) NOT NULL AUTO_INCREMENT,
  `ticketno` varchar(50) DEFAULT NULL,
  `tickettitle` varchar(50) DEFAULT NULL,
  `ticketscheduleid` int(11) DEFAULT NULL,
  `seatno` varchar(50) DEFAULT NULL,
  `customername` varchar(50) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `checked` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ticketid`),
  KEY `fk_ticket_schedule` (`ticketscheduleid`),
  CONSTRAINT `fk_ticket_schedule` FOREIGN KEY (`ticketscheduleid`) REFERENCES `routeschedule` (`scheduleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------
