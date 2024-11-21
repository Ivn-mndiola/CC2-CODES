//IVAN DAVE MENDIOLA
//CC2 CITCS 1N-A

import java.util.Scanner;

public class lab7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // ask user to input password
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // ask user to input again if input is invalid
        while (true) {
            // nested if
            if (password.length() >= 8 
                    && password.matches(".*[A-Z].*") // check for at least one uppercase letter
                    && password.matches(".*[0-9].*")) { // check for at least one digit
                System.out.println("Valid Password.");
                break;
            } else {
                System.out.println("Invalid Password. Password must contain at least 8 characters, an uppercase letter, and a digit.");
                System.out.print("Enter Password: ");
                password = sc.nextLine(); // prompt for re-entry
            }
        }
        
    }
}



