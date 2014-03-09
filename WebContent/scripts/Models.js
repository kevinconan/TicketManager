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
    associations: [{
        type: 'hasMany', model: 'BusModel',
        name: 'busList',
        foreignKey: 'busstationid',
        associationKey: 'busList',
        storeConfig: Ext.data.StoreManager.lookup('busStore')
    }, {
        type: 'hasMany', model: 'RouteModel',
        name: 'startList',
        foreignKey: 'startstationid',
        associationKey: 'startList',
        storeConfig: Ext.data.StoreManager.lookup('routeStore')
    }, {
        type: 'hasMany', model: 'RouteModel',
        name: 'endList',
        foreignKey: 'endstationid',
        associationKey: 'endList',
        storeConfig: Ext.data.StoreManager.lookup('routeStore')
    }
    ],

});
//定义汽车数据模型
Ext.define('BusModel', {
    extend: 'Ext.data.Model',
    fields: [
		 'vehicleno',
		 'busrouteid',
		 'busstate',
		 'busstationid',
		 'drivername',
		 'seatcount',
    ],
    idProperty: 'vehicleno',
    associations: [
            { type: 'belongsTo', model: 'StationModel', foreignKey: 'busstationid' },
            { type: 'belongsTo', model: 'RouteModel', foreignKey: 'busrouteid' }
    ]

});

//创建线路数据模型
Ext.define('RouteModel', {
    extend: 'Ext.data.Model',
    fields: [
		 'routeid',
		 'routename',
		 'startstationid',
		 'endstationid',
    ],
    idProperty: 'routeid',
    associations: [
  		         { type: 'belongsTo', model: 'StationModel', foreignKey: 'startstationid' },
  		         { type: 'belongsTo', model: 'StationModel', foreignKey: 'endstationid' },
  		         {
  		             type: 'hasMany', model: 'RouteScheduleModel',
  		             name: 'routeschedules',
  		             foreignKey: 'schedulerouteid',
  		             associationKey: 'routeschedules',
  		             storeConfig: Ext.data.StoreManager.lookup('routeScheduleStore')
  		         }
    ]
});
//定义线路调度模型
Ext.define('RouteScheduleModel', {
    extend: 'Ext.data.Model',
    fields: [
		 'scheduleid',
		 'schedulerouteid',
		 'starttime',
		 'endtime',
		 'schedulename',
		 'schedulevehicleno',
    ],
    idProperty: 'scheduleid',
    associations: [{
        type: 'belongsTo', model: 'RouteModel', foreignKey: 'schedulerouteid',
        associationKey: 'route', name: 'route'
    }, {
        type: 'hasMany', model: 'TicketModel',
        name: 'tickets',
        foreignKey: 'ticketscheduleid',
        associationKey: 'tickets',
        storeConfig: Ext.data.StoreManager.lookup('ticketStore')
    }]
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
    ],
    idProperty: 'ticketid',
    associations: [
    		         { type: 'belongsTo', model: 'RouteScheduleModel', foreignKey: 'ticketscheduleid' }
    ]
});