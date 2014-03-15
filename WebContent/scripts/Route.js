var toolbar_rt = [
   			{ text: '注册线路', iconCls: 'add', handler: showNewRoute },
   			{ text: '修改线路', iconCls: 'option',handler:showModifyRoute},
   			{ text: '注销线路', iconCls: 'remove' ,handler:showDeleteRoute}
];

//分页工具下拉框
var pagesize_combo_rt = new Ext.form.ComboBox({
    store: [[5, '5条'], [10, '10条'], [20, '20条'], [40, '40条'], [60, '60条'], [100, '100条']],
    width: 70,
    emptyText: '10条',
    mode: 'remote',
    name: 'pageSize',
    editable: false,
    triggerAction: 'all',
    valueField: 'value',
    displayField: 'text'
});
//绑定分页下拉框更改事件
pagesize_combo_rt.on("select", function (comboBox) {
    pageToolbar_rt.pageSize = parseInt(comboBox.getValue());
    routeStore.pageSize = parseInt(comboBox.getValue());
    routeStore.reload({ params: { start: 0, limit: pageToolbar_rt.pageSize } });
});
//分页工具栏
var pageToolbar_rt = new Ext.PagingToolbar({
    store: routeStore,
    pageSize: 10,//小点，和上面一致
    displayInfo: true,
    displayMsg: "当前显示从{0}条到{1}条，共{2}条",
    emptyMsg: "<span style='color:red;font-style:italic;'>对不起没有找到数据</span>",
    items: ['&nbsp;&nbsp;每页显示：', pagesize_combo_rt]
});
//定义表格组件
var routeGrid = new Ext.grid.Panel({
    width: 690,
    height: 350,
    tbar: toolbar_rt,
    bbar: pageToolbar_rt,
    region: 'center',
    store: routeStore,
    selModel: new Ext.selection.CheckboxModel(),
    columns: [//配置表格列
            { text: "线路号", width: '24%', dataIndex: 'routeid', sortable: true },
            { text: "线路名", width: '24%', dataIndex: 'routename', sortable: true },
            { text: "出发站", width: '24%', dataIndex: 'startstationname', sortable: true },
            { text: "终点站", width: '24%', dataIndex: 'endstationname', sortable: true }
    ]
});



//创建调度表单
var routeForm = new Ext.form.Panel({
    autoHeight: true,
    layout: "form",
    fieldDefaults: {//统一设置表单字段默认属性
        labelSeparator: '：',//分隔符
        labelWidth: 80,//标签宽度
        style: "margin-left:20px;",

        //	msgTarget : 'side',
        width: 200
    },
    bodyPadding: 5,
    //	frame:true,
    items: [{//第一行
        layout: 'column',
        items: [{
            xtype: 'hidden',
          //  allowBlank: false,
            name: 'routeid'
        }, {
            xtype: 'textfield',
            allowBlank: false,
            blankText: '发车站不能为空',
            emptyText: '请选择发车站点',
            name: 'startstationid',
            fieldLabel: '发车站点'
        }, {
            xtype: 'button',
            text: '选择发车站',
            style: "margin-left:20px;",
            handler: function () {

            	if(stationGrid.isHidden()){
            		stationGrid.show();
            	}else{		
                var recs = stationGrid.getSelectionModel().getSelection();
                if (recs.length == 0) {
                    Ext.MessageBox.alert('提示', '请选择发车站！');
                } else if (recs.length > 1) {
                    Ext.MessageBox.alert('提示', '你只能选择一个车站');

                } else {
                    routeForm.getForm().findField('startstationid').setValue(recs[0].get('stationid'));

                }

            	}
            }
        }, {
            xtype: 'textfield',
            allowBlank: false,
            blankText: '终点站不能为空',
            emptyText: '请选择终点站',
            name: 'endstationid',
            fieldLabel: '终点站'
        }, {
            xtype: 'button',
            text: '选择终点站',
            style: "margin-left:20px;",
            handler: function () {

            	if(stationGrid.isHidden()){
            		stationGrid.show();
            	}else{	
                var recs = stationGrid.getSelectionModel().getSelection();
                if (recs.length == 0) {
                    Ext.MessageBox.alert('提示', '请选择终点站！');
                } else if (recs.length > 1) {
                    Ext.MessageBox.alert('提示', '你只能选择一个车站');

                } else {
                    routeForm.getForm().findField('endstationid').setValue(recs[0].get('stationid'));

                }


            	}
            }
        }]

    }, {
        layout: 'column',

        items: [{

            xtype: 'textfield',
            allowBlank: false,
            blankText: '线路名称不能为空',
            name: 'routename',
            fieldLabel: '线路名称'
        }, {
            xtype: 'button',
            text: '&nbsp;&nbsp;提交&nbsp;&nbsp;',
            style: "margin-left:20px;",
            handler:function(){
            	Ext.MessageBox.confirm("提示", "您确定要提交吗？", function (btnId) {
            	//	alert(btnId);
                    if (btnId == 'yes') {
                    	submitForm_rt();
                    }
                });
            	
            	
            }

        }]
    }
    ]
});

var panel_rt = new Ext.panel.Panel({
    //	width:'99%',
    //	 height:'99%',
    layout: 'fit',
    //bodyPadding : 0,
    items: [{
        layout: 'auto',
        //		bodyPadding : 0,
        maxWidth: 750,
        maxHeight: 500,
        items: [{

            items: routeForm
        }, {

            items: [stationGrid]
        }]
    }, {
        //	layout:'accordion',
        items: []
    }]
});

