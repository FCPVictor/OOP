import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String custId;
    private static String custName;
    private int custIc;
    private String contact;
    private String email;
    private static int balance;
    private ArrayList<Reservation> reservation;

    public Customer(){
    }

    public Customer(String custId,String custName, int custIc, String contact, String email, int balance, List<Reservation> reservation){
        this.custId = custId;
        this.custName = custName;
        this.custIc = custIc;
        this.contact = contact;
        this.email = email;
        this.balance = balance;
        this.reservation = (ArrayList<Reservation>) reservation;
    }

    public void addReservation(Reservation reservation) {
        if (this.reservation == null) {
            this.reservation = new ArrayList<>();
        }
        this.reservation.add(reservation);
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

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getCustIc() {
        return custIc;
    }

    public void setCustIc(int custIc) {
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

    public static int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = (ArrayList<Reservation>) reservation;
    }
}
