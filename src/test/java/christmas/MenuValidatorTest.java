package christmas;

import christmas.validator.MenuValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuValidatorTest {

    @Test
    @DisplayName("메뉴판에 없는 메뉴일 경우 예외를 발생시켜야 한다")
    void validateOrderMenu_WithInvalidMenu_ShouldThrowException() {
        assertThatThrownBy(() -> MenuValidator.validateOrderMenu("존재하지않는메뉴-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 메뉴판에 없는 메뉴입니다");
    }

    @Test
    @DisplayName("중복된 메뉴가 있을 경우 예외를 발생시켜야 한다")
    void validateOrderMenu_WithDuplicateMenu_ShouldThrowException() {
        assertThatThrownBy(() -> MenuValidator.validateOrderMenu("제로콜라-1,제로콜라-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 메뉴가 있습니다");
    }

    @Test
    @DisplayName("유효하지 않은 수량일 경우 예외를 발생시켜야 한다")
    void validateOrderMenu_WithInvalidQuantity_ShouldThrowException() {
        assertThatThrownBy(() -> MenuValidator.validateOrderMenu("제로콜라-0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 주문 형식이 올바르지 않습니다");
    }
}
