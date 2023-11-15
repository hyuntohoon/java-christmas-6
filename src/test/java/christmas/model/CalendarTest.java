package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalendarTest {

    @Test
    @DisplayName("특별 이벤트 날짜 확인")
    void isSpecialEventDay_ShouldCorrectlyIdentifySpecialEventDays() {
        assertThat(Calendar.isSpecialEventDay(3)).isTrue();
        assertThat(Calendar.isSpecialEventDay(10)).isTrue();
        assertThat(Calendar.isSpecialEventDay(1)).isFalse();
    }

    @Test
    @DisplayName("주말 여부 확인")
    void isWeekend_ShouldCorrectlyIdentifyWeekendDays() {
        assertThat(Calendar.isWeekend(2)).isTrue();
        assertThat(Calendar.isWeekend(9)).isTrue();
        assertThat(Calendar.isWeekend(8)).isFalse();
    }

    @Test
    @DisplayName("평일 여부 확인")
    void isWeekDay_ShouldCorrectlyIdentifyWeekDays() {
        assertThat(Calendar.isWeekDay(4)).isTrue();
        assertThat(Calendar.isWeekDay(16)).isFalse();
        assertThat(Calendar.isWeekDay(23)).isFalse();
    }
}
