package util.enums;

public enum ANNOTATION {
    QUESTION_NO("@questionNo"),
    QUESTION_TITLE("@questionTitle"),
    QUESTION_LEVEL("@questionLevel"),
    IS_COMPLETE("@isComplete"),
    SINCE("@since");

    ANNOTATION(String annotation) {
        this.annotation = annotation;
    }

    private final String annotation;

    public String getAnnotation() {
        return this.annotation;
    }
}
