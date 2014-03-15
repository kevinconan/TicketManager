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
        <title>车站列表，用于测试</title>
        <link rel="stylesheet" type="text/css" href="./ext-4.2.1-Lite/resources/ext-theme-neptune/ext-theme-neptune-all.css" />
        <script type="text/javascript" src="./ext-4.2.1-Lite/ext-all-debug.js"></script>
        <script type="text/javascript" src="./ext-4.2.1-Lite/ext-theme-neptune.js"></script>
        <script type="text/javascript" src="./ext-4.2.1-Lite/locale/ext-lang-zh_CN.js"></script>
        <script type="text/javascript" src="./scripts/Models.js"></script>
        <script type="text/javascript" src="./scripts/Station.js"></script>
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

    Ext.onReady(function() {


        new Ext.container.Viewport({
            layout: 'border', //表格布局
            items: stationGrid
        });



        //创建新增或修改书籍信息的form表单
        Ext.QuickTips.init();
    });
    //创建书籍类型数据模型


        </script>
    </body>
</html>