//创建弹出窗口
var win_rt = new Ext.window.Window({
    layout: 'fit',
    width: 700,
    closeAction: 'hide',
    height: 500,
    resizable: false,
    shadow: true,
    modal: true,
    closable: true,
    items: [panel_rt]
});
//新增线路
function showNewRoute() {

	routeForm.isAdd = true;
    routeForm.form.reset();
    win_rt.setTitle("新增线路");
    win_rt.show();

}
function showDeleteRoute() {
    //var busList = getStationIdList();
    var routeList = getSelectionList(routeGrid,false);
    var num = routeList.length;
    if (num == 0) {
        return;
    }
    Ext.MessageBox.confirm("提示", "您确定要删除所选线路吗？", function (btnId) {
        if (btnId == 'yes') {
            deleteRoute(routeList);
        }
    });
}

function deleteRoute(routeList) {
    var routeIds = Ext.JSON.encode(routeList);
    var msgTip = Ext.MessageBox.show({
        title: '提示',
        width: 250,
        msg: '正在删除线路信息请稍后......'
    });
    Ext.Ajax.request({
        url: 'route_delete',
        params: { "deleteRouteBeans": routeIds },
        method: 'POST',
        success: function (response, options) {
            msgTip.hide();
            var result = Ext.JSON.decode(response.responseText);
            if (result.success) {

                Ext.Msg.alert('提示', '删除线路信息成功。');
                routeStore.reload();
            } else {
                Ext.Msg.alert('提示', '删除线路信息失败！');
                routeStore.reload();
            }
        },
        failure: function (response, options) {
            msgTip.hide();
            Ext.Msg.alert('提示', '删除线路信息请求失败！');
            routeStore.reload();
        }
    });
    win_rt.hide();
    routeStore.reload();
}



//加载表单数据
function loadForm_rt(routeId) {
    //	var list =[];
    //	list.push(routeId)
    //	var message=Ext.JSON.encode(list);
    routeForm.form.load({
        waitMsg: '正在加载数据请稍后',//提示信息
        waitTitle: '提示',//标题
        url: 'route_getById',//请求的url地址
        params: { "message": routeId },
        method: 'GET',//请求方式
        failure: function (form, action) {//加载失败的处理函数
            Ext.Msg.alert('提示', '数据加载失败');
        }
    });
}


//显示修改线路窗口
function showModifyRoute() {
    var routeList = getSelectionList(routeGrid,true);
    var num = routeList.length;
    if (num > 1) {
        Ext.MessageBox.alert("提示", "每次只能修改一条线路信息。");
    } else if (num == 1) {
        routeForm.form.reset();
        routeForm.isAdd = false;
        win_rt.setTitle("修改线路信息");
        win_rt.show();
        var routeId = routeList[0];
        //	Ext.getCmp('stationid').getEl().dom.setDisabled(true);
        loadForm_rt(routeId);

    }
}


//提交表单数据
function submitForm_rt() {
    var msgTip = Ext.MessageBox.show({
        title: '提示',
        width: 250,
        msg: '正在添加线路信息请稍后......'
    });
    //判断当前执行的提交操作，isAdd为true表示执行线路新增操作，false表示执行线路修改操作
    list = [];
    list.push(routeForm.form.getValues());
    var formparams = Ext.JSON.encode(list);
    if (routeForm.isAdd) {
        //新增线路信息
        //	alert(Ext.JSON.encode(routeForm.form.getValues()));
        //	var formparams=Ext.JSON.encode(routeForm.form.getValues());

        routeForm.form.submit({
            clientValidation: true,
            url: 'route_add',// 文件路径
            method: 'post',// 提交方法post或get
            params: { "createRouteBeans": formparams },
            // 提交成功的回调函数
            success: function (form, submit) {
                msgTip.hide();
                var result = Ext.JSON.decode(submit.response.responseText);
                if (result.success) {
                    routeStore.reload();
                    Ext.Msg.alert('提示', '添加线路信息成功。');
                } else {
                    routeStore.reload();
                    Ext.Msg.alert('提示', '添加线路信息失败！');
                }
            },
            // 提交失败的回调函数
            failure: function () {
                routeStore.reload();
                Ext.Msg.alert('错误',
                '服务器出现错误请稍后再试！'); win_rt.close();
            }
        });
        win_rt.close();
        /* userForm.form.submit({
			clientValidation:true,//进行客户端验证
			waitMsg : '正在提交数据请稍后',//提示信息
			waitTitle : '提示',//标题
			url : ctxpath + '/user_add',//请求的url地址
			method:'POST',//请求方式
			success:function(form,action){//加载成功的处理函数
				win.hide();
				updateBusGrid(action.result.bookId);
				Ext.Msg.alert('提示','新增线路成功');
			},
			failure:function(form,action){//加载失败的处理函数
				Ext.Msg.alert('提示','新增线路失败');
			}
		}); */
    } else {
        //修改线路信息
        routeForm.form.submit({
            clientValidation: true,//进行客户端验证
            waitMsg: '正在提交数据请稍后',//提示信息
            waitTitle: '提示',//标题
            url: 'route_update',//请求的url地址
            method: 'POST',//请求方式
            params: { "updateRouteBeans": formparams },
            success: function (form, submit) {
                msgTip.hide();
                var result = Ext.JSON.decode(submit.response.responseText);
                if (result.success) {
                    routeStore.reload();
                    Ext.Msg.alert('提示', '修改线路信息成功。');
                } else {
                    routeStore.reload();
                    Ext.Msg.alert('提示', '修改线路信息失败！');
                }
            },
            // 提交失败的回调函数
            failure: function () {
                routeStore.reload();
                Ext.Msg.alert('错误',
                '服务器出现错误请稍后再试！'); win_rt.close();
            }
        });
        win_rt.close();
    }
}
