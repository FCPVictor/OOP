import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ThreadLocalRandom;

import Loyalty.Loyalty;
import Service.*;



public class Main {


    static FoodMenu fd = new FoodMenu();
    static TopUp wallet = new TopUp();
    Print print = new Print();
    static Loyalty member = new Loyalty();



//    public double generateRandom() {
//        return ThreadLocalRandom.current().nextDouble(10, 1000);
//    } // Temporary for data generate only not used anymore

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
        Customer customer = new Customer();
        User user = null;
        DA da = new DA();
        Main m = new Main();



        Scanner scanner = new Scanner(System.in);

        //Prompt welcome msg
        m.print.welcomeScreen();
        do {
            m.print.displayMenu();
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
                m.print.printArtWork(2);
                // Prompt the user to enter their username and password
                System.out.print("Enter your username: ");
                String username = scanner1.nextLine();

                System.out.print("Enter your password: ");
                String password = scanner1.nextLine();

                da.insertRecord(username, password);

                inputCustDetail(customer,scanner);

            } else if (userOption == 1) {
                Scanner scanner2 = new Scanner(System.in);
                m.print.printArtWork(1);
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

        customer.setCustId(user.getCustomerID() + ""); // convert datatype to String
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
            System.out.println("4. Profile");
            System.out.println("5. Payment");
            System.out.println("6. Exit");

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

                    System.out.println("================================");
                    System.out.println("|     1. Make Reservation      |");
                    System.out.println("|     2. Modify Reservation    |");
                    System.out.println("|     3. Cancel Reservation    |");
                    System.out.println("|     4. Exit                  |");
                    System.out.println("================================\n");
                    System.out.print("Select your option : ");
                    int resinput = scanner.nextInt();

                    switch (resinput){
                        case 1:
                            customer = MakeReservationProcess(hotels, rooms, customer);
                            break;
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
                    break;


                    //Choice
                case 3:
                    topupProcess(customer);

                    break;

                case 4:
                    DisplayProfile(customer);
                    break;

                case 5:
                    //Exit
                    System.out.println("Thank you!!");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (choice != 6);


    }

    static Customer MakeReservationProcess(ArrayList<Hotel> hotels ,
                                       ArrayList<Room> rooms, Customer customer ) {
        boolean validPax = true;
        boolean validDate = true;
        boolean validRoom = true;
        int pax = 0;

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
                validPax = false;
                System.out.println("Please Enter Valid Number Of Pax");

            } else if (pax > 6) {
                validPax = false;
                System.out.println("\nNo Suitable Room For More Than 6 Pax\nPlease Try Again\n");
            } else {
                reservation.setPax(pax);
                validPax = true;
            }

        } while (validPax == false);

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

                if (Indate.equals(Outdate)) {
                    throw new IllegalArgumentException("Check-out date cannot be the same as check-in date");
                }

                reservation.setCheckindate(Indate);
                reservation.setCheckoutdate(Outdate);

                validDate = true;

