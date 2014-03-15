<%@page import="kevin.tm.dao.model.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汽车站售票管理系统</title>
<link rel="stylesheet" type="text/css" href="./ext-4.2.1-Lite/resources/ext-theme-neptune/ext-theme-neptune-all.css" />
<script type="text/javascript" src="./ext-4.2.1-Lite/ext-all-debug.js"></script>
<script type="text/javascript" src="./ext-4.2.1-Lite/ext-theme-neptune.js"></script>
<script type="text/javascript" src="./ext-4.2.1-Lite/locale/ext-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<script type="text/javascript" src="./scripts/Main.js"></script>
</head>
<%
/*AdminBean admin = (AdminBean)request.getSession().getAttribute("LoginUser");
if(admin == null)
	response.sendRedirect("login.jsp");*/
String ctxpath = request.getContextPath();
//String userName = admin.getAdminname();
//request.setAttribute("username", userName);
%>
<script type="text/javascript">
	var ctxpath = '<%=ctxpath%>';
	
</script>
<body>
<iframe id='contentIframe' name='contentIframe' style='height:100%;width:100%;border-width:0px'></iframe>
</body>
</html>
