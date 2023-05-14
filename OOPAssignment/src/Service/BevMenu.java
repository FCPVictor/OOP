package Service;

import java.util.ArrayList;

public class BevMenu extends Menu {
    private int quantity;
    public BevMenu(){

    }

    public BevMenu(String name, double price){
        super(name,price);
    }

    public BevMenu(String name, double price, int quantity ){
        super(name,price);
        this.quantity =quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static double printBeverageOrders(ArrayList<BevMenu> bevOrders) {
        System.out.println("Your beverage orders:");
        double subTotal = 0;
        for (int i = 0; i < bevOrders.size(); i++) {
            BevMenu bevOrder = bevOrders.get(i);
            double bevSubTotal = bevOrder.order(bevOrder.getQuantity(), bevOrder.getPrice());
            System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), bevOrder.getName(), bevOrder.getQuantity(),"x", bevSubTotal);
            subTotal += bevSubTotal;
        }
        System.out.println();
        return subTotal;
    }


    @Override
    public double order(int quantity, double price) {
        return getPrice() * quantity;
    }
}
