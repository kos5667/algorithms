package util.service;

import util.enums.PLATFORM;
import util.models.Question;

import java.io.*;
import java.util.List;

/**
 * README를 직접적으로 수정하는 Service
 */
public class ReadmeService {

    private final String README_PATH = "./READMETEST.md";
    private static ReadmeService readmeService;
    private static QuestionService questionService;

    private ReadmeService() { }

    public static ReadmeService getInstance() {
        if (readmeService == null) {
            return new ReadmeService();
        }
        return readmeService;
    }

    /**
     * 내용 입력.
     */
    public StringBuilder createContent(List<Question> questions, StringBuilder contents) {
        for (Question question : questions) {
            contents.append("- ")
                    .append(question.getTier()).append(question.getQuestionLevel()).append(" ")
                    .append("[").append(question.getQuestionNo())
                    .append("(").append(question.getQuestionTitle()).append(")").append("]")
                    .append("(").append(question.getQuestionURL()).append(")")
                    .append(question.isComplete() ? ("`완료` " + question.getSince()) : "`진행중`")
                    .append(System.lineSeparator());
        }
        return contents;
    }

    private String setTitle(int n, String title) {
        return "#".repeat(n) + title;
    }

    /**
     * README 내용 복사
     */
    public StringBuilder read() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(README_PATH))){
            String line;
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                if (line.contains(PLATFORM.BAEKJOON.start())) {
                    System.out.println(line);

                }

                if (line.contains(PLATFORM.BAEKJOON.end())) {

                }

                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }

    /**
     * README 작성
     */
    public void write(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(README_PATH))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
