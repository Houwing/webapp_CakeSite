<%--
  Created by IntelliJ IDEA.
  User: gorden
  Date: 2020/3/28
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<jsp:include page="top.jsp"/>

<div class="row">
    <div class="container">
        <div class="jumbotron">
            <div class="container " >
                <h1>已加入订单</h1>
                <p>...</p>
                <p><a class="btn btn-primary btn-lg center-block" style="background: #F07818;border: none" href="/index.do" role="button">返回首页</a></p>
                <p><a class="btn btn-primary btn-lg center-block" style="background: #F07818;border: none" href="/my/Cart/list.do?id=${USER.id}" role="button">前往购物车</a></p>
            </div>
        </div>
    </div>
</div>


<jsp:include page="bottom.jsp"/>
