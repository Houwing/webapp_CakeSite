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
<%--register--%>
<div class="row">
    <div class="container">
        <div class="jumbotron">
            <div class="container " >
                <h1>您好！赶快注册开启你的my cake之旅</h1>
                <p>...</p>
                <p><a class="btn btn-primary btn-lg center-block" style="background: #F07818;border: none" href="/index.do" role="button">返回首页</a></p>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="register">
            <form method="post" action="/regist.do" >
                <div class="form-group">
                    <div class="glyphicon glyphicon-user"></div>
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="Username">
                </div>
                <div class="form-group">
                    <div class="glyphicon glyphicon-wrench"></div>
                    <label for="userpass">密码</label>
                    <input type="password" class="form-control" name="userpass" id="userpass" placeholder="Password">
                </div>
                <div class="form-group">
                    <div class="glyphicon glyphicon-tags"></div>
                    <label for="nickname">昵称</label>
                    <input type="nickname" class="form-control" name="nickname" id="nickname" placeholder="Nickname">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
    </div>
</div>

<%--register--%>
<jsp:include page="bottom.jsp"/>
