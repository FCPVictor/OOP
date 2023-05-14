package Service;

import java.util.ArrayList;

public class FoodMenu extends ServiceMenu {
    private int quantity;
    private double serviceSubtotal;
    public FoodMenu(){

    }

    public double getServiceSubtotal() {
        return serviceSubtotal;
    }

    public void setServiceSubtotal(double serviceSubtotal) {
        this.serviceSubtotal = serviceSubtotal;
    }

    public FoodMenu(String name, double price){
        super(name,price);
    }

    public FoodMenu(String name, double price, int quantity ){
        super(name,price);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static double printFoodOrders(ArrayList<FoodMenu> foodOrders) {
        System.out.println("Your food orders:");
        double subTotal = 0;
        for (int i = 0; i < foodOrders.size(); i++) {
            FoodMenu foodOrder = foodOrders.get(i);
            double foodSubTotal = foodOrder.order(foodOrder.getQuantity(), foodOrder.getPrice());
            System.out.printf("%-4d%-20s %-2d %-1s RM%.2f %n", (i + 1), foodOrder.getName(), foodOrder.getQuantity(),"x", foodSubTotal);
            subTotal += foodSubTotal;
        }
        System.out.println();
        return subTotal;
    }

    @Override
    public double order(int quantity, double price) {
        return getPrice() * quantity;
    }
}
