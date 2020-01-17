package food;
import objects.*;
import people.*;
import java.util.ArrayList;

public class Item {
	
	private String name;
	private Integer price;
	private String description;
	private String type;
	
	public Item() {
		name = "undefined";
		price = -1;
		description = "undefined";
		type = "undefined";
	}
	
	public Item(String aName, Integer aPrice, String aDesc, String aType) {
		name = aName;
		price = aPrice;
		description = aDesc;
		type = aType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}
	

	public void setType(String x) {
		if((x.equals("beverage")) || (x.equals("appetizer")) || (x.equals("entree")) || (x.equals("dessert"))) {
			type = x;
		}
		else {
			System.out.println("Item type must be beverage, appetizer, entree, or dessert.");
		}
	}
	
	public void printItem() {
		
		//System.out.println("\t" + this.getMenu().beverages.get(i).getName() + " - " + this.getMenu().beverages.get(i).getPrice());
		//System.out.println("\t-" + this.getMenu().beverages.get(i).getDescription());
		System.out.println("\n" + this.getName() + " - " + this.getPrice());
		System.out.println(this.getDescription() + "\n");
	}

}
