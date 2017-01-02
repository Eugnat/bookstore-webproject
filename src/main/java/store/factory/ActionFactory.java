package store.factory;

import javax.servlet.http.HttpServletRequest;

import store.action.*;

import store.dao.Action;

public class ActionFactory {
	
	public static Action getAction(HttpServletRequest request) {
		
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String address = uri.substring(lastIndex + 1);
		
		Action action = null;
		
		if (address.equalsIgnoreCase("showbooks"))
		{
				action = new FindAllAction();
				return action;
		}
		
		if (address.equalsIgnoreCase("search"))
		{
				action = new FindByTitleAction();
				return action;
		}
		
		
		if (address.equalsIgnoreCase("showbook"))
		{
				action = new ShowBookAction();
				return action;
		}
		
		if (address.equalsIgnoreCase("addbook"))
		{		
				action = new AddBookAction();
				return action;
		}
		
		if (address.equalsIgnoreCase("remove"))
		{
				action = new RemoveBookAction();
				return action;
		}
		
		if (address.equalsIgnoreCase("editlist"))
		{
			action = new EditListAction();
			return action;
		}
		
		if (address.equalsIgnoreCase("showcategory"))
		{
			action = new FindByCategoryAction();
			return action;
		}
		
		if (address.equalsIgnoreCase("showsorted"))
		{
			action = new ShowSortedAction();
			return action;
		}
		
		if (address.equalsIgnoreCase("addtocart"))
		{
			action = new AddToCartAction();
			//add UpdateCartAction() if id already exists in the scope; make it via request.getSession().getAttribute("cart");
		}
		
		if (address.equalsIgnoreCase("updatecart"))
		{
			action = new UpdateCartAction();
		}
		
		if (address.equalsIgnoreCase("removefromcart"))
		{
			action = new RemoveFromCartAction();
		}
		
		if (action == null)
			action = new ErrorAction();
			
		return action;
		
			
	}

}
