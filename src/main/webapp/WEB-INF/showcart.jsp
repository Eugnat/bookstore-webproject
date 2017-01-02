<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/header.jsp" />

			<div class="main-content">
				<table>
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Author</th>
					<th>Page number</th>
					<th>ISBN</th>
					<th>Category</th>
					<th>Image URL</th>
					<th>Publishing house</th>
					<th>Issue year</th>
					<th>Price</th>
					<th>Bestseller</th>
					<th>Language</th>
					<th>Copy number</th>
					<th></th>
				</tr>
				<c:forEach items="${booklist}" var="item">
					<tr>
					<td>${item.id}</td>
					<td><a href="<c:url value="/book/showbook?id=${item.id}" />">${item.title}</a></td>
					<td>${item.author}</td>
					<td>${item.pageNumber}</td>
					<td>${item.isbn}</td>
					<td>${item.category}</td>
					<td>${item.imageUrl}</td>
					<td>${item.publishingHouse}</td>
					<td>${item.issueYear}</td>
					<td>${item.price}</td>
					<td>${item.bestseller}</td>
					<td>${item.language}</td>
					<td>${item.copyNumber}</td>
					<td>
					<form method="post" action="<c:url value='/cart/addtocart' />" >
					<input type="hidden" name="itemId" value="<c:out value="${item.id}" />" />
					<p><input type="submit" value="Add to cart" /></p>
					<p>Quantity:</p>
					<p><input type="text" name="itemNumber" value="1" size="2" /></p>
					</form>
					</td>
					</tr>
				</c:forEach>
				</table>
			</div>

<jsp:include page="/footer.jsp" />