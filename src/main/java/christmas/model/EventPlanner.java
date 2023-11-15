package christmas.model;

public class EventPlanner {
    private Order order;
    private int orderDay;
    private int totalBeforeDiscount;
    private int totalDiscount;
    private int totalAfterDiscount;
    private Badge eventBadge;
    private String giftItem;

    public EventPlanner(int orderDay, String orderMenuString) {
        this.orderDay = orderDay;
        this.order = new Order(orderMenuString);
        calculateOrderDetails();
    }

    private void calculateOrderDetails() {
        this.totalBeforeDiscount = order.calculateTotalPrice();
        this.totalDiscount = calculateTotalDiscount();
        this.totalAfterDiscount = this.totalBeforeDiscount - this.totalDiscount;
        this.eventBadge = determineEventBadge();
        this.giftItem = determineGiftItem();
    }

}
