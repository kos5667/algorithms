package Done.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        main.main();
        Q1000.main();
    }

    public static class main {
        public static void main () throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            double a = Integer.parseInt(st.nextToken());
            double b = Integer.parseInt(st.nextToken());

            System.out.println("Hello World!");
        }
    }

    public static class Q1000 {
        public static void main() {
            try (Scanner scan = new Scanner(System.in)) {
                int a = scan.nextInt();
                int b = scan.nextInt();

                System.out.println(a + b);
            }
        }
    }
}
