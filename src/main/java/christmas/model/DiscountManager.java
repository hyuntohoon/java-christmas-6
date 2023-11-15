package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class DiscountManager {
    private Map<String, Integer> discounts;

    public DiscountManager() {
        this.discounts = new HashMap<>();
    }

    public void calculateDiscounts(Order order, int orderDay) {
        Map<Menu, Integer> orderItems = order.getOrderItems();
        boolean isWeekend = Calendar.isWeekend(orderDay);
        boolean isWeekday = !isWeekend;
        boolean isSpecialEvent = Calendar.isSpecialEventDay(orderDay);

        addDiscount("크리스마스 디데이 할인", Discount.calculateChristmasDdayDiscount(orderDay));
        addDiscount("평일 디저트 할인", Discount.calculateWeekdayDessertDiscount(orderItems, isWeekday));
        addDiscount("주말 메인 할인", Discount.calculateWeekendMainDiscount(orderItems, isWeekend));
        addDiscount("특별 이벤트 할인", Discount.calculateSpecialEventDiscount(isSpecialEvent));
    }

    private void addDiscount(String name, int amount) {
        if (amount > 0) {
            discounts.put(name, amount);
        }
    }

    public Map<String, Integer> getDiscounts() {
        return discounts;
    }

    public int getTotalDiscount() {
        return discounts.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int calculateTotalPrice(Order order) {
        return order.getOrderItems().entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

}