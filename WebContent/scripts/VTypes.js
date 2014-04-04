/*************************************
 * 自定义表单验证
 * @author Kevin
 ************************************/
 
 Ext.apply(Ext.form.field.VTypes, {
    vehiclenoVT: function(val, field) {
    	var ff=field;
    	var flag = true;
    	/*Ext.Ajax.request({
        url: 'bus_isVehicleNoExist',
        params: { "message": val },
        method: 'POST',
        async: false,
        success: function (response, options) {
            var result = Ext.JSON.decode(response.responseText);
            flag=!result.MESSAGE; 
        }
      
    });*/
  //  if(field.originalValue==val)
    
    //	flag=true;
    	///^[\u4E00-\u9FA5][A-Z]\s*[0-9A-Z]{5}$/i.test(val)
    	return flag;
;
        
    },
    vehiclenoVTText: '车牌号格式错误！'


});