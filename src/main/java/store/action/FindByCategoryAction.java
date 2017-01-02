package store.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dao.Action;
import store.dao.BookDAO;
import store.model.Book;

public class FindByCategoryAction implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		BookDAO book = new Book();
		String category = request.getParameter("cat");
		
		List<Book> list = book.findByCategory(category);
		
		request.setAttribute("booklist", list);
		
		return "/WEB-INF/showcategory.jsp";
		
	}

}
