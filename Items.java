

/**
 * This class represent an Item
 * 
 * @author Lior Maimon 
 * mmn11 , Question 1
 */
public class Items {
	
	//instance variables
	private String name; //item name
	private int quantity; //item quantity
	private double price; //item price
	
	/**
	 * Construct a new item with the given name quantity and price
	 * @param itemName - the name of the item
	 * @param itemQuantity - the quantity of the item
	 * @param itemPrice - the item price
	 */
	public Items(String itemName , int itemQuantity , double itemPrice){ //constructor 
		name = itemName;
		quantity = itemQuantity;
		price = itemPrice;
	}
	
	/**
	 * Copy Constructor, make a copy of a given item
	 * @param item - represent the item we want to copy
	 */
	public Items(Items item){ //copy constructor 
		name = item.name;
		quantity = item.quantity;
		price = item.price;
	}
	/**
	 * set the name of the item
	 * @param itemName
	 */
	public void setName(String itemName){
		name = itemName;
	}
	/**
	 * Return the name of the item
	 * @return the name of the item
	 */
	public String getName(){
		return name;
	}
	/**
	 * set the quantity of the item
	 * @param itemQuantity
	 */
	public void setQuantity(int itemQuantity){
		quantity = itemQuantity;
	}
	/**
	 * Return the quantity of the item
	 * @return quantity of the item
	 */
	public int getQuantity(){
		return quantity;
	}
	/**
	 * set the price of the item
	 * @param itemPrice
	 */
	public void setPrice(double itemPrice){
		price = itemPrice;
	}
	/**
	 * Return item price
	 * @return the item price
	 */
	public double getPrice(){
		return price;
	}
	/**
	 * Return the total price of the item multiply by his quantity
	 * @return total item price 
	 */
	public double getTotalPrice(){//total price of quantity * price of an item
		return (quantity * price);
	}
	/**
	 * method toString
	 */
	public String toString(){
		return name + " \t\t" + quantity + " \t\t\t" + price + " \t\t" + (quantity * price);
	}
}
