<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div class="z_ttms_nav_wrap">
        <div class="z_ttms_nav_top">
            <div class="container">
                <div class="row">
                    <div class="left">
                        <img src="${ctx}/resources/img/index_logo.png" alt="">
                        <span class="z_homepage_logoname">宏程教育GEE人事管理平台</span>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!--内容-->
     <div class="z_login_content">
        <div>
            <p class="z_ttms_login_title">宏程教育考勤管理系统</p>
            <p class="z_ttms_login_title_eng">HongEdu HR Mangement System Login</p>
        </div>
        <div class="z_login_box">
            <div class="z_login_inner">
                <form id="loginForm" method="post">
                	<label class="login_label" for="">
                        <span class="z_login_in">用户名：</span><input type="text" class="z_login_user username" name="username" value="${cookie.username.value}">
                    </label>
                    <label class="login_label" for="">
                        <span class="z_login_in">密 码：</span><input type="password" class="z_login_user password" name="password" value="${cookie.password.value}">
                    </label>
                    	<center><button type="button" class="btn btn-primary w_login" id="save_btn">登录</button></center>
                </form>
            </div>
        </div>
        <div class="z_arrow"></div>
        <input type="hidden" id="basePath" value="${ctx}">
    </div>
    <script type="text/javascript" src="${ctx}/resources/js/admin/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/login/login.js"></script>
</body>
</html>