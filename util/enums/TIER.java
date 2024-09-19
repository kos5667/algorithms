package util.enums;

import java.util.Arrays;

public enum TIER {

    BRONZE(1, "Bronze"),
    SILVER(2, "Silver"),
    GOLD(3, "Gold"),
    PLATINUM(4, "Platinum"),
    DIAMOND(5, "Diamond");

    // Index
    private final int index;
    private final String name;

    TIER(int idx, String name) {
        this.index = idx;
        this.name = name;
    }

    public int getIndex() { return index; };
    public String getName() { return name; }

    public static TIER fromName(String name) {
        return Arrays.stream(TIER.values())
                .filter(tier -> name.contains(tier.getName()))
                .findFirst()
                .orElse(null); // 해당 name이 없을 때 null을 반환
    }

    public static boolean isName(String name) {
        return Arrays.stream(TIER.values())
                .anyMatch(tier -> name.contains(tier.getName()));
    }
}

enum LEVEL {

    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

    private final int level;

    LEVEL(int level) {
        this.level = level;
    }

    void getEmogi() {

    }
}
