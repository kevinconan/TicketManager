/*************************************
 * 自定义表单验证
 * @author Kevin
 ************************************/
 
 Ext.apply(Ext.form.field.VTypes, {
    vehiclenoVT: function(val, field) {
    	
    	
        return timeTest.test(val);
    },
    timeText: 'Not a valid time.  Must be in the format "12:34 PM".',


});