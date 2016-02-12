<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>

            <div class="container">
                <div class="col-md-3 col-sm-6">
                    <h4><spring:message code="label.about-us" /></h4>

                    <p>MyEshop is an e-commerce web site, we buy all related to computer products.</p>

                    <hr>

                    <h4>Join our monthly newsletter</h4>

                    <form>
                        <div class="input-group">

                            <input type="text" class="form-control">

                            <span class="input-group-btn">

                        <button class="btn btn-default" type="button"><i class="fa fa-send"></i></button>

                    </span>

                        </div>
                        <!-- /input-group -->
                    </form>

                    <hr class="hidden-md hidden-lg hidden-sm">

                </div>
                <!-- /.col-md-3 -->

               <%--  <div class="col-md-3 col-sm-6">

                    <h4>Blog</h4>

                    <div class="blog-entries">
                        <div class="item same-height-row clearfix">
                            <div class="image same-height-always">
                                <a href="#">
                                    <img class="img-responsive" src="<c:url value='/resources/img/detailsquare.jpg' /> " alt="">
                                </a>
                            </div>
                            <div class="name same-height-always">
                                <h5><a href="#">Blog post name</a></h5>
                            </div>
                        </div>

                        <div class="item same-height-row clearfix">
                            <div class="image same-height-always">
                                <a href="#">
                                    <img class="img-responsive" src="<c:url value='/resources/img/detailsquare.jpg' /> " alt="">
                                </a>
                            </div>
                            <div class="name same-height-always">
                                <h5><a href="#">Blog post name</a></h5>
                            </div>
                        </div>

                        <div class="item same-height-row clearfix">
                            <div class="image same-height-always">
                                <a href="#">
                                    <img class="img-responsive" src="<c:url value='/resources/img/detailsquare.jpg' /> " alt="">
                                </a>
                            </div>
                            <div class="name same-height-always">
                                <h5><a href="#">Very very long blog post name</a></h5>
                            </div>
                        </div>
                    </div>

                    <hr class="hidden-md hidden-lg">

                </div> --%>
                <!-- /.col-md-3 -->

                <div class="col-md-3 col-sm-6">

                    <h4><spring:message code="label.contact" /></h4>

                    <p><strong>Manifera Pte. Ltd.</strong>
                        <br>100 Tras Street #16-01 100 AM
                        <br>Singapore 079027
                        <br>
                        <strong>Singapore</strong>
                    </p>

                    <a href="contact.html" class="btn btn-small btn-template-main"><spring:message code="label.go-to-contact-page" /> </a>

                    <hr class="hidden-md hidden-lg hidden-sm">

                </div>
                <!-- /.col-md-3 -->



               <%--  <div class="col-md-3 col-sm-6">

                    <h4>Photostream</h4>

                    <div class="photostream">
                        <div>
                            <a href="#">
                                <img src="<c:url value='/resources/img/detailsquare.jpg' /> " class="img-responsive" alt="#">
                            </a>
                        </div>
                        <div>
                            <a href="#">
                                <img src="<c:url value='/resources/img/detailsquare2.jpg' /> " class="img-responsive" alt="#">
                            </a>
                        </div>
                        <div>
                            <a href="#">
                                <img src="<c:url value='/resources/img/detailsquare3.jpg' /> " class="img-responsive" alt="#">
                            </a>
                        </div>
                        <div>
                            <a href="#">
                                <img src="<c:url value='/resources/img/detailsquare3.jpg' /> " class="img-responsive" alt="#">
                            </a>
                        </div>
                        <div>
                            <a href="#">
                                <img src="<c:url value='/resources/img/detailsquare2.jpg' /> " class="img-responsive" alt="#">
                            </a>
                        </div>
                        <div>
                            <a href="#">
                                <img src="<c:url value='/resources/img/detailsquare.jpg' /> " class="img-responsive" alt="#">
                            </a>
                        </div>
                    </div>

                </div> --%>
                <!-- /.col-md-3 -->
            </div>