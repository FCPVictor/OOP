
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ModifyReservation {

    private Reservation reservation;

    public ModifyReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }




    public void modifyCheckInDate(LocalDate checkInDate) {
        LocalDate currentCheckInDate = reservation.getCheckindate();
        LocalDate currentCheckOutDate = reservation.getCheckoutdate();

        int currentNumOfDays = (int) (currentCheckOutDate.toEpochDay() - currentCheckInDate.toEpochDay()) + 1;

        int numOfDays = (int) (currentCheckOutDate.toEpochDay() - checkInDate.toEpochDay()) + 1;
        double pricePerDay = reservation.getRoom().getPrice();
        double additionalCost = (numOfDays - currentNumOfDays) * pricePerDay;

        reservation.setCheckindate(checkInDate);
        reservation.calNumDays();
        reservation.calTotalRoomPrice();
    }

    public void modifyCheckOutDate(LocalDate checkOutDate) {
        LocalDate currentCheckInDate = reservation.getCheckindate();
        LocalDate currentCheckOutDate = reservation.getCheckoutdate();

        int currentNumOfDays = (int) (currentCheckOutDate.toEpochDay() - currentCheckInDate.toEpochDay()) + 1;

        int numOfDays = (int) (checkOutDate.toEpochDay() - currentCheckInDate.toEpochDay()) + 1;
        double pricePerDay = reservation.getRoom().getPrice();
        double additionalCost = (numOfDays - currentNumOfDays) * pricePerDay;

        reservation.setCheckoutdate(checkOutDate);
        reservation.calNumDays();
        reservation.calTotalRoomPrice();
    }

    public void makeChanges() {
        Scanner scanner = new Scanner(System.in);

        printModify();
        System.out.println("1. Check-in date");
        System.out.println("2. Check-out date");
        System.out.print("Choose the modification you want to make:");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter the new check-in date (YYYY-MM-DD):");
                LocalDate newCheckInDate = readValidCheckInDate(scanner, reservation.getCheckoutdate());
                modifyCheckInDate(newCheckInDate);
                break;
            case 2:
                System.out.print("Enter the new check-out date (YYYY-MM-DD):");
                LocalDate newCheckOutDate = readValidCheckOutDate(scanner, reservation.getCheckindate());
                modifyCheckOutDate(newCheckOutDate);
                break;

            default:
                System.out.println("Invalid choice. No modifications made.");
                break;
        }

        System.out.println("Reservation modified successfully.");
    }

    private LocalDate readValidCheckInDate(Scanner scanner, LocalDate currentCheckOutDate) {
        LocalDate date = null;
        boolean validDate = false;
        LocalDate minDate = LocalDate.parse("2023-06-01");
        LocalDate maxDate = LocalDate.parse("2023-06-07");

        while (!validDate) {
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input);
                if (date.isEqual(reservation.getCheckindate())) {
                    System.out.println("The new check-in date cannot be the same as the old check-in date.");
                    System.out.print("Please enter a different date: ");
                    continue;
                }
                if (date.isEqual(minDate) || (date.isAfter(minDate) && date.isBefore(currentCheckOutDate))) {
                    validDate = true;
                } else {
                    System.out.println("Invalid date. Please enter a date between " + minDate + " and the current check-out date (" + currentCheckOutDate + ").");
                    System.out.print("Please enter a different date: ");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
                System.out.print("Please enter a different date: ");
            }
        }
        return date;
    }

    private LocalDate readValidCheckOutDate(Scanner scanner, LocalDate currentCheckInDate) {
        LocalDate date = null;
        boolean validDate = false;
        LocalDate minDate = LocalDate.parse("2023-06-01");
        LocalDate maxDate = LocalDate.parse("2023-06-07");

        while (!validDate) {
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input);
                if (date.isEqual(reservation.getCheckoutdate())) {
                    System.out.println("The new check-out date cannot be the same as the old check-out date.");
                    System.out.print("Please enter a different date: ");
                    continue;
                }
                if (date.isEqual(maxDate) || (date.isAfter(currentCheckInDate) && date.isBefore(maxDate))) {
                    validDate = true;
                } else {
                    System.out.println("Invalid date. Please enter a date between the current check-in date (" + currentCheckInDate + ") and " + maxDate + ".");
                    System.out.print("Please enter a different date: ");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
                System.out.print("Please enter a different date: ");
            }
        }
        return date;
    }

    private void printModify() {
        System.out.println("****************************************************************************************");
        System.out.println("*               __  __  ____  _____ _____ ________     __                              *");
        System.out.println("*              |  \\/  |/ __ \\|  __ \\_   _|  ____\\ \\   / /                              *");
        System.out.println("*              | \\  / | |  | | |  | || | | |__   \\ \\_/ /                               *");
        System.out.println("*              | |\\/| | |  | | |  | || | |  __|   \\   /                                *");
        System.out.println("*              | |  | | |__| | |__| || |_| |       | |                                 *");
        System.out.println("*  _____  _____|_|__|_|\\____/|_____/_____|_|__  ___|_|_ _____ ____  _   _              *");
        System.out.println("* |  __ \\|  ____|/ ____|  ____|  __ \\ \\    / /\\|__   __|_   _/ __ \\| \\ | |             *");
        System.out.println("* | |__) | |__  | (___ | |__  | |__) \\ \\  / /  \\  | |    | || |  | |  \\| |             *");
        System.out.println("* |  _  /|  __|  \\___ \\|  __| |  _  / \\ \\/ / /\\ \\ | |    | || |  | | . ` |             *");
        System.out.println("* | | \\ \\| |____ ____) | |____| | \\ \\  \\  / ____ \\| |   _| || |__| | |\\  |             *");
        System.out.println("* |_|  \\_\\______|_____/|______|_|  \\_\\  \\/_/    \\_\\_|  |_____|\\____/|_| \\_|            *");
        System.out.println("****************************************************************************************");
    }
}
