package store.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
	
	public static EntityManagerFactory emf;
	

	
	public static void closeEMF() {
		
		Factory.emf.close();
		
	}
	
	public Factory() {}
	
	public static void createEMF() {
		
		Factory.emf = Persistence.createEntityManagerFactory("bookstore");
		
	}

}
