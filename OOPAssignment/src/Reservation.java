import java.time.LocalDate;

public class Reservation {
    private int resId;
    private Customer custName;
    private LocalDate checkindate;
    private LocalDate checkoutdate;
    private String contact;
    private int pax;
    private int hotel;
    private RoomType roomType;
    private Service service;

    public Reservation(){
    }
    public Reservation(int resId,Customer custName, LocalDate checkindate, LocalDate checkoutdate, String contact, int pax, int hotel, RoomType roomType, Service service) {
        this.resId = resId;
        this.custName = custName;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.contact = contact;
        this.pax = pax;
        this.hotel = hotel;
        this.roomType = roomType;
        this.service = service;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public static int setPax() {
    }

    public String getCustName() {
        return Customer.getCustName();
    }

    public void setCustName(Customer custName) {
        this.custName = custName;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public String getRoomType() {
        return RoomType.getRoomType();
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
}