                if (Outdate.isBefore(Indate)) { // check if check-out date is before check-in date
                    validDate = false;
                    throw new IllegalArgumentException("Check-out date must be after check-in date");
                }

            } catch (DateTimeParseException e) {
                validDate = false;
                System.out.println("\nInvalid Date\nPlease Try Again\n");
            } catch (IllegalArgumentException e) {
                validDate = false;
                System.out.println("\n" + e.getMessage() + "\nPlease Try Again\n");
            }

        } while (validDate == false);

        int j = 1;

        System.out.println("\n------------------Available Room Type------------------");
        System.out.println("*******************************************************");
        for (Room room : selectedHotel.getRooms()) {
            if (room.getMaxPax() >= reservation.getPax()) {
                String roomType = room.getRoomType(); //get the room type from the room object
                double roomPrice = room.getPrice();

                System.out.println(j + ". " + roomType + " (Max Pax: " + room.getMaxPax() + ") - RM " + room.getPrice());

                roomDisplay.add(new RoomDisplay(j, roomType,roomPrice));

                j++;
            }
        }

        System.out.println("*******************************************************");

        do {
            try {
                System.out.print("Select Room Type : ");
                int inputRoom = input.nextInt();

                Room selectedRoom = null;
                double selectedRoomPrice = 0;
                for (RoomDisplay rd : roomDisplay) {
                    // check if input matches the displayId
                    if (inputRoom == rd.getRoomNum()) {
                        // print roomType associated with matched RoomDisplay object
                        System.out.println("\nYou have selected: " + rd.getRoomType());
                        validRoom = true;

                        // find the corresponding Room object based on the selected room type
                        selectedRoom = selectedHotel.getRooms().stream()
                                .filter(room -> room.getRoomType().equals(rd.getRoomType()))
                                .findFirst()
                                .orElse(null);

                        selectedRoomPrice = selectedHotel.getRooms().stream()
                                .filter(room -> room.getPrice() == rd.getRoomPrice())
                                .mapToDouble(Room::getPrice) // add this line to get the price value
                                .findFirst()
                                .orElse(0.0);

                        reservation.setRoom(selectedRoom);

                        break; // exit loop since we found a match
                    }
                }

                if (selectedRoom == null) {
                    System.out.println("Please Enter a Valid Room Number");
                    validRoom = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Input\nPlease Try Again\n");
                input.nextLine(); // consume the invalid input
                validRoom = false;
            }
        } while (validRoom == false);

        //service
        Service(selectedHotel);

        //Store data to customer class
        customer.addReservation(reservation);

        //Display Reservation Summary
        String custResSum = customer.toString();
        System.out.println(custResSum);

        //Payment part
        Scanner scanner1 = new Scanner(System.in);
        double subtotal = 0.0;
        double userPay = 0.0;
        double balance = 0.0;
        double discount = member.getDiscount();
        Main m = new Main();

        int lastIndex = customer.getReservation().size() - 1;

        m.print.printPaymentArt();
        double discountAmount = 0;
        subtotal = (fd.getServiceSubtotal() + customer.getReservation().get(lastIndex).calTotalRoomPrice());
        System.out.printf("Initial amount to pay: RM %.2f\n", subtotal);

        if (customer.getBalance() > 0){
            discountAmount = subtotal * member.getDiscount();
            subtotal -= discountAmount;
            System.out.printf("Member discount: RM %.2f\n", discountAmount);
        }
        System.out.printf("Amount to pay: RM %.2f\n", subtotal);
        String method = m.paymentMethods(subtotal);

        System.out.printf("Thank you for visiting! \nPayment method: " + method + "\nPlease pay:RM %.2f\n", subtotal);

        balance = m.getPayment(subtotal);

        System.out.println("\n         *****************************");
        System.out.println("         |   Thank You For Booking   |");
        System.out.println("         *****************************");


        return customer;
    }


    public static void Service(Hotel selectedHotel) {
        Scanner scan = new Scanner(System.in);
        //Hotel A Menu
        TransMenu[] transMenuA = {new TransMenu("Valet Parking", 50.00),
                new TransMenu("Taxi from KLIA", 65.00),
                new TransMenu("Taxi from KLIA2", 65.00),
                new TransMenu("Taxi from KL Sentral", 30.00),
        };

        FoodMenu[] foodMenuA = {new FoodMenu("Burger", 35.50),
                new FoodMenu("Steak", 50.50),
                new FoodMenu("Chicken Chop", 22.90),
                new FoodMenu("Spaghetti", 19.90),
        };

        BevMenu[] bevMenuA = {new BevMenu("Coca-cola", 5.90),
                new BevMenu("Sprite", 5.90),
                new BevMenu("Ice Lemon Tea", 6.50),
                new BevMenu("100 Plus", 5.90),
        };

        //Hotel B Menu
        TransMenu[] transMenuB = {new TransMenu("Valet Parking", 150.00),
                new TransMenu("Taxi from KLIA", 125.00),
                new TransMenu("Taxi from KLIA2", 125.00),
                new TransMenu("Taxi from KL Sentral", 80.00),
        };

        FoodMenu[] foodMenuB = {new FoodMenu("Lamb Shank", 64.90),
                new FoodMenu("Seafood Aglio Olio", 45.90),
                new FoodMenu("Grill Salmon", 59.90),
                new FoodMenu("Beef Wellington", 79.90),
        };

        BevMenu[] bevMenuB = {new BevMenu("Blue Mountain Coffee", 38.80),
                new BevMenu("Grand Jasmine Tea", 25.00),
                new BevMenu("Highland Honey", 30.00),
                new BevMenu("Red Wine", 99.90),
        };

        //Hotel C Menu
        TransMenu[] transMenuC = {new TransMenu("Valet Parking", 50.00),
                new TransMenu("Taxi from KLIA", 65.00),
                new TransMenu("Taxi from KLIA2", 65.00),
                new TransMenu("Taxi from KL Sentral", 30.00),
        };

        FoodMenu[] foodMenuC = {new FoodMenu("Chicken Burger", 35.50),
                new FoodMenu("Chicken Tender", 29.90),
                new FoodMenu("Hard Rock Nachos", 25.50),
                new FoodMenu("New York Cheese Cake", 19.90),
        };

        BevMenu[] bevMenuC = {new BevMenu("Hurricane Cocktail ", 19.90),
                new BevMenu("Margarita", 19.90),
                new BevMenu("Long Island Iced Tea", 12.80),
                new BevMenu("Classic Mojito", 19.90),
        };

        //Hotel D Menu
        TransMenu[] transMenuD = {new TransMenu("Valet Parking", 30.00),
                new TransMenu("Taxi from KLIA", 65.00),
                new TransMenu("Taxi from KLIA2", 65.00),
                new TransMenu("Taxi from KL Sentral", 30.00),
        };

        FoodMenu[] foodMenuD = {new FoodMenu("Nasi Lemak", 35.50),
                new FoodMenu("Nasi Briyani", 12.80),
                new FoodMenu("Curry Mutton", 15.90),
                new FoodMenu("Fried Rice", 9.90),
        };

        BevMenu[] bevMenuD = {new BevMenu("Mineral Water", 3.00),
                new BevMenu("Teh Tarik", 2.50),
                new BevMenu("Chinese Tea", 1.90),
                new BevMenu("Syrup Bandung", 2.50),
        };

        //Hotel E Menu
        TransMenu[] transMenuE = {new TransMenu("Valet Parking", 120.00),
                new TransMenu("Taxi from KLIA", 85.00),
                new TransMenu("Taxi from KLIA2", 85.00),
                new TransMenu("Taxi from KL Sentral", 50.00),
        };

        FoodMenu[] foodMenuE = {new FoodMenu("Rib Eye Steak", 50.00),
                new FoodMenu("Sashimi and Sushi", 65.00),
                new FoodMenu("Dim Sum", 65.00),
                new FoodMenu("Malay Cuisine", 30.00),
        };

        BevMenu[] bevMenuE = {new BevMenu("Cocktails", 50.00),
                new BevMenu("Red Vine", 65.00),
                new BevMenu("Premium Honey", 65.00),
                new BevMenu("Blue Mountain Coffee", 30.00),
        };

        double subTotal = 0;

        //Array to record Service order
        ArrayList<FoodMenu> foodOrders = new ArrayList<>();
        ArrayList<BevMenu> bevOrders = new ArrayList<>();
        ArrayList<TransMenu> transOrders = new ArrayList<>();
        FoodMenu fOrder = new FoodMenu();
        BevMenu bOrder = new BevMenu();
        TransMenu tOrder = new TransMenu();

        String hotelChoice = selectedHotel.getHotelName();

        if (hotelChoice.equals("Holiday Inn Subang Jaya")) {
            boolean validService = true;
            while (validService) {
                displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Holiday Inn Subang Hotel Transport Service");
                    for (int i = 0; i < transMenuA.length; i++) {
                        System.out.printf("%-4d%-25sRM %.2f%n", i + 1, transMenuA[i].getName(), transMenuA[i].getPrice());
                    }
                    boolean validateTrans = true;
                    while (validateTrans) {

                        int t;
                        int tQty;

                        System.out.println();
                        System.out.println("Which transport service you require? : ");
                        String transChoice = scan.nextLine();
                        System.out.println("How many transport service you require?: ");
                        String transQty = scan.nextLine();
                        try {
                            t = Integer.parseInt(transChoice);
                            tQty = Integer.parseInt(transQty);
                            if (t >= 1 && t <= 4) {
                                tOrder.setPrice(transMenuA[t - 1].getPrice());
                                tOrder.setQuantity(tQty);
                                transOrders.add(new TransMenu(transMenuA[t - 1].getName(), tOrder.getPrice(), tQty));
                                break;
                            }  else
                                System.out.println("Invalid input for transport service. Please choose between 1-4.");
                            validateTrans = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateTrans = true;
                        }

                    }

                } else if (selection.equals("2")) {
                    System.out.println("Holiday Inn Subang Hotel Food Service");
                    for (int i = 0; i < transMenuA.length; i++) {
                        System.out.printf("%-4d%-25sRM %.2f%n", i + 1, foodMenuA[i].getName(), foodMenuA[i].getPrice());
                    }
                    boolean validateFood = true;
                    while (validateFood) {

                        int f;
                        int fQty;
                        System.out.println();
                        System.out.println("What would you like to eat? : ");
                        String foodChoice = scan.nextLine();
                        System.out.println("How many would you like to order?: ");
                        String foodQty = scan.nextLine();
                        try {
                            f = Integer.parseInt(foodChoice);
                            fQty = Integer.parseInt(foodQty);
                            if (f >= 1 && f <= 4) {
                                fOrder.setPrice(foodMenuA[f - 1].getPrice());
                                fOrder.setQuantity(fQty);
                                foodOrders.add(new FoodMenu(foodMenuA[f - 1].getName(), fOrder.getPrice(), fQty));
                                break;
                            }  else
                                System.out.println("Invalid input for food choice. Please choose between 1-4.");
                            validateFood = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateFood = true;
                        }

                    }
                } else if (selection.equals("3")) {
                    System.out.println("Holiday Inn Subang Hotel Beverage Service");
                    for (int i = 0; i < bevMenuA.length; i++) {
                        System.out.printf("%-4d%-25sRM %.2f%n", i + 1, bevMenuA[i].getName(), bevMenuA[i].getPrice());
                    }
                    boolean validateBev = true;
                    while (validateBev) {
                        int b;
                        int bQty;
                        System.out.println();
                        System.out.println("What would you like to drink? : ");
                        String bevChoice = scan.nextLine();
                        System.out.println("How many would you like to order?: ");
                        String bevQty = scan.nextLine();
                        try {
                            b = Integer.parseInt(bevChoice);
                            bQty = Integer.parseInt(bevQty);
                            if (b >= 1 && b <= 4) {
                                bOrder.setPrice(bevMenuA[b - 1].getPrice());
                                bOrder.setQuantity(bQty);
                                bevOrders.add(new BevMenu(bevMenuA[b - 1].getName(), bOrder.getPrice(), bQty));
                                break;
                            }  else
                                System.out.println("Invalid input for beverage choice. Please choose between 1-4.");
                            validateBev = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateBev = true;
                        }
                    }
                } else if (selection.equals("4")) {
                    break;
                } else {
                    System.out.println("Invalid selection, please try again.");
                    validService = true;
                }

            }
            System.out.println();
            System.out.println("Your transport orders:");
            for (int i = 0; i < transOrders.size(); i++) {
                TransMenu transOrder = transOrders.get(i);
                double transSubTotal = transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), transOrder.getName(), transOrder.getQuantity(),"x", transSubTotal);
                subTotal += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrders.size(); i++) {
                FoodMenu foodOrder = foodOrders.get(i);
                double foodSubTotal = foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), foodOrder.getName(), foodOrder.getQuantity(),"x", foodSubTotal);
                subTotal += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrders.size(); i++) {
                BevMenu bevOrder = bevOrders.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), bevOrder.getName(), bevOrder.getQuantity(),"x", bevSubTotal);
                subTotal += bevSubTotal;
            }
            System.out.print("\n-------------Service Details----------------");
            System.out.println("\nService Price   : RM" + String.format("%.2f",subTotal));
            System.out.print("--------------------------------------------");
            fd.setServiceSubtotal(subTotal);

        } else if (hotelChoice.equals("Hilton Kuala Lumpur")) {
            boolean validService = true;
            while (validService) {
                displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Hilton Kuala Lumpur Hotel Transport Service");
                    for (int i = 0; i < transMenuB.length; i++) {
                        System.out.printf("%-4d%-25sRM %.2f%n", i + 1, transMenuB[i].getName(), transMenuB[i].getPrice());
                    }
                    boolean validateTrans = true;
                    while (validateTrans) {

                        int t;
                        int tQty;

                        System.out.println();
                        System.out.println("Which transport service you require? : ");
                        String transChoice = scan.nextLine();
                        System.out.println("How many transport service you require?: ");
                        String transQty = scan.nextLine();
                        try {
                            t = Integer.parseInt(transChoice);
                            tQty = Integer.parseInt(transQty);
                            if (t >= 1 && t <= 4) {
                                tOrder.setPrice(transMenuB[t - 1].getPrice());
                                tOrder.setQuantity(tQty);
                                transOrders.add(new TransMenu(transMenuB[t - 1].getName(), tOrder.getPrice(), tQty));
                                break;
                            }  else
                                System.out.println("Invalid input for transport service. Please choose between 1-4.");
                            validateTrans = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateTrans = true;
                        }

                    }

                } else if (selection.equals("2")) {
                    System.out.println("Hilton Kuala Lumpur Hotel Food Service");
                    for (int i = 0; i < foodMenuB.length; i++) {
                        System.out.printf("%-4d%-25sRM %.2f%n", i + 1, foodMenuB[i].getName(), foodMenuB[i].getPrice());
                    }
                    boolean validateFood = true;
                    while (validateFood) {

                        int f;
                        int fQty;
                        System.out.println();
                        System.out.println("What would you like to eat? : ");
                        String foodChoice = scan.nextLine();
                        System.out.println("How many would you like to order?: ");
                        String foodQty = scan.nextLine();
                        try {
                            f = Integer.parseInt(foodChoice);
                            fQty = Integer.parseInt(foodQty);
                            if (f >= 1 && f <= 4) {
                                fOrder.setPrice(foodMenuB[f - 1].getPrice());
                                fOrder.setQuantity(fQty);
                                foodOrders.add(new FoodMenu(foodMenuB[f - 1].getName(), fOrder.getPrice(), fQty));
                                break;
                            }  else
                                System.out.println("Invalid input for food choice. Please choose between 1-4.");
                            validateFood = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateFood = true;
                        }

                    }
                } else if (selection.equals("3")) {
                    System.out.println("Hilton Kuala Lumpur Hotel Beverage Service");
                    for (int i = 0; i < bevMenuB.length; i++) {
                        System.out.printf("%-4d%-25sRM %.2f%n", i + 1, bevMenuB[i].getName(), bevMenuB[i].getPrice());
                    }
                    boolean validateBev = true;
                    while (validateBev) {
                        int b;
                        int bQty;
                        System.out.println();
                        System.out.println("What would you like to drink? : ");
                        String bevChoice = scan.nextLine();
                        System.out.println("How many would you like to order?: ");
                        String bevQty = scan.nextLine();
                        try {
                            b = Integer.parseInt(bevChoice);
                            bQty = Integer.parseInt(bevQty);
                            if (b >= 1 && b <= 4) {
                                bOrder.setPrice(bevMenuB[b - 1].getPrice());
                                bOrder.setQuantity(bQty);
                                bevOrders.add(new BevMenu(bevMenuB[b - 1].getName(), bOrder.getPrice(), bQty));
                                break;
                            }  else
                                System.out.println("Invalid input for beverage choice. Please choose between 1-4.");
                            validateBev = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateBev = true;
                        }
                    }
                } else if (selection.equals("4")) {
                    break;
                } else {
                    System.out.println("Invalid selection, please try again.");
                    validService = true;
                }

            }
            System.out.println();
            System.out.println("Your transport orders:");
            for (int i = 0; i < transOrders.size(); i++) {
                TransMenu transOrder = transOrders.get(i);
                double transSubTotal = transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), transOrder.getName(), transOrder.getQuantity(),"x", transSubTotal);
                subTotal += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrders.size(); i++) {
                FoodMenu foodOrder = foodOrders.get(i);
                double foodSubTotal = foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), foodOrder.getName(), foodOrder.getQuantity(),"x", foodSubTotal);
                subTotal += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrders.size(); i++) {
                BevMenu bevOrder = bevOrders.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), bevOrder.getName(), bevOrder.getQuantity(),"x", bevSubTotal);
                subTotal += bevSubTotal;
            }
            System.out.print("\n-------------Service Details----------------");
            System.out.println("\nService Price   : RM" + String.format("%.2f",subTotal));
            System.out.print("--------------------------------------------");
            fd.setServiceSubtotal(subTotal);
        } else if (hotelChoice.equals("Hard Rock Kuala Lumpur")) {
            boolean validService = true;
            while (validService) {
                displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Hard Rock Kuala Lumpur Hotel Transport Service");
                    for (int i = 0; i < transMenuC.length; i++) {
                        System.out.printf("%-4d%-25sRM %.2f%n", i + 1, transMenuC[i].getName(), transMenuC[i].getPrice());
                    }
                    boolean validateTrans = true;
                    while (validateTrans) {

                        int t;
                        int tQty;

                        System.out.println();
                        System.out.println("Which transport service you require? : ");
                        String transChoice = scan.nextLine();
                        System.out.println("How many transport service you require?: ");
                        String transQty = scan.nextLine();
                        try {
                            t = Integer.parseInt(transChoice);
                            tQty = Integer.parseInt(transQty);
                            if (t >= 1 && t <= 4) {
                                tOrder.setPrice(transMenuC[t - 1].getPrice());
                                tOrder.setQuantity(tQty);
                                transOrders.add(new TransMenu(transMenuC[t - 1].getName(), tOrder.getPrice(), tQty));
                                break;
                            }  else
                                System.out.println("Invalid input for transport service. Please choose between 1-4.");
                            validateTrans = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateTrans = true;
                        }

                    }

                } else if (selection.equals("2")) {
                    System.out.println("Hard Rock Kuala Lumpur Hotel Food Service");
                    for (int i = 0; i < foodMenuC.length; i++) {
                        System.out.printf("%-4d%-25sRM %.2f%n", i + 1, foodMenuC[i].getName(), foodMenuC[i].getPrice());
                    }
                    boolean validateFood = true;
                    while (validateFood) {

                        int f;
                        int fQty;
                        System.out.println();
                        System.out.println("What would you like to eat? : ");
                        String foodChoice = scan.nextLine();
                        System.out.println("How many would you like to order?: ");
                        String foodQty = scan.nextLine();
                        try {
                            f = Integer.parseInt(foodChoice);
                            fQty = Integer.parseInt(foodQty);
                            if (f >= 1 && f <= 4) {
                                fOrder.setPrice(foodMenuC[f - 1].getPrice());
                                fOrder.setQuantity(fQty);
                                foodOrders.add(new FoodMenu(foodMenuC[f - 1].getName(), fOrder.getPrice(), fQty));
                                break;
                            }  else
                                System.out.println("Invalid input for food choice. Please choose between 1-4.");
                            validateFood = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateFood = true;
                        }

                    }
                } else if (selection.equals("3")) {
                    System.out.println("Hard Rock Kuala Lumpur Hotel Beverage Service");
                    for (int i = 0; i < bevMenuC.length; i++) {
                        System.out.printf("%-4d%-25sRM %.2f%n", i + 1, bevMenuC[i].getName(), bevMenuC[i].getPrice());
                    }
                    boolean validateBev = true;
                    while (validateBev) {
                        int b;
                        int bQty;
                        System.out.println();
                        System.out.println("What would you like to drink? : ");
                        String bevChoice = scan.nextLine();
                        System.out.println("How many would you like to order?: ");
                        String bevQty = scan.nextLine();
                        try {
                            b = Integer.parseInt(bevChoice);
                            bQty = Integer.parseInt(bevQty);
                            if (b >= 1 && b <= 4) {
                                bOrder.setPrice(bevMenuC[b - 1].getPrice());
                                bOrder.setQuantity(bQty);
                                bevOrders.add(new BevMenu(bevMenuC[b - 1].getName(), bOrder.getPrice(), bQty));
                                break;
                            }  else
                                System.out.println("Invalid input for beverage choice. Please choose between 1-4.");
                            validateBev = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateBev = true;
                        }
                    }
                } else if (selection.equals("4")) {
                    break;
                } else {
                    System.out.println("Invalid selection, please try again.");
                    validService = true;
                }

            }
            System.out.println();
            System.out.println("Your transport orders:");
            for (int i = 0; i < transOrders.size(); i++) {
                TransMenu transOrder = transOrders.get(i);
                double transSubTotal = transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), transOrder.getName(), transOrder.getQuantity(),"x", transSubTotal);
                subTotal += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrders.size(); i++) {
                FoodMenu foodOrder = foodOrders.get(i);
                double foodSubTotal = foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), foodOrder.getName(), foodOrder.getQuantity(),"x", foodSubTotal);
                subTotal += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrders.size(); i++) {
                BevMenu bevOrder = bevOrders.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), bevOrder.getName(), bevOrder.getQuantity(),"x", bevSubTotal);
                subTotal += bevSubTotal;
            }
            System.out.print("\n-------------Service Details----------------");
            System.out.println("\nService Price   : RM" + String.format("%.2f",subTotal));
            System.out.print("--------------------------------------------");
            fd.setServiceSubtotal(subTotal);
        } else if (hotelChoice.equals("Sepang Resort")) {
            boolean validService = true;
            while (validService) {
                displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Sepang Resort Hotel Transport Service");
                    for (int i =0; i < transMenuD.length;i ++){
                        System.out.printf("%-4d%-25sRM %.2f%n",i+1 ,   transMenuD[i].getName() ,  transMenuD[i].getPrice());
                    }
                    boolean validateTrans = true;
                    while (validateTrans) {
                        int t;
                        int tQty;

                        System.out.println();
                        System.out.println("Which transport service you require? : ");
                        String transChoice = scan.nextLine();
                        System.out.println("How many transport service you require?: ");
                        String transQty = scan.nextLine();
                        try {
                            t = Integer.parseInt(transChoice);
                            tQty = Integer.parseInt(transQty);
                            if (t >= 1 && t <= 4) {
                                tOrder.setPrice(transMenuD[t - 1].getPrice());
                                tOrder.setQuantity(tQty);
                                transOrders.add(new TransMenu(transMenuD[t - 1].getName(), tOrder.getPrice(), tQty));
                                break;
                            }  else
                                System.out.println("Invalid input for transport service. Please choose between 1-4.");
                            validateTrans = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateTrans = true;
                        }

                    }

                } else if (selection.equals("2")) {
                    System.out.println("Sepang Resort Hotel Food Service");
                    for (int i =0; i < foodMenuD.length;i ++){
                        System.out.printf("%-4d%-25sRM %.2f%n",i+1 ,   foodMenuD[i].getName() ,  foodMenuD[i].getPrice());
                    }
                    boolean validateFood = true;
                    while (validateFood) {

                        int f;
                        int fQty;
                        System.out.println();
                        System.out.println("What would you like to eat? : ");
                        String foodChoice = scan.nextLine();
                        System.out.println("How many would you like to order?: ");
                        String foodQty = scan.nextLine();
                        try {
                            f = Integer.parseInt(foodChoice);
                            fQty = Integer.parseInt(foodQty);
                            if (f >= 1 && f <= 4) {
                                fOrder.setPrice(foodMenuD[f - 1].getPrice());
                                fOrder.setQuantity(fQty);
                                foodOrders.add(new FoodMenu(foodMenuD[f - 1].getName(), fOrder.getPrice(), fQty));
                                break;
                            }  else
                                System.out.println("Invalid input for food choice. Please choose between 1-4.");
                            validateFood = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateFood = true;
                        }

                    }
                } else if (selection.equals("3")) {
                    System.out.println("Sepang Resort Hotel Beverage Service");
                    for (int i =0; i < bevMenuD.length;i ++){
                        System.out.printf("%-4d%-25sRM %.2f%n",i+1 ,   bevMenuD[i].getName() ,  bevMenuD[i].getPrice());
                    }
                    boolean validateBev = true;
                    while (validateBev) {
                        int b;
                        int bQty;
                        System.out.println();
                        System.out.println("What would you like to drink? : ");
                        String bevChoice = scan.nextLine();
                        System.out.println("How many would you like to order?: ");
                        String bevQty = scan.nextLine();
                        try {
                            b = Integer.parseInt(bevChoice);
                            bQty = Integer.parseInt(bevQty);
                            if (b >= 1 && b <= 4) {
                                bOrder.setPrice(bevMenuD[b - 1].getPrice());
                                bOrder.setQuantity(bQty);
                                bevOrders.add(new BevMenu(bevMenuD[b - 1].getName(), bOrder.getPrice(), bQty));
                                break;
                            }  else
                                System.out.println("Invalid input for beverage choice. Please choose between 1-4.");
                            validateBev = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateBev = true;
                        }
                    }
                } else if (selection.equals("4")) {
                    break;
                } else {
                    System.out.println("Invalid selection, please try again.");
                    validService = true;
                }

            }
            System.out.println();
            System.out.println("Your transport orders:");
            for (int i = 0; i < transOrders.size(); i++) {
                TransMenu transOrder = transOrders.get(i);
                double transSubTotal = transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), transOrder.getName(), transOrder.getQuantity(),"x", transSubTotal);
                subTotal += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrders.size(); i++) {
                FoodMenu foodOrder = foodOrders.get(i);
                double foodSubTotal = foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), foodOrder.getName(), foodOrder.getQuantity(),"x", foodSubTotal);
                subTotal += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrders.size(); i++) {
                BevMenu bevOrder = bevOrders.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), bevOrder.getName(), bevOrder.getQuantity(),"x", bevSubTotal);
                subTotal += bevSubTotal;
            }

            System.out.println("Thank you for ordering services. \nTotal Amount for services is RM " + String.format("%.2f",subTotal));
            fd.setServiceSubtotal(subTotal);


        } else if (hotelChoice.equals("Le Meridien Kuala Lumpur")) {
            boolean validService = true;
            while (validService) {
                displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Le Meridien Kuala Lumpur Transport Service");
                    for (int i =0; i < transMenuE.length;i ++){
                        System.out.printf("%-4d%-25sRM %.2f%n",i+1 ,   transMenuE[i].getName() ,  transMenuE[i].getPrice());
                    }
                    boolean validateTrans = true;
                    while (validateTrans) {

                        int t;
                        int tQty;

                        System.out.println();
                        System.out.println("Which transport service you require? : ");
                        String transChoice = scan.nextLine();
                        System.out.println("How many transport service you require?: ");
                        String transQty = scan.nextLine();
                        try {
                            t = Integer.parseInt(transChoice);
                            tQty = Integer.parseInt(transQty);
                            if (t >= 1 && t <= 4) {
                                tOrder.setPrice(transMenuE[t - 1].getPrice());
                                tOrder.setQuantity(tQty);
                                transOrders.add(new TransMenu(transMenuE[t - 1].getName(), tOrder.getPrice(), tQty));
                                break;
                            }  else
                                System.out.println("Invalid input for transport service. Please choose between 1-4.");
                            validateTrans = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateTrans = true;
                        }

                    }

                } else if (selection.equals("2")) {
                    System.out.println("Le Meridien Kuala Lumpur Hotel Food Service");
                    for (int i =0; i < foodMenuE.length;i ++){
                        System.out.printf("%-4d%-25sRM %.2f%n",i+1 ,   foodMenuE[i].getName() ,  foodMenuE[i].getPrice());
                    }
                    boolean validateFood = true;
                    while (validateFood) {

                        int f;
                        int fQty;
                        System.out.println();
                        System.out.println("What would you like to eat? : ");
                        String foodChoice = scan.nextLine();
                        System.out.println("How many would you like to order?: ");
                        String foodQty = scan.nextLine();
                        try {
                            f = Integer.parseInt(foodChoice);
                            fQty = Integer.parseInt(foodQty);
                            if (f >= 1 && f <= 4) {
                                fOrder.setPrice(foodMenuE[f - 1].getPrice());
                                fOrder.setQuantity(fQty);
                                foodOrders.add(new FoodMenu(foodMenuE[f - 1].getName(), fOrder.getPrice(), fQty));
                                break;
                            }  else
                                System.out.println("Invalid input for food choice. Please choose between 1-4.");
                            validateFood = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateFood = true;
                        }

                    }
                } else if (selection.equals("3")) {
                    System.out.println("Le Meridien Kuala Lumpur Hotel Beverage Service");
                    for (int i =0; i < bevMenuE.length;i ++){
                        System.out.printf("%-4d%-25sRM %.2f%n",i+1 ,   bevMenuE[i].getName() ,  bevMenuE[i].getPrice());
                    }
                    boolean validateBev = true;
                    while (validateBev) {
                        int b;
                        int bQty;
                        System.out.println();
                        System.out.println("What would you like to drink? : ");
                        String bevChoice = scan.nextLine();
                        System.out.println("How many would you like to order?: ");
                        String bevQty = scan.nextLine();
                        try {
                            b = Integer.parseInt(bevChoice);
                            bQty = Integer.parseInt(bevQty);
                            if (b >= 1 && b <= 4) {
                                bOrder.setPrice(bevMenuE[b - 1].getPrice());
                                bOrder.setQuantity(bQty);
                                bevOrders.add(new BevMenu(bevMenuE[b - 1].getName(), bOrder.getPrice(), bQty));
                                break;
                            }  else
                                System.out.println("Invalid input for beverage choice. Please choose between 1-4.");
                            validateBev = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateBev = true;
                        }
                    }
                } else if (selection.equals("4")) {
                    break;
                } else {
                    System.out.println("Invalid selection, please try again.");
                    validService = true;
                }

            }
            System.out.println();
            System.out.println("Your transport orders:");
            for (int i = 0; i < transOrders.size(); i++) {
                TransMenu transOrder = transOrders.get(i);
                double transSubTotal = transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), transOrder.getName(), transOrder.getQuantity(),"x", transSubTotal);
                subTotal += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrders.size(); i++) {
                FoodMenu foodOrder = foodOrders.get(i);
                double foodSubTotal = foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), foodOrder.getName(), foodOrder.getQuantity(),"x", foodSubTotal);
                subTotal += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrders.size(); i++) {
                BevMenu bevOrder = bevOrders.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), bevOrder.getName(), bevOrder.getQuantity(),"x", bevSubTotal);
                subTotal += bevSubTotal;
            }
            System.out.print("\n-------------Service Details----------------");
            System.out.println("\nService Price   : RM" + String.format("%.2f",subTotal));
            System.out.print("--------------------------------------------");

            fd.setServiceSubtotal(subTotal);

        } else {
            System.out.println("Invalid input");
        }

    }
    public static void displayServiceMenu(){
        System.out.println();
        System.out.println("""
                
                  ______   ________  _______  ____   ____  _____   ______  ________   ____    ____  ________  ____  _____  _____  _____ \s
                .' ____ \\ |_   __  ||_   __ \\|_  _| |_  _||_   _|.' ___  ||_   __  | |_   \\  /   _||_   __  ||_   \\|_   _||_   _||_   _|\s
                | (___ \\_|  | |_ \\_|  | |__) | \\ \\   / /    | | / .'   \\_|  | |_ \\_|   |   \\/   |    | |_ \\_|  |   \\ | |    | |    | |  \s
                 _.____`.   |  _| _   |  __ /   \\ \\ / /     | | | |         |  _| _    | |\\  /| |    |  _| _   | |\\ \\| |    | '    ' |  \s
                | \\____) | _| |__/ | _| |  \\ \\_  \\ ' /     _| |_\\ `.___.'\\ _| |__/ |  _| |_\\/_| |_  _| |__/ | _| |_\\   |_    \\ \\__/ /   \s
                 \\______.'|________||____| |___|  \\_/     |_____|`.____ .'|________| |_____||_____||________||_____|\\____|    `.__.'    \s
                                                                                                                                        \s
                """);
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%79s","                  1.Transport Menu                   \n");
        System.out.printf("%79s","                  2.Foods Menu                       \n");
        System.out.printf("%79s","                  3.Beverage Menu                    \n");
        System.out.printf("%79s","                  4.Exit                             \n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%70s","            PLEASE SELECT THE MENU CATEGORY          \n");
    }

    public static void topupProcess(Customer customer) {
        boolean validtopup = true;
        Scanner input = new Scanner(System.in);

        //Display user details and account balance
        wallet.topupHeader();

        //Input top up amount

        System.out.println("=============Enter Top Up Amount============");

        do {
            try {
                System.out.print("Top Up Amount > ");
                int topupAmount = input.nextInt();

                if (topupAmount <= 0) {
                    throw new IllegalArgumentException("Please Enter a Valid Amount");
                } else {
                    wallet.addFunds(customer, topupAmount);
                    System.out.println("\n-------Top Up Successful-------");

                    System.out.println("==============================");
                    System.out.println("Current balance : RM" + customer.getBalance() );
                    System.out.println("==============================");
                    if (wallet.getToupAmount() >= 2000){
                        member.setTier("Diamond");
                        member.setPoints(wallet.getToupAmount());
                        System.out.println("Congratulation! You achieve " + member.getTier() + " tier now.");
                        System.out.println("You can now enjoy " + member.getDiscount() *100 + "% discount for you payment.");
                    } else if (wallet.getToupAmount() >= 1500) {
                        member.setTier("Gold");
                        member.setPoints(wallet.getToupAmount());
                        System.out.println("Congratulation! You achieve " + member.getTier() + " tier now.");
                        System.out.println("You can now enjoy " + member.getDiscount() *100 + "% discount for you payment.");
                    }else if(wallet.getToupAmount() >= 1000){
                        member.setTier("Silver");
                        member.setPoints(wallet.getToupAmount());
                        System.out.println("Congratulation! You achieve " + member.getTier() + " tier now.");
                        System.out.println("You can now enjoy " + member.getDiscount() *100 + "% discount for you payment.");
                    }else if(wallet.getToupAmount() >= 500){
                        member.setTier("Bronze");
                        member.setPoints(wallet.getToupAmount());
                        System.out.println("Congratulation! You achieve " + member.getTier() + " tier now.");
                        System.out.println("You can now enjoy " + member.getDiscount() *100 + "% discount for you payment.");
                    }else {
                        member.setTier("Non");
                    }
                    validtopup = true;
                }
            } catch (InputMismatchException e) {
                validtopup = false;
                System.out.println("Please Enter a Valid Amount");
                input.nextLine(); // clear the input buffer
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                validtopup = false;
            }

        } while (validtopup == false);

    }

    public static void inputCustDetail(Customer customer, Scanner input){

        boolean validIC = true;
        boolean validContact = true;
        boolean validEmail = true;

        //Header
        System.out.println("=====================================================");
        System.out.println("|         __     ______  _    _ _____               |\n" +
                "|         \\ \\   / / __ \\| |  | |  __ \\              |\n" +
                "|          \\ \\_/ / |  | | |  | | |__) |             |\n" +
                "|           \\   /| |  | | |  | |  _  /              |\n" +
                "|            | | | |__| | |__| | | \\ \\              |\n" +
                "|  _____  ___|_| _\\____/ \\____/|_|__\\_\\      _____  |\n" +
                "| |  __ \\|  ____|__   __|/\\   |_   _| |     / ____| |\n" +
                "| | |  | | |__     | |  /  \\    | | | |    | (___   |\n" +
                "| | |  | |  __|    | | / /\\ \\   | | | |     \\___ \\  |\n" +
                "| | |__| | |____   | |/ ____ \\ _| |_| |____ ____) | |\n" +
                "| |_____/|______|  |_/_/    \\_\\_____|______|_____/  |");
        System.out.println("=====================================================");

        //Prompt User Input
        System.out.println("---------------------Create Your Profile-----------------------");
        System.out.print("Enter Your Name :");
        String name = input.next();
        input.nextLine();

        customer.setCustName(name);

        //Get Customer IC
        do {
            System.out.print("\nEnter Your IC (xxxxxx-xx-xxxx): ");
            String IC = input.nextLine();

            // Check for the format of Malaysia IC (format: 000000-00-0000)
            String icPattern = "\\d{6}-\\d{2}-\\d{4}";

            try {
                if (IC.matches(icPattern)) {
                    validIC = true;
                    customer.setCustIc(IC);
                } else {
                    throw new IllegalArgumentException("\nInvalid IC format. Please enter a valid Malaysian IC number (format: 000000-00-0000).");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage() + "\nPlease Try Again\n");
                validIC = false;
            }
        } while (!validIC);


        //Get Customer Contact
        do {
            System.out.print("Enter Your Contact Number (xxx-xxxxxxx): ");
            String contact = input.next();
            try {
                // Check if contact number contains only digits and is exactly 10 digits long
                if (contact.matches("\\d{3}-\\d{7}") || contact.matches("\\d{3}-\\d{8}")) {
                    customer.setContact(contact);
                    validContact = true;
                } else {
                    throw new IllegalArgumentException("\nInvalid contact number. Please enter you contact with dash.ln");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                validContact = false;
            }
        } while (!validContact);

        //Get Customer Email
        do {
            System.out.print("Enter Your Email Address : ");
            String email = input.next();

            // Check if email is valid using regular expression
            if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                System.out.println("\nPlease Enter a Valid Email Address\n");
                validEmail = false;
            } else {
                customer.setEmail(email);
                validEmail = true;
            }
        } while (validEmail == false);

        System.out.println("   ------Profile Created------  ");

    }

    public static void DisplayProfile(Customer customer){

        //Display header
        System.out.println("=======================================================");
        System.out.println("|  _____  _____   ____  ______ _____ _      ______  |\n" +
                "| |  __ \\|  __ \\ / __ \\|  ____|_   _| |    |  ____| |\n" +
                "| | |__) | |__) | |  | | |__    | | | |    | |__    |\n" +
                "| |  ___/|  _  /| |  | |  __|   | | | |    |  __|   |\n" +
                "| | |    | | \\ \\| |__| | |     _| |_| |____| |____  |\n" +
                "| |_|    |_|  \\_\\\\____/|_|    |_____|______|______| |\n" +
                "                                                  ");
        System.out.println("=======================================================");

        //Display Customer Data

        System.out.println("Name            : " + customer.getCustName());
        System.out.println("IC              : " + customer.getCustIc());
        System.out.println("Contact         : " + customer.getContact());
        System.out.println("Email           : " + customer.getEmail());
        System.out.println("Account Balance : " + customer.getBalance());
        System.out.println("=======================================================");
    }
}
