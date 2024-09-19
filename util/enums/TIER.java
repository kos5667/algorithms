package util.enums;

public enum TIER {

    BRONZE(1),
    SILVER(2),
    GOLD(3),
    PLATINUM(4);

    // Index
    private final int index;

    TIER(int idx) {
        this.index = idx;
    }

    int getIndex () { return index; };

    /**
     *
     * @param level {1,2,3,4,5}
     * @param size 1: Large, 2: Small
     */
    public String getEmoji(int level, int size) {
        return "<img src=\"https://static.solved.ac/tier_small/4.svg\" alt=\"4\">";
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
