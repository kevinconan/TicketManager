/*************************************
 * 自定义表单验证
 * @author Kevin
 ************************************/
 
 Ext.apply(Ext.form.field.VTypes, {
    vehiclenoVT: function(val, field) {
    	var ff=field;
    	var flag = false;
    	Ext.Ajax.request({
        url: 'bus_isVehicleNoExist',
        params: { "message": val },
        method: 'POST',
        async: false,
        success: function (response, options) {
            var result = Ext.JSON.decode(response.responseText);
            flag=!result.MESSAGE; 
        }
      
    });
  //  if(field.originalValue==val)
    
    //	flag=true;
    
    	return flag;
        
    },
    vehiclenoVTText: '车牌号重复！'


});