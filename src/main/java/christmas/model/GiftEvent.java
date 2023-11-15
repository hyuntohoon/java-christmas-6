package christmas.model;

public enum GiftEvent {
    CHAMPAGNE_GIFT(120000, "샴페인"); // 예: 12만원 이상 구매 시 샴페인 증정

    private final int threshold;
    private final String giftName;

    GiftEvent(int threshold, String giftName) {
        this.threshold = threshold;
        this.giftName = giftName;
    }

    public static GiftEvent determineGift(int totalAmount) {
        for (GiftEvent event : GiftEvent.values()) {
            if (totalAmount >= event.threshold) {
                return event;
            }
        }
        return null; // 증정 아이템이 없는 경우
    }

    public int getThreshold() {
        return threshold;
    }

    public String getGiftName() {
        return giftName;
    }
}
