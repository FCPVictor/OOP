import java.util.ArrayList;

public class Customer {
    private String custId;
    private static String custName;
    private String custIc;
    private String contact;
    private String email;
    private double balance;
    private ArrayList<Reservation> reservation = new ArrayList<>();

    private Wallet wallet;

    public Customer() {
    }

    public Customer(String custId, String custIc, String contact, String email, double balance) {
        this.custId = custId;
        this.custIc = custIc;
        this.contact = contact;
        this.email = email;
        this.balance = balance;
        this.reservation = new ArrayList<>();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public static String getCustName() {
        return custName;
    }

    public static void setCustName(String custName) {
        Customer.custName = custName;
    }

    public String getCustIc() {
        return custIc;
    }

    public void setCustIc(String custIc) {
        this.custIc = custIc;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addReservation(Reservation reservation){
        this.reservation.add(reservation);
    }

    public ArrayList<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(ArrayList<Reservation> reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        String reservationDetails = "";
        for (Reservation r : reservation) {
            reservationDetails += r.toString() + "\n";
        }

        return  "\n==========================================\n" +
                "|          Reservation Summary           |\n" +
                "==========================================\n" +
                "Customer ID : " + custId + reservationDetails +
                "============================================";

    }
}



