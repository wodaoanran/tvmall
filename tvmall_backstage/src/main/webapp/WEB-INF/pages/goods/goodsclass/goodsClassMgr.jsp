<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <base href="<%=basePath %>">
    <meta charset="UTF-8">
    <title>商品分类管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- load css -->
    <link rel="icon" href="image/common/logo.png" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/font/iconfont.css?v=1.0.0" media="all">
    <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css" media="all">
    <link href="js/common/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet"  type="text/css"/>
    <link href="js/common/cropper/cropper.css" rel="stylesheet"  type="text/css"/>
    <script type="text/javascript" src="js/common/jquery-1.11.3.js"></script>
    <script src="js/common/ztree/jquery.ztree.all.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/layui/layui.js"></script>
    <script type="text/javascript" src="js/jQueryFileUpload/js/vendor/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/jQueryFileUpload/js/jquery.iframe-transport.js"></script>
	<script type="text/javascript" src="js/jQueryFileUpload/js/jquery.fileupload.js"></script>
	<script type="text/javascript" src="js/common/cropper/cropper.js"></script>	
<script type="text/javascript">
	layui.config({
		    base: "js/common/"
		}).use(["common",  "layer"], function(){
				var layer = layui.layer;
				var $ = layui.jquery;
				layui.common.init();	
	});
    var setting = {
        async: {
            enable: true, // 设置 zTree是否开启异步加载模式 
            url: "goodsClass/tree?tmp="+ Math.random(),						 	// Ajax 获取数据的 URL 地址
            autoParam: ["id","name=n", "level=lv"],		 	//异步加载时自动提交父节点属性的参数 , "name=n", "level=lv"
            type: "get",                                     	//提交方式
            dataFilter: filter
        },
        callback: {
            onClick: select
        } 
    };

    function filter(treeId, parentNode, childNodes) {
        setNode(childNodes);
        return childNodes;
    }
    function setNode(nodes) {
        if (!nodes) return null;
        for (var i = 0, l = nodes.length; i < l; i++) {
            nodes[i].url = "";
            setNode(nodes[i].children);
        }
    }

    function select(event, treeId, treeNode) {
        $("#btnAddSub").show();
        $("#btnAddSub").unbind("click");
        $("#btnAddSub").bind("click",function(){
            $.post($(this).attr("url"),{gcId:treeNode.id,treeNodeLevel:treeNode.level},addSubClass,"json");
        });
        $("#goodsClassDetails").load("goodsClass/toGcUpd?gcId="+treeNode.id+"&treeNodeLevel="+treeNode.level+"&treeNodeName="+treeNode.name);
    }
    
    $(document).ready(function () {
    	//生成zTree树 
        $.fn.zTree.init($("#goodsClass"), setting);
        
        $("#btnAddParent").on("click",function(){
            $.post($(this).attr("url"),addParentClass,"json");
        });
    });    
    
    //添加父分类回调
    function addParentClass(data) {
        if (data.statusCode == 200) { 
            layer.msg(data.message, {icon: 6,time: 2000});       	
            var model = data.model;           
            var treeObj = $.fn.zTree.getZTreeObj("goodsClass");
            var newNode = { name: model.gcName, id: model.gcId, pid: null, url: "", click: model.click };
            newNode = treeObj.addNodes(null, newNode);
        }else{
        	layer.msg(data.message, {icon: 5,time: 2000});
        }
    }
    //添加子分类回调
   function addSubClass(data) {        
        if (data.statusCode == 200) {
            layer.msg(data.message, {icon: 6,time: 2000});   
            var model = data.model;
            var treeObj = $.fn.zTree.getZTreeObj("goodsClass");
            var nodes = treeObj.getSelectedNodes();
            var newNode = { name: model.gcName, id: model.gcId, pid: nodes[0].gcId, url: "", click: model.click};
            newNode = treeObj.addNodes(nodes[0], newNode);
        }else{
           layer.msg(data.message, {icon: 5,time: 2000});   
        }
    }
</script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>商品分类信息</legend>
</fieldset>
<div style="margin-top:10px;">
    <div style="float: left; display: block; margin: 0px 10px; overflow: auto; width: 240px;
        height: 763px; border: solid 1px #CCC; background: #FFF;" >
            <div class="layui-btn-group">
               <a href="javascript:void(0);" id="btnAddParent" url="goodsClass/addParentClass" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe654;</i>添加根分类</a>
               <a href="javascript:void(0);" style="display: none" url="goodsClass/addSubClass" id="btnAddSub" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe654;</i>添加子分类</a>
            </div>         
           <div>
             <ul class="ztree" id="goodsClass">
             </ul>
           </div>
     </div>
     <div id="goodsClassDetails"  style="height: 763px;border: solid 1px #CCC ;background:#c3ced2; margin-left: 256px;">
    </div>
 </div>
</body>
</html>