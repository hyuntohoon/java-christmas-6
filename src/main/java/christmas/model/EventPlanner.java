package christmas.model;

import java.util.Map;
import java.util.stream.Collectors;

public class EventPlanner {
    private final Order order;
    private final int orderDay;
    private final DiscountManager discountManager;

    public EventPlanner(int orderDay, String orderMenuString) {
        this.orderDay = orderDay;
        this.order = new Order(orderMenuString);
        this.discountManager = new DiscountManager();
        this.discountManager.calculateDiscounts(order, orderDay);
    }

    public String getOrderDetails() {
        return order.getOrderItems().entrySet().stream()
                .map(entry -> entry.getKey().getName() + " " + entry.getValue() + "개")
                .collect(Collectors.joining("\n"));
    }

    public int calculateTotalBeforeDiscount() {
        return order.calculateTotalPrice(order);
    }

    public int calculateTotalDiscount() {
        return discountManager.getTotalDiscount();
    }

    public int calculateTotalAfterDiscount() {
        return calculateTotalBeforeDiscount() - calculateTotalDiscount();
    }

    public String getDiscountDetails() {
        Map<String, Integer> discounts = discountManager.getDiscounts();
        if (discounts.isEmpty()) {
            return "없음";
        }
        return discounts.entrySet().stream()
                .map(entry -> entry.getKey() + ": -" + entry.getValue() + "원")
                .collect(Collectors.joining("\n"));
    }

    public String getEventBadgeDetails() {
        Badge badge = Badge.getBadgeForAmount(calculateTotalDiscount());
        if (badge != null) {
            return badge.getDisplayName();
        }
        return "없음";
    }

    public String getGiftItemDetails() {
        Map<String, Integer> giftItems = GiftEvent.determineGifts(calculateTotalBeforeDiscount());
        if (giftItems.isEmpty()) {
            return "없음";
        }
        return giftItems.keySet().stream().collect(Collectors.joining(", "));
    }
}
