//public class HotelEMenu extends Menu implements MenuInterface{
//        private String name;
//        private double price;
//        private int quantity;
//        private double total;
//
//    public HotelEMenu(){
//
//    }
//
//    public HotelEMenu(String name, double price){
//        super(name,price);
//    }
//
//    public HotelEMenu(String name, double price, int quantity){
//        super(name, price, quantity);
//    }
//
//
//
//        public static void displayTransportMenu() {
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%78s","*************** Le Meridien Kuala Lumpur Transportation *********************\n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%79s","                 1.Valet Parking            120.00/entry       \n");
//            System.out.printf("%79s","                 2.Taxi from KLIA            85.00/4 seated    \n");
//            System.out.printf("%79s","                 3.Taxi from KLIA 2          85.00/4 seated    \n");
//            System.out.printf("%79s","                 4.Taxi from KL Sentral      50.00/4 seated    \n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%70s","          We aim to provide best service for you!     \n");;
//        }
//
//
//        public static void displayFoodMenu() {
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%78s","*************** Le Meridien Kuala Lumpur Food *********************\n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%79s","                 1.Rib Eye Steak             50.00      \n");
//            System.out.printf("%79s","                 2.Sashimi and Sushi              65.00    \n");
//            System.out.printf("%79s","                 3.Dim Sum       65.00   \n");
//            System.out.printf("%79s","                 4.Malay Cuisine          30.00    \n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%70s","          We aim to provide best service for you!     \n");;
//        }
//
//
//        public static void displayBevMenu() {
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%78s","*************** Le Meridien Kuala Lumpur Beverage *********************\n");
//            System.out.printf("%78s","=====================================================\n");
//            System.out.printf("%79s","                 1.Cocktails             50.00     \n");
//            System.out.printf("%79s","                 2.Red Vine              65.00    \n");
//            System.out.printf("%79s","                 3.Premium Honey       65.00/    \n");
//            System.out.printf("%79s","                 4.Blue Mountain Coffee          30.00    \n");
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
//
