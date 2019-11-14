package assignmentThree;

import java.io.FileWriter;
import java.util.ArrayList;

public interface PrintOutputInterface {
	

	public void writeItemsToFile();
	
	public void printItemClassArrayToConsole(ArrayList<ItemClass> itemList);
	public void printShoppingCartToConsole(ShoppingCartOne shoppingCartOne);
	
	public void writeItemClassArrayToFile(ArrayList<ItemClass> itemList, FileWriter fileWriter);
	public void writeShoppingCartToFile(ShoppingCartOne shoppingCartOne, FileWriter fileWriter);

	
}
