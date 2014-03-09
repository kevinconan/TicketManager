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
  	<script type="text/javascript" src="./scripts/Stores.js"></script>
	<script type="text/javascript" src="./scripts/Station.js"></script>
	  	<script type="text/javascript" src="./scripts/Route.js"></script>
	<script type="text/javascript" src="./scripts/Bus.js"></script>
	<script type="text/javascript" src="./resources/ux/Spinner.js"></script>
	<script type="text/javascript" src="./resources/ux/SpinnerField.js"></script>
	<script type="text/javascript" src="./resources/ux/DateTimeField.js"></script>
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

		var toolbar_rs = [
		         			{text : '新增调度',iconCls:'add',handler:showNewSchedule},
		         			{text : '修改调度',iconCls:'option',handler:test},
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
		      	routeScheduleStore.pageSize = parseInt(comboBox.getValue());
		      	routeScheduleStore.reload({params:{start:0,limit:pageToolbar_rs.pageSize}});   
		      });
		      //分页工具栏
		      var pageToolbar_rs=new Ext.PagingToolbar({
		      	  store:routeScheduleStore,
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
		      			store: routeScheduleStore,
		      			selModel : new Ext.selection.CheckboxModel(),
		      			columns: [//配置表格列
		      				{text: "调度编号", width: 80, dataIndex: 'scheduleid', sortable: true},
<<<<<<< HEAD
<<<<<<< HEAD
		      				{text: "调度线路", width: 80, dataIndex: 'schedulerouteid', sortable: true,
		      					renderer : function(value){
		      						var list = [];
		      						list.push(value);
		      						var nameS = "";
		      						var	lists = Ext.JSON.encode(list);
		      						Ext.Ajax.request({
		      							url : 'route_getById',
		      							params : {"message" : lists},
		      							method : 'GET',
		      							success : function(response,options){
		      							//	 debugger;
		      								var result = Ext.JSON.decode(response.responseText);
		      							    nameS = result.rows[0].routename;
		      							},
		      							failure : function(response,options){
		      								
		      							}
		      						});
		      						return nameS;
		      					}
		      				},
=======
		      				{text: "调度线路", width: 80, dataIndex: 'schedulerouteid', sortable: true,},
>>>>>>> bddae9ee2f5910d03507a93efdf9bfdc15d9a700
=======
		      				{text: "调度线路", width: 80, dataIndex: 'schedulerouteid', sortable: true,},
>>>>>>> bddae9ee2f5910d03507a93efdf9bfdc15d9a700
		      				{text: "出发时间", width: 80, dataIndex: 'starttime', sortable: true},	
		      				{text: "到达时间", width: 80, dataIndex: 'endtime', sortable: true},
		      				{text: "调度名称", width: 80, dataIndex: 'schedulename', sortable: true},
		      				{text: "调度车辆", width: 80, dataIndex: 'schedulevehicleno', sortable: true}
		      			],
		      			beforeshow:function(value,op){
		      				consloe.log("beforeshow");
		      	        	var	list=[];
		      	        	for(var i=0;i<routeScheduleStore.data.items.length;i++){
		      	        		list.push(routeScheduleStore.data.items[i].data.schedulerouteid);
		      	        	}
		      	        	var message=Ext.JSON.encode(list);
		      	        	Ext.Ajax.request({
		      	    				url : 'route_getById',
		      	    				params : {"message" : message},
		      	    				method : 'GET',
		      	    				success : function(response,options){
		      	    					var result = Ext.JSON.decode(response.responseText);
		      	    					for(var i=0;i<result.rows;i++){
		      	    						routeStore.add(RouteModel.create(result.rows[i]));
		      	    						console.log(result.rows[i]);
		      	    					}
		      	    				}	
		      	    			});
		      	        }
		      		});
		
		
		routeGrid.hide();
		 busGrid.hide();
		 
		//显示
			new Ext.container.Viewport({
				layout:'border',//表格布局
				items : routesScheduleGrid
			});
		//创建调度表单
		var routesScheduleForm = new Ext.form.Panel({
			autoHeight : true,
			layout : "form",
			fieldDefaults:{//统一设置表单字段默认属性
				labelSeparator :'：',//分隔符
				labelWidth : 80,//标签宽度
				style:"margin-left:20px;",
				
			//	msgTarget : 'side',
				width : 200
			},
			bodyPadding: 5,
		//	frame:true,
			items : [{//第一行
				layout : 'column',
				items : [{
					xtype:'textfield',
					allowBlank : false,
					blankText : '调度线路不能为空',
					emptyText : '请选择线路',
					name : 'schedulerouteid',
					fieldLabel:'调度线路'
				},{
		            xtype: 'button',
		            text : '选择线路',
		            style:"margin-left:20px;",
		            handler:function(){
		            
		            	if(routeGrid.isHidden()){
		            		routeGrid.show();
		            	}else{
		            		var recs = routeGrid.getSelectionModel().getSelection();
		            		if(recs.length == 0){
		        				Ext.MessageBox.alert('提示','请选择线路！');
		        			}else if(recs.length >1){
		        				Ext.MessageBox.alert('提示','你只能选择一条线路');
		        				
		        			}else{
		        				routesScheduleForm.getForm().findField('schedulerouteid').setValue(recs[0].get('routeid'));
		        				
		        			}
		            		
		            	}
		            	
		       		 	busGrid.hide();
		            	
		            }
		        },{
					xtype:'textfield',
					allowBlank : false,
					blankText : '调度车辆不能为空',
					emptyText : '请选择车辆',
					name : 'schedulevehicleno',
					fieldLabel:'调度车辆'
				},{
		            xtype: 'button',
		            text : '选择车辆',
		            style:"margin-left:20px;",
		            handler:function(){
		            	if(busGrid.isHidden()){
		            		busGrid.show();
		            	}else{
		            		var recs = busGrid.getSelectionModel().getSelection();
		            		if(recs.length == 0){
		        				Ext.MessageBox.alert('提示','请选择车辆！');
		        			}else if(recs.length >1){
		        				Ext.MessageBox.alert('提示','你只能选择一辆车');
		        				
		        			}else{
		        				routesScheduleForm.getForm().findField('schedulevehicleno').setValue(recs[0].get('vehicleno'));
		        				
		        			}
		            		
		            	}
		            	routeGrid.hide();
		       		 
		            	
		            }
		        }]
				
			},{
				layout : 'column',
				items : [{
			        xtype: 'datefield',
			        name: 'startdate',
			        fieldLabel: '出发时间',
			        emptyText : '请选择日期',
			        anchor: '100%',
			        altFormats:'Y-m-d',
			        format : 'Y-m-d'
			    },{
			        xtype: 'timefield',
			        name: 'starttime',
			        emptyText : '时间',
			     //   fieldLabel: '出发时间',
			        anchor: '50%',
			        style:"margin-left:0px;",
			        width : 86,
			        altFormats:'H:i:s',
			        format : 'H:i:s'
			    }, {
			        xtype: 'datefield',
			        name: 'enddate',
			        emptyText : '请选择日期',
			        fieldLabel: '到达时间',
			        anchor: '100%',
			        altFormats:'Y-m-d h:i:s',
			        format : 'Y-m-d h:i:s'
			   },{
			        xtype: 'timefield',
			        name: 'endtime',
			        emptyText : '时间',
			     //   fieldLabel: '出发时间',
			        anchor: '50%',
			        style:"margin-left:0px;",
			        width : 86,
			        altFormats:'H:i:s',
			        format : 'H:i:s'
			    }]
			} ,{
				layout:'column',

				items: [{
		        	
					xtype:'textfield',
					allowBlank : false,
					blankText : '调度名称不能为空',
					name : 'schedulename',
					fieldLabel:'调度名称'
				},{
		        	xtype: 'button',
		            text : '&nbsp;&nbsp;提交&nbsp;&nbsp;',
		            style:"margin-left:20px;",
		            handler: submitScheduleForm
		        	
		        }]
			} 
			]
		});
		
		var panel = new Ext.panel.Panel({
		//	width:'99%',
		//	 height:'99%',
			layout : 'fit',
			//bodyPadding : 0,
			items : [{
				layout:'auto',
		//		bodyPadding : 0,
				maxWidth : 750,
				maxHeight :500,
				items: [{
				//	title :'test1',
					items: routesScheduleForm
				},{
				//	title :'test1',
					items: [routeGrid,busGrid]
				}]
			},{
			//	layout:'accordion',
				items: [] }]
		});

		//创建弹出窗口
		var win = new Ext.window.Window({
			layout:'fit',
		    width:700,
		    closeAction:'hide',
		    height:500,
			resizable : false,
			shadow : true,
			modal :true,
		    closable:true,
			items: [panel]
		});
		
		function showNewSchedule(){
			routesScheduleForm.isAdd = true;//新增表单标识
			routesScheduleForm.form.reset();
			win.setTitle("新增调度");
			win.show();
			
		}
		function test(){
			for(var i=0;i<routeStore.data.items.length;i++){
				console.log(routeStore.data.items[i].data.routename);
			}
			var selected=routesScheduleGrid.getSelectionModel().getSelection();
			for(var i=0;i<selected.length;i++){
				var obj=selected[i];
				
				//console.log(obj.data.route.routename);
			//	console.log(routeStore.data.items.find(function(element, index, array){return element.data.routeid==obj.data.schedulerouteid;}).data.routename);
			}
		}
//提交调度信息表单
	function submitScheduleForm(){
		if(routesScheduleForm.isAdd){//新增提交
			var startdate = routesScheduleForm.getForm().findField('startdate').getValue();
			var starttime = startdate+routesScheduleForm.getForm().findField('starttime').getValue();
			alert(starttime);
		}
	
		
		
}
	
		
		Ext.QuickTips.init();});

		
</script>
</body>
</html>