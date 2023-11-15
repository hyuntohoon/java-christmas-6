package christmas.validator;

import christmas.model.Menu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MenuValidator {

    public static void validateOrderMenu(String orderMenuString) {
        Set<String> orderedMenus = new HashSet<>();

        String[] menuItems = orderMenuString.split(",");
        for (String item : menuItems) {
            String[] parts = item.split("-");
            if (parts.length != 2 || !isValidQuantity(parts[1].trim())) {
                throw new IllegalArgumentException("[ERROR] 주문 형식이 올바르지 않습니다: " + item);
            }

            String menuName = parts[0].trim();
            if (!isMenuValid(menuName)) {
                throw new IllegalArgumentException("[ERROR] 메뉴판에 없는 메뉴입니다: " + menuName);
            }

            if (!orderedMenus.add(menuName)) {
                throw new IllegalArgumentException("[ERROR] 중복된 메뉴가 있습니다: " + menuName);
            }
        }
    }

    private static boolean isMenuValid(String menuName) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.getName().equalsIgnoreCase(menuName));
    }

    private static boolean isValidQuantity(String quantityString) {
        try {
            int quantity = Integer.parseInt(quantityString);
            return quantity > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
