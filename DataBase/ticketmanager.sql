/*
 * 汽车售票系统数据库
 * for MySQL 5.6
 * Author: Diluka
 * Date: 2014-03-11
 */

DROP DATABASE IF EXISTS ticketmanager;
CREATE DATABASE ticketmanager;

USE ticketmanager;

/*创建表*/
DROP TABLE IF EXISTS admin;
CREATE TABLE admin (
    loginid VARCHAR(50) PRIMARY KEY,
    loginpwd VARCHAR(50) NULL,
    adminname VARCHAR(50) NULL
);

DROP TABLE IF EXISTS station;
CREATE TABLE station (
    stationid INT PRIMARY KEY AUTO_INCREMENT,
    stationname VARCHAR(50) NULL,
    locationx DOUBLE NULL,
    locationy DOUBLE NULL
);

DROP TABLE IF EXISTS bus;
CREATE TABLE bus (
    busid INT PRIMARY KEY AUTO_INCREMENT,
    vehicleno VARCHAR(50) NULL,
    drivername VARCHAR(50) NULL,
    seatcount INT NULL,
    busstationid INT NULL,
    busstate INT NULL
);

DROP TABLE IF EXISTS route;
CREATE TABLE route (
    routeid INT PRIMARY KEY AUTO_INCREMENT,
    routename VARCHAR(50) NULL,
    startstationid INT NULL,
    endstationid INT NULL
);

DROP TABLE IF EXISTS routeschedule;
CREATE TABLE routeschedule (
    scheduleid INT PRIMARY KEY AUTO_INCREMENT,
    schedulerouteid INT NULL,
    schedulename VARCHAR(50) NULL,
    schedulebusid INT NULL,
    starttime DATETIME NULL,
    endtime DATETIME NULL
);

DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket (
    ticketid INT PRIMARY KEY AUTO_INCREMENT,
    ticketno VARCHAR(50) NULL,
    tickettitle VARCHAR(50) NULL,
    ticketscheduleid INT NULL,
    seatno VARCHAR(50) NULL,
    customername VARCHAR(50) NULL,
    entrytime DATETIME NULL,
    deadline DATETIME NULL,
    checked BIT NULL
);

/*添加关系*/
ALTER TABLE bus 
	ADD CONSTRAINT fk_bus_station FOREIGN KEY(busstationid) REFERENCES station(stationid);

ALTER TABLE route 
	ADD CONSTRAINT fk_route_station_start FOREIGN KEY(startstationid) REFERENCES station(stationid),
	ADD CONSTRAINT fk_route_station_end FOREIGN KEY(endstationid) REFERENCES station(stationid);

ALTER TABLE routeschedule 
	ADD CONSTRAINT fk_schedule_route FOREIGN KEY(schedulerouteid) REFERENCES route(routeid),
	ADD CONSTRAINT fk_schedule_bus FOREIGN KEY(schedulebusid) REFERENCES bus(busid);

ALTER TABLE ticket 
	ADD CONSTRAINT fk_ticket_schedule FOREIGN KEY(ticketscheduleid) REFERENCES routeschedule(scheduleid);

/*创建视图*/
DROP VIEW IF EXISTS routeinfo;
CREATE VIEW routeinfo AS
    SELECT 
        r . *,
        ss.stationname AS startstationname,
        es.stationname AS endstationname
    FROM
        route r,
        station ss,
        station es
    WHERE
        r.startstationid = ss.stationid
            AND r.endstationid = es.stationid;

DROP VIEW IF EXISTS scheduleinfo;
CREATE VIEW scheduleinfo AS
    SELECT 
        rs . *,
        ri.routename,
        ri.startstationname,
        ri.endstationname,
        b.vehicleno,
        b.drivername
    FROM
        routeschedule rs,
        bus b,
        routeinfo ri
    WHERE
        rs.schedulerouteid = ri.routeid
            AND rs.schedulebusid = b.busid;

DROP VIEW IF EXISTS businfo;
CREATE VIEW businfo AS
    SELECT 
        b . *, s.stationname
    FROM
        bus b,
        station s
    WHERE
        b.busstationid = s.stationid;

DROP VIEW IF EXISTS ticketinfo;
CREATE VIEW ticketinfo AS
    SELECT 
        t . *,
        si.schedulename,
        si.routename,
        si.startstationname,
        si.starttime,
        si.endstationname,
        si.endtime,
        si.vehicleno
    FROM
        ticket t,
        scheduleinfo si
    WHERE
        t.ticketscheduleid = si.scheduleid;

DROP VIEW IF EXISTS businfo_cn;
CREATE VIEW businfo_cn AS
    SELECT 
        bi.busid 汽车ID,
        bi.vehicleno 车牌号,
        bi.drivername 驾驶员,
        bi.seatcount 座位数,
        bi.busstationid 归属车站编号,
        bi.stationname 归属车站,
        bi.busstate 汽车状态
    FROM
        businfo bi;

DROP VIEW IF EXISTS routeinfo_cn;
CREATE VIEW routeinfo_cn AS
    SELECT 
        ri.routeid 线路ID,
        ri.routename 线路名称,
        ri.startstationname 出发车站,
        ri.endstationname 目的地车站
    FROM
        routeinfo ri;

DROP VIEW IF EXISTS scheduleinfo_cn;
CREATE VIEW scheduleinfo_cn AS
    SELECT 
        si.scheduleid 行程ID,
        si.schedulename 行程名称,
        si.routename 线路名称,
        si.startstationname 起点站,
        si.starttime 出发时间,
        si.endstationname 目的地,
        si.endtime 到达时间,
        si.vehicleno 车牌号,
        si.drivername 驾驶员
    FROM
        scheduleinfo si;

DROP VIEW IF EXISTS ticketinfo_cn;
CREATE VIEW ticketinfo_cn AS
    SELECT 
        ti.ticketid 车票ID,
        ti.ticketno 车票编号,
        ti.tickettitle 车票标题,
        ti.schedulename 行程名称,
        ti.routename 线路名称,
        ti.startstationname 起点站,
        ti.starttime 出发时间,
        ti.endstationname 目的地,
        ti.endtime 到达时间,
        ti.seatno 座位号,
        ti.customername 顾客姓名,
        ti.entrytime 生成时间,
        ti.deadline 作废时间,
        ti.checked 检票状态
    FROM
        ticketinfo ti;