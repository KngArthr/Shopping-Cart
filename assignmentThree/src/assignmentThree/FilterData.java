package assignmentThree;

import java.util.ArrayList;
import java.util.Scanner;

public class FilterData extends SortClass {
	
	
	//order objects in array by priority from highest to lowest
	
	
	//add up prices from array. Return true if less than hundred. Return false if greater than hundred
	public boolean checkOneHundred(ArrayList<ItemClass> itemList) {
		
		double priceSum = 0;
		
		boolean isOneHundred = false;
		
		for(int z = 0; z < itemList.size(); z++) {
			/*System.out.println ("Iteration " + z);
			System.out.println ("Previous Item Name " + itemList[z].getItemName());
			System.out.println ("New Item Name " + line);*/
			priceSum += itemList.get(z).getPrice();

		}
		
		if(priceSum < 100){
			
			isOneHundred = true;
		}
		
		return isOneHundred;
				
	}
	//Check array for duplicates item based on how much array is filled and which new string is being added.
	public String checkItemDuplicate(ArrayList<ItemClass> itemList, String stringInput, int slot) {
		Scanner scanData = new Scanner(System.in);
		if(slot > 0) {
		while(checkDuplicate(itemList, stringInput)) {
			System.out.println("This is a duplicate. Please re-enter the name.");
			stringInput = scanData.nextLine();
		}
		//scanData.close();
		}
		return stringInput;
	}
	public String itemDuplicateExit(ArrayList<ItemClass> itemList, String stringInput, int slot) {
		for(int z = 0; z < itemList.size(); z++) {
			/*System.out.println ("Iteration " + z);
			System.out.println ("Previous Item Name " + itemList[z].getItemName());
			System.out.println ("New Item Name " + line);*/
			if(itemList.get(z).getItemName().equals(stringInput)){
				System.out.println("There appears to be a duplicate item. Please re-create your text file. System will now Exit....");

				System.exit(0);
			}
	
		}
		return stringInput;

	}
	
	
	public boolean checkDuplicate(ArrayList<ItemClass> itemList, String stringInput) {
		
		boolean isDuplicate = false;
		
		for(int z = 0; z < itemList.size(); z++) {
			/*System.out.println ("Iteration " + z);
			System.out.println ("Previous Item Name " + itemList[z].getItemName());
			System.out.println ("New Item Name " + line);*/
			if(itemList.get(z).getItemName().equals(stringInput)){
				
				isDuplicate = true;
			}
				
		}
		
		
		return isDuplicate;
	}
	//check a double to see if it is negative. If negative then return true
	public boolean checkPositive(String stringDouble) {
		
		boolean isNegative = false;
		
		if((Double.parseDouble(stringDouble)) < 0){
			
			isNegative = true;
		}
		
		return isNegative;			
	}
	//Asks for new value if initial value is negative. Returns resulting positive value
	public String checkingPositive(String stringDouble) {
		Scanner scanData = new Scanner(System.in);
		
		while(Double.parseDouble(stringDouble) < 0) {
			System.out.println("Please enter a value above zero:");
			stringDouble = String.valueOf(scanData.nextLine());	
		}
		//scanData.close();
		
		return stringDouble;			
	}
	
	//method to filter a string from anything but a-z and A-Z. Return filtered String.
	public String filterStringForHash(String stringInput) {
		String inputProcessed = "";
		
		//inputProcessed = input.replaceAll("[^a-zA-Z%]","");
		inputProcessed = stringInput.replaceAll("[#]","");

		
		return inputProcessed;
	}
	
	public String filterStringOnlyAlpha(String stringInput) {
		String inputProcessed = "";
		
		//inputProcessed = input.replaceAll("[^a-zA-Z%]","");
		inputProcessed = stringInput.replaceAll("[^A-Za-z]","");

		
		return inputProcessed;
	}
	public boolean checkStringOnlyAlpha(String stringInput) {
		
		//inputProcessed = input.replaceAll("[^a-zA-Z%]","");
		/*if(stringInput.indexOf("%[^a- zA-Z]%") > -1) {
			return true;
		}*/
		if(stringInput.matches("[a-zA-Z]")) {
			return true;
		}else {
			return false;

		}

		
	}
	
	//Method to check for duplicate priority
	public boolean checkPriority(ArrayList<ItemClass> itemList, String incomingPriority) {
		boolean isDuplicatePriority = false;
		
		for(int z = 0; z < itemList.size(); z++) {
			
			if(itemList.get(z).getPriority() == Integer.parseInt(incomingPriority)){
				
				isDuplicatePriority = true;
			}
				
		}
		
		
		return isDuplicatePriority;
	}
	
	/*public String checkingForInteger(String stringInput) {
		Scanner scanData = new Scanner(System.in);
		String poop;
		
		while(stringInput.getClass() == int.class) {//Make this useful for checking files too.//You were debugging your shoppingcart
			System.out.println("Please enter an Integer:");
			stringInput = String.valueOf(scanData.nextLine());	
		}
		//scanData.close();
		
		return stringInput;		
	}*/
	/*public String checkingForDouble(String stringInput) {
		Scanner scanData = new Scanner(System.in);
		
		
		while(!(scanData.hasNextDouble())) {
			System.out.println("Please enter a decimal number:");
			stringInput = scanData.nextLine();	
		}
		//scanData.close();
		
		return stringInput;		
	}*/
	
	
	
	
	
	
	public boolean checkForExit(String stringInput) {
		
		
		if(stringInput.equals("#")) {
			return true;
		}
		
		else {
			return false;
		}
		
	}
	public void checkingForExit(String stringInput) {
		
		
		if(stringInput.equals("#")) {
			System.out.println("Exit command detected. Exiting...");
			System.exit(0);
		}
		
		
	}
	
	public boolean checkForDone(String stringInput) {
		
		
		if(stringInput.equals("&")) {
			return true;
		}
		
		else {
			return false;
		}
		
	}
	



}
