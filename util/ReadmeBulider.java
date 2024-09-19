package util;

import util.enums.ANNOTATION;
import util.enums.PLATFORM;
import util.enums.TIER;
import util.enums.SORT;
import util.models.Question;
import util.service.QuestionService;

import java.io.*;
import java.util.*;

/**
 *  TODO(1): 이모지 URL 티어 및 레밸 별로 enum 생성.
 *  TODO(2): 티어는 브론즈 (1~5) 내림차순.
 */
public class ReadmeBulider {
    static final String README_PATH = "./READMETEST.md";
    static final String basePackage = "./algorithm/";

    static QuestionService questionService = null;


    public static void main(String[] args) throws IOException {
        questionService = QuestionService.getInstance();
        List<String> subPackages = questionService.getSubPackages(PLATFORM.BAEKJOON);

//        StringBuilder content = new StringBuilder();
//        for (String path : subPackages) {
//            // Get Files
//            File[] temp = getFiles(path, SORT.DESC.name());
//
//            // 티어 목록(Bronze, Silver, Gold...)
//            Optional<TIER> tier = Arrays.stream(TIER.values())
//                    .filter(tierValue -> path.toUpperCase().contains(tierValue.name()))
//                    .findFirst();
//
//            // 각 티어별 Contents 도출.
//            List<Question> questions = setQuestions(temp, tier.orElse(null));
//            content.append(createContent(questions));
//        }
//
//        System.out.println(content);
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

    /**
     * README 작성
     */
    public static void write(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(README_PATH))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 파일내 주석 도출
     */
    public static List<Question> setQuestions (File[] files, TIER tier) {
        List<Question> list = new ArrayList<>();

        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                Question question = new Question(tier, file);

                String line;
                while ((line = reader.readLine()) != null) {
                    // 문제 번호
                    if (line.contains(ANNOTATION.QUESTION_NO.getAnnotation())) {
                        question.setQuestionNo(line);
                    }
                    // 문제 제목
                    if (line.contains(ANNOTATION.QUESTION_TITLE.getAnnotation())) {
                        question.setQuestionTitle(line);
                    }
                    // 문제 레벨
                    if (line.contains(ANNOTATION.QUESTION_LEVEL.getAnnotation())) {
                        question.setQuestionLevel(line);
                    }
                    // 완료 유무
                    if (line.contains(ANNOTATION.IS_COMPLETE.getAnnotation())) {
                        question.setComplete(line);
                    }
                    // 일자
                    if (line.contains(ANNOTATION.SINCE.getAnnotation())) {
                        question.setSince(line);
                        break;
                    }
                }
                list.add(question);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 하위 패키지 내 문제 파일 추출 및 정렬
     * @param path path
     * @param sort ASC: 오름차순, DESC: 내림차순, null: 정령 X
     */
    public static File[] getFiles(String path, String sort) {
        File file = new File(path);
        File[] files = file.listFiles(File::isFile);

        if (Objects.equals(sort, "ASC")) {
            Arrays.sort(files, (f1, f2) -> f1.getName().compareTo(f2.getName()));
        }
        if (Objects.equals(sort, "DESC")) {
            Arrays.sort(files, (f1, f2) -> f2.getName().compareTo(f1.getName()));
        }

        return files;
    }
}
