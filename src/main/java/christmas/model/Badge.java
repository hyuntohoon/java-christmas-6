package christmas.model;

public enum Badge {
    STAR(5000, "별"),
    TREE(10000, "트리"),
    SANTA(20000, "산타");

    private final int minimumAmount;
    private final String displayName;

    Badge(int minimumAmount, String displayName) {
        this.minimumAmount = minimumAmount;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Badge getBadgeForAmount(int amount) {
        if (amount >= SANTA.minimumAmount) {
            return SANTA;
        }
        if (amount >= TREE.minimumAmount) {
            return TREE;
        }
        if (amount >= STAR.minimumAmount) {
            return STAR;
        }
        return null; // 또는 기본 뱃지를 반환할 수도 있습니다.
    }

}
