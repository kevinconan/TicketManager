var toolbar_rt = [
   			{ text: '注册客车', iconCls: 'add', handler: showNewBus },
   			{ text: '修改客车', iconCls: 'option' },
   			{ text: '注销客车', iconCls: 'remove' }
];

//分页工具下拉框
var pagesize_combo_bs = new Ext.form.ComboBox({
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
pagesize_combo_bs.on("select", function (comboBox) {
    pageToolbar_bs.pageSize = parseInt(comboBox.getValue());
    routeStore.pageSize = parseInt(comboBox.getValue());
    routeStore.reload({ params: { start: 0, limit: pageToolbar_bs.pageSize } });
});
//分页工具栏
var pageToolbar_bs = new Ext.PagingToolbar({
    store: routeStore,
    pageSize: 10,//小点，和上面一致
    displayInfo: true,
    displayMsg: "当前显示从{0}条到{1}条，共{2}条",
    emptyMsg: "<span style='color:red;font-style:italic;'>对不起没有找到数据</span>",
    items: ['&nbsp;&nbsp;每页显示：', pagesize_combo_bs]
});
//定义表格组件
var busGrid = new Ext.grid.Panel({
    width: 690,
    height: 360,
    tbar: toolbar_bs,
    bbar: pageToolbar_bs,
    region: 'center',
    store: busStore,
    selModel: new Ext.selection.CheckboxModel(),
    columns: [//配置表格列
		{ text: "车牌号", width: '16%', dataIndex: 'vehicleno', sortable: true },
		{ text: "线路", width: '16%', dataIndex: 'busrouteid', sortable: true },
		{ text: "汽车状态", width: '16%', dataIndex: 'busstate', sortable: true },
		{ text: "所属车站", width: '16%', dataIndex: 'busstationid', sortable: true },
		{ text: "司机名", width: '16%', dataIndex: 'drivername', sortable: true },
		{ text: "座位数", width: '16%', dataIndex: 'seatcount', sortable: true }


    ]
});



//创建调度表单
var busForm = new Ext.form.Panel({
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
            blankText: '所属不能为空',
            emptyText: '请选择所属站点',
            name: 'busstationid',
            fieldLabel: '所属站点'
        }, {
            xtype: 'button',
            text: '选择发车站',
            style: "margin-left:20px;",
            handler: function () {

                var recs = stationGrid.getSelectionModel().getSelection();
                if (recs.length == 0) {
                    Ext.MessageBox.alert('提示', '请选择发车站！');
                } else if (recs.length > 1) {
                    Ext.MessageBox.alert('提示', '你只能选择一个车站');

                } else {
                    busForm.getForm().findField('busstationid').setValue(recs[0].get('stationid'));

                }


            }
        }, {
            xtype: 'textfield',
            allowBlank: false,
            blankText: '运营线路不能为空',
            emptyText: '请选择运营线路',
            name: 'busrouteid',
            fieldLabel: '运营线路'
        }, {
            xtype: 'button',
            text: '选择运营线路',
            style: "margin-left:20px;",
            handler: function () {

                var recs = routeGrid.getSelectionModel().getSelection();
                if (recs.length == 0) {
                    Ext.MessageBox.alert('提示', '请选择终点站！');
                } else if (recs.length > 1) {
                    Ext.MessageBox.alert('提示', '你只能选择一个车站');

                } else {
                    busForm.getForm().findField('endstationid').setValue(recs[0].get('stationid'));

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

            items: busForm
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

function showNewBus() {
    busForm.form.reset();
    win_rt.setTitle("新增线路");
    win_rt.show();

}
