package util.service;

import util.enums.PLATFORM;
import util.models.QuestionModel;

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
    public void createContent(List<QuestionModel> questionModels, StringBuilder contents) {
        for (QuestionModel questionModel : questionModels) {
            contents.append("- ")
                    .append(questionModel.getEmoji()).append(" ")
                    .append(questionModel.getTitleWithURL()).append(" ")
                    .append(questionModel.getCompleteCode())
                    .append(System.lineSeparator());
        }
    }

    /**
     * README 내용 복사
     */
    public String inputContent(String contents, PLATFORM platform) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(README_PATH))){
            String line; boolean skip = false;
            while ((line = reader.readLine()) != null) {
                if (!skip) {
                    builder.append(line).append(System.lineSeparator());
                }
                if (line.contains(platform.start())) {
                    builder.append(contents);
                    skip = true;
                }
                if (line.contains(platform.end())) {
                    builder.append(System.lineSeparator())
                            .append(line)
                            .append(System.lineSeparator());
                    skip = false;
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

    public void setStyle(StringBuilder builder) {
        String style = "img {"
                + "width: 19px;"
                + "height: 19px;"
                + "margin-top: 4px;"
                + "vertical-align: top;"
                + "}";
        builder.append(style);
    }
}
