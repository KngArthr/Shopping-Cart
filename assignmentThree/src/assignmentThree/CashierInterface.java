package assignmentThree;

import java.util.ArrayList;

public interface CashierInterface {
	
	
	public void buyItems();
	
	public void setItemsBought(ArrayList<ItemClass> itemsBought);
	public ArrayList<ItemClass> getItemsBought();
	
	public void setItemsRemaining(ArrayList<ItemClass> itemsRemaining);
	public ArrayList<ItemClass> getItemsRemaining();

	public void setBankAccountInitial(String bankAccountInitial);
	public String getBankAccountInitial();
	public void subtractBankAccount(String price);


}
