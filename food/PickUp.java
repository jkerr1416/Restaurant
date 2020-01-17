package food;
import objects.*;
import people.*;
import java.util.ArrayList;

public class PickUp extends Order{

	public PickUp() {
		
	}
	
	public void calculateTotal() {				//total only based on items price
		
		int sum = 0;
		for(int i = 0; i < this.getItemsList().size(); i++) {
			sum = sum + this.getItemsList().get(i).getPrice();
		}
		this.total = sum;
		
	}
	
	public void printOrder() {
		
		System.out.println("User " + this.getAccount().getUserName() + "'s Order: \n");
		System.out.println("PickUp:\n");
		for(int i = 0; i < this.getItemsList().size(); i++) {
			System.out.println("\t" + this.getItemsList().get(i).getName() + " - " + this.getItemsList().get(i).getPrice());
		}
		System.out.println("\nComment: " + this.getComment());
		System.out.println("\nTotal: " + this.getTotal() + "\n");
		
	}
}
