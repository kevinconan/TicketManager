/*******************************
 * 
 * 表单模型定义
 * Auther：Kevin
 * 
 ******************************/
//管理员模型
Ext.define('AdminModel', {
    extend: 'Ext.data.Model',
    fields: ['loginid', 'loginpwd', 'adminname'],
    idProperty: 'loginid'

});
//定义车站数据模型
Ext.define('StationModel', {
    extend: 'Ext.data.Model',
    fields: ['stationid', 'stationname', 'locationx', 'locationy'],
    idProperty: 'stationid',
});
//定义汽车数据模型
Ext.define('BusModel', {
    extend: 'Ext.data.Model',
    fields: [
        'busid',
        'vehicleno',
        'busstationid',
        'busstate',
        'stationname',
        'drivername',
        'seatcount',
    ],
    idProperty: 'busid',
});

//创建线路数据模型
Ext.define('RouteModel', {
    extend: 'Ext.data.Model',
    fields: [
        'routeid',
        'routename',
        'startstationid',
        'endstationid',
        'startstationname',
        'endstationname',
    ],
    idProperty: 'routeid',
});
//定义线路调度模型
Ext.define('RouteScheduleModel', {
    extend: 'Ext.data.Model',
    fields: [
        'scheduleid',
        'drivername',
        'startstationname',
        'endtime',
        'routename',
        'schedulebusid',
        'schedulename',
        'schedulerouteid',
        'endstationname',
        'starttime',
        'vehicleno',
    ],
    idProperty: 'scheduleid',
});
//定义车票模型
Ext.define('TicketModel', {
    extend: 'Ext.data.Model',
    fields: [
        'ticketid',
        'tickettitle',
        'ticketscheduleid',
        'seatno',
        'customername',
        'ticketno',
        'entrytime',
        'deadline',
        'checked',
        'vehicleno',
        'endstationname',
        'endtime',
        'starttime',
        'routename',
        'schedulename',
        'startstationname',
    ],
    idProperty: 'ticketid',
});