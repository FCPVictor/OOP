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
        this.toupAmount = topupAmount;
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
        System.out.println("""
                
                  _____                            __   _             _________  _                \s
                 |_   _|                          [  | / |_          |  _   _  |(_)               \s
                   | |       .--.   _   __  ,--.   | |`| |-' _   __  |_/ | | \\_|__  .---.  _ .--. \s
                   | |   _ / .'`\\ \\[ \\ [  ]`'_\\ :  | | | |  [ \\ [  ]     | |   [  |/ /__\\\\[ `/'`\\]\s
                  _| |__/ || \\__. | \\ '/ / // | |, | | | |,  \\ '/ /     _| |_   | || \\__., | |    \s
                 |________| '.__.'[\\_:  /  \\'-;__/[___]\\__/[\\_:  /     |_____| [___]'.__.'[___]   \s
                                   \\__.'                    \\__.'                                 \s
                """);
        System.out.println("Top up value:  500 & above -  Bronze Tier  (1% offer)");
        System.out.println("Top up value: 1000 & above -  Silver Tier  (1.5% offer)");
        System.out.println("Top up value: 1500 & above -  Gold Tier    (3% offer)");
        System.out.println("Top up value: 2000 & above -  Diamond Tier (5% offer)");

    }

}
