package util.enums;

public enum PLATFORM {
    BAEKJOON,
    PROGRAMMERS,
    ALGORITHM;

    public String getName() {
        return "$" + this + "$";
    }

    public String start () {
        return getName() + "START";
    }

    public String end () {
        return getName() + "END";
    }
}
