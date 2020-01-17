package food;
import objects.*;
import people.*;
import java.util.ArrayList;

public class DineIn extends Order{
	
	private Reservation reservation;
	private Integer serviceFee;
	
	public DineIn() {
		
		reservation = new Reservation();
		serviceFee = 0;
		
	}
	
	public Integer getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee() {					//service fee is based on reservation time and size
		
		int multiplier = 1;
		if(this.getReservation().getTime() > 4) {
			multiplier = 2;
		}
		serviceFee = this.getReservation().getSize() * multiplier;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public void calculateTotal() {							//total based on service fee and item prices
		
		int sum = 0;
		for(int i = 0; i < this.getItemsList().size(); i++) {
			sum = sum + this.getItemsList().get(i).getPrice();
		}
		this.total = sum + serviceFee;
		
	}
	
	public void printOrder() {
		
		System.out.println("User " + this.getAccount().getUserName() + "'s Order: \n");
		System.out.println("Dine In:\n");
		System.out.println("Reservation- Time Slot: " + this.getReservation().getTime() + ", Size: " + this.getReservation().getSize() + "\n");
		for(int i = 0; i < this.getItemsList().size(); i++) {
			System.out.println("\t" + this.getItemsList().get(i).getName() + " - " + this.getItemsList().get(i).getPrice());
		}
		System.out.println("\nComment: " + this.getComment());
		System.out.println("\nService Fee: " + serviceFee + "\tTotal: " + this.getTotal() + "\n");
		
	}

}
