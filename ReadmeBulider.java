import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadmeBulider {
    static final String filePath = "./READMETEST.md";
    static final String basePackage = "./algorithm/BAEKJOON/Done";

    static final String BRONZE = "\uD83E\uDD47";
    static final String SILVER = "\uD83E\uDD47";
    static final String GOLD = "\uD83E\uDD47";


    public static void main(String[] args) throws IOException {
        List<String> subPackages = getSubPackages();

        System.out.println(subPackages);

        for (String path : subPackages) {
            getFiles(path);
        }

//        try {
//            Files.write(Paths.get(filePath), test.getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static List<String> getFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles(File::isFile);

        String questionKeyword = "@question", sinceKeyword = "@since";

        for (File inputFilePath : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                 FileWriter writer = new FileWriter(filePath)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(questionKeyword)) {
                        System.out.println(line);
//                        writer.write(line.trim() + System.lineSeparator());
                    }
                    if (line.contains(sinceKeyword)) {
                        System.out.println(line);
                        continue;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


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
}
