public class TopUp {

    private Customer customer;
    private double toupAmount;

    public TopUp() {
    }

    public TopUp(Customer customer, double toupAmount) {
        this.customer = customer;
        this.toupAmount = toupAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getToupAmount() {
        return toupAmount;
    }

    public void setToupAmount(double toupAmount) {
        this.toupAmount = toupAmount;
    }

    public void addFunds(Customer customer, double topupAmount) {
        double currentBalance = customer.getBalance();
        double newBalance = currentBalance + topupAmount;
        customer.setBalance(newBalance);
    }

    public static void topupHeader(){
        System.out.println("*********************************************");
        System.out.println("*  _______ ____  _____    _    _ _____      *");
        System.out.println("* |__   __/ __ \\|  __ \\  | |  | |__ \\  *");
        System.out.println("*    | | | |  | | |__) | | |  | | |__) |    *");
        System.out.println("*    | | | |  | |  ___/  | |  | |  ___/     *");
        System.out.println("*    | | | |__| | |      | |__| | |         *");
        System.out.println("*    |_|  \\____/|_|      \\____/|_|       *");
        System.out.println("*********************************************\n");

    }

}
