package store.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import store.dao.ListItemDAO;
import store.factory.Factory;
import store.model.Book;
import store.model.ListItem;

public class ListItemImpl implements ListItemDAO {

	@Override
	public List<ListItem> findAll() {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		List<ListItem> list = em.createQuery("from ListItem").getResultList();
		
		em.close();
		
		return list;
		
	}

	@Override
	public void addListItem(int id) {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		
		try
		{
			Book book = em.find(Book.class, id);
		ListItem item = new ListItem(book);
		item.setQuantity(1);
		em.persist(item);
		}
		catch (Exception e)
		{
			tr.rollback();
		}
		
		tr.commit();
		
		em.close();
		
	}
	
	@Override
	public void addListItem(int id, int quantity) {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		
		try
		{
			Book book = em.find(Book.class, id);
		ListItem item = new ListItem(book);
		item.setQuantity(quantity);
		em.persist(item);
		}
		catch (Exception e)
		{
			tr.rollback();
		}
		
		tr.commit();
		
		em.close();
		
	}

	@Override
	public void removeListItem(int id) {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		
		ListItem item = em.find(ListItem.class, id);
		
		em.remove(item);
		
		tr.commit();
		
		em.close();
		
	}

	@Override
	public void updateListItem(int id, int quantity) {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		
		ListItem item = em.find(ListItem.class, id);
		
		item.setQuantity(quantity);
		
		em.persist(item);
		
		tr.commit();
		
		em.close();
	}

}
