package util.enums;

public enum TIER {

    BRONZE(1, "\uD83E\uDD47"),
    SILVER(2, "\uD83E\uDD47"),
    GOLD(3, "\uD83E\uDD47"),
    PLATINUM(4, "\uD83E\uDD47");

    // Index
    private final int index;
    // 이모지
    private final String emoji;

    TIER(int idx, String emoji) {
        this.index = idx;
        this.emoji = emoji;
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
