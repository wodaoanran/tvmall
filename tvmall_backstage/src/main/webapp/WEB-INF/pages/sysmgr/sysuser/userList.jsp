<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">

    <title>用户管理</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <%-- 引用自定义图标库 --%>
    <!-- <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" /> -->
    <%-- 引用layui.css --%>
    <link rel="stylesheet" type="text/css"href="js/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css"href="css/common/common.css" />
</head>
<body>
<div class="ibox">
    <div class="ibox-content bodycss">
        <!-- 表单搜索 开始 -->
        <section class="panel panel-padding ">
            <form class="layui-form layui-form-pane form-search"
                  action="" onsubmit="return false" method="post">

                <div class="layui-form-item layui-inline" >
                    <label class="layui-form-label">用户姓名</label>
                    <div class="layui-input-inline">
                        <input name="userName" value="" placeholder="请输入用户姓名" class="layui-input" style="width:140px">
                    </div>
                </div>

                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">登录账号</label>
                    <div class="layui-input-inline">
                        <input name="loginName" value="" placeholder="请输入登录账号" class="layui-input" style="width:140px">
                    </div>
                </div>

                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">状态</label>
                    <div class="layui-input-inline" >
                        <div  style="width:150px">
                            <select name="status"  >
                                <option value="" >请选择</option>
                                <option value="1">正常</option>
                                <option value="0">禁用</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item layui-inline">
                    <button class="layui-btn layui-btn-primary" lay-submit lay-filter="seach">
                        <i class="layui-icon"></i> 搜 索
                    </button>
                </div>
            </form>
        </section>
        <!-- 表单搜索 结束 -->
        <section class="panel panel-padding ">
            <form onsubmit="return false;" data-auto="true" method="post"
                  data-listen="true" novalidate="novalidate">
                    <button id="addSysUser" data-modal="" data-title="添加用户" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe61f;</i> 添加用户
                    </button>
                    <button id="delSysUser" data-field="delete" data-action="" class="layui-btn layui-btn-sm layui-btn-danger"><i class="layui-icon">&#xe640;</i> 批量删除
                    </button>
                <!--  </div> -->
                <input type="hidden" value="resort" name="action">
                <table class="layui-table" lay-data="{
                        id: 'userTeble',
                        width:'auto',
                        height:'auto',
                        url:'users/query',
                        toolbar: '#toolbarDemo',
                        page:true,
                        even:true,
                        skin:'row',
                        limits:[10,20,30,40,50],
                        limit:10}" lay-filter="userLay">
                    <thead>
                    <tr>
                        <th lay-data="{checkbox:true,disabledKey:'identity',disabledKeyValue:'1'}"></th>
                        <th lay-data="{field:'userName', width:150}">用户姓名</th>
                        <th lay-data="{field:'loginName', width:120}">登录账号</th>
                        <th lay-data="{field:'status', width:100, templet:'#user_status'}">状态</th>
                        <th lay-data="{field:'provinceName', width:70}">省份</th>
                        <th lay-data="{field:'cityName', width:70}">城市</th>
                        <th lay-data="{field:'servicePointName', width:120}">服务点</th>
                        <th lay-data="{field:'loginTimes', width:100,templet:'#login_times'}">登录次数</th>
                        <th lay-data="{field:'lastLoginTime', width:160}">上次登录时间</th>
                        <th lay-data="{field:'lastLoginIp', width:160}">上次登录IP</th>
                        <th lay-data="{field:'createTime', width:140}">创建时间</th>
                        <th lay-data="{field:'createUserName', width:140}">创建人</th>
                        <th lay-data="{field:'updateTime', width:160}">修改时间</th>
                        <th lay-data="{field:'updateUserName', width:140}">修改人</th>
                        <th lay-data="{fixed: 'right', width:300, align:'center', toolbar: '#userBar'}">操作</th>
                    </tr>
                    </thead>
                </table>
            </form>
        </section>
    </div>
</div>
<script type="text/html" id="userBar">

        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="role">设置角色</a>

        <a class="layui-btn layui-bg-cyan layui-btn-xs" lay-event="shou">修改密码</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>

        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

