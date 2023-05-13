
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
            System.out.print("                          Enter CustomerID: ");
            String custId = scanner.next();

            Reservation[] customerReservations = findReservationsByCustomerId(custId);
            if (customerReservations.length == 0) {
                System.out.println("                                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("                                Invalid CustomerID. No reservations found.");
                System.out.println("                                Please try again.");
                continue;
            }

            System.out.println("Customer's Bookings:");
            for (int i = 0; i < customerReservations.length; i++) {
                Reservation reservation = customerReservations[i];
                System.out.println((i + 1) + ". Booking ID: " + reservation.getResId());
            }

            System.out.print("Select a booking to cancel (enter the number): ");
            int selectedBookingIndex = scanner.nextInt();

            if (selectedBookingIndex < 1 || selectedBookingIndex > customerReservations.length) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("Invalid selection. Please try again.");
                continue;
            }

            Reservation selectedReservation = customerReservations[selectedBookingIndex - 1];

            System.out.print("Are you sure you want to cancel booking ID "
                    + selectedReservation.getResId() + "? (Y/N): ");
            String confirmation = scanner.next();

            if (confirmation.equalsIgnoreCase("Y")) {
                cancelSelectedReservation(selectedReservation);
                System.out.println("Reservation canceled successfully.\n");
            } else {
                System.out.println("Reservation cancellation aborted.\n");
            }

            break;
        }
    }

    private void cancelSelectedReservation(Reservation reservation) {
        for (int i = 0; i < numReservations; i++) {
            if (reservations[i] == reservation) {
                for (int j = i + 1; j < numReservations; j++) {
                    reservations[j - 1] = reservations[j];
                }
                reservations[numReservations - 1] = null;
                numReservations--;
                break;
            }
        }
    }

    private Reservation[] findReservationsByCustomerId(String custId) {
        Reservation[] customerReservations = new Reservation[numReservations];
        int count = 0;
        for (int i = 0; i < numReservations; i++) {
            Reservation reservation = reservations[i];
            if (reservation.getCustName().getCustId().equals(custId)) {
                customerReservations[count] = reservation;
                count++;
            }
        }
        Reservation[] result = new Reservation[count];
        System.arraycopy(customerReservations, 0, result, 0, count);
        return result;
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