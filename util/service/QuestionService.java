package util.service;

import util.enums.ANNOTATION;
import util.enums.PLATFORM;
import util.enums.SORT;
import util.enums.TIER;
import util.models.QuestionModel;

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
    private static PLATFORM platform;

    // Singleton Pattern 사용을 위한 constructor new Instance 제한.
    private QuestionService() { }

    public static QuestionService getInstance(PLATFORM instanceBy) {
        platform = instanceBy;

        if (questionService == null) {
            return new QuestionService();
        }
        return questionService;
    }

    /**
     * 하위 패키지 경로.
     */
    public List<String> getSubPackages() {
        List<String> subPackages = new ArrayList<>();

        String basePackage = "./algorithm/";
        File baseDir = new File(basePackage + platform.name());
        if (baseDir.exists() && baseDir.isDirectory()) {
            File[] files = baseDir.listFiles(File::isDirectory);
            if (files != null) {
                for (File file : files) {
                    String subPackage = basePackage + platform.name() + '/' + file.getName();
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
    public File[] getFile(String path, String sort) {
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
     * 추출한 파일 분리
     */
    public Map<TIER, File[]> getFiles () {
        Map<TIER, File[]> result = new HashMap<>();
        List<String> subPackages = this.getSubPackages();
        for (String path : subPackages) {
            // 티어 목록(Bronze, Silver, Gold...)
            Optional<TIER> tier = Arrays.stream(TIER.values())
                    .filter(tierValue -> path.toUpperCase().contains(tierValue.name()))
                    .findFirst();

            result.put(tier.orElse(null), this.getFile(path, SORT.DESC.name()));
        }
        return result;
    }

    /**
     * 파일내 주석 입력
     */
    public List<QuestionModel> setQuestions (TIER tier, File[] files) {
        List<QuestionModel> list = new ArrayList<>();

        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                QuestionModel questionModel = new QuestionModel(tier, file);

                String line;
                while ((line = reader.readLine()) != null) {
                    // 문제 번호
                    if (line.contains(ANNOTATION.QUESTION_NO.getAnnotation())) {
                        questionModel.setQuestionNo(line);
                    }
                    // 문제 제목
                    if (line.contains(ANNOTATION.QUESTION_TITLE.getAnnotation())) {
                        questionModel.setQuestionTitle(line);
                    }
                    // 문제 레벨
                    if (line.contains(ANNOTATION.QUESTION_LEVEL.getAnnotation())) {
                        questionModel.setQuestionLevel(line);
                    }
                    // 완료 유무
                    if (line.contains(ANNOTATION.IS_COMPLETE.getAnnotation())) {
                        questionModel.setComplete(line);
                    }
                    // 일자
                    if (line.contains(ANNOTATION.SINCE.getAnnotation())) {
                        questionModel.setSince(line);
                        break;
                    }
                }
                list.add(questionModel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sortQuestionsOrderBySince(list);
        return list;
    }

    /**
     * 일자순으로 정렬.
     */
    private void sortQuestionsOrderBySince(List<QuestionModel> list) {
        // 일자순으로 정렬
        list.sort(Comparator.comparing(QuestionModel::getSince,
                Comparator.nullsFirst(Comparator.naturalOrder())));

        // 레벨순으로 정렬
        list.sort(Comparator.comparing(QuestionModel::getQuestionLevel).reversed());
    }

    public Map<TIER, List<QuestionModel>> getMaterials() {
        Map<TIER, File[]> files = this.getFiles();

        Map<TIER, List<QuestionModel>> materials = new HashMap<>();
        files.forEach((tier, o) -> materials.put(tier, this.setQuestions(tier, o)));
        return materials;
    }
}
