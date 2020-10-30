//监听键盘事件
document.onkeydown=function(event){	
	var e = event || window.event || arguments.callee.caller.arguments[0];	
	// 按 Esc	
	if(e && e.keyCode==27){ 
		//要做的事情	
	}
	// 按 F2	
	if(e && e.keyCode==113){ 
		//要做的事情	
	}	
	// enter 键
	if(e && e.keyCode==13){ 
		//$(".seachButton").click();
		$("[lay-filter='seach']").click();
	}
};