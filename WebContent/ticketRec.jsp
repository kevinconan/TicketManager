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
		
		var searchForm = new Ext.form.Panel({
		   //  height: 20,
		   	fieldDefaults: {//统一设置表单字段默认属性
       		labelSeparator: '：',//分隔符
       		labelWidth: 55,//标签宽度
        	style: "margin-left:20px;",
        	width: 200
    		},

		     baseCls: "x-plain",
		     items: [{
		    	 layout: 'column',
		    	 items:[{
				      fieldLabel: "终点站",
				      name: "namestation",
				      allowBlank: false,//禁止为空
				      xtype : 'textfield',
				     // blankText: ""
				     },{
				      fieldLabel: "起点站",
				      name: "startstation",
				      allowBlank: false,//禁止为空
				      xtype : 'datefield',
				     }]
		     },
		             
		             ]
		    });

		var toolbar_tr = [
		         			{text : '新增调度',iconCls:'add',handler:showNewSchedule},
		         			{text : '修改调度',iconCls:'option',handler:showModifyRoute},
		         			searchForm,
		         			{text : '搜索',iconCls:'remove'}
		         		];
		
		
		

		      //分页工具下拉框
		      var pagesize_combo_tr = new Ext.form.ComboBox({   
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
		      pagesize_combo_tr.on("select",function(comboBox){          
		      	pageToolbar_tr.pageSize = parseInt(comboBox.getValue());
		      	ticketStore.pageSize = parseInt(comboBox.getValue());
		      	ticketStore.reload({params:{start:0,limit:pageToolbar_tr.pageSize}});   
		      });
		      //分页工具栏
		      var pageToolbar_tr=new Ext.PagingToolbar({
		      	  store:ticketStore,
		      	  pageSize:10,//小点，和上面一致
		      	  displayInfo:true,
		      	  displayMsg:"当前显示从{0}条到{1}条，共{2}条",
		      	  emptyMsg:"<span style='color:red;font-style:italic;'>对不起没有找到数据</span>",
		      	  items:[ '&nbsp;&nbsp;每页显示记录数量：',pagesize_combo_tr]
		      	 });
		      //定义表格组件
		      
		     
		      var ticketGrid = new Ext.grid.Panel({

		      			tbar : toolbar_tr,
		      			bbar : pageToolbar_tr,
		      			region: 'center',
		      			store: ticketStore,
		      			selModel : new Ext.selection.CheckboxModel(),
		      			columns: [//配置表格列
		      				{text: "票号", width: 80, dataIndex: 'ticketno', sortable: true},
		      				{text: "票名", width: 80, dataIndex: 'tickettitle', sortable: true,},
		      				{text: "出发站点", width: 80, dataIndex: 'startstationname', sortable: true},
		      				{text: "到达站点", width: 80, dataIndex: 'endstationname', sortable: true},
		      				{text: "出发时间", width: 80, dataIndex: 'starttime', sortable: true},	
		      				{text: "到达时间", width: 80, dataIndex: 'endtime', sortable: true},
		      				{text: "行程名", width: 80, dataIndex: 'schedulename', sortable: true},
		      				{text: "线路名", width: 80, dataIndex: 'routename', sortable: true},
		      				{text: "座位数", width: 80, dataIndex: 'seatno', sortable: true},
		      				{text: "开始检票时间", width: 80, dataIndex: 'entrytime', sortable: true},
		      				{text: "检票截止时间", width: 80, dataIndex: 'deadline', sortable: true},
		      				{text: "是否检票", width: 80, dataIndex: 'checked', sortable: true},
		      				
		      			],
		      			/* beforeshow:function(value,op){
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
		      	        } */
		      		});
		
		 
		//显示
			new Ext.container.Viewport({
				layout:'border',//表格布局
				items : ticketGrid
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
					xtype:'hidden',
					name:'scheduleid',
				},{
					xtype:'textfield',
					allowBlank : false,
					blankText : '调度调度不能为空',
					emptyText : '请选择调度',
					readOnly : true,
					name : 'schedulerouteid',
					fieldLabel:'调度调度'
				},{
		            xtype: 'button',
		            text : '选择调度',
		            style:"margin-left:20px;",
		            handler:function(){
		            
		            	if(routeGrid.isHidden()){
		            		routeGrid.show();
		            	}else{
		            		var recs = routeGrid.getSelectionModel().getSelection();
		            		if(recs.length == 0){
		        				Ext.MessageBox.alert('提示','请选择调度！');
		        			}else if(recs.length >1){
		        				Ext.MessageBox.alert('提示','你只能选择一条调度');
		        				
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
					readOnly : true,
					name : 'schedulebusid',
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
		        				routesScheduleForm.getForm().findField('schedulebusid').setValue(recs[0].get('busid'));
		        				
		        			}
		            		
		            	}
		            	routeGrid.hide();
		       		 
		            	
		            }
		        }]
				
			},{
				layout : 'column',
				items : [{
			        xtype: 'datefield',
			        name: 'starttime',
			        fieldLabel: '出发时间',
			        emptyText : '请选择日期',
			        anchor: '100%',
			        editable : false,
			        altFormats:'Y-m-d H:i:s',
			        format : 'Y-m-d H:i:s',
			        submitFormat :'Y-m-d H:i:s '
			    },{
			        xtype: 'timefield',
			        id : 's_t',
			        name: 's_time',
			        emptyText : '时间',
			        anchor: '50%',
			        style:"margin-left:0px;",
			        width : 86,
			        altFormats:'H:i:s',
			        format : 'H:i:s'
			    }, {
			        xtype: 'datefield',
			        name: 'endtime',
			        emptyText : '请选择日期',
			        fieldLabel: '到达时间',
			        anchor: '100%',
			        editable : false,
			        altFormats:'Y-m-d H:i:s',
			        format : 'Y-m-d H:i:s',
			        submitFormat :'Y-m-d H:i:s '
			   },{
			        xtype: 'timefield',
			        id :'e_t',
			        name: 'e_time',
			        emptyText : '时间',
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

		function showDeleteSchedule() {
		    //var busList = getStationIdList();
		    var scheduleList = getSelectionList(ticketGrid,false);
		    var num = scheduleList.length;
		    if (num == 0) {
		        return;
		    }
		    Ext.MessageBox.confirm("提示", "您确定要删除所选调度吗？", function (btnId) {
		        if (btnId == 'yes') {
		            deleteSchedule(scheduleList);
		        }
		    });
		}
		
		
		function deleteSchedule(scheduleList) {
			
		    var scheduleIds = Ext.JSON.encode(scheduleList);
		    var msgTip = Ext.MessageBox.show({
		        title: '提示',
		        width: 250,
		        msg: '正在删除调度信息请稍后......'
		    });
		    Ext.Ajax.request({
		        url: 'routeschedule_delete',
		        params: { "deleteRouteScheduleBeans": scheduleIds },
		        method: 'POST',
		        success: function (response, options) {
		            msgTip.hide();
		            var result = Ext.JSON.decode(response.responseText);
		            if (result.success) {

		                Ext.Msg.alert('提示', '删除调度信息成功。');
		                routeScheduleStore.reload();
		            } else {
		                Ext.Msg.alert('提示', '删除调度信息失败！');
		                routeScheduleStore.reload();
		            }
		        },
		        failure: function (response, options) {
		            msgTip.hide();
		            Ext.Msg.alert('提示', '删除调度信息请求失败！');
		            routeScheduleStore.reload();
		        }
		    });
		    win.hide();
		    routeScheduleStore.reload();
		}
		
		
		//加载表单数据
		function loadForm_rs(scheduleId) {
			
		    routesScheduleForm.form.load({
		        waitMsg: '正在加载数据请稍后',//提示信息
		        waitTitle: '提示',//标题
		        url: 'routeschedule_getById',//请求的url地址
		        params: { "message": scheduleId },
		        method: 'GET',//请求方式
		        success: function(form, action){
		        	var startdate = form.findField('starttime').getValue();
			        var enddate = form.findField('endtime').getValue();
			        form.findField('s_time').setValue(new Date(startdate));
			        form.findField('e_time').setValue(new Date(enddate));
		        	
		        },
		        failure: function (form, action) {//加载失败的处理函数
		            Ext.Msg.alert('提示', '数据加载失败');
		        }
		    });
    
		}


		//显示修改调度窗口
		function showModifyRoute() {
		    var scheduleList = getSelectionList(ticketGrid,true);
		    var num = scheduleList.length;
		    if (num > 1) {
		        Ext.MessageBox.alert("提示", "每次只能修改一条调度信息。");
		    } else if (num == 1) {
		        routesScheduleForm.form.reset();
		        routesScheduleForm.isAdd = false;
		        win.setTitle("修改调度信息");
		        win.show();
		        var scheduleId = scheduleList[0];
		        //	Ext.getCmp('stationid').getEl().dom.setDisabled(true);
		        loadForm_rs(scheduleId);
		        
		    }
		}		
		
		
		
//提交调度信息表单
	function submitScheduleForm(){
		 var msgTip = Ext.MessageBox.show({
		        title: '提示',
		        width: 250,
		        msg: '正在添加调度信息请稍后......'
		    });
	//连接控件时间
	
		 	list = [];
		    list.push(routesScheduleForm.form.getValues());
		    var formparams = Ext.JSON.encode(list);
		    console.log(list);	
		if(routesScheduleForm.isAdd){//新增提交
			routesScheduleForm.form.submit({
	        //    clientValidation: true,
	            url: 'routeschedule_add',// 文件路径
	            method: 'post',// 提交方法post或get
	            params: { "createRouteScheduleBeans": formparams },
	            // 提交成功的回调函数
	            success: function (form, submit) {
	                msgTip.hide();
	                var result = Ext.JSON.decode(submit.response.responseText);
	                if (result.success) {
	                	routeScheduleStore.reload();
	                    Ext.Msg.alert('提示', '添加调度信息成功。');
	                } else {
	                	routeScheduleStore.reload();
	                    Ext.Msg.alert('提示', '添加调度信息失败！');
	                }
	            },
	            // 提交失败的回调函数
	            failure: function () {
	            	routeScheduleStore.reload();
	                Ext.Msg.alert('错误',
	                '服务器出现错误请稍后再试！'); win.close();
	            }
	        });
		win.close();		
		}else{
			routesScheduleForm.form.submit({
		            clientValidation: true,//进行客户端验证
		            waitMsg: '正在提交数据请稍后',//提示信息
		            waitTitle: '提示',//标题
		            url: 'routeschedule_update',//请求的url地址
		            method: 'POST',//请求方式
		            params: { "updateRouteScheduleBeans": formparams },
		            success: function (form, submit) {
		                msgTip.hide();
		                var result = Ext.JSON.decode(submit.response.responseText);
		                if (result.success) {
		                	routeScheduleStore.reload();
		                    Ext.Msg.alert('提示', '修改调度信息成功。');
		                    win.close();
		                } else {
		                	routeScheduleStore.reload();
		                    Ext.Msg.alert('提示', '修改调度信息失败！');
		                    win.close();
		                }
		            },
		            // 提交失败的回调函数
		            failure: function () {
		            	routeScheduleStore.reload();
		                Ext.Msg.alert('错误',
		                '服务器出现错误请稍后再试！'); win.close();
		            }
		        });
		        win.close();
			
			
			
		}
	
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
	Ext.getCmp('s_t').on('change',function(){
		var startdate = routesScheduleForm.getForm().findField('starttime').getValue();
		var starttime = routesScheduleForm.getForm().findField('s_time').getValue();
		routesScheduleForm.getForm().findField('starttime').setValue(convTimeField(startdate,starttime));		
	});
	
	Ext.getCmp('e_t').on('change',function(){
		var startdate = routesScheduleForm.getForm().findField('endtime').getValue();
		var starttime = routesScheduleForm.getForm().findField('e_time').getValue();
		routesScheduleForm.getForm().findField('endtime').setValue(convTimeField(startdate,starttime));		
	});
	
	
	
	
		
		Ext.QuickTips.init();});

</script>
</body>
</html>