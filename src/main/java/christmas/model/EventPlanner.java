package christmas.model;

import java.util.Map;

public class EventPlanner {
    private final Order order;
    private final int orderDay;
    private final Badge eventBadge;
    private final GiftEvent giftEvent;
    private final DiscountManager discountManager;

    public EventPlanner(int orderDay, String orderMenuString) {
        this.orderDay = orderDay;
        this.order = new Order(orderMenuString);
        this.discountManager = new DiscountManager();
        this.discountManager.calculateDiscounts(order, orderDay);
        this.eventBadge = Badge.getBadgeForAmount(discountManager.getTotalDiscount());
        this.giftEvent = GiftEvent.determineGift(discountManager.calculateTotalPrice(order));
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

}
