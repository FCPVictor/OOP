import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CheckAvailability {

    private boolean[][] roomBookings;

    public CheckAvailability() {
        roomBookings = new boolean[7][4];
    }

    public void checkAvailability() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("      __      __     _____ _               ____ _____ _      _____ _________     __\n"
                + "     /\\ \\    / /\\   |_   _| |        /\\   |  _ \\_   _| |    |_   _|__   __\\ \\   / /\n"
                + "    /  \\ \\  / /  \\    | | | |       /  \\  | |_) || | | |      | |    | |   \\ \\_/ / \n"
                + "   / /\\ \\ \\/ / /\\ \\   | | | |      / /\\ \\ |  _ < | | | |      | |    | |    \\   /  \n"
                + "  / ____ \\  / ____ \\ _| |_| |____ / ____ \\| |_) || |_| |____ _| |_   | |     | |   \n"
                + " /_/    \\_\\/_/    \\_\\_____|______/_/    \\_\\____/_____|______|_____|  |_|     |_|   \n"
                + "                                                                                   \n");
        System.out.print("Enter hotel name: ");

        String hotelName = scanner.nextLine();

        LocalDate checkInDate = null;
        LocalDate checkOutDate = null;
        while (checkInDate == null || checkOutDate == null) {
            try {
                System.out.print("Enter check-in date (YYYY-MM-DD): ");
                checkInDate = LocalDate.parse(scanner.nextLine());
                System.out.print("Enter check-out date (YYYY-MM-DD): ");
                checkOutDate = LocalDate.parse(scanner.nextLine());

                LocalDate minDate = LocalDate.of(2023, 6, 1);
                LocalDate maxDate = LocalDate.of(2023, 6, 7);
                if (checkInDate.isBefore(minDate) || checkOutDate.isAfter(maxDate)) {
                    System.out.println(" ________ _______    _______     ___  _______     \n"
                            + "|_   __  |_   __ \\  |_   __ \\  .'   `|_   __ \\    \n"
                            + "  | |_ \\_| | |__) |   | |__) |/  .-.  \\| |__) |   \n"
                            + "  |  _| _  |  __ /    |  __ / | |   | ||  __ /    \n"
                            + " _| |__/ |_| |  \\ \\_ _| |  \\ \\\\  `-'  _| |  \\ \\_  \n"
                            + "|________|____| |___|____| |___`.___.|____| |___| \n"
                            + "                                                  \n");
                    System.out.println("Invalid dates. Available dates are between 2023-06-01 and 2023-06-07.");
                    checkInDate = null;
                    checkOutDate = null;
                } else if (checkOutDate.isBefore(checkInDate)) {
                    System.out.println(" ________ _______    _______     ___  _______     \n"
                            + "|_   __  |_   __ \\  |_   __ \\  .'   `|_   __ \\    \n"
                            + "  | |_ \\_| | |__) |   | |__) |/  .-.  \\| |__) |   \n"
                            + "  |  _| _  |  __ /    |  __ / | |   | ||  __ /    \n"
                            + " _| |__/ |_| |  \\ \\_ _| |  \\ \\\\  `-'  _| |  \\ \\_  \n"
                            + "|________|____| |___|____| |___`.___.|____| |___| \n"
                            + "                                                  \n");
                    System.out.println("Invalid dates. Check-in date should be earlier than check-out date.");
                    checkInDate = null;
                    checkOutDate = null;
                } else if (isFullyBooked(hotelName, checkInDate, checkOutDate)) {
                    System.out.println("  _    _ _   _ ______ ____  _____ _______ _    _ _   _       _______ ______ \n"
                            + " | |  | | \\ | |  ____/ __ \\|  __ |__   __| |  | | \\ | |   /\\|__   __|  ____|\n"
                            + " | |  | |  \\| | |__ | |  | | |__) | | |  | |  | |  \\| |  /  \\  | |  | |__   \n"
                            + " | |  | | . ` |  __|| |  | |  _  /  | |  | |  | | . ` | / /\\ \\ | |  |  __|  \n"
                            + " | |__| | |\\  | |   | |__| | | \\ \\  | |  | |__| | |\\  |/ ____ \\| |  | |____ \n"
                            + "  \\____/|_| \\_|_|    \\____/|_|  \\_\\ |_|   \\____/|_| \\_/_/    \\_|_|  |______|");
                    System.out.println("Selected dates are fully booked. Please choose different dates.");
                    checkInDate = null;
                    checkOutDate = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println(" ________ _______    _______     ___  _______     \n"
                        + "|_   __  |_   __ \\  |_   __ \\  .'   `|_   __ \\    \n"
                        + "  | |_ \\_| | |__) |   | |__) |/  .-.  \\| |__) |   \n"
                        + "  |  _| _  |  __ /    |  __ / | |   | ||  __ /    \n"
                        + " _| |__/ |_| |  \\ \\_ _| |  \\ \\\\  `-'  _| |  \\ \\_  \n"
                        + "|________|____| |___|____| |___`.___.|____| |___| \n"
                        + "                                                  \n");
                System.out.println("Invalid date format. Please enter dates in the specified format.");
            }
        }

        int startDay = checkInDate.getDayOfMonth();
        int endDay = checkOutDate.getDayOfMonth();
        int roomCount = roomBookings[0].length;
        for (int day = startDay; day <= endDay; day++) {
            for (int room = 0; room < roomCount; room++) {
                roomBookings[day - 1][room] = true;
            }
        }

        System.out.println("Room availability for " + hotelName + " (" + checkInDate + " to " + checkOutDate + "):");

        for (int day = startDay; day <= endDay; day++) {
            System.out.println("Day " + day + ":");
            for (int room = 0; room < roomCount; room++) {
                Room currentRoom = Hotel.get(Name).getRooms().get(room);
                System.out.println("---$$$---$$$---$$$---");
                System.out.println(currentRoom.getName() + ": " + (roomBookings[day - 1][room] ? "Booked " : "Available "));
                System.out.println("---$$$---$$$---$$$---");
            }

        }
    }

    private boolean isFullyBooked(String hotelName, LocalDate checkInDate, LocalDate checkOutDate) {
        int startDay = checkInDate.getDayOfMonth();
        int endDay = checkOutDate.getDayOfMonth();
        int roomCount = roomBookings[0].length;
        for (int day = startDay; day <= endDay; day++) {
            for (int room = 0; room < roomCount; room++) {
                if (roomBookings[day - 1][room]) {
                    return true;
                }
            }
        }
        return false;
    }
}
