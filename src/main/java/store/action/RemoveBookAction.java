package store.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dao.Action;
import store.dao.BookDAO;
import store.model.Book;

public class RemoveBookAction implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		BookDAO bookDAO = new Book();
		String msg = "Book removed.";
		
		try
		{
		int id = Integer.parseInt(request.getParameter("book_id"));
		bookDAO.removeBook(id);
		}
		catch (Exception e)
		{
			msg = e.getMessage();
			return "/WEB-INF/error.jsp";
		}
				
		
		request.setAttribute("message", msg);
		
		return "/WEB-INF/success.jsp";
	}

}
