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
                <h2> 商品详情</h2>
            </div>
            <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
                <div class="panel heading-border">
                        <div class="panel-body bg-light">
                            <div class="section row">
                                <div class="col-md-1" style="margin-top: 10px;"><b>名称</b></div>
                                <div class="col-md-5">
                                    <label for="cakename" class="field prepend-icon">
                                        <input type="text" name="cakename" readonly id="cakename" class="gui-input" value="${cake.cakename}" required>
                                        <label for="cakename" class="field-icon">
                                            <i class="fa fa-navicon"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-1" style="margin-top: 10px;"><b>状态</b></div>
                                <div class="col-md-3" style="margin-top: 10px;">${cake.status}</div>
                            </div>
                            <div class="section row">
                                <div class="col-md-1" style="margin-top: 10px;"><b>图片</b></div>
                                <div class="col-md-1" id="showImage">
                                    <img src="${cake.image}" style="height: 50px;">
                                </div>
                            </div>
                            <div class="section row">
                                <div class="col-md-1" style="margin-top: 10px;"><b>所属分类</b></div>
                                <div class="col-md-2">
                                    ${cake.catalog.name}
                                </div>
                                <div class="col-md-1" style="margin-top: 10px;"><b>口味</b></div>
                                <div class="col-md-2">${cake.taste}</div>
                                <div class="col-md-1" style="margin-top: 10px;"><b>甜度</b></div>
                                <div class="col-md-2">${cake.sweet}度</div>
                            </div>
                            <div class="section row">
                                <div class="col-md-1" style="margin-top: 10px;"><b>价格</b></div>
                                <div class="col-md-2">${cake.price}</div>
                                <div class="col-md-1" style="margin-top: 10px;"><b>重量</b></div>${cake.weight}</div>
                                <div class="col-md-1" style="margin-top: 10px;"><b>尺寸</b></div>
                                <div class="col-md-2">${cake.size}</div>
                                <div class="col-md-1" style="margin-top: 10px;"><b>品牌</b></div>
                                <div class="col-md-2">${cake.brand}</div>
                            </div>
                            <div class="section row">
                                <div class="col-md-1" style="margin-top: 10px;"><b>材料</b></div>
                                <div class="col-md-8">${cake.ingredients}</div>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="button" class="button" onclick="javascript:window.location.href='/admin/Cake/list.do';"> 返回 </button>
                        </div>
                </div>
            </div>
        </div>
    </section>
</section>

<jsp:include page="buttom.jsp"/>
