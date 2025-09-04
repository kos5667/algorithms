package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @questionNo 2559
 * @questionTitle 수열
 * @questionLevel 3
 * @isComplete false
 * @since 2025-04-16
 */
public class S3Q2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // N은 2 이상 100,000 이하
        int k = Integer.parseInt(st.nextToken()); // K는 1과 N 사이의 정수

        st = new StringTokenizer(br.readLine());
        long[] org = new long[n];
        int max = 0;
        int idx = 0;
        for (int i=0; i<n; i++) { // 100,000번
            org[i] = Integer.parseInt(st.nextToken());

            if (i != 0 && max < (org[i-1] + org[i])) {
                max = (int) (org[i-1] + org[i]);
                idx = i;
            }
        }

        int answer = 0;
        for (int i=0; i<k; i++) {
            answer += (int) org[idx--];
        }
        System.out.println(answer);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken()); // 전체 날짜 수
//        int k = Integer.parseInt(st.nextToken()); // 연속 날짜 수
//
//        st = new StringTokenizer(br.readLine());
//        int[] temps = new int[n];
//        for (int i = 0; i < n; i++) {
//            temps[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int sum = 0;
//        // 첫 K개 합 구하기
//        for (int i = 0; i < k; i++) {
//            sum += temps[i];
//        }
//
//        int max = sum;
//
//        // 슬라이딩 윈도우
//        for (int i = k; i < n; i++) {
//            sum = sum - temps[i - k] + temps[i];
//            if (sum > max) max = sum;
//        }
//
//        System.out.println(max);
//    }
}
