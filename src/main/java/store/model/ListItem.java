package store.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import store.impl.ListItemImpl;

@Entity
public class ListItem extends ListItemImpl {
	
	@Id
	private int id;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Book item;
	
	private int quantity;
	
	
	public ListItem() {}

	public ListItem(Book item) {
		super();
		this.item = item;
		this.id = item.getId();
	}



	public Book getItem() {
		return item;
	}

	public void setItem(Book item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ListItem [id=" + id + ", item=" + item + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListItem other = (ListItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	

}
