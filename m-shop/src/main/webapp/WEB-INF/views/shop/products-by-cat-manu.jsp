<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <div id="heading-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1>Category full</h1>
            </div>
            <div class="col-md-5">
                <ul class="breadcrumb">
                    <li><a href="index.html">Home</a>
                    </li>
                    <li>Category full</li>
                </ul>

            </div>
        </div>
    </div>
</div>

<div class="container">
	
    <div class="row products">
    <c:forEach items="${productPage.list}" var="prod">
        <div class="col-md-3 col-sm-4">
            <div class="product">
                <div class="image">
                   <a href="<c:url value ='/product/details/${prod.nameAttributeValue.sefUrl}' /> ">
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
    
    
    <c:if test="${fn:length(productPage.pages) > 1 }">
    <div class="col-sm-12">
        <div class="pages">
        	<ul class="pagination">
		  		<c:if test="${currentPage > 1}">
		  			<li><a href="?page=${currentPage -1 }" title="<spring:message code="label.prev" /> ">&laquo;</a></li>
		  		</c:if>
		  		<c:forEach items="${productPage.pages}" var="page" varStatus="loop">
		  			<li <c:if test="${page == currentPage}">class="active"</c:if> ><a href="?page=${page}" title="<spring:message code="label.page" /> ${page}">${page}</a></li>
		  		</c:forEach>
		  		<c:if test="${currentPage < fn:length(productPage.pages)}">
		  			<li><a href="?page=${currentPage + 1 }" title="<spring:message code="label.next" /> ">&raquo;</a></li>
		  		</c:if>
			</ul>
        </div>
    </div>
    </c:if>
    <!-- /.col-sm-12 -->
    
</div>
<!-- /.container -->