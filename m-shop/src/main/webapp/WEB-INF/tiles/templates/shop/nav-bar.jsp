<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="contextPath" value="/" />

<div class="container">
    <div class="navbar-header">
		
        <a class="navbar-brand home" href="${contextPath}">
            <img src="${contextPath}/resources/img/logo.png" alt="MyEshop Logo" class="hidden-xs hidden-sm">
            <img src="${contextPath}/resources/img/logo.png" alt="MyEshop Logo" class="visible-xs visible-sm"><span class="sr-only">MyEshop - go to homepage</span>
            <%-- <img src="<c:url value='/resources/img/logo-small.png' /> " alt="Universal logo" class="visible-xs visible-sm"><span class="sr-only">Universal - go to homepage</span> --%>
        </a>
        <div class="navbar-buttons">
            <button type="button" class="navbar-toggle btn-template-main" data-toggle="collapse" data-target="#navigation">
                <span class="sr-only">Toggle navigation</span>
                <i class="fa fa-align-justify"></i>
            </button>
        </div>
    </div>
    <!--/.navbar-header -->

    <div class="navbar-collapse collapse" id="navigation">

        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown active">
                <a href="${contextPath}" class="dropdown-toggle"><spring:message code="label.nav-bar.home"/> <!-- <b class="caret"></b> --></a>
            </li>
            <li class="dropdown use-yamm yamm-fw">
                <a href="<c:url value='/product/laptop' /> " class="dropdown-toggle" data-toggle="dropdown"><spring:message code="label.nav-bar.laptop"/> <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <div class="yamm-content">
                            <div class="row">
                                <div class="col-sm-6">
                                    <img src="<c:url value='/resources/img/template-easy-customize.png' /> " class="img-responsive hidden-xs" alt="">
                                </div>
                                <div class="col-sm-3">
                                    <h5><spring:message code="label.nav-bar.top-brands"/></h5>
                                  <!--   <ul>
                                        <li><a href="template-accordions.html">Accordions</a>
                                        </li>
                                    </ul> -->
                                    <c:forEach items="${manufacturers}" var="manufacturer">
                                     <ul>
                                        <li><a href="<c:url value ='/product/list/laptop/manufacturer/${manufacturer.sefUrl}'/>">${manufacturer.name}</a>
                                        </li>
                                    </ul>
                                    </c:forEach>
                                </div>
                                <div class="col-sm-3">
                                    <h5><spring:message code="label.nav-bar.price"/></h5>
                                    
                                    <c:forEach items="${productPriceRanges}" var="priceRange">
                                     	<ul>
                                        	<li>
                                        		<a href="<c:url value = '/product/list/laptop/price-range/${priceRange.sefUrl}' /> ">
                                        		<c:choose>
                                        			<c:when test="${priceRange.min.unscaledValue() eq 0}">
                                        				<spring:message code="label.nav-bar.below" />&nbsp;
                                        				$<fmt:formatNumber pattern="#,##0" value="${priceRange.max}" type="number"/>
                                        			</c:when>
                                        			<c:when test="${empty priceRange.max}">
                                        				<spring:message code="label.nav-bar.above" />&nbsp;
                                        				$<fmt:formatNumber pattern="#,##0" value="${priceRange.min}" type="number" />
                                        			</c:when>
                                        			<c:otherwise>
                                        				<spring:message code="label.nav-bar.from" />&nbsp;
                                        				$<fmt:formatNumber pattern="#,##0" value="${priceRange.min}" type="number" />&nbsp;
                                        				<spring:message code="label.nav-bar.to" />&nbsp;
                                        				$<fmt:formatNumber pattern="#,##0" value="${priceRange.max}" type="number" />
                                        			</c:otherwise>
                                        		</c:choose>
                                        		</a>
                                        	</li>
                                    	</ul>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </li>
            <li class="dropdown use-yamm yamm-fw">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <div class="yamm-content">
                            <div class="row">
                                <div class="col-sm-6">
                                    <img src="<c:url value='/resources/img/template-homepage.png' /> " class="img-responsive hidden-xs" alt="">
                                </div>
                                <div class="col-sm-3">
                                    <h5>Portfolio</h5>
                                    <ul>
                                        <li><a href="portfolio-2.html">2 columns</a>
                                        </li>
                                        <li><a href="portfolio-no-space-2.html">2 columns with negative space</a>
                                        </li>
                                        <li><a href="portfolio-3.html">3 columns</a>
                                        </li>
                                        <li><a href="portfolio-no-space-3.html">3 columns with negative space</a>
                                        </li>
                                        <li><a href="portfolio-4.html">4 columns</a>
                                        </li>
                                        <li><a href="portfolio-no-space-4.html">4 columns with negative space</a>
                                        </li>
                                        <li><a href="portfolio-detail.html">Portfolio - detail</a>
                                        </li>
                                        <li><a href="portfolio-detail-2.html">Portfolio - detail 2</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h5>About</h5>
                                    <ul>
                                        <li><a href="about.html">About us</a>
                                        </li>
                                        <li><a href="team.html">Our team</a>
                                        </li>
                                        <li><a href="team-member.html">Team member</a>
                                        </li>
                                        <li><a href="services.html">Services</a>
                                        </li>
                                    </ul>
                                    <h5>Marketing</h5>
                                    <ul>
                                        <li><a href="packages.html">Packages</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </li>
            <!-- ========== FULL WIDTH MEGAMENU ================== -->
            <li class="dropdown use-yamm yamm-fw">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">All Pages <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <div class="yamm-content">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h5>Home</h5>
                                    <ul>
                                        <li><a href="index.html">Option 1: Default Page</a>
                                        </li>
                                        <li><a href="index2.html">Option 2: Application</a>
                                        </li>
                                        <li><a href="index3.html">Option 3: Startup</a>
                                        </li>
                                        <li><a href="index4.html">Option 4: Agency</a>
                                        </li>
                                        <li><a href="index5.html">Option 5: Portfolio</a>
                                        </li>
                                    </ul>
                                    <h5>About</h5>
                                    <ul>
                                        <li><a href="about.html">About us</a>
                                        </li>
                                        <li><a href="team.html">Our team</a>
                                        </li>
                                        <li><a href="team-member.html">Team member</a>
                                        </li>
                                        <li><a href="services.html">Services</a>
                                        </li>
                                    </ul>
                                    <h5>Marketing</h5>
                                    <ul>
                                        <li><a href="packages.html">Packages</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h5>Portfolio</h5>
                                    <ul>
                                        <li><a href="portfolio-2.html">2 columns</a>
                                        </li>
                                        <li><a href="portfolio-no-space-2.html">2 columns with negative space</a>
                                        </li>
                                        <li><a href="portfolio-3.html">3 columns</a>
                                        </li>
                                        <li><a href="portfolio-no-space-3.html">3 columns with negative space</a>
                                        </li>
                                        <li><a href="portfolio-4.html">4 columns</a>
                                        </li>
                                        <li><a href="portfolio-no-space-4.html">4 columns with negative space</a>
                                        </li>
                                        <li><a href="portfolio-detail.html">Portfolio - detail</a>
                                        </li>
                                        <li><a href="portfolio-detail-2.html">Portfolio - detail 2</a>
                                        </li>
                                    </ul>
                                    <h5>User pages</h5>
                                    <ul>
                                        <li><a href="customer-register.html">Register / login</a>
                                        </li>
                                        <li><a href="customer-orders.html">Orders history</a>
                                        </li>
                                        <li><a href="customer-order.html">Order history detail</a>
                                        </li>
                                        <li><a href="customer-wishlist.html">Wishlist</a>
                                        </li>
                                        <li><a href="customer-account.html">Customer account / change password</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h5>Shop</h5>
                                    <ul>
                                        <li><a href="shop-category.html">Category - sidebar right</a>
                                        </li>
                                        <li><a href="shop-category-left.html">Category - sidebar left</a>
                                        </li>
                                        <li><a href="shop-category-full.html">Category - full width</a>
                                        </li>
                                        <li><a href="shop-detail.html">Product detail</a>
                                        </li>
                                    </ul>
                                    <h5>Shop - order process</h5>
                                    <ul>
                                        <li><a href="shop-basket.html">Shopping cart</a>
                                        </li>
                                        <li><a href="shop-checkout1.html">Checkout - step 1</a>
                                        </li>
                                        <li><a href="shop-checkout2.html">Checkout - step 2</a>
                                        </li>
                                        <li><a href="shop-checkout3.html">Checkout - step 3</a>
                                        </li>
                                        <li><a href="shop-checkout4.html">Checkout - step 4</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-sm-3">
                                    <h5>Contact</h5>
                                    <ul>
                                        <li><a href="contact.html">Contact</a>
                                        </li>
                                        <li><a href="contact2.html">Contact - version 2</a>
                                        </li>
                                        <li><a href="contact3.html">Contact - version 3</a>
                                        </li>
                                    </ul>
                                    <h5>Pages</h5>
                                    <ul>
                                        <li><a href="text.html">Text page</a>
                                        </li>
                                        <li><a href="text-left.html">Text page - left sidebar</a>
                                        </li>
                                        <li><a href="text-full.html">Text page - full width</a>
                                        </li>
                                        <li><a href="faq.html">FAQ</a>
                                        </li>
                                        <li><a href="404.html">404 page</a>
                                        </li>
                                    </ul>
                                    <h5>Blog</h5>
                                    <ul>
                                        <li><a href="blog.html">Blog listing big</a>
                                        </li>
                                        <li><a href="blog-medium.html">Blog listing medium</a>
                                        </li>
                                        <li><a href="blog-small.html">Blog listing small</a>
                                        </li>
                                        <li><a href="blog-post.html">Blog Post</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- /.yamm-content -->
                    </li>
                </ul>
            </li>
            <!-- ========== FULL WIDTH MEGAMENU END ================== -->

            <li class="dropdown">
                <a href="javascript: void(0)" class="dropdown-toggle" data-toggle="dropdown">Contact <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="contact.html">Contact option 1</a>
                    </li>
                    <li><a href="contact2.html">Contact option 2</a>
                    </li>
                    <li><a href="contact3.html">Contact option 3</a>
                    </li>

                </ul>
            </li>
        </ul>

    </div>
    <!--/.nav-collapse -->



        <div class="collapse clearfix" id="search">

            <form class="navbar-form" role="search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-btn">

    <button type="submit" class="btn btn-template-main"><i class="fa fa-search"></i></button>

</span>
                </div>
            </form>

        </div>
        <!--/.nav-collapse -->

</div>