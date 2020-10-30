<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath %>">
    <title>订单管理</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <%-- 引用layui.css --%>
    <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css"href="css/common/common.css" />
</head>
<body>
<div class="ibox">
    <div class="ibox-content bodycss">
        <!-- 表单搜索 开始 -->
        <section class="panel panel-padding ">
            <form class="layui-form layui-form-pane form-search"
                  onsubmit="return false" method="get">
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">订单号</label>
                    <div class="layui-input-inline">
                        <input name="orderSn" id="orderSn" value="" placeholder="请输入订单号"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">用户ID</label>
                    <div class="layui-input-inline">
                        <input name="userId" id="userId" value="" placeholder="请输入用户id"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">用户名称</label>
                    <div class="layui-input-inline">
                        <input name="userName" id="userName" value="" placeholder="请输入用户名"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">订单状态</label>
                    <div class="layui-input-inline" >
                        <div  style="width:150px">
                            <select name="orderState" id="orderState" > <!-- 订单状态：0:已取消;10(默认):待确认;20:已确认;30:已配货;40:已发货;50:已收款;60:已退货 -->
                                <option value="">请选择</option>
                                <option value="0">已取消</option>
                                <option value="10">待确认</option>
                                <option value="20">已确认</option>
                                <option value="30">已配货</option>
                                <option value="40">已发货</option>
                                <option value="50">已收款</option>
                                <option value="60">已退货</option>
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
                <div class="ibox-toolbar">
                    <button id="exportExcel" data-modal="" data-title="导出Excel"
                            class="layui-btn layui-btn-sm">
                        <i class="layui-icon">&#xe667;</i> 导出Excel
                    </button>
                    <button id="exportPdf" data-modal="" data-title="导出PDF"
                            class="layui-btn layui-btn-sm">
                        <i class="layui-icon">&#xe667;</i> 导出PDF
                    </button>
                </div>
            <table class="layui-table"
                   lay-data="{
	                        id: 'orderTable',
	                        width:'auto',
	                        url:'orders/list',
	                        page:true,
	                        even:true,
	                        skin:'row',
	                        limits:[10,20,30,40,50],
	                        limit:10}"
                   lay-filter="popedomLay">
                <thead>
                <tr>
                    <th lay-data="{checkbox:true,disabledKey:'check_status',disabledKeyValue:'1,2'}"></th>
                    <th lay-data="{type:'numbers', width:50}">序号</th>
                    <!-- <th lay-data="{field:'orderId', width:120,align:'center'}">订单id</th> -->
                    <th lay-data="{field:'orderSn', width:200,align:'center'}">订单编号</th>
                    <th lay-data="{field:'userId', width:120,align:'center'}">用户id(tvn号)</th>
                    <th lay-data="{field:'userName', width:200,align:'center'}">用户姓名</th>
                    <th lay-data="{field:'orderState', width:120,align:'center',templet:'#m_type'}">订单状态</th>
                    <th lay-data="{fixed: 'right', width:350, align:'center', toolbar: '#popedomBar'}">操作</th>
                </tr>
                </thead>
            </table>
        </section>
    </div>
</div>
<script type="text/html" id="m_type">
    {{#  if(d.orderState == "0") {  }}
    <font color="#00ff00">已取消</font>
    {{#  } else if(d.orderState == "10") {  }}
    <font color="#ff0000">待确认</font>
    {{#  } else if(d.orderState == "20") {  }}
    <font color="#ff0000">已确认</font>
    {{#  } else if(d.orderState == "30") {  }}
    <font color="#ff0000">已配货</font>
    {{#  } else if(d.orderState == "40") {  }}
    <font color="#ff0000">已发货</font>
    {{#  } else if(d.orderState == "50") {  }}
    <font color="#ff0000">已收款</font>
    {{#  } else if(d.orderState == "60") {  }}
    <font color="#ff0000">已退货</font>
    {{#  }  }}
</script>
<script type="text/html" id="popedomBar">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">订单发货</a>
    <a class="layui-btn layui-bg-cyan layui-btn-xs"  lay-event="editPw">取消订单</a>
</script>
<script type="text/javascript" src="<%=basePath %>js/layui/layui.js"></script>
<script type="text/javascript">
    layui.config({
        base: "<%=basePath%>js/common/"
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
            console.log(JSON.stringify(data.field));
            table.reload('orderTable', {
                where: data.field,
                page : {
                    curr : 1
                }
            });
            return false;
        });
        //导出Excel
        $("#exportExcel").on("click", function(){
            layer.load(2, {time: 1000});
            window.location.href = "orders/export?orderSn="+$("#orderSn").val()+"&userId="+$("#userId").val()+"&userName="+$("#userName").val()+"&orderState="+$("#orderState").val();
        });
        $("#exportPdf").on("click", function(){
            layer.load(2, {time: 1000});
            window.location.href = "orders/exportPdf?orderSn="+$("#orderSn").val()+"&userId="+$("#userId").val()+"&userName="+$("#userName").val()+"&orderState="+$("#orderState").val();
        });
    });
</script>
</body>
</html>
