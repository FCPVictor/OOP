public class TopUp {
    private Customer custName;
    private Customer balance;
    private int topUpAmount;

    public TopUp(){
    };

    public TopUp(Customer custName, Customer balance, int topUpAmount) {
        this.custName = custName;
        this.balance = balance;
        this.topUpAmount = topUpAmount;
    }

    public String getCustName() {
        return Customer.getCustName();
    }

    public void setCustName(Customer custName) {
        this.custName = custName;
    }

    public int getBalance() {
        return Customer.getBalance();
    }

    public void setBalance(Customer balance) {
        this.balance = balance;
    }

    public int getTopUpAmount() {
        return topUpAmount;
    }

    public void setTopUpAmount(int topUpAmount) {
        this.topUpAmount = topUpAmount;
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
