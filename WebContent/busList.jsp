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
<title>汽车列表</title>
	<link rel="stylesheet" type="text/css" href="./ext-4.2.1-Lite/resources/ext-theme-neptune/ext-theme-neptune-all.css" />
	
  <script type="text/javascript" src="./ext-4.2.1-Lite/ext-all-debug.js"></script>
  <script type="text/javascript" src="./ext-4.2.1-Lite/ext-theme-neptune.js"></script>
  <script type="text/javascript" src="./ext-4.2.1-Lite/locale/ext-lang-zh_CN.js"></script>
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
		//创建汽车数据模型
		Ext.regModel('Bus', {
		    fields: [
				{name: 'vehicleno'},
				{name: 'routename'},
				{name: 'busstate'},
				{name: 'stationname'},
				{name: 'drivername'},
				{name: 'seatcount'},
		    ]
		});
		
		//定义汽车数据源对象
		var busStore = Ext.create('Ext.data.JsonStore',{
			autoLoad :true,
			model : 'Bus',
			proxy: {
		        type: 'ajax',
		        url : 'bus_list',
		        reader: {
		            type: 'json',
		            totalRecords: 'results',
		            idProperty : 'vehicleno'
		         //   record: 'Book'
		        }
		    }
		});
		//创建车站数据模型
		Ext.regModel('Station', {
		    fields: [
				{name: 'stationid'},
				{name: 'stationname'},
				{name: 'locationx'},
				{name: 'locationy'}
		    ]
		});
		//创建线路数据模型
		Ext.regModel('Route', {
		    fields: [
				{name: 'routeid'},
				{name: 'routename'},
				{name: 'startstationid'},
				{name: 'endstationid'},
		    ]
		});
		//创建工具栏组件
		var toolbar = [
			{text : '注册汽车',iconCls:'add',handler:showAddBus},
			{text : '修改汽车',iconCls:'option',handler:showModifyBus},
			{text : '注销汽车',iconCls:'remove',handler:showDeleteBuses}
		];
		//创建Grid表格组件
		var busGrid = new Ext.grid.Panel({
			tbar : toolbar,
			region: 'center',
			store: busStore,
			selModel : new Ext.selection.CheckboxModel(),
			columns: [//配置表格列
				{text: "车牌号", width: 80, dataIndex: 'vehicleno', sortable: true},
				{text: "线路", width: 80, dataIndex: 'routename', sortable: true},
				{text: "汽车状态", width: 80, dataIndex: 'busstate', sortable: true},
				{text: "所属车站", width: 80, dataIndex: 'stationname', sortable: true},
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
				blankText : '车牌号不能为空',
				name : 'vehicleno',
				fieldLabel:'车牌号'
			},{
				xtype:'combo',
				autoShow : true,
				allowBlank : false,
				blankText : '必须选择线路',
				name : 'busrouteid',
				store : new Ext.data.JsonStore({
				//	autoLoad :true,
					model : 'Route',
					proxy: {
				        type: 'ajax',
				        url : 'route_list',
				        reader: {
				            type: 'json',
				       //     record: 'results',
				            idProperty : 'routeid'
				        }
				    }
				}),//设置数据源
		//		allQuery:'allbook',//查询全部信息的查询字符串
				triggerAction: 'all',//单击触发按钮显示全部数据
				editable : false,//禁止编辑
				loadingText : '正在加载线路信息',//加载数据时显示的提示信息
				displayField:'routename',//定义要显示的字段
				valueField : 'routeid',
				emptyText :'请选择线路',
				queryMode: 'remote',//远程模式
				fieldLabel:'线路'
			},{
				xtype:'textfield',
				allowBlank : false,
				blankText : '车辆状态不能为空',
				name : 'busstate',
				fieldLabel:'车辆状态'
			},{
				xtype:'combo',
				autoShow : true,
				allowBlank : false,
				blankText : '必须选择所属车站',
				name : 'busstationid',
				store : new Ext.data.JsonStore({
				//	autoLoad :true,
					model : 'Station',
					proxy: {
				        type: 'ajax',
				        url : 'station_list',
				        reader: {
				            type: 'json',
				          //  record: 'results',
				            idProperty : 'stationid'
				        }
				    }
				}),//设置数据源
				triggerAction: 'all',//单击触发按钮显示全部数据
				editable : false,//禁止编辑
				loadingText : '正在加载车站信息',//加载数据时显示的提示信息
				displayField:'stationname',//定义要显示的字段
				valueField : 'stationid',
				emptyText :'请选择车站',
				queryMode: 'remote',//远程模式
				fieldLabel:'车站'
			},{
				xtype:'textfield',
				allowBlank : false,
				blankText : '司机名能为空',
				name : 'drivername',
				fieldLabel:'司机'
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
				//inputType:'password',
				name : 'seatcount',
				fieldLabel:'座位数'
			},/* ,{
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
		    height:280,
			resizable : false,
			shadow : true,
			modal :true,
		    closable:true,
			items:busForm
		});
		//显示新建书籍窗口
		function showAddBus(){
			busForm.form.reset();
			busForm.isAdd = true;
			win.setTitle("新增汽车");
			win.show();
		}
		//显示修改书籍窗口
		function showModifyBus(){
			var busList = getBusIdList();
			var num = busList.length;
			if(num > 1){
				Ext.MessageBox.alert("提示","每次只能修改一条车辆信息。");
			}else if(num == 1){
				busForm.form.reset();
				busForm.isAdd = false;
				win.setTitle("修改车辆信息");
				win.show();
				var busId = busList[0];
				loadForm(busId);
			}
		}
		//显示删除书籍对话框
		function showDeleteBuses(){
			var busList = getBusIdList();
			var num = busList.length;
			if(num == 0){
				return;
			}
			Ext.MessageBox.confirm("提示","您确定要删除所选车辆吗？",function(btnId){
				if(btnId == 'yes'){
					deleteBuses(busList);
				}
			});
		}
		//删除书籍
		function deleteBuses(busList){
			var busIds = busList.join(',');
			var msgTip = Ext.MessageBox.show({
				title:'提示',
				width : 250,
				msg:'正在删除车辆信息请稍后......'
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
						for(var i = 0 ; i < busList.length ; i++){
							var index = busStore.find('id',busList[i]);
							if(index != -1){
								var rec = busStore.getAt(index);
								busStore.remove(rec);
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
		function loadForm(busId){
			busForm.form.load({
				waitMsg : '正在加载数据请稍后',//提示信息
				waitTitle : '提示',//标题
				url : 'bus_getByVehicleNo',//请求的url地址
				params : {"busBean.vehicleno":busId},
				method:'GET',//请求方式
				failure:function(form,action){//加载失败的处理函数
					Ext.Msg.alert('提示','数据加载失败');
				}
			});
		}
		//提交表单数据
		function submitForm(){
			//判断当前执行的提交操作，isAdd为true表示执行书籍新增操作，false表示执行书籍修改操作
			if(busForm.isAdd){
				//新增书籍信息
			//	alert(Ext.JSON.encode(busForm.form.getValues()));
				var formparams=Ext.JSON.encode(busForm.form.getValues());
				 Ext.Ajax.request({
                     url : 'bus_add',// 文件路径
                     method : 'post',// 提交方法post或get
                     params : {"jsonData":formparams},
                     // 提交成功的回调函数
                     success : function(data,response) {                                               
                     	var dat = Ext.JSON.decode(data.responseText);
                     //	alert(dat);
                         switch(dat){
                         case "0" : 
                        	 Ext.Msg.alert('操作成功！');break;
                         case "1" :	
                         	Ext.Msg.alert('操作失败！');break;
                         default :
                         	Ext.Msg.alert('操作失败！');break;
                         
                         }   
                     },
                     // 提交失败的回调函数
                     failure : function() {
                             Ext.Msg.alert('错误',
                             '服务器出现错误请稍后再试！');
                     }
             });
				/* userForm.form.submit({
					clientValidation:true,//进行客户端验证
					waitMsg : '正在提交数据请稍后',//提示信息
					waitTitle : '提示',//标题
					url : ctxpath + '/user_add',//请求的url地址
					method:'POST',//请求方式
					success:function(form,action){//加载成功的处理函数
						win.hide();
						updateBusGrid(action.result.bookId);
						Ext.Msg.alert('提示','新增书籍成功');
					},
					failure:function(form,action){//加载失败的处理函数
						Ext.Msg.alert('提示','新增书籍失败');
					}
				}); */
			}else{
				//修改车辆信息
				busForm.form.submit({
					clientValidation:true,//进行客户端验证
					waitMsg : '正在提交数据请稍后',//提示信息
					waitTitle : '提示',//标题
					url : 'bus_update',//请求的url地址
					method:'POST',//请求方式
					success:function(data,response) {                                               
                     	var dat = Ext.JSON.decode(data.responseText);
                        //	alert(dat);
                            switch(dat){
                            case "0" : 
                           	 Ext.Msg.alert('操作成功！');break;
                            case "1" :	
                            	Ext.Msg.alert('操作失败！');break;
                            default :
                            	Ext.Msg.alert('操作失败！');break;
                            
                            }   
                        },
                        // 提交失败的回调函数
                        failure : function() {
                                Ext.Msg.alert('错误',
                                '服务器出现错误请稍后再试！');
                        }
				});
			}
		}
		//明细数据修改后，同步更新汽车列表信息
		function updateBusGrid(bookId){
			var values = busForm.form.getValues();
			var index = busStore.find('id',values['id']);
			var bookTypeField = busForm.form.findField('bookTypeId');
			var bookTypeName = bookTypeField.getRawValue();
			if(index != -1){
				var item = busStore.getAt(index);
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
				busStore.add(rec);
			}
		}
		//取得所选汽车id
		function getBusIdList(){
			var recs = busGrid.getSelectionModel().getSelection();
			var list = [];
			if(recs.length == 0){
				Ext.MessageBox.alert('提示','请选择要进行操作的车辆！');
			}else{
				for(var i = 0 ; i < recs.length ; i++){
					var rec = recs[i];
					list.push(rec.get('vehicleno'));
				}
			}
			return list;
		}
	});
</script>
</body>
</html>