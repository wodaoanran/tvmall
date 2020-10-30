;
layui.define(["jquery", "form"], function(exports) {
	var $ = layui.jquery;
	var form = layui.form;
	
	var common = {
		init: function(){
	
			$.ajaxSetup({
			    global: true,
			    type: "POST",
			    complete: function (XMLHttpRequest) {
			        var data = XMLHttpRequest.responseText;
			        if (data == "timeout") {
			        	layer.msg("会话超时，请重新登陆!",{icon:6});
     					setTimeout('window.top.location = "login/toLogin.do"',2000);
			        }
			    }
			});
		}
	}
	exports("common", common);
});

/*function common(){
	$.ajaxSetup({
	    global: true,
	    type: "POST",
	    complete: function (XMLHttpRequest) {
	        var data = XMLHttpRequest.responseText;
	        if (data == "timeout") {
	        	layer.msg("会话超时，请重新登陆!",{icon:6});
					setTimeout('window.top.location = "login/toLogin.do"',2000);
	        }
	    }
	});
}*/
 

