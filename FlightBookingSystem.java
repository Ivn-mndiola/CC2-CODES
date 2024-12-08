//CC2
//MENDIOLA IVAN DAVE A.
import javax.swing.JOptionPane;

public class FlightBookingSystem {
    
    // Custom Exception
    public static class NoSeatsAvailableException extends Exception {
        public NoSeatsAvailableException(String message) {
            super(message);
        }
    }

    // Flight attributes
    private int totalSeats;
    private int bookedSeats;

    // Constructor to initialize total seats
    public FlightBookingSystem(int totalSeats) {
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    // Method to book a seat
    public void bookSeat() throws NoSeatsAvailableException {
        if (bookedSeats >= totalSeats) {
            throw new NoSeatsAvailableException("No seats available for booking.");
        }
        bookedSeats++;
    }

    // Method to get available seats
    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }

    // Main method to run the booking system
    public static void main(String[] args) {
        FlightBookingSystem flight = new FlightBookingSystem(5); // Example: Flight with 5 seats

        while (true) {
            String input = JOptionPane.showInputDialog("Enter 'book' to book a seat or 'exit' to quit:");

            if (input == null || input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.equalsIgnoreCase("book")) {
                try {
                    flight.bookSeat();
                    JOptionPane.showMessageDialog(null, "Seat booked successfully! Available seats: " + flight.getAvailableSeats());
                } catch (NoSeatsAvailableException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Booking Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter 'book' or 'exit'.");
            }
        }

        JOptionPane.showMessageDialog(null, "Thank you for using the flight booking system!");
    }
}