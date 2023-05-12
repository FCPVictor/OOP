import java.time.LocalDate;

public class Reservation {
    private int resId;
    private LocalDate checkindate;
    private LocalDate checkoutdate;
    private int pax;
    private int hotel;
    private String hotelName;
    private Object roomType;
    private Room room;
//    private Service service;

    public Reservation(){
    }
    public Reservation(int resId, LocalDate checkindate, LocalDate checkoutdate, int pax, int hotel, String hotelName, Object roomType, Room room/*,Service service*/) {
        this.resId = resId;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.pax = pax;
        this.hotel = hotel;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.room = room;
//        this.service = service;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public LocalDate getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(LocalDate checkindate) {
        this.checkindate = checkindate;
    }

    public LocalDate getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(LocalDate checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Object getRoomType() {
        return Room.getRoomType();
    }

    public void setRoomType(Object roomType) {
        this.roomType = roomType;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    //    public Service getService() {
//        return service;
//    }
//
//    public void setService(Service service) {
//        this.service = service;
//    }

    public static void ReservationHeader(){
        System.out.println("****************************************************************************");
        System.out.println("*  _____  ______  _____ ______ _______      __  _______ _____ ____  _   __  *");
        System.out.println("* |  __ \\|  ____|/ ____|  ____|  __ \\ \\    / /\\|__   __|_   _/ __ \\| \\ |  | *");
        System.out.println("* | |__) | |__  | (___ | |__  | |__) \\ \\  / /  \\  | |    | || |  | |  \\|  | *");
        System.out.println("* |  _  /|  __|  \\___ \\|  __| |  _  / \\ \\/ / /\\ \\ | |    | || |  | |      | *");
        System.out.println("* | | \\ \\| |____ ____) | |____| | \\ \\  \\  / ____ \\| |   _| || |__| |  |\\  | *");
        System.out.println("* |_|  \\_\\______|_____/|______|_|  \\_\\  \\/_/    \\_\\_|  |_____|\\____/__| \\_| *");
        System.out.println("****************************************************************************\n");
    }
}

