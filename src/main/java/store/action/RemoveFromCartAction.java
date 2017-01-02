package store.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dao.Action;
import store.dao.ListItemDAO;
import store.model.ListItem;
import store.model.ShoppingCart;

public class RemoveFromCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String msg = "Item removed.";
		ShoppingCart cart = new ShoppingCart();
		
		ListItemDAO item = new ListItem();
		
		int id = Integer.parseInt(request.getParameter("itemId"));
		
		try
		{
		item.removeListItem(id);
		}
		catch (Exception e)
		{
			request.setAttribute("message", e.getMessage());
			return "/WEB-INF/error.jsp";
		}
		
		List<ListItem> list = item.findAll();
		
		cart.setItemList(list);
		
		request.getSession().setAttribute("cart", cart);
		
		request.setAttribute("message", msg);
		
		return "/WEB-INF/success.jsp";
	}

}
