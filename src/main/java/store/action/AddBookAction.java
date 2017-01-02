package store.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.controller.BookValidator;
import store.dao.Action;
import store.dao.BookDAO;
import store.model.Book;

public class AddBookAction implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		BookDAO bookDAO = new Book();
		String title;
		String author;
		int pageNumber;
		String isbn;
		String category;
		String imageUrl;
		String publishingHouse;
		int issueYear;
		float price;
		boolean bestseller;
		String language;
		int copyNumber;
		
		String msg = "Book added.";
		
		try {
		title = request.getParameter("title");
		author = request.getParameter("author");
		pageNumber = Integer.parseInt(request.getParameter("page_number"));
		isbn = request.getParameter("isbn");
		category = request.getParameter("category");
		imageUrl = request.getParameter("image_url");
		publishingHouse = request.getParameter("publishing_house");
		issueYear = Integer.parseInt(request.getParameter("issue_year"));
		price = Float.parseFloat(request.getParameter("price"));
		bestseller = Boolean.parseBoolean(request.getParameter("bestseller"));
		language = request.getParameter("language");
		copyNumber = Integer.parseInt(request.getParameter("copy_number"));
		}
		catch (Exception e)
		{
			request.setAttribute("message", e.getMessage());
			return "/WEB-INF/error.jsp";
		}
		
		BookValidator validator = new BookValidator();
		
		if (!validator.validate(request, isbn, category, imageUrl, issueYear))
			return "/WEB-INF/error.jsp";
		
		try
		{
		bookDAO.addBook(title, author, pageNumber, isbn, category, imageUrl, publishingHouse, issueYear, price, bestseller, language, copyNumber);
		}
		catch (Exception e)
		{
			request.setAttribute("message", "Failed to add the book");
			return "/WEB-INF/error.jsp";
		}
		
		request.setAttribute("message", msg);
		
		return "/WEB-INF/success.jsp";
	}

}
