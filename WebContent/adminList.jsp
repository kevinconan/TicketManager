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
<title>管理员列表</title>
	<link rel="stylesheet" type="text/css" href="./ext-4.2.1-Lite/resources/ext-theme-neptune/ext-theme-neptune-all.css" />
	
  <script type="text/javascript" src="./ext-4.2.1-Lite/ext-all-debug.js"></script>
  <script type="text/javascript" src="./ext-4.2.1-Lite/ext-theme-neptune.js"></script>
  <script type="text/javascript" src="./ext-4.2.1-Lite/locale/ext-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
</head>
<body>
<script type="text/javascript">
	var ctxpath = '<%=ctxpath%>';
	//切换主题
	function themeChange(theme) {
		Ext.util.CSS.swapStyleSheet('theme', './ext-4.2.1-Lite/resources/css/ext-all.css');
	}
	//创建AdminAction模型
	Ext.define('AdminAction', {  
	    extend : 'Ext.data.Model',  
	    fields : [ 'admin', 'updateAdmins', 'createAdmins',  
	            'deleteAdmins', 'message' ],  
	    proxy : {  
	        type : 'ajax',  
	        api : {  
	            create : 'adminTest_add',  
	            update : 'adminTest_update'  
	        },  
	        writer : {  
	            type : 'json'  
	        },  
	        reader : {  
	            type : 'json'  
	        }  
	    }  
	});  
	
	Ext.define('AdminModel', {  
	    extend : 'Ext.data.Model',  
	    fields : [ 'loginid', 'loginpwd', 'adminname' ],  
	      
	});  
	Ext.onReady(function(){
		//创建汽车数据模型
		
		
		var adminStore = Ext.create('Ext.data.Store', {  
		    pageSize : 5,  //改小点，好测试
		    model : 'AdminModel',  
		    autoLoad : true,  
		    proxy : {  
		        type : 'ajax',  
		        actionMethods : 'post',  
		        url : 'adminTest_list',  
		        reader : {  
		            type : 'json',  
		         //   root : 'admin',  
		            totalProperty : 'totalCount'  
		        }  
		    }  
		});
		//定义汽车数据源对象
		/* var busStore = Ext.create('Ext.data.JsonStore',{
			autoLoad :true,
			model : 'Bus',
			proxy: {
		        type: 'ajax',
		        url : 'bus_list',
		        reader: {
		            type: 'json',
		            totalRecords: 'results',
		            idProperty : 'vehicleno'
		         //   record: 'Book'
		        }
		    }
		});
		//创建车站数据模型
		Ext.regModel('Station', {
		    fields: [
				{name: 'stationid'},
				{name: 'stationname'},
				{name: 'locationx'},
				{name: 'locationy'}
		    ]
		});
		//创建线路数据模型
		Ext.regModel('Route', {
		    fields: [
				{name: 'routeid'},
				{name: 'routename'},
				{name: 'startstationid'},
				{name: 'endstationid'},
		    ]
		}); */
		//创建工具栏组件
		var toolbar = [
			{text : '注册汽车',iconCls:'add'},
			{text : '修改汽车',iconCls:'option'},
			{text : '注销汽车',iconCls:'remove'}
		];
		//创建Grid表格组件
		var adminGrid = new Ext.grid.Panel({
			tbar : toolbar,
			region: 'center',
			store: adminStore,
			selModel : new Ext.selection.CheckboxModel(),
			columns: [//配置表格列
				{text: "管理员号", width: 80, dataIndex: 'loginid', sortable: true},
				{text: "登陆密码", width: 80, dataIndex: 'loginpwd', sortable: true},
				{text: "名字", width: 80, dataIndex: 'adminname', sortable: true},	
			]
		});
		new Ext.container.Viewport({
			layout:'border',//表格布局
			items : adminGrid
		});
		
		//创建新增或修改书籍信息的form表单
		Ext.QuickTips.init();});
		//创建书籍类型数据模型
		
		
</script>
</body>
</html>