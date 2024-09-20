package util.enums;

import util.enums.interfaces.RankOperator;

import java.util.Arrays;

public enum TIER implements RankOperator {

    BRONZE(1, "Bronze"),
    SILVER(2, "Silver"),
    GOLD(3, "Gold"),
    PLATINUM(4, "Platinum"),
    DIAMOND(5, "Diamond");

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

    @Override
    public RANK getRank(int level) {
        if (level == 0) {
            return RANK.UNRATED;
        }
        return RANK.valueOf(this.name() + level);
    }
}
