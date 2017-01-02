package store.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dao.Action;
import store.factory.ActionFactory;
import store.factory.Factory;
import store.model.ShoppingCart;



public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
       
    public FrontController() {
        super();
    }
    
    public void init() throws ServletException {
    	
    	Factory.createEMF();
    	EntityManager em = Factory.emf.createEntityManager();
    	EntityTransaction tr = em.getTransaction();
    	
    	tr.begin();
    	em.createQuery("delete from ListItem").executeUpdate();
    	tr.commit();
    	
    	em.close();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String dispatchURL = null;
		Action action = ActionFactory.getAction(request);
		
		dispatchURL = action.execute(request, response);
		
		if (dispatchURL != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher(dispatchURL);
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/error.jsp");
			rd.forward(request, response);
		}
		
		
	}
	
	public void destroy() {
		Factory.closeEMF();
	}


}
