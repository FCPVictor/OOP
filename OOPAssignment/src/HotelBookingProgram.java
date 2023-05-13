//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class HotelBookingProgram {
//    public static void main(String[] args) {
//        ArrayList<Hotel> hotels = new ArrayList<>();
//        ArrayList<Room> rooms = new ArrayList<>();
//
//        rooms.add(new DeluxeRoom("Superior Deluxe Single Room", 2, 150.0));
//        rooms.add(new DeluxeRoom("Superior Deluxe King Room", 4, 250.0));
//        rooms.add(new ExecutiveSuite("Grand Executive Suite", 4, 350.0));
//        rooms.add(new ExecutiveSuite("Presidential Suite", 6, 500.0));
//        hotels.add(new Hotel("Holiday Inn Subang Jaya", rooms));
//
//        rooms = new ArrayList<>();
//        rooms.add(new DeluxeRoom("Twin Deluxe", 2, 200.0));
//        rooms.add(new DeluxeRoom("King Deluxe", 4, 300.0));
//        rooms.add(new ExecutiveSuite("Grand Executive Suite", 4, 400.0));
//        rooms.add(new ExecutiveSuite("Presidential Suite", 6, 600.0));
//        hotels.add(new Hotel("Hilton Kuala Lumpur", rooms));
//
//        rooms = new ArrayList<>();
//        rooms.add(new DeluxeRoom("Deluxe Studio Single Room", 2, 170.0));
//        rooms.add(new DeluxeRoom("Deluxe Studio King Room", 4, 270.0));
//        rooms.add(new ExecutiveSuite("King Executive Suite", 4, 380.0));
//        rooms.add(new ExecutiveSuite("Presidential Suite", 6, 550.0));
//        hotels.add(new Hotel("Hard Rock Kuala Lumpur", rooms));
//
//        rooms = new ArrayList<>();
//        rooms.add(new DeluxeRoom("Sea View Single Room", 2, 100.0));
//        rooms.add(new DeluxeRoom("Sea View King Room", 4, 200.0));
//        rooms.add(new ExecutiveSuite("King Executive Suite", 4, 350.0));
//        rooms.add(new ExecutiveSuite("Presidential Suite", 6, 500.0));
//        hotels.add(new Hotel("Sepang Resort", rooms));
//
//        rooms = new ArrayList<>();
//        rooms.add(new DeluxeRoom("Twin Deluxe Room", 2, 180.0));
//        rooms.add(new DeluxeRoom("King Deluxe Room", 4, 280.0));
//        rooms.add(new ExecutiveSuite("Executive Suite", 4, 380.0));
//        rooms.add(new ExecutiveSuite("Presidential Suite", 6, 550.0));
//        hotels.add(new Hotel("Le Meridien Kuala Lumpur", rooms));
//
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//
//        do {
//            System.out.println("\nWelcome to Hotel Booking System");
//            System.out.println("1. View hotels and rooms");
//            System.out.println("2. Search for hotel by name");
//            System.out.println("3. Compare Hotel by prices");
//            System.out.println("4. Sort room prices for a specific hotel");
//            System.out.println("5. Exit");
//
//            System.out.print("Enter your choice: ");
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                Hotel.printHeader(1);
//                System.out.println("\n\033[36m=== List of Hotels ===\033[0m");
//                int i = 1;
//                for (Hotel hotel : hotels) {
//                    System.out.printf("\033[1m%-3d%-30s\033[0m\n", i, hotel.getHotelName());
//                    i++;
//                }
//                System.out.print("\n\033[33mEnter hotel number to view room types: \033[0m");
//                int hotelChoice = scanner.nextInt();
//
//                if (hotelChoice < 1 || hotelChoice > hotels.size()) {
//                    System.out.println("\n\033[31mInvalid choice. Please try again.\033[0m\n");
//                    break;
//                }
//
//                Hotel.printHeader(3);
//                Hotel selectedHotel = hotels.get(hotelChoice - 1);
//                System.out.printf("\n\033[36m%-50s\033[0m\n", "=== Room Types Available at " + selectedHotel.getHotelName() + " ===");
//                System.out.printf("\033[1m%-5s%-30s%-20s%s\033[0m\n", "Room Category    ", "Room Type", "Max Occupants", "Price (per night)", "Room Category");
//                System.out.println("\033[36m---------------------------------------------------------------------------------\033[0m");
//                for (Room room : selectedHotel.getRooms()) {
//                    room.displayRoomInfo();
//                }
//
//                System.out.println("\033[36m---------------------------------------------------------------------------------\033[0m");
//                break;
//
//                case 2:
//                Hotel.printHeader(4);
//                System.out.print("\n\033[33mEnter hotel name to search: \033[0m");
//                scanner.nextLine();
//                String hotelName = scanner.nextLine();
//
//                boolean found = false;
//                for (Hotel hotel : hotels) {
//                    if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
//                        System.out.printf("\n\033[36m=== Room types Available at %s ===\033[0m\n", hotel.getHotelName());
//                        System.out.printf("\033[1m%-5s%-30s%-20s%s\033[0m\n", "Room Category    ", "Room Type", "Max Occupants", "Price (per night)", "Room Category");
//                        System.out.println("\033[36m---------------------------------------------------------------------------------\033[0m");
//                        for (Room room : hotel.getRooms()) {
//                            room.displayRoomInfo();
//                        }
//                        System.out.println("\033[36m---------------------------------------------------------------------------------\033[0m");
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found) {
//                    System.out.println("Invalid hotel name entered.");
//                }
//                break;
//
//
//                case 3:
//                Hotel.printHeader(2);
//                System.out.print("\n\033[33mEnter the first hotel name: \033[0m");
//                scanner.nextLine();
//                String hotel1Name = scanner.nextLine();
//
//                System.out.print("\n\033[33mEnter the second hotel name: \033[0m");
//                String hotel2Name = scanner.nextLine();
//
//                Hotel hotel1 = null;
//                Hotel hotel2 = null;
//
//                for (Hotel hotel : hotels) {
//                    if (hotel.getHotelName().equalsIgnoreCase(hotel1Name)) {
//                        hotel1 = hotel;
//                    } else if (hotel.getHotelName().equalsIgnoreCase(hotel2Name)) {
//                        hotel2 = hotel;
//                    }
//
//                    if (hotel1 != null && hotel2 != null) {
//                        break;
//                    }
//                }
//
//                if (hotel1 == null || hotel2 == null) {
//                    System.out.println("Invalid hotel name entered.");
//                    break;
//                }
//
//                double hotel1Price = hotel1.getRooms().stream()
//                    .mapToDouble(Room::getPrice)
//                    .min().orElse(Double.POSITIVE_INFINITY);
//                double hotel2Price = hotel2.getRooms().stream()
//                    .mapToDouble(Room::getPrice)
//                    .min().orElse(Double.POSITIVE_INFINITY);
//
//
//                Hotel.displaycompare();
//                String hotel1CheapestRoomType = "";
//                String hotel2CheapestRoomType = "";
//
//                for (Room room : hotel1.getRooms()) {
//                    if (room.getPrice() == hotel1Price) {
//                        hotel1CheapestRoomType = room.getRoomType().toString();
//                        System.out.printf("%-40s%-10.2f%-20s%n", hotel1.getHotelName(), hotel1Price, hotel1CheapestRoomType);
//                    }
//                }
//
//                for (Room room : hotel2.getRooms()) {
//                    if (room.getPrice() == hotel2Price) {
//                        hotel2CheapestRoomType = room.getRoomType().toString();
//                        System.out.printf("%-40s%-10.2f%-20s%n", hotel2.getHotelName(), hotel2Price, hotel2CheapestRoomType);
//                    }
//                }
//
//                System.out.println();
//                System.out.println("-------------------------------------------------------------------------");
//
//                if (hotel1Price < hotel2Price) {
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    System.out.println(hotel1Name + " is cheaper than " + hotel2Name + " by RM " + (hotel2Price - hotel1Price));
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    System.out.println("Cheapest room type in " + hotel1Name + ": " + hotel1CheapestRoomType);
//                    System.out.println("Price of " + hotel1Name + " is RM " + hotel1Price);
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    System.out.println("Cheapest room type in " + hotel2Name + ": " + hotel2CheapestRoomType);
//                    System.out.println("Price of " + hotel2Name + " is RM " + hotel2Price);
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                } else if (hotel2Price < hotel1Price) {
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    System.out.println(hotel2Name + " is cheaper than " + hotel1Name + " by RM " + (hotel1Price - hotel2Price));
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    System.out.println("Cheapest room type in " + hotel2Name + ": " + hotel2CheapestRoomType);
//                    System.out.println("Price of " + hotel2Name + " is RM " + hotel2Price);
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    System.out.println("Cheapest room type in " + hotel1Name + ": " + hotel1CheapestRoomType);
//                    System.out.println("Price of " + hotel1Name + " is RM " + hotel1Price);
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    } else {
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    System.out.println(hotel1Name + " and " + hotel2Name + " have the same price for their cheapest room.");
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    System.out.println("Cheapest room type in " + hotel1Name + " and " + hotel2Name + ": " + hotel1CheapestRoomType);
//                    System.out.println("Price of " + hotel1Name + " is RM " + hotel1Price);
//                    System.out.println("Price of " + hotel2Name + " is RM " + hotel2Price);
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                }
//
//                break;
//
//
//
//case 4:
//    Hotel.printHeader(5);
//    System.out.print("\n\033[33mPlease enter the name of the hotel to sort prices: \033[0m");
//    scanner.nextLine();
//    String hotelNameToCompare = scanner.nextLine();
//
//    found = false;
//
//    for (Hotel hotel : hotels) {
//        if (hotel.getHotelName().equalsIgnoreCase(hotelNameToCompare)) {
//            ArrayList<Room> sortedRoomsLowToHigh = new ArrayList<>(hotel.getRooms());
//            ArrayList<Room> sortedRoomsHighToLow = new ArrayList<>(hotel.getRooms());
//            Collections.sort(sortedRoomsLowToHigh, Comparator.comparing(Room::getPrice));
//            Collections.sort(sortedRoomsHighToLow, Comparator.comparing(Room::getPrice).reversed());
//
//            System.out.println("\n\u001B[36m****************************************************************************************\u001B[0m");
//            System.out.println("\u001B[36m***                                                                                  ***\u001B[0m");
//            System.out.printf("\u001B[36m***           %-70s   ***\n", "Hotel " + hotel.getHotelName() + " Room Prices Sorted");
//            System.out.println("\u001B[36m***                                                                                  ***\u001B[0m");
//            System.out.println("\u001B[36m****************************************************************************************\u001B[0m\n");
//
//            System.out.println("\u001B[32mRoom Types Available at " + hotel.getHotelName() + " Sorted by Price from Cheapest to Highest:\u001B[0m\n");
//
//            System.out.printf("\033[1m%-5s%-30s%-20s%s\033[0m\n", "Room Category    ", "Room Type", "Max Occupants", "Price (per night)", "Room Category");
//
//            System.out.println("\u001B[37m----------------------------------------------------------------------------------------------------------------------\u001B[0m");
//
//            for (Room room : sortedRoomsLowToHigh) {
//                room.displayRoomInfo();
//            }
//
//            System.out.println("\n\u001B[32mRoom Types Available at " + hotel.getHotelName() + " Sorted by Price from Highest to Cheapest:\u001B[0m\n");
//
//            System.out.printf("\033[1m%-5s%-30s%-20s%s\033[0m\n", "Room Category    ", "Room Type", "Max Occupants", "Price (per night)", "Room Category");
//
//            System.out.println("\u001B[37m----------------------------------------------------------------------------------------------------------------------\u001B[0m");
//
//            for (Room room : sortedRoomsHighToLow) {
//                room.displayRoomInfo();
//            }
//
//            System.out.println("\n\u001B[36m****************************************************************************************\u001B[0m");
//
//            found = true;
//            break;
//        }
//    }
//
//    if (!found) {
//        System.out.println("Invalid hotel name entered.");
//    }
//
//    break;
//
//
//                case 5:
//                    System.out.println("Thank you for using Hotel Booking System.");
//                    break;
//
//                default:
//                    System.out.println("Invalid choice.");
//                    break;
//            }
//
//        } while (choice != 4);
//
//    }
//}
//
//
//
//
