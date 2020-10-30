<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <title>后台管理</title>
    <link rel="icon" href="image/common/title.png" type="image/x-icon" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="js/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="css/business/index/admin.css" media="all">
</head>
<body class="layui-layout-body">
<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="http://www.baidu.com" target="_blank" title="前台">
                        <i class="layui-icon layui-icon-website"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
                <!-- <li class="layui-nav-item layui-hide-xs" lay-unselect>
                  <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="template/search.html?keywords=">
                </li> -->
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

                <!-- <li class="layui-nav-item" lay-unselect>
                  <a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心">
                    <i class="layui-icon layui-icon-notice"></i>

                    如果有新消息，则显示小圆点
                    <span class="layui-badge-dot"></span>
                  </a>
                </li> -->
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="theme">
                        <i class="layui-icon layui-icon-theme"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="note">
                        <i class="layui-icon layui-icon-note"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite>${userName}</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd style="text-align: center;"><a lay-href="login/toUpdPassword">修改密码</a></dd>
                        <hr>
                        <dd style="text-align: center;"><a id="exit">退出</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="about123">
                        <i class="layui-icon layui-icon-more-vertical"></i>
                    </a>
                </li>
                <!-- <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                  <a href="javascript:;" layadmin-event="more">
                      <i class="layui-icon layui-icon-more-vertical"></i>
                  </a>
                </li> -->
            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="console.html">
                    <span>后台管理</span>
                </div>

                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                    <li data-name="home" class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;" lay-tips="主页" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>主页</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd data-name="console" class="layui-this">
                                <a lay-href="console.html">控制台</a>
                            </dd>
                        </dl>
                    </li>
                    <c:forEach items="${leavel1Menu}" var="leavel1">
                        <li data-name="${leavel1.rel }" class="layui-nav-item">
                            <a href="javascript:;" lay-tips="${leavel1.menuName }" lay-direction="2">
                               <i class="layui-icon">${leavel1.icon }</i>
                                <cite>${leavel1.menuName }</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <c:forEach items="${leavel2Menu}" var="leavel2">
                                    <c:choose>
                                        <c:when test="${leavel2.pMenuId==leavel1.menuId }">
                                            <c:choose>
                                                <c:when test="${leavel2.subMenuNumbers<=0 }">
                                                    <dd data-name="${leavel2.rel }">
                                                        <a lay-href="${leavel2.url }">${leavel2.menuName }</a>
                                                    </dd>
                                                </c:when>
                                                <c:otherwise>
                                                    <dd data-name="${leavel2.rel }">
                                                        <a href="javascript:;">${leavel2.menuName }</a>
                                                        <dl class="layui-nav-child">
                                                            <c:forEach items="${leavel3Menu}" var="leavel3">
                                                                <c:choose>
                                                                    <c:when test="${leavel2.menuId==leavel3.pMenuId}">
                                                                        <dd data-name="${leavel3.rel }">
                                                                            <a lay-href="${leavel3.url }">${leavel3.menuName }</a>
                                                                        </dd>
                                                                    </c:when>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </dl>
                                                    </dd>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </dl>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="console.html" lay-attr="console.html" class="layui-this">
                        <i class="layui-icon layui-icon-home"></i>
                    </li>
                </ul>
            </div>
        </div>

        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show layadmin-iframe" style="overflow:scroll;">
                <jsp:include page="./console.jsp"></jsp:include>
            </div>
        </div>
        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>

<script src="js/layui/layui.js"></script>
<script type="text/javascript" src="js/common/jquery-1.8.2.js"></script>
<script>
    layui.config({
        base: 'js/' //静态资源所在路径
    }).extend({
        index:"lib/index", //主入口模块
        console:"console"
    }).use(['index','console']);
    $(function(){
        $("#exit").on("click", function(){
            window.parent.location = "login/exit";
        });
    });
</script>
</body>
</html>


