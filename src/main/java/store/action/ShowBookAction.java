package store.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dao.Action;
import store.dao.BookDAO;
import store.factory.Factory;
import store.model.Book;

public class ShowBookAction implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		BookDAO bookDAO = new Book();
		Book book;
		int id;
		
		id = Integer.parseInt(request.getParameter("id"));
		book = bookDAO.findOne(id);
		
		request.setAttribute("book", book);
		
		return "/WEB-INF/showbook.jsp";
		
		
	}
	
	

}
