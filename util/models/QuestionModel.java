package util.models;

import util.enums.ANNOTATION;
import util.enums.RANK;
import util.enums.TIER;

import java.io.File;

public class QuestionModel {

    private final File file;

    private final TIER tier;

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

    public QuestionModel(TIER tier, File file) {
        this.tier = tier;
        this.file = file;
    }

    public TIER getTier() {
        return tier;
    }

    public File getFile() {
        return file;
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

    public String getQuestionURL() {
        if (this.questionNo == 0) {
            return "#";
        }
        return "https://www.acmicpc.net/problem/" + this.questionNo;
    }

    public String parseLine(String txt, String annotation) {
        return txt.substring(txt.indexOf(annotation) + annotation.length()).trim();
    }

    public String getEmoji() {
        System.out.println(getImageOfTier());
        String alt = tier.name() + questionLevel;
        String img = getImageOfTier().getCode();
        return "<img src=\"https://static.solved.ac/tier_small/" + img + ".svg\" alt=\"" + alt + "\">";
    }

    private RANK getImageOfTier() {
        return tier.getRank(questionLevel);
    }
}
