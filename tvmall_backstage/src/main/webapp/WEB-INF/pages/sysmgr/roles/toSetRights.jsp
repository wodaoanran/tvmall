<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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

    <link rel="stylesheet" type="text/css" href="js/common/ztree/zTreeStyle/zTreeStyle.css"/>
    <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css"/>

    <style>
        ul.ztree li span.button.switch {
            margin-right: 5px
        }

        /* ul.ztree ul ul li {
            display: inline-block;
            white-space: normal
        } */

        ul.ztree>li>ul>li {
            padding: 5px
        }

        ul.ztree>li {
            background: #dae6f0
        }

        ul.ztree>li:nth-child(even)>ul>li:nth-child(even) {
            background: #eef5fa
        }

        ul.ztree>li:nth-child(even)>ul>li:nth-child(odd) {
            background: #f6fbff
        }

        ul.ztree>li:nth-child(odd)>ul>li:nth-child(even) {
            background: #eef5fa
        }

        ul.ztree>li:nth-child(odd)>ul>li:nth-child(odd) {
            background: #f6fbff
        }

        ul.ztree>li>ul {
            margin-top: 12px
        }

        ul.ztree>li {
            padding: 15px;
            padding-right: 25px
        }

        ul.ztree li {
            white-space: normal !important
        }

        ul.ztree>li>a>span {
            font-size: 15px;
            font-weight: 700
        }
    </style>

    <script type="text/javascript" src="js/layui/layui.all.js"></script>
    <script type="text/javascript" src="js/common/ztree/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="js/common/ztree/jquery.ztree.all.min.js"></script>
    <SCRIPT type="text/javascript">
        <!--
        /**
         * 会话是否超时
         */
        $.ajaxSetup({
            global: true,
            type: "POST",
            complete: function (XMLHttpRequest, textStatus) {
                var data = XMLHttpRequest.responseText;
                if (data == "timeout") {
                    window.top.location = "login/exit";
                }
            }
        });

        var setting = {
            async : {
                enable : true, // 设置 zTree是否开启异步加载模式
                url : 'roles/queryPopedom/${roleId}',  // Ajax 获取数据的 URL 地址
                autoParam : [ "id=", "name=n", "level=lv" ],//异步加载时自动提交父节点属性的参数 , "name=n", "level=lv"
                type : "get",
                dataFilter : filter,
            },
            check : {
                autoCheckTrigger : false,
                checkboxType : {
                    "Y" : "ps",
                    "N" : "ps"
                },
                chkStyle : "checkbox",
                enable : true
            },
            view : {
                addDiyDom : addDiyDom
            }
        };

        function filter(treeId, parentNode, childNodes) {
            setNode(childNodes);
            return childNodes;
        }

        function addDiyDom(treeId, treeNode){
            var aObj = $("#" + treeNode.tId+"_a");
            if (treeNode.model) {
                var editStr=""; //
                $.each(treeNode.model,function(index){
                    var check = this.ishave>0?"checked":"";
                    editStr+="&nbsp;&nbsp;<label for='"+this.id+"'><input type='checkbox' id='"+
                        this.id+"'class='checkboxCtrl' "+check+"/>"
                        +this.item_name+"</label>";
                });
                aObj.append(editStr);
            }
        }

        function setNode(nodes) {
            if (!nodes) return null;
            for (var i = 0, l = nodes.length; i < l; i++) {
                nodes[i].url = "";
                setNode(nodes[i].children);
            }
        }

        $(document).ready(function() {
            $.fn.zTree.init($("#treeDemo"), setting);
        });

        function savepopedom(){

            var myZtree = $.fn.zTree.getZTreeObj("treeDemo");
            var ids=[];
            var nodes = myZtree.getCheckedNodes();
            $.each(nodes,function(){
                ids.push(this.id);
            });

            $("input[type=checkbox]:checked").each(function(){
                ids.push($(this).attr("id"));
            });

            $.ajax({
                url:"roles/saveRoleRights?ids=" + ids,
                type:"put",
                dataType:"json",
                data:{roleId:"${roleId}"},
                success:function(json){
                    if(json.statusCode == 200){
                        // 设置成功
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        parent.layer.msg("授权成功", {icon: 6,time: 2000});
                    } else{
                        // 设置失败
                        layer.msg("授权失败", {icon: 5,time: 2000});
                    }
                }
            });
        }

        function closepopedom(){
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        }

        //-->
    </SCRIPT>
</head>

<body>
<div style="padding:20px;">
    <ul id="treeDemo" class="ztree"></ul>
    <button type="submit" id="submit" style="display: none" onclick="savepopedom();" class="layui-btn">立即提交</button>
    <button type="reset" id="reset" style="display: none" onclick="closepopedom();" class="layui-btn layui-btn-primary">重置</button>
</div>
</body>
</html>
