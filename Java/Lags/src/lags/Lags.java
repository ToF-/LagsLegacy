package lags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lags {
    private final List<Order> orders;

    public Lags(List<Order> orders) {
        this.orders = orders;
    }

    public int revenue_orders(List<Order> orders) {
        if(orders.size() == 0)
            return 0;
        Order order = orders.get(0);
        if(order.revenue != -1)
            return order.revenue;
        List<Order> comp = selection(orders, order);
        int rc = order.getPrice() + revenue_orders(comp);

        List<Order> ordersMinusFirst = removeFirst(orders);
        int rn = revenue_orders(ordersMinusFirst);
        order.setRevenue(Math.max(rc, rn));
        return Math.max(rc, rn);
    }

    private List<Order> removeFirst(List<Order> orders) {
        List <Order>remove = new ArrayList(orders);
        remove.remove(0);
        return remove;
    }

    public int revenue() {
        Comparator<Order> cm = new Comparator<Order>() {
            @Override
            public int compare(Order a, Order b) {
                return a.getStart() - b.getStart();
            }
        };
        Collections.sort(this.orders, cm);
        return revenue_orders(this.orders);
    }
    private List<Order> selection(List<Order> orders, Order order) {
        List<Order>select = new ArrayList<Order>();

        int start = order.getStart();
        int end   = start + order.getDuration();
        int final_end;
        int year  = start / 1000;
        int year_end = year * 1000 + 365;
        if(end > year_end) {
            int days = end - year_end;
            end = (year + 1) * 1000 + days;
        }
        for (Order o : orders) {
            if(o.getStart() >= end) {
                select.add(o);
            }
        }
        return select;
    }
};