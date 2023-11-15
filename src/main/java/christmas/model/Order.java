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

        if (parts.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        String menuName = parts[0].trim();
        Menu menu = findMenuByName(menuName);

        try {
            int quantity = Integer.parseInt(parts[1].trim());
            orderItems.put(menu, orderItems.getOrDefault(menu, 0) + quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }


    private Menu findMenuByName(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."));
    }

    public Map<Menu, Integer> getOrderItems() {
        return new HashMap<>(orderItems);
    }

    public int calculateTotalPrice(Order order) {
        return order.getOrderItems().entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
