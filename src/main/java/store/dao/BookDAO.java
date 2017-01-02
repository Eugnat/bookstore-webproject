package store.dao;

import java.util.List;

import store.model.Book;

public interface BookDAO {
	
	Book findOne(int id);
	List<Book> findAll();
	
	List<Book> findByTitle(String title);
	List<Book> findByCategory(String category);
	void addBook(String title, String author, int pageNumber, String isbn, String category, String imageUrl, String publishingHouse,
			int issueYear, float price, boolean bestseller, String language, int copyNumber);
	
	void removeBook(int id);

}
