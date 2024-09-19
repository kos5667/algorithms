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
        questionService = QuestionService.getInstance();
        readmeService = ReadmeService.getInstance();

        List<String> subPackages = questionService.getSubPackages(PLATFORM.BAEKJOON);
        StringBuilder content = new StringBuilder();
        for (String path : subPackages) {
            // Get Files
            File[] temp = questionService.getFiles(path, SORT.DESC.name());

            // 티어 목록(Bronze, Silver, Gold...)
            Optional<TIER> tier = Arrays.stream(TIER.values())
                    .filter(tierValue -> path.toUpperCase().contains(tierValue.name()))
                    .findFirst();

            // 각 티어별 Contents 도출.
            List<Question> questions = questionService.setQuestions(temp, tier.orElse(null));
            content.append(createContent(questions));
        }

        System.out.println(content);
//        write(read(content.toString()));
    }

    public static String createContent(List<Question> questions) {
        StringBuilder contents = new StringBuilder();
        for (Question question : questions) {
            contents.append("- ")
                    .append(question.getTier()).append(question.getQuestionLevel()).append(" ")
                    .append("[").append(question.getQuestionNo())
                    .append("(").append(question.getQuestionTitle()).append(")").append("]")
                    .append("(").append(question.getQuestionURL()).append(")")
                    .append(question.isComplete() ? ("`완료` " + question.getSince()) : "`진행중`")
                    .append(System.lineSeparator());
        }
        return contents.toString();
    }

    /**
     * README 내용 복사
     */
    public static String read(String content) {
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
        return stringBuilder.toString();
    }


}
