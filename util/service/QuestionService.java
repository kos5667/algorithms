package util.service;

import util.enums.ANNOTATION;
import util.enums.PLATFORM;
import util.enums.TIER;
import util.models.Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * README 수정을 위한 문제를 도출하는 Service
 */
public class QuestionService {

    private static QuestionService questionService;

    // Singleton Pattern 사용을 위한 constructor new Instance 제한.
    private QuestionService() { }

    public static QuestionService getInstance() {
        if (questionService == null) {
            return new QuestionService();
        }
        return questionService;
    }

    /**
     * 하위 패키지 경로.
     */
    public List<String> getSubPackages(PLATFORM name) {
        List<String> subPackages = new ArrayList<>();

        String basePackage = "./algorithm/";
        File baseDir = new File(basePackage + name.name());
        if (baseDir.exists() && baseDir.isDirectory()) {
            File[] files = baseDir.listFiles(File::isDirectory);
            if (files != null) {
                for (File file : files) {
                    String subPackage = basePackage + name.name() + '/' + file.getName();
                    subPackages.add(subPackage);
                }
            }
        }
        // TIER index 순으로 정렬.
        subPackages.sort(Comparator.comparingInt(o -> TIER.fromName(o).getIndex()));
        return subPackages;
    }

    /**
     * 하위 패키지 내 문제 파일 추출 및 정렬
     * @param path path
     * @param sort ASC: 오름차순, DESC: 내림차순, null: 정령 X
     */
    public File[] getFiles(String path, String sort) {
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

    /**
     * 파일내 주석 도출
     */
    public List<Question> setQuestions (File[] files, TIER tier) {
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
}
