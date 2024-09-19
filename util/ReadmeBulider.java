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
        Map<TIER, File[]> files = questionService.getFiles();

        Map<TIER, List<Question>> content = new HashMap<>();
        files.forEach((tier, o) -> content.put(tier, questionService.setQuestions(tier, o)));


//        String contents = readmeService.createContent(questions);
    }
}
