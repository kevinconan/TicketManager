/*******************************
 * 
 * 表单模型定义
 * Auther：Kevin
 * 
 ******************************/
//管理员模型
Ext.define('AdminModel', {  
	    extend : 'Ext.data.Model',  
	    fields : [ 'loginid', 'loginpwd', 'adminname' ],  
	      
	});  
//定义车站数据模型
Ext.define('StationModel', {  
	    extend : 'Ext.data.Model',  
	    fields : [ 'stationid', 'stationname', 'locationx','locationy' ],  	      
	});
//定义汽车数据模型
Ext.define('BusModel', {
	extend : 'Ext.data.Model',
    fields: [
		 'vehicleno',
		 'routeid',
		 'busstate',
		 'stationid',
		 'drivername',
		 'seatcount',
    ]
});

//创建线路数据模型
Ext.define('RouteModel', {
	extend : 'Ext.data.Model',
    fields: [
		 'routeid',
		 'routename',
		 'startstationid',
		 'endstationid',
    ]
});
//定义线路调度模型
Ext.define('RouteScheduleModel', {
	extend : 'Ext.data.Model',
    fields: [
		 'scheduleid',
		 'schedulerouteid',
		 'starttime',
		 'endtime',
		 'schedulename',
		 'schedulevehicleno',
    ]
});
//定义车票模型
Ext.define('TicketModel', {
	extend : 'Ext.data.Model',
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
    ]
});