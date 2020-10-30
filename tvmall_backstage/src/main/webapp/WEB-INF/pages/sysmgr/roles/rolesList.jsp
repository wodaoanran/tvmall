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

    <title>角色管理</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <%-- 引用layui.css --%>
    <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css"href="css/common/common.css" />
</head>

<body>
<div class="ibox">
    <!-- 搜索区 -->
    <div class="ibox-content bodycss">
        <section class="panel panel-padding ">
            <!-- 表单搜索 开始 -->
            <form class="layui-form layui-form-pane form-search"
                  action="" onsubmit="return false" method="post" id="searchForm">
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">角色名称</label>
                    <div class="layui-input-inline">
                        <input name="roleName" value="" placeholder="请输入角色名称" class="layui-input"
                               style="width:150px">
                    </div>
                </div>
                <div class=" layui-form-item layui-inline">
                    <button id="search_btn" class="layui-btn layui-btn-primary seachButton" lay-submit
                            lay-filter="seach">
                        <i class="layui-icon"></i> 搜 索
                    </button>
                </div>
            </form>
        </section>
        <section class="panel panel-padding ">

                <div class="ibox-toolbar">
                    <button id="addRoles" data-modal="" data-title="添加角色" class="layui-btn layui-btn-sm">
                        <i class="layui-icon">&#xe61f;</i> 添加角色
                    </button>
                </div>

            <table class="layui-table" lay-data="{
                        id: 'roleTeble',
                        width:'auto',
                        url:'roles/query',
                        page:true,
                        method:'get',
                        even:true,
                        skin:'line',
                        limits:[10,20,30,40,50],
                        limit:10}" lay-filter="rolesLay">
                <thead>
                <tr>
                    <th lay-data="{field:'rowno', width:50}"></th>
                    <th lay-data="{field:'roleName', width:200}">角色名</th>
                    <th lay-data="{field:'status', width:100, templet:'#status'}">状态</th>
                    <th lay-data="{field:'createTime', width:180}">创建时间</th>
                    <th lay-data="{field:'createUser', width:150}">创建人</th>
                    <th lay-data="{field:'updateTime', width:180}">修改时间</th>
                    <th lay-data="{field:'updateUser', width:150}">修改人</th>
                    <th lay-data="{fixed: 'right', width:230, align:'center', toolbar: '#rolesBar'}"></th>
                </tr>
                </thead>
            </table>
        </section>
    </div>
</div>

<script type="text/html" id="status">
    {{#  if(d.status == 1) {  }}
    <font color="#00ff00">正常</font>
    {{#  } else {  }}
    <font color="#ff0000">禁用</font>
    {{#  }  }}
</script>

<script type="text/html" id="rolesBar">
        <a class="layui-btn layui-btn-xs" lay-event="right">授权</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

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

        //搜索框事件
        form.on('submit(seach)', function (data) {
            //layer.msg(JSON.stringify(data.field));
            table.reload('roleTeble', {
                method: "get",
                where: data.field
            });
            return false;
        });

        $("#addRoles").on("click", function(){
            var bool = false;
            layer.open({
                type: 2,
                title: '添加角色',
                content: 'roles/toAdd',
                area: ['700px', '350px'],
                anim: 5,
                isOutAnim: true,
                maxmin: true,
                resize: false,
                moveOut: true,
                zIndex: 99999,
                btn:['提交','重置'],
                end : function(){
                    if(bool){
                        table.reload("roleTeble");
                    }
                },
                yes: function(index, layero){
                    bool = true;
                    //按钮【按钮一】的回调
                    var body = layer.getChildFrame('body', index);
                    body.contents().find("BUTTON[id='submit']").click();
                    return false;
                },
                btn2: function(index, layero){
                    //按钮【按钮二】的回调
                    var body = layer.getChildFrame('body', index);
                    body.contents().find("BUTTON[id='reset']").click();
                    return false;
                }
            });
        });


        table.on('tool(rolesLay)', function(obj){
            var data = obj.data;            //获得当前行数据
            var layEvent = obj.event;       //获得 lay-event 对应的值
            var tr = obj.tr;                //获得当前行 tr 的DOM对象

            if(layEvent === 'del'){  //删除
                layer.open({
                    icon:3,
                    title: "删除",
                    content : "确认删除？",
                    btn: ['确认', '取消'],
                    yes: function(index, layero){
                        $.ajax({
                            type:"delete",
                            url:'roles/delete/'+data.roleId,
                            dataType:"json",
                            success:function(json){
                                if(json.statusCode == 200){
                                    table.reload("roleTeble", {});
                                    layer.msg("删除成功", {icon: 6,time: 2000});
                                }else{
                                    layer.msg("删除失败", {icon: 5,time: 2000});
                                }
                            }
                        });
                    },
                    btn2: function(index, layero){ }
                });

            } else if(layEvent === 'edit'){ //编辑
                //console.log(data);
                var bool = false;
                layer.open({
                    type: 2,
                    title: '修改角色',
                    content: 'roles/toUpd/'+data.roleId+"/"+data.roleName+'/'+data.status,
                    area: ['700px', '350px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999,
                    btn:['提交','重置'],
                    end : function(){
                        if(bool){
                            table.reload("roleTeble");
                        }
                    },
                    yes: function(index, layero){
                        bool = true;
                        //按钮【按钮一】的回调
                        var body = layer.getChildFrame('body', index);
                        body.contents().find("BUTTON[id='submit']").click();
                        return false;
                    },
                    btn2: function(index, layero){
                        //按钮【按钮二】的回调
                        var body = layer.getChildFrame('body', index);
                        body.contents().find("BUTTON[id='reset']").click();
                        return false;
                    }
                });
            } else if(layEvent === 'right'){ // 授权
                var bool = false;
                layer.open({
                    type: 2,
                    title: '授权',
                    content: 'roles/toSetRights/'+data.roleId,
                    area: ['900px', '500px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999,
                    btn:['保存数据','取消编辑'],
                    end : function(){
                        if(bool){
                            table.reload("roleTeble");
                        }
                    },
                    yes: function(index, layero){
                        bool = true;
                        //按钮【按钮一】的回调
                        var body = layer.getChildFrame('body', index);
                        body.contents().find("BUTTON[id='submit']").click();
                        return false;
                    },
                    btn2: function(index, layero){
                        //按钮【按钮二】的回调
                        var body = layer.getChildFrame('body', index);
                        body.contents().find("BUTTON[id='reset']").click();
                        return false;
                    }
                });
            }

        });

    });
</script>
</body>
</html>
