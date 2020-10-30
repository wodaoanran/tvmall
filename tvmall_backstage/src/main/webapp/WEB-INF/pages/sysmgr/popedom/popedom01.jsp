<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- 菜单管理 --%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%-- 引用layui.css --%>
<link rel="stylesheet" type="text/css" href="js/layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/ibox.css" />

</head>

<body>
<div class="ibox">
    <!-- 搜索区 -->
    <div class="ibox-title">
        <div class="title">&nbsp;&nbsp;&nbsp;系统权限管理</div>
    </div>
    <div class="ibox-content">
        <div class="ibox-toolbar">
            <button id="addPopedom" data-modal="" data-title="添加权限"  class="layui-btn layui-btn-sm">
                <i class="layui-icon">&#xe61f;</i> 添加权限
            </button>
        </div>
        <table class="layui-table"
            lay-data="{
                id: 'menuTeble',
                width:'auto',
                url:'xtgl020/query.do',
                page:true,
                even:true,
                skin:'line',
                limits:[10,20,30,40,50],
                limit:10}"
            lay-filter="popedomLay">
            <thead>
                <tr>
                <th lay-data="{checkbox: true}"></th>
                <th lay-data="{field:'menu_id', width:160}">权限项id</th>
                <th lay-data="{field:'id', width:160}">权限项id</th>
                <th	lay-data="{field:'item_name', width:280, templet:'#item_name'}">权限项名称</th>
                <th lay-data="{field:'item_code', width:280}">权限项代码</th>
                <th	lay-data="{field:'item_type', width:160, templet:'#item_type'}">权限类型</th>
                <th lay-data="{fixed: 'right', width:230, align:'center', toolbar: '#popedomBar'}"></th>
                </tr>
            </thead>
        </table>
    </div>
</div>

<script type="text/html" id="item_type">
    {{#  if(d.item_type == 1){  }}
    <font color="blue">菜单</font>
    {{#  } else{  }}
    <font color="green">功能</font>
    {{#  }  }}
</script>

<script type="text/html" id="item_name">
    {{#  var length = d.menu_id.length / 2 - 1  }}
    {{#  if(d.item_type == 0){  }}
    {{#  length++  }}
    {{#  }  }}
    {{#  for(var i = 0;i < length;i++){  }}
    &nbsp;&nbsp;&nbsp;├&nbsp;&nbsp;
    {{#  }  }}
    {{  d.item_name  }}
</script>

<script type="text/html" id="popedomBar">
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

    $("#addPopedom").on("click", function(){
        layer.open({
            type: 2,
            title: '添加权限项',
            content: 'xtgl020/toXtgl02002.do',
            area: ['800px', '400px'],
            anim: 5,
            isOutAnim: true,
            maxmin: true,
            resize: false,
            moveOut: true,
            zIndex: 99999,
            end : function(){
                table.reload("menuTeble");
            }
        });
    });

    table.on('tool(popedomLay)', function(obj){
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
                    type:"post",
                    url:'xtgl020/delPopedom.do',
                    data:{id : data.id},
                    dataType:"json",
                    success:function(json){
                                if(json.statusCode == 200){
                                    table.reload("menuTeble", {});
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
            layer.open({
            type: 2,
            title: '修改权限项',
            content: 'xtgl020/toXtgl02003.do?menuId='+data.menu_id,
            area: ['800px', '400px'],
            anim: 5,
            isOutAnim: true,
            maxmin: true,
            resize: false,
            moveOut: true,
            zIndex: 99999,
            success: function(layero, index){
                    var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
                    body.contents().find("#upd_pope_id").val(data.id);
                    /* if(data.item_type == 0){
                    body.contents().find("#"+data.menu_id).val(data.menu_id);
                    } else{
                    if(data.menu_id.length > 2){
                    body.contents().find("#upd_menu_id").val(data.menu_id.substr(0, data.menu_id.length - 2));
                    }
                    } */
                    body.contents().find("#upd_item_name").val(data.item_name);
                    body.contents().find("#upd_item_code").val(data.item_code);
            },
            end : function(){
                    table.reload("menuTeble");
                }
            });
            }
        });

    });
</script>
</body>
</html>
