layui.define(['jquery', 'from'], function(exports) {
	var $ = layui.jquery;
    var layer = layui.layer;
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
		//[1-2]位小数位的金额
		isMoney:[/^(([0-9]{1,7})|([0-9]{1,7}\.[0-9]{1,2}))?$/,"请正确填写金额"],
		isPercent:[/^[1-9]\d{0,3}\.\d$|^[1-9]\d{0,2}\.\d{2}$|^[1-9]\d{0,4}$|^[0]\.\d{1,2}$/,"最多输入两位小数"],
		//大于0
		bigZero: function(value, item){ //value：表单的值、item：表单的DOM对象
			if(parseFloat(value)<=0){
				return '请输入大于0的数字';
			}
		},
		//百分比(大于0小于100)
		isPercentage: function(value, item){ //value：表单的值、item：表单的DOM对象
			if(parseFloat(value)<=0||parseFloat(value)>100){
				return '请输入正确的百分数';
			}
		},
		username : function(value, item) { //value：表单的值、item：表单的DOM对象
			if(value.length > 20){
				return '用户名长度不能超过20个字符';
			}
			if(!/^[a-zA-Z0-9_\u4e00-\u9fa5]+$/.test(value)){
				return "用户名不能存在特殊字符";
			}
			if (/(^\_)|(\__)|(\_+$)/
				.test(value)) {
				return '用户名首尾不能出现下划线\'_\'';
			}
			if (/^\d+\d+\d$/.test(value)) {
				return '用户名不能全为数字';
			}
			if(value=""){
				return '用户名不能空格';
			}

		},
		integer:[/^[1-9]\d*$/,"请输入大于0的正整数"],
		//链接
		myUrl: function(value, item){ //value：表单的值、item：表单的DOM对象
			var reg = /(^#)|(^http(s*):\/\/[^\s]+\.[^\s]+)/;
			if(value!=""&&!reg.exec(value)){
				return '链接格式不正确';
			}
		},
		//邮箱
		myEmail: function(value, item){ //value：表单的值、item：表单的DOM对象
			var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			if(value!=""&&!reg.exec(value)){
				return '邮箱格式不正确';
			}
		}
	});
	
    exports('validate', validate);
});