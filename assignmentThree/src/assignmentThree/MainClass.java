package assignmentThree;

import java.util.Scanner;

public class MainClass {
	private static ShoppingCart runProgram = new ShoppingCart();
	

	public static void main(String[] args) {
		
		Scanner scanKeyboard = new Scanner(System.in);
		
		String whichProgram = "0";
		String fileName1 = "";
		String fileName2 = "";
		String bankAccountCheck ="";
		double bankAccount = 0;
		
		//fileName = "groceryList5";
		//runProgram.writeItemsFile(fileName);
		
		
		System.out.println ("Hello! Welcome to the shopping cart program!");
		System.out.println ("Enter 0 if you would like to use an already existing list (txt file). Enter any other key if you would like to write to a txt file.");
		
		//attribute for determining which program to run
		whichProgram = scanKeyboard.nextLine();
		
		
		//add and filter items to arrays
		//if whichProgram is 0 then take input from file
		if(whichProgram.equals("0")) {
			
			System.out.println ("Enter the file name to read from. To use the provided file, just type groceryList2.");
			fileName1 = scanKeyboard.nextLine();
			System.out.println ("Enter the file name to write to. To use the provided file, just type groceryList5.");
			fileName2 = scanKeyboard.nextLine();
			try {
				runProgram.addItemsFromFile(fileName1, fileName2);
			} catch (UnsupportedFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println ("What is your budget?");
			bankAccount = Double.parseDouble(scanKeyboard.nextLine());
			runProgram.purchaseItems(bankAccount);
			runProgram.createFinalFile(fileName2);

		}else {
			System.out.println ("What is your budget?");

			bankAccountCheck = scanKeyboard.nextLine();
			bankAccount = Double.parseDouble(bankAccountCheck);
			System.out.println ("Enter the file name to write to. To use the provided file, just type groceryList5.");
			fileName2 = scanKeyboard.nextLine();
			fileName1 = "TempList";
			runProgram.writeItemsFile(fileName1);
			//runProgram.addItemsFromFile(fileName1, fileName2);
			scanKeyboard.close();
			

			
			System.out.println ("bankAccount");

			runProgram.purchaseItems(bankAccount);
			runProgram.createFinalFile(fileName2);
			scanKeyboard.close();
			
		}
		//fileName = scanData.nextLine();
			

		
		//runProgram.writeItemsFile("groceryList5");
		//runProgram.addItemsFromFile("groceryList2");
		
		//if whichProgram is anything else then take input from console
		
		
		//After adding and filtering items, buy them
	
	}

}
