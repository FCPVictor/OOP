package Loyalty;

public class Loyalty {
    private String tier;
    private double points;
    private final double BRONZE_DISCOUNT = 0.01;
    private final double SILVER_DISCOUNT = 0.015;
    private final double GOLD_DISCOUNT = 0.03;
    private final double DIAMOND_DISCOUNT = 0.05;

    public Loyalty(){

    }

    public Loyalty(String tier, double points){
        this.tier = tier;
        this.points = points;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getDiscount() {
        if (this.tier.equalsIgnoreCase("Bronze")) {
            return BRONZE_DISCOUNT;
        } else if (this.tier.equalsIgnoreCase("Silver")) {
            return SILVER_DISCOUNT;
        } else if (this.tier.equalsIgnoreCase("Gold")) {
            return GOLD_DISCOUNT;
        } else if (this.tier.equalsIgnoreCase("Diamond")) {
            return DIAMOND_DISCOUNT;
        } else {
            return 0.0;
        }
    }

}
