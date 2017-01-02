package store.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dao.Action;

public class ErrorAction implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "/WEB-INF/error.html";
	}

}
