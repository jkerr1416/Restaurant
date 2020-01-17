package people;
import objects.*;
import food.*;
import java.util.ArrayList;

public class CustomerAccount extends Account {	//checks that person is logged in before taking any action

	private Integer phoneNumber;
	private String address;
	private DebitCard paymentInfo;
	private ArrayList<Order> currentOrder;
	private Reservation reservation;
	private String orderType;
	
	public CustomerAccount() {
		PickUp x = new PickUp();
		phoneNumber = 0;
		address = "undefined";
		paymentInfo = new DebitCard();
		reservation = new Reservation();
		currentOrder = new ArrayList<Order>();
		currentOrder.add(x);
		orderType = "undefined";
	}
	
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(Integer phoneNumber) {			//checks that phone number entered is 7 digits
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		if((phoneNumber > 9999999) || (phoneNumber < 1000000)) {
			if(userName == "undefined") {
				System.out.println("\nPhone Number must be 7 digits long and not start with a 0");
			}
			else {
			System.out.println("\n" + userName + "'s Phone Number must be 7 digits long and not start with a 0");
			}
			return;
		}
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String x) {					//Deliveries are only done to phoenix, tucson, and specificly sabino canyon area
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		if((!x.equals("Tucson")) && (!x.equals("Phoenix")) && (!x.equals("Flagstaff"))) {
			System.out.println("\nAccepted addresses are: Tucson, Phoenix, and Flagstaff.");
			return;
		}
		else {
			address = x;
		}
	}
	
	public DebitCard getPaymentInfo() {
		return paymentInfo;
	}
	
	public void setPaymentInfo(DebitCard paymentInfo) {
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		this.paymentInfo = paymentInfo;
	}
	
