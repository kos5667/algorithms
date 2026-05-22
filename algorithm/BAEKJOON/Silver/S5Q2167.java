package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @questionNo 2167
 * @questionTitle 2차원 배열의 합
 * @questionLevel 5
 * @isComplete false
 * @since 2025-09-23
 * @desription
 * 2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.
 *
 * 첫째 줄에 배열의 크기 N, M(1 ≤ N, M ≤ 300)이 주어진다. 다음 N개의 줄에는 M개의 정수로 배열이 주어진다. 배열에 포함되어 있는 수는 절댓값이 10,000보다 작거나 같은 정수이다.
 * 그 다음 줄에는 합을 구할 부분의 개수 K(1 ≤ K ≤ 10,000)가 주어진다. 다음 K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(1 ≤ i ≤ x ≤ N, 1 ≤ j ≤ y ≤ M).
 *
 * 예제 입력
 * 2 3
 * 1 2 4    | [[1], [3], [7]]
 * 8 16 32  | [[9], [11], [50]]
 * 3
 * 1 1 2 3
 * 1 2 1 2
 * 1 3 2 3
 *
 * 예제 출력
 * 63
 * 2
 * 36
 */
public class S5Q2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
        int N = 2;
        int M = 3;

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");


//            for (int j = (i * M); j < (i+1) * M; j++) {
//                int num = Integer.parseInt(temp[j - (i * M)]);
//                arr[j] = j == 0 ? num : arr[j-1] + num;
//            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

//        int K = Integer.parseInt(st.nextToken());
//        for (int i = 0; i < K; i++) {
//            st = new StringTokenizer(br.readLine());
//
//        }
    }
}
