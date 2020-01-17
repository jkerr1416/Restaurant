package objects;
import food.*;
import people.*;
import java.util.ArrayList;

public class Reservation {
	
	private CustomerAccount account;		//all conflict testing for this object is done in customeraccount
	private Integer time;
	private Integer size;
	
	public Reservation() {
		time = -1;
		size = -1;
	}
	
	public Reservation(CustomerAccount aAccount, Integer aTime, Integer aSize) {
		account = aAccount;
		time = aTime;
		size = aSize;
	}

	public CustomerAccount getAccount() {
		return account;
	}

	public void setAccount(CustomerAccount account) {
		this.account = account;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	public void printReservation() {
		
		System.out.println("\n" + this.getAccount().getUserName() + ", Time Slot: " + time + ", Size: " + size + "\n");
		
	}

}
