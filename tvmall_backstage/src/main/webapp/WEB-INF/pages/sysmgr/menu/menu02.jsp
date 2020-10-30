<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=0">
    <%-- 引用自定义图标库 --%>
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
    <%-- 引用layui.css --%>
    <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css"/>

</head>
<body>
<form class="layui-form" action="" style="margin:30px;">
<div class="layui-form-item">
<label class="layui-form-label">父级菜单</label>
<div class="layui-input-block">
    <select name="pmenu_id" lay-verify="required">
        <option value=""></option>
        <option value="0">11</option>
        <option value="1">22</option>
        <option value="2">33</option>
        <option value="3">44</option>
        <option value="4">55</option>
    </select>
</div>
</div>
<div class="layui-form-item">
<label class="layui-form-label">菜单名称</label>
<div class="layui-input-block">
    <input type="text" name="menu_name" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
</div>
</div>
<div class="layui-form-item">
<label class="layui-form-label">菜单链接</label>
<div class="layui-input-block">
    <input type="text" name="url" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
</div>
</div>

<div class="layui-form-item">
<label class="layui-form-label">菜单图标</label>
<div class="layui-input-inline" style="width:300px">
    <input placeholder="请输入或选择图标" onchange="$('#icon-preview').get(0).className = this.value" type="text" name="icon" value="" class="layui-input">
</div>
<span class="layui-btn layui-btn-primary" style="padding:0 12px;min-width:45.2px">
    <i id="icon-preview" style="font-size:1.2em" class=""></i>
</span>
<button id="menu_icon" data-icon="icon" type="button" class="layui-btn layui-btn-primary">选择图标</button>
</div>
<hr class="layui-bg-gray" style="margin-top: 10px;">
<div class="layui-form-item">
<div class="layui-input-block">
    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
</div>
</div>
</form>
<script type="text/javascript" src="js/business/layui/layui.js"></script>
<script type="text/javascript">
//Demo

	layui.config({
        base: "<%=basePath%>/js/common/"
    }).use([ "layer", "form" ], function() {
		var $ = layui.jquery;
		var form = layui.form;
		var layer = layui.layer;

		layui.common.init();
		
		//监听提交
		form.on('submit(formDemo)', function(data) {
			layer.msg(JSON.stringify(data.field));
			return false;
		});

		$("#menu_icon").on("click", function() {
			layer.open({
				type : 2,
				title : '添加菜单',
				content : 'xtgl010/toMenuIcon.do',
				area : [ '900px', '500px' ],
				anim : 5,
				isOutAnim : true,
				maxmin : true,
				resize : false,
				moveOut : true,
				zIndex : 1
			});
		});

	});
</script>
</body>
</html>
