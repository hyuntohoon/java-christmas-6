package christmas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DiscountManagerTest {

    private DiscountManager discountManager;
    private Order mockOrder;

    @BeforeEach
    void setUp() {
        discountManager = new DiscountManager();
        mockOrder = mock(Order.class);
    }

    @Test
    @DisplayName("할인 관리자가 총 할인 금액을 정확히 계산")
    void getTotalDiscount_ShouldCalculateCorrectly() {
        // Mock order items and discounts
        Map<Menu, Integer> mockOrderItems = Map.of(Menu.CHOCO_CAKE, 2, Menu.T_BONE_STEAK, 1);
        when(mockOrder.getOrderItems()).thenReturn(mockOrderItems);
        when(mockOrder.calculateTotalPrice(mockOrder)).thenReturn(10000);

        int orderDay = 10; // Special event day
        discountManager.calculateDiscounts(mockOrder, orderDay);

        int totalDiscount = discountManager.getTotalDiscount();
        assertThat(totalDiscount).isGreaterThan(0);
    }

    @Test
    @DisplayName("증정 이벤트 할인을 제외한 총 할인 금액 계산")
    void getTotalDiscountWithoutGift_ShouldExcludeGiftEventDiscount() {
        // Mock order items and discounts
        Map<Menu, Integer> mockOrderItems = Map.of(Menu.CHOCO_CAKE, 2, Menu.T_BONE_STEAK, 1);
        when(mockOrder.getOrderItems()).thenReturn(mockOrderItems);
        when(mockOrder.calculateTotalPrice(mockOrder)).thenReturn(120000); // High enough for gift event

        int orderDay = 15; // Not a special event day
        discountManager.calculateDiscounts(mockOrder, orderDay);

        int totalDiscountWithoutGift = discountManager.getTotalDiscountWithoutGift();
        assertThat(totalDiscountWithoutGift).isLessThan(discountManager.getTotalDiscount());
    }

    @Test
    @DisplayName("증정 이벤트 할인 금액 계산")
    void getGiftEventDiscount_ShouldCalculateGiftEventDiscount() {
        // Mock order items for a high total that triggers a gift event
        Map<Menu, Integer> mockOrderItems = Map.of(Menu.CHOCO_CAKE, 2, Menu.T_BONE_STEAK, 1);
        when(mockOrder.getOrderItems()).thenReturn(mockOrderItems);
        when(mockOrder.calculateTotalPrice(mockOrder)).thenReturn(120000);

        int orderDay = 5; // Not a special event day
        discountManager.calculateDiscounts(mockOrder, orderDay);

        int giftEventDiscount = discountManager.getGiftEventDiscount();
        assertThat(giftEventDiscount).isGreaterThan(0);
    }
}
