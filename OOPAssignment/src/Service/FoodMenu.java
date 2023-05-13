package Service;
public class FoodMenu extends MenuAbs {
    private int quantity;
    public FoodMenu(){

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
