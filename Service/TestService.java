import java.util.Scanner;
import java.util.ArrayList;

public class TestService {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Hotel A Menu
        HotelAMenu[] transMenuA = {new HotelAMenu("Valet Parking", 50.00),
                new HotelAMenu("Taxi from KLIA", 65.00),
                new HotelAMenu("Taxi from KLIA2", 65.00),
                new HotelAMenu("Taxi from KL Sentral", 30.00),
        };

        HotelAMenu[] foodMenuA = {new HotelAMenu("Burger", 35.50),
                new HotelAMenu("Steak", 50.50),
                new HotelAMenu("Chicken Chop", 22.90),
                new HotelAMenu("Spaghetti", 19.90),
        };

        HotelAMenu[] bevMenuA = {new HotelAMenu("Coca-cola", 5.90),
                new HotelAMenu("Sprite", 5.90),
                new HotelAMenu("Ice Lemon Tea", 6.50),
                new HotelAMenu("100 Plus", 5.90),
        };

        //Hotel B Menu
        HotelBMenu[] transMenuB = {new HotelBMenu("Valet Parking", 150.00),
                new HotelBMenu("Taxi from KLIA", 125.00),
                new HotelBMenu("Taxi from KLIA2", 125.00),
                new HotelBMenu("Taxi from KL Sentral", 80.00),
        };

        HotelBMenu[] foodMenuB = {new HotelBMenu("Lamb Shank", 64.90),
                new HotelBMenu("Seafood Aglio Olio", 45.90),
                new HotelBMenu("Grill Salmon", 59.90),
                new HotelBMenu("Beef Wellington", 79.90),
        };

        HotelBMenu[] bevMenuB = {new HotelBMenu("Blue Mountain Coffee", 38.80),
                new HotelBMenu("Grand Jasmine Tea", 25.00),
                new HotelBMenu("Highland Honey", 30.00),
                new HotelBMenu("Red Wine", 99.90),
        };

        //Hotel C Menu
        HotelCMenu[] transMenuC = {new HotelCMenu("Valet Parking", 50.00),
                new HotelCMenu("Taxi from KLIA", 65.00),
                new HotelCMenu("Taxi from KLIA2", 65.00),
                new HotelCMenu("Taxi from KL Sentral", 30.00),
        };

        HotelCMenu[] foodMenuC = {new HotelCMenu("Chicken Burger", 35.50),
                new HotelCMenu("Chicken Tender", 29.90),
                new HotelCMenu("Hard Rock Nachos", 25.50),
                new HotelCMenu("New York Cheese Cake", 19.90),
        };

        HotelCMenu[] bevMenuC = {new HotelCMenu("Hurricane Cocktail ", 19.90),
                new HotelCMenu("Margarita", 19.90),
                new HotelCMenu("Long Island Iced Tea", 12.80),
                new HotelCMenu("Classic Mojito", 19.90),
        };

        //Hotel D Menu
        HotelDMenu[] transMenuD = {new HotelDMenu("Valet Parking", 30.00),
                new HotelDMenu("Taxi from KLIA", 65.00),
                new HotelDMenu("Taxi from KLIA2", 65.00),
                new HotelDMenu("Taxi from KL Sentral", 30.00),
        };

        HotelDMenu[] foodMenuD = {new HotelDMenu("Nasi Lemak", 35.50),
                new HotelDMenu("Nasi Briyani", 12.80),
                new HotelDMenu("Curry Mutton", 15.90),
                new HotelDMenu("Fried Rice", 9.90),
        };

        HotelDMenu[] bevMenuD = {new HotelDMenu("Mineral Water", 3.00),
                new HotelDMenu("Teh Tarik", 2.50),
                new HotelDMenu("Chinese Tea", 1.90),
                new HotelDMenu("Syrup Bandung", 2.50),
        };

        //Hotel E Menu
        HotelEMenu[] transMenuE = {new HotelEMenu("Valet Parking", 120.00),
                new HotelEMenu("Taxi from KLIA", 85.00),
                new HotelEMenu("Taxi from KLIA2", 85.00),
                new HotelEMenu("Taxi from KL Sentral", 50.00),
        };

        HotelEMenu[] foodMenuE = {new HotelEMenu("Rib Eye Steak", 50.00),
                new HotelEMenu("Sashimi and Sushi", 65.00),
                new HotelEMenu("Dim Sum", 65.00),
                new HotelEMenu("Malay Cuisine", 30.00),
        };

