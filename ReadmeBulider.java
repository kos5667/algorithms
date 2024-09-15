import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadmeBulider {

    static final String GOLD = "\uD83E\uDD47";

    static final String basePackage = "./algorithm/BAEKJOON/Done";
    public static void main(String[] args) throws IOException {
        String filePath = "./READMETEST.md";


        System.out.println(getSubPackages());
//        try {
//            Files.write(Paths.get(filePath), test.getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static List<String> getSubPackages() {
        List<String> subPackages = new ArrayList<>();
        File baseDir = new File(basePackage);

        if (baseDir.exists() && baseDir.isDirectory()) {
            File[] files = baseDir.listFiles(File::isDirectory);
            if (files != null) {
                for (File file : files) {
                    String subPackage = basePackage + '.' + file.getName();
                    subPackages.add(subPackage);
                }
            }
        }
        return subPackages;
    }
}
