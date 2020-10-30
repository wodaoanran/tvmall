<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'xtgl03002.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <%-- 引用layui.css --%>
    <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css" />

</head>

<body>
<%-- 添加角色信息 --%>
<div id="roleAdd">
    <form class="layui-form" action="" style="margin:40px;">
        <div class="layui-form-item">
            <label class="layui-form-label">角色名称</label>
            <div class="layui-input-block">
                <input type="text" name="roleName" required lay-verify="name" 
                       placeholder="请输入角色名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色状态</label>
            <div class="layui-input-block">
                <select name="status" lay-verify="required">
                    <option value="1">正常</option>
                    <option value="0">禁用</option>
                </select>
            </div>
        </div>
        <br>
        <div class="layui-form-item" style="margin-left: 160px">
            <div class="layui-input-block">
                <button type="submit" id="submit" style="display: none" class="layui-btn" lay-submit lay-filter="AddRoles">立即提交</button>
                <button type="reset" id="reset" style="display: none" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="js/layui/layui.js"></script>
<script type="text/javascript">
    layui.config({
        base: "<%=basePath%>/js/common/"
    }).use(["common", "element", "layer", "form", "table", "jquery"], function(){
        var elem = layui.element;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var $ = layui.jquery;

        layui.common.init();

        //监听提交  添加
        form.on('submit(AddRoles)', function(data){
            $.ajax({
                type:"POST",
                url:'roles/addRole',
                data:data.field,
                dataType:"json",
                success:function(json){
                    if(json.statusCode == 200){
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        parent.layer.msg(json.message, {icon: 6,time: 2000});
                    } else{
                        layer.msg(json.message, {icon: 5,time: 2000});
                    }
                }
            });
            return false;
        });


        // 表单验证
        form.verify({
            name: function(value, item){
                if(value.length < 1 || value.length > 20){
                    return "长度为0-20个字符";
                }
                if(!/^[a-zA-Z0-9_\u4e00-\u9fa5]+$/.test(value)){
                    return "角色名不能存在特殊字符"
                }
            },
            length: function(value, item){
                if($(item).attr("max")){
                    if(value.length > $(item).attr("max")){
                        return "长度不能超过" + $(item).attr("max");
                    }
                }
                if($(item).attr("min")){
                    if(value.length > $(item).attr("min")){
                        return "长度不能小于" + $(item).attr("min");
                    }
                }
            }
        });

    });
</script>
</body>
</html>
