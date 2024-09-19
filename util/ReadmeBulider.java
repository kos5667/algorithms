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

        List<String> subPackages = questionService.getSubPackages();
        StringBuilder content = new StringBuilder();
//        for (String path : subPackages) {
//            // Get Files
//            File[] temp = questionService.getFiles(path, SORT.DESC.name());
//
//            // 티어 목록(Bronze, Silver, Gold...)
//            Optional<TIER> tier = Arrays.stream(TIER.values())
//                    .filter(tierValue -> path.toUpperCase().contains(tierValue.name()))
//                    .findFirst();
//
//            // 각 티어별 Contents 도출.
//            List<Question> questions = questionService.setQuestions(temp, tier.orElse(null));
//            content.append(readmeService.createContent(questions));
//        }

        System.out.println(content);
//        write(read(content.toString()));
    }
}
