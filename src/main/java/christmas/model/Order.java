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

    private void parseAndAddItems(String orderMenuString) {
        String[] menuItems = orderMenuString.split(",");

        for (String item : menuItems) {
            addItemFromString(item);
        }
    }

    private void addItemFromString(String item) {
        String[] parts = item.split("-");

        if (parts.length != 2) {
            throw new IllegalArgumentException("[ERROR] 주문 형식이 올바르지 않습니다: " + item);
        }

        String menuName = parts[0].trim();
        int quantity = parseQuantity(parts[1].trim());
        Menu menu = findMenuByName(menuName);
        orderItems.put(menu, orderItems.getOrDefault(menu, 0) + quantity);
    }

}
