//IVAN DAVE A. MENDIOLA
//CC2 CITCS-1N-A


import java.util.Scanner;
public class lab4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//We ask the user for their input
		System.out.print("Enter the total purchase amount: PHP ");
	    
		//declaring variables
		float totalAmount = sc.nextFloat();
	    float discount = 0.0f;
	    float finalPrice;
	    
	    // if else statement
	    if (totalAmount < 1000) {
	        discount = 0.0f;
	    } else if (totalAmount >= 1000 && totalAmount <= 5000) {
	        discount = 0.05f; // 5% discount
	    } else if (totalAmount >= 5001 && totalAmount <= 10000) {
	        discount = 0.10f; // 10% discount
	    } else if (totalAmount >= 10000) {
	        discount = 0.15f; // 15% discount
	    }
		
		//Calculating the discountAmount and the final price
		float discountAmount = totalAmount * discount;
    	finalPrice = totalAmount - discountAmount;

	    
	    System.out.println("Discount applied: " + (discount * 100) + "%");
	    System.out.printf("Final price after discount: PHP %.2f ", + finalPrice);
        
	}
}