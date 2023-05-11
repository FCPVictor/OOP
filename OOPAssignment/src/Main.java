import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
public class Main {

    /**
     * public class UserLogin {
     *     private static User currentLoggedInUser;
     *
     *     public static User getCurrentLoggedInUser() {
     *         if(currentLoggedInUser == null) {
     *             return new User();
     *         }
     *         return currentLoggedInUser;
     *     }
     *
     *     public static void setCurrentLoggedInUser(User user) {
     *         currentLoggedInUser = user;
     *     }
     *
     * }
     *
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


            public static void main(String[] args) {
                User user = null;
                DA da = new DA();
                double subtotal = 0.0;

                Scanner scanner = new Scanner(System.in);

                //Prompt welcome msg
                welcomeScreen();
                do {
                    displayMenu();
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
                        printArtWork(2);
                        // Prompt the user to enter their username and password
                        System.out.print("Enter your username: ");
                        String username = scanner1.nextLine();

                        System.out.print("Enter your password: ");
                        String password = scanner1.nextLine();

                        da.insertRecord(username, password);

                    } else if (userOption == 1) {
                        Scanner scanner2 = new Scanner(System.in);
                        printArtWork(1);
                        try {
                            System.out.print("Enter your username to login: ");
                            String username = scanner2.nextLine();

                            System.out.print("Enter your password to login: ");
                            String password = scanner2.nextLine();

                            ResultSet rs = da.readRecord(username, password);
                            if (rs.next()) {
                                user = new User();
                                user.setUsername(username);
                                user.setPassword(password);
                                System.out.println("Logged in successfully");
                            }else{
                                System.out.println("Invalid username or password");
                            }
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } while (user == null);


                //Payment part





            }
    public static void welcomeScreen(){

        String artwork;

        artwork = """

                    888       888          888                                                \s
                    888   o   888          888                                                \s
                    888  d8b  888          888                                                \s
                    888 d888b 888  .d88b.  888  .d8888b  .d88b.  88888b.d88b.   .d88b.        \s
                    888d88888b888 d8P  Y8b 888 d88P"    d88""88b 888 "888 "88b d8P  Y8b       \s
                    88888P Y88888 88888888 888 888      888  888 888  888  888 88888888       \s
                    8888P   Y8888 Y8b.     888 Y88b.    Y88..88P 888  888  888 Y8b.           \s
                    888P     Y888  "Y8888  888  "Y8888P  "Y88P"  888  888  888  "Y8888        \s
                   
                    """;

        System.out.println(artwork);
    }

    public static void displayMenu(){
        System.out.println("\n\n\t\t(a) Press 0 to Exit.");
        System.out.println("\t\t(b) Press 1 to Login");
        System.out.println("\t\t(c) Press 2 to Register");
        System.out.print("\t\tEnter the desired option:    ");
    }

    public static void printArtWork(int option){

        String artWork;
        if (option == 1){
            artWork = """

                     .o88b. db    db .d8888. d888888b  .d88b.  .88b  d88. d88888b d8888b.      db       .d88b.   d888b  d888888b d8b   db\s
                    d8P  Y8 88    88 88'  YP `~~88~~' .8P  Y8. 88'YbdP`88 88'     88  `8D      88      .8P  Y8. 88' Y8b   `88'   888o  88\s
                    8P      88    88 `8bo.      88    88    88 88  88  88 88ooooo 88oobY'      88      88    88 88         88    88V8o 88\s
                    8b      88    88   `Y8b.    88    88    88 88  88  88 88~~~~~ 88`8b        88      88    88 88  ooo    88    88 V8o88\s
                    Y8b  d8 88b  d88 db   8D    88    `8b  d8' 88  88  88 88.     88 `88.      88booo. `8b  d8' 88. ~8~   .88.   88  V888\s
                     `Y88P' ~Y8888P' `8888Y'    YP     `Y88P'  YP  YP  YP Y88888P 88   YD      Y88888P  `Y88P'   Y888P  Y888888P VP   V8P\s
                                                                                                                                         \s
                                                                                                                                         \s
                    """;
            System.out.println(artWork);
        } else if (option == 2) {
            artWork = """

                     .o88b. db    db .d8888. d888888b  .d88b.  .88b  d88. d88888b d8888b.      .d8888. d888888b  d888b  d8b   db db    db d8888b.\s
                    d8P  Y8 88    88 88'  YP `~~88~~' .8P  Y8. 88'YbdP`88 88'     88  `8D      88'  YP   `88'   88' Y8b 888o  88 88    88 88  `8D\s
                    8P      88    88 `8bo.      88    88    88 88  88  88 88ooooo 88oobY'      `8bo.      88    88      88V8o 88 88    88 88oodD'\s
                    8b      88    88   `Y8b.    88    88    88 88  88  88 88~~~~~ 88`8b          `Y8b.    88    88  ooo 88 V8o88 88    88 88~~~  \s
                    Y8b  d8 88b  d88 db   8D    88    `8b  d8' 88  88  88 88.     88 `88.      db   8D   .88.   88. ~8~ 88  V888 88b  d88 88     \s
                     `Y88P' ~Y8888P' `8888Y'    YP     `Y88P'  YP  YP  YP Y88888P 88   YD      `8888Y' Y888888P  Y888P  VP   V8P ~Y8888P' 88     \s
                                                                                                                                                 \s
                                                                                                                                                 \s
                    """;
            System.out.println(artWork);

        }
    }
}

