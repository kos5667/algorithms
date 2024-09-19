package util;

import util.enums.ANNOTATION;
import util.enums.PLATFORM;
import util.enums.TIER;
import util.enums.SORT;
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

        read();
        // 각 티어별 Contents 도출.
//        List<Question> questions = questionService.setQuestions(temp, tier.orElse(null));
//        content.append(readmeService.createContent(questions));

//        write(read(content.toString()));
    }

    public static void read() {
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

        System.out.println("=============");
        System.out.println(contents.toString());
    }
}
