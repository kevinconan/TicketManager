<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* UserBean User = (UserBean)request.getSession().getAttribute("User");
if(User == null)
	response.sendRedirect("login.jsp"); */
String ctxpath = request.getContextPath();
/* String userName = User.getUsername();
request.setAttribute("username", userName); */
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>调度管理</title>
	<link rel="stylesheet" type="text/css" href="./ext-4.2.1-Lite/resources/ext-theme-neptune/ext-theme-neptune-all.css" />

  <script type="text/javascript" src="./ext-4.2.1-Lite/ext-all-debug.js"></script>
  <script type="text/javascript" src="./ext-4.2.1-Lite/ext-theme-neptune.js"></script>
  <script type="text/javascript" src="./ext-4.2.1-Lite/locale/ext-lang-zh_CN.js"></script>
  	<script type="text/javascript" src="./scripts/Models.js"></script>
	<script type="text/javascript" src="./scripts/Station.js"></script>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
</head>
<body>
<script type="text/javascript">
	var ctxpath = '<%=ctxpath%>';
	//切换主题
	function themeChange(theme) {
		Ext.util.CSS.swapStyleSheet('theme', './ext-4.2.1-Lite/resources/css/ext-all.css');
	}
	
	
	Ext.onReady(function(){

		var routesScheduleStore = Ext.create('Ext.data.Store', {  
		    pageSize : 10,  
		    model : 'RouteScheduleModel',  
		    autoLoad : true,  
		    proxy : {  
		        type : 'ajax',  
		        actionMethods : 'post',  
		        url : 'routemchedule_list',  
		        reader : {  
		            type : 'json',  
		            root : 'rows',  
		            totalProperty : 'totalCount'  
		        }  
		    }  
		});
		var toolbar_rs = [
		         			{text : '新增调度',iconCls:'add'},
		         			{text : '修改调度',iconCls:'option'},
		         			{text : '删除调度',iconCls:'remove'}
		         		];

		      //分页工具下拉框
		      var pagesize_combo_rs = new Ext.form.ComboBox({   
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
		      pagesize_combo_rs.on("select",function(comboBox){          
		      	pageToolbar_rs.pageSize = parseInt(comboBox.getValue());
		      	routesScheduleStore.pageSize = parseInt(comboBox.getValue());
		      	routesScheduleStore.reload({params:{start:0,limit:pageToolbar_rs.pageSize}});   
		      });
		      //分页工具栏
		      var pageToolbar_rs=new Ext.PagingToolbar({
		      	  store:routesScheduleStore,
		      	  pageSize:10,//小点，和上面一致
		      	  displayInfo:true,
		      	  displayMsg:"当前显示从{0}条到{1}条，共{2}条",
		      	  emptyMsg:"<span style='color:red;font-style:italic;'>对不起没有找到数据</span>",
		      	  items:[ '&nbsp;&nbsp;每页显示记录数量：',pagesize_combo_rs]
		      	 });
		      //定义表格组件
		      var routesScheduleGrid = new Ext.grid.Panel({
		      			tbar : toolbar_rs,
		      			bbar : pageToolbar_rs,
		      			region: 'center',
		      			store: routesScheduleStore,
		      			selModel : new Ext.selection.CheckboxModel(),
		      			columns: [//配置表格列
		      				{text: "调度编号", width: 80, dataIndex: 'scheduleid', sortable: true},
		      				{text: "调度线路", width: 80, dataIndex: 'schedulerouteid', sortable: true},
		      				{text: "出发时间", width: 80, dataIndex: 'starttime', sortable: true},	
		      				{text: "到达时间", width: 80, dataIndex: 'endtime', sortable: true},
		      				{text: "调度名称", width: 80, dataIndex: 'schedulename', sortable: true},
		      				{text: "调度车辆", width: 80, dataIndex: 'schedulevehicleno', sortable: true}
		      			]
		      		});
		
		new Ext.container.Viewport({
			layout:'border',//表格布局
			items : routesScheduleGrid
		});
		
	
		
		Ext.QuickTips.init();});

		
</script>
</body>
</html>