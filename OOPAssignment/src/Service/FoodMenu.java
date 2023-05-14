package Service;

import java.util.ArrayList;

public class FoodMenu extends Menu {
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



    @Override
    public double order(int quantity, double price) {
        return getPrice() * quantity;
    }
}
