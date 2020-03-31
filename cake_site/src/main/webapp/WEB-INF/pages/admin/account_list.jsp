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
                <h2> 用户管理</h2>
                <p class="lead"></p>
            </div>
            <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
                <div class="panel  heading-border">
                    <div class="panel-menu">
                        <div class="row">
                            <div class="hidden-xs hidden-sm col-md-3">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default light">
                                        <i class="fa fa-trash"></i>
                                    </button>
                                    <button type="button" class="btn btn-default light">
                                        <i class="fa fa-plus" onclick="javascript:window.location.href='/admin/Account/toAdd.do';"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="col-xs-12 col-md-9 text-right">
                                <form action="/admin/Cake/list.do" method="post">
                                    共${pageInfo.total}条 ${pageInfo.pageNum}/${pageInfo.pages}
                                    <div class="btn-group">
                                        <button type="submit" name="pageNum" value="${pageInfo.pageNum-1}" class="btn btn-default light">
                                            <i class="fa fa-chevron-left"></i>
                                        </button>
                                        <button type="submit" name="pageNum" value="${pageInfo.pageNum+1}" class="btn btn-default light">
                                            <i class="fa fa-chevron-right"></i>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body pn">
                        <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                            <thead>
                            <tr class="">
                                <th class="text-center hidden-xs"></th>
                                <th class="hidden-xs">用户id</th>
                                <th class="hidden-xs">用户名</th>
                                <th class="hidden-xs">用户密码</th>
                                <th class="hidden-xs">用户昵称</th>
                                <th class="hidden-xs">用户等级</th>
                                <th class="hidden-xs">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="account">
                                <tr class="message-unread">
                                    <td class="hidden-xs">
                                        <label class="option block mn">
                                            <input type="checkbox" name="mobileos" value="FR">
                                            <span class="checkbox mn"></span>
                                        </label>
                                    </td>
                                    <td>${account.id}</td>
                                    <td>${account.username}</td>
                                    <td>${account.userpass}</td>
                                    <td>${account.nickname}</td>
                                    <td>${account.priority}</td>
                                    <td>
                                        <a href="/admin/Account/toEdit.do?id=${account.id}">编辑</a>
                                        <a href="/admin/Account/delete.do?id=${account.id}">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>

<jsp:include page="buttom.jsp"/>
