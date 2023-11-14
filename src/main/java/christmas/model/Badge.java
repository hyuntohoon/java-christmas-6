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

}
