//public class HotelBMenu extends Menu implements MenuInterface{
//        private String name;
//        private double price;
//        private int quantity;
//        private double total;
//
//    public HotelBMenu(){
//
//    }
//
//    public HotelBMenu(String name, double price){
//        super(name,price);
//    }
//
//    public HotelBMenu(String name, double price, int quantity){
//        super(name, price, quantity);
//    }
//
//
//        public static void displayTransportMenu() {
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%78s","*************** Hilton Kuala Lumpur Transportation *********************\n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%79s","                 1.Valet Parking             150.00/entry       \n");
//            System.out.printf("%79s","                 2.Taxi from KLIA            125.00/6 seated    \n");
//            System.out.printf("%79s","                 3.Taxi from KLIA 2          125.00/6 seated    \n");
//            System.out.printf("%79s","                 4.Taxi from KL Sentral      80.00/6 seated    \n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%70s","          We aim to provide best service for you!     \n");
//        }
//
//        public static void displayFoodMenu() {
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%78s","*************** Hilton Kuala Lumpur Food *********************\n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%79s","                 1.Lamb Shank             64.90       \n");
//            System.out.printf("%79s","                 2.Seafood Aglio Olio     45.90    \n");
//            System.out.printf("%79s","                 3.Grill Salmon           59.90    \n");
//            System.out.printf("%79s","                 4.Beef Wellington        79.90    \n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%70s","          We aim to provide best service for you!     \n");;
//        }
//
//        public static void displayBevMenu() {
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%78s","*************** Hilton Kuala Lumpur Beverage *********************\n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%79s","                 1.Blue Mountain Coffee   38.80       \n");
//            System.out.printf("%79s","                 2.Grand Jasmine Tea      25.00    \n");
//            System.out.printf("%79s","                 3.Highland Honey         30.00    \n");
//            System.out.printf("%79s","                 4.Red Wine               99.90    \n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%70s","          We aim to provide best service for you!     \n");;
//        }
//
//    @Override
//    public double order(int quantity, double price) {
//        double total = quantity * price;
//        return total;
//    }
//}
