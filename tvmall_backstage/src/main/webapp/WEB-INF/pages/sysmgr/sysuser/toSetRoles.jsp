<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- 设置学员权限页面 --%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">

    <title>授权</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css"href="css/common/scroll.css" />
    <script type="text/javascript" src="js/common/ztree/jquery-1.4.4.min.js"></script>
</head>
<body>
<div>
    <form id="setStuPopedom" class="layui-form" action="" style="margin:30px;" >
        <input type="hidden" id="userId" name="userId" value="${userId }">
        <div class="layui-form-item">
            <c:forEach items="#{roles}" var="obj">
                <input type="checkbox" name="roleIds" value="${obj.role_id}"
                       title="${obj.role_name}" ${obj.ishave>0 ? 'checked' : ''}>
            </c:forEach>
        </div>
        <button class="layui-btn" id="submit" lay-submit lay-filter="setStuPopedom" style="display: none">立即提交</button>
        <button type="reset" id="reset" class="layui-btn layui-btn-primary" style="display: none">重置</button>
    </form>
</div>
</body>
<script type="text/javascript" src="js/layui/layui.js"></script>
<script type="text/javascript">
    layui.config({
        base: "<%=basePath%>/js/common/"
    }).use(["common", "element", "layer", "form", "table","jquery"], function(){
        var elem = layui.element;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var $ = layui.jquery;

        layui.common.init();

        //监听提交  添加
        form.on('submit(setStuPopedom)', function(data){
            $.ajax({
                type:"post",
                url:'users/setUserRoles',
                data:$("#setStuPopedom").serialize(),
                dataType:"json",
                success:function(json){
                    if(json.statusCode == 200){
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.msg(json.message, {icon: 6,time: 2000});
                        parent.layer.close(index);
                    }else{
                        parent.layer.msg(json.message, {icon: 5,time: 2000});
                    }
                }
            });
            return false;
        });
    });
</script>
</html>
