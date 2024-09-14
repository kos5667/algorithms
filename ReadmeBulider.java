import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadmeBulider {

    static final String GOLD = "\uD83E\uDD47";
    public static void main(String[] args) {
        String filePath = "./README.md";
        String questionPath = "./algorithm/BAEKJOON/Done/*";

        String test = "dddd";

        System.out.println(GOLD);

//        try {
//            Files.write(Paths.get(filePath), test.getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
