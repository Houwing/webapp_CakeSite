<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>欢迎使用 IMOOC Cake 后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/theme.css">
    <link rel="stylesheet" type="text/css" href="/css/admin-forms.css">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body class="admin-validation-page" data-spy="scroll" data-target="#nav-spy" data-offset="200">
<div id="main">
    <header class="navbar navbar-fixed-top navbar-shadow">
        <div class="navbar-branding">
            <span id="toggle_sidemenu_l" class="ad ad-lines"></span>
            <a class="navbar-brand" href="../index.html">
                <H3>Cake 后台管理系统</H3>
            </a>
        </div>
    </header>
    <aside id="sidebar_left" class="nano nano-light affix">
        <div class="sidebar-left-content nano-content">
            <header class="sidebar-header">
                <div class="sidebar-widget author-widget">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img src="/images/head.jpg" class="img-responsive">
                        </a>
                        <div class="media-body">
                            <div class="media-author">${ACCOUNT.username}</div>
                            <div class="media-links">
                                <a href="/quit.do">退出</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sidebar-widget search-widget hidden">
                    <div class="input-group">
                        <span class="input-group-addon">
                        <i class="fa fa-search"></i>
                        </span>
                        <input type="text" id="sidebar-search" class="form-control" placeholder="Search...">
                    </div>
                </div>
            </header>
            <ul class="nav sidebar-menu">
                <li class="sidebar-label pt20">商品管理</li>
                <li class="active">
                    <a href="/admin/Cake/list.do">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">商品列表</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/Cake/toAdd.do">
                        <span class="glyphicon glyphicon-home"></span>
                        <span class="sidebar-title">商品上架</span>
                    </a>
                </li>
                <li class="sidebar-label pt20">分类管理</li>
                <li class="active">
                    <a href="/admin/Catalog/list.do">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">分类列表</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/Catalog/toAdd.do">
                        <span class="glyphicon glyphicon-home"></span>
                        <span class="sidebar-title">添加分类</span>
                    </a>
                </li>
                <li class="sidebar-label pt20">用户管理</li>
                <li class="active">
                    <a href="/admin/User/list.do">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">普通用户列表</span>
                    </a>
                </li>
                <c:if test="${ACCOUNT.priority==2}">
                    <li class="active">
                        <a href="/admin/Account/list.do">
                            <span class="glyphicon glyphicon-book"></span>
                            <span class="sidebar-title">用户列表</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/Account/toAdd.do">
                            <span class="glyphicon glyphicon-home"></span>
                            <span class="sidebar-title">添加用户</span>
                        </a>
                    </li>
                </c:if>
                    <c:if test="${ACCOUNT.priority<2}">
                        <li class="active">
                            <a >
                                <span class="glyphicon glyphicon-book"></span>
                                <span class="sidebar-title">用户列表</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <span class="glyphicon glyphicon-home"></span>
                                <span class="sidebar-title">添加用户</span>
                            </a>
                        </li>
                    </c:if>





            </ul>
            <div class="sidebar-toggle-mini">
                <a href="login.html">
                    <span class="fa fa-sign-out"></span>
                </a>
            </div>
        </div>
    </aside>
