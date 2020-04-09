<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: gorden
  Date: 2020/4/1
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<div class="row">
    <div class="container">
        <div class="panel panel-default">
            <c:if test="${ALART!=null}">
                <div class="alert alert-info" role="alert">${ALART}</div>
            </c:if>
            <!-- Default panel contents -->
            <div class="panel-heading">
                <span>
                    <div class="glyphicon glyphicon-shopping-cart"/>您的购物车
                </span>
            </div>


            <!-- List group -->
            <form  class="form-group" method="post" action="/my/Order/addOrder.do">
                <table class="table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>##</th>
                        <th>商品名</th>
                        <th>数量</th>
                        <th>价钱</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="carts">
                        <c:set var="cake" value="${carts.cake}"/>
                        <tr>
                            <th><input type="hidden" name="userid" value="${USER.id}"></th>
                            <th><input type="checkbox" name="cartid" value="${carts.id}"></th>
                            <th>
                                <div class="col-md-3 gallery-grid">
                                    <img src="${cake.image}" class="img-responsive">
                                </div>
                            </th>
                            <th>${cake.cakename}</th>
                            <th>
                                <a class="btn btn-default" href="/my/Cart/plusCart.do?cartId=${carts.id}" role="button">+</a>
                                <span class="badge">${carts.quantity}</span>
                                <a class="btn btn-default" href="/my/Cart/minusCart.do?cartId=${carts.id}" role="button">-</a>
                            </th>
                            <th>${cake.price}</th>
                            <th><a href="/my/Cart/remove.do?cartId=${carts.id}" class="btn-primary">删除</a> </th>
                        </tr>
                    </c:forEach>
                    <tr>
                        <div class="col-md-12 gallery-grid glry-two text-right">
                            <a href="/my/Cart/list.do?id=${USER.id}&pageNum=1" style="color:#666666;"><span class="glyphicon glyphicon-backward"></span></a>
                            <a href="/my/Cart/list.do?id=${USER.id}&pageNum=${pageInfo.pageNum-1}" style="color:#666666;"><span class="glyphicon glyphicon-chevron-left"></span></a>
                            共${pageInfo.total}条 ${pageInfo.pageNum}/${pageInfo.pages}
                            <a  href="/my/Cart/list.do?id=${USER.id}&pageNum=${pageInfo.pageNum+1}" style="color:#666666;"><span class="glyphicon glyphicon-chevron-right"></span></a>
                            <a href="/my/Cart/list.do?id=${USER.id}&pageNum=${pageInfo.pages}" style="color:#666666;"><span class="glyphicon glyphicon-forward"></span></a>
                        </div>

                    </tr>
                    </tbody>
                </table>
                <input type="submit" class="btn-primary" title="提交订单">
            </form>








        </div>
    </div>
</div>


<jsp:include page="bottom.jsp"/>
