import java.util.ArrayList;

abstract class Room {
    protected String roomType;
    protected int maxPax;
    protected double price;

    public Room(String roomType, int maxPax, double price) {
        this.roomType = roomType;
        this.maxPax = maxPax;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType){
        this.roomType = roomType;
    }

    public int getMaxPax() {
        return maxPax;
    }

    public void setMaxPax(int maxPax){
        this.maxPax = maxPax;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public abstract void displayRoomInfo();
}

class DeluxeRoom extends Room {
    public DeluxeRoom(String roomType, int maxPax, double price) {
        super(roomType, maxPax, price);
    }

    @Override
    public void displayRoomInfo() {
        System.out.printf("\033[1m%-5s%-30s%-20dRM %-10.2f\033[0m\n", "Deluxe Room      ", getRoomType(), getMaxPax(), getPrice());
    }
}

class ExecutiveSuite extends Room {
    public ExecutiveSuite(String roomType, int maxPax, double price) {
        super(roomType, maxPax, price);
    }

    @Override
    public void displayRoomInfo() {
        System.out.printf("\033[1m%-5s%-30s%-20dRM %-10.2f\033[0m\n", "Executive Suite  ", getRoomType(), getMaxPax(), getPrice());
    }
}

class Hotel {
    private String hotelName;
    private ArrayList<Room> rooms;

    public Hotel(String hotelName, ArrayList<Room> rooms) {
        this.hotelName = hotelName;
        this.rooms = rooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName){
        this.hotelName = hotelName;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }


    public static void displaycompare() {
        System.out.println();
        System.out.println("**********************************************************");
        System.out.println("***                                                    ***");
        System.out.println("***        Comparing the cheapest rooms of hotels      ***");
        System.out.println("***                                                    ***");
        System.out.println("**********************************************************");
        System.out.println();

        System.out.println("-------------------------------------------------------------------------");

        System.out.printf("%-40s%-10s%-20s%n", "Hotel Name", "Price(RM)", "Cheapest Room Type");

        System.out.println("-------------------------------------------------------------------------");
    }

