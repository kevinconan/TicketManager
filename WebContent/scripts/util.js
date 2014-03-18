/**********************************
 * 搜索Form所有的textField添加通配符
 * @author Kevin
 * 
 **********************************/
 
 function getWildcardValues(form){
 	 list= new Ext.util.HashMap();
	 var fields = form.form.getFields();
	 for(var i = 0; i <fields.length;i++){
	 	var string='';
	 	var field = fields.getAt(i);
	 	if(field.xtype == 'textfield'){
	 		string = '%'+field.getValue()+'%';	 		 	
	 	}else{
	 		string = field.getValue();
	 	}
	 	list.add(field.getName(),string)
	 }
	 return list.map;
 }
 