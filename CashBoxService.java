

/**
 * This class represent a Case Box Service - main method of the program
 * 
 * @author Lior Maimon 
 * mmn11 , Question 1
 */
import java.util.Scanner;
import java.util.ArrayList; //import to use array lists

public class CashBoxService {
	//main method 
	public static void main(String[] args){
		
		int index = 1; //use as index to the menu
		Scanner input = new Scanner(System.in); // create scanner to obtain input from command window
		
		System.out.println("Welcom to Cash Box Service ");
		while(index > 0 ){
			System.out.println("Please enter one of the following options:\n");
			System.out.println("0 - To exit \n1 - To open an empty CashBox \n2 - To open a non empty CashBox \n");
			index = input.nextInt(); //user input
			switch(index){ //continue as the user choose 
				case 1: {//open empty case box
					CashBox openCashBox = new CashBox();
					printMenu(openCashBox); //call method to print the menu
					break;
					
				}
				case 2:{//open cash box with start money
					double money; 
					System.out.println("How much money do you want in the Cash Box? Please enter the amount");
					money = input.nextDouble();//user input
					CashBox openCashBox = new CashBox(money);
					printMenu(openCashBox); //call method to print the menu
					break;
				}
				default:System.out.println("Program is finished. \nHave a Nice Day"); break;//error or exit
			}
		}
		
	}
	
	//method to print the user menu get an object type CashBox
	private static void printMenu(CashBox openCashBox){
		int index; //index to the menu
		int quantity; //the quantity of the items
		double price , //price of the item
			   money;  //money that got payed by the buyer
		Scanner input = new Scanner(System.in); //make new scanner for input
		Scanner StringInput = new Scanner(System.in); //make new scanner for input
		do{
			System.out.println("Please enter one of the following options:\n");
			System.out.print("0 - To exit \n1 - To add item to your shopping list \n2 - To get  an array of your items and display its content \n3 - To get the total amount of this buy \n");
			System.out.print("4 - To pay for this buy and get the receipt \n5 - To get the money amount in the cash box\n");
			index = input.nextInt();//user input
			switch(index){
			case 1: { //add an item to the shopping list
				System.out.println("Please enter the name of the item:");
				String name = StringInput.nextLine();//user input
				System.out.println("Please enter number of units:");
				quantity = input.nextInt();//user input
				System.out.println("Please enter the price for a unit:");
				price = input.nextDouble();//user input
				Items item = new Items(name , quantity , price);
				openCashBox.addItem(item); //add item to the list
				break;
			}
			case 2: { //get the item list array and print the item list with "name, quantity, price ,total price"
				ArrayList<Items> myItems = new ArrayList<Items>();
				myItems = openCashBox.getList();
				printList(myItems); //call method print list
				break;
				
			}
			case 3: {// get total price of this shopping list
				System.out.println("The total amount of this list is " + openCashBox.getBillAmount() + " NIS \n");
				break;
			}
			case 4: { //pay for the buy and get the receipt
				double change; //buyer change
				ArrayList<Items> myItems = new ArrayList<Items>();
				myItems = openCashBox.getList();
				System.out.println("Please enter your payment amount:\n");
				money = input.nextDouble();//user input
				change = openCashBox.getPay(money);
				if(change == -1){ //check for error
					index = 0;
					break;
				}
				System.out.println("Your change is " + change + " NIS\n");
				System.out.println("Your receipt: ");
				printList(myItems); //call method print list for printing the receipt
				break;
			}
			case 5: {//check the money in the cash box
				System.out.println("The amount of money in the cash box is " + openCashBox.getMoneySum() + " NIS\n");
				break;
			}
			default: openCashBox.clearList(); //clear the list and exit
				break;
				
			}
		}while(index > 0);//while not type "0"
	}
	//method to print the ArrayList of the item list
	private static void printList(ArrayList<Items> myList){
		String str = "Name\t\tQuantity\t\tPrice\t\tTotal Price \n";
		for(int item = 0 ; item < myList.size(); item++){
			str = str + myList.get(item) + "\n";
		}
		System.out.println(str);
	}
}










