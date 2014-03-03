
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
<title>书籍列表</title>
	<link rel="stylesheet" type="text/css" href="./ext-4.2.1-Lite/resources/ext-theme-neptune/ext-theme-neptune-all.css" />
	
  <script type="text/javascript" src="./ext-4.2.1-Lite/ext-all-debug.js"></script>
  <script type="text/javascript" src="./ext-4.2.1-Lite/ext-theme-neptune.js"></script>
  <script type="text/javascript" src="./ext-4.2.1-Lite/locale/ext-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
</head>
<script type="text/javascript">
	var ctxpath = '<%=ctxpath%>';
	//切换主题
	function themeChange(theme) {
		Ext.util.CSS.swapStyleSheet('theme', './ext-4.2.1-Lite/resources/css/ext-all.css');
	}
	Ext.onReady(function(){
		//创建汽车数据模型
		Ext.regModel('Bus', {
		    fields: [
				{name: 'vehicleno'},
				{name: 'busrouteid'},
				{name: 'busstate'},
				{name: 'busstationid'},
				{name: 'drivername'},
				{name: 'seatcount'},
		    ]
		});
		//定义书籍数据源对象
		var busStore = Ext.create('Ext.data.Store',{
			autoLoad :true,
			model : 'Bus',
			proxy: {
		        type: 'ajax',
		        url : ctxpath+'/bus_list',
		        reader: {
		            type: 'json',
		            totalRecords: 'results',
		            idProperty : 'vehicleno'
		         //   record: 'Book'
		        }
		    }
		});
		//创建工具栏组件
		var toolbar = [
			{text : '注册汽车',iconCls:'add',handler:showAddUser},
			{text : '修改汽车',iconCls:'option',handler:showModifyUser},
			{text : '注销汽车',iconCls:'remove',handler:showDeleteUsers}
		];
		//创建Grid表格组件
		var busGrid = new Ext.grid.Panel({
			tbar : toolbar,
			region: 'center',
			store: busStore,
			selModel : new Ext.selection.CheckboxModel(),
			columns: [//配置表格列
				{text: "车牌号", width: 80, dataIndex: 'vehicleno', sortable: true},
				{text: "线路ID", width: 80, dataIndex: 'busrouteid', sortable: true},
				{text: "汽车状态", width: 80, dataIndex: 'busstate', sortable: true},
				{text: "所属车站", width: 80, dataIndex: 'busstationid', sortable: true},
				{text: "司机名", width: 80, dataIndex: 'drivername', sortable: true},
				{text: "座位数", width: 80, dataIndex: 'seatcount', sortable: true}

				
			]
		});
		new Ext.container.Viewport({
			layout:'border',//表格布局
			items : busGrid
		});
		//创建新增或修改书籍信息的form表单
		Ext.QuickTips.init();
		//创建书籍类型数据模型
		
		var busForm = new Ext.form.Panel({
			fieldDefaults:{//统一设置表单字段默认属性
				labelSeparator :'：',//分隔符
				labelWidth : 80,//标签宽度
				msgTarget : 'side',
				width : 300
			},
			bodyPadding: 5,
			frame:true,
			items : [{
				xtype:'textfield',
				allowBlank : false,
				blankText : '用户编号不能为空',
				name : 'userid',
				fieldLabel:'用户编号'
			},{
				xtype:'textfield',
				allowBlank : false,
				blankText : '用户名不能为空',
				name : 'username',
				fieldLabel:'用户名'
			},/* {
				xtype:'combo',
				autoShow : true,
				allowBlank : false,
				blankText : '必须选择书籍类型',
				name : 'bookTypeId',
				store : new Ext.data.Store({
					autoLoad :true,
					model : 'BookType',
					proxy: {
				        type: 'ajax',
				        url : '',
				        reader: {
				            type: 'xml',
				            record: 'BookType'
				        }
				    }
				}),//设置数据源
				allQuery:'allbook',//查询全部信息的查询字符串
				triggerAction: 'all',//单击触发按钮显示全部数据
				editable : false,//禁止编辑
				loadingText : '正在加载书籍类型信息',//加载数据时显示的提示信息
				displayField:'title',//定义要显示的字段
				valueField : 'id',
				emptyText :'请选择书籍类型',
				queryMode: 'remote',//远程模式
				fieldLabel:'类型'
			}, */{
				xtype:'textfield',
				inputType:'password',
				name : 'userpassword',
				fieldLabel:'密码'
			},{
				xtype:'textfield',
				name : 'userstate',
				fieldLabel:'用户状态'
			}/* ,{
				xtype:'hidden',
				name : 'id'
			} */],
			buttons:[{
				text : '提交',
				handler : submitForm
			},{
				text : '关闭',
				handler : function(){
					win.hide();
				}
			},'->']
		});
		//创建弹出窗口
		var win = new Ext.window.Window({
			layout:'fit',
		    width:380,
		    closeAction:'hide',
		    height:200,
			resizable : false,
			shadow : true,
			modal :true,
		    closable:true,
			items:userForm
		});
		//显示新建书籍窗口
		function showAddUser(){
			userForm.form.reset();
			userForm.isAdd = true;
			win.setTitle("新增用户");
			win.show();
		}
		//显示修改书籍窗口
		function showModifyUser(){
			var bookList = getBookIdList();
			var num = bookList.length;
			if(num > 1){
				Ext.MessageBox.alert("提示","每次只能修改一条书籍信息。");
			}else if(num == 1){
				bookForm.form.reset();
				bookForm.isAdd = false;
				win.setTitle("修改用户信息");
				win.show();
				var bookId = bookList[0];
				loadForm(bookId);
			}
		}
		//显示删除书籍对话框
		function showDeleteUsers(){
			var bookList = getBookIdList();
			var num = bookList.length;
			if(num == 0){
				return;
			}
			Ext.MessageBox.confirm("提示","您确定要删除所选书籍吗？",function(btnId){
				if(btnId == 'yes'){
					deleteBooks(bookList);
				}
			});
		}
		//删除书籍
		function deleteBooks(bookList){
			var bookIds = bookList.join(',');
			var msgTip = Ext.MessageBox.show({
				title:'提示',
				width : 250,
				msg:'正在删除书籍信息请稍后......'
			});
			Ext.Ajax.request({
				url : ctxpath + '/bookext.do?method=deleteBooks',
				params : {bookIds : bookIds},
				method : 'POST',
				success : function(response,options){
					msgTip.hide();
					var result = Ext.JSON.decode(response.responseText);
					if(result.success){
						//服务器端数据成功删除后，同步删除客户端列表中的数据
						for(var i = 0 ; i < bookList.length ; i++){
							var index = bookStore.find('id',bookList[i]);
							if(index != -1){
								var rec = bookStore.getAt(index);
								bookStore.remove(rec);
							}
						}
						Ext.Msg.alert('提示','删除书籍信息成功。');
					}else{
						Ext.Msg.alert('提示','删除书籍信息失败！');
					}
				},
				failure : function(response,options){
					msgTip.hide();
					Ext.Msg.alert('提示','删除书籍信息请求失败！');
				}
			});
		}
		//加载表单数据
		function loadForm(bookId){
			bookForm.form.load({
				waitMsg : '正在加载数据请稍后',//提示信息
				waitTitle : '提示',//标题
				url : ctxpath + '/bookext.do?method=getBookById',//请求的url地址
				params : {bookId:bookId},
				method:'GET',//请求方式
				failure:function(form,action){//加载失败的处理函数
					Ext.Msg.alert('提示','数据加载失败');
				}
			});
		}
		//提交表单数据
		function submitForm(){
			//判断当前执行的提交操作，isAdd为true表示执行书籍新增操作，false表示执行书籍修改操作
			if(userForm.isAdd){
				//新增书籍信息
				alert(Ext.JSON.encode(userForm.form.getValues()));
				/* userForm.form.submit({
					clientValidation:true,//进行客户端验证
					waitMsg : '正在提交数据请稍后',//提示信息
					waitTitle : '提示',//标题
					url : ctxpath + '/user_add',//请求的url地址
					method:'POST',//请求方式
					success:function(form,action){//加载成功的处理函数
						win.hide();
						updateBookGrid(action.result.bookId);
						Ext.Msg.alert('提示','新增书籍成功');
					},
					failure:function(form,action){//加载失败的处理函数
						Ext.Msg.alert('提示','新增书籍失败');
					}
				}); */
			}else{
				//修改书籍信息
				bookForm.form.submit({
					clientValidation:true,//进行客户端验证
					waitMsg : '正在提交数据请稍后',//提示信息
					waitTitle : '提示',//标题
					url : ctxpath+'/bookext.do?method=modifyBook',//请求的url地址
					method:'POST',//请求方式
					success:function(form,action){//加载成功的处理函数
						win.hide();
						updateBookGrid(action.result.bookId);
						Ext.Msg.alert('提示','修改书籍成功');
					},
					failure:function(form,action){//加载失败的处理函数
						Ext.Msg.alert('提示','修改书籍失败');
					}
				});
			}
		}
		//明细数据修改后，同步更新书籍列表信息
		function updateBookGrid(bookId){
			var values = bookForm.form.getValues();
			var index = bookStore.find('id',values['id']);
			var bookTypeField = bookForm.form.findField('bookTypeId');
			var bookTypeName = bookTypeField.getRawValue();
			if(index != -1){
				var item = bookStore.getAt(index);
				for(var fieldName in values){
					item.set(fieldName,values[fieldName]);
				}
				item.set('typeName',bookTypeName);
				item.commit();
			}else{
				var rec = Ext.ModelMgr.create({
					id : bookId,
					bookName : values['bookName'],
					author : values['author'],
					typeName : bookTypeName,
					price : values['price'],
					brief : values['brief']
				}, 'Book');
				bookStore.add(rec);
			}
		}
		//取得所选书籍id
		function getBookIdList(){
			var recs = bookGrid.getSelectionModel().getSelection();
			var list = [];
			if(recs.length == 0){
				Ext.MessageBox.alert('提示','请选择要进行操作的书籍！');
			}else{
				for(var i = 0 ; i < recs.length ; i++){
					var rec = recs[i];
					list.push(rec.get('id'));
				}
			}
			return list;
		}
	});
</script>
<body></body>
</html>