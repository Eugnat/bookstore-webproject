package store.dao;

import java.util.List;

import store.model.ListItem;

public interface ListItemDAO {
	
	List<ListItem> findAll();
	
	void addListItem(int id);
	
	void addListItem(int id, int quantity);
	
	void removeListItem(int id);
	
	void updateListItem(int id, int quantity);
	

}
