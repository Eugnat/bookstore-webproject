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
					</tr>
				</c:forEach>
				</table>
				<br />
				<br />
				<c:url value="/book/remove" var="link" scope="page" />
				<form name="remove_book_form" action="${link}" method="post" id="remove_book_form" accept-charset="UTF-8">
					<p><label>Enter book ID to remove it from the database: </label><input type="text" name="book_id" required size="2" /></p>
					<p><input type="submit" value="Remove" /></p>
				</form>
			</div>

<jsp:include page="/footer.jsp" />