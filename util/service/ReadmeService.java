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
    public void createContent(List<Question> questions, StringBuilder contents) {
        for (Question question : questions) {
            contents.append("- ")
                    .append(question.getTier()).append(question.getQuestionLevel()).append(" ")
                    .append("[").append(question.getQuestionNo())
                    .append("(").append(question.getQuestionTitle()).append(")").append("]")
                    .append("(").append(question.getQuestionURL()).append(")")
                    .append(question.isComplete() ? ("`완료` " + question.getSince()) : "`진행중`")
                    .append(System.lineSeparator());
        }
    }

    /**
     * README 내용 복사
     */
    public String inputContent(String contents, PLATFORM platform) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(README_PATH))){
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
                if (line.contains(platform.start())) {
                    builder.append(contents);
                }
                if (line.contains(platform.end())) {
                    builder.append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
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
