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

    // toString method to display payment information
    public String toString() {
        return "Payment Type: " + paymentType + "\nAmount: $" + amount;
    }

    public static void printPaymentArt() {
        String artWork;

        artWork = """
                _____    __     ____  __ ______ _   _ _______        \s
                |  __ \\ /\\\\ \\   / /  \\/  |  ____| \\ | |__   __| \s
                | |__) /  \\\\ \\_/ /| \\  / | |__  |  \\| |  | |     \s
                |  ___/ /\\ \\\\   / | |\\/| |  __| | . ` |  | |      \s
                | |  / ____ \\| |  | |  | | |____| |\\  |  | |        \s
                |_| /_/    \\_\\_|  |_|  |_|______|_| \\_|  |_|       \s
                                                              
                    """;
    }
}
    // Subclass of Payment for cash payments
    class CashPayment extends Payment{

        public CashPayment(double amount) {
            this.paymentType = "Cash";
            this.amount = amount;
        }

        public void processPayment(){
            System.out.println("Processing cash payment of $" + amount);
        }

        public String toString(){
            return super.toString() + "\n";
        }
    }



    // Subclass of Payment for credit card payments
    class CreditCardPayment extends Payment{
        private String cardNumber;
        private String expirationDate;
        private String securityCode;

        public CreditCardPayment(double amount, String cardNumber, String expirationDate, String securityCode) {
            this.paymentType = "Credit Card";
            this.amount = amount;
            this.cardNumber = cardNumber;
            this.expirationDate = expirationDate;
            this.securityCode = securityCode;
        }

        @Override
        public void processPayment() {
            System.out.println("Processing credit card payment of $" + amount);
            System.out.println("Card number: "+ cardNumber);
            System.out.println("Security code: "+ securityCode);
        }

        // Override the toString method to display additional information
        public String toString() {
            return super.toString() + "\nCard Number: "+ cardNumber + "\nExpiration Date: " + expirationDate
                    + "\nSecurity Code: " + securityCode + "\n";
        }
    }

    class PayOnlineBankAccount extends Payment{

        private String accUsername;
        private String accPassword;

        // Implementation of the processPayment() method for PayPal payments
        @Override
        public void processPayment() {
            System.out.println("Processing Bank Account payment of $" + amount);
            System.out.println("Email: " + accUsername);
            System.out.println("Password: " + accPassword);
        }

        public String toString() {
            return super.toString() + "\nUsername: " + accUsername + "\nPassword: " + accPassword + "\n";
        }
    }




