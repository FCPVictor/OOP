
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckAvailability {

    private ArrayList<Hotel> hotels;
    private boolean[][][] roomBookings;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public CheckAvailability(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
        this.checkInDate = LocalDate.of(2023, 6, 1);
        this.checkOutDate = LocalDate.of(2023, 6, 7);

        int numDays = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate) + 1;
        int numHotels = hotels.size();
        int numRooms = hotels.get(0).getRooms().size();

        roomBookings = new boolean[numDays][numHotels][numRooms];
    }

    public void checkRoomAvailability() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("                                   __      __     _____ _               ____ _____ _      _____ _________     __\n"
                + "                                  /\\ \\    / /\\   |_   _| |        /\\   |  _ \\_   _| |    |_   _|__   __\\ \\   / /\n"
                + "                                 /  \\ \\  / /  \\    | | | |       /  \\  | |_) || | | |      | |    | |   \\ \\_/ / \n"
                + "                                / /\\ \\ \\/ / /\\ \\   | | | |      / /\\ \\ |  _ < | | | |      | |    | |    \\   /  \n"
                + "                               / ____ \\  / ____ \\ _| |_| |____ / ____ \\| |_) || |_| |____ _| |_   | |     | |   \n"
                + "                              /_/    \\_\\/_/    \\_\\_____|______/_/    \\_\\____/_____|______|_____|  |_|     |_|   \n"
                + "                                                                                                                \n");

        // Get the check-in date
        LocalDate checkInDate = null;
        while (checkInDate == null) {
            System.out.print("                  Enter the check-in date (yyyy-MM-dd): ");
            String checkInDateStr = scanner.nextLine();

            try {
                checkInDate = LocalDate.parse(checkInDateStr, DateTimeFormatter.ISO_DATE);

                // Validate the check-in date range
                if (checkInDate.isBefore(LocalDate.of(2023, 6, 1)) || checkInDate.isAfter(LocalDate.of(2023, 6, 7))) {
                    printError();
                    System.out.println("                                Invalid check-in date. Please enter a date between 2023-06-01 and 2023-06-07.");
                    checkInDate = null;
                }
            } catch (DateTimeParseException e) {
                printError();
                System.out.println("                                Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }

        // Get the check-out date
        LocalDate checkOutDate = null;
        while (checkOutDate == null) {
            System.out.print("                  Enter the check-out date (yyyy-MM-dd): ");
            String checkOutDateStr = scanner.nextLine();

            try {
                checkOutDate = LocalDate.parse(checkOutDateStr, DateTimeFormatter.ISO_DATE);

                // Validate the check-out date range
                if (checkOutDate.isBefore(checkInDate) || checkOutDate.isAfter(checkInDate.plusDays(6))) {
                    printError();
                    System.out.println("                                Invalid check-out date. Please enter a date between " + checkInDate.plusDays(1).toString() + " and " + checkInDate.plusDays(7).toString() + ".");
                    checkOutDate = null;
                }
            } catch (DateTimeParseException e) {
                printError();
                System.out.println("                                Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }
        System.out.println("                                    _               _                    _ _       _     _ _ _ _         \n"
                + "                                   | |             | |                  (_) |     | |   (_) (_) |        \n"
                + "                                ___| |__   ___  ___| | ____ ___   ____ _ _| | __ _| |__  _| |_| |_ _   _ \n"
                + "                               / __| '_ \\ / _ \\/ __| |/ / _` \\ \\ / / _` | | |/ _` | '_ \\| | | | __| | | |\n"
                + "                              | (__| | | |  __/ (__|   < (_| |\\ V / (_| | | | (_| | |_) | | | | |_| |_| |\n"
                + "                               \\___|_| |_|\\___|\\___|_|\\_\\__,_| \\_/ \\__,_|_|_|\\__,_|_.__/|_|_|_|\\__|\\__, |\n"
                + "                                                                                                    __/ |\n"
                + "                                                                                                   |___/ ");

        // Display hotel names and room types
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println("                   " + (i + 1) + ". " + hotels.get(i));
            ArrayList<Room> rooms = hotels.get(i).getRooms();
            for (int j = 0; j < rooms.size(); j++) {
                System.out.println("                      " + (j + 1) + ". " + rooms.get(j).getRoomType());
            }
        }

        // Get the hotel index
        int hotelIndex;
        do {
            System.out.print("                                              Select a hotel (1-" + hotels.size() + "): ");
            hotelIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (hotelIndex < 1 || hotelIndex > hotels.size()) {
                System.out.println("                        Invalid hotel selection. Please enter a number between 1 and " + hotels.size() + ".");
            }
        } while (hotelIndex < 1 || hotelIndex > hotels.size());

// Get the room index
        int roomIndex;
        do {
            System.out.print("                                              Select a room type (1-" + hotels.get(hotelIndex - 1).getRooms().size() + "): ");
            roomIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (roomIndex < 1 || roomIndex > hotels.get(hotelIndex - 1).getRooms().size()) {
                System.out.println("                        Invalid room selection. Please enter a number between 1 and " + hotels.get(hotelIndex - 1).getRooms().size() + ".");
            }
        } while (roomIndex < 1 || roomIndex > hotels.get(hotelIndex - 1).getRooms().size());

// Check if the room is fully booked for the requested dates
        boolean fullyBooked = false;
        LocalDate currentDate = checkInDate;
        while (!currentDate.isAfter(checkOutDate)) {
            int dayIndex = currentDate.getDayOfYear() - checkInDate.getDayOfYear();
            if (roomBookings[dayIndex][hotelIndex - 1][roomIndex - 1]) {
                fullyBooked = true;
                break;
            }
            currentDate = currentDate.plusDays(1);
        }

        if (fullyBooked) {
            System.out.println("                                        =================================================");
            System.out.println("                                        The room is fully booked for the requested dates.");
            System.out.println("                                        =================================================");
        } else {
            System.out.println("                                        ==============================================");
            System.out.println("                                        The room is available for the requested dates.");
            System.out.println("                                        ==============================================");
        }
    }

    private void printError() {
        System.out.println("                              ________ _______    _______     ___  _______     \n"
                + "                             |_   __  |_   __ \\  |_   __ \\  .'   `|_   __ \\    \n"
                + "                               | |_ \\_| | |__) |   | |__) |/  .-.  \\| |__) |   \n"
                + "                               |  _| _  |  __ /    |  __ / | |   | ||  __ /    \n"
                + "                              _| |__/ |_| |  \\ \\_ _| |  \\ \\\\  `-'  _| |  \\ \\_  \n"
                + "                             |________|____| |___|____| |___`.___.|____| |___| \n"
                + "                                                                               \n");
    }
}
