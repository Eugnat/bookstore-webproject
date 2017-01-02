package store.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dao.Action;
import store.model.Book;

public class FindAllAction implements Action {
	
public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Book book = new Book();
		
		List<Book> list = book.findAll();
		
		request.setAttribute("booklist", list);
		
		return "/WEB-INF/showbooks.jsp";
	}

}
