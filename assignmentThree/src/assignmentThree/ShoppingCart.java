package assignmentThree;

import java.util.ArrayList;
import java.util.Scanner;
//import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.nio.file.*;
import java.io.*;

public class ShoppingCart implements PrintOutput{
		
		//private File file = new File("groceryList2");
		private FilterData filterData = new FilterData();
		private String itemCheck = "N/A";
		private String priorityCheck = "0";
		private String priceCheck = "0.00";
		private String quantityCheck = "0";
		private String unitCheck = "N/A";
		
		private String itemName = "N/A";
		private int itemPriority = 0;
		private double itemPrice = 0.00;
		private int itemQuantity = 0;
		private String itemUnit = "N/A";
		
		private String userName = "";

		private double bankAccountInitial = 0;
		private double bankAccountPost = 0;
		
		private ArrayList<ItemClass> itemList= new ArrayList<ItemClass>();
		private ArrayList<ItemClass> itemListSorted= new ArrayList<ItemClass>();
		private ArrayList<ItemClass> itemsBought= new ArrayList<ItemClass>();
		private ArrayList<ItemClass> itemsRemaining= new ArrayList<ItemClass>();
		

		private DecimalFormat df2 = new DecimalFormat("#.##");
		private File fileRead = null;

		private FileWriter fileWriter = null;

	
	    public void addItemsFromFile(String fileNameRead, String fileNameWrite) throws UnsupportedFormatException {
		
	    //try adding items to array from File
		try {
			File fileWrite = null;
			fileRead = new File(fileNameRead);
			fileWrite = new File(fileNameWrite);
			fileWriter = new FileWriter(fileWrite);
	
			
			
	        Scanner scanFile = new Scanner(fileRead);

			userName = filterData.filterStringForHash(scanFile.nextLine());
			int itemCounter = 0;
	        while(scanFile.hasNextLine()){
	        	// for loop to load array with 
					//checking if item is same as a previous item
	        		
					itemCheck = scanFile.nextLine();
					if (filterData.checkDuplicate(itemList, itemCheck)) {
						throw new UnsupportedFormatException("Please remove the following duplicate item in the text file:" + itemCheck);
						
						//System.out.println("Please remove duplicate items in the text file. System will now exit.");
						//System.exit(0);
					}else {
						//if everything adds up, give the item to the itemm attribute
						itemName = itemCheck;
					}
					
					
					
					//priority of the item
					priorityCheck = scanFile.nextLine();
					//remove priority check
					/*if (filterData.checkPriority(itemList, priorityCheck)) {
						System.out.println("Please remove duplicate priority in the text file. System will now exit.");
						System.exit(0);
					}else {
						
					}*/
					itemPriority = Integer.parseInt(priorityCheck);

					
					
					
					//check if price is a positive number
					priceCheck = String.valueOf(scanFile.nextLine());
					
					if (filterData.checkPositive(priceCheck)) {
						System.out.println("Please enter a price above zero for the item:" + itemName + " within the text file. System will now exit.");
						System.exit(0);
					}else {
						//if price is positive, give it to the price variable
						itemPrice = Double.parseDouble(df2.format(Double.parseDouble(priceCheck)));
					}
					
					quantityCheck = scanFile.nextLine();
					
					if (filterData.checkPositive(quantityCheck)) {
						System.out.println("Please enter a quantity above zero for the item:" + itemName + " within the text file. System will now exit.");
						System.exit(0);
					}else {
						//if price is positive, give it to the price variable
						itemQuantity = Integer.parseInt(quantityCheck);
					}
					
					
					//If commenting out fixes the null issue then fix the filter
					//unitCheck = filterData.filterStringOnlyAlpha(scanFile.nextLine());
					unitCheck = scanFile.nextLine();
					
					itemUnit = unitCheck;
					
					
					
					//item, priority, and price variables are added as an object to the itemList Array
					itemList.add(new ItemClass(itemName, itemPriority, itemPrice, itemQuantity, itemUnit));
					
					try {
						fileWriter.write(itemName + "\n");
						fileWriter.write(String.valueOf(itemPriority) + "\n");
		    			fileWriter.write(String.valueOf(itemPrice) + "\n");
		    			fileWriter.write(String.valueOf(itemQuantity) + "\n");
		    			fileWriter.write(itemUnit + "\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println ("Slot " + (itemCounter + 1) + " contains item: " + itemName + " priority: " + itemPriority + " price: " + itemPrice + " quantity: " + itemQuantity + " units: " + itemUnit);
					//System.out.println ("Slot " + (itemCounter + 1) + " contains item: " + itemList.get(itemCounter).getItemName() + " priority: " + itemList.get(itemCounter).getPriority() + " price: " + itemList.get(itemCounter).getPrice() + " Quantity: " + itemList.get(itemCounter).getQuantity() + " " + itemList.get(itemCounter).getUnit());

					itemCounter++;
		        	
		        }
	        
	        scanFile.close();
	        fileWriter.close();
	    } 
		//if the file is not found, trace stack
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*debugger
		 * for(int i = 0; i < itemListV1.length; i++) {
			System.out.println ("Slot " + (i + 1) + " contains item: " + itemListV1[i].getItemName() + " priority: " + itemListV1[i].getPriority() + " price: " + itemListV1[i].getPrice());

		}*/
		//if sum of prices is not at least a hundred, end the program
		/*if (filterData.checkOneHundred(itemList)) {
			System.out.println("Sum of prices must be greater than $100.00 in the text file. System will now exit.");
			System.exit(0);
		}*/

		//order the items by priority and give it back to the item array
		//itemListV1 = filterData.bubbleSortByPriority(itemListV1);
		
		itemListSorted.addAll(filterData.bubbleSortByPriority(itemList));
		
		//print the array, which is the list of items
        System.out.println(userName + "'s Shopping Cart");

		System.out.println("Grocery List:");
		for(int i = 0; i < itemList.size(); i++) {
			System.out.println ("Slot " + (i + 1) + " contains item: " + itemListSorted.get(i).getItemName() + " priority: " + itemListSorted.get(i).getPriority() + " price: " + itemListSorted.get(i).getPrice() + " Quantity: " + itemListSorted.get(i).getQuantity() + " " + itemListSorted.get(i).getUnit());

		}
		
		
	}
	    //add items to array from console input
	    public void writeItemsFile(String fileNameWrite) {
	    		int itemCounter = 1;
	    		File fileWrite = null;
	    		Scanner scanData = new Scanner(System.in);
	    		Scanner scanFile;
				
				fileWrite = new File(fileNameWrite);
				try {
					
					fileWriter = new FileWriter(fileWrite);
					//System.out.println("Please enter the item name: ");
					//fileWriter.write(scanData.nextLine());
					//fileWriter.flush();
				    //fileWriter.close();
					scanFile = new Scanner(fileWrite);
					System.out.println("Type # at any time to exit the program.");
					
					System.out.println("What is your name? Don't use #");

	    			userName = filterData.filterStringForHash(scanData.nextLine());
	    			fileWriter.write(userName + "\n");
	    			fileWriter.flush();
	    			System.out.println(scanFile.nextLine() + ". This name was written to the file.");

					while(true) {
						
						
						//System.out.println(scanFile.nextLine());
						System.out.println("Type & if you are done creating the list. If you would like to continue, please enter the name of item number " + itemCounter);
						itemCheck = scanData.nextLine();
		    			if(filterData.checkForExit(itemCheck)) {
							System.out.println("Exit command detected. Exiting...");
		    				System.exit(0);
		    			}if(filterData.checkForDone(itemCheck)) {
		    				break;
		    			}
		    			//check item for duplicates and prompt for new entry until a unique item name is entered
		    			while(filterData.checkDuplicate(itemList, itemCheck)) {
		    				System.out.println("This is a duplicate. Please re-enter the name.");
							itemCheck = scanData.nextLine();
		    			}
		    			
						itemName = itemCheck;

		    			fileWriter.write(itemName + "\n");
		    			fileWriter.flush();
		    			System.out.println(scanFile.nextLine() + ". This item was written to the file.");
						//itemName = itemCheck;
		    			
		    			
		    			
						//take priority input
		    			System.out.println ("Please enter the priority  of item number " + (itemCounter));
		    			priorityCheck = scanData.nextLine();
		    			if(filterData.checkForExit(priorityCheck)) {
							System.out.println("Exit command detected. Exiting...");
		    				System.exit(0);
		    			}
		    			/*while(filterData.checkPriority(itemList, priorityCheck)) {
		    				System.out.println("This is a duplicate Priority. Please re-enter the Priority.");
		    				itemPriority = Integer.parseInt(scanData.nextLine());
		    			}*/
		    			
		    			
		    			itemPriority = Integer.parseInt(priorityCheck);
		    			
						fileWriter.write(itemPriority + "\n");
						fileWriter.flush();
						System.out.println(scanFile.nextLine() + ". This priority was written to the file.");
							
		    			System.out.println ("Please enter the value of item number " + (itemCounter));
		    			
		    			
		    			
		    			//check price input for positive double. Keep prompting for positive price until it is entered.
		    			priceCheck = scanData.nextLine();
		    			if(filterData.checkForExit(priceCheck)) {
							System.out.println("Exit command detected. Exiting...");
		    				System.exit(0);
		    			}
		    			while(filterData.checkPositive(priceCheck)) {
		    				System.out.println("Please enter a price above zero for the item:" + itemName);
		    				priceCheck = String.valueOf(scanData.nextLine());	
		    			}
		    			itemPrice = Double.parseDouble(df2.format(Double.parseDouble(priceCheck)));			


						fileWriter.write(itemPrice + "\n");
						fileWriter.flush();
						System.out.println(scanFile.nextLine() + ". This price was written to the file.");
						
						
						System.out.println("Please enter how many items you would like to purchase: ");

						quantityCheck = scanData.nextLine();
		    			if(filterData.checkForExit(quantityCheck)) {
							System.out.println("Exit command detected. Exiting...");
		    				System.exit(0);
		    			}
		    			while(filterData.checkPositive(quantityCheck)) {
		    				System.out.println("Please enter a quantity above zero for the item:" + itemName);
		    				quantityCheck = String.valueOf(scanData.nextLine());
		    			}
		    			itemQuantity = Integer.parseInt(quantityCheck);		


						fileWriter.write(itemQuantity + "\n");
						fileWriter.flush();
						System.out.println(scanFile.nextLine() + ". This quantity was written to the file.");
						
						
						System.out.println("Please enter the unit in which would like to buy this item: ");
						unitCheck = filterData.filterStringOnlyAlpha(scanData.nextLine());
						
		    			if(filterData.checkForExit(unitCheck)) {
							System.out.println("Exit command detected. Exiting...");
		    				System.exit(0);
		    			}
		    			
		    	
		    			itemUnit = String.valueOf(unitCheck);


						fileWriter.write(itemUnit + "\n");
						fileWriter.flush();
						System.out.println(scanFile.nextLine() + ". The unit was written to the file.");
						
		    			//System.out.println ("Slot " + (i + 1) + " contains item: " + itemName + " priority: " + itemPriority + " price: " + itemPrice);
		    			itemList.add(new ItemClass(itemName, itemPriority, itemPrice, itemQuantity, itemUnit));
		    			
		    			//System.out.println ("Slot " + (i + 1) + " contains item: " + itemListV1[i].getItemName() + " priority: " + itemListV1[i].getPriority() + " price: " + itemListV1[i].getPrice());
		    			itemCounter++;
		    				
		    			
					}	
		    		scanFile.close();	
					scanData.close();
		    		fileWriter.close();

			
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	    		//loop runs for the length of the array
	    		
	    		
	    		//check array for a sum over $100
	    		/*if (filterData.checkOneHundred(itemList)) {
	    			System.out.println("Sum of prices must be greater than $100.00. Please restart the Program. System will now exit.");
	    			System.exit(0);
	    		}*/
	    		//order the array by priority
	    		
	    		itemListSorted.addAll(filterData.bubbleSortByPriority(itemList));
	    		
	    		//display list of items
	    		System.out.println(userName + "'s Shopping Cart");

	    		System.out.println("Grocery List:");
	    		for(int i = 0; i < itemList.size(); i++) {
	    			
	    			System.out.println ("Slot " + (i + 1) + " contains item: " + itemListSorted.get(i).getItemName() + " priority: " + itemListSorted.get(i).getPriority() + " price: " + itemListSorted.get(i).getPrice() + " Quantity: " + itemListSorted.get(i).getQuantity() + " " + itemListSorted.get(i).getUnit());
	    			
	    			
	    		}
	    		
	    }
	    //method to calculate which o buy and which are remaining
	    public void purchaseItems(double bankAcc) {
	    	//used to check iteration of itemsbought array
	    	int itemBoughtIteration = 0;
	    	int quantityRemaining = 0;
	    	int quantityBought = 0;
	    	this.bankAccountInitial = Double.parseDouble(df2.format(bankAcc));
	    	this.bankAccountPost = Double.parseDouble(df2.format(bankAcc));

	    	
	    	System.out.println("Bank Account: " + bankAccountInitial);
	    	//add items from item array to bought array. Deduct from budget based on what is bought
	    	for(int i = 0; i < itemListSorted.size(); i ++){
	    		
	    		//if the price is mroe or equal to bankaccount and the quantity is above zero, buy the item
	    		quantityRemaining = itemListSorted.get(i).getQuantity() - 1;
	    		quantityBought = 1;
	    		
	    		if((itemListSorted.get(i).getPrice() <= bankAccountPost) && (itemListSorted.get(i).getQuantity() > 0)) {
	    			
	    			if(itemListSorted.get(i).getQuantity() == 1) {
		    			itemsBought.add(itemListSorted.get(i));

	    			}else {
		    			//itemsBought.add(itemListSorted.get(i));
		    			itemsBought.add(new ItemClass(itemListSorted.get(i).getItemName(), itemListSorted.get(i).getPriority(), itemListSorted.get(i).getPrice(), quantityBought, itemListSorted.get(i).getUnit()));
    					bankAccountPost -= (itemListSorted.get(i).getPrice());

	    				while(quantityRemaining > 0) {
		    				if((itemListSorted.get(i).getPrice()) <= bankAccountPost) {
		    					quantityBought++;

		    					itemsBought.set(itemBoughtIteration, new ItemClass(itemListSorted.get(i).getItemName(), itemListSorted.get(i).getPriority(), itemListSorted.get(i).getPrice(), quantityBought, itemListSorted.get(i).getUnit()));
		    					
		    					bankAccountPost -= (itemListSorted.get(i).getPrice());
				    			quantityRemaining--;
				    			/*System.out.println("Items Bought: Test");
		    			    	for(int j = 0; j < itemsBought.size(); j++) {
		    		    			System.out.println ("Slot " + (j + 1) + " contains item: " + itemsBought.get(j).getItemName() + " priority: " + itemsBought.get(j).getPriority() + " price: " + itemsBought.get(j).getPrice() + " Quantity: " + itemsBought.get(j).getQuantity() + " " + itemsBought.get(j).getUnit());

		    		    		}*/
		    				}else {
		    					itemsRemaining.add(new ItemClass(itemListSorted.get(i).getItemName(), itemListSorted.get(i).getPriority(), itemListSorted.get(i).getPrice(), quantityRemaining, itemListSorted.get(i).getUnit()));
		    					break;
		    				}
	    			}
	    		
	    			
	    				
	    				
	    			}
	    			itemBoughtIteration++;
	    	
	    		}else {
	    			//those that are not bought get placed into the items remaining array
	    			itemsRemaining.add(itemListSorted.get(i));

	    		}
	    		
	    	}
	    	
	    	//print everything from items bought array
	    	System.out.println("Items Bought:");
	    	for(int i = 0; i < itemsBought.size(); i++) {
    			System.out.println ("Slot " + (i + 1) + " contains item: " + itemsBought.get(i).getItemName() + " priority: " + itemsBought.get(i).getPriority() + " price: " + itemsBought.get(i).getPrice() + " Quantity: " + itemsBought.get(i).getQuantity() + " " + itemsBought.get(i).getUnit());

    		}    	
	    	
	    	//print everything from items remaining array
	    	System.out.println("Items Remaining:");
	    	for(int i = 0; i < itemsRemaining.size(); i++) {
	    		
    			System.out.println ("Slot " + (i + 1) + " contains item: " + itemsRemaining.get(i).getItemName() + " priority: " + itemsRemaining.get(i).getPriority() + " price: " + itemsRemaining.get(i).getPrice() + " Quantity: " + itemsRemaining.get(i).getQuantity() + " " + itemsRemaining.get(i).getUnit());

    		}
	    	System.out.println("Bank Account Post Shopping: " + Double.parseDouble(df2.format(bankAccountPost)));
	    }
	    public void createFinalFile(String fileNameWrite) {
	    	
    		
			
	    	try {
	    		File file = new File(fileNameWrite);
	    		FileWriter fileWrite = new FileWriter(file);
	    		
	    		fileWrite.write(userName + "'s Shopping Cart\n");

	    		fileWrite.write("Bank Account: " + bankAccountInitial + "\n");

	    		fileWrite.write("Item List:" + "\n");

	    		for(int i = 0; i < itemListSorted.size(); i++) {
	    			
	   
	    			fileWrite.write ("Slot " + (i + 1) + " contains item: " + itemListSorted.get(i).getItemName() + " priority: " + itemListSorted.get(i).getPriority() + " price: " + itemListSorted.get(i).getPrice() + " quantity: " + itemListSorted.get(i).getQuantity() + " " + itemListSorted.get(i).getUnit() + "\n");

	    		}
	    		
	    		fileWrite.write("Items Bought:" + "\n");
		    	for(int i = 0; i < itemsBought.size(); i++) {
	    			fileWrite.write ("Slot " + (i + 1) + " contains item: " + itemsBought.get(i).getItemName() + " priority: " + itemsBought.get(i).getPriority() + " price: " + itemsBought.get(i).getPrice() + " quantity: " + itemsBought.get(i).getQuantity() + " " + itemsBought.get(i).getUnit() + "\n");


	    		}    	
		    	
		    	//print everything from items remaining array
		    	fileWrite.write("Items Remaining:" + "\n");
		    	for(int i = 0; i < itemsRemaining.size(); i++) {
		    		fileWrite.write ("Slot " + (i + 1) + " contains item: " + itemsRemaining.get(i).getItemName() + " priority: " + itemsRemaining.get(i).getPriority() + " price: " + itemsRemaining.get(i).getPrice() + " quantity: " + itemsRemaining.get(i).getQuantity() + " " + itemsRemaining.get(i).getUnit() + "\n");

	    		}
		    	fileWrite.write("Bank Account Post-Shopping: " + Double.parseDouble(df2.format(bankAccountPost)));
				fileWrite.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
		/*if(itemListSorted.get(i).getQuantity() > 1) {
		for(int j = 2; j <= itemListSorted.get(i).getQuantity(); j++) {
			
			if((itemListSorted.get(i).getPrice()) <= bankAccountPost) {
				
				
				itemsBought.set(itemBoughtCounter, new ItemClass(itemsBought.get(i).getItemName(), itemsBought.get(i).getPriority(), itemsBought.get(i).getPrice(), j, itemsBought.get(i).getUnit()));
				
    			this.bankAccountPost -= (itemListSorted.get(i).getPrice());
				
				
			}else {
				
				
				break;
			}
			
			
		}
		
	}*/
	
}