    public static void printHeader(int option) {
        String header;
        if (option == 1) {
            header = """                                                                                                                               
                                                                                                                                  
            HHHHHHHHH     HHHHHHHHH     OOOOOOOOO     TTTTTTTTTTTTTTTTTTTTTTTEEEEEEEEEEEEEEEEEEEEEELLLLLLLLLLL                SSSSSSSSSSSSSSS 
            H:::::::H     H:::::::H   OO:::::::::OO   T:::::::::::::::::::::TE::::::::::::::::::::EL:::::::::L              SS:::::::::::::::S
            H:::::::H     H:::::::H OO:::::::::::::OO T:::::::::::::::::::::TE::::::::::::::::::::EL:::::::::L             S:::::SSSSSS::::::S
            HH::::::H     H::::::HHO:::::::OOO:::::::OT:::::TT:::::::TT:::::TEE::::::EEEEEEEEE::::ELL:::::::LL             S:::::S     SSSSSSS
              H:::::H     H:::::H  O::::::O   O::::::OTTTTTT  T:::::T  TTTTTT  E:::::E       EEEEEE  L:::::L               S:::::S            
              H:::::H     H:::::H  O:::::O     O:::::O        T:::::T          E:::::E               L:::::L               S:::::S            
              H::::::HHHHH::::::H  O:::::O     O:::::O        T:::::T          E::::::EEEEEEEEEE     L:::::L                S::::SSSS         
              H:::::::::::::::::H  O:::::O     O:::::O        T:::::T          E:::::::::::::::E     L:::::L                 SS::::::SSSSS    
              H:::::::::::::::::H  O:::::O     O:::::O        T:::::T          E:::::::::::::::E     L:::::L                   SSS::::::::SS  
              H::::::HHHHH::::::H  O:::::O     O:::::O        T:::::T          E::::::EEEEEEEEEE     L:::::L                      SSSSSS::::S 
              H:::::H     H:::::H  O:::::O     O:::::O        T:::::T          E:::::E               L:::::L                           S:::::S
              H:::::H     H:::::H  O::::::O   O::::::O        T:::::T          E:::::E       EEEEEE  L:::::L         LLLLLL            S:::::S
            HH::::::H     H::::::HHO:::::::OOO:::::::O      TT:::::::TT      EE::::::EEEEEEEE:::::ELL:::::::LLLLLLLLL:::::LSSSSSSS     S:::::S
            H:::::::H     H:::::::H OO:::::::::::::OO       T:::::::::T      E::::::::::::::::::::EL::::::::::::::::::::::LS::::::SSSSSS:::::S
            H:::::::H     H:::::::H   OO:::::::::OO         T:::::::::T      E::::::::::::::::::::EL::::::::::::::::::::::LS:::::::::::::::SS 
            HHHHHHHHH     HHHHHHHHH     OOOOOOOOO           TTTTTTTTTTT      EEEEEEEEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLLLLLLLLL SSSSSSSSSSSSSSS   

                    """;
        } else if (option == 2) {
            header = """        
                                                                                                                                                            
                                                                                                                                                            
        CCCCCCCCCCCCC     OOOOOOOOO     MMMMMMMM               MMMMMMMMPPPPPPPPPPPPPPPPP        AAA               RRRRRRRRRRRRRRRRR   EEEEEEEEEEEEEEEEEEEEEE
        CCC::::::::::::C   OO:::::::::OO   M:::::::M             M:::::::MP::::::::::::::::P      A:::A              R::::::::::::::::R  E::::::::::::::::::::E
      CC:::::::::::::::C OO:::::::::::::OO M::::::::M           M::::::::MP::::::PPPPPP:::::P    A:::::A             R::::::RRRRRR:::::R E::::::::::::::::::::E
     C:::::CCCCCCCC::::CO:::::::OOO:::::::OM:::::::::M         M:::::::::MPP:::::P     P:::::P  A:::::::A            RR:::::R     R:::::REE::::::EEEEEEEEE::::E
    C:::::C       CCCCCCO::::::O   O::::::OM::::::::::M       M::::::::::M  P::::P     P:::::P A:::::::::A             R::::R     R:::::R  E:::::E       EEEEEE
   C:::::C              O:::::O     O:::::OM:::::::::::M     M:::::::::::M  P::::P     P:::::PA:::::A:::::A            R::::R     R:::::R  E:::::E             
   C:::::C              O:::::O     O:::::OM:::::::M::::M   M::::M:::::::M  P::::PPPPPP:::::PA:::::A A:::::A           R::::RRRRRR:::::R   E::::::EEEEEEEEEE   
   C:::::C              O:::::O     O:::::OM::::::M M::::M M::::M M::::::M  P:::::::::::::PPA:::::A   A:::::A          R:::::::::::::RR    E:::::::::::::::E   
   C:::::C              O:::::O     O:::::OM::::::M  M::::M::::M  M::::::M  P::::PPPPPPPPP A:::::A     A:::::A         R::::RRRRRR:::::R   E:::::::::::::::E   
   C:::::C              O:::::O     O:::::OM::::::M   M:::::::M   M::::::M  P::::P        A:::::AAAAAAAAA:::::A        R::::R     R:::::R  E::::::EEEEEEEEEE   
   C:::::C              O:::::O     O:::::OM::::::M    M:::::M    M::::::M  P::::P       A:::::::::::::::::::::A       R::::R     R:::::R  E:::::E             
    C:::::C       CCCCCCO::::::O   O::::::OM::::::M     MMMMM     M::::::M  P::::P      A:::::AAAAAAAAAAAAA:::::A      R::::R     R:::::R  E:::::E       EEEEEE
     C:::::CCCCCCCC::::CO:::::::OOO:::::::OM::::::M               M::::::MPP::::::PP   A:::::A             A:::::A   RR:::::R     R:::::REE::::::EEEEEEEE:::::E
      CC:::::::::::::::C OO:::::::::::::OO M::::::M               M::::::MP::::::::P  A:::::A               A:::::A  R::::::R     R:::::RE::::::::::::::::::::E
        CCC::::::::::::C   OO:::::::::OO   M::::::M               M::::::MP::::::::P A:::::A                 A:::::A R::::::R     R:::::RE::::::::::::::::::::E
           CCCCCCCCCCCCC     OOOOOOOOO     MMMMMMMM               MMMMMMMMPPPPPPPPPPAAAAAAA                   AAAAAAARRRRRRRR     RRRRRRREEEEEEEEEEEEEEEEEEEEEE
                                                                                                                                                               
                                                                                                                                                        

                    """;
        } else if (option == 3) {
            header = """                                                                                                       
                                                                                                            
            RRRRRRRRRRRRRRRRR        OOOOOOOOO          OOOOOOOOO     MMMMMMMM               MMMMMMMM   SSSSSSSSSSSSSSS 
            R::::::::::::::::R     OO:::::::::OO      OO:::::::::OO   M:::::::M             M:::::::M SS:::::::::::::::S
            R::::::RRRRRR:::::R  OO:::::::::::::OO  OO:::::::::::::OO M::::::::M           M::::::::MS:::::SSSSSS::::::S
            RR:::::R     R:::::RO:::::::OOO:::::::OO:::::::OOO:::::::OM:::::::::M         M:::::::::MS:::::S     SSSSSSS
              R::::R     R:::::RO::::::O   O::::::OO::::::O   O::::::OM::::::::::M       M::::::::::MS:::::S            
              R::::R     R:::::RO:::::O     O:::::OO:::::O     O:::::OM:::::::::::M     M:::::::::::MS:::::S            
              R::::RRRRRR:::::R O:::::O     O:::::OO:::::O     O:::::OM:::::::M::::M   M::::M:::::::M S::::SSSS         
              R:::::::::::::RR  O:::::O     O:::::OO:::::O     O:::::OM::::::M M::::M M::::M M::::::M  SS::::::SSSSS    
              R::::RRRRRR:::::R O:::::O     O:::::OO:::::O     O:::::OM::::::M  M::::M::::M  M::::::M    SSS::::::::SS  
              R::::R     R:::::RO:::::O     O:::::OO:::::O     O:::::OM::::::M   M:::::::M   M::::::M       SSSSSS::::S 
              R::::R     R:::::RO:::::O     O:::::OO:::::O     O:::::OM::::::M    M:::::M    M::::::M            S:::::S
              R::::R     R:::::RO::::::O   O::::::OO::::::O   O::::::OM::::::M     MMMMM     M::::::M            S:::::S
            RR:::::R     R:::::RO:::::::OOO:::::::OO:::::::OOO:::::::OM::::::M               M::::::MSSSSSSS     S:::::S
            R::::::R     R:::::R OO:::::::::::::OO  OO:::::::::::::OO M::::::M               M::::::MS::::::SSSSSS:::::S
            R::::::R     R:::::R   OO:::::::::OO      OO:::::::::OO   M::::::M               M::::::MS:::::::::::::::SS 
            RRRRRRRR     RRRRRRR     OOOOOOOOO          OOOOOOOOO     MMMMMMMM               MMMMMMMM SSSSSSSSSSSSSSS   
                                                                                                                  
                        """;
        }else if (option == 4) {
            header = """                                                                                                       
                                                                                                                                        
            SSSSSSSSSSSSSSS EEEEEEEEEEEEEEEEEEEEEE               AAA               RRRRRRRRRRRRRRRRR           CCCCCCCCCCCCCHHHHHHHHH     HHHHHHHHH
            SS:::::::::::::::SE::::::::::::::::::::E              A:::A              R::::::::::::::::R       CCC::::::::::::CH:::::::H     H:::::::H
           S:::::SSSSSS::::::SE::::::::::::::::::::E             A:::::A             R::::::RRRRRR:::::R    CC:::::::::::::::CH:::::::H     H:::::::H
           S:::::S     SSSSSSSEE::::::EEEEEEEEE::::E            A:::::::A            RR:::::R     R:::::R  C:::::CCCCCCCC::::CHH::::::H     H::::::HH
           S:::::S              E:::::E       EEEEEE           A:::::::::A             R::::R     R:::::R C:::::C       CCCCCC  H:::::H     H:::::H  
           S:::::S              E:::::E                       A:::::A:::::A            R::::R     R:::::RC:::::C                H:::::H     H:::::H  
            S::::SSSS           E::::::EEEEEEEEEE            A:::::A A:::::A           R::::RRRRRR:::::R C:::::C                H::::::HHHHH::::::H  
             SS::::::SSSSS      E:::::::::::::::E           A:::::A   A:::::A          R:::::::::::::RR  C:::::C                H:::::::::::::::::H  
               SSS::::::::SS    E:::::::::::::::E          A:::::A     A:::::A         R::::RRRRRR:::::R C:::::C                H:::::::::::::::::H  
                  SSSSSS::::S   E::::::EEEEEEEEEE         A:::::AAAAAAAAA:::::A        R::::R     R:::::RC:::::C                H::::::HHHHH::::::H  
                       S:::::S  E:::::E                  A:::::::::::::::::::::A       R::::R     R:::::RC:::::C                H:::::H     H:::::H  
                       S:::::S  E:::::E       EEEEEE    A:::::AAAAAAAAAAAAA:::::A      R::::R     R:::::R C:::::C       CCCCCC  H:::::H     H:::::H  
           SSSSSSS     S:::::SEE::::::EEEEEEEE:::::E   A:::::A             A:::::A   RR:::::R     R:::::R  C:::::CCCCCCCC::::CHH::::::H     H::::::HH
           S::::::SSSSSS:::::SE::::::::::::::::::::E  A:::::A               A:::::A  R::::::R     R:::::R   CC:::::::::::::::CH:::::::H     H:::::::H
           S:::::::::::::::SS E::::::::::::::::::::E A:::::A                 A:::::A R::::::R     R:::::R     CCC::::::::::::CH:::::::H     H:::::::H
            SSSSSSSSSSSSSSS   EEEEEEEEEEEEEEEEEEEEEEAAAAAAA                   AAAAAAARRRRRRRR     RRRRRRR        CCCCCCCCCCCCCHHHHHHHHH     HHHHHHHHH
                                                                                
          
                        """;
        }else if (option == 5) {
            header = """                                                                                                       
                                                                                                                               
                                                                                                                               
            SSSSSSSSSSSSSSS      OOOOOOOOO     RRRRRRRRRRRRRRRRR   TTTTTTTTTTTTTTTTTTTTTTT     BBBBBBBBBBBBBBBBB   YYYYYYY       YYYYYYY
            SS:::::::::::::::S   OO:::::::::OO   R::::::::::::::::R  T:::::::::::::::::::::T     B::::::::::::::::B  Y:::::Y       Y:::::Y
           S:::::SSSSSS::::::S OO:::::::::::::OO R::::::RRRRRR:::::R T:::::::::::::::::::::T     B::::::BBBBBB:::::B Y:::::Y       Y:::::Y
           S:::::S     SSSSSSSO:::::::OOO:::::::ORR:::::R     R:::::RT:::::TT:::::::TT:::::T     BB:::::B     B:::::BY::::::Y     Y::::::Y
           S:::::S            O::::::O   O::::::O  R::::R     R:::::RTTTTTT  T:::::T  TTTTTT       B::::B     B:::::BYYY:::::Y   Y:::::YYY
           S:::::S            O:::::O     O:::::O  R::::R     R:::::R        T:::::T               B::::B     B:::::B   Y:::::Y Y:::::Y   
            S::::SSSS         O:::::O     O:::::O  R::::RRRRRR:::::R         T:::::T               B::::BBBBBB:::::B     Y:::::Y:::::Y    
             SS::::::SSSSS    O:::::O     O:::::O  R:::::::::::::RR          T:::::T               B:::::::::::::BB       Y:::::::::Y     
               SSS::::::::SS  O:::::O     O:::::O  R::::RRRRRR:::::R         T:::::T               B::::BBBBBB:::::B       Y:::::::Y      
                  SSSSSS::::S O:::::O     O:::::O  R::::R     R:::::R        T:::::T               B::::B     B:::::B       Y:::::Y       
                       S:::::SO:::::O     O:::::O  R::::R     R:::::R        T:::::T               B::::B     B:::::B       Y:::::Y       
                       S:::::SO::::::O   O::::::O  R::::R     R:::::R        T:::::T               B::::B     B:::::B       Y:::::Y       
           SSSSSSS     S:::::SO:::::::OOO:::::::ORR:::::R     R:::::R      TT:::::::TT           BB:::::BBBBBB::::::B       Y:::::Y       
           S::::::SSSSSS:::::S OO:::::::::::::OO R::::::R     R:::::R      T:::::::::T           B:::::::::::::::::B     YYYY:::::YYYY    
           S:::::::::::::::SS    OO:::::::::OO   R::::::R     R:::::R      T:::::::::T           B::::::::::::::::B      Y:::::::::::Y    
            SSSSSSSSSSSSSSS        OOOOOOOOO     RRRRRRRR     RRRRRRR      TTTTTTTTTTT           BBBBBBBBBBBBBBBBB       YYYYYYYYYYYYY    
        
                        """;
        } else {
            header = """

                    """;
        }

        System.out.println(header);
    }

}