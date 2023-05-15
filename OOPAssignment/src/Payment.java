import java.util.Scanner;

// Base class for the payment process
abstract class Payment {

    protected String paymentType;
    protected double amount;

    // Abstract method to perform the payment
    public abstract void processPayment();

    // Encapsulated getter and setter methods for the amount field
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    // toString method to display payment information
    @Override
    public String toString() {
        return "Payment Type: " + paymentType + "\nAmount: RM " + String.format("%.2f", amount);
    }

}
// Subclass of Payment for cash payments
class CashPayment extends Payment{

    public CashPayment(double amount) {
        this.paymentType = "Cash";
        this.amount = amount;
    }

    public void processPayment(){
        System.out.println("Processing cash payment of RM " + amount);
    }

    @Override
    public String toString(){
        return super.toString() + "\n";
    }
}



// Subclass of Payment for credit card payments
class CreditCardPayment extends Payment{
    private String cardNumber;
    private String expirationDate;
    private String securityCode;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public CreditCardPayment(double amount) {
        this.paymentType = "Credit Card";
        this.amount = amount;
    }

    public CreditCardPayment(double amount, String cardNumber, String expirationDate, String securityCode) {
        this.paymentType = "Credit Card";
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    @Override
    public void processPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter card number: ");
        cardNumber = scanner.next();
        System.out.print("Enter the expiration date (MM/YYYY): ");
        expirationDate = scanner.next();
        System.out.print("Enter the security code: ");
        securityCode = scanner.next();
        System.out.println("Processing credit card payment of RM " + amount);
        System.out.println("Card number: "+ cardNumber);
        System.out.println("Security code: "+ securityCode);
    }

    // Override the toString method to display additional information
    @Override
    public String toString() {
        return super.toString() + "\nCard Number: "+ cardNumber + "\nExpiration Date: " + expirationDate
                + "\nSecurity Code: " + securityCode + "\n";
    }
}

 class Wallet extends Payment{
     public Wallet() {
     }

     public Wallet(double amount) {
         this.paymentType = "Wallet";
         this.amount = amount;
     }

     @Override
    public void processPayment() {
         System.out.println("Processing eWallet RM " + amount + "...");
    }
}




