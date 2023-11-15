package christmas.model;

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

}
