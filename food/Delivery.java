package food;
import objects.*;
import people.*;
import java.util.ArrayList;

public class Delivery extends Order{
	
	private Integer deliveryTime;
	private Integer deliveryFee;
	
	public Delivery() {
		
		deliveryTime = 0;
		deliveryFee = 0;
		
	}

	public Integer getDeliveryTime() {
		return deliveryTime;
	}
	
	public Integer getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryTime() {			//sets delivery wait time based on address location
		
		if(this.getAccount().getAddress() == "Tucson") {
			deliveryTime = 15;
		}
		if(this.getAccount().getAddress() == "Phoenix") {
			deliveryTime = 120;
		}
		if(this.getAccount().getAddress() == "Flagstaff") {
			deliveryTime = 30;
		}
		
	}

	public void setDeliveryFee() {			//sets delivery cost based on address location
		
		if(this.getAccount().getAddress() == "Tucson") {
			deliveryFee = 5;
		}
		if(this.getAccount().getAddress() == "Phoenix") {
			deliveryFee = 60;
		}
		if(this.getAccount().getAddress() == "Flagstaff") {
			deliveryFee = 15;
		}
		
	}
	
	public void calculateTotal() {				//finds order total based on item prices and delivery location
		int sum = 0;
		for(int i = 0; i < this.getItemsList().size(); i++) {
			sum = sum + this.getItemsList().get(i).getPrice();
		}
		this.total = sum + deliveryFee;
		
	}
	
	public void printOrder() {
		
		System.out.println("User " + this.getAccount().getUserName() + "'s Order: \n");
		System.out.println("Delivery:\t\tEstimated Time - " + this.getDeliveryTime() + "\n");
		for(int i = 0; i < this.getItemsList().size(); i++) {
			System.out.println("\t" + this.getItemsList().get(i).getName() + " - " + this.getItemsList().get(i).getPrice());
		}
		System.out.println("\nComment: " + this.getComment());
		System.out.println("\nDelivery Fee: " + deliveryFee + "\tTotal: " + this.getTotal() + "\n");
		
	}

}
