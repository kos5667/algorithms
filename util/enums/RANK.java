package util.enums;

public enum RANK {
    BRONZE1(1,"5"),
    BRONZE2(2,"4"),
    BRONZE3(3,"3"),
    BRONZE4(4,"2"),
    BRONZE5(5,"1"),

    SILVER1(1,"10"),
    SILVER2(2,"9"),
    SILVER3(3,"8"),
    SILVER4(4,"7"),
    SILVER5(5,"6"),

    GOLD1(1,"15"),
    GOLD2(2,"14"),
    GOLD3(3,"13"),
    GOLD4(4,"12"),
    GOLD5(5,"11"),

    PLATINUM1(1,"20"),
    PLATINUM2(2,"19"),
    PLATINUM3(3,"18"),
    PLATINUM4(4,"17"),
    PLATINUM5(5,"16"),

    DIAMOND1(1,"25"),
    DIAMOND2(2,"24"),
    DIAMOND3(3,"23"),
    DIAMOND4(4,"22"),
    DIAMOND5(5,"21"),

    RUBY1(1,"30"),
    RUBY2(2,"29"),
    RUBY3(3,"28"),
    RUBY4(4,"27"),
    RUBY5(5,"26"),

    UNRATED(0,"0");


    private final int level;
    private final String code;

    RANK(int level, String code) {
        this.level = level;
        this.code = code;
    }

    public int getLevel() {
        return level;
    }

    public String getCode() {
        return code;
    }
}
