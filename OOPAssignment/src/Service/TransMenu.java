package Service;

import java.util.ArrayList;

public class TransMenu extends Menu {
    private int quantity;
    public TransMenu(){

    }

    public TransMenu(String name, double price){
        super(name,price);
    }

    public TransMenu(String name, double price, int quantity ){
        super(name,price);
        this.quantity= quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static double printTransportOrders(ArrayList<TransMenu> transOrders) {
        System.out.println("Your transport orders:");
        double subTotal = 0;
        for (int i = 0; i < transOrders.size(); i++) {
            TransMenu transOrder = transOrders.get(i);
            double transSubTotal = transOrder.order(transOrder.getQuantity(), transOrder.getPrice());
            System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), transOrder.getName(), transOrder.getQuantity(),"x", transSubTotal);
            subTotal += transSubTotal;
        }
        System.out.println();
        return subTotal;
    }

    @Override
    public double order(int quantity, double price) {
        return getPrice() * quantity;
    }
}
