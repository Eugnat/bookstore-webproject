<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/css/styles.css" />">
		<title>Book web-store "Letter"</title>
	</head>
	
	<body>
		<header>
		<p><a href="<c:url value="/index.jsp"/>">Bookstore "Letter"</a></p>
		</header>
		
		<c:choose>
			<c:when test="${empty sessionScope.cart}">
				<c:set var="quantity" value="0" scope="session" />
			</c:when>
			<c:otherwise>
				<c:set var="quantity" value="${sessionScope.cart.itemQuantity}" scope="session" />
			</c:otherwise>
		</c:choose>
		
		<div class="login-bar">
			<ul>
				<li><a href="">My cart: [<c:out value="${quantity}" />] item(s)</a></li>
				<li><a href="">Login</a></li>
				<li><a href="<c:url value="/addbook.jsp" />">Add books</a></li>
				<li><a href="<c:url value="/book/showbooks" />">Show all books</a></li>
				<li><a href="<c:url value="/book/editlist" />">Edit list</a></li>
			</ul>
		</div>
		<nav class="top-navigation">
			<ul>
				<li><a href="<c:url value="/index.jsp"/>">Home</a></li>
				<li><a href="<c:url value="/static/company_information.jsp"/>">Company</a></li>
				<li><a href="<c:url value="/booksearch.jsp"/>">Search books</a></li>
				<li><a href="<c:url value="/static/payment.jsp"/>">Payment</a></li>
				<li><a href="<c:url value="/static/delivery.jsp"/>">Delivery</a></li>
				<li><a href="<c:url value="/static/contacts.jsp"/>">Contacts</a></li>
			</ul>
		</nav>
<div class="main-area">
			<nav class="side-navigation">
				<ul>
					<li><a href="<c:url value="/book/showcategory?cat=bestsellers" />">Bestsellers</a></li>
					<li><a href="<c:url value="/book/showcategory?cat=fiction" />">Fiction</a></li>
					<li><a href="<c:url value="/book/showcategory?cat=artwork" />">Art work</a></li>
					<li><a href="<c:url value="/book/showcategory?cat=children" />">Children</a></li>
					<li><a href="<c:url value="/book/showcategory?cat=history" />">History</a></li>
					<li><a href="<c:url value="/book/showcategory?cat=poetry" />">Poetry</a></li>
				</ul>
			</nav>