package christmas.model;

import java.util.Map;
import java.util.stream.Collectors;

public class EventPlanner {
    private final Order order;
    private final int orderDay;
    private final Badge eventBadge;
    private final Map<String, Integer> giftItems;
    private final DiscountManager discountManager;

    public EventPlanner(int orderDay, String orderMenuString) {
        this.orderDay = orderDay;
        this.order = new Order(orderMenuString);
        this.discountManager = new DiscountManager();
        this.discountManager.calculateDiscounts(order, orderDay);
        this.eventBadge = Badge.getBadgeForAmount(discountManager.getTotalDiscount());
        this.giftItems = GiftEvent.determineGifts(discountManager.calculateTotalPrice(order));
    }

    public int getTotalBeforeDiscount() {
        return discountManager.calculateTotalPrice(order);
    }

    public int getTotalDiscount() {
        return discountManager.getTotalDiscount();
    }

    public int getTotalAfterDiscount() {
        return getTotalBeforeDiscount() - getTotalDiscount();
    }

    public String getGiftItemNames() {
        if (giftItems.isEmpty()) {
            return null;
        }
        return giftItems.keySet().stream().collect(Collectors.joining(", "));
    }

    public int getTotalGiftValue() {
        return giftItems.entrySet().stream()
                .mapToInt(entry -> GiftEvent.valueOf(entry.getKey().toUpperCase()).getGiftPrice() * entry.getValue())
                .sum();
    }

}
