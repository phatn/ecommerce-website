<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    <p class="text-muted lead text-center"><spring:message code="label.product.new-arrivals"/> </p>
	
    <div class="row products">
    <c:forEach items="${newArrivalProduct.list}" var="prod">
        <div class="col-md-3 col-sm-4">
            <div class="product">
                <div class="image">
                    <a href="<c:url value ='/product/${prod.selUrl}' /> ">
                        <img src="${prod.mediumImage.productImage}" alt="" class="img-responsive image1">
                    </a>
                </div>
                <!-- /.image -->
                
                <div class="text">
                    <h3><a href="shop-detail.html"><c:if test="${not empty prod.nameAttributeValue}">${prod.nameAttributeValue.value}</c:if> </a></h3>
                    <p class="price"><c:if test="${not empty prod.salePrice}"><del>$<fmt:formatNumber pattern="#,##0.00" value="${prod.salePrice}" type="number"/></del></c:if> $<fmt:formatNumber value="${prod.price}" type="number"/></p>
                    <p class="buttons">
                        <a href="shop-detail.html" class="btn btn-default">View detail</a>
                        <a href="shop-basket.html" class="btn btn-template-main"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                    </p>
                </div>
                <!-- /.text -->
                
                <c:if test="${not empty prod.salePrice}">
                <div class="ribbon sale">
                    <div class="theribbon"><spring:message code="label.product.sale"/></div>
                    <div class="ribbon-background"></div>
                </div>
                </c:if>
                <!-- /.ribbon -->

                <!-- <div class="ribbon new">
                    <div class="theribbon"><spring:message code="label.product.new"/></div>
                    <div class="ribbon-background"></div>
                </div> -->
                <!-- /.ribbon -->
                
            </div>
            <!-- /.product -->
        </div>
        <!-- /.col-md-4 -->
     </c:forEach>
    </div>
    <!-- /.products -->

	<p class="text-muted lead text-center"><spring:message code="label.product.features-product"/> </p>
	
    <div class="row products">
    <c:forEach items="${featuredProduct.list}" var="prod">
        <div class="col-md-3 col-sm-4">
            <div class="product">
                <div class="image">
                    <a href="<c:url value ='/product/${prod.selUrl}' /> ">
                        <img src="${prod.mediumImage.productImage}" alt="" class="img-responsive image1">
                    </a>
                </div>
                <!-- /.image -->
                
                <div class="text">
                    <h3><a href="shop-detail.html"><c:if test="${not empty prod.nameAttributeValue}">${prod.nameAttributeValue.value}</c:if> </a></h3>
                    <p class="price"><c:if test="${not empty prod.salePrice}"><del>$<fmt:formatNumber pattern="#,##0.00" value="${prod.salePrice}" type="number"/></del></c:if> $<fmt:formatNumber value="${prod.price}" type="number"/></p>
                    <p class="buttons">
                        <a href="shop-detail.html" class="btn btn-default">View detail</a>
                        <a href="shop-basket.html" class="btn btn-template-main"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                    </p>
                </div>
                <!-- /.text -->
                
                <c:if test="${not empty prod.salePrice}">
                <div class="ribbon sale">
                    <div class="theribbon"><spring:message code="label.product.sale"/></div>
                    <div class="ribbon-background"></div>
                </div>
                </c:if>
                
            </div>
            <!-- /.product -->
        </div>
        <!-- /.col-md-4 -->
     </c:forEach>
    </div>
    <!-- /.products -->

   <%--  <div class="col-sm-12">

        <div class="banner">
            <a href="#">
                <img src="<c:url value='/resources/img/banner2.jpg'/> " alt="" class="img-responsive">
            </a>
        </div>

        <div class="pages">

            <p class="loadMore">
                <a href="#" class="btn btn-template-main"><i class="fa fa-chevron-down"></i> <spring:message code="label.product.load-more"/></a>
            </p>

            <ul class="pagination">
                <li><a href="#">&laquo;</a>
                </li>
                <li class="active"><a href="#">1</a>
                </li>
                <li><a href="#">2</a>
                </li>
                <li><a href="#">3</a>
                </li>
                <li><a href="#">4</a>
                </li>
                <li><a href="#">5</a>
                </li>
                <li><a href="#">&raquo;</a>
                </li>
            </ul>
        </div>

    </div> --%>
    <!-- /.col-sm-12 -->

</div>
<!-- /.container -->