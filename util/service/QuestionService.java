package util.service;

import util.enums.PLATFORM;
import util.enums.TIER;

import java.io.File;
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
                    System.out.println(file);
                    String subPackage = basePackage + name.name() + '/' + file.getName();
                    subPackages.add(subPackage);
                }
            }
        }
        // TIER index 순으로 정렬.
        subPackages.sort(Comparator.comparingInt(o -> TIER.fromName(o).getIndex()));
        return subPackages;
    }
}