        HotelEMenu[] bevMenuE = {new HotelEMenu("Cocktails", 50.00),
                new HotelEMenu("Red Vine", 65.00),
                new HotelEMenu("Premium Honey", 65.00),
                new HotelEMenu("Blue Mountain Coffee", 30.00),
        };

        double subTotal = 0;

        //Array to record Service order for Hotel A
        ArrayList<HotelAMenu> foodOrdersA = new ArrayList<>();
        ArrayList<HotelAMenu> bevOrdersA = new ArrayList<>();
        ArrayList<HotelAMenu> transOrdersA = new ArrayList<>();
        HotelAMenu fOrderA = new HotelAMenu();
        HotelAMenu bOrderA = new HotelAMenu();
        HotelAMenu tOrderA = new HotelAMenu();
        double subTotalA = 0;

        //Array to record Service order for Hotel B
        ArrayList<HotelBMenu> foodOrdersB = new ArrayList<>();
        ArrayList<HotelBMenu> bevOrdersB = new ArrayList<>();
        ArrayList<HotelBMenu> transOrdersB = new ArrayList<>();
        HotelBMenu fOrderB = new HotelBMenu();
        HotelBMenu bOrderB = new HotelBMenu();
        HotelBMenu tOrderB = new HotelBMenu();
        double subTotalB = 0;

        //Array to record Service order for Hotel C
        ArrayList<HotelCMenu> foodOrdersC = new ArrayList<>();
        ArrayList<HotelCMenu> bevOrdersC = new ArrayList<>();
        ArrayList<HotelCMenu> transOrdersC = new ArrayList<>();
        HotelCMenu fOrderC = new HotelCMenu();
        HotelCMenu bOrderC = new HotelCMenu();
        HotelCMenu tOrderC = new HotelCMenu();
        double subTotalC = 0;

        //Array to record Service order for Hotel D
        ArrayList<HotelDMenu> foodOrderdD = new ArrayList<>();
        ArrayList<HotelDMenu> bevOrderdD = new ArrayList<>();
        ArrayList<HotelDMenu> transOrderdD = new ArrayList<>();
        HotelDMenu fOrderD = new HotelDMenu();
        HotelDMenu bOrderD = new HotelDMenu();
        HotelDMenu tOrderD = new HotelDMenu();
        double subTotalD = 0;


        //Array to record Service order for Hotel E
        ArrayList<HotelEMenu> foodOrderED = new ArrayList<>();
        ArrayList<HotelEMenu> bevOrderED = new ArrayList<>();
        ArrayList<HotelEMenu> transOrderED = new ArrayList<>();
        HotelEMenu fOrderE = new HotelEMenu();
        HotelEMenu bOrderE = new HotelEMenu();
        HotelEMenu tOrderE = new HotelEMenu();
        double subTotalE = 0;

        System.out.println("Please Choose Hotel: ");
        String hotelChoice = scan.nextLine();

