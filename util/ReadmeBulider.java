package util;

import util.enums.ANNOTATION;
import util.enums.TIER;
import util.enums.SORT;
import util.models.Question;

import java.io.*;
import java.util.*;

/**
 * Annotation을 이용한 README 자동 입력.
 * '|' 구분자를 이용히여 문제의 No, 제목, 레밸을 도출한다.
 * Annotation 목록: {
 *  '@question':
 *  '@since'
 *  }
 *  TODO(1): 이모지 URL 티어 및 레밸 별로 enum 생성.
 *  TODO(2): 티어는 브론즈 (1~5) 내림차순.
 */
public class ReadmeBulider {
    static final String BAEKJOON_URL = "https://www.acmicpc.net/problem/1546";
    static final String filePath = "./READMETEST.md";
    static final String basePackage = "./algorithm/BAEKJOON/Doing";


    public static void main(String[] args) throws IOException {
        // TODO: Bronze, Silver, Gold... 티어 순서 정렬.
        List<String> subPackages = getSubPackages();

        for (String path : subPackages) {
            File[] temp = getFiles(path, SORT.DESC.name());

            Optional<TIER> tier = Arrays.stream(TIER.values())
                    .filter(tierValue -> path.toUpperCase().contains(tierValue.name()))
                    .findFirst();

            List<Question> questions = setQuestions(temp, tier.orElse(null));

            write(questions);
        }
    }

    /**
     * README 작성.
     */
    public static void write(List<Question> questions) {
        for (Question question : questions) {
            StringBuilder stringBuilder = new StringBuilder();
        }
    }

    /**
     * 파일내 주석 도출
     */
    public static List<Question> setQuestions (File[] files, TIER tier) {
        List<Question> list = new ArrayList<>();

        for (File inputFilePath : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                Question question = new Question(tier);

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

    public static void writeReadme (File[] files) {
        String questionKeyword = "@question";
        String sinceKeyword = "@since";

        for (File inputFilePath : files) {

        }
    }

    /**
     * 하위 패키지 경로.
     */
    public static List<String> getSubPackages() {
        List<String> subPackages = new ArrayList<>();
        File baseDir = new File(basePackage);

        if (baseDir.exists() && baseDir.isDirectory()) {
            File[] files = baseDir.listFiles(File::isDirectory);
            if (files != null) {
                for (File file : files) {
                    String subPackage = basePackage + '/' + file.getName();
                    subPackages.add(subPackage);
                }
            }
        }

        return subPackages;
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
