package objects;

public class DebitCard {
	
	private Integer cardNumber;
	private Integer password;
	private Integer balance;
	
	public DebitCard() {
		cardNumber = -1;
		password = -1;
		balance = -1;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		if((cardNumber < 100000) || (cardNumber > 999999)) {		//card number must be six digits
			System.out.println("Debit Card Number must be 6 digits");
			return;
		}
		this.cardNumber = cardNumber;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {					//password must be less than 10 digits
		if(password > 999999999) {
			System.out.println("Password must be less than 10 digits");
			return;
		}
		this.password = password;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

}
