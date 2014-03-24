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
<title>票务管理</title>
<link rel="stylesheet" type="text/css" href="./ext-4.2.1-Lite/resources/ext-theme-neptune/ext-theme-neptune-all.css" />
<script type="text/javascript" src="./ext-4.2.1-Lite/ext-all-debug.js"></script>
<script type="text/javascript" src="./ext-4.2.1-Lite/ext-theme-neptune.js"></script>
<script type="text/javascript" src="./ext-4.2.1-Lite/locale/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="./scripts/Models.js"></script>
<script type="text/javascript" src="./scripts/Stores.js"></script>
<script type="text/javascript" src="./scripts/Station.js"></script>
<script type="text/javascript" src="./scripts/Route.js"></script>
<script type="text/javascript" src="./scripts/Bus.js"></script>
<script type="text/javascript" src="./scripts/VTypes.js"></script>
<script type="text/javascript" src="./scripts/util.js"></script>
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
		      				{text: "行程名称", width: 80, dataIndex: 'schedulename', sortable: true},
		      				{text: "线路", width: 80, dataIndex: 'routename', sortable: true,},
		      				{text: "起点站", width: 80, dataIndex: 'startstationname', sortable: true},
		      				{text: "终点站", width: 80, dataIndex: 'endstationname', sortable: true},
		      				{text: "出发时间", width: 80, dataIndex: 'starttime', sortable: true},	
		      				{text: "到达时间", width: 80, dataIndex: 'endtime', sortable: true},
		      				
		      				{text: "车牌号", width: 80, dataIndex: 'vehicleno', sortable: true},
		      				{text: "余票", width: 80, sortable: true,renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
		      					var scheduleid = record.data['scheduleid'];
		      					
		      					
		      					 
		      					return getRemainSeat(scheduleid);
		      					
		      				}},{
		      					text: "操作",
		      					menuDisabled: true,  
		      				    sortable: false,  
		      				    align:'center',  
		      				    xtype: 'actioncolumn',
		      				    height:'40',
		      				  	width: 80,
		      				  items: [{  
		      				       icon :'./images/sell.png',  
		      				       iconCls:'height:24px;width:24px;',
		      				  //     id: 'sell',  
		      				       tooltip: '售票',  
		      				       handler: function(grid,rowIndex,colIndex){
		      				    	   win_sell.show();
		      				    	   Ext.getCmp('sellForm').getForm().reset();
		      				    	   var scheduleid=routesScheduleGrid.getStore().getAt(rowIndex).data['scheduleid'];
		      				    	   loadForm_sell(scheduleid);
		      				    	   
		      				       }
		      				  }]
		      					
		      					
		      					
		      				}
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
		      //根据调度编号获得余票
		      function getRemainSeat(scheduleid){
		    	  var value
		    	  Ext.Ajax.request({
				        url: 'ticket_remainSeat',
				        params: { "message": scheduleid },
				        method: 'get',
				     	async :  false,
				        success: function (response, options) {
				            var result = Ext.JSON.decode(response.responseText);
				            value = result.data;
				        }
				        
				    });
		    	  return value;
		      }
		
		//创建售票信息确认窗口
		var win_sell= new Ext.window.Window({
			layout:'fit',
			title:'售票',
		    width:480,
		    closeAction:'hide',
		    height:320,
			resizable : false,
			shadow : true,
			modal :true,
		    closable:true,
			items: [Ext.create('Ext.form.Panel',{
				id:'sellForm',
				autoHeight : true,
				layout : "form",
				fieldDefaults:{//统一设置表单字段默认属性
					labelSeparator :'：',//分隔符
					labelWidth : 70,//标签宽度
					style:"margin-left:20px;",
					width : 180
				},
				bodyPadding: 5,

				items :[{
					xtype:'fieldset',
					title:'车票概况',
					style:'padding:5 5 5 5',
					items:[{layout:'column',items:[{xtype:'textfield',readOnly:true,name : 'schedulename',fieldLabel:'行程名称'},
					                             {xtype:'textfield',readOnly:true,name : 'routename',fieldLabel:'线路'},
					                             ]},
					   		{layout:'column',items:[{xtype:'textfield',readOnly:true,name : 'startstationname',fieldLabel:'起点站'},
					    					     {xtype:'textfield',readOnly:true,name : 'endstationname',fieldLabel:'终点站'},
					    					      ]},
							{layout:'column',items:[{xtype:'textfield',readOnly:true,name : 'starttime',fieldLabel:'出发时间'},
					    					     {xtype:'textfield',readOnly:true,name : 'endtime',fieldLabel:'到达时间'}
					    						 ]},
					    	{layout:'column',items:[{xtype:'textfield',readOnly:true,name : 'vehicleno',fieldLabel:'车牌号'},
					    	                        {xtype:'textfield',readOnly:true,name : 'remainseat',fieldLabel:'余票'}
					    					       ]}]
					
				},{
					xtype:'fieldset',
					title:'售票信息',
					items:[{layout:'column',items:[{
														xtype:'textfield',
														name : 'customername',
														fieldLabel:'旅客姓名',
														allowBlank:false,
														blankText:'请输入旅客姓名',
														emptyText:'请输入旅客姓名',
													},{	xtype:'numberfield',
														name : 'ticketamount',
														fieldLabel:'购买张数',
														minValue:1,
														minText:'购票数量有误',
														allowBlank:false,
														blankText:'请输入购票数量',
														emptyText:'请输入购票数量',
														}

						                             ]},]
				},{xtype:'hidden',name:'checked'},
				{xtype:'hidden',name:'deadline'},
				{xtype:'hidden',name:'entrytime'},
				//{xtype:'hidden',name:'seatno'},
				//{xtype:'hidden',name:'ticketno'},
				{xtype:'hidden',name:'ticketscheduleid'},
				{xtype:'hidden',name:'tickettitle'},
				
				
				],
				
				buttons: [{
			        text: '提交',
			        handler: submitSellForm
			    }, {
			        text: '关闭',
			        handler: function () {
			            win_sell.hide();
			        }
			    }, '->']
				
				
				
			})]
		});
		      
		      
		      
		routeGrid.hide();
		 busGrid.hide();
		 
		//显示
			new Ext.container.Viewport({
				layout:'border',//表格布局
				items : routesScheduleGrid
			});
	
		
	

		

		
		
	
		
		
		//加载表单数据
		function loadForm_sell(scheduleId) {
			
		    Ext.getCmp('sellForm').getForm().load({
		        waitMsg: '正在加载数据请稍后',//提示信息
		        waitTitle: '提示',//标题
		        url: 'scheduleinfo_getById',//请求的url地址
		        params: { "message": scheduleId },
		        method: 'GET',//请求方式
				success: function(form,action){
					form.findField('remainseat').setValue(getRemainSeat(scheduleId));
					form.findField('ticketscheduleid').setValue(scheduleId);
					form.findField('checked').setValue(false);
					var tickettitle = form.findField('startstationname').getValue()+"-"+form.findField('endstationname').getValue();
					form.findField('tickettitle').setValue(tickettitle);
					var entrytime =new Date(form.findField('starttime').getValue());
					entrytime=entrytime.setTime(entrytime.getTime()-20*60000);
					form.findField('entrytime').setValue(new Date(entrytime).Format("yyyy-MM-dd hh:mm:ss"));
					deadline = new Date(entrytime);
					deadline = deadline.setTime(deadline.getTime()-5*60000);
					form.findField('deadline').setValue(new Date(deadline).Format("yyyy-MM-dd hh:mm:ss"));
					
				},

		        failure: function (form, action) {//加载失败的处理函数
		            Ext.Msg.alert('提示', '数据加载失败');
		        }
		    });
    
		}


	
		
		
