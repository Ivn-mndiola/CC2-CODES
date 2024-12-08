//CC2
//IVAN DAVE A MENDIOLA


package FinalChallenge2;

import java.util.Scanner;

public class FinalChallenge2 {
	public static void main (String[]args) {
		// Scanner for user input
		Scanner scanner = new Scanner(System.in);
        
		// Constants for the number of cities and days
        final int CITIES = 3;
        final int DAYS = 7;
        
        // 2D array to store temperatures
        double[][] temperatures = new double[CITIES][DAYS];
        
        // Input temperature data
        System.out.println("Enter the daily temperatures for each city:");
        for (int city = 0; city < CITIES; city++) {
            System.out.println("City " + (city + 1) + ":");
            for (int day = 0; day < DAYS; day++) {
                System.out.print("Day " + (day + 1) + ": ");
                temperatures[city][day] = scanner.nextDouble();
            }
        }
        
        // Calculate average temperature and highest temperature for each city
        for (int city = 0; city < CITIES; city++) {
            double total = 0;
            double highest = Double.MIN_VALUE;
            
            for (int day = 0; day < DAYS; day++) {
                total += temperatures[city][day];
                if (temperatures[city][day] > highest) {
                    highest = temperatures[city][day];
                }
            }
            
            double average = total / DAYS;
            System.out.println("\nCity " + (city + 1) + " Summary:");
            System.out.printf("Average Temperature: %.2f°C\n", average);
            System.out.println("Highest Temperature: " + highest + "°C");
        }
        
    }
}

