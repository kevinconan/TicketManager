//定义车站模型
Ext.define('StationModel', {  
	    extend : 'Ext.data.Model',  
	    fields : [ 'stationid', 'stationname', 'locationx','locationy' ],  	      
	});
//定义车站数据源
var stationStore = Ext.create('Ext.data.Store', {  
		    pageSize : 10,  
		    model : 'StationModel',  
		    autoLoad : true,  
		    proxy : {  
		        type : 'ajax',  
		        actionMethods : 'post',  
		        url : 'station_list',  
		        reader : {  
		            type : 'json',  
		            root : 'rows',  
		            totalProperty : 'totalCount'  
		        }  
		    }  
		});
//定义表格组件
var stationGrid = new Ext.grid.Panel({
		//	tbar : toolbar,
			bbar : pageToolbar,
			region: 'center',
			store: stationStore,
			selModel : new Ext.selection.CheckboxModel(),
			columns: [//配置表格列
				{text: "车站编号", width: 80, dataIndex: 'stationid', sortable: true},
				{text: "站名", width: 80, dataIndex: 'stationname', sortable: true},
				{text: "坐标x", width: 80, dataIndex: 'locationx', sortable: true},	
				{text: "坐标y", width: 80, dataIndex: 'locationy', sortable: true}
			]
		});
//定义操作工具栏
