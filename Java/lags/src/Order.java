public class Order {
    private final String id;
    private final int start;
    private final int duration;
    private final int price;

    public Order(String idt, int start, int durn, int bid) {
        this.id = idt;
        this.start = start;
        this.duration = durn;
        this.price = bid;
    }
}

