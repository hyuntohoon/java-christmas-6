package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class DiscountManager {
    private Map<String, Integer> discounts;
    private int giftEventDiscount;
    private static final int MINIMUM_AMOUNT_FOR_DISCOUNT = 10000;

    public DiscountManager() {
        this.discounts = new HashMap<>();
        this.giftEventDiscount = 0;
    }

    public void calculateDiscounts(Order order, int orderDay) {
        int totalOrderAmount = order.calculateTotalPrice(order);
        if (totalOrderAmount <= MINIMUM_AMOUNT_FOR_DISCOUNT) {
            return; // 주문 금액이 최소 요구 금액보다 적으면 할인 없음
        }

        Map<Menu, Integer> orderItems = order.getOrderItems();
        boolean isWeekend = Calendar.isWeekend(orderDay);
        boolean isWeekday = !isWeekend;
        boolean isSpecialEvent = Calendar.isSpecialEventDay(orderDay);

        // 각 할인 항목 계산
        addDiscount("크리스마스 디데이 할인", Discount.calculateChristmasDdayDiscount(orderDay));
        addDiscount("평일 디저트 할인", Discount.calculateWeekdayDessertDiscount(orderItems, isWeekday));
        addDiscount("주말 메인 할인", Discount.calculateWeekendMainDiscount(orderItems, isWeekend));
        addDiscount("특별 이벤트 할인", Discount.calculateSpecialEventDiscount(isSpecialEvent));

        this.giftEventDiscount = calculateGiftEventDiscount(order);
        if (giftEventDiscount > 0) {
            discounts.put("증정 이벤트", giftEventDiscount);
        }
    }

    private int calculateGiftEventDiscount(Order order) {
        int totalBeforeDiscount = order.calculateTotalPrice(order);
        Map<String, Integer> giftItems = GiftEvent.determineGifts(totalBeforeDiscount);

        return giftItems.entrySet().stream()
                .mapToInt(entry -> {
                    String giftName = entry.getKey();
                    int quantity = entry.getValue();
                    GiftEvent giftEvent = GiftEvent.fromDisplayName(giftName);
                    return giftEvent.getGiftPrice() * quantity;
                })
                .sum();
    }

    public int getTotalDiscountWithoutGift() {
        return discounts.values().stream().mapToInt(Integer::intValue).sum() - giftEventDiscount;
    }

    public int getGiftEventDiscount() {
        return giftEventDiscount;
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

}
