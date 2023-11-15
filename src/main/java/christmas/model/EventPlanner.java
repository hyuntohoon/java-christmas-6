package christmas.model;

import java.util.Map;

public class EventPlanner {
    private Order order;
    private int orderDay;
    private int totalBeforeDiscount;
    private int totalDiscount;
    private int totalAfterDiscount;
    private Badge eventBadge;
    private GiftEvent giftEvent;

    public EventPlanner(int orderDay, String orderMenuString) {
        this.orderDay = orderDay;
        this.order = new Order(orderMenuString);
        calculateOrderDetails();
    }

    private void calculateOrderDetails() {
        this.totalBeforeDiscount = order.calculateTotalPrice();
        this.totalDiscount = calculateTotalDiscount();
        this.totalAfterDiscount = this.totalBeforeDiscount - this.totalDiscount;
        this.eventBadge = Badge.getBadgeForAmount(totalDiscount);
        this.giftEvent = GiftEvent.determineGift(totalBeforeDiscount);
    }

    private int calculateTotalDiscount() {
        boolean isWeekend = Calendar.isWeekend(this.orderDay);
        boolean isSpecialEvent = Calendar.isSpecialEventDay(this.orderDay);
        int discount = 0;
        Map<Menu, Integer> orderItems = this.order.getOrderItems();
        discount += Discount.calculateWeekendMainDiscount(orderItems, isWeekend);
        discount += Discount.calculateSpecialEventDiscount(isSpecialEvent);
        discount += Discount.calculateChristmasDdayDiscount(this.orderDay);
        return discount;
    }

}
