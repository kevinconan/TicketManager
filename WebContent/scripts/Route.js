var toolbar_rt = [
   			{ text: '注册线路', iconCls: 'add', handler: showNewRoute },
   			{ text: '修改线路', iconCls: 'option' },
   			{ text: '注销线路', iconCls: 'remove' }
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
            { text: "出发站", width: '24%', dataIndex: 'startstationid', sortable: true },
            { text: "终点站", width: '24%', dataIndex: 'endstationid', sortable: true }
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
            handler: function () { }

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

function showNewRoute() {

    routeForm.form.reset();
    win_rt.setTitle("新增线路");
    win_rt.show();

}
