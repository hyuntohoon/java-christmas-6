package christmas.validator;

import christmas.model.Menu;

public class InputValidator {

    public static void validateOrderDate(int orderDate) {
        if (orderDate < 1 || orderDate > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateOrderMenu(String input) {
        String[] menuItems = input.split(",");
        boolean allBeverages = true;

        for (String item : menuItems) {
            validateMenuItem(item);
            String menuName = item.split("-")[0].trim();
            String menuType = Menu.getTypeByName(menuName);

            if (!menuType.equals("Beverage")) {
                allBeverages = false;
                break;
            }
        }

        if (allBeverages) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
        }
    }

    public static void validateMenuItem(String item) {
        String[] parts = item.split("-");

        if (parts.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        String menuName = parts[0].trim();
        try {
            int quantity = Integer.parseInt(parts[1].trim());
            validateQuantity(quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }


}
