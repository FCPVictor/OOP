package Service;

import java.util.Scanner;
import java.util.ArrayList;

public class TestService {
    public static void main(String[] args) {
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

        System.out.println("Please Choose Hotel: ");
        String hotelChoice = scan.nextLine();

        if (hotelChoice.equals("1")) {
            boolean validService = true;
            while (validService) {
                ServiceMenu.displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Holiday Inn Subang Hotel Transport Service");
                    for (int i = 0; i < transMenuA.length; i++) {
                        System.out.printf("%-4d%-40sRM %.2f%n", i + 1, transMenuA[i].getName(), transMenuA[i].getPrice());
                    }
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
                                tOrder.setPrice(transMenuA[t - 1].getPrice());
                                tOrder.setQuantity(tQty);
                                transOrders.add(new TransMenu(transMenuA[t - 1].getName(), tOrder.getPrice(), tQty));
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
                        for (TransMenu transOrder : transOrders) {
                            transSubtotal += transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                        }
                    }

                } else if (selection.equals("2")) {
                    System.out.println("Holiday Inn Subang Hotel Food Service");
                    for (int i = 0; i < transMenuA.length; i++) {
                        System.out.printf("%-4d%-40sRM %.2f%n", i + 1, foodMenuA[i].getName(), foodMenuA[i].getPrice());
                    }
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
                                fOrder.setPrice(foodMenuA[f - 1].getPrice());
                                fOrder.setQuantity(fQty);
                                foodOrders.add(new FoodMenu(foodMenuA[f - 1].getName(), fOrder.getPrice(), fQty));
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
                        for (FoodMenu foodOrderA : foodOrders) {
                            foodSubtotal += foodOrderA.order(foodOrderA.getQuantity(), foodOrderA.getPrice());
                        }
                    }
                } else if (selection.equals("3")) {
                    System.out.println("Holiday Inn Subang Hotel Beverage Service");
                    for (int i = 0; i < bevMenuA.length; i++) {
                        System.out.printf("%-4d%-40sRM %.2f%n", i + 1, bevMenuA[i].getName(), bevMenuA[i].getPrice());
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
            for (int i = 0; i < transOrders.size(); i++) {
                TransMenu transOrderA = transOrders.get(i);
                double transSubTotal = transOrderA.order(transOrderA.getQuantity(), transOrderA.getPrice());
                System.out.println((i + 1) + ". " + transOrderA.getName() + " x" + transOrderA.getQuantity() + " = RM " + String.format("%.2f", transSubTotal));
                subTotal += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrders.size(); i++) {
                FoodMenu foodOrderA = foodOrders.get(i);
                double foodSubTotal = foodOrderA.order(foodOrderA.getQuantity(), foodOrderA.getPrice());
                System.out.printf("%-4d%-20s %-2d RM%.2f %n", (i + 1), foodOrderA.getName(), foodOrderA.getQuantity(), foodSubTotal);
                subTotal += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrders.size(); i++) {
                BevMenu bevOrder = bevOrders.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.println((i + 1) + ". " + bevOrder.getName() + " x" + bevOrder.getQuantity() + " = RM " + String.format("%.2f", bevSubTotal));
                subTotal += bevSubTotal;
            }

            System.out.println("Thank you for ordering services. \nTotal Amount for services is RM " + String.format("%.2f", subTotal));

        } else if (hotelChoice.equals("2")) {
            boolean validService = true;
            while (validService) {
                ServiceMenu.displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Holiday Inn Subang Hotel Transport Service");
                    for (int i = 0; i < transMenuB.length; i++) {
                        System.out.printf("%-4d%-40sRM %.2f%n", i + 1, transMenuB[i].getName(), transMenuB[i].getPrice());
                    }
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
                                tOrder.setPrice(transMenuB[t - 1].getPrice());
                                tOrder.setQuantity(tQty);
                                transOrders.add(new TransMenu(transMenuB[t - 1].getName(), tOrder.getPrice(), tQty));
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
                        for (TransMenu transOrder : transOrders) {
                            transSubtotal += transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                        }
                    }

                } else if (selection.equals("2")) {
                    System.out.println("Holiday Inn Subang Hotel Food Service");
                    for (int i = 0; i < foodMenuB.length; i++) {
                        System.out.printf("%-4d%-40sRM %.2f%n", i + 1, foodMenuB[i].getName(), foodMenuB[i].getPrice());
                    }
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
                                fOrder.setPrice(foodMenuB[f - 1].getPrice());
                                fOrder.setQuantity(fQty);
                                foodOrders.add(new FoodMenu(foodMenuB[f - 1].getName(), fOrder.getPrice(), fQty));
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
                        for (FoodMenu foodOrderB : foodOrders) {
                            foodSubtotal += foodOrderB.order(foodOrderB.getQuantity(), foodOrderB.getPrice());
                        }
                    }
                } else if (selection.equals("3")) {
                    System.out.println("Holiday Inn Subang Hotel Beverage Service");
                    for (int i = 0; i < bevMenuB.length; i++) {
                        System.out.printf("%-4d%-40sRM %.2f%n", i + 1, bevMenuB[i].getName(), bevMenuB[i].getPrice());
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
            for (int i = 0; i < transOrders.size(); i++) {
                TransMenu transOrder = transOrders.get(i);
                double transSubTotal = transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                System.out.println((i + 1) + ". " + transOrder.getName() + " x" + transOrder.getQuantity() + " = RM " + String.format("%.2f", transSubTotal));
                subTotal += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrders.size(); i++) {
                FoodMenu foodOrder = foodOrders.get(i);
                double foodSubTotal = foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d RM%.2f %n", (i + 1), foodOrder.getName(), foodOrder.getQuantity(), foodSubTotal);
                subTotal += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrders.size(); i++) {
                BevMenu bevOrder = bevOrders.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.println((i + 1) + ". " + bevOrder.getName() + " x" + bevOrder.getQuantity() + " = RM " + String.format("%.2f", bevSubTotal));
                subTotal += bevSubTotal;
            }

            System.out.println("Thank you for ordering services. \nTotal Amount for services is RM " + String.format("%.2f", subTotal));
        } else if (hotelChoice.equals("3")) {
            boolean validService = true;
            while (validService) {
                ServiceMenu.displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Holiday Inn Subang Hotel Transport Service");
                    for (int i = 0; i < transMenuC.length; i++) {
                        System.out.printf("%-4d%-40sRM %.2f%n", i + 1, transMenuC[i].getName(), transMenuC[i].getPrice());
                    }
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
                                tOrder.setPrice(transMenuC[t - 1].getPrice());
                                tOrder.setQuantity(tQty);
                                transOrders.add(new TransMenu(transMenuC[t - 1].getName(), tOrder.getPrice(), tQty));
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
                        for (TransMenu transOrder : transOrders) {
                            transSubtotal += transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                        }
                    }

                } else if (selection.equals("2")) {
                    System.out.println("Holiday Inn Subang Hotel Food Service");
                    for (int i = 0; i < foodMenuC.length; i++) {
                        System.out.printf("%-4d%-40sRM %.2f%n", i + 1, foodMenuC[i].getName(), foodMenuC[i].getPrice());
                    }
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
                                fOrder.setPrice(foodMenuC[f - 1].getPrice());
                                fOrder.setQuantity(fQty);
                                foodOrders.add(new FoodMenu(foodMenuC[f - 1].getName(), fOrder.getPrice(), fQty));
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
                        for (FoodMenu foodOrder : foodOrders) {
                            foodSubtotal += foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
                        }
                    }
                } else if (selection.equals("3")) {
                    System.out.println("Holiday Inn Subang Hotel Beverage Service");
                    for (int i = 0; i < bevMenuC.length; i++) {
                        System.out.printf("%-4d%-40sRM %.2f%n", i + 1, bevMenuC[i].getName(), bevMenuC[i].getPrice());
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
            for (int i = 0; i < transOrders.size(); i++) {
                TransMenu transOrder = transOrders.get(i);
                double transSubTotal = transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                System.out.println((i + 1) + ". " + transOrder.getName() + " x" + transOrder.getQuantity() + " = RM " + String.format("%.2f", transSubTotal));
                subTotal += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrders.size(); i++) {
                FoodMenu foodOrder = foodOrders.get(i);
                double foodSubTotal = foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d RM%.2f %n", (i + 1), foodOrder.getName(), foodOrder.getQuantity(), foodSubTotal);
                subTotal += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrders.size(); i++) {
                BevMenu bevOrder = bevOrders.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.println((i + 1) + ". " + bevOrder.getName() + " x" + bevOrder.getQuantity() + " = RM " + String.format("%.2f", bevSubTotal));
                subTotal += bevSubTotal;
            }

            System.out.println("Thank you for ordering services. \nTotal Amount for services is RM " + String.format("%.2f", subTotal));
        } else if (hotelChoice.equals("4")) {
            boolean validService = true;
            while (validService) {
                ServiceMenu.displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Holiday Inn Subang Hotel Transport Service");
                    for (int i =0; i < transMenuD.length;i ++){
                        System.out.printf("%-4d%-40sRM %.2f%n",i+1 ,   transMenuD[i].getName() ,  transMenuD[i].getPrice());
                    }
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
                                tOrder.setPrice(transMenuD[t - 1].getPrice());
                                tOrder.setQuantity(tQty);
                                transOrders.add(new TransMenu(transMenuD[t - 1].getName(), tOrder.getPrice(), tQty));
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
                        for (TransMenu transOrderD : transOrders) {
                            transSubtotal += transOrderD.order(transOrderD.getQuantity(), transOrderD.getPrice());
                        }
                    }

                } else if (selection.equals("2")) {
                    System.out.println("Holiday Inn Subang Hotel Food Service");
                    for (int i =0; i < foodMenuD.length;i ++){
                        System.out.printf("%-4d%-40sRM %.2f%n",i+1 ,   foodMenuD[i].getName() ,  foodMenuD[i].getPrice());
                    }
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
                                fOrder.setPrice(foodMenuD[f - 1].getPrice());
                                fOrder.setQuantity(fQty);
                                foodOrders.add(new FoodMenu(foodMenuD[f - 1].getName(), fOrder.getPrice(), fQty));
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
                        for (FoodMenu foodOrderD : foodOrders) {
                            foodSubtotal += foodOrderD.order(foodOrderD.getQuantity(), foodOrderD.getPrice());
                        }
                    }
                } else if (selection.equals("3")) {
                    System.out.println("Holiday Inn Subang Hotel Beverage Service");
                    for (int i =0; i < bevMenuD.length;i ++){
                        System.out.printf("%-4d%-40sRM %.2f%n",i+1 ,   bevMenuD[i].getName() ,  bevMenuD[i].getPrice());
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
            for (int i = 0; i < transOrders.size(); i++) {
                TransMenu transOrder = transOrders.get(i);
                double transSubTotal = transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                System.out.println((i + 1) + ". " + transOrder.getName() + " x" + transOrder.getQuantity() + " = RM " + String.format("%.2f", transSubTotal));
                subTotal += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrders.size(); i++) {
                FoodMenu foodOrder = foodOrders.get(i);
                double foodSubTotal = foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d RM%.2f %n",(i + 1) , foodOrder.getName()  ,  foodOrder.getQuantity() , foodSubTotal);
                subTotal += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrders.size(); i++) {
                BevMenu bevOrder = bevOrders.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.println((i + 1) + ". " + bevOrder.getName() + " x" + bevOrder.getQuantity() + " = RM " + String.format("%.2f", bevSubTotal));
                subTotal += bevSubTotal;
            }

            System.out.println("Thank you for ordering services. \nTotal Amount for services is RM " + String.format("%.2f",subTotal));


        } else if (hotelChoice.equals("5")) {
            boolean validService = true;
            while (validService) {
                ServiceMenu.displayServiceMenu();
                System.out.println("Enter your choice: ");
                String selection = scan.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Holiday Inn Subang Hotel Transport Service");
                    for (int i =0; i < transMenuE.length;i ++){
                        System.out.printf("%-4d%-40sRM %.2f%n",i+1 ,   transMenuE[i].getName() ,  transMenuE[i].getPrice());
                    }
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
                                tOrder.setPrice(transMenuE[t - 1].getPrice());
                                tOrder.setQuantity(tQty);
                                transOrders.add(new TransMenu(transMenuE[t - 1].getName(), tOrder.getPrice(), tQty));
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
                        for (TransMenu transOrderE : transOrders) {
                            transSubtotal += transOrderE.order(transOrderE.getQuantity(), transOrderE.getPrice());
                        }
                    }

                } else if (selection.equals("2")) {
                    System.out.println("Holiday Inn Subang Hotel Food Service");
                    for (int i =0; i < foodMenuE.length;i ++){
                        System.out.printf("%-4d%-40sRM %.2f%n",i+1 ,   foodMenuE[i].getName() ,  foodMenuE[i].getPrice());
                    }
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
                                fOrder.setPrice(foodMenuE[f - 1].getPrice());
                                fOrder.setQuantity(fQty);
                                foodOrders.add(new FoodMenu(foodMenuE[f - 1].getName(), fOrder.getPrice(), fQty));
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
                        for (FoodMenu foodOrderE : foodOrders) {
                            foodSubtotal += foodOrderE.order(foodOrderE.getQuantity(), foodOrderE.getPrice());
                        }
                    }
                } else if (selection.equals("3")) {
                    System.out.println("Holiday Inn Subang Hotel Beverage Service");
                    for (int i =0; i < bevMenuE.length;i ++){
                        System.out.printf("%-4d%-40sRM %.2f%n",i+1 ,   bevMenuE[i].getName() ,  bevMenuE[i].getPrice());
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
            for (int i = 0; i < transOrders.size(); i++) {
                TransMenu transOrder = transOrders.get(i);
                double transSubTotal = transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
                System.out.println((i + 1) + ". " + transOrder.getName() + " x" + transOrder.getQuantity() + " = RM " + String.format("%.2f", transSubTotal));
                subTotal += transSubTotal;
            }
            System.out.println();
            System.out.println("Your food orders:");
            for (int i = 0; i < foodOrders.size(); i++) {
                FoodMenu foodOrder = foodOrders.get(i);
                double foodSubTotal = foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
                System.out.printf("%-4d%-20s %-2d RM%.2f %n",(i + 1) , foodOrder.getName()  ,  foodOrder.getQuantity() , foodSubTotal);
                subTotal += foodSubTotal;
            }
            System.out.println();
            System.out.println("Your beverage orders:");
            for (int i = 0; i < bevOrders.size(); i++) {
                BevMenu bevOrder = bevOrders.get(i);
                double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
                System.out.println((i + 1) + ". " + bevOrder.getName() + " x" + bevOrder.getQuantity() + " = RM " + String.format("%.2f", bevSubTotal));
                subTotal += bevSubTotal;
            }

            System.out.println("Thank you for ordering services. \nTotal Amount for services is RM " + String.format("%.2f",subTotal));

        } else {
            System.out.println("Invalid input");
        }

    }
}
