package lags;

public class Order {
    private final String id;
    private final int start;
    private final int duration;
    private final int price;
    public int revenue;

    public Order(String idt, int start, int durn, int bid) {
        this.id = idt;
        this.start = start;
        this.duration = durn;
        this.price = bid;
        this.revenue = -1;
    }

    public int getStart() {
        return this.start;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getPrice() {
        return this.price;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getId() {
        return this.id;
    }
}