package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @questionNo 10986
 * @questionTitle 나머지 합
 * @questionLevel 3
 * @isComplete true
 * @since 2024-09-23
 * @example
 *  - 5 3 | 1 2 3 1 2
 *  - 8 3 | 1 2 4 5 6 3 9 4
 */
public class G3Q10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n+1];
        for (int i=1; i<=n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = i == 1 ? num : arr[i-1] + num;
        }

        int answer = 0;
        long[] sum = new long[m];
        for (int i=1; i<=n; i++) {
            int num = (int) (arr[i]%m);
            if (num == 0) answer++;
            sum[num]++;
        }

        for (int i=0; i<m; i++) {
            answer += (int) (sum[i] * (sum[i] - 1) / 2);
        }
        System.out.println(answer);
    }

//    /**
//     * 시간초과....
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        long[] arr = new long[n];
//        for (int i=0; i<n; i++) {
//            arr[i] = i == 0 ? sc.nextInt() : arr[i-1] + sc.nextInt();
//        }
//
//        int answer = 0;
//        long [] con = new long[n];
//        for (int i=0; i<arr.length; i++) {
//            long num = arr[i] % m;
//            if (num == 0) answer++;
//            con[i] = arr[i] % m;
//        }
//
//        long[] param = Arrays.stream(con).distinct().toArray();
//        for (int i=0; i<param.length; i++) {
//            long num = param[i];
//            int count = (int) Arrays.stream(con).filter(j -> (long) j == num).count();
//            answer += count * (count - 1) / 2;
//        }
//        System.out.println(answer);
//    }

    /** 1 5 3 2 5
     * 직접 구현
     */
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        long[] s = new long[n];
//        for (int i=0; i<n; i++) {
//            s[i] = i == 0 ? sc.nextInt() : s[i-1] + sc.nextInt();
//        }
//
//        int[] c = new int[m];
//        for (long i : s) {
//            c[(int) (i % m)]++;
//        }
//
//        long answer = c[0];
//        for (int i=0; i<m; i++) {
//            answer += c[i] * (c[i] - 1) / 2;
//        }
//        System.out.println(answer);
//    }

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
