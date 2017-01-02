<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/header.jsp" />

			<div class="main-content">
				<p>Find books:</p>
				<c:url value="/book/search" var="link" scope="page" />
				<form name="find_books_form" action="${link}" accept-charset="UTF-8" id="find_book_form" method="post">
					<p><label>Enter title:</label><input type="text" name="title" size="50" /></p>
					<p><input type="submit" value="Search" /></p>
				</form>
				
			</div>

<jsp:include page="/footer.jsp" />