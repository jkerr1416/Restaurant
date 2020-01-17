package objects;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import food.*;
import people.*;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RestaurantGUI{

	private JFrame mainFrame;
	private Restaurant r;
	private JButton customerButton;
	private JButton employeeButton;
	private JButton employeeLoginButton;
	private JButton employeeRegButton;
	private JButton customerLoginButton;
	private JButton customerRegButton;
	private JFrame x;
	private JFrame z;
	private JButton employeeOptionChange;
	private JButton employeeOptionAdd;
	private JButton employeeOptionDelete;
	private JButton employeeOptionCloseOrder;
	private JButton employeeOptionCloseRes;
	private JButton employeeBack;
	private JFrame employeeOptionFrame;
	
	private JButton customerOptionRes;
	private JButton customerOptionStartOrder;
	private JButton customerOptionCancelRes;
	private JButton customerOptionCancelOrder;
	private JButton customerBack;
	private JFrame customerOptionFrame;
	private JButton empPrint;
	private JButton custPrint;
	private JFrame xy;
	private JFrame yz;
	
	private int currentCust = 0;
	
	private JFrame w;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		RestaurantGUI gui = new RestaurantGUI();
		gui.mainFrame.setVisible(true);
		
	}

	/**
	 * Create the application.
	 */
	public RestaurantGUI() {
		r = new Restaurant();	//Initialize Restaurant and Menu
		r.setName("Mikuni");
		Menu m = new Menu();
		r.setMenu(m);
		
		Item i1 = new Item("California Roll", 10, "Roll with crab, avocado, and vegetables", "entree");	//Creating Items
		Item i2 = new Item("Teriyaki Chicken", 8, "Chicken in teriyaki sauce with rice", "entree");
		Item i3 = new Item("Kendall Jackson", 13, "Buttery Chardonnay", "beverage");
		Item i4 = new Item("Mochi", 5, "Sweet Dairy Dessert", "dessert");
		Item i5 = new Item("Barbeque Tuna", 7, "Spicy Tuna served with mayo sauce", "appetizer");
		Item i6 = new Item("Water", 1, "Water", "beverage");
		Item i7 = new Item("Rice Krispy Sushi", 9, "Dessert Sushi Roll", "dessert");
		Item i8 = new Item("Coca Cola", 3, "Wet", "beverage");
		Item i9 = new Item("Sprite", 3, "Like 7 UP", "beverage");
		Item i10 = new Item("Cake", 9, "Chocolate", "dessert");
		Item i11 = new Item("Salad", 6, "Basic Caesar salad", "appetizer");
		
		EmployeeAccount e1 = new EmployeeAccount();	//Creating Accounts for Employees and Customers
		e1.setName("Mike");
		e1.setRestaurant(r);
		e1.setUserName("employee1");
		e1.setPassword("11111111");
		r.addEmployee(e1);
		
		e1.addMenuItem(i1);
		e1.addMenuItem(i2);
		e1.addMenuItem(i3);
		e1.addMenuItem(i4);
		e1.addMenuItem(i5);
		e1.addMenuItem(i6);
		e1.addMenuItem(i7);
		e1.addMenuItem(i8);
		e1.addMenuItem(i9);
		e1.addMenuItem(i10);
		e1.addMenuItem(i11);
		
		DebitCard d1 = new DebitCard();	//Creating Debit Cards
		d1.setCardNumber(987654);
		d1.setPassword(275);
		d1.setBalance(100);
		
		CustomerAccount c1 = new CustomerAccount();
		c1.setName("Jeff");
		c1.setRestaurant(r);
		c1.setUserName("customer1");
		c1.setPassword("11111111");
		c1.setPaymentInfo(d1);
		c1.setAddress("Tucson");
		c1.setPhoneNumber(1111111);
		r.addCustomer(c1);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		
		mainFrame = new JFrame();
		
		
//		mainFrame.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowActivated(WindowEvent e) {
//				
//			}
//		});
		
		
		mainFrame.setTitle(r.getName());
		mainFrame.setBounds(0,0, 500, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		employeeButton = new JButton("<html>Employee");
		employeeButton.setFont(new Font("Arial", Font.PLAIN, 20));
		employeeButton.addActionListener(new MenuListener());
		mainFrame.add(employeeButton);
		employeeButton.setBounds(66, 75, 150,100);
		
		customerButton = new JButton("<html>Customer");
		customerButton.setFont(new Font("Arial", Font.PLAIN, 20));
		customerButton.addActionListener(new MenuListener());
		mainFrame.add(customerButton);
		customerButton.setBounds(275, 75, 150,100);
		
	}
	
	
private class MenuListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			JButton source = (JButton)(e.getSource());
			
			if(source.equals(employeeButton)) {
				handleEmployee();
			}
			else if(source.equals(customerButton)) {
				handleCustomer();
			}
			else if(source.equals(employeeLoginButton)) {
				handleEmployeeLogin();
			}
			else if(source.equals(employeeRegButton)) {
				handleEmployeeRegister();
			}
			else if(source.equals(customerLoginButton)) {
				handleCustomerLogin();
			}
			else if(source.equals(customerRegButton)) {
				handleCustomerRegister();
			}
			else if(source.equals(employeeOptionChange)) {
				handleEmployeeOptionChange();
			}
			else if(source.equals(employeeOptionAdd)) {
				handleEmployeeOptionAdd();
			}
			else if(source.equals(employeeOptionDelete)) {
				handleEmployeeOptionDelete();
			}
			else if(source.equals(employeeOptionCloseOrder)) {
				handleEmployeeCloseOrder();
			}
			else if(source.equals(employeeOptionCloseRes)) {
				handleEmployeeOptionCloseRes();
			}
			else if(source.equals(employeeBack)) {
				employeeOptionFrame.setVisible(false);
				mainFrame.setVisible(true);
			}
			else if(source.equals(customerOptionRes)) {
				handleCustomerOptionRes();
			}
			else if(source.equals(customerOptionStartOrder)) {
				handleCustomerOptionStartOrder();
			}
			else if(source.equals(customerOptionCancelRes)) {
				handleCustomerOptionCancelRes();
			}
			else if(source.equals(customerOptionCancelOrder)) {
				handleCustomerOptionCancelOrder();
			}
			else if(source.equals(customerBack)) {
				customerOptionFrame.setVisible(false);
				mainFrame.setVisible(true);
			}
			else if(source.equals(empPrint)) {
				handleEmpPrint();
			}
			else if(source.equals(custPrint)) {
				handleCustPrint();
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		public void handleEmpPrint() {
			employeeOptionFrame.setVisible(true);
			xy = new JFrame();
			JPanel y = new JPanel();
			JTextArea a = new JTextArea();
			y.add(a);
			JScrollPane scrPan = new JScrollPane(y);
			xy.setTitle(r.getName());
			xy.setBounds(0,0, 800, 800);
			xy.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			a.setFont(new Font("Arial", Font.PLAIN, 15));
			xy.add(scrPan);
			
				a.append("Customer List:\n");
				for(int i = 0; i < r.getCustomers().size(); i++) {
					a.append("\n\n\t" + r.getCustomers().get(i).getUserName() + " - " + r.getCustomers().get(i).getName());
				}
			

				
				a.append("\n\n\nEmployeeList:\n");				
				for(int i = 0; i < r.getEmployees().size(); i++) {
					a.append("\n\n\t" + r.getEmployees().get(i).getUserName() + " - " + r.getEmployees().get(i).getName());
				}
				
				a.append("\n\n\nMenu:\n");
				a.append("\nBeverages:");
				for(int i = 0; i < r.getMenu().beverages.size(); i++) {
					a.append("\n\n\t" + r.getMenu().beverages.get(i).getName() + " - " + r.getMenu().beverages.get(i).getPrice());
					a.append("\n\t-" + r.getMenu().beverages.get(i).getDescription());
				}
				a.append("\n\n\nAppetizers:\n");
				for(int i = 0; i < r.getMenu().appetizers.size(); i++) {
					a.append("\n\n\t" + r.getMenu().appetizers.get(i).getName() + " - " + r.getMenu().appetizers.get(i).getPrice());
					a.append("\n\t-" + r.getMenu().appetizers.get(i).getDescription());
				}
				a.append("\n\n\nEntrees:\n");
				for(int i = 0; i < r.getMenu().entrees.size(); i++) {
					a.append("\n\n\t" + r.getMenu().entrees.get(i).getName() + " - " + r.getMenu().entrees.get(i).getPrice());
					a.append("\n\t-" + r.getMenu().entrees.get(i).getDescription());
				}
				a.append("\n\n\nDesserts:\n");
				for(int i = 0; i < r.getMenu().desserts.size(); i++) {
					a.append("\n\n\t" + r.getMenu().desserts.get(i).getName() + " - " + r.getMenu().desserts.get(i).getPrice());
					a.append("\n\t-" + r.getMenu().desserts.get(i).getDescription());
				}
				a.append("\n\n");
				
				a.append("\n\n\nReservation:\n");
				for(int i = 0; i < r.getReservations().size(); i++) {
					a.append("\n\n" + r.getReservations().get(i).getAccount().getUserName() + ", Time Slot: " + r.getReservations().get(i).getTime() + ", Size: " + r.getReservations().get(i).getSize() + "\n");

				}
				a.append("\n\n");
		
				
				a.append("\n\n\nOrders:\n");
				for(int i = 0; i < r.getOrders().size(); i++) {
					a.append("\n\n");
					if(r.getOrders().get(i).getAccount().getOrderType().equals("Dine In")) {
						
						a.append("User " + r.getOrders().get(i).getAccount().getUserName() + "'s Order: \n");
						a.append("Dine In:\n");
						a.append("Reservation- Time Slot: " + ((DineIn) r.getOrders().get(i)).getReservation().getTime() + ", Size: " + ((DineIn) r.getOrders().get(i)).getReservation().getSize() + "\n");
						for(int j = 0; j < r.getOrders().get(i).getItemsList().size(); j++) {
							a.append("\t" + r.getOrders().get(i).getItemsList().get(j).getName() + " - " + r.getOrders().get(i).getItemsList().get(j).getPrice());
						}
						a.append("\nComment: " + r.getOrders().get(i).getComment());
						a.append("\nService Fee: " + ((DineIn)r.getOrders().get(i)).getServiceFee() + "\tTotal: " + r.getOrders().get(i).getTotal() + "\n");
						
					}
					else if(r.getOrders().get(i).getAccount().getOrderType().equals("Pickup")) {
						
						a.append("User " + r.getOrders().get(i).getAccount().getUserName() + "'s Order: \n");
						a.append("PickUp:\n");
						for(int j = 0; j < r.getOrders().get(i).getItemsList().size(); j++) {
							a.append("\t" + r.getOrders().get(i).getItemsList().get(j).getName() + " - " + r.getOrders().get(i).getItemsList().get(j).getPrice());
						}
						a.append("\nComment: " + r.getOrders().get(i).getComment());
						a.append("\nTotal: " + r.getOrders().get(i).getTotal() + "\n");
						
					}
					else {
						
						a.append("User " + r.getOrders().get(i).getAccount().getUserName() + "'s Order: \n");
						a.append("Delivery:\t\tEstimated Time - " + ((Delivery) r.getOrders().get(i)).getDeliveryTime() + "\n");
						for(int j = 0; j < r.getOrders().get(i).getItemsList().size(); j++) {
							a.append("\t" + r.getOrders().get(i).getItemsList().get(j).getName() + " - " + r.getOrders().get(i).getItemsList().get(j).getPrice());
						}
						a.append("\nComment: " + r.getOrders().get(i).getComment());
						a.append("\nDelivery Fee: " + ((Delivery) r.getOrders().get(i)).getDeliveryFee() + "\tTotal: " + r.getOrders().get(i).getTotal() + "\n");
						
					}
				}
				a.append("\n");
			

				a.append("\n\n\nToday's Sales:\t$" + r.getSales());
			
			
			xy.setVisible(true);
		}
		
		
		
		
		public void handleCustPrint() {
			customerOptionFrame.setVisible(true);
			yz = new JFrame();
			
			CustomerAccount tempCust = r.getCustomers().get(currentCust);
			
			JPanel y = new JPanel();
			JTextArea a = new JTextArea();
			y.add(a);
			yz.setTitle(r.getName());
			yz.setBounds(0,0, 800, 800);
			yz.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			a.setFont(new Font("Arial", Font.PLAIN, 15));
			yz.add(y);
			
			if(tempCust.getOrderType().equals("Dine In")) {
				
				a.append("User " + tempCust.getUserName() + "'s Order: \n");
				a.append("Dine In:\n");
				a.append("Reservation- Time Slot: " +  tempCust.getReservation().getTime() + ", Size: " + tempCust.getReservation().getSize() + "\n");
				for(int j = 0; j < tempCust.getCurrentOrder().getItemsList().size(); j++) {
					a.append("\t" + tempCust.getCurrentOrder().getItemsList().get(j).getName() + " - " + tempCust.getCurrentOrder().getItemsList().get(j).getPrice());
				}
				a.append("\nComment: " + tempCust.getCurrentOrder().getComment());
				a.append("\nService Fee: " + ((DineIn) tempCust.getCurrentOrder()).getServiceFee() + "\tTotal: " + tempCust.getCurrentOrder().getTotal() + "\n");
				
			}
			else if(tempCust.getOrderType().equals("Pickup")) {
				
				a.append("User " + tempCust.getUserName() + "'s Order: \n");
				a.append("PickUp:\n");
				for(int j = 0; j < tempCust.getCurrentOrder().getItemsList().size(); j++) {
					a.append("\t" + tempCust.getCurrentOrder().getItemsList().get(j).getName() + " - " + tempCust.getCurrentOrder().getItemsList().get(j).getPrice());
				}
				a.append("\nComment: " + tempCust.getCurrentOrder().getComment());
				a.append("\nTotal: " + tempCust.getCurrentOrder().getTotal() + "\n");
				
			}
			else if(tempCust.getOrderType().equals("Delivery")){
				
				a.append("User " + tempCust.getUserName() + "'s Order: \n");
				a.append("Delivery:\t\tEstimated Time - " + ((Delivery)tempCust.getCurrentOrder()).getDeliveryTime() + "\n");
				for(int j = 0; j < tempCust.getCurrentOrder().getItemsList().size(); j++) {
					a.append("\t" + tempCust.getCurrentOrder().getItemsList().get(j).getName() + " - " + tempCust.getCurrentOrder().getItemsList().get(j).getPrice());
				}
				a.append("\nComment: " + tempCust.getCurrentOrder().getComment());
				a.append("\nDelivery Fee: " + ((Delivery)tempCust.getCurrentOrder()).getDeliveryFee() + "\tTotal: " + tempCust.getCurrentOrder().getTotal() + "\n");
				
			}
			else {
				
			}
			
			yz.setVisible(true);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void handleEmployee() {
			
			mainFrame.setVisible(false);
			x = new JFrame();
			JPanel y = new JPanel();
			y.setLayout(null);
			x.setTitle("Employee");
			x.setBounds(0,0, 500, 300);
			x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			employeeLoginButton = new JButton("Login");
			employeeLoginButton.setFont(new Font("Arial", Font.PLAIN, 20));
			employeeLoginButton.addActionListener(new MenuListener());
			y.add(employeeLoginButton);
			employeeLoginButton.setBounds(66, 75, 150,100);
			
			employeeRegButton = new JButton("Register");
			employeeRegButton.setFont(new Font("Arial", Font.PLAIN, 20));
			employeeRegButton.addActionListener(new MenuListener());
			y.add(employeeRegButton);
			employeeRegButton.setBounds(275, 75, 150,100);
			
			
			x.add(y);
			x.setVisible(true);
			
			
		}
		
		public void handleCustomer() {
			
			mainFrame.setVisible(false);
			z = new JFrame();
			JPanel y = new JPanel();
			y.setLayout(null);
			z.setTitle("Customer");
			z.setBounds(0,0, 500, 300);
			z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			customerLoginButton = new JButton("Login");
			customerLoginButton.setFont(new Font("Arial", Font.PLAIN, 20));
			customerLoginButton.addActionListener(new MenuListener());
			y.add(customerLoginButton);
			customerLoginButton.setBounds(66, 75, 150,100);
			
			customerRegButton = new JButton("Register");
			customerRegButton.setFont(new Font("Arial", Font.PLAIN, 20));
			customerRegButton.addActionListener(new MenuListener());
			y.add(customerRegButton);
			customerRegButton.setBounds(275, 75, 150,100);
			
			
			z.add(y);
			z.setVisible(true);
			
		}
		
		public void handleEmployeeLogin() {
			x.setVisible(false);
			String user;
			String password;
			boolean validUser = false;
			EmployeeAccount emp1 = new EmployeeAccount();
			emp1.setName("test");
			
			JPanel panel = new JPanel(new GridLayout(4,1));
			
			JLabel x = new JLabel("UserName:");
			JLabel y = new JLabel("Password:");
			JTextField a = new JTextField(15);
			JTextField b = new JTextField(15);
			
			panel.add(x);
			panel.add(a);
			panel.add(y);
			panel.add(b);
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "Employee Login", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				user = a.getText();
				password = b.getText();
				if((user != null) && (password != null)) {
										
					for(int i = 0; i < r.getEmployees().size(); i++) {
						if(r.getEmployees().get(i).getUserName().equals(user)) {
							validUser = true;
							emp1 = r.getEmployees().get(i);
							break;
						}
					}
					if(validUser == true) {
						if(emp1.getPassword().equals(password)) {
							employeeOptionScreen();
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect Password", "Error", JOptionPane.PLAIN_MESSAGE);
							handleEmployeeLogin();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "User Does Not Exist", "Error", JOptionPane.PLAIN_MESSAGE);
						handleEmployeeLogin();
					}
				}
				else {
					//maybe add error message
				}
			}
			else {
				mainFrame.setVisible(true);
			}
			
		}
		
		public void handleCustomerLogin() {
			
			z.setVisible(false);
			String user;
			String password;
			int tempCust = 0;
			boolean validUser = false;
			CustomerAccount cust1 = new CustomerAccount();
			
			JPanel panel = new JPanel(new GridLayout(4,1));
			
			JLabel x = new JLabel("UserName:");
			JLabel y = new JLabel("Password:");
			JTextField a = new JTextField(15);
			JTextField b = new JTextField(15);
			
			panel.add(x);
			panel.add(a);
			panel.add(y);
			panel.add(b);
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "Customer Login", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				user = a.getText();
				password = b.getText();
				if((user != null) && (password != null)) {
										
					for(int i = 0; i < r.getCustomers().size(); i++) {
						if(r.getCustomers().get(i).getUserName().equals(user)) {
							validUser = true;
							cust1 = r.getCustomers().get(i);
							tempCust = i;
							break;
						}
					}
					if(validUser == true) {
						if(cust1.getPassword().equals(password)) {
							currentCust = tempCust;
							customerOptionScreen();
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect Password", "Error", JOptionPane.PLAIN_MESSAGE);
							handleCustomerLogin();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "User Does Not Exist", "Error", JOptionPane.PLAIN_MESSAGE);
						handleCustomerLogin();
					}
				}
				else {
					//maybe add error message
				}
			}
			else {
				mainFrame.setVisible(true);
			}
			
		}
		
		public void handleEmployeeRegister() {
			
			 String name;
			 String userName;
			 String password;
			//protected Restaurant restaurant;
			//Integer loginStatus;
			
			x.setVisible(false);
			
			JPanel panel = new JPanel(new GridLayout(6,1));
			
			JLabel x = new JLabel("UserName:");
			JLabel y = new JLabel("Password:");
			JLabel z = new JLabel("Name:");
			JTextField a = new JTextField(15);
			JTextField b = new JTextField(15);
			JTextField c = new JTextField(15);
			
			panel.add(z);
			panel.add(c);
			panel.add(x);
			panel.add(a);
			panel.add(y);
			panel.add(b);
			
			boolean conflict = false;
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "Employee Register", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				userName = a.getText();
				password = b.getText();
				name = c.getText();
				if((userName != null) && (password != null) && (name != null)) {
					
					if(name.trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Invalid Name", "Error", JOptionPane.PLAIN_MESSAGE);
						handleEmployeeRegister();
					}
					else {
						
						for(int i = 0; i < r.getEmployees().size(); i++) {
							if(r.getEmployees().get(i).getUserName().equals(userName)) {
								conflict = true;
								break;
							}
						}
						if(conflict == true) {
							JOptionPane.showMessageDialog(null, "UserName taken", "Error", JOptionPane.PLAIN_MESSAGE);
							handleEmployeeRegister();
						}
						else {
							if((password.length() < 8) || (password.length() > 12)) {
								JOptionPane.showMessageDialog(null, "Password must be between 8 and 12 characters long", "Error", JOptionPane.PLAIN_MESSAGE);
								handleEmployeeRegister();
							}
							else {
								JOptionPane.showMessageDialog(null, "Employee " + name + " added", "Success", JOptionPane.PLAIN_MESSAGE);
								EmployeeAccount newEmp = new EmployeeAccount();
								newEmp.setName(name);
								newEmp.setPassword(password);
								newEmp.setRestaurant(r);
								newEmp.setUserName(userName);
								r.addEmployee(newEmp);
								employeeOptionScreen();
							}

						}

						
					}
										

				}
				else {
					//maybe add error message
				}
			}
			else {
				mainFrame.setVisible(true);
			}
			
		}
		
		public void handleCustomerRegister() {
			 Integer phoneNumber = 0;
			 String phoneString;
			 String address;
			 String name;
			 String userName;
			 String password;
			 String cardString;
			 String cardPasswordString;
			 String cardBalanceString;
			 Integer cardNumber;
			 Integer cardPassword;
			 Integer cardBalance;
			 boolean conflict = false;
			//protected Restaurant restaurant;
			//Integer loginStatus;
			
			z.setVisible(false);
			
			JPanel panel = new JPanel(new GridLayout(16,1));
			
			JLabel x = new JLabel("UserName:");
			JLabel y = new JLabel("Password:");
			JLabel z = new JLabel("Name:");
			JLabel t = new JLabel("Phone Number(7 digits):");
			JLabel q = new JLabel("Address(Tucson, Phoenix, Flagstaff):");
			JTextField a = new JTextField(15);
			JTextField b = new JTextField(15);
			JTextField c = new JTextField(15);
			JTextField d = new JTextField(15);
			JTextField e = new JTextField(15);
			
			JLabel w = new JLabel("Debit Card Number(6 digits):");
			JTextField w1 = new JTextField(15);
			JLabel ww = new JLabel("Card Password(less than 10 digits):");
			JTextField ww1 = new JTextField(15);
			JLabel www = new JLabel("Debit Card Balance:");
			JTextField www1 = new JTextField(15);
			
			panel.add(z);
			panel.add(c);
			panel.add(x);
			panel.add(a);
			panel.add(y);
			panel.add(b);
			panel.add(t);
			panel.add(d);
			panel.add(q);
			panel.add(e);
			panel.add(w);
			panel.add(w1);
			panel.add(ww);
			panel.add(ww1);
			panel.add(www);
			panel.add(www1);
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "Customer Register", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				userName = a.getText();
				password = b.getText();
				name = c.getText();
				phoneString = d.getText();
				phoneNumber = Integer.parseInt(phoneString);
				address = e.getText();
				cardString = w1.getText();
				cardNumber = Integer.parseInt(cardString);
				cardPasswordString = ww1.getText();
				cardPassword = Integer.parseInt(cardPasswordString);
				cardBalanceString = www1.getText();
				cardBalance = Integer.parseInt(cardBalanceString);
				if((userName != null) && (password != null) && (name != null) && (phoneString != null) && (address != null)) {
					
					if(name.trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Invalid Name", "Error", JOptionPane.PLAIN_MESSAGE);
						handleCustomerRegister();
					}
					else {
						
						for(int i = 0; i < r.getCustomers().size(); i++) {
							if(r.getCustomers().get(i).getUserName().equals(userName)) {
								conflict = true;
								break;
							}
						}
						if(conflict == true) {
							JOptionPane.showMessageDialog(null, "UserName taken", "Error", JOptionPane.PLAIN_MESSAGE);
							handleCustomerRegister();
						}
						else {
							if((password.length() < 8) || (password.length() > 12)) {
								JOptionPane.showMessageDialog(null, "Password must be between 8 and 12 characters long", "Error", JOptionPane.PLAIN_MESSAGE);
								handleCustomerRegister();
							}
							else {
								if(!(((address.equals("Tucson")) || (address.equals("Phoenix")) || (address.equals("Flagstaff"))))) {
									JOptionPane.showMessageDialog(null, "Invalid Address", "Error", JOptionPane.PLAIN_MESSAGE);
									handleCustomerRegister();
								}
								else {
									if((phoneNumber < 1000000) || (phoneNumber > 9999999)) {
										JOptionPane.showMessageDialog(null, "Phone Number must be 7 digits", "Error", JOptionPane.PLAIN_MESSAGE);
										handleCustomerRegister();
									}
									else {
										if((cardNumber < 100000) || (cardNumber > 999999)) {		//card number must be six digits
											JOptionPane.showMessageDialog(null, "Card Number must be 7 digits", "Error", JOptionPane.PLAIN_MESSAGE);
											handleCustomerRegister();
										}
										else {
											if(cardPassword > 999999999) {
												JOptionPane.showMessageDialog(null, "Card Password must be less than 10 digits", "Error", JOptionPane.PLAIN_MESSAGE);
												handleCustomerRegister();
											}
											else {
												if(cardBalance < 0) {
													JOptionPane.showMessageDialog(null, "Card balance can't be negative", "Error", JOptionPane.PLAIN_MESSAGE);
													handleCustomerRegister();
												}
												else {
													
													JOptionPane.showMessageDialog(null, "Customer " + name + " added", "Success", JOptionPane.PLAIN_MESSAGE);
													CustomerAccount newCust = new CustomerAccount();
													newCust.setName(name);
													newCust.setPassword(password);
													newCust.setRestaurant(r);
													newCust.setUserName(userName);
													newCust.setPhoneNumber(phoneNumber);
													newCust.setAddress(address);
													DebitCard d1 = new DebitCard();
													d1.setBalance(cardBalance);
													d1.setCardNumber(cardNumber);
													d1.setPassword(cardPassword);
													newCust.setPaymentInfo(d1);
													r.addCustomer(newCust);
													currentCust = r.getCustomers().size()-1;
													customerOptionScreen();
													
												}
											}
										}
										
									}

								}

							}
						}
						
					}
										
				}
				else {
					//maybe add error message
				}
			}
			else {
				mainFrame.setVisible(true);
			}
			
		}
		
		public void employeeOptionScreen() {	//Change Price, Add item, delete item, close order, or close reservation
			
			 employeeOptionFrame = new JFrame();
			 JPanel y = new JPanel();
			 y.setLayout(null);
			 employeeOptionFrame.setTitle("Employee Options");
			 employeeOptionFrame.setBounds(0,0,1500,800);
			 employeeOptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
			  employeeOptionChange = new JButton("Change Price");
			  employeeOptionChange.setFont(new Font("Arial", Font.PLAIN, 30));
			  employeeOptionChange.addActionListener(new MenuListener());
			  y.add(employeeOptionChange);
			  employeeOptionChange.setBounds(300,25,300,150);
			  
			  employeeOptionAdd = new JButton("Add Menu Item");
			  employeeOptionAdd.setFont(new Font("Arial", Font.PLAIN, 30));
			  employeeOptionAdd.addActionListener(new MenuListener());
			  y.add(employeeOptionAdd);
			  employeeOptionAdd.setBounds(300,225,300,150);
			  
			  employeeOptionDelete = new JButton("Delete Menu Item");
			  employeeOptionDelete.setFont(new Font("Arial", Font.PLAIN, 30));
			  employeeOptionDelete.addActionListener(new MenuListener());
			  y.add(employeeOptionDelete);
			  employeeOptionDelete.setBounds(300,425,300,150);
			  
			  employeeOptionCloseOrder = new JButton("Close Order");
			  employeeOptionCloseOrder.setFont(new Font("Arial", Font.PLAIN, 30));
			  employeeOptionCloseOrder.addActionListener(new MenuListener());
			  y.add(employeeOptionCloseOrder);
			  employeeOptionCloseOrder.setBounds(900,25,300,150);
			  
			  employeeOptionCloseRes = new JButton("Close Reservation");
			  employeeOptionCloseRes.setFont(new Font("Arial", Font.PLAIN, 30));
			  employeeOptionCloseRes.addActionListener(new MenuListener());
			  y.add(employeeOptionCloseRes);
			  employeeOptionCloseRes.setBounds(900,225,300,150);
			  
			  empPrint = new JButton("Print All");
			  empPrint.setFont(new Font("Arial", Font.PLAIN, 30));
			  empPrint.addActionListener(new MenuListener());
			  y.add(empPrint);
			  empPrint.setBounds(900, 425, 300, 150);
			  
			  employeeBack = new JButton("Log Out");
			  employeeBack.setFont(new Font("Arial", Font.PLAIN, 30));
			  employeeBack.addActionListener(new MenuListener());
			  y.add(employeeBack);
			  employeeBack.setBounds(650,600,200,100);
			  Color color = new Color(225,102,102);
			  employeeBack.setBackground(color);
			  
			  employeeOptionFrame.add(y);
			  employeeOptionFrame.setVisible(true);
			  
			  
			
			
		}
		
		public void customerOptionScreen() {	//make reservation, start order(first ask order type, then go to petits gui screen(canfinalize, add and delete items, and add comment from that screen)),  cancel reservation, cancel order
			
			customerOptionFrame = new JFrame();
			 JPanel y = new JPanel();
			 y.setLayout(null);
			 customerOptionFrame.setTitle("Customer Options");
			 customerOptionFrame.setBounds(0,0,1500,800);
			 customerOptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
			 customerOptionRes = new JButton("Make Reservation");
			 customerOptionRes.setFont(new Font("Arial", Font.PLAIN, 30));
			 customerOptionRes.addActionListener(new MenuListener());
			  y.add(customerOptionRes);
			  customerOptionRes.setBounds(300,25,300,150);
			  
			  customerOptionStartOrder = new JButton("Start Order");
			  customerOptionStartOrder.setFont(new Font("Arial", Font.PLAIN, 30));
			  customerOptionStartOrder.addActionListener(new MenuListener());
			  y.add(customerOptionStartOrder);
			  customerOptionStartOrder.setBounds(300,225,300,150);
			  
			  customerOptionCancelRes = new JButton("Cancel Reservation");
			  customerOptionCancelRes.setFont(new Font("Arial", Font.PLAIN, 30));
			  customerOptionCancelRes.addActionListener(new MenuListener());
			  y.add(customerOptionCancelRes);
			  customerOptionCancelRes.setBounds(300,425,300,150);
			  
			  customerOptionCancelOrder = new JButton("Cancel Order");
			  customerOptionCancelOrder.setFont(new Font("Arial", Font.PLAIN, 30));
			  customerOptionCancelOrder.addActionListener(new MenuListener());
			  y.add(customerOptionCancelOrder);
			  customerOptionCancelOrder.setBounds(900,25,300,150);
			  
			  custPrint = new JButton("Print Customer");
			  custPrint.setFont(new Font("Arial", Font.PLAIN, 30));
			  custPrint.addActionListener(new MenuListener());
			  y.add(custPrint);
			  custPrint.setBounds(900,225,300,150);
			  
			  customerBack = new JButton("Log Out");
			  customerBack.setFont(new Font("Arial", Font.PLAIN, 30));
			  customerBack.addActionListener(new MenuListener());
			  y.add(customerBack);
			  customerBack.setBounds(900,425,300,150);
			  Color color = new Color(225,102,102);
			  customerBack.setBackground(color);
			  
			  customerOptionFrame.add(y);
			  customerOptionFrame.setVisible(true);
			
			

		}
		
		public void handleEmployeeOptionChange() {
			
			employeeOptionFrame.setVisible(false);
		
			 String name;
			 String priceString;
			 Integer price = 0;

			
			JPanel panel = new JPanel(new GridLayout(4,1));
			
			JLabel x = new JLabel("Item:");
			JLabel y = new JLabel("New Price:");
			JTextField a = new JTextField(15);
			JTextField b = new JTextField(15);
			Item newItem = new Item();
			panel.add(x);
			panel.add(a);
			panel.add(y);
			panel.add(b);
			
			boolean conflict = true;
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "Price Change", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				name = a.getText();
				priceString = b.getText();
				price = Integer.parseInt(priceString);
				if((name != null) && (priceString != null)) {
					
					for(int i = 0; i < r.getMenu().beverages.size(); i++) {
						if(r.getMenu().beverages.get(i).getName().equals(name)) {
							conflict = false;
							newItem = r.getMenu().beverages.get(i);
						}
					}
					
					for(int i = 0; i < r.getMenu().appetizers.size(); i++) {
						if(r.getMenu().appetizers.get(i).getName().equals(name)) {
							conflict = false;
							newItem = r.getMenu().appetizers.get(i);
						}
					}
					
					for(int i = 0; i < r.getMenu().entrees.size(); i++) {
						if(r.getMenu().entrees.get(i).getName().equals(name)) {
							conflict = false;
							newItem = r.getMenu().entrees.get(i);
						}
					}
					
					for(int i = 0; i < r.getMenu().desserts.size(); i++) {
						if(r.getMenu().desserts.get(i).getName().equals(name)) {
							conflict = false;
							newItem = r.getMenu().desserts.get(i);
						}
					}
					
					if(conflict == true) {
						JOptionPane.showMessageDialog(null, "Item not on the menu", "Error", JOptionPane.PLAIN_MESSAGE);
						handleEmployeeOptionChange();
					}
					else {
						if(price < 1) {
							JOptionPane.showMessageDialog(null, "Price must be positive", "Error", JOptionPane.PLAIN_MESSAGE);
							handleEmployeeOptionChange();
						}
						else {
							r.changePrice(name, price);
							JOptionPane.showMessageDialog(null, name + " price changed to $" + price, "Success", JOptionPane.PLAIN_MESSAGE);
							employeeOptionScreen();
						}
					}
					
				}
				else {
					//maybe error message
				}
			}
			else {
				employeeOptionFrame.setVisible(true);
			}
			
		}
		
		public void handleEmployeeOptionAdd() {
			
			employeeOptionFrame.setVisible(false);
			
			 String name;
			 String priceString;
			 Integer price = 0;
			 String description;
			 String type;

			
			JPanel panel = new JPanel(new GridLayout(8,1));
			
			JLabel x = new JLabel("Item Name:");
			JLabel y = new JLabel("Price:");
			JLabel z = new JLabel("Description");
			JLabel t = new JLabel("Type");
			JTextField a = new JTextField(15);
			JTextField b = new JTextField(15);
			JTextField c = new JTextField(50);
			JTextField d = new JTextField(15);
			Item newItem = new Item();
			panel.add(x);
			panel.add(a);
			panel.add(y);
			panel.add(b);
			panel.add(z);
			panel.add(c);
			panel.add(t);
			panel.add(d);
			
			boolean conflict = false;
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "New Item", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				name = a.getText();
				priceString = b.getText();
				price = Integer.parseInt(priceString);
				description = c.getText();
				type = d.getText();
				if((name != null) && (priceString != null) && (description != null) && (type != null)) {
					
					for(int i = 0; i < r.getMenu().beverages.size(); i++) {
						if(r.getMenu().beverages.get(i).getName().equals(name)) {
							conflict = true;
						}
					}
					
					for(int i = 0; i < r.getMenu().appetizers.size(); i++) {
						if(r.getMenu().appetizers.get(i).getName().equals(name)) {
							conflict = true;
						}
					}
					
					for(int i = 0; i < r.getMenu().entrees.size(); i++) {
						if(r.getMenu().entrees.get(i).getName().equals(name)) {
							conflict = true;
						}
					}
					
					for(int i = 0; i < r.getMenu().desserts.size(); i++) {
						if(r.getMenu().desserts.get(i).getName().equals(name)) {
							conflict = true;
						}
					}
					
					if(conflict == true) {
						JOptionPane.showMessageDialog(null, "Item already on the menu", "Error", JOptionPane.PLAIN_MESSAGE);
						handleEmployeeOptionAdd();
					}
					else {
						if(price < 1) {
							JOptionPane.showMessageDialog(null, "Price Must be positive", "Error", JOptionPane.PLAIN_MESSAGE);
							handleEmployeeOptionAdd();
						}
						else {
							if(!((type.equals("dessert")) || (type.equals("entree")) || (type.equals("beverage")) || (type.equals("appetizer")))) {
								JOptionPane.showMessageDialog(null, "Valid types are beverage, entree, appetizer, and dessert", "Error", JOptionPane.PLAIN_MESSAGE);
								handleEmployeeOptionAdd();
							}
							else {
								newItem.setDescription(description);
								newItem.setName(name);
								newItem.setPrice(price);
								newItem.setType(type);
								r.addMenuItem(newItem);
								JOptionPane.showMessageDialog(null, name + " added to menu", "Success", JOptionPane.PLAIN_MESSAGE);
								employeeOptionFrame.setVisible(true);
							}

						}

					}
					

				}
				else {
					//maybe error message
				}
			}
			else {
				employeeOptionFrame.setVisible(true);
			}
			
		}
		
		public void handleEmployeeOptionDelete() {
			
			employeeOptionFrame.setVisible(false);
			
			 String name;

			
			JPanel panel = new JPanel(new GridLayout(2,1));
			
			JLabel x = new JLabel("Item Name:");
			JTextField a = new JTextField(15);
			panel.add(x);
			panel.add(a);
			
			boolean conflict = true;
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "Delete Item", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				name = a.getText();
				if(name != null) {
					
					for(int i = 0; i < r.getMenu().beverages.size(); i++) {		//these loops check for the item
						if(r.getMenu().beverages.get(i).getName().equals(name)) {
							conflict = false;
						}
					}
					
					for(int i = 0; i < r.getMenu().appetizers.size(); i++) {
						if(r.getMenu().appetizers.get(i).getName().equals(name)) {
							conflict = false;
						}
					}
					
					for(int i = 0; i < r.getMenu().entrees.size(); i++) {
						if(r.getMenu().entrees.get(i).getName().equals(name)) {
							conflict = false;
						}
					}
					
					for(int i = 0; i < r.getMenu().desserts.size(); i++) {
						if(r.getMenu().desserts.get(i).getName().equals(name)) {
							conflict = false;
						}
					}
					
					if(conflict == true) {
						JOptionPane.showMessageDialog(null, name + "Item not on menu", "Error", JOptionPane.PLAIN_MESSAGE);
						handleEmployeeOptionDelete();
					}
					else {
						
						r.deleteMenuItem(name);
						JOptionPane.showMessageDialog(null, name + " deleted from menu", "Success", JOptionPane.PLAIN_MESSAGE);
						employeeOptionFrame.setVisible(true);
					}
					
				}
				else {
					//error message
				}
				
			}
			else {
				employeeOptionFrame.setVisible(true);
			}
				
			
			
		}
		
		public void handleEmployeeCloseOrder() {
			
			employeeOptionFrame.setVisible(false);
			
			 String orderString;
			 Integer order = 0;

			
			JPanel panel = new JPanel(new GridLayout(2,1));
			
			JLabel x = new JLabel("Order Number:");
			JTextField a = new JTextField(15);
			panel.add(x);
			panel.add(a);
			
			boolean conflict = true;
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "Close Order", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				orderString = a.getText();
				order = Integer.parseInt(orderString);

					if(r.getOrders().size() < order) {
						JOptionPane.showMessageDialog(null, "Restaurant has " + r.getOrders().size() + " orders", "Error", JOptionPane.PLAIN_MESSAGE);
						handleEmployeeCloseOrder();
	
					}
					else {
						r.closeOrder(order);
						JOptionPane.showMessageDialog(null, "Order " + order + " closed", "Success", JOptionPane.PLAIN_MESSAGE);
						employeeOptionFrame.setVisible(true);
					}
			}
			else {
				employeeOptionFrame.setVisible(true);
			}
			
		}
		
		public void handleEmployeeOptionCloseRes() {
			
			employeeOptionFrame.setVisible(false);
			
			 String resString;
			 Integer res = 0;

			
			JPanel panel = new JPanel(new GridLayout(2,1));
			
			JLabel x = new JLabel("Reservation Number:");
			JTextField a = new JTextField(15);
			panel.add(x);
			panel.add(a);
			
			boolean conflict = true;
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "Close Reservation", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				resString = a.getText();
				res = Integer.parseInt(resString);

					if(r.getReservations().size() < res) {
						JOptionPane.showMessageDialog(null, "Restaurant has " + r.getReservations().size() + " reservations", "Error", JOptionPane.PLAIN_MESSAGE);
						handleEmployeeOptionCloseRes();
	
					}
					else {
						r.closeReservation(res);
						JOptionPane.showMessageDialog(null, "Reservation " + res + " closed", "Success", JOptionPane.PLAIN_MESSAGE);
						employeeOptionFrame.setVisible(true);
					}
			}
			else {
				employeeOptionFrame.setVisible(true);
			}
			
		}
		
		public void handleCustomerOptionRes() {
			
			CustomerAccount tempCust = r.getCustomers().get(currentCust);
			
			customerOptionFrame.setVisible(false);
			
			 String timeStr;
			 String sizeStr;
			 Integer time = 0;
			 Integer size = 0;

			
			JPanel panel = new JPanel(new GridLayout(4,1));
			
			JLabel x = new JLabel("Time Slot:");
			JLabel y = new JLabel("Size:");
			JTextField a = new JTextField(15);
			JTextField b = new JTextField(15);
			panel.add(x);
			panel.add(a);
			panel.add(y);
			panel.add(b);

			
			boolean conflict = false;
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "New Reservation", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				timeStr = a.getText();
				sizeStr = b.getText();
				time = Integer.parseInt(timeStr);
				size = Integer.parseInt(sizeStr);
				
				if((time < 1) || (time > 7)) {				//checks to see if they want a valid time slot
					JOptionPane.showMessageDialog(null, "Time Slots are 1-7 corresponding to each 30 minute time slot between 5 and 9 p.m.", "Error", JOptionPane.PLAIN_MESSAGE);
					handleCustomerOptionRes();
				}
				else {
					if(tempCust.getReservation().getSize() != -1) {		//checks to see if customer already has a reservation
						JOptionPane.showMessageDialog(null, "This Customer already has a reservation today", "Error", JOptionPane.PLAIN_MESSAGE);
						handleCustomerOptionRes();
					}
					else {
						int space = 0;
						for(int i = 0; i < r.getReservations().size(); i++) {
							if(r.getReservations().get(i).getTime().equals(time)) {
								space = space + r.getReservations().get(i).getSize();
							}
						}
						if((8-space) < size) {					//checks to see if there is enough space available
							JOptionPane.showMessageDialog(null, "There is not enough space available during time slot " + time + ".", "Error", JOptionPane.PLAIN_MESSAGE);
							handleCustomerOptionRes();
							
						}
						else {
							tempCust.setReservation(time, size);
							JOptionPane.showMessageDialog(null, "Added Reservation", "Success", JOptionPane.PLAIN_MESSAGE);
							customerOptionFrame.setVisible(true);
						}
					}
				}
			}
			else {
				customerOptionFrame.setVisible(true);
			}
			
			
			
		}
		
		public void handleCustomerOptionStartOrder() {
			CustomerAccount tempCust = r.getCustomers().get(currentCust);
			
			if(r.getOrders().isEmpty() == false) {
				if(r.getOrders().contains(tempCust.getCurrentOrder())) {
					JOptionPane.showMessageDialog(null, "Customer has already placed an order", "Error", JOptionPane.PLAIN_MESSAGE);
					customerOptionScreen();
				}
				else {
					customerOptionFrame.setVisible(false);
					
					 String order;

					
					JPanel panelt = new JPanel(new GridLayout(2,1));
					JLabel x = new JLabel("Order Type(Dine In, Pickup, Delivery):");
					JTextField a = new JTextField(15);
					panelt.add(x);
					panelt.add(a);
					
					boolean conflict = false;
					
					int answer = JOptionPane.showConfirmDialog(null, panelt, "Close Reservation", JOptionPane.OK_CANCEL_OPTION);
					if(answer == JOptionPane.OK_OPTION) {
						order = a.getText();
						if((!order.equals("Dine In")) && (!order.equals("Pickup")) && (!order.equals("Delivery"))) {
							JOptionPane.showMessageDialog(null, "Invalid Order Type", "Error", JOptionPane.PLAIN_MESSAGE);
							handleCustomerOptionStartOrder();
						}
						else {
							if((order.equals("Dine In")) && (tempCust.getReservation().getSize().equals(-1))) {
								JOptionPane.showMessageDialog(null, "Must place a reservation before a Dine In order", "Error", JOptionPane.PLAIN_MESSAGE);
								customerOptionScreen();
							}
							else {
								tempCust.setOrderType(order);
								w = new JFrame();
								w.setTitle("Order");
								JTextArea text = new JTextArea();
								w.setBounds(0,0, 1500, 800);
								w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								JPanel basePanel = new JPanel();								//new GridLayout(1,2)
								basePanel.setLayout(null);
								JPanel panel = new JPanel();
								JPanel panel2 = new JPanel();
								panel2.add(text);
								JPanel panel3 = new JPanel();
								panel3.setLayout(null);
								JScrollPane scrPan = new JScrollPane(panel);							//////////////
								panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
								basePanel.add(scrPan);	
								JScrollPane scrPan2 = new JScrollPane(panel2);
								scrPan.setBounds(50, 25, 650, 700);
								basePanel.add(scrPan2);
								scrPan2.setBounds(800, 50, 650, 550);
								basePanel.add(panel3);
								panel3.setBounds(800, 600, 650, 200);
								w.add(basePanel);													///////////
								panel.setLayout(new GridLayout(0, 1, 0, 2));	//changed from 10,2,0,2
								panel2.setLayout(new GridLayout(0,1));
								text.setFont(new Font("Arial", Font.ITALIC, 25));
								text.append("\n                                 Items In Order");
							
								JLabel lblNewLabel_1 = new JLabel("Menu");
								lblNewLabel_1.setFont(new Font("Kokonor", Font.BOLD, 35));
								panel.add(lblNewLabel_1);
								lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
								
								JLabel lblNewLabel_2 = new JLabel("Beverages");
								lblNewLabel_2.setFont(new Font("Kokonor", Font.ITALIC + Font.BOLD, 25));
								panel.add(lblNewLabel_2);
								lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
								
								JButton finalize = new JButton("Finalize");
								finalize.setFont(new Font("Arial", Font.BOLD, 20));
								finalize.addActionListener(new ActionListener() {
								    public void actionPerformed(ActionEvent e)
								    {
								    	tempCust.getCurrentOrder().calculateTotal();
								    	if(tempCust.getCurrentOrder().getItemsList().size() == 0) {
								    		JOptionPane.showMessageDialog(null, "No Items In Cart", "Error", JOptionPane.PLAIN_MESSAGE);
								    	}
								    	else {
											if(tempCust.getPaymentInfo().getBalance() < tempCust.getCurrentOrder().getTotal()) {
												JOptionPane.showMessageDialog(null, "Customer Has Insufficient Funds", "Error", JOptionPane.PLAIN_MESSAGE);
												customerOptionScreen();
											}
											else {
												w.setVisible(false);
												 String comment;

													
													JPanel panely = new JPanel(new GridLayout(2,1));
													JLabel x = new JLabel("Comment:");
													JTextField a = new JTextField(15);
													panely.add(x);
													panely.add(a);
													
													boolean conflict = false;
													
													int answer = JOptionPane.showConfirmDialog(null, panely, "Close Reservation", JOptionPane.OK_CANCEL_OPTION);
													if(answer == JOptionPane.OK_OPTION) {
														comment = a.getText();
														tempCust.addCommentToOrder(comment);
													}
													else {
														
													}
												
												tempCust.getRestaurant().addOrder(tempCust.getCurrentOrder());
												JOptionPane.showMessageDialog(null, "Customer Order Placed", "Success", JOptionPane.PLAIN_MESSAGE);
												customerOptionScreen();
											}
								    	}
								    }
								});
								panel3.add(finalize);
								finalize.setBounds(66, 25, 200, 75);
								
								JButton cancel = new JButton("Cancel");
								cancel.setFont(new Font("Arial", Font.BOLD, 20));
								cancel.addActionListener(new ActionListener() {
								    public void actionPerformed(ActionEvent e)
								    {
										w.setVisible(false);
										customerOptionScreen();
								    }
								});
								panel3.add(cancel);
								cancel.setBounds(385, 25, 200, 75);
								
								for(int i = 0; i < r.getMenu().beverages.size(); i++) {
									final int index = i;
									JButton b = new JButton(r.getMenu().beverages.get(i).getName());
									b.setFont(new Font("Ariel", Font.PLAIN, 20));
									b.addActionListener(new ActionListener() {
									    public void actionPerformed(ActionEvent e)
									    {
											tempCust.addItemToOrder(r.getMenu().beverages.get(index).getName());
											text.append("\n\n   " + r.getMenu().beverages.get(index).getName() +  "                        " + r.getMenu().beverages.get(index).getPrice());
									    }
									});
									panel.add(b);
									
								}
								
								JLabel lblNewLabel_3 = new JLabel("appetizers");
								lblNewLabel_3.setFont(new Font("Kokonor", Font.ITALIC + Font.BOLD, 25));
								panel.add(lblNewLabel_3);
								lblNewLabel_3.setHorizontalAlignment(JLabel.CENTER);
								
								for(int i = 0; i < r.getMenu().appetizers.size(); i++) {
									final int index = i;
									JButton b = new JButton(r.getMenu().appetizers.get(i).getName());
									b.setFont(new Font("Ariel", Font.PLAIN, 20));
									b.addActionListener(new ActionListener() {
									    public void actionPerformed(ActionEvent e)
									    {
									    	tempCust.addItemToOrder(r.getMenu().appetizers.get(index).getName());
									    	text.append("\n\n   " + r.getMenu().appetizers.get(index).getName() +  "                        " + r.getMenu().appetizers.get(index).getPrice());
									    }
									});
									panel.add(b);
									
								}
								
								JLabel lblNewLabel_4 = new JLabel("entrees");
								lblNewLabel_4.setFont(new Font("Kokonor", Font.ITALIC + Font.BOLD, 25));
								panel.add(lblNewLabel_4);
								lblNewLabel_4.setHorizontalAlignment(JLabel.CENTER);
								
								for(int i = 0; i < r.getMenu().entrees.size(); i++) {
									final int index = i;
									JButton b = new JButton(r.getMenu().entrees.get(i).getName());
									b.setFont(new Font("Ariel", Font.PLAIN, 20));
									b.addActionListener(new ActionListener() {
									    public void actionPerformed(ActionEvent e)
									    {
									    	tempCust.addItemToOrder(r.getMenu().entrees.get(index).getName());	
									    	text.append("\n\n   " + r.getMenu().entrees.get(index).getName() +  "                        " + r.getMenu().entrees.get(index).getPrice());
									    }
									});
									panel.add(b);
									
								}
								
								JLabel lblNewLabel_5 = new JLabel("desserts");
								lblNewLabel_5.setFont(new Font("Kokonor", Font.ITALIC + Font.BOLD, 25));
								panel.add(lblNewLabel_5);
								lblNewLabel_5.setHorizontalAlignment(JLabel.CENTER);
								
								
								for(int i = 0; i < r.getMenu().desserts.size(); i++) {
									final int index = i;
									JButton b = new JButton(r.getMenu().desserts.get(i).getName());
									b.setFont(new Font("Ariel", Font.PLAIN, 20));
									b.addActionListener(new ActionListener() {
									    public void actionPerformed(ActionEvent e)
									    {
									    	tempCust.addItemToOrder(r.getMenu().desserts.get(index).getName());			
									    	text.append("\n\n   " + r.getMenu().desserts.get(index).getName() +  "                        " + r.getMenu().desserts.get(index).getPrice());
									    	}
									});
									panel.add(b);
									
								}
							
								w.setVisible(true);
							}
						}
						
					}
					else {
						customerOptionScreen();
					}
				}
			}
			else {
			customerOptionFrame.setVisible(false);
			
			 String order;

			
			JPanel panelt = new JPanel(new GridLayout(2,1));
			JLabel x = new JLabel("Order Type(Dine In, Pickup, Delivery):");
			JTextField a = new JTextField(15);
			panelt.add(x);
			panelt.add(a);
			
			boolean conflict = false;
			
			int answer = JOptionPane.showConfirmDialog(null, panelt, "Close Reservation", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				order = a.getText();
				if((!order.equals("Dine In")) && (!order.equals("Pickup")) && (!order.equals("Delivery"))) {
					JOptionPane.showMessageDialog(null, "Invalid Order Type", "Error", JOptionPane.PLAIN_MESSAGE);
					handleCustomerOptionStartOrder();
				}
				else {
					if((order.equals("Dine In")) && (tempCust.getReservation().getSize().equals(-1))) {
						JOptionPane.showMessageDialog(null, "Must place a reservation before a Dine In order", "Error", JOptionPane.PLAIN_MESSAGE);
						customerOptionScreen();
					}
					else {
						tempCust.setOrderType(order);
						w = new JFrame();
						w.setTitle("Order");
						JTextArea text = new JTextArea();
						w.setBounds(0,0, 1500, 800);
						w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JPanel basePanel = new JPanel();								//new GridLayout(1,2)
						basePanel.setLayout(null);
						JPanel panel = new JPanel();
						JPanel panel2 = new JPanel();
						panel2.add(text);
						JPanel panel3 = new JPanel();
						panel3.setLayout(null);
						JScrollPane scrPan = new JScrollPane(panel);							//////////////
						panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
						basePanel.add(scrPan);	
						JScrollPane scrPan2 = new JScrollPane(panel2);
						scrPan.setBounds(50, 25, 650, 700);
						basePanel.add(scrPan2);
						scrPan2.setBounds(800, 50, 650, 550);
						basePanel.add(panel3);
						panel3.setBounds(800, 600, 650, 200);
						w.add(basePanel);													///////////
						panel.setLayout(new GridLayout(0, 1, 0, 2));	//changed from 10,2,0,2
						panel2.setLayout(new GridLayout(0,1));
						text.setFont(new Font("Arial", Font.ITALIC, 25));
						text.append("\n                                 Items In Order");
					
						JLabel lblNewLabel_1 = new JLabel("Menu");
						lblNewLabel_1.setFont(new Font("Kokonor", Font.BOLD, 35));
						panel.add(lblNewLabel_1);
						lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
						
						JLabel lblNewLabel_2 = new JLabel("Beverages");
						lblNewLabel_2.setFont(new Font("Kokonor", Font.ITALIC + Font.BOLD, 25));
						panel.add(lblNewLabel_2);
						lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
						
						JButton finalize = new JButton("Finalize");
						finalize.setFont(new Font("Arial", Font.BOLD, 20));
						finalize.addActionListener(new ActionListener() {
						    public void actionPerformed(ActionEvent e)
						    {
						    	tempCust.getCurrentOrder().calculateTotal();
						    	if(tempCust.getCurrentOrder().getItemsList().size() == 0) {
						    		JOptionPane.showMessageDialog(null, "No Items In Cart", "Error", JOptionPane.PLAIN_MESSAGE);
						    	}
						    	else {
									if(tempCust.getPaymentInfo().getBalance() < tempCust.getCurrentOrder().getTotal()) {
										JOptionPane.showMessageDialog(null, "Customer Has Insufficient Funds", "Error", JOptionPane.PLAIN_MESSAGE);
										customerOptionScreen();
									}
									else {
										w.setVisible(false);
										 String comment;

											
											JPanel panely = new JPanel(new GridLayout(2,1));
											JLabel x = new JLabel("Comment:");
											JTextField a = new JTextField(15);
											panely.add(x);
											panely.add(a);
											
											boolean conflict = false;
											
											int answer = JOptionPane.showConfirmDialog(null, panely, "Close Reservation", JOptionPane.OK_CANCEL_OPTION);
											if(answer == JOptionPane.OK_OPTION) {
												comment = a.getText();
												tempCust.addCommentToOrder(comment);
											}
											else {
												
											}
										
										tempCust.getRestaurant().addOrder(tempCust.getCurrentOrder());
										JOptionPane.showMessageDialog(null, "Customer Order Placed", "Success", JOptionPane.PLAIN_MESSAGE);
										customerOptionScreen();
									}
						    	}
						    }
						});
						panel3.add(finalize);
						finalize.setBounds(66, 25, 200, 75);
						
						JButton cancel = new JButton("Cancel");
						cancel.setFont(new Font("Arial", Font.BOLD, 20));
						cancel.addActionListener(new ActionListener() {
						    public void actionPerformed(ActionEvent e)
						    {
								w.setVisible(false);
								customerOptionScreen();
						    }
						});
						panel3.add(cancel);
						cancel.setBounds(385, 25, 200, 75);
						
						for(int i = 0; i < r.getMenu().beverages.size(); i++) {
							final int index = i;
							JButton b = new JButton(r.getMenu().beverages.get(i).getName());
							b.setFont(new Font("Ariel", Font.PLAIN, 20));
							b.addActionListener(new ActionListener() {
							    public void actionPerformed(ActionEvent e)
							    {
									tempCust.addItemToOrder(r.getMenu().beverages.get(index).getName());
									text.append("\n\n   " + r.getMenu().beverages.get(index).getName() +  "                        " + r.getMenu().beverages.get(index).getPrice());
							    }
							});
							panel.add(b);
							
						}
						
						JLabel lblNewLabel_3 = new JLabel("appetizers");
						lblNewLabel_3.setFont(new Font("Kokonor", Font.ITALIC + Font.BOLD, 25));
						panel.add(lblNewLabel_3);
						lblNewLabel_3.setHorizontalAlignment(JLabel.CENTER);
						
						for(int i = 0; i < r.getMenu().appetizers.size(); i++) {
							final int index = i;
							JButton b = new JButton(r.getMenu().appetizers.get(i).getName());
							b.setFont(new Font("Ariel", Font.PLAIN, 20));
							b.addActionListener(new ActionListener() {
							    public void actionPerformed(ActionEvent e)
							    {
							    	tempCust.addItemToOrder(r.getMenu().appetizers.get(index).getName());
							    	text.append("\n\n   " + r.getMenu().appetizers.get(index).getName() +  "                        " + r.getMenu().appetizers.get(index).getPrice());
							    }
							});
							panel.add(b);
							
						}
						
						JLabel lblNewLabel_4 = new JLabel("entrees");
						lblNewLabel_4.setFont(new Font("Kokonor", Font.ITALIC + Font.BOLD, 25));
						panel.add(lblNewLabel_4);
						lblNewLabel_4.setHorizontalAlignment(JLabel.CENTER);
						
						for(int i = 0; i < r.getMenu().entrees.size(); i++) {
							final int index = i;
							JButton b = new JButton(r.getMenu().entrees.get(i).getName());
							b.setFont(new Font("Ariel", Font.PLAIN, 20));
							b.addActionListener(new ActionListener() {
							    public void actionPerformed(ActionEvent e)
							    {
							    	tempCust.addItemToOrder(r.getMenu().entrees.get(index).getName());	
							    	text.append("\n\n   " + r.getMenu().entrees.get(index).getName() +  "                        " + r.getMenu().entrees.get(index).getPrice());
							    }
							});
							panel.add(b);
							
						}
						
						JLabel lblNewLabel_5 = new JLabel("desserts");
						lblNewLabel_5.setFont(new Font("Kokonor", Font.ITALIC + Font.BOLD, 25));
						panel.add(lblNewLabel_5);
						lblNewLabel_5.setHorizontalAlignment(JLabel.CENTER);
						
						
						for(int i = 0; i < r.getMenu().desserts.size(); i++) {
							final int index = i;
							JButton b = new JButton(r.getMenu().desserts.get(i).getName());
							b.setFont(new Font("Ariel", Font.PLAIN, 20));
							b.addActionListener(new ActionListener() {
							    public void actionPerformed(ActionEvent e)
							    {
							    	tempCust.addItemToOrder(r.getMenu().desserts.get(index).getName());			
							    	text.append("\n\n   " + r.getMenu().desserts.get(index).getName() +  "                        " + r.getMenu().desserts.get(index).getPrice());
							    	}
							});
							panel.add(b);
							
						}
					
						w.setVisible(true);
					}
				}
				
			}
			else {
				customerOptionScreen();
			}
		}
		}
		
		public void handleCustomerOptionCancelRes() {
			
			CustomerAccount tempCust = r.getCustomers().get(currentCust);
			
			customerOptionFrame.setVisible(false);
			
			 String resStr;
			 Integer res = 0;
			
			JPanel panel = new JPanel(new GridLayout(1,1));
			
			JLabel x = new JLabel("Click OK to cancel Reservation");
			panel.add(x);
			
			boolean conflict = false;
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "Cancel Reservation", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				
				if(tempCust.getReservation().getSize().equals(-1)) {
					JOptionPane.showMessageDialog(null, "Customer doesn't have a reservation", "Error", JOptionPane.PLAIN_MESSAGE);
					customerOptionFrame.setVisible(true);
				}
				else {
					tempCust.cancelReservation();
					JOptionPane.showMessageDialog(null, "Reservation cancelled", "Success", JOptionPane.PLAIN_MESSAGE);
					customerOptionFrame.setVisible(true);
				}
				
			}
			else {
				customerOptionFrame.setVisible(true);
			}
			
		}
		
		public void handleCustomerOptionCancelOrder() {
			
CustomerAccount tempCust = r.getCustomers().get(currentCust);
			
			customerOptionFrame.setVisible(false);
			
			
			JPanel panel = new JPanel(new GridLayout(1,1));
			
			JLabel x = new JLabel("Click OK to cancel Order");
			panel.add(x);
			
			boolean conflict = false;
			
			int answer = JOptionPane.showConfirmDialog(null, panel, "Cancel Order", JOptionPane.OK_CANCEL_OPTION);
			if(answer == JOptionPane.OK_OPTION) {
				
				if(tempCust.getCurrentOrder().getTotal().equals(0)) {
					JOptionPane.showMessageDialog(null, "Customer doesn't have an order", "Error", JOptionPane.PLAIN_MESSAGE);
					customerOptionFrame.setVisible(true);
				}
				else {
					tempCust.cancelOrder();
					JOptionPane.showMessageDialog(null, "Order cancelled", "Success", JOptionPane.PLAIN_MESSAGE);
					customerOptionFrame.setVisible(true);
				}
				
			}
			else {
				customerOptionFrame.setVisible(true);
			}
			
			
		}
}

//JButton btnNewButton = new JButton("<html>Omelette");
//btnNewButton.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		
//	}
//});


}
