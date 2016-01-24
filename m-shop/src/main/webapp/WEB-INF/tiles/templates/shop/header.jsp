<%@	taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="categoryMenu">
	<div class="categoryTitle"><spring:message code="categories.label" /><img class="arrowDropDown" alt="" src="<c:url value="/resources/images/arrow-drop-down.png" />"> </div>
	<div id="leftSide">
		<ul class="sideBar">
		<%-- <c:forEach items="${categories}" var="category">
			<li <c:if test="${not empty category.categories}">class="hasChild"</c:if>>
				<a href="<c:url value="/product/list/"/>${category.description.sefUrl}">${category.description.name}</a>
			<c:if test="${not empty category.categories }">
				<ul class="subNav">
				<c:forEach items="${category.categories}" var="level1Cat">
					<li><a href="<c:url value="/product/list/"/>${level1Cat.description.sefUrl}">${level1Cat.description.name}</a>
						<c:if test="${not empty level1Cat.categories }">
							<ul>
							<c:forEach items="${level1Cat.categories}" var="level2Cat">
								<li><a href="<c:url value="/product/list/"/>${level2Cat.description.sefUrl}">${level2Cat.description.name}</a></li>
							</c:forEach>
							</ul>
						</c:if>
						<div style="height: 10px;"></div>
					</li>
				</c:forEach>
				</ul>
			</c:if>
			</li>
		</c:forEach> --%>
		
		<c:forEach items="${categories}" var="category">
			<li>
				<a href="<c:url value="/product/list/"/>${category.description.sefUrl}">${category.description.name}</a>
			</li>
		</c:forEach>
		
		</ul>
	</div>
</div>
<div class="cart">
	<a href="<c:url value="/cart/shoppingCart" />">
		<span style="color: #0072BC; background-color: #fad53f; border: 1px solid #fad53f; border-radius: 16px 16px; padding: 1px 6px 1px 6px; margin-left: 22px; position: absolute">
		<c:choose> 
		  <c:when test="${fn:length(cart.cartItems) > 0}">
		    ${cart.totalItems}
		  </c:when>
		  <c:otherwise>
		    0
		  </c:otherwise>
		</c:choose>
		</span>
		<img alt="" src="<c:url value="/resources/images/shopping-cart.png" />">
		<span class="cartLable"><spring:message code="cart.label"/></span>
		<img class="arrowDropDown" alt="" src="<c:url value="/resources/images/arrow-drop-down.png" />" />
	</a>
</div>
<div class="account">
	<sec:authorize access="!hasRole('ROLE_CUSTOMER')">
		<a href="<c:url value="/login"/> "><spring:message code="login.label"/> </a>&nbsp;<spring:message code="or.label"/>
		<a href="<c:url value="/customer/register"/> "><spring:message code="register.label"/></a>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_CUSTOMER')">
		<spring:message code="hi.label" />,&nbsp;<sec:authentication property="principal.username"/>&nbsp;|
		<a href="<c:url value="/j_spring_security_logout"/> "><spring:message code="logout.label"/></a>
	</sec:authorize>
</div>
<div class="search">
	<form action="/search">
		<input type="text" class="inputSearch"/>
		<button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-search"></span>&nbsp;<spring:message code="search.form.label" /></button>
	</form>
</div>

