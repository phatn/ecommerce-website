<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:url var="contextPath" value="/"/>

<div id="heading-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>Shopping cart</h1>
            </div>
            <div class="col-md-6">
                <ul class="breadcrumb">
                    <li><a href="index.html">Home</a>
                    </li>
                    <li>Shopping cart</li>
                </ul>

            </div>
        </div>
    </div>
</div>

<div id="content">
    <div class="container">

        <div class="row">
            <div class="col-md-12">
                <p class="text-muted lead">
                	<spring:message code="label.cart.current-items" arguments="${cart.totalItems}"/>
                </p>
            </div>


            <div class="col-md-9 clearfix" id="basket">

                <div class="box">

                    <form method="post" action="shop-checkout1.html">

                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th colspan="2">Product</th>
                                        <th>Quantity</th>
                                        <th>Unit price</th>
                                      <!--   <th>Discount</th> -->
                                        <th colspan="2">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${cart.cartItems}" var="cartItem">
                                    <tr>
                                        <td>
                                            <a href="#">
                                                <img src="${cartItem.product.smallImage.productImage}" alt="White Blouse Armani">
                                            </a>
                                        </td>
                                        <td><a href="${contextPath}/product/details/${cartItem.product.nameAttributeValue.sefUrl}">${fn:substring(cartItem.product.nameAttributeValue.value, 0, 40)}</a>
                                        </td>
                                        <td>
                                            <input type="number" value="${cartItem.quantity}" class="form-control">
                                        </td>
                                        <td>$<fmt:formatNumber value="${cartItem.product.price}" type="number"/></td>
                                        <!-- <td>$0.00</td> -->
                                        <td>$<fmt:formatNumber value="${cartItem.totalPrice}" type="number"/></td>
                                        <td><a href="#"><i class="fa fa-trash-o"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th colspan="5">Total</th>
                                        <th colspan="2">$<fmt:formatNumber value="${cart.grandTotal}" type="number"/></th>
                                    </tr>
                                </tfoot>
                            </table>

                        </div>
                        <!-- /.table-responsive -->

                        <div class="box-footer">
                            <div class="pull-left">
                                <a href="${contextPath}" class="btn btn-default"><i class="fa fa-chevron-left"></i> Continue shopping</a>
                            </div>
                            <div class="pull-right">
                                <button class="btn btn-default"><i class="fa fa-refresh"></i> Update cart</button>
                                <button type="submit" class="btn btn-template-main">Proceed to checkout <i class="fa fa-chevron-right"></i>
                                </button>
                            </div>
                        </div>

                    </form>

                </div>
                <!-- /.box -->

                <div class="row">
                    <div class="col-md-3">
                        <div class="box text-uppercase">
                            <h3>You may also like these products</h3>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="product">
                            <div class="image">
                                <a href="shop-detail.html">
                                    <img src="img/product2.jpg" alt="" class="img-responsive image1">
                                </a>
                            </div>
                            <div class="text">
                                <h3><a href="shop-detail.html">Fur coat</a></h3>
                                <p class="price">$143</p>

                            </div>
                        </div>
                        <!-- /.product -->
                    </div>

                    <div class="col-md-3">
                        <div class="product">
                            <div class="image">
                                <a href="shop-detail.html">
                                    <img src="img/product3.jpg" alt="" class="img-responsive image1">
                                </a>
                            </div>
                            <div class="text">
                                <h3><a href="shop-detail.html">Fur coat</a></h3>
                                <p class="price">$143</p>
                            </div>
                        </div>
                        <!-- /.product -->
                    </div>

                    <div class="col-md-3">
                        <div class="product">
                            <div class="image">
                                <a href="shop-detail.html">
                                    <img src="img/product1.jpg" alt="" class="img-responsive image1">
                                </a>
                            </div>
                            <div class="text">
                                <h3><a href="shop-detail.html">Fur coat</a></h3>
                                <p class="price">$143</p>
                            </div>
                        </div>
                        <!-- /.product -->
                    </div>

                </div>

            </div>
            <!-- /.col-md-9 -->

               <div class="col-md-3">
                   <div class="box" id="order-summary">
                       <div class="box-header">
                           <h3>Order summary</h3>
                       </div>
                       <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.</p>

                       <div class="table-responsive">
                           <table class="table">
                               <tbody>
                                   <tr>
                                       <td>Order subtotal</td>
                                       <th>$446.00</th>
                                   </tr>
                                   <tr>
                                       <td>Shipping and handling</td>
                                       <th>$10.00</th>
                                   </tr>
                                   <tr>
                                       <td>Tax</td>
                                       <th>$0.00</th>
                                   </tr>
                                   <tr class="total">
                                       <td>Total</td>
                                       <th>$456.00</th>
                                   </tr>
                               </tbody>
                           </table>
                       </div>

                   </div>


                   <div class="box">
                       <div class="box-header">
                           <h4>Coupon code</h4>
                       </div>
                       <p class="text-muted">If you have a coupon code, please enter it in the box below.</p>
                       <form>
                           <div class="input-group">

                               <input type="text" class="form-control">

                               <span class="input-group-btn">

    <button class="btn btn-template-main" type="button"><i class="fa fa-gift"></i></button>

</span>
                           </div>
                           <!-- /input-group -->
                    </form>
                </div>

            </div>
            <!-- /.col-md-3 -->

        </div>

    </div>
    <!-- /.container -->
</div>
<!-- /#content -->