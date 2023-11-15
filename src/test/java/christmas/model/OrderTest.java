package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @Test
    @DisplayName("주문 문자열을 올바르게 파싱하고 주문 항목을 추가하는지 확인")
    void orderShouldParseInputStringCorrectly() {
        String orderString = "타파스-2,제로콜라-1";
        Order order = new Order(orderString);

        assertThat(order.getOrderItems())
                .containsKeys(Menu.TAPAS, Menu.ZERO_COLA)
                .containsValues(2, 1);
    }

    @Test
    @DisplayName("유효하지 않은 주문 문자열에 대해 예외를 던지는지 확인")
    void orderShouldThrowExceptionForInvalidInput() {
        String invalidOrderString = "타파스-abc";

        assertThatThrownBy(() -> new Order(invalidOrderString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다.");
    }

    @Test
    @DisplayName("주문의 총 가격을 올바르게 계산하는지 확인")
    void orderShouldCalculateTotalPriceCorrectly() {
        String orderString = "타파스-2,제로콜라-1";
        Order order = new Order(orderString);

        int totalPrice = order.calculateTotalPrice(order);

        int expectedPrice = Menu.TAPAS.getPrice() * 2 + Menu.ZERO_COLA.getPrice();
        assertThat(totalPrice).isEqualTo(expectedPrice);
    }
}
