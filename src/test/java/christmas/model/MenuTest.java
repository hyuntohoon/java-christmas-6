package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    @Test
    @DisplayName("모든 메뉴 항목의 이름, 유형 및 가격이 정확한지 확인")
    void allMenuItems_ShouldHaveCorrectProperties() {
        // 애피타이저 테스트
        assertMenuProperties(Menu.MUSHROOM_SOUP, "양송이수프", "Appetizer", 6000);
        assertMenuProperties(Menu.TAPAS, "타파스", "Appetizer", 5500);
        assertMenuProperties(Menu.CAESAR_SALAD, "시저샐러드", "Appetizer", 8000);

        // 메인 테스트
        assertMenuProperties(Menu.T_BONE_STEAK, "티본스테이크", "Main", 55000);
        assertMenuProperties(Menu.BBQ_RIBS, "바비큐립", "Main", 54000);
        assertMenuProperties(Menu.SEAFOOD_PASTA, "해산물파스타", "Main", 35000);
        assertMenuProperties(Menu.CHRISTMAS_PASTA, "크리스마스파스타", "Main", 25000);

        // 디저트 테스트
        assertMenuProperties(Menu.CHOCO_CAKE, "초코케이크", "Dessert", 15000);
        assertMenuProperties(Menu.ICE_CREAM, "아이스크림", "Dessert", 5000);

        // 음료 테스트
        assertMenuProperties(Menu.ZERO_COLA, "제로콜라", "Beverage", 3000);
        assertMenuProperties(Menu.RED_WINE, "레드와인", "Beverage", 60000);
        assertMenuProperties(Menu.CHAMPAGNE, "샴페인", "Beverage", 25000);
    }

    private void assertMenuProperties(Menu menu, String expectedName, String expectedType, int expectedPrice) {
        assertThat(menu.getName()).isEqualTo(expectedName);
        assertThat(menu.getType()).isEqualTo(expectedType);
        assertThat(menu.getPrice()).isEqualTo(expectedPrice);
    }
}
