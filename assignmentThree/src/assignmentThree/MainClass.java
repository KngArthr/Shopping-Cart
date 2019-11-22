package assignmentThree;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;


public class MainClass {
	private static ShoppingCartOne shoppingCartOne;
	private static Cashier cashier;

	
	public static void main(String[] args) {
		
		Scanner scanKeyboard = new Scanner(System.in);
    	DecimalFormat df2 = new DecimalFormat("#.##");
    	
		String whichProgram = "0";
		
		String fileNameRead = "";
		String fileNameWrite = "";
		
		System.out.println ("Hello! Welcome to the shopping cart program!");
		System.out.println ("Enter the file name to write to. To use the provided file, just type groceryList5:");
		fileNameWrite = scanKeyboard.nextLine();
		System.out.println ("Enter 0 if you would like to read an already existing list (txt file). Enter any other key if you would like to read from the console:");
		
		//attribute for determining which program to run
		whichProgram = scanKeyboard.nextLine();
		
		if(whichProgram.equals("0")) {
			try {
				System.out.println ("Enter the file name to read from. To use the provided file, just type groceryList2:");
				fileNameRead = scanKeyboard.nextLine();
				shoppingCartOne = new ShoppingCartOne(fileNameRead);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//scanKeyboard = new Scanner(System.in);
			//System.out.println ("Enter the file name to write to. To use the provided file, just type groceryList5.");
			//fileNameWrite = scanKeyboard.nextLine();
			cashier = new Cashier(fileNameWrite, shoppingCartOne);
			//cashier.buyItems();
			
			System.out.println(shoppingCartOne.getUserName() + "'s Shopping Cart");
			System.out.println("You have $" + cashier.getBankAccountInitial() + " in the bank.");
			System.out.println("Grocery List:");
			cashier.printShoppingCartToConsole(shoppingCartOne);
			
			System.out.println ("Items Bought:");
			cashier.printItemClassArrayToConsole(cashier.getItemsBought());
			
			System.out.println ("Items Remaining:");
			cashier.printItemClassArrayToConsole(cashier.getItemsRemaining());
			System.out.println ("Post-Shopping Bank Account: " + Double.parseDouble(df2.format(Double.parseDouble(shoppingCartOne.getBankAccount()))));


		}else {
			try {
				shoppingCartOne = new ShoppingCartOne();
			} catch (UnsupportedFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			
			//fileNameWrite = scanKeyboard.nextLine();
			cashier = new Cashier(fileNameWrite, shoppingCartOne);
			//cashier.buyItems();
			System.out.println(shoppingCartOne.getUserName() + "'s Shopping Cart");
			System.out.println("You have $" + cashier.getBankAccountInitial() + " in the bank.");
			System.out.println("Grocery List:");
			cashier.printShoppingCartToConsole(shoppingCartOne);
			
			System.out.println ("Items Bought:");
			cashier.printItemClassArrayToConsole(cashier.getItemsBought());
			
			System.out.println ("Items Remaining:");
			cashier.printItemClassArrayToConsole(cashier.getItemsRemaining());
			System.out.println ("Bank Account Post-Shopping: " + Double.parseDouble(df2.format(Double.parseDouble(shoppingCartOne.getBankAccount()))));
			
		}
		
		scanKeyboard.close();
		
	
	}

}
