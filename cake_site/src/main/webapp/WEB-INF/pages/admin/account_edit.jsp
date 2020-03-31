<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: gorden
  Date: 2020/3/14
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content_wrapper">
    <section id="content" class="table-layout animated fadeIn">
        <div class="tray tray-center">
            <div class="content-header">
                <h2> 增加新管理员</h2>
            </div>
            <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
                <div class="panel heading-border">
                    <form method="post" action="/admin/Account/edit.do"  id="admin-form">
                        <input type="hidden" name="id" id="id" value="${account.id}">
                        <div class="panel-body bg-light">
                            <div class="section row">
                                <div class="col-md-1" style="margin-top: 10px;"><b>用户名</b></div>
                                <div class="col-md-5">
                                    <label for="username" class="field prepend-icon">
                                        <input type="text" name="username" id="username" class="gui-input" value="${account.username}" required>
                                        <label for="username" class="field-icon">
                                            <i class="fa fa-navicon"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-1" style="margin-top: 10px;"><b>权限</b></div>
                                <div class="col-md-5">
                                    <label for="priority" class="field prepend-icon">
                                        <input type="number" name="priority" id="priority" class="gui-input" placeholder="管理员" readonly>
                                        <label for="priority" class="field-icon">
                                            <i class="fa fa-navicon"></i>
                                        </label>
                                    </label>
                                </div>


                            <div class="section row">
                                <div class="col-md-1" style="margin-top: 10px;"><b>密码</b></div>
                                <div class="col-md-2">
                                    <label for="userpass" class="field prepend-icon">
                                        <input type="password" name="userpass" id="userpass" class="gui-input" value="${account.userpass}" required>
                                        <label for="userpass" class="field-icon">
                                            <i class="fa fa-coffee"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-1" style="margin-top: 10px;"><b>昵称</b></div>
                                <div class="col-md-2">
                                    <label for="nickname" class="field prepend-icon">
                                        <input type="text" name="nickname" id="nickname" class="gui-input" value="${account.nickname}" required >
                                        <label for="nickname" class="field-icon">
                                            <i class="fa fa-star"></i>
                                        </label>
                                    </label>
                                </div>
                            </div>


                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存 </button>
                            <button type="button" class="button" onclick="javascript:window.location.href='/admin/Cake/list.do';"> 返回 </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</section>

<jsp:include page="buttom.jsp"/>
