

/**
 * This class represent a Cash Box
 * 
 * @author Lior Maimon 
 * mmn11 , Question 1
 */
import java.util.ArrayList; //import to use array lists

public class CashBox {
	//instance variables
	private double money ; //the amount of money in the cash box
	private ArrayList<Items> itemList; //the list of items in the current buy
	
	/**
	 * empty constructor, initialize the money to zero and make an empty item list
	 */
	public CashBox(){
		money = 0;
		itemList = new ArrayList<Items>();
	}
	/**
	 * construct a new CashBox with given amount of start money,
	 * make a new empty item list
	 * @param startMoney - the amount of money the cash box start with
	 */
	public CashBox(double startMoney){
		money = startMoney;
		itemList = new ArrayList<Items>();
	}
	/**
	 * Add an item to the current shopping list
	 * @param item - The item to add to the list
	 */
	public void addItem(Items item){
		itemList.add(item);
	}
	/**
	 * Return a copy of the current shopping list
	 * @return an ArrayList<Items> that represent copy of the item list
	 */
	public ArrayList<Items> getList(){ 
		ArrayList<Items> copyList = new ArrayList<Items>();
		for(int ind = 0 ; ind < itemList.size(); ind++){
			Items item = new Items(itemList.get(ind));
			copyList.add(item);
		}
		return copyList;
	}
	/**
	 * Return the current list price
	 * @return a double that represent the amount of money the item list cost
	 */
	public double getBillAmount(){ 
		double amount = 0;
		
		for(int item = 0 ; item < itemList.size() ; item++){
			amount += itemList.get(item).getTotalPrice();
		}
		return amount;
	}
	/**
	 * method that get payment, clear the item list and return the change
	 * @param payment represent the money we receive from the buyer
	 * @return in success return the change to this buy on failure return -1
	 */
	public double getPay(double payment){//get the pay and return the change
		double billAmount = getBillAmount();
		if(payment < billAmount){
			System.out.println("You are missing " + (billAmount - payment) + " NIS" );
		}
		else if(money < (payment - billAmount)){
			System.out.println("There is not enought money in the cash Box for the change");
		}
		else{
			itemList.clear();
			money += billAmount;
			return (payment - billAmount);
		}
		return -1; // something went wrong - not enough money in the cash box or did not pay enough
	}
	/**
	 * Return the amount of money in the case box
	 * @return money represent the amount of it in the cash box
	 */
	public double getMoneySum(){// return the money in the cash box
		return money;
	}
	/**
	 * method to clear the current item list
	 */
	public void clearList(){ //clean the shopping list 
		itemList.clear();
	}
}
