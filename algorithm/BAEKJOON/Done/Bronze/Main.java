package Done.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        main.run();
        Q1000.run();
        Q1152.run();
    }

    public static class main {
        public static void run () throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            double a = Integer.parseInt(st.nextToken());
            double b = Integer.parseInt(st.nextToken());

            System.out.println("Hello World!");
        }
    }

    public static class Q1000 {
        public static void run() {
            try (Scanner scan = new Scanner(System.in)) {
                int a = scan.nextInt();
                int b = scan.nextInt();

                System.out.println(a + b);
            }
        }
    }

    /**
     * 1152 | 단어의 개수
     * 시간 제한 2초 | 메모리 제한 128 MB | 브론즈2
     */
    public static class Q1152 {
        public static void run() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            System.out.println(st.countTokens());
        }
    }

    public static class Q1271 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            BigInteger n = new BigInteger(st.nextToken());
            BigInteger m = new BigInteger(st.nextToken());

            System.out.println(n.divide(m));
            System.out.println(n.remainder(m));
        }
    }

    public static class Q1330 {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println(A > B ? ">" : A < B ? "<" : "== ");
        }
    }
}
