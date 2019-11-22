package assignmentThree;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;


public class ShoppingCartOne implements ShoppingCartInterface{
	
	FilterData filterData = new FilterData();
	
	private String userName;
	private ArrayList<ItemClass> itemList;
	private ArrayList<ItemClass> itemListSorted;
	
	private File shoppingListFile;
	
	private String bankAccount;
	
	ShoppingCartOne() throws UnsupportedFormatException{
		userName = "N/A";
		itemList = new ArrayList<ItemClass>();
		itemListSorted = new ArrayList<ItemClass>();
		bankAccount = "0.00";
		String itemName;
		String itemPriority;
		String itemPrice;
		String itemQuantity;
		String itemUnit;
		
		
		int itemCounter = 0;
		Scanner scanData = new Scanner(System.in);
		
		System.out.println("Type # at any time to exit the program.");
		
		System.out.println("What is your name? Don't use #");
		userName = filterData.filterStringForHash(scanData.nextLine());
		
		System.out.println("What is your budget?");
		bankAccount = filterData.checkingPositive(scanData.nextLine());
		
		while(true) {
			
			System.out.println("Type & if you are done creating the list.");
			
			System.out.println("If you would like to continue, please enter the name of item number " + (itemCounter + 1));
			itemName = scanData.nextLine();
			filterData.checkingForExit(itemName);
			if(filterData.checkForDone(itemName)) {
				break;
			}
			//check item for duplicates and prompt for new entry until a unique item name is entered
			itemName = filterData.checkItemDuplicate(itemList, itemName, itemCounter);

			
			//take priority input
			System.out.println ("Please enter the priority  of item number " + (itemCounter + 1));
			itemPriority = scanData.nextLine();
			filterData.checkingForExit(itemPriority);
			//itemPriority = filterData.checkingForInteger(itemPriority);

			
			//take price input
			System.out.println ("Please enter the value of item number " + (itemCounter + 1));
			//check price input for positive double. Keep prompting for positive price until it is entered.
			itemPrice = scanData.nextLine();
			filterData.checkingForExit(itemPrice);
			//itemPrice = filterData.checkingForDouble(itemPrice);
			itemPrice = filterData.checkingPositive(itemPrice);		


			//take quantity input
			System.out.println("Please enter how many items you would like to purchase: ");
			itemQuantity = scanData.nextLine();
			filterData.checkingForExit(itemQuantity);
			//itemQuantity = filterData.checkingForInteger(itemQuantity);
			itemQuantity = filterData.checkingPositive(itemQuantity);		
			
			
			//take unit input
			System.out.println("Please enter the unit in which you would like to buy this item: ");
			itemUnit = scanData.nextLine();
			filterData.checkingForExit(itemUnit);
			itemUnit = filterData.filterStringOnlyAlpha(itemUnit);
	
			
			//System.out.println ("Slot " + (i + 1) + " contains item: " + itemName + " priority: " + itemPriority + " price: " + itemPrice);
			itemList.add(new ItemClass(itemName, Integer.parseInt(itemPriority), Double.parseDouble(itemPrice), Integer.parseInt(itemQuantity), itemUnit));
			
			//System.out.println ("Slot " + (i + 1) + " contains item: " + itemListV1[i].getItemName() + " priority: " + itemListV1[i].getPriority() + " price: " + itemListV1[i].getPrice());
			itemCounter++;
			
			
		}	
		scanData.close();

		//loop runs until user is done
		
		//order the array by priority
		itemListSorted.addAll(filterData.bubbleSortByPriority(itemList));
		
		//display list of items
		/*System.out.println(userName + "'s Shopping Cart");
		
		System.out.println(bankAccount + "$ is your budget");

		System.out.println("Grocery List:");
		for(int i = 0; i < itemList.size(); i++) {
			
			System.out.println ("Slot " + (i + 1) + " contains item: " + itemListSorted.get(i).getItemName() + " priority: " + itemListSorted.get(i).getPriority() + " price: " + itemListSorted.get(i).getPrice() + " Quantity: " + itemListSorted.get(i).getQuantity() + " " + itemListSorted.get(i).getUnit());
				
				
		}*/
		
		
	}
		