//提交调度信息表单
	function submitSellForm(){
		 var msgTip = Ext.MessageBox.show({
		        title: '提示',
		        width: 250,
		        msg: '正在操作请稍后......'
		    });	
		 	list = [];
		    list.push(Ext.getCmp('sellForm').getForm().getValues());
		    var formparams = Ext.JSON.encode(list);
		    console.log(list);	
		    Ext.getCmp('sellForm').getForm().submit({
	        //    clientValidation: true,
	            url: 'ticket_add',// 文件路径
	            method: 'post',// 提交方法post或get
	            params: { "createTicketBeans": formparams },
	            // 提交成功的回调函数
	            success: function (form, submit) {
	                msgTip.hide();
	                var result = Ext.JSON.decode(submit.response.responseText);
	                if (result.success) {
	                	//routeScheduleStore.reload();
	                    Ext.Msg.alert('提示', '操作成功。');
	                    routeScheduleStore.reload();
	                } else {
	                	routeScheduleStore.reload();
	                    Ext.Msg.alert('提示', '操作失败！');
	                }
	            },
	            // 提交失败的回调函数
	            failure: function () {
	            	routeScheduleStore.reload();
	                Ext.Msg.alert('错误',
	                '服务器出现错误请稍后再试！'); win_sell.close();
	            }
	        });
		win_sell.close();				
	
	}

/**
 * 连接双控件的时间
 ***/
	function convTimeField(date,time){
	var dat = null;
	if(date!=null && time!=null)
		dat = new Date(date.setHours(time.getHours(),time.getMinutes(),time.getSeconds(),0));
	return dat;
	
}

	/**
	 * 
	 *时间下拉绑定select时间
	 */
	/* Ext.getCmp('s_t').on('change',function(){
		var startdate = routesScheduleForm.getForm().findField('starttime').getValue();
		var starttime = routesScheduleForm.getForm().findField('s_time').getValue();
		routesScheduleForm.getForm().findField('starttime').setValue(convTimeField(startdate,starttime));		
	});
	
	Ext.getCmp('e_t').on('change',function(){
		var startdate = routesScheduleForm.getForm().findField('endtime').getValue();
		var starttime = routesScheduleForm.getForm().findField('e_time').getValue();
		routesScheduleForm.getForm().findField('endtime').setValue(convTimeField(startdate,starttime));		
	});
	
	 */
	
	
		
		Ext.QuickTips.init();});

</script>
</body>
</html>