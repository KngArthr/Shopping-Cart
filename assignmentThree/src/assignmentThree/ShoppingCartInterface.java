package assignmentThree;

import java.io.File;
import java.util.ArrayList;

public interface ShoppingCartInterface {
	

	public void setItemList(ArrayList<ItemClass> itemList);
	
	public ArrayList<ItemClass> getItemList();

	
	public void setItemListSorted(ArrayList<ItemClass> itemListSorted);
	
	public ArrayList<ItemClass> getItemListSorted();
	
	
	public void setShoppingListFile(String fileName);
	
	public File getShoppingListFile();
	
	public void setBankAccount(String bankAccount);
	
	public String getBankAccount();
		
	public void setUserName(String userName);
	
	public String getUserName();


}
