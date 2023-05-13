package Service;
public abstract class MenuAbs implements MenuInterface{
    private String name;
    private double price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public MenuAbs(){

    }

    public MenuAbs(String name, double price){
        this.name = name;
        this.price = price;
    }

    public static void printServiceHeader(){
        String sHeader = """
                                
                  ______   ________  _______  ____   ____  _____   ______  ________   ____    ____  ________  ____  _____  _____  _____ \s
                .' ____ \\ |_   __  ||_   __ \\|_  _| |_  _||_   _|.' ___  ||_   __  | |_   \\  /   _||_   __  ||_   \\|_   _||_   _||_   _|\s
                | (___ \\_|  | |_ \\_|  | |__) | \\ \\   / /    | | / .'   \\_|  | |_ \\_|   |   \\/   |    | |_ \\_|  |   \\ | |    | |    | |  \s
                 _.____`.   |  _| _   |  __ /   \\ \\ / /     | | | |         |  _| _    | |\\  /| |    |  _| _   | |\\ \\| |    | '    ' |  \s
                | \\____) | _| |__/ | _| |  \\ \\_  \\ ' /     _| |_\\ `.___.'\\ _| |__/ |  _| |_\\/_| |_  _| |__/ | _| |_\\   |_    \\ \\__/ /   \s
                 \\______.'|________||____| |___|  \\_/     |_____|`.____ .'|________| |_____||_____||________||_____|\\____|    `.__.'    \s
                                                                                                                                        \s
                                
                """;
    }

}
