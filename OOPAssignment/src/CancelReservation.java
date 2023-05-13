
import java.util.ArrayList;
import java.util.Scanner;

public class CancelReservation {

    private Reservation[] reservations;
    private int numReservations;

    public CancelReservation(Reservation[] reservations, int numReservations) {
        this.reservations = reservations;
        this.numReservations = numReservations;
    }

    public Reservation[] getReservations() {
        return reservations;
    }

    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }

    public int getNumReservations() {
        return numReservations;
    }

    public void setNumReservations(int numReservations) {
        this.numReservations = numReservations;
    }

    public void cancelReservation() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            printMenu();
            System.out.print("                              Enter CustomerID: ");
            String custId = scanner.next();

            Customer customer = findCustomerById(custId);
            if (customer == null) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("                              Invalid CustomerID. No reservations found.");
                System.out.println("                              Please try again.");
                continue;
            }

            ArrayList<Reservation> customerReservations = customer.getReservation();

            System.out.println("Customer's Bookings:");
            for (int i = 0; i < customerReservations.size(); i++) {
                Reservation reservation = customerReservations.get(i);
                System.out.println((i + 1) + ". Booking ID: " + reservation.getResId());
            }

            System.out.print("Select a booking to cancel (enter the number): ");
            int selectedBookingIndex = scanner.nextInt();

            if (selectedBookingIndex < 1 || selectedBookingIndex > customerReservations.size()) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("                           Invalid selection. Please try again.");
                continue;
            }

            Reservation selectedReservation = customerReservations.get(selectedBookingIndex - 1);

            System.out.print("Are you sure you want to cancel booking ID "
                    + selectedReservation.getResId() + "? (Y/N): ");
            String confirmation = scanner.next();

            if (confirmation.equalsIgnoreCase("Y")) {
                cancelSelectedReservation(selectedReservation);
                System.out.println("==================================");
                System.out.println("Reservation canceled successfully.");
                System.out.println("==================================");
            } else {
                System.out.println("==================================");
                System.out.println("Reservation cancellation aborted.");
                System.out.println("==================================");
            }

            break;
        }
    }

    private void cancelSelectedReservation(Reservation reservation) {
        for (int i = 0; i < numReservations; i++) {
            if (reservations[i] == reservation) {
                System.arraycopy(reservations, i + 1, reservations, i, numReservations - i - 1);
                reservations[numReservations - 1] = null;
                numReservations--;
                break;
            }
        }
    }

    private Customer findCustomerById(String custId) {
        for (Reservation reservation : reservations) {
            Customer customer = reservation.getCustomer();
            if (customer.getCustId().equals(custId)) {
                return customer;
            }
        }
        return null;
    }
    private void printMenu() {
        System.out.println("  _____          _   _  _____ ______ _            _______ _____ ____  _   _");
        System.out.println(" / ____|   /\\   | \\ | |/ ____|  ____| |        /\\|__   __|_   _/ __ \\| \\ | |");
        System.out.println("| |       /  \\  |  \\| | |    | |__  | |       /  \\  | |    | || |  | |  \\| |");
        System.out.println("| |      / /\\ \\ | . ` | |    |  __| | |      / /\\ \\ | |    | || |  | | . ` |");
        System.out.println("| |____ / ____ \\| |\\  | |____| |____| |____ / ____ \\| |   _| || |__| | |\\  |");
        System.out.println(" \\_____/_/    \\_\\_| \\_|\\_____|______|______/_/    \\_\\_|  |_____\\____/|_| \\_|\n");
        System.out.println("-----------------------------------------------------------------------------------");
    }

}
