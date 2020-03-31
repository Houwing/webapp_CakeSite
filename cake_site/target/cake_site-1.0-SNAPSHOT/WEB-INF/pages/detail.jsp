<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>




<jsp:include page="top.jsp"/>
<!--gallery-->

<div class="gallery">
    <div class="container">
        <div class="gallery-grids">
            <div class="col-md-4 gallery-grid ">
                <img src="${cake.image}" class="img-responsive" alt=""/>
            </div>
            <div class="col-md-8 gallery-grid">
                <div class="galy-info">
                    <h1>${cake.cakename}</h1>
                    <h5 class="item_price">$${cake.price}</h5>
                </div>
                <p class="detail_attr"><strong>尺寸&nbsp;:&nbsp;</strong>${cake.size}寸</p>
                <p class="detail_attr"><strong>重量&nbsp;:&nbsp;</strong>${cake.weight}磅</p>
                <p class="detail_attr">
                    <strong>甜度&nbsp;:&nbsp;</strong>
                    <span class="detail_xing">
                        <c:forEach begin="1" end="5" var="index">
                            <c:if test="${cake.sweet>=index}">
                                <span class="glyphicon glyphicon-star"></span>
                            </c:if>
                            <c:if test="${cake.sweet<index}">
                                <span class="glyphicon glyphicon-star-empty"></span>
                            </c:if>
                        </c:forEach>

                    </span>
                </p>
                <p class="detail_attr"><strong>口味&nbsp;:&nbsp;</strong>${cake.taste}</p>
                <p class="detail_attr"><strong>适应场合&nbsp;:&nbsp;</strong>${cake.catalog.name}</p>
                <p class="detail_attr"><strong>原材料&nbsp;:&nbsp;</strong>${cake.ingredients}</p>
                <form method="post" action="/my/Cart/addCart.do">
                    <input type="hidden" name="userId" value="${USER.id}">
                    <input type="hidden" name="cakeId" value="${cake.id}">
                    <button type="submit" class="btn-primary">
                        <div class="glyphicon glyphicon-shopping-cart"/>
                        <span>加入购物车</span>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<!--//gallery-->

<jsp:include page="bottom.jsp"/>