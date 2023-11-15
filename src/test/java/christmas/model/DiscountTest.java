package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountTest {

    @Test
    @DisplayName("크리스마스 디데이 할인 계산")
    void calculateChristmasDdayDiscount_ShouldCalculateCorrectly() {
        assertThat(Discount.calculateChristmasDdayDiscount(5)).isEqualTo(1400);
        assertThat(Discount.calculateChristmasDdayDiscount(26)).isEqualTo(0);
    }

    @Test
    @DisplayName("평일 디저트 할인 계산")
    void calculateWeekdayDessertDiscount_ShouldCalculateCorrectly() {
        Map<Menu, Integer> orderItems = new HashMap<>();
        orderItems.put(Menu.CHOCO_CAKE, 2);
        orderItems.put(Menu.T_BONE_STEAK, 1);

        assertThat(Discount.calculateWeekdayDessertDiscount(orderItems, true)).isEqualTo(4046);
        assertThat(Discount.calculateWeekdayDessertDiscount(orderItems, false)).isEqualTo(0);
    }

    @Test
    @DisplayName("주말 메인 할인 계산")
    void calculateWeekendMainDiscount_ShouldCalculateCorrectly() {
        Map<Menu, Integer> orderItems = new HashMap<>();
        orderItems.put(Menu.BBQ_RIBS, 1);
        orderItems.put(Menu.ICE_CREAM, 2);

        assertThat(Discount.calculateWeekendMainDiscount(orderItems, true)).isEqualTo(2023);
        assertThat(Discount.calculateWeekendMainDiscount(orderItems, false)).isEqualTo(0);
    }

    @Test
    @DisplayName("특별 이벤트 할인 계산")
    void calculateSpecialEventDiscount_ShouldCalculateCorrectly() {
        assertThat(Discount.calculateSpecialEventDiscount(true)).isEqualTo(1000);
        assertThat(Discount.calculateSpecialEventDiscount(false)).isEqualTo(0);
    }
}