        if (hotelChoice.equals("1")) {
            boolean validService = true;
            while (validService) {
                ServiceMenu.displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    HotelAMenu.displayTransportMenu();
                    boolean validateTrans = true;
                    while (validateTrans) {
                        double transSubtotal = 0;
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
                                tOrderA.setPrice(transMenuA[t - 1].getPrice());
                                tOrderA.setQuantity(tQty);
                                transOrdersA.add(new HotelAMenu(transMenuA[t - 1].getName(), tOrderA.getPrice(), tQty));
                                break;
                            } else if (t == 5) {
                                System.exit(0);
                            } else
                                System.out.println("Invalid input for transport service. Please choose between 1-4.");
                            validateTrans = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateTrans = true;
                        }
                        for (HotelAMenu transOrderA : transOrdersA) {
                            transSubtotal += transOrderA.order(transOrderA.getQuantity(), transOrderA.getPrice());
                        }
                    }

                } else if (selection.equals("2")) {
                    HotelAMenu.displayFoodMenu();
                    boolean validateFood = true;
                    while (validateFood) {
                        double foodSubtotal = 0;
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
                                fOrderA.setPrice(foodMenuA[f - 1].getPrice());
                                fOrderA.setQuantity(fQty);
                                foodOrdersA.add(new HotelAMenu(foodMenuA[f - 1].getName(), fOrderA.getPrice(), fQty));
                                break;
                            } else if (f == 5) {
                                System.exit(0);
                            } else
                                System.out.println("Invalid input for food choice. Please choose between 1-4.");
                            validateFood = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateFood = true;
                        }
                        for (HotelAMenu foodOrderA : foodOrdersA) {
                            foodSubtotal += foodOrderA.order(foodOrderA.getQuantity(), foodOrderA.getPrice());
                        }
                    }
                } else if (selection.equals("3")) {
                    HotelAMenu.displayBevMenu();
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
                                bOrderA.setPrice(bevMenuA[b - 1].getPrice());
                                bOrderA.setQuantity(bQty);
                                bevOrdersA.add(new HotelAMenu(bevMenuA[b - 1].getName(), bOrderA.getPrice(), bQty));
                                break;
                            } else if (b == 5) {
                                System.exit(0);
                            } else
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
            System.out.println("Your transport service:");
            for (int i = 0; i < transOrdersA.size(); i++) {
                HotelAMenu transOrderA = transOrdersA.get(i);
                double transSubTotal = transOrderA.order(transOrderA.getQuantity(), transOrderA.getPrice());
                System.out.println((i + 1) + ". " + transOrderA.getName() + " x" + transOrderA.getQuantity() + " = RM " + String.format("%.2f", transSubTotal));
                subTotalA += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrdersA.size(); i++) {
                HotelAMenu foodOrderA = foodOrdersA.get(i);
                double foodSubTotal = foodOrderA.order(foodOrderA.getQuantity(), foodOrderA.getPrice());
                System.out.println((i + 1) + ". " + foodOrderA.getName() + " x" + foodOrderA.getQuantity() + " = RM " + String.format("%.2f", foodSubTotal));
                subTotalA += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrdersA.size(); i++) {
                HotelAMenu bevOrder = bevOrdersA.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.println((i + 1) + ". " + bevOrder.getName() + " x" + bevOrder.getQuantity() + " = RM " + String.format("%.2f", bevSubTotal));
                subTotalA += bevSubTotal;
            }

            System.out.println("Thank you for ordering services. \n Total Amount for services is RM " + String.format("%.2f",subTotalA));

        } else if (hotelChoice.equals("2")) {
            boolean validService = true;
            while (validService) {
                ServiceMenu.displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    HotelBMenu.displayTransportMenu();
                    boolean validateTrans = true;
                    while (validateTrans) {
                        double transSubtotal = 0;
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
                                tOrderB.setPrice(transMenuB[t - 1].getPrice());
                                tOrderB.setQuantity(tQty);
                                transOrdersB.add(new HotelBMenu(transMenuB[t - 1].getName(), tOrderB.getPrice(), tQty));
                                break;
                            } else if (t == 5) {
                                System.exit(0);
                            } else
                                System.out.println("Invalid input for transport service. Please choose between 1-4.");
                            validateTrans = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateTrans = true;
                        }
                        for (HotelBMenu transOrderB : transOrdersB) {
                            transSubtotal += transOrderB.order(transOrderB.getQuantity(), transOrderB.getPrice());
                        }
                    }

                } else if (selection.equals("2")) {
                    HotelBMenu.displayFoodMenu();
                    boolean validateFood = true;
                    while (validateFood) {
                        double foodSubtotal = 0;
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
                                fOrderB.setPrice(foodMenuB[f - 1].getPrice());
                                fOrderB.setQuantity(fQty);
                                foodOrdersB.add(new HotelBMenu(foodMenuB[f - 1].getName(), fOrderB.getPrice(), fQty));
                                break;
                            } else if (f == 5) {
                                System.exit(0);
                            } else
                                System.out.println("Invalid input for food choice. Please choose between 1-4.");
                            validateFood = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateFood = true;
                        }
                        for (HotelBMenu foodOrderB : foodOrdersB) {
                            foodSubtotal += foodOrderB.order(foodOrderB.getQuantity(), foodOrderB.getPrice());
                        }
                    }
                } else if (selection.equals("3")) {
                    HotelBMenu.displayBevMenu();
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
                                bOrderB.setPrice(bevMenuB[b - 1].getPrice());
                                bOrderB.setQuantity(bQty);
                                bevOrdersB.add(new HotelBMenu(bevMenuB[b - 1].getName(), bOrderB.getPrice(), bQty));
                                break;
                            } else if (b == 5) {
                                System.exit(0);
                            } else
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
            System.out.println("Your transport service:");
            for (int i = 0; i < transOrdersB.size(); i++) {
                HotelBMenu transOrderB = transOrdersB.get(i);
                double transSubTotal = transOrderB.order(transOrderB.getQuantity(), transOrderB.getPrice());
                System.out.println((i + 1) + ". " + transOrderB.getName() + " x" + transOrderB.getQuantity() + " = RM " + String.format("%.2f", transSubTotal));
                subTotalB += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrdersB.size(); i++) {
                HotelBMenu foodOrderB = foodOrdersB.get(i);
                double foodSubTotal = foodOrderB.order(foodOrderB.getQuantity(), foodOrderB.getPrice());
                System.out.println((i + 1) + ". " + foodOrderB.getName() + " x" + foodOrderB.getQuantity() + " = RM " + String.format("%.2f", foodSubTotal));
                subTotalB += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrdersB.size(); i++) {
                HotelBMenu bevOrder = bevOrdersB.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.println((i + 1) + ". " + bevOrder.getName() + " x" + bevOrder.getQuantity() + " = RM " + String.format("%.2f", bevSubTotal));
                subTotalB += bevSubTotal;
            }
            System.out.println("Thank you for ordering services. \nTotal Amount for services is RM " + String.format("%.2f",subTotalB));
        } else if (hotelChoice.equals("3")) {
            boolean validService = true;
            while (validService) {
                ServiceMenu.displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    HotelCMenu.displayTransportMenu();
                    boolean validateTrans = true;
                    while (validateTrans) {
                        double transSubtotal = 0;
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
                                tOrderC.setPrice(transMenuA[t - 1].getPrice());
                                tOrderC.setQuantity(tQty);
                                transOrdersC.add(new HotelCMenu(transMenuA[t - 1].getName(), tOrderC.getPrice(), tQty));
                                break;
                            } else if (t == 5) {
                                System.exit(0);
                            } else
                                System.out.println("Invalid input for transport service. Please choose between 1-4.");
                            validateTrans = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateTrans = true;
                        }
                        for (HotelCMenu transOrderC : transOrdersC) {
                            transSubtotal += transOrderC.order(transOrderC.getQuantity(), transOrderC.getPrice());
                        }
                    }

                } else if (selection.equals("2")) {
                    HotelCMenu.displayFoodMenu();
                    boolean validateFood = true;
                    while (validateFood) {
                        double foodSubtotal = 0;
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
                                fOrderC.setPrice(foodMenuA[f - 1].getPrice());
                                fOrderC.setQuantity(fQty);
                                foodOrdersC.add(new HotelCMenu(foodMenuA[f - 1].getName(), fOrderC.getPrice(), fQty));
                                break;
                            } else if (f == 5) {
                                System.exit(0);
                            } else
                                System.out.println("Invalid input for food choice. Please choose between 1-4.");
                            validateFood = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Please input agn.");
                            validateFood = true;
                        }
                        for (HotelCMenu foodOrderC : foodOrdersC) {
                            foodSubtotal += foodOrderC.order(foodOrderC.getQuantity(), foodOrderC.getPrice());
                        }
                    }
                } else if (selection.equals("3")) {
                    HotelCMenu.displayBevMenu();
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
                                bOrderC.setPrice(bevMenuA[b - 1].getPrice());
                                bOrderC.setQuantity(bQty);
                                bevOrdersC.add(new HotelCMenu(bevMenuA[b - 1].getName(), bOrderC.getPrice(), bQty));
                                break;
                            } else if (b == 5) {
                                System.exit(0);
                            } else
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
            System.out.println("Your transport service:");
            for (int i = 0; i < transOrdersC.size(); i++) {
                HotelCMenu transOrderC = transOrdersC.get(i);
                double transSubTotal = transOrderC.order(transOrderC.getQuantity(), transOrderC.getPrice());
                System.out.println((i + 1) + ". " + transOrderC.getName() + " x" + transOrderC.getQuantity() + " = RM " + String.format("%.2f", transSubTotal));
                subTotalC += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrdersC.size(); i++) {
                HotelCMenu foodOrderC = foodOrdersC.get(i);
                double foodSubTotal = foodOrderC.order(foodOrderC.getQuantity(), foodOrderC.getPrice());
                System.out.println((i + 1) + ". " + foodOrderC.getName() + " x" + foodOrderC.getQuantity() + " = RM " + String.format("%.2f", foodSubTotal));
                subTotalC += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrdersC.size(); i++) {
                HotelCMenu bevOrder = bevOrdersC.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.println((i + 1) + ". " + bevOrder.getName() + " x" + bevOrder.getQuantity() + " = RM " + String.format("%.2f", bevSubTotal));
                subTotalC += bevSubTotal;
            }
            System.out.println("Thank you for ordering services. \n Total Amount for services is RM " + String.format("%.2f",subTotalC));
        } else if (hotelChoice.equals("4")) {


        }else if(hotelChoice.equals("5")){

        }else {
            System.out.println("Invalid input");
        }

    }
}