package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final int orderDate;
    private final Map<Menu, Integer> orderItems;

    public Order(int orderDate, String orderMenuString) {
        this.orderDate = orderDate;
        this.orderItems = new HashMap<>();
        parseAndAddItems(orderMenuString);
    }
}
