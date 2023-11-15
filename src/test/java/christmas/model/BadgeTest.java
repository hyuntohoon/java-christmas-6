package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BadgeTest {

    @Test
    @DisplayName("5000원 이상의 금액에 대해 '별' 배지를 반환")
    void getBadgeForAmount_ShouldReturnStarForAmountOver5000() {
        assertThat(Badge.getBadgeForAmount(5000)).isEqualTo(Badge.STAR);
        assertThat(Badge.getBadgeForAmount(9999)).isEqualTo(Badge.STAR);
    }

    @Test
    @DisplayName("10000원 이상의 금액에 대해 '트리' 배지를 반환")
    void getBadgeForAmount_ShouldReturnTreeForAmountOver10000() {
        assertThat(Badge.getBadgeForAmount(10000)).isEqualTo(Badge.TREE);
        assertThat(Badge.getBadgeForAmount(19999)).isEqualTo(Badge.TREE);
    }

    @Test
    @DisplayName("20000원 이상의 금액에 대해 '산타' 배지를 반환")
    void getBadgeForAmount_ShouldReturnSantaForAmountOver20000() {
        assertThat(Badge.getBadgeForAmount(20000)).isEqualTo(Badge.SANTA);
        assertThat(Badge.getBadgeForAmount(30000)).isEqualTo(Badge.SANTA);
    }

    @Test
    @DisplayName("5000원 미만의 금액에 대해 null 반환")
    void getBadgeForAmount_ShouldReturnNullForAmountUnder5000() {
        assertThat(Badge.getBadgeForAmount(4999)).isNull();
    }
}
