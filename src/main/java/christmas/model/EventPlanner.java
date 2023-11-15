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


}
