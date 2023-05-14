import Service.FoodMenu;

import java.time.LocalDate;
import java.time.Period;

public class Reservation {
    private Customer customer;
    private int resId;
    private static int nextResId = 1010;
    private LocalDate checkindate;
    private LocalDate checkoutdate;
    private int pax;
    private Hotel hotel;
    private String hotelName;
    private Room room;



    public Reservation() {
    }

    public Reservation(Customer customer, int resId, LocalDate checkindate, LocalDate checkoutdate, int pax, Hotel hotel, String hotelName, Room room) {
        this.customer = customer;
        this.resId = nextResId;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.pax = pax;
        this.hotel = hotel;
        this.hotelName = hotelName;
        this.room = room;


        customer.addReservation(this);
        nextResId++;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Hotel getHotel() {
        return this.hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

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

    @Override
    public String toString() {
        return "\n-----------Reservation Details--------------\n" +
                "Hotel Name     : " + hotel.getHotelName() + "\n" +
                "Room Type      : " + room.getRoomType() + "\n" +
                "Check-in Date  : " + checkindate.toString() + "\n" +
                "Check-out Date : " + checkoutdate.toString() + "\n" +
                "Pax            : " + getPax() + "\n" +
                "Days of Stay   : " + calNumDays() + "\n" +
                "Room Price     : RM" + room.getPrice() +"\n" +
                "---------------------------------------------\n" +
                "Total Room Fee : RM" + calTotalRoomPrice() + "\n" +
                "---------------------------------------------\n";
    }

    public long calNumDays() {
        return Period.between(checkindate, checkoutdate).getDays();
    }

    public double calTotalRoomPrice() {
        return room.getPrice() * calNumDays() ;
    }
}
