package objects;
import food.*;
import people.*;
import java.util.ArrayList;

public class Restaurant {
	
	private String name;
	private Menu menu;
	private ArrayList<EmployeeAccount> employees;
	private ArrayList<CustomerAccount> customers;
	private ArrayList<Order> orders;
	private ArrayList<Reservation> reservations;
	private Integer sales;
	
	public Restaurant() {
		name = "undefined";
		menu = new Menu();
		employees = new ArrayList<EmployeeAccount>();
		customers = new ArrayList<CustomerAccount>();
		orders = new ArrayList<Order>();
		reservations = new ArrayList<Reservation>();
		sales = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menu getMenu() {
		return menu;
	}
	
	public void setMenu(Menu m) {
		menu = m;
	}

	public ArrayList<EmployeeAccount> getEmployees() {
		return employees;
	}
	
	public ArrayList<CustomerAccount> getCustomers(){
		return customers;
	}

	public void addEmployee(EmployeeAccount x) {
		employees.add(x);
	}
	
	public void addCustomer(CustomerAccount x) {
		customers.add(x);
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public void addOrder(Order x) {
		orders.add(x);
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void addReservation(Reservation x) {
		reservations.add(x);
	}

	public Integer getSales() {
		return sales;
	}

	public void addSale(Order x) {			//sales are added when an employee closes a customers order
		
		sales = sales + x.getTotal();
	}
	
	public void printCustomerList() {
		
		System.out.println("\n" + name + "'s customer list:\n");
		for(int i = 0; i < this.getCustomers().size(); i++) {
			System.out.println("\t" + this.getCustomers().get(i).getUserName() + " - " + this.getCustomers().get(i).getName());
		}
		
	}
	
	public void printEmployeeList() {
		
		System.out.println("\n" + name + "'s employee list:\n");
		for(int i = 0; i < this.getEmployees().size(); i++) {
			System.out.println("\t" + this.getEmployees().get(i).getUserName() + " - " + this.getEmployees().get(i).getName());
		}
		
	}
	
	public void printMenu() {		//menu prints all items grouped by their category
		
		System.out.println("\n" + name + "'s Menu:");
		System.out.println("Beverages:");
		for(int i = 0; i < this.getMenu().beverages.size(); i++) {
			System.out.println("\n\t" + this.getMenu().beverages.get(i).getName() + " - " + this.getMenu().beverages.get(i).getPrice());
			System.out.println("\t-" + this.getMenu().beverages.get(i).getDescription());
		}
		System.out.println("\nAppetizers:");
		for(int i = 0; i < this.getMenu().appetizers.size(); i++) {
			System.out.println("\n\t" + this.getMenu().appetizers.get(i).getName() + " - " + this.getMenu().appetizers.get(i).getPrice());
			System.out.println("\t-" + this.getMenu().appetizers.get(i).getDescription());
		}
		System.out.println("\nEntrees:");
		for(int i = 0; i < this.getMenu().entrees.size(); i++) {
			System.out.println("\n\t" + this.getMenu().entrees.get(i).getName() + " - " + this.getMenu().entrees.get(i).getPrice());
			System.out.println("\t-" + this.getMenu().entrees.get(i).getDescription());
		}
		System.out.println("\nDesserts:");
		for(int i = 0; i < this.getMenu().desserts.size(); i++) {
			System.out.println("\n\t" + this.getMenu().desserts.get(i).getName() + " - " + this.getMenu().desserts.get(i).getPrice());
			System.out.println("\t-" + this.getMenu().desserts.get(i).getDescription());
		}
		System.out.println("\n");
		
	}
	
	public void printReservations() {
		
		System.out.println("\n" + name + "'s Reservations:\n");
		for(int i = 0; i < this.getReservations().size(); i++) {
			this.getReservations().get(i).printReservation();
		}
		System.out.println("\n");
	}
	
	public void printOrders() {
		
		System.out.println("\n" + name + "'s Orders:\n");
		for(int i = 0; i < this.getOrders().size(); i++) {
			System.out.println("\n");
			this.getOrders().get(i).printOrder();
		}
		System.out.println("\n");
	}
	
	public void printSales() {
		System.out.println("\nToday's Sales:\t$" + this.getSales());
	}
	
	public void changePrice(String name, Integer price) { //checks if name belings to item on menu and changes price if price is positive
		
		if(price < 1) {
			System.out.println("\nPrice must be a postive number");
			return;
		}
		
		for(int i = 0; i < getMenu().beverages.size(); i++) {
			if(getMenu().beverages.get(i).getName().equals(name)) {
				getMenu().beverages.get(i).setPrice(price);
				return;
			}
		}
		
		for(int i = 0; i < getMenu().appetizers.size(); i++) {
			if(getMenu().appetizers.get(i).getName().equals(name)) {
				getMenu().appetizers.get(i).setPrice(price);
				return;
			}
		}
		
		for(int i = 0; i < getMenu().entrees.size(); i++) {
			if(getMenu().entrees.get(i).getName().equals(name)) {
				getMenu().entrees.get(i).setPrice(price);
				return;
			}
		}
		
		for(int i = 0; i < getMenu().desserts.size(); i++) {
			if(getMenu().desserts.get(i).getName().equals(name)) {
				getMenu().desserts.get(i).setPrice(price);
				return;
			}
		}
		
		System.out.println("There is no " + name + " on the menu.");
		
	}
	
	public void addMenuItem(Item x) {			//checks to see if menu already has this item
		
		if(x.getPrice().intValue() < 1) {
			System.out.println("\nItem price must be positive");
			return;
		}
	
		
		if((x.getDescription() == "undefined") || (x.getName() == "undefined") || (x.getPrice() == -1) || (x.getType() == "undefined")) {//checks if x is a valid item
			System.out.println("Item cannot be added to menu as it is not fully developed.");
			return;
		}
		
		for(int i = 0; i < getMenu().beverages.size(); i++) {
			if(getMenu().beverages.get(i).getName().equals(x.getName())) {
				System.out.println("There is already an item on the menu with the name " + x.getName() + ".");
				return;
			}
		}
		
		for(int i = 0; i < getMenu().appetizers.size(); i++) {
			if(getMenu().appetizers.get(i).getName().equals(x.getName())) {
				System.out.println("There is already an item on the menu with the name " + x.getName() + ".");
				return;
			}
		}
		
		for(int i = 0; i < getMenu().entrees.size(); i++) {
			if(getMenu().entrees.get(i).getName().equals(x.getName())) {
				System.out.println("There is already an item on the menu with the name " + x.getName() + ".");
				return;
			}
		}
		
		for(int i = 0; i < getMenu().desserts.size(); i++) {
			if(getMenu().desserts.get(i).getName().equals(x.getName())) {
				System.out.println("There is already an item on the menu with the name " + x.getName() + ".");
				return;
			}
		}
		
		if(x.getType().equals("beverage")) {
			getMenu().beverages.add(x);
		}
		
		if(x.getType().equals("appetizer")) {
			getMenu().appetizers.add(x);
		}
		
		if(x.getType().equals("entree")) {
			getMenu().entrees.add(x);
		}
		
		if(x.getType().equals("dessert")) {
			getMenu().desserts.add(x);
		}
		
	}
	
public void deleteMenuItem(String x) {
		
		
		for(int i = 0; i < getMenu().beverages.size(); i++) {		//these loops check for the item
			if(getMenu().beverages.get(i).getName().equals(x)) {
				getMenu().beverages.remove(i);
				return;
			}
		}
		
		for(int i = 0; i < getMenu().appetizers.size(); i++) {
			if(getMenu().appetizers.get(i).getName().equals(x)) {
				getMenu().appetizers.remove(i);
				return;
			}
		}
		
		for(int i = 0; i < getMenu().entrees.size(); i++) {
			if(getMenu().entrees.get(i).getName().equals(x)) {
				getMenu().entrees.remove(i);
				return;
			}
		}
		
		for(int i = 0; i < getMenu().desserts.size(); i++) {
			if(getMenu().desserts.get(i).getName().equals(x)) {
				getMenu().desserts.remove(i);
				return;
			}
		}
		
		System.out.println("Item " + x + " isn't on the menu");
		
	}
	
public void closeOrder(Integer x){	//closes the customers order and adds its total to the restaurants daily sales value
	
	
	
			addSale(getOrders().get((x-1)));
			getOrders().get((x-1)).getAccount().getPaymentInfo().setBalance(getOrders().get((x-1)).getAccount().getPaymentInfo().getBalance()-getOrders().get((x-1)).getTotal());
			getOrders().get((x-1)).getAccount().cancelOrder();
			return;
			
	
}

public void closeReservation(Integer x) {
	
			getReservations().get((x-1)).getAccount().cancelReservation();
			return;

	
}
	

}
