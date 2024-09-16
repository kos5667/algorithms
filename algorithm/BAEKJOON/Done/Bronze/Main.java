package Done.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초(10000만 연산 이하) | 메모리 제한 128 MB
 * 128 MB = 128000 KB, 0.5s = 500000 ms
 */
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

    public static class Q2338 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BigInteger a = new BigInteger(br.readLine());
            BigInteger b = new BigInteger(br.readLine());
            System.out.println(a.add(b));
            System.out.println(a.subtract(b));
            System.out.print(a.multiply(b));
        }
    }

    public static class Q2393 {
        public static void main(String[] args) throws Exception {
            System.out.println("  ___  ___  ___");
            System.out.println("  | |__| |__| |");
            System.out.println("  |           |");
            System.out.println("   \\_________/");
            System.out.println("    \\_______/");
            System.out.println("     |     |");
            System.out.println("     |     |");
            System.out.println("     |     |");
            System.out.println("     |     |");
            System.out.println("     |_____|");
            System.out.println("  __/       \\__");
            System.out.println(" /             \\");
            System.out.println("/_______________\\");
        }
    }

    public static class Q2420 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            System.out.println(Math.abs(A-B));
        }
    }

    public static class Q2438 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());

            for(int i=1; i<=A; i++) {
                System.out.println("*".repeat(i));
            }
        }
    }

    public static class Q2743 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            System.out.println(n.length());
        }
    }
}
