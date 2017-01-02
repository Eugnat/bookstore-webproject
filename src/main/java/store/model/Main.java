package store.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import store.factory.Factory;

public class Main {

	public static void main(String[] args) {
		
		
		Factory.createEMF();
		
		EntityManager em = Factory.emf.createEntityManager();
		
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		
		Book book = em.find(Book.class, 2);
		ListItem item = new ListItem(book);
		
		em.persist(item);
		
		tr.commit();
		
		em.close();
		
		Factory.closeEMF();

	}

}
