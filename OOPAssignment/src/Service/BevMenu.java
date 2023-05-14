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




    @Override
    public double order(int quantity, double price) {
        return getPrice() * quantity;
    }
}
