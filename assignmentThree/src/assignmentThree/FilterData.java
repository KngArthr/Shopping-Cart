package assignmentThree;

import java.util.ArrayList;

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
	public boolean checkDuplicate(ArrayList<ItemClass> itemList, String line) {
		
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
	//check a double to see if it is negative. If negative then return true
	public boolean checkPositive(String price) {
		
		boolean isNegative = false;
		
		if((Double.parseDouble(price)) < 0){
			
			isNegative = true;
		}
		
		return isNegative;			
	}
	
	//method to filter a string from anything but a-z and A-Z. Return filtered String.
	public String filterStringForHash(String input) {
		String inputProcessed = "";
		
		//inputProcessed = input.replaceAll("[^a-zA-Z%]","");
		inputProcessed = input.replaceAll("[#%]","");

		
		return inputProcessed;
	}
	
	public String filterStringOnlyAlpha(String input) {
		String inputProcessed = "";
		
		//inputProcessed = input.replaceAll("[^a-zA-Z%]","");
		inputProcessed = input.replaceAll("[^A-Za-z%]","");

		
		return inputProcessed;
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
	public boolean checkForExit(String exitCommand) {
		
		
		if(exitCommand.equals("#")) {
			return true;
		}
		
		else {
			return false;
		}
		
	}
	public boolean checkForDone(String doneCommand) {
		
		
		if(doneCommand.equals("&")) {
			return true;
		}
		
		else {
			return false;
		}
		
	}



}
