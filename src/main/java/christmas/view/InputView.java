package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_ORDER_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ASK_ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (예: 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static int readOrderDate() {
        System.out.println(ASK_ORDER_DATE);
        try {
            int orderDate = Integer.parseInt(Console.readLine());
            if (orderDate < 1 || orderDate > 31) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
            return orderDate;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}
