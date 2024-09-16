package util.models;

import util.enums.ANNOTATION;

import java.util.Date;

public class Question {

    // 문제 번호
    private int questionNo;

    // 문제 제목
    private String questionTitle;

    // 문제 레벨
    private int questionLevel;

    // 완료 유무
    private boolean isComplete;

    // 일자
    private Date since;

//    public Question(int questionNo, String questionTitle, int questionLevel, boolean isComplete, Date since) {
//        this.questionNo = questionNo;
//        this.questionTitle = questionTitle;
//        this.questionLevel = questionLevel;
//        this.isComplete = isComplete;
//        this.since = since;
//    }

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
        this.questionTitle = questionTitle;
    }

    public int getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(int questionLevel) {
        this.questionLevel = questionLevel;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public String parseLine(String txt, String annotation) {
        return txt.substring(txt.indexOf(annotation) + annotation.length()).trim();
    }
}
