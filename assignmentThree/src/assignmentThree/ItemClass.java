package assignmentThree;

import java.util.ArrayList;

public class ItemClass implements ItemInterface{
	
	private String itemName;
	private int itemPriority;
	private double itemPrice;
	private int itemQuantity;
	private String itemUnit;
	
	//default constructor
	ItemClass() {
		
		itemName = "N/A";
		itemPriority = 0;
		itemPrice = 0;
		itemQuantity = 0;
		itemUnit = "N/A";
	}
	
	//not default constructor
	ItemClass(String itemName, int priority, double price, int quantity, String unit) {
			
		this.itemName = itemName;
		itemPriority = priority;
		itemPrice = price;
		itemQuantity = quantity;
		itemUnit = unit;
			
	}
	//rest of getters and setters are pretty self-explanatory
	public void setItemName(String name) {
		itemName = name;
		
	}
	
	public String getItemName() {

		return itemName;
	}
	
	public void setPriority(int priority) {
		itemPriority = priority;
		
	}
	
	public int getPriority() {

		return itemPriority;
	}
	
	public void setPrice(double price) {
		itemPrice = price;
		
	}
	
	public double getPrice() {

		return itemPrice;
	}
	
	public void setQuantity(int quantity) {
		itemQuantity = quantity;
		
	}
	
	public int getQuantity() {

		return itemQuantity;
	}
	
	
	public void setUnit(String unit) {
		itemUnit = unit;
		
	}
	
	public String getUnit() {

		return itemUnit;
	}
	

	
	
	
	public boolean equalsMethod(ArrayList<ItemClass> itemList, String line) {
		
		boolean isDuplicate = false;
		
		for(int z = 0; z < itemList.size(); z++) {
			/*System.out.println ("Iteration " + z);
			System.out.println ("Previous Item Name " + itemList[z].getItemName());
			System.out.println ("New Item Name " + line);*/
			if(itemList.get(z).getItemName().equals(line)){
				
				isDuplicate = true;
			}
			
				
		}
		return isDuplicate;
	}

	
	
}
