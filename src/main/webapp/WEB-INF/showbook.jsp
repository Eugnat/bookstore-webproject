<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/header.jsp" />

			<div class="main-content">
				<table>
					<tr>
					<td>${book.id}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.pageNumber}</td>
					<td>${book.isbn}</td>
					<td>${book.category}</td>
					<td>${book.imageUrl}</td>
					<td>${book.publishingHouse}</td>
					<td>${book.issueYear}</td>
					<td>${book.price}</td>
					<td>${book.bestseller}</td>
					<td>${book.language}</td>
					<td>${book.copyNumber}</td>
					<td>
					<form method="post" action="<c:url value='/cart/addtocart' />" >
					<input type="hidden" name="itemId" value="<c:out value="${book.id}" />" />
					<p><input type="submit" value="Add to cart" /></p>
					<p>Quantity:</p>
					<p><input type="text" name="itemNumber" value="1" size="2" /></p>
					</form>
					</td>
					</tr>
				</table>
			</div>

<jsp:include page="/footer.jsp" />