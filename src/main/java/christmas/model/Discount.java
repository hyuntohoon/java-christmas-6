package christmas.model;

import java.util.Map;

public class Discount {
    private static final int WEEKDAY_DESSERT_DISCOUNT = 2023;
    private static final int WEEKEND_MAIN_DISCOUNT = 2023;
    private static final int SPECIAL_EVENT_DISCOUNT = 1000;

    public static int calculateChristmasDdayDiscount(int orderDay) {
        if (orderDay >= 1 && orderDay <= 25) {
            return 1000 + (orderDay - 1) * 100;
        }
        return 0;
    }

    public static int calculateWeekdayDessertDiscount(Map<Menu, Integer> orderItems, boolean isWeekday) {
        if (!isWeekday) {
            return 0;
        }
        return orderItems.entrySet().stream()
                .filter(entry -> "Dessert".equals(entry.getKey().getType()))
                .mapToInt(entry -> WEEKDAY_DESSERT_DISCOUNT * entry.getValue())
                .sum();
    }

    public static int calculateWeekendMainDiscount(Map<Menu, Integer> orderItems, boolean isWeekend) {
        if (!isWeekend) {
            return 0;
        }
        return orderItems.entrySet().stream()
                .filter(entry -> "Main".equals(entry.getKey().getType()))
                .mapToInt(entry -> WEEKEND_MAIN_DISCOUNT * entry.getValue())
                .sum();
    }

    public static int calculateSpecialEventDiscount(boolean isSpecialEvent) {
        if (isSpecialEvent) {
            return SPECIAL_EVENT_DISCOUNT;
        }
        return 0;
    }

}
