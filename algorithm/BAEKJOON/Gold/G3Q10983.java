package Gold;

import java.io.IOException;
import java.util.Scanner;

/**
 * @questionNo 123
 * @questionTitle TEST
 * @questionLevel 4
 * @isComplete true
 * @since 2024-10-25
 */
public class G3Q10983 {

    /** 1 5 3 2 5
     * 직접 구현
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] s = new long[n];
        for (int i=0; i<n; i++) {
            s[i] = i == 0 ? sc.nextInt() : s[i-1] + sc.nextInt();
        }

        int[] c = new int[m];
        for (long i : s) {
            c[(int) (i % m)]++;
        }

        long answer = c[0];
        for (int i=0; i<m; i++) {
            answer += c[i] * (c[i] - 1) / 2;
        }
        System.out.println(answer);
    }

    /**
     * 교제
     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        long[] s = new long[n];
//        long[] c = new long[m];
//        long answer = 0;
//        s[0] = sc.nextInt();
//        for (int i=1; i<n; i++) {
//            s[i] = s[i-1] + sc.nextInt();
//        }
//
//        for (int i=0; i<n; i++) {
//            int remainder = (int) (s[i] % m);
//            // 0 ~ i 까지의 구간 합 자체가 0일 때 정답에 더하기
//            if (remainder == 0) answer++;
//            // 나머지가 같은 인덱스의 개수 카운팅
//            c[remainder]++;
//        }
//
//        for (long i : c) {
//            System.out.print(i + " ");
//        }
//
//        for (int i=0; i<m; i++) {
//            if (c[i] > 1) {
//                answer = answer + (c[i] * (c[i] -1) / 2);
//            }
//        }
//        System.out.println(answer);
//    }
}
