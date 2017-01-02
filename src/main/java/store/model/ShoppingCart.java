package store.model;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
	
	private List<ListItem> itemList;
	private int itemQuantity;
	
	public ShoppingCart() {
		
		this.itemList = new ArrayList<>();
		this.itemQuantity = 0;
	}


	public List<ListItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<ListItem> itemList) {
		this.itemList = itemList;
		this.itemQuantity = this.itemList.size();
	}


	public int getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	



	
	

}
