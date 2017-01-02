<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/header.jsp" />

			<div class="main-content">
				<p>Please enter book details below. All fields are mandatory.</p>
				<p>Please note that ISBN number contains 13 characters.</p>
				<br />
				<c:url value="/book/addbook" var="link" scope="page"/>
				<form name="addbookform" action="${link}" method="post" accept-charset="UTF-8" id="addbook_form">
					<p><label>Book title:</label> <input type="text" name="title" required size="50" maxlength="200"></p>
					<p><label>Author name:</label> <input type="text" name="author" required size="50" maxlength="200"></p>
					<p><label>Page number:</label> <input type="text" name="page_number" required size="50" maxlength="4" pattern="[0-9]+"></p>
					<p><label>ISBN (13 symbols):</label> <input type="text" name="isbn" required size="50" maxlength="20" pattern="[0-9]{13}"></p>
					<p><label>Category:</label> <input type="text" name="category" required size="50" maxlength="200" list="categories"></p>
					<datalist id="categories">
						<option>Fiction</option>
						<option>Artwork</option>
						<option>Children</option>
						<option>History</option>
						<option>Poetry</option>
					</datalist>
					<p><label>Image URL:</label> <input type="text" name="image_url" required size="50" maxlength="200" pattern=".+\.jpg"></p>
					<p><label>Publishing house:</label> <input type="text" name="publishing_house" required size="50" maxlength="200"></p>
					<p><label>Publication year:</label> <input type="text" name="issue_year" required size="50" maxlength="4" pattern="[0-9]{4}"></p>
					<p><label>Price:</label> <input type="text" name="price" required size="50" maxlength="20" pattern="\d+(\.\d{2})?"></p>
					<p><label>Bestseller?</label> <input type="checkbox" name="bestseller" value="true"></p>
					<p><label>Language:</label> <input type="text" name="language" required size="50" maxlength="20"></p>
					<p><label>Copy number:</label> <input type="text" name="copy_number" required size="50" maxlength="6" pattern="[0-9]+"></p>
					<p><input type="submit" value="Add book"></p>
				</form>
			</div>

<jsp:include page="/footer.jsp" />