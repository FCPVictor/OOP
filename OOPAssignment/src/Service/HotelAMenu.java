public class HotelAMenu extends Menu implements MenuInterface{

    public HotelAMenu(){

    }

    public HotelAMenu(String name, double price){
        super(name,price);
    }

    public HotelAMenu(String name, double price, int quantity){
        super(name, price, quantity);
    }

    public static void displayTransportMenu() {
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%78s","*************** Holiday Inn Subang Jaya Transportation *********************\n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%79s","                 1.Valet Parking             50.00/entry       \n");
        System.out.printf("%79s","                 2.Taxi from KLIA            65.00/4 seated    \n");
        System.out.printf("%79s","                 3.Taxi from KLIA 2          65.00/4 seated    \n");
        System.out.printf("%79s","                 4.Taxi from KL Sentral      30.00/4 seated    \n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%70s","          We aim to provide best service for you!     \n");;
    }

    public static void displayBevMenu() {
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%78s","************** Holiday Inn Subang Jaya Beverage *********************\n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%79s","                 1.Coca-cola             5.90       \n");
        System.out.printf("%79s","                 2.Sprite               5.90   \n");
        System.out.printf("%79s","                 3.Ice Lemon Tea       6.50    \n");
        System.out.printf("%79s","                 4.100 plus          5.90    \n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%70s","          We aim to provide best service for you!     \n");;
    }

    public static void displayFoodMenu() {
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%78s","*************** Holiday Inn Subang Jaya Food *********************\n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%79s","                 1.Burger             35.50       \n");
        System.out.printf("%79s","                 2.Steak              50.50    \n");
        System.out.printf("%79s","                 3.Chicken Chop       22.90    \n");
        System.out.printf("%79s","                 4.Spaghetti          19.90    \n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%70s","          We aim to provide best service for you!     \n");
    }
    @Override
    public double order(int quantity, double price) {
        double total = quantity * price;
        return total;
    }
}
