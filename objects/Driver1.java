package objects;

import food.*;
import people.*;

public class Driver1 {
	
	public static void main(String[] args) {
		
		Restaurant r = new Restaurant();	//Initialize Restaurant and Menu
		r.setName("Mikuni");
		
		Menu m = new Menu();
		
		r.setMenu(m);
		
		
		Item i1 = new Item("California Roll", 10, "Roll with crab, avocado, and vegetables", "entree");	//Creating Items
		Item i2 = new Item("Teriyaki Chicken", 8, "Chicken in teriyaki sauce with rice", "entree");
		Item i3 = new Item("Kendall Jackson", 13, "Buttery Chardonnay", "beverage");
		Item i4 = new Item("Mochi", 5, "Sweet Dairy Dessert", "dessert");
		Item i5 = new Item("Barbeque Tuna", 7, "Spicy Tuna served with mayo sauce", "appetizer");
		Item i6 = new Item("Water", 0, "Water", "beverage");
		Item i7 = new Item("Rice Krispy Sushi", 9, "Dessert Sushi Roll", "dessert");
		
		
		DebitCard d1 = new DebitCard();	//Creating Debit Cards
		d1.setCardNumber(987654);
		d1.setPassword(275);
		d1.setBalance(100);
		
		DebitCard d2 = new DebitCard();
		d2.setCardNumber(123456);
		d2.setPassword(9843);
		d2.setBalance(200);
		
		DebitCard d3 = new DebitCard();
		d3.setCardNumber(123456);
		d3.setPassword(1111);
		d3.setBalance(200);
		
		
		EmployeeAccount e1 = new EmployeeAccount();	//Creating Accounts for Employees and Customers
		e1.setName("Mike");
		e1.setRestaurant(r);
		e1.setUserName("J424");
		e1.setPassword("724bghlp");
		
		EmployeeAccount e2 = new EmployeeAccount();
		e2.setName("Steven");
		e2.setRestaurant(r);
		e2.setUserName("pandaNinja");
		e2.setPassword("8bitRouter");
		
		
		CustomerAccount c1 = new CustomerAccount();
		c1.setName("Jack");
		c1.setRestaurant(r);
		c1.setUserName("jCoder");
		c1.setPassword("rams78904");
		c1.setAddress("Sacramento");	//Testing Address conflict
		c1.setAddress("Sabino Canyon");
		c1.setPhoneNumber(12345678);	//Testing Phone Number Conflict
		c1.setPhoneNumber(1234567);
		c1.setPaymentInfo(d1);
		
		CustomerAccount c2 = new CustomerAccount();
		c2.setName("Gopher");
		c2.setRestaurant(r);
		c2.setUserName("sadam6034");
		c2.setPassword("GiccuFlip9");
		c2.setAddress("Tucson");
		c2.setPhoneNumber(7174646);
		c2.setPaymentInfo(d2);
		
		CustomerAccount c3 = new CustomerAccount();
		c3.setName("Jazz");
		c3.setRestaurant(r);
		c3.setUserName("Krank Yanker");
		c3.setPassword("GiccuFlip9");
		c3.setAddress("Phoenix");
		c3.setPhoneNumber(2222222);
		c3.setPaymentInfo(d3);
		
		
		e1.addMenuItem(i1);			//Adding Items to Menu
		e1.addMenuItem(i2);
		e1.addMenuItem(i3);
		e1.addMenuItem(i4);
		e1.addMenuItem(i5);
		e1.addMenuItem(i6);			//negative price exception
		e1.addMenuItem(i7);
		
		e2.deleteMenuItem("Barbeque Tuna");		//Deleting item from menu
		
		
		e1.changePrice("Mochi", 3);	//Changing price
		
		
		c1.setOrderType("Delivery");		//Creating Orders and Reservations
		c1.addItemToOrder("California Roll");
		c1.addItemToOrder("Kendall Jackson");
		c1.addItemToOrder("Mochi");
		c1.addItemToOrder("Beer");
		c1.addCommentToOrder("Double cut the California Roll");
		c1.finalizeOrder(275);
		
		c2.setReservation(5, 6);
		c2.setReservation(1, 1);			//Testing Reservation conflict
		c2.setOrderType("Dine In");
		c2.addItemToOrder("Water");
		c2.addItemToOrder("Rice Krispy Sushi");
		c2.addItemToOrder("Barbeque Tuna");		//Testing addItem conflict
		c2.addItemToOrder("California Roll");
		c2.addItemToOrder("Mochi");
		c2.removeItemFromOrder("Mochi");
		c2.addCommentToOrder("Dehydrate that water");
		c2.finalizeOrder(9843);
		
		c3.setReservation(5, 3);			//Testing Reservation space conflict
		c3.setOrderType("Pickup");
		c3.addItemToOrder("Water");
		c3.addItemToOrder("Mochi");
		c3.addCommentToOrder("None");
		c3.logOut();						//Testing logout function
		c3.finalizeOrder(1111);				//testing finalize order conflict
		c3.logIn("Krank Yanker", "Michaek90");
		c3.logIn("Krank Yanker", "GiccuFlip9");//Testing login function
		c3.finalizeOrder(1111);					//retrying finalize order
		
		c1.cancelOrder();			//testing cancel order function
		
		
		r.printCustomerList();//printing restaurant lists
		r.printEmployeeList();
		r.printMenu();
		r.printOrders();
		r.printReservations();
		
		e1.closeOrder(c1);	//closing all orders and reservations
		e1.closeOrder(c2);
		e2.closeOrder(c3);
		e1.closeReservation(c2);
		
		r.printSales();
		System.out.println("\nUser " + c1.getUserName() + "balance: "+ c1.getPaymentInfo().getBalance()); //testing payment 
		
		
		
	}

}
