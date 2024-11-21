
import java.util.Scanner;
public class Lab5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		double priceBurger = 100, fries = 50, soda = 30, iceCream = 45;
		int userInput, qty;
		double total = 0;
		
		System.out.println("MENU");
		System.out.println("1. Burger ");
		System.out.println("2. Fries ");
		System.out.println("3. Soda ");
		System.out.println("4. IceCream ");
		System.out.println("5. Exit ");
		
		System.out.print("Enter the menu number of your choice: ");
		userInput = sc.nextInt();
		
		System.out.print("Enter the quantity: ");
		qty = sc.nextInt();
		
		
		switch(userInput) {
		case 1: 
			System.out.println("You ordered Burger.");
			total = priceBurger * qty; 
			break;
		
		case 2: 
			System.out.println("You ordered Fries.");
			total = fries * qty; 
			break;
		
		case 3: 
			System.out.println("You ordered Soda.");
			total = soda * qty; 
			break;
		
		case 4: 
			System.out.println("You ordered Ice Cream.");
			total = iceCream * qty;
			break;
		
		default: userInput = 5;
			System.out.println("Exit");
		}
		
		System.out.println("Total amount: PHP " +total);
	}

}
