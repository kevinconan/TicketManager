//定义车站数据源
var stationStore = Ext.create('Ext.data.JsonStore', {
    pageSize: 10,
    model: 'StationModel',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'station_list',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'totalCount'
        }
    }
});
//定义线路数据源
var routeStore = Ext.create('Ext.data.JsonStore', {
    pageSize: 10,
    model: 'RouteModel',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'routeinfo_list',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'totalCount'
        }
    }
});
//定义汽车数据源
var busStore = Ext.create('Ext.data.JsonStore', {
    pageSize: 10,
    model: 'BusModel',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'businfo_list',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'totalCount'
        }
    }
});
//定义调度数据源
var routeScheduleStore = Ext.create('Ext.data.JsonStore', {
    pageSize: 10,
    model: 'RouteScheduleModel',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'scheduleinfo_list',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'totalCount'
        }
    }
});
//定义车票数据源
var ticketStore = Ext.create('Ext.data.JsonStore', {
    pageSize: 10,
    model: 'TicketModel',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'ticketinfo_list',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'totalCount'
        }
    }
});
//定义管理员数据源
var adminStore = Ext.create('Ext.data.JsonStore', {
    pageSize: 10,
    model: 'AdminModel',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        actionMethods: 'post',
        url: 'admin_list',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'totalCount'
        }
    }
});