package christmas.model;

public enum Menu {
    // 애피타이저
    MUSHROOM_SOUP("양송이수프", "Appetizer", 6000),
    TAPAS("타파스", "Appetizer", 5500),
    CAESAR_SALAD("시저샐러드", "Appetizer", 8000),

    // 메인
    T_BONE_STEAK("티본스테이크", "Main", 55000),
    BBQ_RIBS("바비큐립", "Main", 54000),
    SEAFOOD_PASTA("해산물파스타", "Main", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", "Main", 25000),

    // 디저트
    CHOCO_CAKE("초코케이크", "Dessert", 15000),
    ICE_CREAM("아이스크림", "Dessert", 5000),

    // 음료
    ZERO_COLA("제로콜라", "Beverage", 3000),
    RED_WINE("레드와인", "Beverage", 60000),
    CHAMPAGNE("샴페인", "Beverage", 25000);

    private final String name;
    private final String type;
    private final int price;

    Menu(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public static String getTypeByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equalsIgnoreCase(name)) {
                return menu.type;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴: " + name);
    }
}
