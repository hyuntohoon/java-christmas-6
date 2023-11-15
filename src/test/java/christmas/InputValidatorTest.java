package christmas;

import christmas.validator.InputValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputValidatorTest {

    @Test
    @DisplayName("유효한 주문 날짜는 예외를 발생시키지 않아야 함")
    void validateOrderDate_WithValidDate() {
        assertThatNoException().isThrownBy(() -> InputValidator.validateOrderDate(15));
    }

    @Test
    @DisplayName("유효하지 않은 주문 날짜는 IllegalArgumentException을 발생시켜야 함")
    void validateOrderDate_WithInvalidDate() {
        assertThatThrownBy(() -> InputValidator.validateOrderDate(32))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다.");
    }

    @Test
    @DisplayName("유효한 주문 메뉴는 예외를 발생시키지 않아야 함")
    void validateOrderMenu_WithValidMenu() {
        assertThatNoException().isThrownBy(() -> InputValidator.validateOrderMenu("타파스-2,제로콜라-1"));
    }

    @Test
    @DisplayName("음료만 주문한 경우 예외를 발생시켜야 함")
    void validateOrderMenu_OnlyBeverages() {
        assertThatThrownBy(() -> InputValidator.validateOrderMenu("제로콜라-1,레드와인-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
    }

    @Test
    @DisplayName("유효한 수량은 예외를 발생시키지 않아야 함")
    void validateQuantity_WithValidQuantity() {
        assertThatNoException().isThrownBy(() -> InputValidator.validateQuantity(5));
    }

    @Test
    @DisplayName("유효하지 않은 수량은 IllegalArgumentException을 발생시켜야 함")
    void validateQuantity_WithInvalidQuantity() {
        assertThatThrownBy(() -> InputValidator.validateQuantity(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다.");
    }
}
