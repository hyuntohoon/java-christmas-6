package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GiftEventTest {

    @Test
    @DisplayName("적절한 총 금액에 따라 증정 이벤트를 결정")
    void determineGifts_ShouldReturnCorrectGifts() {
        int totalAmount = 150000; // 금액이 충분하여 샴페인 증정 이벤트에 해당
        Map<String, Integer> gifts = GiftEvent.determineGifts(totalAmount);

        assertThat(gifts).containsOnlyKeys("샴페인");
        assertThat(gifts.get("샴페인")).isEqualTo(1);
    }

    @Test
    @DisplayName("적절하지 않은 총 금액에 따라 증정 이벤트가 없음")
    void determineGifts_NoGiftsForInsufficientAmount() {
        int totalAmount = 50000; // 금액이 증정 이벤트에 부족
        Map<String, Integer> gifts = GiftEvent.determineGifts(totalAmount);

        assertThat(gifts).isEmpty();
    }

    @Test
    @DisplayName("해당하는 displayName의 GiftEvent 반환")
    void fromDisplayName_ShouldReturnCorrectGiftEvent() {
        String displayName = "샴페인";
        GiftEvent giftEvent = GiftEvent.fromDisplayName(displayName);

        assertThat(giftEvent).isEqualTo(GiftEvent.CHAMPAGNE_GIFT);
    }

    @Test
    @DisplayName("존재하지 않는 displayName에 대해 예외 발생")
    void fromDisplayName_ThrowsExceptionForInvalidName() {
        String invalidDisplayName = "Invalid Name";

        assertThatThrownBy(() -> GiftEvent.fromDisplayName(invalidDisplayName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No gift event with name: " + invalidDisplayName);
    }
}
