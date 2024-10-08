package util;

import util.enums.PLATFORM;
import util.enums.TIER;
import util.models.QuestionModel;
import util.service.QuestionService;
import util.service.ReadmeService;

import java.io.*;
import java.util.*;

/**
 * TODO: 문제풀이 TODO List
 * TODO: 다른 Platform 적용.
 */
public class ReadmeBulider {
    static QuestionService questionService = null;

    static ReadmeService readmeService = null;


    public static void main(String[] args) throws IOException {
        questionService = QuestionService.getInstance(PLATFORM.BAEKJOON);
        readmeService = ReadmeService.getInstance();

        // Create Content
        String content = createContent();

        // Input Content
        readmeService.inputContent(content, PLATFORM.BAEKJOON);
        // Update README
        readmeService.write(content);
    }

    public static String createContent() {
        Map<TIER, List<QuestionModel>> materials = questionService.getMaterials();

        StringBuilder contents = new StringBuilder();
        Arrays.stream(TIER.values()).forEach(tier -> {
            List<QuestionModel> questionModels = materials.get(tier);
            if (questionModels == null || questionModels.isEmpty()) return;

            readmeService.createContent(questionModels,
                    contents.append(System.lineSeparator())
                            .append("### ")
                            .append(tier.name())
                            .append("\n"));
        });
        return contents.toString();
    }
}