	ShoppingCartOne(String shoppingListFile) throws UnsupportedFormatException, FileNotFoundException{

		itemList = new ArrayList<ItemClass>();
		itemListSorted = new ArrayList<ItemClass>();
	
		this.shoppingListFile = new File(shoppingListFile);
		String itemName;
		String itemPriority;
		String itemPrice;
		String itemQuantity;
		String itemUnit;
		
		
		int itemCounter = 0;
		Scanner scanFile = new Scanner(this.shoppingListFile);
		Scanner scanData = new Scanner(System.in);
		
		System.out.println("What is your name? Don't use #");

		//userName = filterData.filterStringForHash(scanFile.nextLine());
		userName = filterData.filterStringForHash(scanData.nextLine());
		
		System.out.println("What is your budget: ");

		//bankAccount = scanFile.nextLine();
		bankAccount = filterData.checkingPositive(scanData.nextLine());
		
		while(scanFile.hasNextLine()) {
			
			itemName = scanFile.nextLine();
			filterData.checkingForExit(itemName);
			//check item for duplicates and prompt for new entry until a unique item name is entered
			itemName = filterData.itemDuplicateExit(itemList, itemName, itemCounter);

			
			//take priority input
			itemPriority = scanFile.nextLine();
			filterData.checkingForExit(itemPriority);
			//itemPriority = filterData.checkingForInteger(itemPriority);
			
			
			//take price input
			//check price input for positive double. Keep prompting for positive price until it is entered.
			itemPrice = scanFile.nextLine();
			filterData.checkingForExit(itemPrice);
			//itemPrice = filterData.checkingForDouble(itemPrice);
			if(filterData.checkPositive(itemPrice)){
				throw new UnsupportedFormatException("A number below 0 is not accepted.");
			}
				
			

			//take quantity input
			itemQuantity = scanFile.nextLine();
			filterData.checkingForExit(itemQuantity);
			//itemQuantity = filterData.checkingForInteger(itemQuantity);
			itemQuantity = filterData.checkingPositive(itemQuantity);		
			if(filterData.checkPositive(itemQuantity)){
				throw new UnsupportedFormatException("A number below 0 is not accepted.");
			}
			
			//take unit input
			itemUnit = scanFile.nextLine();
			filterData.checkingForExit(itemUnit);
			itemUnit = filterData.filterStringOnlyAlpha(itemUnit);
		
			
			
			
			//System.out.println ("Slot " + (itemCounter + 1) + " contains item: " + itemName + " priority: " + itemPriority + " price: " + itemPrice + " quantity: " + itemQuantity + " unit: " + itemUnit);
			itemList.add(new ItemClass(itemName, Integer.parseInt(itemPriority), Double.parseDouble(itemPrice), Integer.parseInt(itemQuantity), itemUnit));
			
			//System.out.println ("Slot " + (itemCounter + 1) + " contains item: " + itemListV1[i].getItemName() + " priority: " + itemListV1[i].getPriority() + " price: " + itemListV1[i].getPrice());
			itemCounter++;
			
			
		}	
		scanFile.close();

		//loop runs until user is done
		
		//order the array by priority
		itemListSorted.addAll(filterData.bubbleSortByPriority(itemList));
		
		//display list of items
	/*	System.out.println(userName + "'s Shopping Cart");
		System.out.println(bankAccount + "$ is your budget.");
		System.out.println("Grocery List:");
		for(int i = 0; i < itemList.size(); i++) {
			
			System.out.println ("Slot " + (i + 1) + " contains item: " + itemListSorted.get(i).getItemName() + " priority: " + itemListSorted.get(i).getPriority() + " price: " + itemListSorted.get(i).getPrice() + " Quantity: " + itemListSorted.get(i).getQuantity() + " " + itemListSorted.get(i).getUnit());
				
				
		}*/
		
		
		
		
	}

	
	
	public void setItemList(ArrayList<ItemClass> itemList) {
		this.itemList = itemList;
		
	}
	
	public ArrayList<ItemClass> getItemList() {
	
		return itemList;
	}
	
	
	public void setItemListSorted(ArrayList<ItemClass> itemListSorted) {
		this.itemListSorted = itemListSorted;
		
	}
	
	public ArrayList<ItemClass> getItemListSorted() {
		
		return itemListSorted;
	}
	
	
	public void setShoppingListFile(String fileName) {
		shoppingListFile = new File(fileName);
		
	}
	
	public File getShoppingListFile() {

		return shoppingListFile;
	}
	
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
		
	}
	
	public String getBankAccount() {
		return bankAccount;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
		
	}
	
	public String getUserName() {
		return userName;
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