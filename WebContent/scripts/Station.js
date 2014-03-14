
/*//定义车站数据源
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
		});*/
//定义操作工具栏
var toolbar_st = [
   			{ text: '注册车站', iconCls: 'add', handler: showAddStation },
   			{ text: '修改车站', iconCls: 'option', handler: showModifyStation },
   			{ text: '注销车站', iconCls: 'remove', handler: showDeleteStation }
];

//分页工具下拉框
var pagesize_combo_st = new Ext.form.ComboBox({
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
pagesize_combo_st.on("select", function (comboBox) {
    pageToolbar_st.pageSize = parseInt(comboBox.getValue());
    stationStore.pageSize = parseInt(comboBox.getValue());
    stationStore.reload({ params: { start: 0, limit: pageToolbar_st.pageSize } });
});
//分页工具栏
var pageToolbar_st = new Ext.PagingToolbar({
    store: stationStore,
    pageSize: 10,//小点，和上面一致
    displayInfo: true,
    displayMsg: "当前显示从{0}条到{1}条，共{2}条",
    emptyMsg: "<span style='color:red;font-style:italic;'>对不起没有找到数据</span>",
    items: ['&nbsp;&nbsp;每页显示：', pagesize_combo_st]
});
//定义表格组件
var stationGrid = new Ext.grid.Panel({
    maxWidth: 700,
    maxHeight: 380,
    tbar: toolbar_st,
    bbar: pageToolbar_st,
    region: 'center',
    store: stationStore,
    selModel: new Ext.selection.CheckboxModel(),
    columns: [//配置表格列
        { text: "车站编号", width: 80, dataIndex: 'stationid', sortable: true },
        { text: "站名", width: 80, dataIndex: 'stationname', sortable: true },
        { text: "坐标x", width: 80, dataIndex: 'locationx', sortable: true },
        { text: "坐标y", width: 80, dataIndex: 'locationy', sortable: true }
    ]
});
var stationForm = new Ext.form.Panel({
    fieldDefaults: {//统一设置表单字段默认属性
        labelSeparator: '：',//分隔符
        labelWidth: 80,//标签宽度
        msgTarget: 'side',
        width: 300
    },
    bodyPadding: 5,
    //	frame:true,
    items: [{
        xtype: 'hidden',
        allowBlank: false,
        name: 'stationid'
    }, {
        xtype: 'textfield',
        allowBlank: false,
        name: 'stationname',
        fieldLabel: '车站名'
    }, {
        xtype: 'textfield',
        allowBlank: false,
        name: 'locationx',
        fieldLabel: '坐标x'
    }, {
        xtype: 'textfield',
        name: 'locationy',
        fieldLabel: '坐标y'
    },/* ,{
		xtype:'hidden',
		name : 'id'
	} */],
    buttons: [{
        text: '提交',
        handler: submitForm_st
    }, {
        text: '关闭',
        handler: function () {
            win_st.hide();
        }
    }, '->']
});

var win_st = new Ext.window.Window({
    layout: 'fit',
    width: 380,
    closeAction: 'hide',
    height: 200,
    resizable: false,
    shadow: true,
    modal: true,
    closable: true,
    items: stationForm
});
//显示新建车站信息窗口
function showAddStation() {

    stationForm.form.reset();
    stationForm.isAdd = true;
    win_st.setTitle("新增车站");
    win_st.show();
}
//显示修改车站窗口
function showModifyStation() {
    var stationList = getSelectionList(stationGrid,true);
    var num = stationList.length;
    if (num > 1) {
        Ext.MessageBox.alert("提示", "每次只能修改一条车站信息。");
    } else if (num == 1) {
        stationForm.form.reset();
        stationForm.isAdd = false;
        win_st.setTitle("修改车站信息");
        win_st.show();
        var stationId = stationList[0];
        //	Ext.getCmp('stationid').getEl().dom.setDisabled(true);
        loadForm_st(stationId);

    }
}
//显示删除车站对话框
function showDeleteStation() {
    var stationList = getSelectionList(stationGrid,false);
    var num = stationList.length;
    if (num == 0) {
        return;
    }
    Ext.MessageBox.confirm("提示", "您确定要删除所选车站吗？", function (btnId) {
        if (btnId == 'yes') {
            deleteStation(stationList);
        }
    });
}
//删除车站
function deleteStation(stationList) {
    var stationIds = Ext.JSON.encode(stationList);
    var msgTip = Ext.MessageBox.show({
        title: '提示',
        width: 250,
        msg: '正在删除车站信息请稍后......'
    });
    Ext.Ajax.request({
        url: 'station_delete',
        params: { "deleteStationBeans": stationIds },
        method: 'POST',
        success: function (response, options) {
            msgTip.hide();
            var result = Ext.JSON.decode(response.responseText);
            if (result.success) {

                Ext.Msg.alert('提示', '删除车站信息成功。');
                stationStore.reload();
            } else {
                Ext.Msg.alert('提示', '删除车站信息失败！');
                stationStore.reload();
            }
        },
        failure: function (response, options) {
            msgTip.hide();
            Ext.Msg.alert('提示', '删除车站信息请求失败！');
            stationStore.reload();
        }
    });
    stationStore.reload();
}
//加载表单数据
function loadForm_st(stationId) {
    //	var list =[];
    //	list.push(stationId)
    //	var message=Ext.JSON.encode(list);
    stationForm.form.load({
        waitMsg: '正在加载数据请稍后',//提示信息
        waitTitle: '提示',//标题
        url: 'station_getById',//请求的url地址
        params: { "message": stationId },
        method: 'GET',//请求方式
        failure: function (form, action) {//加载失败的处理函数
            Ext.Msg.alert('提示', '数据加载失败');
        }
    });
}
//提交表单数据
function submitForm_st() {
    var msgTip = Ext.MessageBox.show({
        title: '提示',
        width: 250,
        msg: '正在添加车站信息请稍后......'
    });
    //判断当前执行的提交操作，isAdd为true表示执行车站新增操作，false表示执行车站修改操作
    list = [];
    list.push(stationForm.form.getValues());
    var formparams = Ext.JSON.encode(list);
    if (stationForm.isAdd) {
        //新增车站信息
        //	alert(Ext.JSON.encode(stationForm.form.getValues()));
        //	var formparams=Ext.JSON.encode(stationForm.form.getValues());

        stationForm.form.submit({
            clientValidation: true,
            url: 'station_add',// 文件路径
            method: 'post',// 提交方法post或get
            params: { "createStationBeans": formparams },
            // 提交成功的回调函数
            success: function (form, submit) {
                msgTip.hide();
                var result = Ext.JSON.decode(submit.response.responseText);
                if (result.success) {
                    stationStore.reload();
                    Ext.Msg.alert('提示', '添加车站信息成功。');
                } else {
                    stationStore.reload();
                    Ext.Msg.alert('提示', '添加车站信息失败！');
                }
            },
            // 提交失败的回调函数
            failure: function () {
                stationStore.reload();
                Ext.Msg.alert('错误',
                '服务器出现错误请稍后再试！'); win_st.close();
            }
        });
        win_st.close();
        /* userForm.form.submit({
			clientValidation:true,//进行客户端验证
			waitMsg : '正在提交数据请稍后',//提示信息
			waitTitle : '提示',//标题
			url : ctxpath + '/user_add',//请求的url地址
			method:'POST',//请求方式
			success:function(form,action){//加载成功的处理函数
				win.hide();
				updateBusGrid(action.result.bookId);
				Ext.Msg.alert('提示','新增车站成功');
			},
			failure:function(form,action){//加载失败的处理函数
				Ext.Msg.alert('提示','新增车站失败');
			}
		}); */
    } else {
        //修改车站信息
        stationForm.form.submit({
            clientValidation: true,//进行客户端验证
            waitMsg: '正在提交数据请稍后',//提示信息
            waitTitle: '提示',//标题
            url: 'station_update',//请求的url地址
            method: 'POST',//请求方式
            params: { "updateStationBeans": formparams },
            success: function (form, submit) {
                msgTip.hide();
                var result = Ext.JSON.decode(submit.response.responseText);
                if (result.success) {
                    stationStore.reload();
                    Ext.Msg.alert('提示', '修改车站信息成功。');
                } else {
                    stationStore.reload();
                    Ext.Msg.alert('提示', '修改车站信息失败！');
                }
            },
            // 提交失败的回调函数
            failure: function () {
                stationStore.reload();
                Ext.Msg.alert('错误',
                '服务器出现错误请稍后再试！'); win_st.close();
            }
        });
    }
}


/**
 * 获取grid选择列表id
 * @author Kevin
 * @param grid,type
 * grid:需要操作的表单
 * type：操作方式，true：修改，false，删除
 * **/
function getSelectionList(grid,type) {
	//debugger
    var recs = grid.getSelectionModel().getSelection();
    var list = [];
    var obj = {};
    if (recs.length == 0 || recs.length == null) {
        Ext.MessageBox.alert('提示', '请选择要进行操作的项目！');
    } else if(recs.length==1 && type){
        list.push(recs[0].get(recs[0].idProperty));
    }else{
    	for (var i = 0 ; i < recs.length ; i++) {
          	 list.push(recs[i].data);
        }
    	
    }
    return list;
}