public class HotelDMenu extends Menu implements MenuInterface{
    private String name;
    private double price;
    private int quantity;
    private double total;
    public HotelDMenu(){

    }

    public HotelDMenu(String name, double price){
        super(name,price);
    }

    public HotelDMenu(String name, double price, int quantity){
        super(name, price, quantity);
    }




    public static void displayTransportMenu() {
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%78s","*************** Sepang Resort Transportation *********************\n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%79s","                 1.Valet Parking             30.00/entry       \n");
        System.out.printf("%79s","                 2.Taxi from KLIA            65.00/4 seated    \n");
        System.out.printf("%79s","                 3.Taxi from KLIA 2          65.00/4 seated    \n");
        System.out.printf("%79s","                 4.Taxi from KL Sentral      30.00/4 seated    \n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%70s","          We aim to provide best service for you!     \n");;
    }


    public static void displayFoodMenu() {
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%78s","*************** Sepang Resort Food *********************\n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%79s","                 1.Nasi Lemak              8.90    \n");
        System.out.printf("%79s","                 2.Nasi Briyani           12.80   \n");
        System.out.printf("%79s","                 3.Curry Mutton          15.90    \n");
        System.out.printf("%79s","                 4.Fried Rice              9.90    \n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%70s","          We aim to provide best service for you!     \n");;
    }


    public static void displayBevMenu() {
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%78s","*************** Sepang Resort Beverage *********************\n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%79s","                 1.Mineral Water             3.00       \n");
        System.out.printf("%79s","                 2.Teh Tarik                 2.50    \n");
        System.out.printf("%79s","                 3.Chinese Tea               1.90    \n");
        System.out.printf("%79s","                 4.Syrup Bandung             2.50    \n");
        System.out.printf("%78s","=====================================================\n");
        System.out.printf("%70s","          We aim to provide best service for you!     \n");;
    }

    @Override
    public double order(int quantity, double price) {
        double total = quantity * price;
        return total;
    }
}
