package store.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import store.dao.BookDAO;
import store.factory.Factory;
import store.model.Book;


public class BookImpl implements BookDAO {
	
	
	
	public Book findOne(int id) {
		
		
		EntityManager em = Factory.emf.createEntityManager();
		
		Book book = em.find(Book.class, id);
		
		em.close();
		
		return book;
	}

	public List<Book> findByTitle(String title) {
		
		
		EntityManager em = Factory.emf.createEntityManager();
		
		//String searchLine = "%" + title + "%";
		
		//Query q = em.createNamedQuery("findByTitle").setParameter("desc", searchLine);
		
		//List<Book> list = q.getResultList();
		
		List<Book> fullList = em.createQuery("from Book").getResultList();
		
		List<Book> list = fullList.stream()
								  .filter(p -> p.getTitle().toLowerCase().contains(title.toLowerCase()))
								  .collect(Collectors.toList());
		
		em.close();
		
		return list;
	}
	
	public List<Book> findByCategory(String category) {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		List<Book> fullList = em.createQuery("from Book").getResultList();
		List<Book> list;
		
		if (category.equals("bestsellers"))
		{
			list = fullList.stream()
									  .filter(p -> p.isBestseller() == true)
									  .collect(Collectors.toList());
		}
		else
		{
			list = fullList.stream()
								  .filter(p -> p.getCategory().toLowerCase().equals(category.toLowerCase()))
								  .collect(Collectors.toList());
		}
		
		em.close();
		
	    return list;
	}
	
	public void addBook(String title, String author, int pageNumber, String isbn, String category, String imageUrl, String publishingHouse,
			int issueYear, float price, boolean bestseller, String language, int copyNumber) {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		Book book = new Book(title, author, pageNumber, isbn, category, imageUrl, publishingHouse, issueYear, price, bestseller, language, copyNumber);
		
		em.persist(book);
		tr.commit();
		
		em.close();
		
	}
	
	public List<Book> findAll() {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		List<Book> list = em.createQuery("from Book").getResultList();
		
		em.close();
		
		return list;
		
	}
	
	public void removeBook(int id) {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		
		Book book = em.find(Book.class, id);
		
		tr.commit();
		
		tr.begin();
		
		em.remove(book);
		
		tr.commit();
		
		em.close();
		
	}
	
	//not finished
	public List<Book> findSortedByPrice() {
		
		
		EntityManager em = Factory.emf.createEntityManager();
		List<Book> list = em.createQuery("from Book").getResultList();
		
		em.close();
		
		return list;
	}
	
	public List<Book> findSortedByTitleAsc() {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		List<Book> searchList = em.createQuery("from Book").getResultList();
		
		List<Book> list = searchList.stream()
									.sorted((p1, p2) -> p1.getTitle().compareTo(p2.getTitle()))
									.collect(Collectors.toList());
		
		em.close();
		return list;
	}
	
public List<Book> findSortedByTitleDesc() {
		
		EntityManager em = Factory.emf.createEntityManager();
		
		List<Book> searchList = em.createQuery("from Book").getResultList();
		
		List<Book> list = searchList.stream()
									.sorted((p1, p2) -> p2.getTitle().compareTo(p1.getTitle()))
									.collect(Collectors.toList());
		
		em.close();
		
		return list;
	}

}