	public Order getCurrentOrder() {
		return currentOrder.get(0);
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	
	public void setReservation(Integer time, Integer size) {
		
		
		
		if(this.getReservation().getSize() != -1) {		//checks to see if customer already has a reservation
			System.out.println("\nUser " + this.getUserName() + " already has a reservation today. Cancel that to place a new one.");
			return;
		}
		
		int space = 0;
		for(int i = 0; i < restaurant.getReservations().size(); i++) {
			if(restaurant.getReservations().get(i).getTime().equals(time)) {
				space = space + restaurant.getReservations().get(i).getSize();
			}
		}
		if((8-space) < size) {					//checks to see if there is enough space available
			System.out.println("\nThere is not enough space available during time slot " + time + ".");
			return;
		}
		if((time < 1) || (time > 7)) {				//checks to see if they want a valid time slot
			System.out.println("\nTime Slots are 1-7 corresponding to each 30 minute time slot between 5 and 9 p.m.");
			return;
		}
		reservation.setAccount(this);
		reservation.setSize(size);
		reservation.setTime(time);
		this.getRestaurant().addReservation(reservation);
		
	}
	
	public void cancelOrder() {				//removes any active order a user has
		
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		if(this.getRestaurant().getReservations().size() > 0) {
			if(reservation.getSize().equals(-1)) {
				
			}
			else {
				if(this.getRestaurant().getReservations().contains(this.getReservation())) {
					this.getRestaurant().getReservations().remove(reservation);
					reservation = new Reservation();
				}
			}
		}
		if(this.getRestaurant().getOrders().contains(this.getCurrentOrder())) {
			this.getRestaurant().getOrders().remove(this.getCurrentOrder());
			currentOrder.clear();
			orderType = "undefined";
			System.out.println("\n" + this.getUserName() + "'s Order has been removed.");
		}
		else {
			System.out.println("\n" + this.getUserName() + " has no active orders.");
		}
		
	}
	
	public void setOrderType(String x) {	//creates an order for customer if they entered a valid order type and dont have an active order
		
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		if(this.getRestaurant().getOrders().isEmpty() == false) {
		if(this.getRestaurant().getOrders().contains(this.getCurrentOrder())) {
			System.out.println("\nUser " + this.getUserName() + "has already placed an order. Cancel that order to start a new one.");
			return;
		}
		}
		if((!x.equals("Dine In")) && (!x.equals("Pickup")) && (!x.equals("Delivery"))) {
			System.out.println("\nOrder types are \"Dine In\", \"Pickup\", or \"Delivery\".");
			return;
		}
		if((x == "Dine In") && (this.getReservation().getSize() == -1)) {					//checks that user has all required info
			System.out.println("A reservation must be set before starting a dine in order");
			return;
		}
		if((x == "Delivery") && (this.getAddress() == "undefined")) {
			System.out.println("An address must be set before starting a delivery order");
			return;
		}
		this.orderType = x;
		currentOrder.clear();
		System.out.println("\n" + this.getUserName() + "'s order type set to " + x + ". Any previous unfinalized order has been cleared.");
		if(x.equals("Dine In")) {			//initializing orders
		DineIn y = new DineIn();
		y.setAccount(this);
		y.setReservation(this.getReservation());
		y.setServiceFee();
		currentOrder.add(y);
		}
		else if(x.equals("Pickup")) {
			PickUp y = new PickUp();
			y.setAccount(this);
			currentOrder.add(y);
		}
		else {
			Delivery y = new Delivery();
			y.setAccount(this);
			y.setDeliveryFee();
			y.setDeliveryTime();
			currentOrder.add(y);
		}
	}
	
	public String getOrderType() {
		return orderType;
	}
	
	public void addItemToOrder(String x) {
		
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		
		if(this.getOrderType() == "undefined") {
			System.out.println("\nUser " + this.getUserName() + " must declare an order type before adding item to order."); //checks that user has an order to add item to
			return;
		}
		if(this.getRestaurant().getOrders().contains(this.getCurrentOrder())) {
			System.out.println("\nUser " + this.getUserName() + "has already placed an order. Cancel that order to start a new one."); //checks for actuve order
			return;
		}
		else {
			
			for(int i = 0; i < this.getRestaurant().getMenu().beverages.size(); i++) {	//these loops check for item in menu
				if(this.getRestaurant().getMenu().beverages.get(i).getName() == x) {
					currentOrder.get(0).addItem(this.getRestaurant().getMenu().beverages.get(i));
					this.getCurrentOrder().calculateTotal();
					return;
				}
			}
			
			for(int i = 0; i < this.getRestaurant().getMenu().appetizers.size(); i++) {
				if(this.getRestaurant().getMenu().appetizers.get(i).getName() == x) {
					currentOrder.get(0).addItem(this.getRestaurant().getMenu().appetizers.get(i));
					this.getCurrentOrder().calculateTotal();
					return;
				}
			}
			
			for(int i = 0; i < this.getRestaurant().getMenu().entrees.size(); i++) {
				if(this.getRestaurant().getMenu().entrees.get(i).getName() == x) {
					currentOrder.get(0).addItem(this.getRestaurant().getMenu().entrees.get(i));
					this.getCurrentOrder().calculateTotal();
					return;
				}
			}
			
			for(int i = 0; i < this.getRestaurant().getMenu().desserts.size(); i++) {
				if(this.getRestaurant().getMenu().desserts.get(i).getName() == x) {
					currentOrder.get(0).addItem(this.getRestaurant().getMenu().desserts.get(i));
					this.getCurrentOrder().calculateTotal();
					return;
				}
			}
			System.out.println("\nItem " + x + " isn't on the menu.");
		}
		
	}
	
	public void removeItemFromOrder(String x) {//checks for active order and checks if item is in cart
		
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		
		if(currentOrder.isEmpty() == true) {
			System.out.println("\nUser " + this.getUserName() + " must declare an order type before removing item from order.");
			return;
		}
		if(this.getRestaurant().getOrders().contains(this.getCurrentOrder())) {
			System.out.println("\nUser " + this.getUserName() + "has already placed an order. Cancel that order to start a new one.");
			return;
		}
		else {
			for(int i = 0; i < this.getCurrentOrder().getItemsList().size(); i++) {
				if(this.getCurrentOrder().getItemsList().get(i).getName() == x) {
					this.getCurrentOrder().getItemsList().remove(i);
					this.getCurrentOrder().calculateTotal();
					return;
				}
			}
			System.out.println("\nItem " + x + " is not part of " + this.getUserName() + "'s order.");
		}
		
	}
	
	public void addCommentToOrder(String x) {
		
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		
		if(currentOrder.isEmpty() == true) {
			System.out.println("\nUser " + this.getUserName() + " must declare an order type before adding a comment to the order.");
			return;
		}
		if(this.getRestaurant().getOrders().contains(this.getCurrentOrder())) {
			System.out.println("\nUser " + this.getUserName() + "has already placed an order. Cancel that order to start a new one.");
			return;
		}
		else {
			this.getCurrentOrder().setComment(x);
		}
		
	}
	
	public void finalizeOrder(Integer x) {	//checks to see if user has a valid order and finalizes if user entered correct debit password
		
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		
		if(this.getUserName() == "undefined") {
			System.out.println("\nA username must be set before placing an order.");
			return;
		}
		
		if(this.getRestaurant().getOrders().isEmpty() == false) {
		if(this.getRestaurant().getOrders().contains(this.getCurrentOrder())) {
			System.out.println("\nUser " + this.getUserName() + "has already placed an order.");
			return;
		}
		}
		
		if(this.getOrderType() == "undefined") {
			System.out.println("\nUser " + this.getUserName() + " must declare an order type and add items before finalizing an order");
			return;
		}
		
		if(this.getCurrentOrder().getItemsList().isEmpty() == true) {
			System.out.println("\nUser " + this.getUserName() + " must select items before finalizing an order.");
			return;
		}
		
		if(this.getOrderType() == "Dine In") {
			if(this.getReservation().getSize() == -1) {
				System.out.println("\nUser " + this.getUserName() + " must set a reservation before finalizing a Dine In order.");
				return;
			}
		}
		
		if(this.getPhoneNumber() == 0) {
			System.out.println("\nUser " + this.getUserName() + " must set a phone number before placing an order.");
			return;
		}
		
		if((this.getAddress() == "undefined") && (this.getOrderType() == "Delivery")) {
			System.out.println("\nUser " + this.getUserName() + " must set a valid address before placing an order");
			return;
		}
		
		if(this.getPaymentInfo().getCardNumber() == -1) {
			System.out.println("\nUser " + this.getUserName() + " has not updated payment information.");
			return;
		}
		
		if(x.intValue() != this.getPaymentInfo().getPassword().intValue()) {
			System.out.println("\nUser " + this.getUserName() + " entered incorrect payment password.");
			return;
		}
		
		if(this.getPaymentInfo().getBalance() < this.getCurrentOrder().getTotal()) {
			System.out.println("\nUser " + this.getUserName() + " doesn't have enough funds to place the order.");
			return;
		}
		this.getCurrentOrder().calculateTotal();
		this.getRestaurant().addOrder(this.getCurrentOrder());
		
	}
	
	public void printOrder() {
		
		if(this.getOrderType() == "undefined") {
			System.out.println("\nUser " + this.getUserName() + " has no ongoing order to print.");
			return;
		}
		else {
			this.getCurrentOrder().printOrder();
		}
		
	}
	
	public void cancelReservation() {
		
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		
		if(this.getRestaurant().getReservations().contains(this.getReservation())) {
			this.getRestaurant().getReservations().remove(this.getReservation());
			reservation.setSize(-1);
			reservation.setTime(-1);
			System.out.println("\n" + this.getUserName() + "'s Reservation has been removed.");
		}
		else {
			System.out.println("\n" + this.getUserName() + " has no active Reservations.");
		}
		
	}
	
	public void setUserName(String x) {
		
		if(this.getRestaurant().getName() == "undefined") {
			System.out.println("\nUser must set a restaurant before creating a userName");
			return;
		}
		
		if(loginStatus == 0) {
			System.out.println("\nUser " + this.getUserName() + " must be logged in to take action.");
			return;
		}
		if(this.getRestaurant().getCustomers().isEmpty() == false) {
			for(int i = 0; i < this.getRestaurant().getCustomers().size(); i++) {
				if(this.getRestaurant().getCustomers().get(i).getUserName() == x) {
					System.out.println("\nCustomer username " + x + " is already taken.");
					return;
				}
			}
		}
		userName = x;
		//this.getRestaurant().addCustomer(this);
	}
	
	
}
