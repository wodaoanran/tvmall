function init_layuiform() {
    layui.use('form', function() {
    	alert("aa");
        var form = layui.form();
        // 自定义校验规则
        form.verify({
    		idCard: function(value, item){
    			if(!/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/.test(value)){
    				return "请输入正确的身份证号";
    			}
    		},
    		myemail : function(value, item) { //value：表单的值、item：表单的DOM对象
    			if(value.length>0 && !/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(value)){
    				return '邮箱格式不正确';
    			}
    		},
    	});
    });
}
