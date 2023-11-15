package christmas.model;

public enum GiftEvent {
    CHAMPAGNE_GIFT(120000, "샴페인"); // 예: 12만원 이상 구매 시 샴페인 증정

    private final int threshold;
    private final String giftItem;

    GiftEvent(int threshold, String giftItem) {
        this.threshold = threshold;
        this.giftItem = giftItem;
    }
}
