package christmas.view;

public class OutputView {


    public static void displayWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void displayOrderDetails(String orderDetails) {
        System.out.println("<주문 메뉴>");
        System.out.println(orderDetails);
    }

    public static void displayTotalBeforeDiscount(int totalBeforeDiscount) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", totalBeforeDiscount));
    }

    public static void displayGiftItemDetails(String giftItemDetails) {
        System.out.println("\n<증정 메뉴>");
        if (giftItemDetails.isEmpty()) {
            System.out.println("없음");
            return;
        }
        System.out.println(giftItemDetails);
    }


    public static void displayDiscountDetails(String discountDetails) {
        System.out.println("\n<혜택 내역>");
        System.out.println(discountDetails);
    }

    public static void displayTotalDiscount(int totalDiscount) {
        System.out.println("\n<총혜택 금액>");
        if (totalDiscount > 0) {
            System.out.println("-" + String.format("%,d원", totalDiscount));
            return;
        }
        System.out.println("없음");
    }

    public static void displayTotalAfterDiscount(int totalAfterDiscount) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원", totalAfterDiscount));
    }

    public static void displayBadgeDetails(String badgeDetails) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(badgeDetails);
    }


}
