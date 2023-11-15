package christmas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventPlannerTest {
    private EventPlanner eventPlanner;

    @BeforeEach
    void setUp() {
        int orderDay = 15; // 임의의 날짜 설정
        String orderMenuString = "타파스-2,제로콜라-1"; // 임의의 주문 설정
        eventPlanner = new EventPlanner(orderDay, orderMenuString);
    }

    @Test
    @DisplayName("주문 상세를 올바르게 반환하는지 확인")
    void getOrderDetails_ShouldReturnCorrectDetails() {
        String orderDetails = eventPlanner.getOrderDetails();
        String[] detailsArray = orderDetails.split("\n");

        assertThat(detailsArray).contains("제로콜라 1개", "타파스 2개");
    }

    @Test
    @DisplayName("할인 전 총 금액을 올바르게 계산하는지 확인")
    void calculateTotalBeforeDiscount_ShouldCalculateCorrectly() {
        int expectedTotal = Menu.TAPAS.getPrice() * 2 + Menu.ZERO_COLA.getPrice();
        assertThat(eventPlanner.calculateTotalBeforeDiscount()).isEqualTo(expectedTotal);
    }

    @Test
    @DisplayName("할인 후 총 금액을 올바르게 계산하는지 확인")
    void calculateTotalAfterDiscount_ShouldCalculateCorrectly() {
        int totalBeforeDiscount = eventPlanner.calculateTotalBeforeDiscount();
        int totalDiscount = eventPlanner.calculateTotalDiscount();

        assertThat(eventPlanner.calculateTotalAfterDiscount())
                .isEqualTo(totalBeforeDiscount - totalDiscount);
    }

    @Test
    @DisplayName("배지 테스트: 할인 금액이 최소 배지 금액 미만일 때 '없음' 반환")
    void badgeShouldReturnNoneForAmountBelowMinimum() {
        int lowAmount = 1000; // Amount below any badge minimum
        Badge badge = Badge.getBadgeForAmount(lowAmount);
        String badgeDisplayName;
        if (badge == null) {
            badgeDisplayName = "없음";
        } else {
            badgeDisplayName = badge.getDisplayName();
        }
        assertThat(badgeDisplayName).isEqualTo("없음");
    }

    @Test
    @DisplayName("증정 아이템 내역을 올바르게 반환하는지 확인")
    void getGiftItemDetails_ShouldReturnCorrectDetails() {
        assertThat(eventPlanner.getGiftItemDetails()).isNotBlank();
    }
}
