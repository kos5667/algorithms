package util.models;

import util.enums.ANNOTATION;
import util.enums.TIER;

public class Question {

    private TIER tier;
    // 문제 번호
    private int questionNo;

    // 문제 제목
    private String questionTitle;

    // 문제 레벨
    private int questionLevel;

    // 완료 유무
    private boolean isComplete;

    // 일자
    private String since;

    public Question(TIER tier) {
        this.tier = tier;
    }

    public TIER getTier() {
        return tier;
    }

    public void setTier(TIER tier) {
        this.tier = tier;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = Integer.parseInt(parseLine(questionNo, ANNOTATION.QUESTION_NO.getAnnotation()));
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = parseLine(questionTitle, ANNOTATION.QUESTION_TITLE.getAnnotation());
    }

    public int getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(String questionLevel) {
        this.questionLevel = Integer.parseInt(parseLine(questionLevel, ANNOTATION.QUESTION_LEVEL.getAnnotation()));
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(String complete) {
        isComplete = Boolean.parseBoolean(parseLine(complete, ANNOTATION.IS_COMPLETE.getAnnotation()));
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = parseLine(since, ANNOTATION.SINCE.getAnnotation());
    }

    public String parseLine(String txt, String annotation) {
        return txt.substring(txt.indexOf(annotation) + annotation.length()).trim();
    }
}
