<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:url var="contextPath" value="/"/>

<div id="heading-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1>${product.nameAttributeValue.value}</h1>
            </div>
         <%--    <div class="col-md-5">
                <ul class="breadcrumb">
                    <li><a href="${contextPath}">Home</a>
                    </li>
                    <li><a href="shop-category.html">Ladies</a>
                    </li>
                    <li><a href="shop-category.html">Tops</a>
                    </li>
                    <li>${product.nameAttributeValue.value}</li>
                </ul>

            </div> --%>
        </div>
    </div>
</div>

<div id="content">
    <div class="container">

        <div class="row">

            <!-- *** LEFT COLUMN ***
_________________________________________________________ -->

            <div class="col-md-9">

                <p class="lead">${product.productDescription.description}</p>
                <p class="goToDescription"><a href="#details" class="scroll-to text-uppercase"><spring:message code="message.scroll-to-product-details" /></a>
                </p>

                <div class="row" id="productMain">
                    <div class="col-sm-6">
                        <div id="mainImage">
                        	<c:if test="${not empty product.pairImages}">
                            <img src="${product.pairImages[0].first}" alt="" class="img-responsive">
                            </c:if>
                        </div>

						 <c:if test="${not empty product.salePrice}">
                        <div class="ribbon sale">
                            <div class="theribbon"><spring:message code="label.product.sale"/></div>
                            <div class="ribbon-background"></div>
                        </div>
                        </c:if>
                        <!-- /.ribbon -->

                        <%-- <div class="ribbon new">
                            <div class="theribbon"><spring:message code="label.product.new"/></div>
                            <div class="ribbon-background"></div>
                        </div> --%>
                        <!-- /.ribbon -->

                    </div>
                    <div class="col-sm-6">
                        <div class="box">

                            <form method="post" action="${contextPath}cart/addToCart">
                            	<input type="hidden" name="productId" value="${product.id}" />
                               <!--  <div class="sizes">

                                    <h3>Available sizes</h3>

                                    <label for="size_s">
                                        <a href="#">S</a>
                                        <input type="radio" id="size_s" name="size" value="s" class="size-input">
                                    </label>
                                    <label for="size_m">
                                        <a href="#">M</a>
                                        <input type="radio" id="size_m" name="size" value="m" class="size-input">
                                    </label>
                                    <label for="size_l">
                                        <a href="#">L</a>
                                        <input type="radio" id="size_l" name="size" value="l" class="size-input">
                                    </label>

                                </div> -->

                                <p class="price">$<fmt:formatNumber value="${product.price}" type="number"/></p>

                                <p class="text-center">
                                    <button type="submit" class="btn btn-template-main">
                                    	<i class="fa fa-shopping-cart"></i> <spring:message code="label.button.add-to-cart"/>
                                    </button>
                                   <!--  <button type="submit" class="btn btn-default" data-toggle="tooltip" data-placement="top" title="<spring:message code='label.button.add-to-wishlist'/>"><i class="fa fa-heart-o"></i>
                                    </button> -->
                                </p>

                            </form>
                        </div>

                        <div class="row" id="thumbs">
                        	<c:forEach var="pair" items="${product.pairImages}">
                            <div class="col-xs-4">
                                <a href="${pair.first}" class="thumb">
                                    <img src="${pair.second}" alt="" class="img-responsive">
                                </a>
                            </div>
                            </c:forEach>
                        </div>
                    </div>

                </div>

                <div class="box" id="details">
                    <p>
                        <h4><spring:message code="label.product.product-details" /></h4>
                        <p>${product.productDescription.description}</p>
                        <!-- <h4>Material & care</h4>
                        <ul>
                            <li>Polyester</li>
                            <li>Machine wash</li>
                        </ul>
                        <h4>Size & Fit</h4>
                        <ul>
                            <li>Regular fit</li>
                            <li>The model (height 5'8" and chest 33") is wearing a size S</li>
                        </ul> -->
						<h4><spring:message code="label.product.specifications" /></h4>
						<div class="table-responsive">
                            <table class="table">
                                <tbody>
                                <c:forEach items="${product.attributes}" var="attribute">
                                    <tr>
                                        <td>${attribute.name}</td>
                                        <th>
										<c:forEach items="${attribute.attributeValues}" var="attributeValue">
											${attributeValue.value} <br/>
										</c:forEach>
										</th>
                                    </tr>
                                </c:forEach> 
                                </tbody>
                            </table>
                        </div>
                        <blockquote>
                            <p><em>Define style this season with Armani's new range of trendy tops, crafted with intricate details. Create a chic statement look by teaming this lace number with skinny jeans and pumps.</em>
                            </p>
                        </blockquote>
                </div>

                <div class="box social" id="product-social">
                    <h4><spring:message code="label.product.show-it-to-your-friends"/></h4>
                    <p>
                        <a href="#" class="external facebook" data-animate-hover="pulse"><i class="fa fa-facebook"></i></a>
                        <a href="#" class="external gplus" data-animate-hover="pulse"><i class="fa fa-google-plus"></i></a>
                        <a href="#" class="external twitter" data-animate-hover="pulse"><i class="fa fa-twitter"></i></a>
                        <a href="#" class="email" data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
                    </p>
                </div>

                <div class="row">
                	<c:if test="${not empty productRelationships}">
                    <div class="col-md-3 col-sm-6">
                        <div class="box text-uppercase">
                            <h3><spring:message code="label.product.you-may-like-these-products"/></h3>
                        </div>
                    </div>
					</c:if>
					<c:forEach items="${productRelationships}" var="relate">
					<div class="col-md-3 col-sm-6">
                        <div class="product">
                            <div class="image">
                                 <a href="${contextPath}/product/details/${relate.relatedProduct.nameAttributeValue.sefUrl}">
                                    <img src="${relate.relatedProduct.smallImage.productImage}" alt="" class="img-responsive image1">
                                </a>
                            </div>
                            <div class="text">
                                <h3>${fn:substring(relate.relatedProduct.nameAttributeValue.value, 0, 40)}</h3>
                                <p class="price">$<fmt:formatNumber value="${relate.relatedProduct.price}" type="number"/></p>

                            </div>
                        </div>
                        <!-- /.product -->
                    </div>					
					</c:forEach>
                </div>

<%--                 <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="box text-uppercase">
                            <h3>Products viewed recently</h3>
                        </div>
                    </div>


                    <div class="col-md-3 col-sm-6">
                        <div class="product">
                            <div class="image">
                                <a href="#">
                                    <img src="${contextPath}resources/img/product3.jpg" alt="" class="img-responsive image1">
                                </a>
                            </div>
                            <div class="text">
                                <h3>Fur coat</h3>
                                <p class="price">$143</p>
                            </div>
                        </div>
                        <!-- /.product -->
                    </div>

                    <div class="col-md-3 col-sm-6">
                        <div class="product">
                            <div class="image">
                                <a href="#">
                                    <img src="${contextPath}resources/img/product1.jpg" alt="" class="img-responsive image1">
                                </a>
                            </div>
                            <div class="text">
                                <h3>Fur coat</h3>
                                <p class="price">$143</p>
                            </div>
                        </div>
                        <!-- /.product -->
                    </div>


                    <div class="col-md-3 col-sm-6">
                        <div class="product">
                            <div class="image">
                                <a href="#">
                                    <img src="${contextPath}resources/img/product2.jpg" alt="" class="img-responsive image1">
                                </a>
                            </div>
                            <div class="text">
                                <h3>Fur coat</h3>
                                <p class="price">$143</p>

                            </div>
                        </div>
                        <!-- /.product -->
                    </div>

                </div> --%>

            </div>
            <!-- /.col-md-9 -->


            <!-- *** LEFT COLUMN END *** -->

            <!-- *** RIGHT COLUMN ***
_________________________________________________________ -->

            <div class="col-sm-3">

                <!-- *** MENUS AND FILTERS ***
_________________________________________________________ -->
                <div class="panel panel-default sidebar-menu">

                    <div class="panel-heading">
                        <h3 class="panel-title"><spring:message code="label.product-filter.categories" /></h3>
                    </div>

                    <div class="panel-body">
                        <ul class="nav nav-pills nav-stacked category-menu">
                            <li>
                                <a href="shop-category.html">Men <span class="badge pull-right">42</span></a>
                                <ul>
                                    <li><a href="shop-category.html">T-shirts</a>
                                    </li>
                                    <li><a href="shop-category.html">Shirts</a>
                                    </li>
                                    <li><a href="shop-category.html">Pants</a>
                                    </li>
                                    <li><a href="shop-category.html">Accessories</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="active">
                                <a href="shop-category.html">Ladies  <span class="badge pull-right">123</span></a>
                                <ul>
                                    <li><a href="shop-category.html">T-shirts</a>
                                    </li>
                                    <li><a href="shop-category.html">Skirts</a>
                                    </li>
                                    <li><a href="shop-category.html">Pants</a>
                                    </li>
                                    <li><a href="shop-category.html">Accessories</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="shop-category.html">Kids  <span class="badge pull-right">11</span></a>
                                <ul>
                                    <li><a href="shop-category.html">T-shirts</a>
                                    </li>
                                    <li><a href="shop-category.html">Skirts</a>
                                    </li>
                                    <li><a href="shop-category.html">Pants</a>
                                    </li>
                                    <li><a href="shop-category.html">Accessories</a>
                                    </li>
                                </ul>
                            </li>

                        </ul>

                    </div>
                </div>

                <div class="panel panel-default sidebar-menu">

                    <div class="panel-heading">
                        <h3 class="panel-title"><spring:message code= "label.product-filter.brands"/></h3>
                        <a class="btn btn-xs btn-danger pull-right" href="#"><i class="fa fa-times-circle"></i> <span class="hidden-sm">Clear</span></a>
                    </div>

                    <div class="panel-body">

                        <form>
                            <div class="form-group">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox">Armani (10)
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox">Versace (12)
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox">Carlo Bruni (15)
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox">Jack Honey (14)
                                    </label>
                                </div>
                            </div>

                            <button class="btn btn-default btn-sm btn-template-main"><i class="fa fa-pencil"></i> Apply</button>

                        </form>

                    </div>
                </div>

                <div class="panel panel-default sidebar-menu">

                    <div class="panel-heading">
                        <h3 class="panel-title clearfix">Colours</h3>
                        <a class="btn btn-xs btn-danger pull-right" href="#"><i class="fa fa-times-circle"></i> <span class="hidden-sm">Clear</span></a>
                    </div>

                    <div class="panel-body">

                        <form>
                            <div class="form-group">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> <span class="colour white"></span> White (14)
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> <span class="colour blue"></span> Blue (10)
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> <span class="colour green"></span> Green (20)
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> <span class="colour yellow"></span> Yellow (13)
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> <span class="colour red"></span> Red (10)
                                    </label>
                                </div>
                            </div>

                            <button class="btn btn-default btn-sm btn-template-main"><i class="fa fa-pencil"></i> <spring:message code="label.button.apply" /></button>

                        </form>

                    </div>
                </div>

                <!-- *** MENUS AND FILTERS END *** -->

                <div class="banner">
                    <a href="shop-category.html">
                        <img src="${contextPath}resources/img/banner.jpg" alt="sales 2014" class="img-responsive">
                    </a>
                </div>
                <!-- /.banner -->
            </div>
            <!-- /.col-md-3 -->

            <!-- *** RIGHT COLUMN END *** -->

        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
</div>
<!-- /#content -->






