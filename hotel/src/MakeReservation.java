import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MakeReservation {
    public static void main(String[] args) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Superior Deluxe Single Room", 2, 150.0));
        rooms.add(new Room("Superior Deluxe King Room", 4, 250.0));
        rooms.add(new Room("Grand Executive Suite", 4, 450.0));
        rooms.add(new Room("Presidential Suite", 6, 900.0));
        hotels.add(new Hotel("Holiday Inn Subang Jaya", rooms));

        rooms = new ArrayList<>();
        rooms.add(new Room("Twin Deluxe", 2, 200.0));
        rooms.add(new Room("King Deluxe", 4, 330.0));
        rooms.add(new Room("Grand Executive Suite", 4, 470.0));
        rooms.add(new Room("Presidential Suite", 6, 650.0));
        hotels.add(new Hotel("Hilton Kuala Lumpur", rooms));

        rooms = new ArrayList<>();
        rooms.add(new Room("Deluxe Studio Single Room", 2, 170.0));
        rooms.add(new Room("Deluxe Studio King Room", 4, 270.0));
        rooms.add(new Room("King Executive Suite", 4, 380.0));
        rooms.add(new Room("Presidential Suite", 6, 750.0));
        hotels.add(new Hotel("Hard Rock Kuala Lumpur", rooms));

        rooms = new ArrayList<>();
        rooms.add(new Room("Sea View Single Room", 2, 150.0));
        rooms.add(new Room("Sea View King Room", 4, 200.0));
        rooms.add(new Room("King Executive Suite", 4, 350.0));
        rooms.add(new Room("Presidential Suite", 6, 500.0));
        hotels.add(new Hotel("Sepang Resort", rooms));

        rooms = new ArrayList<>();
        rooms.add(new Room("Twin Deluxe Room", 2, 180.0));
        rooms.add(new Room("King Deluxe Room", 4, 280.0));
        rooms.add(new Room("Executive Suite", 4, 380.0));
        rooms.add(new Room("Presidential Suite", 6, 550.0));
        hotels.add(new Hotel("Le Meridien Kuala Lumpur", rooms));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome to Hotel Booking System");
            System.out.println("1. View hotels and rooms");
            System.out.println("2. Search for hotel by name");
            System.out.println("3. Compare Hotel by prices");
            System.out.println("4. Sort room prices for a specific hotel");
            System.out.println("5. Exit");
            System.out.println("6. Make Reservation");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printArtWork(1);
                    System.out.println("\n\033[36m=== List of Hotels ===\033[0m");
                    int i = 1;
                    for (Hotel hotel : hotels) {
                        System.out.printf("\033[1m%-3d%-30s\033[0m\n", i, hotel.getHotelName());
                        i++;
                    }
                    System.out.print("\n\033[33mEnter hotel number to view room types: \033[0m");
                    int hotelChoice = scanner.nextInt();

                    if (hotelChoice < 1 || hotelChoice > hotels.size()) {
                        System.out.println("\n\033[31mInvalid choice. Please try again.\033[0m\n");
                        break;
                    }

                    printArtWork(3);
                    Hotel selectedHotel = hotels.get(hotelChoice - 1);
                    System.out.printf("\n\033[36m%-50s\033[0m\n", "=== Room Types Available at " + selectedHotel.getHotelName() + " ===");
                    System.out.printf("\033[1m%-5s%-30s%-20s%s\033[0m\n", "No.", "Room Type", "Max Occupants", "Price (per night)");
                    System.out.println("\033[36m----------------------------------------------------------------------\033[0m");
                    int j = 1;
                    for (Room room : selectedHotel.getRooms()) {
                        System.out.printf("\033[1m%-5d%-30s%-20dRM %-10.2f\033[0m\n", j, room.getRoomType(), room.getMaxPax(), room.getPrice());
                        j++;
                    }
                    System.out.println("\033[36m----------------------------------------------------------------------\033[0m");
                    break;

                case 2:
                    printArtWork(4);
                    System.out.print("\n\033[33mEnter hotel name to search: \033[0m");
                    scanner.nextLine();
                    String hotelName = scanner.nextLine();

                    boolean found = false;
                    for (Hotel hotel : hotels) {
                        if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                            System.out.printf("\n\033[36m=== Room types at ===\033[0m\n", hotel.getHotelName());
                            System.out.printf("\033[1m%-5s%-30s%-20s%s\033[0m\n", "No.", "Room Type", "Max Occupants", "Price (per night)");
                            System.out.println("\033[34m----------------------------------------------------------------------\033[0m");
                            int k = 1;
                            for (Room room : hotel.getRooms()) {
                                System.out.printf("\033[1m%-5d%-30s%-20dRM %-10.2f\033[0m\n", k, room.getRoomType(), room.getMaxPax(), room.getPrice());
                                k++;
                            }
                            System.out.println("\033[34m----------------------------------------------------------------------\033[0m");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\033[31mHotel not found.\033[0m");
                    }
                    break;


                case 3:
                    printArtWork(2);
                    System.out.print("\n\033[33mEnter the first hotel name: \033[0m");
                    scanner.nextLine();
                    String hotel1Name = scanner.nextLine();

                    System.out.print("\n\033[33mEnter the second hotel name: \033[0m");
                    String hotel2Name = scanner.nextLine();

                    Hotel hotel1 = null;
                    Hotel hotel2 = null;

                    for (Hotel hotel : hotels) {
                        if (hotel.getHotelName().equalsIgnoreCase(hotel1Name)) {
                            hotel1 = hotel;
                        } else if (hotel.getHotelName().equalsIgnoreCase(hotel2Name)) {
                            hotel2 = hotel;
                        }

                        if (hotel1 != null && hotel2 != null) {
                            break;
                        }
                    }

                    if (hotel1 == null || hotel2 == null) {
                        System.out.println("Invalid hotel name entered.");
                        break;
                    }

                    double hotel1Price = hotel1.getRooms().stream()
                            .mapToDouble(Room::getPrice)
                            .min().orElse(Double.POSITIVE_INFINITY);
                    double hotel2Price = hotel2.getRooms().stream()
                            .mapToDouble(Room::getPrice)
                            .min().orElse(Double.POSITIVE_INFINITY);


                    System.out.println();
                    System.out.println("**********************************************************");
                    System.out.println("***                                                    ***");
                    System.out.println("***        Comparing the cheapest rooms of hotels      ***");
                    System.out.println("***                                                    ***");
                    System.out.println("**********************************************************");
                    System.out.println();

                    System.out.println("-------------------------------------------------------------------------");

                    System.out.printf("%-40s%-10s%-20s%n", "Hotel Name", "Price (RM)", "Cheapest Room Type");

                    System.out.println("-------------------------------------------------------------------------");

                    String hotel1CheapestRoomType = "";
                    String hotel2CheapestRoomType = "";

                    for (Room room : hotel1.getRooms()) {
                        if (room.getPrice() == hotel1Price) {
                            hotel1CheapestRoomType = room.getRoomType().toString();
                            System.out.printf("%-40s%-10.2f%-20s%n", hotel1.getHotelName(), hotel1Price, hotel1CheapestRoomType);
                        }
                    }

                    for (Room room : hotel2.getRooms()) {
                        if (room.getPrice() == hotel2Price) {
                            hotel2CheapestRoomType = room.getRoomType().toString();
                            System.out.printf("%-40s%-10.2f%-20s%n", hotel2.getHotelName(), hotel2Price, hotel2CheapestRoomType);
                        }
                    }

                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------");

                    if (hotel1Price < hotel2Price) {
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println(hotel1Name + " is cheaper than " + hotel2Name + " by RM " + (hotel2Price - hotel1Price));
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Cheapest room type in " + hotel1Name + ": " + hotel1CheapestRoomType);
                        System.out.println("Price of " + hotel1Name + " is RM " + hotel1Price);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Cheapest room type in " + hotel2Name + ": " + hotel2CheapestRoomType);
                        System.out.println("Price of " + hotel2Name + " is RM " + hotel2Price);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    } else if (hotel2Price < hotel1Price) {
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println(hotel2Name + " is cheaper than " + hotel1Name + " by RM " + (hotel1Price - hotel2Price));
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Cheapest room type in " + hotel2Name + ": " + hotel2CheapestRoomType);
                        System.out.println("Price of " + hotel2Name + " is RM " + hotel2Price);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Cheapest room type in " + hotel1Name + ": " + hotel1CheapestRoomType);
                        System.out.println("Price of " + hotel1Name + " is RM " + hotel1Price);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    } else {
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println(hotel1Name + " and " + hotel2Name + " have the same price for their cheapest room.");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Cheapest room type in " + hotel1Name + " and " + hotel2Name + ": " + hotel1CheapestRoomType);
                        System.out.println("Price of " + hotel1Name + " is RM " + hotel1Price);
                        System.out.println("Price of " + hotel2Name + " is RM " + hotel2Price);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    }

                    break;


                case 4:
                    printArtWork(5);
                    System.out.print("\n\033[33mPlease enter the name of the hotel to sort prices: \033[0m");
                    scanner.nextLine();
                    String hotelNameToCompare = scanner.nextLine();

                    found = false;

                    for (Hotel hotel : hotels) {
                        if (hotel.getHotelName().equalsIgnoreCase(hotelNameToCompare)) {
                            ArrayList<Room> sortedRoomsLowToHigh = new ArrayList<>(hotel.getRooms());
                            ArrayList<Room> sortedRoomsHighToLow = new ArrayList<>(hotel.getRooms());
                            Collections.sort(sortedRoomsLowToHigh, Comparator.comparing(Room::getPrice));
                            Collections.sort(sortedRoomsHighToLow, Comparator.comparing(Room::getPrice).reversed());

                            System.out.println("\n\u001B[36m****************************************************************************************\u001B[0m");
                            System.out.println("\u001B[36m***                                                                                  ***\u001B[0m");
                            System.out.printf("\u001B[36m***           %-70s   ***\n", "Hotel " + hotel.getHotelName() + " Room Prices Sorted");
                            System.out.println("\u001B[36m***                                                                                  ***\u001B[0m");
                            System.out.println("\u001B[36m****************************************************************************************\u001B[0m\n");

                            System.out.println("\u001B[32mRoom Types Available at " + hotel.getHotelName() + " Sorted by Price from Cheapest to Highest:\u001B[0m\n");

                            System.out.printf("\u001B[36m%-5s%-30s%-30s%-20s%n\u001B[0m", "No.", "Room Type", "Max Occupants", "Price (RM)");

                            System.out.println("\u001B[37m----------------------------------------------------------------------------------------------------------------------\u001B[0m");

                            int x = 1;
                            for (Room room : sortedRoomsLowToHigh) {
                                System.out.printf("%-5s%-30s%-30s%-20.2f%n", x, room.getRoomType(), room.getMaxPax(), room.getPrice());
                                x++;
                            }

                            System.out.println("\n\u001B[32mRoom Types Available at " + hotel.getHotelName() + " Sorted by Price from Highest to Cheapest:\u001B[0m\n");

                            System.out.printf("\u001B[36m%-5s%-30s%-30s%-20s%n\u001B[0m", "No.", "Room Type", "Max Occupants", "Price (RM)");

                            System.out.println("\u001B[37m----------------------------------------------------------------------------------------------------------------------\u001B[0m");

                            int y = 1;
                            for (Room room : sortedRoomsHighToLow) {
                                System.out.printf("%-5s%-30s%-30s%-20.2f%n", y, room.getRoomType(), room.getMaxPax(), room.getPrice());
                                y++;
                            }

                            System.out.println("\n\u001B[36m****************************************************************************************\u001B[0m");

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("\u001B[31mHotel " + hotelNameToCompare + " not found.\u001B[0m");
                    }

                    break;


                case 5:
                    System.out.println("Thank you for using Hotel Booking System.");
                    break;

                case 6:
                    MakeReservationProcess();

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (choice != 4);
    }


        private static void MakeReservationProcess() {
            boolean validpax = true;
            boolean validdate = true;
            boolean validhotel = true;
            int balanceChoice;
            Customer customer = new Customer();
            Reservation reservation = new Reservation();
            TopUp topUp = new TopUp();
//        AvalibilityCheck avbCk = new AvalibilityCheck();
            ArrayList<Reservation> custresRecord = new ArrayList<>();
            Scanner input = new Scanner(System.in);
            MakeReservation obj = new MakeReservation();

            ArrayList<Hotel> hotels = new ArrayList<>();
            ArrayList<Room> rooms = new ArrayList<>();
            ArrayList<Reservation> arrReservation = new ArrayList<>();

            rooms.add(new Room("Superior Deluxe Single Room", 2, 150.0));
            rooms.add(new Room("Superior Deluxe King Room", 4, 250.0));
            rooms.add(new Room("Grand Executive Suite", 4, 450.0));
            rooms.add(new Room("Presidential Suite", 6, 900.0));
            hotels.add(new Hotel("Holiday Inn Subang Jaya", rooms));

            rooms = new ArrayList<>();
            rooms.add(new Room("Twin Deluxe", 2, 200.0));
            rooms.add(new Room("King Deluxe", 4, 330.0));
            rooms.add(new Room("Grand Executive Suite", 4, 470.0));
            rooms.add(new Room("Presidential Suite", 6, 650.0));
            hotels.add(new Hotel("Hilton Kuala Lumpur", rooms));

            rooms = new ArrayList<>();
            rooms.add(new Room("Deluxe Studio Single Room", 2, 170.0));
            rooms.add(new Room("Deluxe Studio King Room", 4, 270.0));
            rooms.add(new Room("King Executive Suite", 4, 380.0));
            rooms.add(new Room("Presidential Suite", 6, 750.0));
            hotels.add(new Hotel("Hard Rock Kuala Lumpur", rooms));

            rooms = new ArrayList<>();
            rooms.add(new Room("Sea View Single Room", 2, 150.0));
            rooms.add(new Room("Sea View King Room", 4, 200.0));
            rooms.add(new Room("King Executive Suite", 4, 350.0));
            rooms.add(new Room("Presidential Suite", 6, 500.0));
            hotels.add(new Hotel("Sepang Resort", rooms));

            rooms = new ArrayList<>();
            rooms.add(new Room("Twin Deluxe Room", 2, 180.0));
            rooms.add(new Room("King Deluxe Room", 4, 280.0));
            rooms.add(new Room("Executive Suite", 4, 380.0));
            rooms.add(new Room("Presidential Suite", 6, 550.0));
            hotels.add(new Hotel("Le Meridien Kuala Lumpur", rooms));

            Hotel hotel1 = hotels.get(0);
            Hotel hotel2 = hotels.get(1);
            Hotel hotel3 = hotels.get(2);
            Hotel hotel4 = hotels.get(3);
            Hotel hotel5 = hotels.get(4);

            String hotel1name = hotel1.getHotelName();
            String hotel2name = hotel2.getHotelName();
            String hotel3name = hotel3.getHotelName();
            String hotel4name = hotel4.getHotelName();
            String hotel5name = hotel5.getHotelName();

            ArrayList<Room> hotel1room = hotel1.getRooms();
            ArrayList<Room> hotel2room = hotel2.getRooms();
            ArrayList<Room> hotel3room = hotel3.getRooms();
            ArrayList<Room> hotel4room = hotel4.getRooms();
            ArrayList<Room> hotel5room = hotel5.getRooms();


            //-------------------------------------Make reservation---------------------------------------------
            //Display header and hotels

            reservation.ReservationHeader();

            System.out.println("===============List of Hotels==============");
            int i = 1;
            for (Hotel hotel : hotels) {
                System.out.println(i + ". " + hotel.getHotelName());
                i++;
            }
            System.out.println("============================================");

            //Get hotel name
            System.out.print("Select Hotel to Make Reservation : ");
            int choosehotel = input.nextInt();

            Hotel Hotel1 = hotels.get(0);

            do {
                switch (choosehotel) {
                    case 1:
                        reservation.setHotel(1);
                        reservation.setHotelName(hotel1name);
                        validhotel = true;
                        break;
                    case 2:
                        reservation.setHotel(2);
                        reservation.setHotelName(hotel2name);
                        validhotel = true;
                        break;
                    case 3:
                        reservation.setHotel(3);
                        reservation.setHotelName(hotel3name);
                        validhotel = true;
                        break;
                    case 4:
                        reservation.setHotel(4);
                        reservation.setHotelName(hotel4name);
                        validhotel = true;
                        break;
                    case 5:
                        reservation.setHotel(5);
                        reservation.setHotelName(hotel5name);
                        validhotel = true;
                        break;
                    default:
                        System.out.println("Please Enter a Valid Hotel");
                        validhotel = false;
                }
            } while (validhotel = false);

            System.out.println("\n********************************************************************");
            System.out.println("   You are currently booking for : " + reservation.getHotelName());
            System.out.println("********************************************************************");

            //Get number of pax

            do {
                System.out.print("Enter number of pax : ");
                int pax = input.nextInt();

                if (pax <= 0) {
                    validpax = false;
                    System.out.println("Please Enter Valid Number Of Pax");

                } else if (pax > 6) {
                    validpax = false;
                    System.out.println("\nNo Suitable Room For More Than 6 Pax\nPlease Try Again\n");
                } else{
                    reservation.setPax(pax);
                    validpax = true;
                }

            } while (validpax == false);

            //Get check in check out date
            input.nextLine();

            do {
                try{
                    System.out.print("Enter Check In Date (yyyy-mm-dd): ");
                    String checkInDateString = input.nextLine();

                    LocalDate Indate = LocalDate.parse(checkInDateString, DateTimeFormatter.ISO_DATE);

                    System.out.print("Enter Check Out Date (yyyy-mm-dd): ");
                    String checkOutDateString = input.nextLine();
                    LocalDate Outdate = LocalDate.parse(checkOutDateString, DateTimeFormatter.ISO_DATE);

                    validdate = true;

                    if (Outdate.isBefore(Indate)) { // check if check-out date is before check-in date
                        validdate = false;
                        throw new IllegalArgumentException("Check-out date must be after check-in date");
                    }

                }catch (DateTimeParseException e) {
                    validdate = false;
                    System.out.println("\nInvalid Date\nPlease Try Again\n");
                }catch (IllegalArgumentException e) {
                    validdate = false;
                    System.out.println("\n" + e.getMessage() + "\nPlease Try Again\n");
                }

            } while (validdate == false);

            //Display availible room type
            int j = 1;
            int c = 0;
            Object[][] chosenroom = new Object[4][2];

            System.out.println("\n\n*************************************************************");
            switch (reservation.getHotel()){
                case 1:
                    for (Room room : hotel1room) {
                        if (reservation.getPax() < 3) {
                            if (room.getMaxPax() > 1) {

                                System.out.println(j + ". " + Room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = Room.getRoomType();
                                c++;
                            }
                        }else if (reservation.getPax() < 5) {
                            if (room.getMaxPax() > 3) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }else {
                            if (room.getMaxPax() == 6) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }
                    }
                    break;

                case 2:
                    for (Room room : hotel2room) {
                        if (reservation.getPax() < 3) {
                            if (room.getMaxPax() > 1) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }else if (reservation.getPax() < 5) {
                            if (room.getMaxPax() > 3) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }else {
                            if (room.getMaxPax() == 6) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }
                    }
                    break;

                case 3:
                    for (Room room : hotel3room) {
                        if (reservation.getPax() < 3) {
                            if (room.getMaxPax() > 1) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }else if (reservation.getPax() < 5) {
                            if (room.getMaxPax() > 3) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }else {
                            if (room.getMaxPax() == 6) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }
                    }
                    break;

                case 4:
                    for (Room room : hotel4room) {
                        if (reservation.getPax() < 3) {
                            if (room.getMaxPax() > 1) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }else if (reservation.getPax() < 5) {
                            if (room.getMaxPax() > 3) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }else {
                            if (room.getMaxPax() == 6) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }
                    }
                    break;

                case 5:
                    for (Room room : hotel5room) {
                        if (reservation.getPax() < 3) {
                            if (room.getMaxPax() > 1) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }else if (reservation.getPax() < 5) {
                            if (room.getMaxPax() > 3) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }else {
                            if (room.getMaxPax() == 6) {

                                System.out.println(j + ". " + room.getRoomType() + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());
                                j++;

                                chosenroom[c][0] = j;
                                chosenroom[c][1] = room.getRoomType();
                                c++;
                            }
                        }
                    }
                    break;
            }

            System.out.println("*************************************************************\n");
            System.out.print("Select Room Type : ");
            int inputRoom = input.nextInt();

            //Store chosen room into reservation

            for (int b=0; b < chosenroom.length; b++){
                System.out.println(chosenroom[b][1]);
                if (inputRoom == (int)chosenroom[b][0]){
                    reservation.setRoomType(chosenroom[b][1]);
                    System.out.println("You have reserved for " + chosenroom[b][1]);
                }
            }
            customer.addReservation(reservation);

            for (int v = 0; v < arrReservation.size(); v++) {
                System.out.println(arrReservation.get(i));
            }

            //Calculate Total Amount

            System.out.println("*****************************");
            System.out.println("*   Room Fees : ");
            System.out.println("*   Service : ");
            System.out.println("*   Cleaning Fees : ");
            System.out.println("*   Total Amount : ");



            //Display user account balance
            System.out.println("============Account Detail===============");
            System.out.println("|     Available balance : RM" + customer.getBalance() + "|");
            System.out.println("==========================================\n");


            do {
                System.out.println("Select option :");
                System.out.println("1. Top up");
                System.out.println("2. Proceed to Payment");
                System.out.println("\nEnter your Choice : ");
                balanceChoice = input.nextInt();

                if (balanceChoice == 1) {
                    obj.topupProcess();
                } else if (balanceChoice == 2) {
                    //Proceed to payment
                } else
                    System.out.println("Please Enter a Valid Option");
            } while (balanceChoice != 1 || balanceChoice != 2);


        }



    //-------------------------------------Topup---------------------------------------------
        private static void topupProcess() {
            TopUp topUp = new TopUp();
            Customer customer = new Customer();
            boolean validtopup = true;
            Scanner input = new Scanner(System.in);

            //Display user details and account balance
            topUp.topupHeader();

            //Input top up amount

            System.out.println("=============Enter Top Up Amount============");

            do{
                System.out.println("Top Up Amount > ");
                int topupAmount = input.nextInt();

                if (topupAmount <= 0){
                    System.out.println("Please Enter a Valid Amount");
                    validtopup = false;
                }else {
                    System.out.println("Top Up Successful");
                    customer.setBalance(customer.getBalance() + topupAmount);
                    System.out.println("Current balance : RM" + customer.getBalance());
                    validtopup = true;
                }

            }while (validtopup = false);

            //Call payment method

        }


        //-------------------------------------Modify reservation---------------------------------------------
    private static void  modifyReservation(){
        Hotel hotel = new Hotel();
        Customer customer = new Customer();
        Reservation reservation = new Reservation();
        TopUp topup = new TopUp();
        ArrayList<Hotel> hotels = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();
//        Service service = new Service();
//        Payment payment = new Payment();

        int modifyChoice;

        Scanner input = new Scanner(System.in);

        System.out.println("*********************************************************************************");
        System.out.println("*               __  __  ____  _____ _____ ________     __                       *");
        System.out.println("*              |  \\/  |/ __ \\|  __ \\_   _|  ____\\ \\   / /                     *");
        System.out.println("*              | \\  / | |  | | |  | || | | |__   \\ \\_/ /                     *");
        System.out.println("*              | |\\/| | |  | | |  | || | |  __|   \\   /                         *");
        System.out.println("*              | |  | | |__| | |__| || |_| |       | |                          *");
        System.out.println("*  _____  _____|_|__|_|\\____/|_____/_____|_|__  ___|_|_ _____ ____  _   _       *");
        System.out.println("* |  __ \\|  ____|/ ____|  ____|  __ \\ \\    / /\\|__   __|_   _/ __ \\| \\ | |       *");
        System.out.println("* | |__) | |__  | (___ | |__  | |__) \\ \\  / /  \\  | |    | || |  | |  \\| |       *");
        System.out.println("* |  _  /|  __|  \\___ \\|  __| |  _  / \\ \\/ / /\\ \\ | |    | || |  | | . ` |       *");
        System.out.println("* | | \\ \\| |____ ____) | |____| | \\ \\  \\  / ____ \\| |   _| || |__| | |\\  |       *");
        System.out.println("* |_|  \\_\\______|_____/|______|_|  \\_\\  \\/_/    \\_\\_|  |_____|\\____/|_| \\_|         *");
        System.out.println("****************************************************************************************");

        //Display user reservation details

        System.out.println("Your Current Reservation Detail : ");
        System.out.println("=============================================");
        System.out.println("    Reservation ID : " + reservation.getResId());
        System.out.println("    Name           : " + customer.getCustName());
        System.out.println("    Contact        : " + customer.getContact());
        System.out.println("    Hotel          : " + reservation.getHotelName());
        System.out.println("    Room Type      : " + reservation.getRoomType());
        System.out.println("    Pax            : " + reservation.getPax());
        System.out.println("    Check In Date  : " + reservation.getCheckindate());
        System.out.println("    Check Out Date : " + reservation.getCheckoutdate());
//        System.out.println("    Service        : " + service.getService());
//        System.out.println("    Payment Amount : RM" + payment.getTotal());
        System.out.println("==============================================");

        //Prompt user to choose part of modify
        System.out.println("=====Do you wish to modify your reservation ?=====");
        System.out.println("|                    1. Yes                       |");
        System.out.println("|                    2. No                        |");
        System.out.println("==================================================");

        do{
            System.out.println("Enter selection : ");
            modifyChoice = input.nextInt();

            if (modifyChoice == 1){
                modifyProcess();
            }else if (modifyChoice == 2){
                //Exit to main menu
            }else {
                System.out.println("Please Enter a Valid Option");
            }
        }while (modifyChoice != 1 || modifyChoice != 2);

    }

    private static void modifyProcess(){
        Hotel hotel = new Hotel();
        Customer customer = new Customer();
        Reservation reservation = new Reservation();
        TopUp topup = new TopUp();
//        Service service = new Service();
//        Payment payment = new Payment();
        Scanner input = new Scanner(System.in);
        int modifyOption = input.nextInt();
        int newtotal = 0;
        boolean validpax = true;
        boolean validdate = true;
        boolean validcancel = true;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("=====Modify Option======");
        System.out.println("| 1. Hotel              |");
        System.out.println("| 2. Room Type          |");
        System.out.println("| 3. Pax                |");
        System.out.println("| 4. Check In Date      |");
        System.out.println("| 5. Check Out Date     |");
        System.out.println("| 6. Service            |");
        System.out.println("| 7. Cancel Reservation |");
        System.out.println("| 8. Exit               |");
        System.out.println("========================");

        System.out.println("Enter Modify Option : ");

        switch (modifyOption){
            case 1 :
                //Display hotel name

                //Prompt user to input new hotel
                System.out.println("Select New Hotel : ");
                int hotelchoice = input.nextInt();

//                reservation.setHotel(/*choice*/);

                //Display Room Type
                System.out.println("Select Room Type : ");
                int roomchoice = input.nextInt();

//                reservation.setRoomType(/*choice*/);

                //Calculate new subtotal


            case 2 :
                //Disply room type

                //Prompt user to select new room type
                System.out.println("Select New Room Type : ");
                int roomTypechoice = input.nextInt();

//                roomTypechoice = reservation.setRoomType(/*choice*/);

                //Calculate new subtotal
                switch (roomTypechoice){
                    case 1 :

                }

            case 3 :
                //Prompt user input
                do {
                    System.out.println("Enter New Pax Count : ");
                    int newpax = input.nextInt();

                    if (newpax <= 0) {
                        validpax = false;
                        System.out.println("Please Enter Valid Number Of Pax");
                    } else if (newpax > 16) {
                        validpax = false;
                        System.out.println("No Suitable Room For More Than 16 Pax\nPlease Try Again");
                    } else
                        validpax = true;
                        reservation.setPax(newpax);
                } while (validpax = false);

            case 4 :
                //Prompt User input
                do {
                    System.out.println("Enter Check In Date (dd/MM/yyyy): ");
                    String checkInDateString = input.nextLine();
                    LocalDate checkInDate = LocalDate.parse(checkInDateString, formatter);
                    System.out.println("Enter Check Out Date (dd/MM/yyyy): ");
                    String checkOutDateString = input.nextLine();
                    LocalDate checkOutDate = LocalDate.parse(checkOutDateString, formatter);

                    if (checkInDate.compareTo(checkOutDate) >= 0) {
                        System.out.println("Please Enter a Valid Check Out Date");
                        validdate = false;
                    }else
                        reservation.setCheckindate(LocalDate.parse(checkInDateString));
                        reservation.setCheckoutdate(LocalDate.parse(checkOutDateString));
                        validdate = true;
                }while (validdate = false);

                //Calculate new total

            case 5 :
                do {
                    System.out.println("Enter Check Out Date (dd/MM/yyyy): ");
                    String checkOutDateString = input.nextLine();
                    LocalDate checkOutDate = LocalDate.parse(checkOutDateString, formatter);

                    if (reservation.getCheckindate().compareTo(checkOutDate) >= 0) {
                        System.out.println("Please Enter a Valid Check Out Date");
                        validdate = false;
                    }else
                        reservation.setCheckoutdate(LocalDate.parse(checkOutDateString));
                        validdate = true;
                }while (validdate = false);

                //Calculate New Total

            case 6 :
                //Display service list

                //Calculate new total

            case 7 :
                System.out.println("Are you sure you want to cancel the reservation ? ");
                System.out.println("                     1. Yes                       ");
                System.out.println("                     2. No                        ");

                do{
                    System.out.println("Select Option : ");
                    int cancelinput = input.nextInt();

                    if (cancelinput == 1){
                        reservation.setHotel(0);
                        reservation.setPax(0);
                        reservation.setRoomType(0);
                        reservation.setCheckindate(null);
                        reservation.setCheckoutdate(null);
//                        reservation.setService(null);
                    }else if (cancelinput == 2){
                        //Return to main menu
                    }else {
                        System.out.println("Please Enter a Valid Option");
                        validcancel = false;
                    }
                    validcancel = true;
                }while (validcancel = false);

            default:
                break;
        }

        //Display new reservation details

        System.out.println("============Reservation Details============");
        System.out.println("    Name           : " + customer.getCustName());
        System.out.println("    Contact        : " + customer.getContact());
        System.out.println("    Hotel          : " + reservation.getHotel());
        System.out.println("    Room Type      : " + reservation.getRoomType());
        System.out.println("    Check In Date  : " + reservation.getCheckindate());
        System.out.println("    Check Out Date : " + reservation.getCheckoutdate());
        System.out.println("    Pax            : " + reservation.getPax());
//        System.out.println("    Service        : " + reservation.getService());
        System.out.println("============================================");



    }
    static void printArtWork(int option) {
        String artWork;
        if (option == 1) {
            artWork = """                                                                                                                               
                                                                                                                                  
            HHHHHHHHH     HHHHHHHHH     OOOOOOOOO     TTTTTTTTTTTTTTTTTTTTTTTEEEEEEEEEEEEEEEEEEEEEELLLLLLLLLLL                SSSSSSSSSSSSSSS 
            H:::::::H     H:::::::H   OO:::::::::OO   T:::::::::::::::::::::TE::::::::::::::::::::EL:::::::::L              SS:::::::::::::::S
            H:::::::H     H:::::::H OO:::::::::::::OO T:::::::::::::::::::::TE::::::::::::::::::::EL:::::::::L             S:::::SSSSSS::::::S
            HH::::::H     H::::::HHO:::::::OOO:::::::OT:::::TT:::::::TT:::::TEE::::::EEEEEEEEE::::ELL:::::::LL             S:::::S     SSSSSSS
              H:::::H     H:::::H  O::::::O   O::::::OTTTTTT  T:::::T  TTTTTT  E:::::E       EEEEEE  L:::::L               S:::::S            
              H:::::H     H:::::H  O:::::O     O:::::O        T:::::T          E:::::E               L:::::L               S:::::S            
              H::::::HHHHH::::::H  O:::::O     O:::::O        T:::::T          E::::::EEEEEEEEEE     L:::::L                S::::SSSS         
              H:::::::::::::::::H  O:::::O     O:::::O        T:::::T          E:::::::::::::::E     L:::::L                 SS::::::SSSSS    
              H:::::::::::::::::H  O:::::O     O:::::O        T:::::T          E:::::::::::::::E     L:::::L                   SSS::::::::SS  
              H::::::HHHHH::::::H  O:::::O     O:::::O        T:::::T          E::::::EEEEEEEEEE     L:::::L                      SSSSSS::::S 
              H:::::H     H:::::H  O:::::O     O:::::O        T:::::T          E:::::E               L:::::L                           S:::::S
              H:::::H     H:::::H  O::::::O   O::::::O        T:::::T          E:::::E       EEEEEE  L:::::L         LLLLLL            S:::::S
            HH::::::H     H::::::HHO:::::::OOO:::::::O      TT:::::::TT      EE::::::EEEEEEEE:::::ELL:::::::LLLLLLLLL:::::LSSSSSSS     S:::::S
            H:::::::H     H:::::::H OO:::::::::::::OO       T:::::::::T      E::::::::::::::::::::EL::::::::::::::::::::::LS::::::SSSSSS:::::S
            H:::::::H     H:::::::H   OO:::::::::OO         T:::::::::T      E::::::::::::::::::::EL::::::::::::::::::::::LS:::::::::::::::SS 
            HHHHHHHHH     HHHHHHHHH     OOOOOOOOO           TTTTTTTTTTT      EEEEEEEEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLLLLLLLLL SSSSSSSSSSSSSSS   

                    """;
        } else if (option == 2) {
            artWork = """        
                                                                                                                                                            
                                                                                                                                                            
        CCCCCCCCCCCCC     OOOOOOOOO     MMMMMMMM               MMMMMMMMPPPPPPPPPPPPPPPPP        AAA               RRRRRRRRRRRRRRRRR   EEEEEEEEEEEEEEEEEEEEEE
        CCC::::::::::::C   OO:::::::::OO   M:::::::M             M:::::::MP::::::::::::::::P      A:::A              R::::::::::::::::R  E::::::::::::::::::::E
      CC:::::::::::::::C OO:::::::::::::OO M::::::::M           M::::::::MP::::::PPPPPP:::::P    A:::::A             R::::::RRRRRR:::::R E::::::::::::::::::::E
     C:::::CCCCCCCC::::CO:::::::OOO:::::::OM:::::::::M         M:::::::::MPP:::::P     P:::::P  A:::::::A            RR:::::R     R:::::REE::::::EEEEEEEEE::::E
    C:::::C       CCCCCCO::::::O   O::::::OM::::::::::M       M::::::::::M  P::::P     P:::::P A:::::::::A             R::::R     R:::::R  E:::::E       EEEEEE
   C:::::C              O:::::O     O:::::OM:::::::::::M     M:::::::::::M  P::::P     P:::::PA:::::A:::::A            R::::R     R:::::R  E:::::E             
   C:::::C              O:::::O     O:::::OM:::::::M::::M   M::::M:::::::M  P::::PPPPPP:::::PA:::::A A:::::A           R::::RRRRRR:::::R   E::::::EEEEEEEEEE   
   C:::::C              O:::::O     O:::::OM::::::M M::::M M::::M M::::::M  P:::::::::::::PPA:::::A   A:::::A          R:::::::::::::RR    E:::::::::::::::E   
   C:::::C              O:::::O     O:::::OM::::::M  M::::M::::M  M::::::M  P::::PPPPPPPPP A:::::A     A:::::A         R::::RRRRRR:::::R   E:::::::::::::::E   
   C:::::C              O:::::O     O:::::OM::::::M   M:::::::M   M::::::M  P::::P        A:::::AAAAAAAAA:::::A        R::::R     R:::::R  E::::::EEEEEEEEEE   
   C:::::C              O:::::O     O:::::OM::::::M    M:::::M    M::::::M  P::::P       A:::::::::::::::::::::A       R::::R     R:::::R  E:::::E             
    C:::::C       CCCCCCO::::::O   O::::::OM::::::M     MMMMM     M::::::M  P::::P      A:::::AAAAAAAAAAAAA:::::A      R::::R     R:::::R  E:::::E       EEEEEE
     C:::::CCCCCCCC::::CO:::::::OOO:::::::OM::::::M               M::::::MPP::::::PP   A:::::A             A:::::A   RR:::::R     R:::::REE::::::EEEEEEEE:::::E
      CC:::::::::::::::C OO:::::::::::::OO M::::::M               M::::::MP::::::::P  A:::::A               A:::::A  R::::::R     R:::::RE::::::::::::::::::::E
        CCC::::::::::::C   OO:::::::::OO   M::::::M               M::::::MP::::::::P A:::::A                 A:::::A R::::::R     R:::::RE::::::::::::::::::::E
           CCCCCCCCCCCCC     OOOOOOOOO     MMMMMMMM               MMMMMMMMPPPPPPPPPPAAAAAAA                   AAAAAAARRRRRRRR     RRRRRRREEEEEEEEEEEEEEEEEEEEEE
                                                                                                                                                               
                                                                                                                                                        

                    """;
        } else if (option == 3) {
            artWork = """                                                                                                       
                                                                                                            
            RRRRRRRRRRRRRRRRR        OOOOOOOOO          OOOOOOOOO     MMMMMMMM               MMMMMMMM   SSSSSSSSSSSSSSS 
            R::::::::::::::::R     OO:::::::::OO      OO:::::::::OO   M:::::::M             M:::::::M SS:::::::::::::::S
            R::::::RRRRRR:::::R  OO:::::::::::::OO  OO:::::::::::::OO M::::::::M           M::::::::MS:::::SSSSSS::::::S
            RR:::::R     R:::::RO:::::::OOO:::::::OO:::::::OOO:::::::OM:::::::::M         M:::::::::MS:::::S     SSSSSSS
              R::::R     R:::::RO::::::O   O::::::OO::::::O   O::::::OM::::::::::M       M::::::::::MS:::::S            
              R::::R     R:::::RO:::::O     O:::::OO:::::O     O:::::OM:::::::::::M     M:::::::::::MS:::::S            
              R::::RRRRRR:::::R O:::::O     O:::::OO:::::O     O:::::OM:::::::M::::M   M::::M:::::::M S::::SSSS         
              R:::::::::::::RR  O:::::O     O:::::OO:::::O     O:::::OM::::::M M::::M M::::M M::::::M  SS::::::SSSSS    
              R::::RRRRRR:::::R O:::::O     O:::::OO:::::O     O:::::OM::::::M  M::::M::::M  M::::::M    SSS::::::::SS  
              R::::R     R:::::RO:::::O     O:::::OO:::::O     O:::::OM::::::M   M:::::::M   M::::::M       SSSSSS::::S 
              R::::R     R:::::RO:::::O     O:::::OO:::::O     O:::::OM::::::M    M:::::M    M::::::M            S:::::S
              R::::R     R:::::RO::::::O   O::::::OO::::::O   O::::::OM::::::M     MMMMM     M::::::M            S:::::S
            RR:::::R     R:::::RO:::::::OOO:::::::OO:::::::OOO:::::::OM::::::M               M::::::MSSSSSSS     S:::::S
            R::::::R     R:::::R OO:::::::::::::OO  OO:::::::::::::OO M::::::M               M::::::MS::::::SSSSSS:::::S
            R::::::R     R:::::R   OO:::::::::OO      OO:::::::::OO   M::::::M               M::::::MS:::::::::::::::SS 
            RRRRRRRR     RRRRRRR     OOOOOOOOO          OOOOOOOOO     MMMMMMMM               MMMMMMMM SSSSSSSSSSSSSSS   
                                                                                                                  
                        """;
        }else if (option == 4) {
            artWork = """                                                                                                       
                                                                                                                                        
            SSSSSSSSSSSSSSS EEEEEEEEEEEEEEEEEEEEEE               AAA               RRRRRRRRRRRRRRRRR           CCCCCCCCCCCCCHHHHHHHHH     HHHHHHHHH
            SS:::::::::::::::SE::::::::::::::::::::E              A:::A              R::::::::::::::::R       CCC::::::::::::CH:::::::H     H:::::::H
           S:::::SSSSSS::::::SE::::::::::::::::::::E             A:::::A             R::::::RRRRRR:::::R    CC:::::::::::::::CH:::::::H     H:::::::H
           S:::::S     SSSSSSSEE::::::EEEEEEEEE::::E            A:::::::A            RR:::::R     R:::::R  C:::::CCCCCCCC::::CHH::::::H     H::::::HH
           S:::::S              E:::::E       EEEEEE           A:::::::::A             R::::R     R:::::R C:::::C       CCCCCC  H:::::H     H:::::H  
           S:::::S              E:::::E                       A:::::A:::::A            R::::R     R:::::RC:::::C                H:::::H     H:::::H  
            S::::SSSS           E::::::EEEEEEEEEE            A:::::A A:::::A           R::::RRRRRR:::::R C:::::C                H::::::HHHHH::::::H  
             SS::::::SSSSS      E:::::::::::::::E           A:::::A   A:::::A          R:::::::::::::RR  C:::::C                H:::::::::::::::::H  
               SSS::::::::SS    E:::::::::::::::E          A:::::A     A:::::A         R::::RRRRRR:::::R C:::::C                H:::::::::::::::::H  
                  SSSSSS::::S   E::::::EEEEEEEEEE         A:::::AAAAAAAAA:::::A        R::::R     R:::::RC:::::C                H::::::HHHHH::::::H  
                       S:::::S  E:::::E                  A:::::::::::::::::::::A       R::::R     R:::::RC:::::C                H:::::H     H:::::H  
                       S:::::S  E:::::E       EEEEEE    A:::::AAAAAAAAAAAAA:::::A      R::::R     R:::::R C:::::C       CCCCCC  H:::::H     H:::::H  
           SSSSSSS     S:::::SEE::::::EEEEEEEE:::::E   A:::::A             A:::::A   RR:::::R     R:::::R  C:::::CCCCCCCC::::CHH::::::H     H::::::HH
           S::::::SSSSSS:::::SE::::::::::::::::::::E  A:::::A               A:::::A  R::::::R     R:::::R   CC:::::::::::::::CH:::::::H     H:::::::H
           S:::::::::::::::SS E::::::::::::::::::::E A:::::A                 A:::::A R::::::R     R:::::R     CCC::::::::::::CH:::::::H     H:::::::H
            SSSSSSSSSSSSSSS   EEEEEEEEEEEEEEEEEEEEEEAAAAAAA                   AAAAAAARRRRRRRR     RRRRRRR        CCCCCCCCCCCCCHHHHHHHHH     HHHHHHHHH
                                                                                
          
                        """;
        }else if (option == 5) {
            artWork = """                                                                                                       
                                                                                                                               
                                                                                                                               
            SSSSSSSSSSSSSSS      OOOOOOOOO     RRRRRRRRRRRRRRRRR   TTTTTTTTTTTTTTTTTTTTTTT     BBBBBBBBBBBBBBBBB   YYYYYYY       YYYYYYY
            SS:::::::::::::::S   OO:::::::::OO   R::::::::::::::::R  T:::::::::::::::::::::T     B::::::::::::::::B  Y:::::Y       Y:::::Y
           S:::::SSSSSS::::::S OO:::::::::::::OO R::::::RRRRRR:::::R T:::::::::::::::::::::T     B::::::BBBBBB:::::B Y:::::Y       Y:::::Y
           S:::::S     SSSSSSSO:::::::OOO:::::::ORR:::::R     R:::::RT:::::TT:::::::TT:::::T     BB:::::B     B:::::BY::::::Y     Y::::::Y
           S:::::S            O::::::O   O::::::O  R::::R     R:::::RTTTTTT  T:::::T  TTTTTT       B::::B     B:::::BYYY:::::Y   Y:::::YYY
           S:::::S            O:::::O     O:::::O  R::::R     R:::::R        T:::::T               B::::B     B:::::B   Y:::::Y Y:::::Y   
            S::::SSSS         O:::::O     O:::::O  R::::RRRRRR:::::R         T:::::T               B::::BBBBBB:::::B     Y:::::Y:::::Y    
             SS::::::SSSSS    O:::::O     O:::::O  R:::::::::::::RR          T:::::T               B:::::::::::::BB       Y:::::::::Y     
               SSS::::::::SS  O:::::O     O:::::O  R::::RRRRRR:::::R         T:::::T               B::::BBBBBB:::::B       Y:::::::Y      
                  SSSSSS::::S O:::::O     O:::::O  R::::R     R:::::R        T:::::T               B::::B     B:::::B       Y:::::Y       
                       S:::::SO:::::O     O:::::O  R::::R     R:::::R        T:::::T               B::::B     B:::::B       Y:::::Y       
                       S:::::SO::::::O   O::::::O  R::::R     R:::::R        T:::::T               B::::B     B:::::B       Y:::::Y       
           SSSSSSS     S:::::SO:::::::OOO:::::::ORR:::::R     R:::::R      TT:::::::TT           BB:::::BBBBBB::::::B       Y:::::Y       
           S::::::SSSSSS:::::S OO:::::::::::::OO R::::::R     R:::::R      T:::::::::T           B:::::::::::::::::B     YYYY:::::YYYY    
           S:::::::::::::::SS    OO:::::::::OO   R::::::R     R:::::R      T:::::::::T           B::::::::::::::::B      Y:::::::::::Y    
            SSSSSSSSSSSSSSS        OOOOOOOOO     RRRRRRRR     RRRRRRR      TTTTTTTTTTT           BBBBBBBBBBBBBBBBB       YYYYYYYYYYYYY    
        
                        """;
        } else {
            artWork = """

                    """;
        }

        System.out.println(artWork);
    }







}
