package christmas.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> orderItems;

    public Order(String orderMenuString) {
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
        String menuName = parts[0].trim();
        int quantity = Integer.parseInt(parts[1].trim());
        Menu menu = findMenuByName(menuName);
        orderItems.put(menu, orderItems.getOrDefault(menu, 0) + quantity);
    }

    private Menu findMenuByName(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴: " + name));
    }

    public Map<Menu, Integer> getOrderItems() {
        return new HashMap<>(orderItems);
    }
}
