package people;
import objects.*;
import food.*;
import java.util.ArrayList;

public abstract class Account {
	
	protected String name;
	protected String userName;
	protected String password;
	protected Restaurant restaurant;
	protected Integer loginStatus;
	
	public Account() {
		
		loginStatus = 1;
		name = "undefined";
		userName = "undefined";
		password = "undefined";
		restaurant = new Restaurant();
		
	}
	
	public void logIn(String y, String x) {			//login checks that the person enters the correct userName and password
		if((x == this.getPassword()) && (y == this.getUserName())){
			loginStatus = 1;
		}
		else {
			System.out.println("Person " + this.getName() + " password or UserName incorrect.");
		}
	}
	
	public void logOut() {						//logout checks that the person has established a valid username and password before logging out
		if((this.getPassword() == "undefined") || (this.getUserName() == "undefined")) {
			System.out.println("Person " + this.getUserName() + " must set a password and userName before logging out.");
		}
		else {
			loginStatus = 0;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String x) {						//checks that password is between 8 and 12 characters long
		if((x.length() < 8) || (x.length() > 12)){
			if(userName == "undefined") {
			System.out.println("Error: User's password must be between 8 and 12 characters long");
			}
			else {
				System.out.println("Error: " + userName + "'s password must be between 8 and 12 characters long");
			}
			return;
		}
		password = x;
	}
	
	public abstract void setUserName(String x) ;

}
