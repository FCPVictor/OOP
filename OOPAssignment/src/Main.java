import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    /**
     * public class UserLogin {
     * private static User currentLoggedInUser;
     * <p>
     * public static User getCurrentLoggedInUser() {
     * if(currentLoggedInUser == null) {
     * return new User();
     * }
     * return currentLoggedInUser;
     * }
     * <p>
     * public static void setCurrentLoggedInUser(User user) {
     * currentLoggedInUser = user;
     * }
     * <p>
     * }
     */

    /*
     * User user = UserLogin.getCurrentLoggedInUser();
     * UserService userService = new UserService();
     * String username = getUsernameInputFromConsoleLine();
     * String passwordFromUser = getPasswordInputFromConsoleLine();
     * String passwordFromDb = userService.getPasswordByUsername(username);
     * if(passwordFromuser.equals(passwordFromDb)) {
     *   user.setUsername(username);
     *   user.setPassword(passwordFromDb);
     *   UserLogin.setCurrentLoggedInUser(user);
     * }
     *
     * */



    public double generateRandom() {
        return ThreadLocalRandom.current().nextDouble(10, 1000);
    }

    public double getPayment(double subtotal) {
        Scanner scanner = new Scanner(System.in);
        double userPayment;
        double balance = 0;

        do {

            if (balance < 0) {
                System.out.println("Insufficient payment! Please pay the correct value!");
            } else {
                System.out.print("Please Enter Your Payment: ");
            }
            userPayment = scanner.nextDouble();
            balance = userPayment - subtotal;
        } while (balance < 0);

        System.out.println("Thanks for the payment! ! !");
        System.out.printf("Here's your balance: RM %.2f", balance);

        return balance;
    }


    public String paymentMethods(double subtotal) {
        Payment payment = null;
        String method;
        Scanner scanner = new Scanner(System.in);
        int paymentMethod;

        do {
            System.out.println("1. Cash");
            System.out.println("2. Credit Card");
            System.out.println("3. TNG eWallet");
            System.out.print("Select the payment method: ");
            paymentMethod = scanner.nextInt();

            switch (paymentMethod) {
                case 1 -> payment = new CashPayment(subtotal);
                case 2 -> payment = new CreditCardPayment(subtotal);
                case 3 -> payment = new PayTngEwallet(subtotal);
            }
        } while (paymentMethod < 1 || paymentMethod > 3);

        payment.processPayment();

        return payment.getPaymentType();
    }


    public static void main(String[] args) {
        User user = null;
        DA da = new DA();
        Print artWork = new Print();

        Scanner scanner = new Scanner(System.in);

        //Prompt welcome msg
        artWork.welcomeScreen();
        do {
            artWork.displayMenu();
            int userOption = scanner.nextInt();

            while (userOption < 0 || userOption > 2) {
                System.out.print("ERROR!! Please enter value between 0 - 2. Enter the value again: \t");
                userOption = scanner.nextInt();
            }
            if (userOption == 0) {
                System.exit(-1);
            }
            if (userOption == 2) {
                Scanner scanner1 = new Scanner(System.in);
                artWork.printArtWork(2);
                // Prompt the user to enter their username and password
                System.out.print("Enter your username: ");
                String username = scanner1.nextLine();

                System.out.print("Enter your password: ");
                String password = scanner1.nextLine();

                da.insertRecord(username, password);

            } else if (userOption == 1) {
                Scanner scanner2 = new Scanner(System.in);
                artWork.printArtWork(1);
                try {
                    System.out.print("Enter your username to login: ");
                    String username = scanner2.nextLine();

                    System.out.print("Enter your password to login: ");
                    String password = scanner2.nextLine();

                    ResultSet rs = da.readRecord(username, password);
                    if (rs.next()) {
                        user = new User();
                        user.setCustomerID(Integer.parseInt(rs.getString("CustomerID")));
                        user.setUsername(username);
                        user.setPassword(password);
                        System.out.println("Logged in successfully");
                    } else {
                        System.out.println("Invalid username or password");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (user == null);
        //System.out.println(user.getCustomerID());

        //Main menu
        ArrayList<Hotel> hotels = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new DeluxeRoom("Superior Deluxe Single Room", 2, 150.0));
        rooms.add(new DeluxeRoom("Superior Deluxe King Room", 4, 250.0));
        rooms.add(new ExecutiveSuite("Grand Executive Suite", 4, 350.0));
        rooms.add(new ExecutiveSuite("Presidential Suite", 6, 500.0));
        hotels.add(new Hotel("Holiday Inn Subang Jaya", rooms));

        rooms = new ArrayList<>();
        rooms.add(new DeluxeRoom("Twin Deluxe", 2, 200.0));
        rooms.add(new DeluxeRoom("King Deluxe", 4, 300.0));
        rooms.add(new ExecutiveSuite("Grand Executive Suite", 4, 400.0));
        rooms.add(new ExecutiveSuite("Presidential Suite", 6, 600.0));
        hotels.add(new Hotel("Hilton Kuala Lumpur", rooms));

        rooms = new ArrayList<>();
        rooms.add(new DeluxeRoom("Deluxe Studio Single Room", 2, 170.0));
        rooms.add(new DeluxeRoom("Deluxe Studio King Room", 4, 270.0));
        rooms.add(new ExecutiveSuite("King Executive Suite", 4, 380.0));
        rooms.add(new ExecutiveSuite("Presidential Suite", 6, 550.0));
        hotels.add(new Hotel("Hard Rock Kuala Lumpur", rooms));

        rooms = new ArrayList<>();
        rooms.add(new DeluxeRoom("Sea View Single Room", 2, 100.0));
        rooms.add(new DeluxeRoom("Sea View King Room", 4, 200.0));
        rooms.add(new ExecutiveSuite("King Executive Suite", 4, 350.0));
        rooms.add(new ExecutiveSuite("Presidential Suite", 6, 500.0));
        hotels.add(new Hotel("Sepang Resort", rooms));

        rooms = new ArrayList<>();
        rooms.add(new DeluxeRoom("Twin Deluxe Room", 2, 180.0));
        rooms.add(new DeluxeRoom("King Deluxe Room", 4, 280.0));
        rooms.add(new ExecutiveSuite("Executive Suite", 4, 380.0));
        rooms.add(new ExecutiveSuite("Presidential Suite", 6, 550.0));
        hotels.add(new Hotel("Le Meridien Kuala Lumpur", rooms));

        int choice;

        do {
            System.out.println("\nWelcome to our Hotel Booking System");
            System.out.println("1. Search for Hotels");
            System.out.println("2. Reservation");
            System.out.println("3. Top Up");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int choice1;
                    do {
                        System.out.println("\n--Search for Hotels--");
                        System.out.println("1. View all hotels and rooms");
                        System.out.println("2. Search hotel by name");
                        System.out.println("3. Compare hotel by prices");
                        System.out.println("4. Sort room prices for a specific hotel");
                        System.out.println("5. Back to main menu");

                        System.out.print("Enter your choice: ");
                        choice1 = scanner.nextInt();

                        switch (choice1) {
                            case 1:
                                Hotel.printHeader(1);
                                System.out.println("\n\033[36m=== List of Hotels ===\033[0m");
                                int i = 1;
                                for (Hotel hotel : hotels) {
                                    System.out.printf("\033[1m%-3d%-30s\033[0m\n", i, hotel.getHotelName());
                                    i++;
                                }
                                System.out.print("\n\033[33mEnter hotel number to view room types: \033[0m");
                                int hotelChoice = scanner.nextInt();

                                if (hotelChoice < 1 || hotelChoice > hotels.size()) {
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                                }

                                Hotel.printHeader(3);
                                Hotel selectedHotel = hotels.get(hotelChoice - 1);
                                System.out.printf("\n\033[36m%-50s\033[0m\n", "=== Room Types Available at " + selectedHotel.getHotelName() + " ===");
                                System.out.printf("\033[1m%-5s%-30s%-20s%s\033[0m\n", "Room Category    ", "Room Type", "Max Occupants", "Price (per night)", "Room Category");
                                System.out.println("\033[36m---------------------------------------------------------------------------------\033[0m");
                                for (Room room : selectedHotel.getRooms()) {
                                    room.displayRoomInfo();
                                }

                                System.out.println("\033[36m---------------------------------------------------------------------------------\033[0m");
                                break;

                            case 2:
                                Hotel.printHeader(4);
                                System.out.print("\n\033[33mEnter hotel name to search: \033[0m");
                                scanner.nextLine();
                                String hotelName = scanner.nextLine();

                                boolean found = false;
                                for (Hotel hotel : hotels) {
                                    if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                                        System.out.printf("\n\033[36m=== Room types Available at %s ===\033[0m\n", hotel.getHotelName());
                                        System.out.printf("\033[1m%-5s%-30s%-20s%s\033[0m\n", "Room Category    ", "Room Type", "Max Occupants", "Price (per night)", "Room Category");
                                        System.out.println("\033[36m---------------------------------------------------------------------------------\033[0m");
                                        for (Room room : hotel.getRooms()) {
                                            room.displayRoomInfo();
                                        }
                                        System.out.println("\033[36m---------------------------------------------------------------------------------\033[0m");
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Invalid hotel name entered.");
                                }
                                break;

                            case 3:
                                Hotel.printHeader(2);
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


                                Hotel.displaycompare();
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
                                Hotel.printHeader(5);
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

                                        System.out.printf("\033[1m%-5s%-30s%-20s%s\033[0m\n", "Room Category    ", "Room Type", "Max Occupants", "Price (per night)", "Room Category");

                                        System.out.println("\u001B[37m----------------------------------------------------------------------------------------------------------------------\u001B[0m");

                                        for (Room room : sortedRoomsLowToHigh) {
                                            room.displayRoomInfo();
                                        }

                                        System.out.println("\n\u001B[32mRoom Types Available at " + hotel.getHotelName() + " Sorted by Price from Highest to Cheapest:\u001B[0m\n");

                                        System.out.printf("\033[1m%-5s%-30s%-20s%s\033[0m\n", "Room Category    ", "Room Type", "Max Occupants", "Price (per night)", "Room Category");

                                        System.out.println("\u001B[37m----------------------------------------------------------------------------------------------------------------------\u001B[0m");

                                        for (Room room : sortedRoomsHighToLow) {
                                            room.displayRoomInfo();
                                        }

                                        System.out.println("\n\u001B[36m****************************************************************************************\u001B[0m");

                                        found = true;
                                        break;
                                    }
                                }

                                if (!found) {
                                    System.out.println("Invalid hotel name entered.");
                                }

                                break;
                            case 5:
                                break;

                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }}
                    while (choice1 != 5) ;
                    break;


                case 2:

                    artWork.reservationOption();
                    int resinput = scanner.nextInt();;

                    switch (resinput){
                        case 1:
                            MakeReservationProcess(hotels, rooms);
                        case 2:
                            break;

                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                    //Payment part
                    Scanner scanner1 = new Scanner(System.in);
                    double subtotal = 0.0;
                    double userPay = 0.0;
                    double balance = 0.0;
                    Main m = new Main();

                    artWork.printPaymentArt();
                    subtotal = m.generateRandom();

                    String method = m.paymentMethods(subtotal);

                    System.out.printf("Thank you for visiting! \nPayment method: " + method + "\nPlease pay:RM %.2f\n", subtotal);

                    balance = m.getPayment(subtotal);

                case 3:
                    System.out.println("Thank you for using Hotel Booking System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (choice != 3);


    }

    static void MakeReservationProcess(ArrayList<Hotel> hotels ,
                                       ArrayList<Room> rooms ) {
        boolean validpax = true;
        boolean validdate = true;
        boolean validroom = true;
        int pax = 0;
        Customer customer = new Customer();
        Reservation reservation = new Reservation();
        Scanner input = new Scanner(System.in);

        ArrayList<RoomDisplay> roomDisplay = new ArrayList<>();

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

        int choosehotel = 0;
        while (choosehotel < 1 || choosehotel > 5) {
            System.out.print("Select Hotel to Make Reservation : ");
            try {
                choosehotel = input.nextInt();
                if (choosehotel < 1 || choosehotel > 5) {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) { //Catch exception if user input is not int
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                input.next();
            }
        }

        Hotel selectedHotel = hotels.get(choosehotel - 1);
        reservation.setHotel(selectedHotel);

        Hotel bookedHotel = reservation.getHotel();
        System.out.println("\n************************************************************");
        System.out.println("You are making reservation for : " + bookedHotel.getHotelName());
        System.out.println("************************************************************");

        //Get number of pax

        do {
            System.out.print("Enter number of pax : ");
            pax = input.nextInt();

            if (pax <= 0) {
                validpax = false;
                System.out.println("Please Enter Valid Number Of Pax");

            } else if (pax > 6) {
                validpax = false;
                System.out.println("\nNo Suitable Room For More Than 6 Pax\nPlease Try Again\n");
            } else {
                reservation.setPax(pax);
                validpax = true;
            }

        } while (validpax == false);

        //Get check in check out date

        System.out.println("\n=================Date=================");
        input.nextLine();

        do {
            LocalDate minDate = LocalDate.of(2023, 6, 1);
            LocalDate maxDate = LocalDate.of(2023, 6, 7);

            try {
                System.out.print("Enter Check In Date (yyyy-mm-dd): ");
                String checkInDateString = input.nextLine();

                LocalDate Indate = LocalDate.parse(checkInDateString, DateTimeFormatter.ISO_DATE);

                if (Indate.isBefore(minDate) || Indate.isAfter(maxDate)) {
                    throw new IllegalArgumentException("Invalid date range. Please enter a date between " + minDate + " and " + maxDate);
                }

                System.out.print("Enter Check Out Date (yyyy-mm-dd): ");
                String checkOutDateString = input.nextLine();

                LocalDate Outdate = LocalDate.parse(checkOutDateString, DateTimeFormatter.ISO_DATE);

                if (Outdate.isBefore(minDate) || Outdate.isAfter(maxDate)) {
                    throw new IllegalArgumentException("Invalid date range. Please enter a date between " + minDate + " and " + maxDate);
                }

                reservation.setCheckindate(Indate);
                reservation.setCheckoutdate(Outdate);

                validdate = true;

                if (Outdate.isBefore(Indate)) { // check if check-out date is before check-in date
                    validdate = false;
                    throw new IllegalArgumentException("Check-out date must be after check-in date");
                }

            } catch (DateTimeParseException e) {
                validdate = false;
                System.out.println("\nInvalid Date\nPlease Try Again\n");
            } catch (IllegalArgumentException e) {
                validdate = false;
                System.out.println("\n" + e.getMessage() + "\nPlease Try Again\n");
            }

        } while (validdate == false);

        int j = 1;

        System.out.println("\n------------------Available Room Type------------------");
        System.out.println("*******************************************************");
        for (Room room : selectedHotel.getRooms()) {
            if (room.getMaxPax() >= reservation.getPax()) {
                String roomType = room.getRoomType(); //get the room type from the room object
                System.out.println(j + ". " + roomType + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());

                roomDisplay.add(new RoomDisplay(j, roomType));

                j++;
            }
        }

        System.out.println("*******************************************************");

        do {
            try {
                System.out.print("Select Room Type : ");
                int inputRoom = input.nextInt();

                Room selectedRoom = null;
                for (RoomDisplay rd : roomDisplay) {
                    // check if input matches the displayId
                    if (inputRoom == rd.getRoomNum()) {
                        // print roomType associated with matched RoomDisplay object
                        System.out.println("\nYou have selected: " + rd.getRoomType());
                        validroom = true;

                        // find the corresponding Room object based on the selected room type
                        selectedRoom = selectedHotel.getRooms().stream()
                                .filter(room -> room.getRoomType().equals(rd.getRoomType()))
                                .findFirst()
                                .orElse(null);

                        reservation.setRoom(selectedRoom);
                        break; // exit loop since we found a match
                    }
                }

                if (selectedRoom == null) {
                    System.out.println("Please Enter a Valid Room Number");
                    validroom = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Input\nPlease Try Again\n");
                input.nextLine(); // consume the invalid input
                validroom = false;
            }
        } while (validroom == false);

        //Store data to customer class
        customer.addReservation(reservation);

        //Display Reservation Summary

        System.out.println("\n         *****************************");
        System.out.println("         |   Thank You For Booking   |");
        System.out.println("         *****************************");
        String custResSum = customer.toString();
        System.out.println(custResSum);

    }





}

