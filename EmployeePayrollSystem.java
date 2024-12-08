class Employee {
    // Attributes
    private String employeeID;
    private String name;
    private double hourlyWage;
    private double hoursWorked;

    // Constructor
    public Employee(String employeeID, String name, double hourlyWage, double hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    // Method to calculate the salary
    public double calculateSalary() {
        return hourlyWage * hoursWorked;
    }

    // Method to display employee details in the specified format
    public void displayEmployeeDetails() {
        System.out.println("Employee:");
        System.out.println("     ID: " + employeeID);
        System.out.println("     Name: " + name);
        System.out.println("     Hourly Wage: " + hourlyWage);
        System.out.println("     Hours Worked: " + hoursWorked);
        System.out.println();
    }

    // Method to display formatted employee summary
    public String getEmployeeSummary() {
        return "ID: " + employeeID + ", Name: " + name + ", Wage: " + hourlyWage + 
               ", Hours Worked: " + (int) hoursWorked + ", Salary: " + String.format("%.1f", calculateSalary());
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        // Creating Employee objects
        Employee employee1 = new Employee("E001", "Alice Go", 15.0, 160);
        Employee employee2 = new Employee("E002", "Bob Hann", 18.0, 150);

        // Displaying individual employee details first
        System.out.println("Employee 1:");
        employee1.displayEmployeeDetails();

        System.out.println("Employee 2:");
        employee2.displayEmployeeDetails();

        // Printing salary calculations and final summary
        System.out.println("Calculating salaries...");
        System.out.println();
        System.out.println("Employee Details:");
        System.out.println(employee1.getEmployeeSummary());
        System.out.println(employee2.getEmployeeSummary());
    }
}
