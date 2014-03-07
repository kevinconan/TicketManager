
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
//定义操作工具栏
var toolbar_st = [
   			{text : '注册车站',iconCls:'add'},
   			{text : '修改车站',iconCls:'option'},
   			{text : '注销车站',iconCls:'remove'}
   		];

//分页工具下拉框
var pagesize_combo_st = new Ext.form.ComboBox({   
    store: [[5,'5条'],[10,'10条'],[20,'20条'],[40,'40条'],[60,'60条'],[100,'100条']],   
 width:70,    
 emptyText: '10条',   
    mode: 'remote',
    name: 'pageSize',
    editable:false,
    triggerAction: 'all',   
    valueField: 'value',   
    displayField: 'text'  
});
//绑定分页下拉框更改事件
pagesize_combo_st.on("select",function(comboBox){          
	pageToolbar_st.pageSize = parseInt(comboBox.getValue());
	stationStore.pageSize = parseInt(comboBox.getValue());
	stationStore.reload({params:{start:0,limit:pageToolbar_st.pageSize}});   
});
//分页工具栏
var pageToolbar_st=new Ext.PagingToolbar({
	  store:stationStore,
	  pageSize:10,//小点，和上面一致
	  displayInfo:true,
	  displayMsg:"当前显示从{0}条到{1}条，共{2}条",
	  emptyMsg:"<span style='color:red;font-style:italic;'>对不起没有找到数据</span>",
	  items:[ '&nbsp;&nbsp;每页显示：',pagesize_combo_st]
	 });
//定义表格组件
var stationGrid = new Ext.grid.Panel({
			tbar : toolbar_st,
			bbar : pageToolbar_st,
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
