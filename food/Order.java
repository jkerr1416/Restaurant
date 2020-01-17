package food;
import objects.*;
import people.*;
import java.util.ArrayList;

public abstract class Order {
	
	protected Integer total;
	protected CustomerAccount account;
	protected ArrayList<Item> items;
	protected String comment;
	
	public Order() {
		
		total = 0;
		items = new ArrayList<Item>();
		comment = "undefined";
	}

	public Integer getTotal() {
		return total;
	}

	public CustomerAccount getAccount() {
		return account;
	}

	public void setAccount(CustomerAccount account) {
		this.account = account;
	}

	public ArrayList<Item> getItemsList() {
		return items;
	}

	public void addItem(Item x) {
		
		this.items.add(x);
		this.calculateTotal();
		
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public abstract void printOrder();
	public abstract void calculateTotal();
	
}