</script>
<script type="text/html" id="user_status">
    {{#  if(d.status == 1) {  }}
    <input type="checkbox" name="status"  value={{ d.userId}}  lay-filter="changeStatus" lay-skin="switch" lay-text="正常|禁用"  checked/>
    {{#  } else {  }}
    <input type="checkbox" name="status"  value={{ d.userId}} lay-filter="changeStatus" lay-skin="switch" lay-text="正常|禁用" />
    {{#  }  }}

</script>

<script type="text/html" id="user_identity">
    {{#  if(d.identity == 1) {  }}
    <font color="purple">超级管理员</font>
    {{#  } else if(d.identity == 2) {  }}
    <font color="orange">普通管理员</font>
    {{#  }  }}
</script>

<script type="text/html" id="login_times">
    <span class="layui-badge">{{d.loginTimes}}</span>
</script>

<script type="text/html" id="toolbarDemo">
        <button lay-event="exportExcel" data-modal="" data-title="导出Excel"
                class="layui-btn layui-btn-danger layui-btn-sm">
            <i class="layui-icon">&#xe62d;</i> 导出Excel
        </button>
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

        /**
         * 监听刷新表格
         */
        form.on('submit(seach)', function(data){
            //layer.msg(JSON.stringify(data.field));
            table.reload('userTeble', {
                method:"get",
                where: data.field
            });
            return false;
        });

        // 添加用户按钮
        $("#addSysUser").on("click", function(){

            var bool = false;
            layer.open({
                type: 2,
                title: '添加用户',
                content: 'users/toAdd',
                area: ['750px', '600px'],
                anim: 5,
                isOutAnim: true,
                maxMin: true,
                resize: false,
                moveOut: true,
                zIndex: 99999,
                btn:['提交','重置'],
                end : function(){
                    if(bool){
                        table.reload("userTeble");
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

        // 删除用户按钮
        $("#delSysUser").on("click", function(){
            //table.exportFile("userTeble",'',"xls");
            var s = table.checkStatus('userTeble');
            if(s.data.length <= 0){
                layer.msg("请选择要删除的用户", {icon: 5,time: 2000});
                return;
            }
            var sid = "";
            for(var i = 0; i < s.data.length;i++){
                sid += s.data[i].userId + ",";
            }

            layer.open({
                icon:3,
                title: "批量删除",
                content : "是否删除这些用户？",
                btn: ['确认', '取消'],
                yes: function(index, layero){
                    $.ajax({
                        type:"delete",
                        url:'users/delSysUserBatch',
                        data:{ids : sid.substr(0, sid.length-1)},
                        dataType:"json",
                        success:function(json){
                            if(json.statusCode == 200){
                                table.reload("userTeble", {});
                                layer.msg(json.message, {icon: 6,time: 2000});
                            }else{
                                layer.msg(json.message, {icon: 5,time: 2000});
                            }
                        }
                    });
                },
                btn2: function(index, layero){ }
            });
        });

        form.on('switch(changeStatus)',function(obj){
            var userId = obj.value;
            var _status = this.checked ? '1' : '0';
            layer.open({
                icon: 3,
                title: "确认",
                content: "确定要修改当前用户状态？",
                btn: ['确认', '取消'],
                yes: function (index, layero) {
                    $.ajax({
                        type: "post",
                        url: 'users/updateStatus',
                        data: {userId: userId, status: _status},
                        dataType: "json",
                        success: function (json) {
                            if (json.statusCode == 200) {
                                table.reload("userTeble", {});
                                layer.msg(json.message, {icon: 6, time: 2000});
                            } else {
                                layer.msg(json.message, {icon: 5, time: 2000});
                            }
                        }
                    });
                }, btn2: function (index, layero) {
                }
            });
        });

        // 监听表格行上的按钮
        table.on('tool(userLay)', function(obj){

            var data = obj.data;            //获得当前行数据
            var layEvent = obj.event;       //获得 lay-event 对应的值
            var tr = obj.tr;                //获得当前行 tr 的DOM对象

            if(layEvent === 'del') {  //删除
                layer.open({
                    icon: 3,
                    title: "删除",
                    content: "确认删除？",
                    btn: ['确认', '取消'],
                    yes: function (index, layero) {
                        $.ajax({
                            type: "delete",
                            url: 'users/deleteSysUser',
                            data: {userId: data.userId},
                            dataType: "json",
                            success: function (json) {
                                if (json.statusCode == 200) {
                                    table.reload("userTeble", {});
                                    layer.msg(json.message, {icon: 6, time: 2000});
                                } else {
                                    layer.msg(json.message, {icon: 5, time: 2000});
                                }
                            }
                        });
                    },
                    btn2: function (index, layero) {
                    }
                });

            } else if(layEvent === 'edit'){ //编辑
                var bool = false;
                layer.open({
                    type: 2,
                    title: '修改用户信息',
                    content: 'users/toUpdate?userId='+data.userId,
                    area: ['750px', '600px'],
                    anim: 5,
                    isOutAnim: true,
                    maxMin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999,
                    btn:['提交','重置'],
                    end : function(){
                        if(bool){
                            table.reload("userTeble");
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
            } else if(layEvent === 'role'){ //设置角色
                var bool = false;
                layer.open({
                    type: 2,
                    title: '设置角色',
                    content: 'users/toSetRoles/' +data.userId,
                    area: ['600px', '400px'],
                    anim: 5,
                    isOutAnim: true,
                    maxMin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999,
                    success: function(layero, index){
                        var body = layer.getChildFrame('body', index);
                        body.contents().find("#id").val(data.user_id);
                    },
                    btn:['提交','重置'],
                    end : function(){
                        if(bool){
                            table.reload("userTeble");
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
            } else if(layEvent === 'shou'){ //修改密码
                var bool = false;
                layer.open({
                    type: 2,
                    title: '修改密码',
                    content: 'users/toUpdPwd/'+data.userId,
                    area: ['600px', '400px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999,
                    success: function(layero, index){
                        var body = layer.getChildFrame('body', index);
                        body.contents().find("INPUT[name='id']").val(data.user_id);
                    },
                    btn:['提交','重置'],
                    end : function(){
                        if(bool){
                            table.reload("userTeble");
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
