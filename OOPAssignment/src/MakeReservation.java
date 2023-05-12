import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MakeReservation {
    public static void main(String[] args) {
        boolean validpax = true;
        boolean validdate = true;
        int balanceChoice;
        Customer customer = new Customer();
        Reservation reservation = new Reservation();
        TopUp topUp = new TopUp();
        Scanner input = new Scanner(System.in);
        MakeReservation obj = new MakeReservation();


        //-------------------------------------Make reservation---------------------------------------------
        //Display header

        reservation.ReservationHeader();

        //Get hotel name
        String hotelname = hotel.getHotelName();
        System.out.println("You are currently booking for : " + hotel);

        //Get check in check out date

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

        //Get number of pax

        do {
            System.out.println("Enter number of pax : ");
            int pax = input.nextInt();

            if (pax <= 0) {
                validpax = false;
                System.out.println("Please Enter Valid Number Of Pax");
            } else if (pax > 16) {
                validpax = false;
                System.out.println("No Suitable Room For More Than 16 Pax\nPlease Try Again");
            } else
                validpax = true;
                reservation.setPax(pax);
        } while (validpax = false);

        //Display Room Type Available

        //Prompt User choose room type

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
            } else if (balanceChoice == 2){
                //Proceed to payment
            }else
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
        Service service = new Service();
        Payment payment = new Payment();

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
        System.out.println("    Hotel          : " + hotel.hotelName);
        System.out.println("    Room Type      : " + reservation.getRoomType());
        System.out.println("    Pax            : " + reservation.getPax());
        System.out.println("    Check In Date  : " + reservation.getCheckindate());
        System.out.println("    Check Out Date : " + reservation.getCheckoutdate());
        System.out.println("    Service        : " + service.getService());
        System.out.println("    Payment Amount : RM" + payment.getTotal());
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
        Service service = new Service();
        Payment payment = new Payment();
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

                reservation.setHotel(/*choice*/);

                //Display Room Type
                System.out.println("Select Room Type : ");
                int roomchoice = input.nextInt();

                reservation.setRoomType(/*choice*/);

                //Calculate new subtotal


            case 2 :
                //Disply room type

                //Prompt user to select new room type
                System.out.println("Select New Room Type : ");
                int roomTypechoice = input.nextInt();

                roomTypechoice = reservation.setRoomType(/*choice*/);

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
                        reservation.setRoomType(null);
                        reservation.setCheckindate(null);
                        reservation.setCheckoutdate(null);
                        reservation.setService(null);
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
        System.out.println("    Name           : " + reservation.getCustName());
        System.out.println("    Contact        : " + reservation.getContact());
        System.out.println("    Hotel          : " + reservation.getHotel());
        System.out.println("    Room Type      : " + reservation.getRoomType());
        System.out.println("    Check In Date  : " + reservation.getCheckindate());
        System.out.println("    Check Out Date : " + reservation.getCheckoutdate());
        System.out.println("    Pax            : "+ reservation.getPax());
        System.out.println("    Service        : " + reservation.getService());
        System.out.println("============================================");



    }







}
