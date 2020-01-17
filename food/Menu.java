package food;

import objects.*;
import people.*;
import java.util.ArrayList;


public class Menu {				//lists of all items on menu sorted by type
	
	public ArrayList<Item> beverages;
	public ArrayList<Item> appetizers;
	public ArrayList<Item> entrees;
	public ArrayList<Item> desserts;
	
	public Menu() {
		beverages = new ArrayList<Item>();
		appetizers = new ArrayList<Item>();
		entrees = new ArrayList<Item>();
		desserts = new ArrayList<Item>();
	}

}
