var toolbar_rt = [
   			{text : '注册线路',iconCls:'add'},
   			{text : '修改线路',iconCls:'option'},
   			{text : '注销线路',iconCls:'remove'}
   		];

//分页工具下拉框
var pagesize_combo_rt = new Ext.form.ComboBox({   
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
pagesize_combo_rt.on("select",function(comboBox){          
	pageToolbar_rt.pageSize = parseInt(comboBox.getValue());
	routeStore.pageSize = parseInt(comboBox.getValue());
	routeStore.reload({params:{start:0,limit:pageToolbar_rt.pageSize}});   
});
//分页工具栏
var pageToolbar_rt=new Ext.PagingToolbar({
	  store:routeStore,
	  pageSize:10,//小点，和上面一致
	  displayInfo:true,
	  displayMsg:"当前显示从{0}条到{1}条，共{2}条",
	  emptyMsg:"<span style='color:red;font-style:italic;'>对不起没有找到数据</span>",
	  items:[ '&nbsp;&nbsp;每页显示：',pagesize_combo_rt]
	 });
//定义表格组件
var routeGrid = new Ext.grid.Panel({
	      	width : 690,
		 	height : 390,
			tbar : toolbar_rt,
			bbar : pageToolbar_rt,
			region: 'center',
			store: routeStore,
			selModel : new Ext.selection.CheckboxModel(),
			columns: [//配置表格列
			        {text: "线路号", width: 80, dataIndex: 'routeid', sortable: true},
					{text: "线路名", width: 80, dataIndex: 'routename', sortable: true},
					{text: "出发站", width: 80, dataIndex: 'startstationid', sortable: true},
					{text: "终点站", width: 80, dataIndex: 'endstationid', sortable: true}
			]
		});