package store.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dao.Action;
import store.model.Book;

public class ShowSortedAction implements Action {


	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<Book> currentList = (List<Book>) request.getSession().getAttribute("currentlist");
		
		String direction = request.getParameter("direction");
		
		List<Book> list;
		
		if (direction.equals("asc"))
		{
			list = currentList.stream()
					   		  .sorted((p1, p2) -> Float.compare(p1.getPrice(), p2.getPrice()))
					          .collect(Collectors.toList());
		}
		else 
			{
				list = currentList.stream()
			   		  .sorted((p1, p2) -> Float.compare(p2.getPrice(), p1.getPrice()))
			          .collect(Collectors.toList());
			}
		
		request.setAttribute("booklist", list);
		
		return "/WEB-INF/showcategory.jsp" + "?direction=" + direction;
	}

}
