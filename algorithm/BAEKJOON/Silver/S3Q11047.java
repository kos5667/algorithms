package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @questionNo 11047
 * @questionTitle 동전 개수의 최솟값 구하기
 * @questionLevel 3
 * @isComplete true
 * @since 2026-05-24
 * @desription
 10 4200
 1
 5
 10
 50
 100
 500
 1000
 5000
 10000
 50000
 */
public class S3Q11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = N-1; i >= 0; i--) {
            if (K / A[i] > 0) {
                cnt += K / A[i];
                K %= A[i];
            }
        }

        System.out.println(cnt);
    }
}
