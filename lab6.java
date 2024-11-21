//MENDIOLA IVAN DAVE
//CITCS 1N-A CC2

import java.util.*;
public class lab6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total number of students: ");
        int totalStudents = sc.nextInt();
        sc.nextLine();  

        int present = 0;
        int absent = 0;

        // Using for loop to ask the student for their attendance
        for (int i = 1; i <= totalStudents; i++) {
            System.out.print("Is student " + i + " present? (Y/N): ");
            String attendance = sc.nextLine().trim().toUpperCase();

            // Step 3: Count present and absent students
            if (attendance.equals("Y")) {
                present++;
            } else if (attendance.equals("N")) {
                absent++;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
                i--;  
            }
        }

        // PRINTS OUT THE NUMBER OF STUDENTS ABSENT/PRESENT
        System.out.println("\nTotal present: " + present);
        System.out.println("Total absent: " + absent);
    }
}
