<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <!-- bese标签作用：控制整个页面上的请求路径的根路径-->
    <base href="<%=basePath%>"> <%-- ${pageContex.request.contextPath}/--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>后台管理</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function(){
           $("#verifyCode").on("click",function(){
               $(this).attr("src","login/verifyCode?"+new Date())
           });
        });
    </script>
</head>

<body>
<div class="login_box">
    <div class="login_l_img"><img src="images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
        <div class="login_name">
            <p>后台管理系统</p>
        </div>
        <form action="login/doLogin" method="post">
            <input name="loginName" type="text"  value="${loginName}" placeholder="请输入用户名"/>
            <input name="password" type="password" id="password"  placeholder="请输入密码"/>
            <input name="verifyCode" type="text" style="width: 65%;" placeholder="请输入验证码" />
            <img src="login/verifyCode" id="verifyCode" title="点击切换" style="position: absolute;height: 50px;margin-left: 2px;" />
            <input value="登录" style="width:100%;" type="submit"/>
            <span style="color:red">${msg}</span>
        </form>
    </div>
    <div class="copyright">云和数据Java202004班 版权所有©2020-2022 技术支持电话：000-00000000</div>
</div>
</body>
</html>