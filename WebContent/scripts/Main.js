Ext.onReady(function() {
    //主题数据
    var themes = [
        {theme: '默认', css: 'ext-all.css'},
        {theme: '黑色', css: 'ext-all-access.css'},
        {theme: '红色', css: 'ext-all-red.css'}];
    //创建主题数据模型
    Ext.regModel('Theme', {
        fields: ['theme', 'css']
    });
    //创建主题数据源
    var themeStore = Ext.create('Ext.data.Store', {
        model: 'Theme',
        data: themes
    });
    //创建主题切换选择框
    var themeChange = Ext.create('Ext.form.ComboBox', {
        id: 'themeChange',
        width: 150,
        labelWidth: 60,
        labelSeparator: '：', //分隔符
        fieldLabel: '样式选择',
        store: themeStore,
        editable: false,
        triggerAction: 'all', //单击触发按钮显示全部数据
        store: themeStore, //设置数据源
                displayField: 'theme',
        valueField: 'css',
        queryMode: 'local', //本地模式
        value: 'ext-all.css', //默认风格
        listeners: {
            'collapse': function() {
                Ext.util.CSS.swapStyleSheet('theme', './ext-4.2.1-Lite/resources/css/' + this.getValue());
                contentIframe.window.themeChange(this.getValue());
            }
        }
    });

    //创建菜单数据模型
    Ext.regModel('Menu', {
        fields: ['text', 'url']
    });
    //创建菜单树数据源
    var menuStore = Ext.create('Ext.data.TreeStore', {
        model: 'Menu',
        proxy: {
            type: 'memory',
            data: [{
                    text: '用户管理',
                    leaf: true,
                    url: ctxpath + '/adminList.jsp'
                }, {
                    text: '汽车管理',
                    leaf: true,
                    url: ctxpath + '/busList.jsp'
                }, {
                    text: '调度管理',
                    leaf: true,
                    url: ctxpath + '/RouteSchedule.jsp'
                }]
        },
        root: {
            text: '功能列表',
            url: '',
            leaf: false,
            expanded: true
        },
        listeners: {
            expand: function(node) {
                //切换内容页面
                changePage(node.get('url'), node.get('text'));
            }
        }
    });
    //切换内容页面
    function changePage(url, title) {
        var theme = Ext.getCmp('themeChange').getValue();
        Ext.getDom('contentIframe').src = url;
        //	Ext.getCmp('mainContent').setTitle(title);
    }
    //创建菜单树
    var menuTree = Ext.create('Ext.tree.Panel', {
        border: false,
        store: menuStore,
        hrefTarget: 'mainContent',
        listeners: {
            itemclick: function(view, rec, item, index, e) {
                changePage(rec.get('url'), rec.get('text'));
            }
        },
        tbar: [themeChange]
    });

    Ext.create('Ext.container.Viewport', {
        layout: 'border', //Border布局
        items: [{
                title: '用户管理',
                collapsible: true,
                html: '<br><center><font size = 6>车站售票系统</font></center>',
                region: 'north', //指定子面板所在区域为north
                height: 100
            }, {
                title: '功能菜单',
                items: menuTree,
                split: true,
                collapsible: true,
                region: 'west', //指定子面板所在区域为west
                width: 180
            }, {
                layout: 'fit',
                contentEl: 'contentIframe',
                collapsible: true,
                id: 'mainContent',
                region: 'center'//指定子面板所在区域为center
            }]
    });
});