//CC2
//IVAN DAVE MENDIOLA

package FinalChallenge3;
import java.util.*;
public class FinalChallenge3 {

	public static void main(String[] args) {
		
		// Number of students and subjects
        int column = 5, rows = 3;

        // Array to store student names
        String[] names = new String[column];

        // 2D array to store student grades
        int[][] grades = new int[column][rows];

        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Input student names
        for (int students = 0; students < names.length; students++) {
            System.out.println("Enter student " + (students + 1) + " name: ");
            names[students] = sc.nextLine();
        }

        // Input grades for each student
        for (int i = 0; i < column; i++) {
            System.out.println("\nEnter grades for student: " + names[i] + ":");
            for (int j = 0; j < rows; j++) {
                System.out.println("Subject " + (j + 1) + ": ");
                grades[i][j] = sc.nextInt();
            }
        }

        // Calculate and display average grades per student
        System.out.println("\nAverage grades per student: ");
        for (int i = 0; i < column; i++) {
            int sum = 0;

            // Calculate the sum of grades for the current student
            for (int j = 0; j < rows; j++) {
                sum += grades[i][j];
            }

            // Calculate average
            double average = (double) sum / rows; // Cast to double for decimal precision
            System.out.println(names[i] + "'s average grade: " + average);
        }

        // Close the scanner
        sc.close();
	}

}
