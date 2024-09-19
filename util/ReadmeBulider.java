package util;

import util.enums.PLATFORM;
import util.enums.TIER;
import util.models.Question;
import util.service.QuestionService;
import util.service.ReadmeService;

import java.io.*;
import java.util.*;

/**
 *
 */
public class ReadmeBulider {
    static QuestionService questionService = null;

    static ReadmeService readmeService = null;


    public static void main(String[] args) throws IOException {
        questionService = QuestionService.getInstance(PLATFORM.BAEKJOON);
        readmeService = ReadmeService.getInstance();

        String content = "";
        content = createContent();
        content = inputContent(content);
        readmeService.write(content);
    }

    public static String createContent() {
        Map<TIER, List<Question>> materials = questionService.getMaterials();

        StringBuilder contents = new StringBuilder();
        Arrays.stream(TIER.values()).forEach(tier -> {
            List<Question> questions = materials.get(tier);
            if (questions.isEmpty()) return;

            readmeService.createContent(questions,
                    contents.append(System.lineSeparator())
                            .append("### ")
                            .append(tier.name())
                            .append("\n"));
        });
        return contents.toString();
    }

    public static String inputContent(String content) {
        return readmeService.inputContent(content, PLATFORM.BAEKJOON);
    }
}
