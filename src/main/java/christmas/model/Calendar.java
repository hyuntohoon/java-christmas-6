package christmas.model;

import java.util.Set;

public enum Calendar {
    ;
    private static final Set<Integer> weekendDays = Set.of(
            3, 10, 17, 24, 25, 31
    );

    private static final Set<Integer> specialEventDays = Set.of(
            2, 3, 9, 10, 16, 17, 23, 24, 30, 31
    );

}