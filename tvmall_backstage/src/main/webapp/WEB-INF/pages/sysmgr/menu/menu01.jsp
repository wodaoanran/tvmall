<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>菜单管理</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0">
<%-- 引用layui.css --%>
<link rel="stylesheet" type="text/css" href="js/layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/common/ibox.css" />
<link rel="stylesheet" type="text/css"href="css/common/common.css" />
</head>
<body>
	<div class="ibox">
		<!-- 搜索区 -->

		<div class="ibox-content">

           <c:if test="${sessionScope.userpopedom.xtgl05001==1}">
            <div class="ibox-toolbar">
				<button onclick="active.tjcd();" data-modal="login/toMenuModel.do"
					data-title="添加菜单" class="layui-btn layui-btn-sm">
					<i class="layui-icon">&#xe61f;</i> 添加菜单
				</button>
			</div>
           </c:if>
			<table class="layui-table"
				lay-data="{
                      id: 'menuTable',
                      width:'auto',
                      url:'menu/query',
                      page:true,
                      even:true,
                      skin:'line',
                      limits:[10,20,30,40,50],
                      limit:10}"
				lay-filter="test">
				<thead>
					<tr>
						<th lay-data="{checkbox: true,disabledKey:'menu_id',disabledKeyValue:'01,0101'}"></th>
						<th lay-data="{field:'menu_id', width:100}">ID</th>
						<th lay-data="{field:'icon', width:120, align: 'center', templet:'#icon_temp'}">图标</th>
						<th lay-data="{field:'menu_name', width:280, templet:'#menu_temp'}">菜单名</th>
						<th lay-data="{field:'url', width:280}">请求路径</th>
						<th lay-data="{field:'rel', width:160}">标识</th>
		
						<th lay-data="{fixed: 'right', width:230, align:'center', toolbar: '#barDemo'}">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>

	<%-- 添加菜单信息 --%>
	<div id="menuAdd" style="display: none;">
		<form class="layui-form" action="" style="margin:30px;">
			<div class="layui-form-item">
				<label class="layui-form-label">父级菜单</label>
				<div class="layui-input-block">
					<select name="pmenu_id">
						<c:forEach items="${data}" var="obj">
							<option value="${obj.menu_id}">${obj.menu_name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单名称</label>
				<div class="layui-input-block">
					<input type="text" name="menu_name" required lay-verify="required"
						placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">唯一标识</label>
				<div class="layui-input-block">
					<input type="text" name="rel" required lay-verify="required"
						placeholder="请输入唯一标识" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单链接</label>
				<div class="layui-input-block">
					<input type="text" name="url" required lay-verify="required"
						placeholder="请输入菜单链接" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">排序</label>
				<div class="layui-input-block">
					<input type="text" name="order" required lay-verify="required"
						placeholder="请输入序号" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单图标</label>
				<div class="layui-input-inline" style="width:300px">
					<input placeholder="请输入或选择图标" lay-verify="required"
						onchange="$('#icon-previewup').html(this.value)"
						type="text" name="icon" value="" class="layui-input">
				</div>
				<span class="layui-btn layui-btn-primary"
					style="padding:0 12px;min-width:45.2px"> <i
					id="icon-preview" style="font-size:1.2em" class="icon iconfont">&#xe630;</i>
				</span>
				<button id="menu_icon" data-icon="icon" type="button"
					class="layui-btn layui-btn-primary">选择图标</button>
			</div>
			<hr class="layui-bg-gray">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="AddMenu">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>

	<%-- 修改菜单信息 --%>
	<div id="menuUpdate" style="display: none;">
		<form id="menuUpdateForm" class="layui-form" action=""
			style="margin:30px;">
			<input id="menu_id1" type="hidden" name="menu_id" value="">
			<div class="layui-form-item">
				<label class="layui-form-label">菜单名称</label>
				<div class="layui-input-block">
					<input id="menu_name1" type="text" name="menu_name" required
						lay-verify="required" placeholder="请输入菜单名称" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">唯一标识</label>
				<div class="layui-input-block">
					<input id="rel1" type="text" name="rel" required
						lay-verify="required" placeholder="请输入唯一标识" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单链接</label>
				<div class="layui-input-block">
					<input id="url1" type="text" name="url" required
						lay-verify="required" placeholder="请输入菜单链接" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">排序</label>
				<div class="layui-input-block">
					<input id="order1" type="text" name="order" required
						lay-verify="required" placeholder="请输入序号" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单图标</label>
					<div class="layui-input-inline" style="width:300px">
					<input id="icon1" placeholder="请输入或选择图标" lay-verify="required"
						onchange="$('#icon-preview').get(0).className=this.value"
						type="text" name="icon" value="" class="layui-input">
				</div>
				<span class="layui-btn layui-btn-primary"
					style="padding:0 12px;min-width:45.2px"> <i
					id="icon-previewup" style="font-size:1.2em" class=""></i>
				</span>
				<button id="menu_icon1" data-icon="icon" type="button"
					class="layui-btn layui-btn-primary">选择图标</button>
			</div>
			<hr class="layui-bg-gray"
				style="margin-top: 20px;margin-bottom: 20px;">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="UpeMenu">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="js/common/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/layui/layui.js"></script>
	<script type="text/javascript">
        layui.config({
            base: "js/common/"
        }).use(["common", "layer", "element", "form", "table", "jquery"], function(){
            var layer = layui.layer;
            var table = layui.table;
            var $ = layui.jquery;
            var form = layui.form;

             layui.common.init();
            
            //监听提交  添加
            form.on('submit(AddMenu)', function(data){
                // layer.msg(JSON.stringify(data.field));
                $.ajax({
                    type:"post",
                    url:'menu/addMenu',
                    data:data.field,
                    dataType:"json",
                    success:function(json){                    	
                        if(json.status == 200){
                            layer.msg(json.message, {icon: 6,time: 2000});
                            table.reload("menuTable", {})
                            window.setTimeout(function(){
                               /* table.reload("menuTable", {});
                                layer.close(index);*/
                                data.form.submit();
                            },2000);
                        }else{
                            layer.msg(json.message, {icon: 6,time: 2000});
                        }
                    }
                });
                return false;
            });

            //监听提交  修改
            form.on('submit(UpeMenu)', function(data){
                // layer.msg(JSON.stringify(data.field));
                $.ajax({
                    type:"post",
                    url:'menu/updMenu',
                    data:data.field,
                    dataType:"json",
                    success:function(json){
                        if(json.statusCode == 200){
                            layer.msg(json.message, {icon: 6,time: 2000});
                            table.reload("menuTable", {});
                            window.setTimeout(function(){
                                /* table.reload("menuTable", {});
                                 layer.close(index);*/
                                data.form.submit();
                            },2000);
                        }else{
                            layer.msg(json.message, {icon: 6,time: 2000});
                        }
                    }
                });
                return false;
            });

            table.on('tool(test)', function(obj){
                var data = obj.data;            //获得当前行数据
                var layEvent = obj.event;       //获得 lay-event 对应的值
                var tr = obj.tr;                //获得当前行 tr 的DOM对象

                if(layEvent === 'del'){  //删除

                    layer.open({
                        icon:3,
                        title: "删除",
                        content : "确认删除？",
                        btn: ['确认', '取消'], //可以无限个按钮
                        yes: function(index, layero){
                            $.ajax({
                                type:"post",
                                url:'menu/delMenu',
                                data:{menu_id : data.menu_id},
                                dataType:"json",
                                success:function(json){
                                    if(json.statusCode == 200){
                                        table.reload("menuTable", {});
                                        layer.msg(json.message, {icon: 6,time: 2000});
                                    }else{
                                        layer.msg(json.message, {icon: 5,time: 2000});
                                    }
                                }
                            });
                        },
                        btn2: function(index, layero){

                        }
                    });

                } else if(layEvent === 'edit'){ //编辑
                    $("#menu_id1").val(data.menu_id);
                    $("#menu_name1").val(data.menu_name);
                    $("#rel1").val(data.rel);
                    $("#url1").val(data.url);
                    $("#order1").val(data.menuOrder);
                    $("#icon1").val(data.icon);

                    layer.open({
                        type: 1,
                        title: '添加菜单',
                        content: $('#menuUpdate'),
                        area: ['800px', '500px'],
                        anim: 5,
                        isOutAnim: true,
                        maxmin: true,
                        resize: false,
                        moveOut: true,
                        zIndex: 99999
                    });
                }
            });

            $("#menu_icon").on("click", function (){
                layer.open({
                    type: 2,
                    title: '请选择图标',
                    content: 'menu/toMenuIcon',
                    area: ['900px', '500px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999
                });
            });

            $("#menu_icon1").on("click", function (){
                layer.open({
                    type: 2,
                    title: '请选择图标',
                    content: 'menu/toMenuIcon',
                    area: ['900px', '500px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999
                });
            });
        });

        var active = {
            tjcd : function(){
                index = layer.open({
                    type: 1,
                    title: '添加菜单',
                    content: $('#menuAdd'),
                    area: ['800px', '500px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999
                });
            }
        };
    </script>

	<script type="text/html" id="barDemo">
    <c:if test="${sessionScope.userpopedom.xtgl05002==1}">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    </c:if>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
	<script type="text/html" id="menu_temp">
        {{#  for(var i = 0;i < d.lev - 1;i++){ }}
            &nbsp;&nbsp;&nbsp;├&nbsp;&nbsp;
        {{#  } }}
        {{  d.menu_name }}
    </script>
	<script type="text/html" id="icon_temp">
        {{# if(d.icon.indexOf('&#') >= 0){  }}
            <i class="layui-icon">{{d.icon}}</i>
        {{# }else { }}
            <i class="{{d.icon}}"></i>
        {{# }  }}
    </script>
</body>
</html>