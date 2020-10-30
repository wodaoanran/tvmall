<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <base href="<%=basePath%>">
  <title>layuiAdmin std - 通用后台管理模板系统（iframe标准版）</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
</head>
<body>  
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md8">
        <div class="layui-row layui-col-space15">
          <div class="layui-col-md6">
            <div class="layui-card">
              <div class="layui-card-header">快捷方式</div>
              <div class="layui-card-body">
                <div class="layui-carousel layadmin-carousel layadmin-shortcut" lay-anim="" 
                			lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
                  <div carousel-item="">
                    <ul class="layui-row layui-col-space10 layui-this">

                      <li class="layui-col-xs3">
                        <a lay-href="#">
                          <i class="layui-icon layui-icon-auz"></i>
                          <cite>入驻审核</cite>
                        </a>
                      </li>

                        <li class="layui-col-xs3">
                          <a lay-href="#">
                            <i class="layui-icon layui-icon-form"></i>
                            <cite>公司信息</cite>
                          </a>
                        </li>

                      <li class="layui-col-xs3">
                        <a lay-href="#">
                          <i class="layui-icon layui-icon-user"></i>
                          <cite>用户信息</cite>
                        </a>
                      </li>

                      <li class="layui-col-xs3">
                        <a lay-href="#">
                          <i class="layui-icon layui-icon-list"></i>
                          <cite>职位信息</cite>
                        </a>
                      </li>

                        <li class="layui-col-xs3">
                          <a lay-href="#">
                            <i class="layui-icon layui-icon-set-sm"></i>
                            <cite>轮播图设置</cite>
                          </a>
                        </li>

                    </ul>
                  </div>
                <div class="layui-carousel-ind">
	                <ul>
		                <!-- <li class="layui-this"></li>
		                <li class=""></li> -->
	                </ul>
                </div>
                <button class="layui-icon layui-carousel-arrow" lay-type="sub"></button>
                <button class="layui-icon layui-carousel-arrow" lay-type="add"></button>
               </div>                
              </div>
            </div>
          </div>
          <div class="layui-col-md6">
            <div class="layui-card">
              <div class="layui-card-header">数据统计</div>
              <div class="layui-card-body">

                <div class="layui-carousel layadmin-carousel layadmin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
                  <div carousel-item="">
                    <ul class="layui-row layui-col-space10 layui-this">
                      <li class="layui-col-xs6">
                        <a href="javascript:;" class="layadmin-backlog-body">
                          <h3>会员数量</h3>
                          <p><cite>${dataMap.users_number }</cite></p>
                        </a>
                      </li>
                      <li class="layui-col-xs6">
                        <a href="javascript:;" class="layadmin-backlog-body">
                          <h3>今日新增会员数量</h3>
                          <p><cite>${dataMap.t_users_number }</cite></p>
                        </a>
                      </li>
                      <li class="layui-col-xs6">
                        <a href="javascript:;" class="layadmin-backlog-body">
                          <h3>公司数量</h3>
                          <p><cite>${dataMap.company_number }</cite></p>
                        </a>
                      </li>
                      <li class="layui-col-xs6">
                        <a href="javascript:;" class="layadmin-backlog-body">
                          <h3>今日新增公司数量</h3>
                          <p><cite>${dataMap.t_company_number }</cite></p>
                        </a>
                      </li>
                    </ul>
                    <ul class="layui-row layui-col-space10">
                      <li class="layui-col-xs6">
                        <a href="javascript:;" class="layadmin-backlog-body">
                          <h3>职位数量</h3>
                          <p><cite>${dataMap.position_number }</cite></p>
                        </a>
                      </li>
                      <li class="layui-col-xs6">
                        <a href="javascript:;" class="layadmin-backlog-body">
                          <h3>今日新增职位数量</h3>
                          <p><cite>${dataMap.t_position_number }</cite></p>
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div class="layui-carousel-ind">
	                <ul>
		                <!-- <li class="layui-this"></li> -->
		                <!-- <li></li> -->
	                </ul>
                  </div>
                  <button class="layui-icon layui-carousel-arrow" lay-type="sub"></button>
                  <button class="layui-icon layui-carousel-arrow" lay-type="add"></button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="layui-col-md4">
        <div class="layui-card">
          <div class="layui-card-header">版本信息</div>
          <div class="layui-card-body layui-text">
            <table class="layui-table">
              <colgroup>
                <col width="100">
                <col>
              </colgroup>
              <tbody>
                <tr>
                  <td>当前版本</td>
                  <td>
                    v1.0.0
                  </td>
                </tr>
                <tr>
                  <td>基于框架</td>
                  <td>
                    <script type="text/html" template="">
                      layui-v{{ layui.v }}
                    </script> layui-v2.4.5 
                 </td>
                </tr>
                <tr>
                  <td>主要特色</td>
                  <td>零门槛 / 响应式 / 清爽 / 极简</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
    </div>
  </div>  
  <!-- <script src="js/layui/layui.js"></script> -->
 <!--  <script>
  layui.config({
    base: 'js/' //静态资源所在路径
  }).extend({
	  console:"modules/console" //主入口模块
  }).use('console');
  </script> -->
  </div>
</body>
</html>

