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
		            		selectGrid(routeGrid,routesScheduleForm,'schedulerouteid','routeid');
		            		/*var recs = routeGrid.getSelectionModel().getSelection();
		            		if(recs.length == 0){
		        				Ext.MessageBox.alert('提示','请选择调度！');
		        			}else if(recs.length >1){
		        				Ext.MessageBox.alert('提示','你只能选择一条调度');
		        				
		        			}else{
		        				routesScheduleForm.getForm().findField('schedulerouteid').setValue(recs[0].get('routeid'));
		        				
		        			}*/
		            		
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
		            		selectGrid(busGrid,routesScheduleForm,'schedulebusid','busid');
		            		
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
		    var scheduleList = getSelectionList(Ext.getCmp('routesScheduleGrid'),false);
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
		function showModifySchedule() {
		    var scheduleList = getSelectionList(Ext.getCmp('routesScheduleGrid'),true);
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
	 * 通用获取grid选中记录的指定字段，填入表单指定指定字段的方法
	 * grid:需要操作的grid，form:需要操作的form，formField:需要操作的表单名，gridrec，需要操作的grid记录字段名
	 */
	function selectGrid(grid,form,formField,gridrec){
		var recs = grid.getSelectionModel().getSelection();
		if(recs.length == 0){
			Ext.MessageBox.alert('提示','请选择一条记录！');
		}else if(recs.length >1){
			Ext.MessageBox.alert('提示','你只能选择一条');
			
		}else{
			form.getForm().findField(formField).setValue(recs[0].get(gridrec));
			
		}
	}
	
	
	
	