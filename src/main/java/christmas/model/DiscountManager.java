package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class DiscountManager {
    private Map<String, Integer> discounts;
    private int giftEventDiscount;
    public DiscountManager() {
        this.discounts = new HashMap<>();
        this.giftEventDiscount = 0;
    }


    public void calculateDiscounts(Order order, int orderDay) {
        Map<Menu, Integer> orderItems = order.getOrderItems();
        boolean isWeekend = Calendar.isWeekend(orderDay);
        boolean isWeekday = !isWeekend;
        boolean isSpecialEvent = Calendar.isSpecialEventDay(orderDay);
        this.giftEventDiscount = calculateGiftEventDiscount(order);
        addDiscount("크리스마스 디데이 할인", Discount.calculateChristmasDdayDiscount(orderDay));
        addDiscount("평일 디저트 할인", Discount.calculateWeekdayDessertDiscount(orderItems, isWeekday));
        addDiscount("주말 메인 할인", Discount.calculateWeekendMainDiscount(orderItems, isWeekend));
        addDiscount("특별 이벤트 할인", Discount.calculateSpecialEventDiscount(isSpecialEvent));

        int giftDiscount = calculateGiftEventDiscount(order);
        this.giftEventDiscount = giftDiscount;
        if (giftDiscount > 0) {
            discounts.put("증정 이벤트", giftDiscount);
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
