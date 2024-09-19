package util.enums;

import java.util.Objects;

public enum PLATFORM {
    BAEKJOON,
    PROGRAMMERS,
    ALGORITHM;

    public String getName() {
        return "$" + this + "$";
    }

    // START 지점
    public String start () {
        return getName() + "START";
    }
    // END 지점
    public String end () {
        return getName() + "END";
    }

    public boolean isTitle(String title) {
        String sharp = "#";
        for (int i=0; i<=6; i++) {
            if (Objects.equals(title, sharp.repeat(i) + title)) {
                return true;
            }
        }
        return false;
    }
}
