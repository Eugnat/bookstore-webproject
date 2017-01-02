package store.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dao.Action;
import store.dao.BookDAO;
import store.model.Book;

public class FindByTitleAction implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Book book = new Book();
		
		String title = request.getParameter("title");
		
		List<Book> list = book.findByTitle(title);
		
		request.setAttribute("booklist", list);
		
		return "/WEB-INF/showbooks.jsp";
	}

}
