package people;
import objects.*;
import food.*;
import java.util.ArrayList;

public class EmployeeAccount extends Account{
	
	public void closeOrder(CustomerAccount aCust){	//closes the customers order and adds its total to the restaurants daily sales value
		
		if(loginStatus == 0) {
			System.out.println("User " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		
		for(int i = 0; i < this.getRestaurant().getOrders().size(); i++) {
			if(this.getRestaurant().getOrders().get(i).getAccount() == aCust) {
				this.getRestaurant().addSale(this.getRestaurant().getOrders().get(i));
				this.getRestaurant().getOrders().get(i).getAccount().getPaymentInfo().setBalance(this.getRestaurant().getOrders().get(i).getAccount().getPaymentInfo().getBalance()-this.getRestaurant().getOrders().get(i).getTotal());
				this.getRestaurant().getOrders().get(i).getAccount().cancelOrder();
				return;
			}
		}
		System.out.println(aCust.getUserName() + " doesn't have an active order to remove");
		
	}
	
	public void closeReservation(CustomerAccount aCust) {
		
		if(loginStatus == 0) {
			System.out.println("User " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		
		for(int i = 0; i < this.getRestaurant().getReservations().size(); i++) {
			if(this.getRestaurant().getReservations().get(i).getAccount() == aCust) {
				this.getRestaurant().getReservations().get(i).getAccount().cancelReservation();
				return;
			}
		}
		System.out.println(aCust.getUserName() + " doesn't have an active reservation to remove");
		
	}
	
	public void deleteMenuItem(String x) {
		
		if(loginStatus == 0) {
			System.out.println("User " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().beverages.size(); i++) {		//these loops check for the item
			if(this.getRestaurant().getMenu().beverages.get(i).getName() == x) {
				this.getRestaurant().getMenu().beverages.remove(i);
				return;
			}
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().appetizers.size(); i++) {
			if(this.getRestaurant().getMenu().appetizers.get(i).getName() == x) {
				this.getRestaurant().getMenu().appetizers.remove(i);
				return;
			}
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().entrees.size(); i++) {
			if(this.getRestaurant().getMenu().entrees.get(i).getName() == x) {
				this.getRestaurant().getMenu().entrees.remove(i);
				return;
			}
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().desserts.size(); i++) {
			if(this.getRestaurant().getMenu().desserts.get(i).getName() == x) {
				this.getRestaurant().getMenu().desserts.remove(i);
				return;
			}
		}
		
		System.out.println("Item " + x + " isn't on the menu");
		
	}
	
	public void addMenuItem(Item x) {			//checks to see if menu already has this item
		
		if(x.getPrice().intValue() < 1) {
			System.out.println("\nItem price must be positive");
			return;
		}
		
		if(loginStatus == 0) {
			System.out.println("User " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		
		if((x.getDescription() == "undefined") || (x.getName() == "undefined") || (x.getPrice() == -1) || (x.getType() == "undefined")) {//checks if x is a valid item
			System.out.println("Item cannot be added to menu as it is not fully developed.");
			return;
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().beverages.size(); i++) {
			if(this.getRestaurant().getMenu().beverages.get(i).getName() == x.getName()) {
				System.out.println("There is already an item on the menu with the name " + x.getName() + ".");
				return;
			}
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().appetizers.size(); i++) {
			if(this.getRestaurant().getMenu().appetizers.get(i).getName() == x.getName()) {
				System.out.println("There is already an item on the menu with the name " + x.getName() + ".");
				return;
			}
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().entrees.size(); i++) {
			if(this.getRestaurant().getMenu().entrees.get(i).getName() == x.getName()) {
				System.out.println("There is already an item on the menu with the name " + x.getName() + ".");
				return;
			}
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().desserts.size(); i++) {
			if(this.getRestaurant().getMenu().desserts.get(i).getName() == x.getName()) {
				System.out.println("There is already an item on the menu with the name " + x.getName() + ".");
				return;
			}
		}
		
		if(x.getType() == "beverage") {
			this.getRestaurant().getMenu().beverages.add(x);
		}
		
		if(x.getType() == "appetizer") {
			this.getRestaurant().getMenu().appetizers.add(x);
		}
		
		if(x.getType() == "entree") {
			this.getRestaurant().getMenu().entrees.add(x);
		}
		
		if(x.getType() == "dessert") {
			this.getRestaurant().getMenu().desserts.add(x);
		}
		
	}
	
	public void changePrice(String name, Integer price) { //checks if name belings to item on menu and changes price if price is positive
		
		if(price < 1) {
			System.out.println("\nPrice must be a postive number");
			return;
		}
		
		if(loginStatus == 0) {
			System.out.println("User " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().beverages.size(); i++) {
			if(this.getRestaurant().getMenu().beverages.get(i).getName() == name) {
				this.getRestaurant().getMenu().beverages.get(i).setPrice(price);
				return;
			}
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().appetizers.size(); i++) {
			if(this.getRestaurant().getMenu().appetizers.get(i).getName() == name) {
				this.getRestaurant().getMenu().appetizers.get(i).setPrice(price);
				return;
			}
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().entrees.size(); i++) {
			if(this.getRestaurant().getMenu().entrees.get(i).getName() == name) {
				this.getRestaurant().getMenu().entrees.get(i).setPrice(price);
				return;
			}
		}
		
		for(int i = 0; i < this.getRestaurant().getMenu().desserts.size(); i++) {
			if(this.getRestaurant().getMenu().desserts.get(i).getName() == name) {
				this.getRestaurant().getMenu().desserts.get(i).setPrice(price);
				return;
			}
		}
		
		System.out.println("There is no " + name + " on the menu.");
		
	}
	
	public void setUserName(String x) {
		
		if(this.getRestaurant().getName() == "undefined") {
			System.out.println("User must set a restaurant before creating a userName");
			return;
		}
		
		if(loginStatus == 0) {
			System.out.println("User " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		if(this.getRestaurant().getEmployees().isEmpty() == false) {
			for(int i = 0; i < this.getRestaurant().getEmployees().size(); i++) {
				if(this.getRestaurant().getEmployees().get(i).getUserName() == x) {
					System.out.println("Employee username " + x + " is already taken.");
					return;
				}
			}
		}
		userName = x;
		//this.getRestaurant().addEmployee(this);
		
	}

}
