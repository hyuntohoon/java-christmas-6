package christmas.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum GiftEvent {
    CHAMPAGNE_GIFT(120000, "샴페인", 1, 25000); // 예: 12만원 이상 구매 시 샴페인 1개 증정

    private final int threshold;
    private final String giftName;
    private final int quantity;
    private final int giftPrice;

    GiftEvent(int threshold, String giftName, int quantity, int giftPrice) {
        this.threshold = threshold;
        this.giftName = giftName;
        this.quantity = quantity;
        this.giftPrice = giftPrice;
    }

    public static Map<String, Integer> determineGifts(int totalAmount) {
        return java.util.Arrays.stream(GiftEvent.values())
                .filter(event -> totalAmount >= event.threshold)
                .collect(Collectors.toMap(event -> event.giftName, event -> event.quantity, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public int getThreshold() {
        return threshold;
    }

    public String getGiftName() {
        return giftName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getGiftPrice() {
        return giftPrice;
    }
}
