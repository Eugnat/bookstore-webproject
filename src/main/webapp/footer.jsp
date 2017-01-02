<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		</div>
<footer>
			<div id="first-column">
				<ul>
					<li><a href="<c:url value="/index.jsp"/>">Home</a></li>
					<li><a href="<c:url value="/static/company_information.jsp"/>">Company</a></li>
					<li><a href="<c:url value="/booksearch.jsp"/>">Search books</a></li>
					<li><a href="<c:url value="/static/contacts.jsp"/>">Contacts</a></li>
				</ul>
			</div>
			<div id="second-column">
				<ul>
					<li><a href="<c:url value="/static/payment.jsp"/>">Payment</a></li>
					<li><a href="<c:url value="/static/delivery.jsp"/>">Delivery</a></li>
					<li><a href="<c:url value="/static/legal.jsp"/>">Legal info</a></li>
				</ul>
			</div>
		</footer>
	</body>
</html>