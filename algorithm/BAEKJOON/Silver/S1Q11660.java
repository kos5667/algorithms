package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @questionNo 11660
 * @questionTitle 구간 합 구하기 2
 * @questionLevel 1
 * @isComplete true
 * @since 2024-09-14
 */
public class S1Q11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] arr = new long[n+1][n+1];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    arr[i+1][j+1] = j == 0 ? num : arr[i+1][j] + num;
                } else {
                    arr[i+1][j+1] = j == 0 ? arr[i][j+1] + num : arr[i][j+1] + arr[i+1][j] - arr[i][j] + num;
                }
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1]);
        }
    }


    /**
     * 직접 구현
     * 메모리: 128928 KB, 시간: 1308 ms, 코듴 길이: 1320 B
     */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        /**
//         * [1,1] [1,2] [1,3] [1,4]  설명
//         * [2,1] [2,2] [2,3] [2,4]  1. i == 0 && j == 0 1행 구하고 j > 0 이후로 1행 합 배열 구하기
//         * [3,1] [3,2] [3,3] [3,4]  2-1. i > 0 && j == 0 1열 구하기
//         * [4,1] [4,2] [4,3] [4,4]  2-2. ex) [3,2] == [3,1] + [2,2] + num - [2,1]
//         */
//        long[][] s = new long[n+1][n+1];
//        for (int i=0; i<n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j=0; j<n; j++) {
//                int num = Integer.parseInt(st.nextToken());
//                if (i == 0) {
//                    s[i+1][j+1] = num + s[i+1][j];
//                } else {
//                    s[i+1][j+1] = (j == 0) ? num + s[i][j+1] : num + s[i+1][j] + s[i][j+1] - s[i][j];
//                }
//            }
//        }
//
//        for (int i=0; i<m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
//            int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
//            System.out.println(s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[x1-1][y1-1]);
//        }
//
//        print(s);
//    }

    /**
     * 교제
     * 메모리: 129032 KB, 시간: 1284 ms, 코드 길이: 1320 B
     */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        int[][] A = new int[n+1][n+1];
//        for (int i=1; i<=n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for(int j=1; j<=n; j++) {
//                A[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int[][] D = new int[n+1][n+1];
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=n; j++) {
//                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
//
//            }
//        }
//
//        for (int i=0; i<m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x1 = Integer.parseInt(st.nextToken());
//            int y1 = Integer.parseInt(st.nextToken());
//            int x2 = Integer.parseInt(st.nextToken());
//            int y2 = Integer.parseInt(st.nextToken());
//            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
//            System.out.println(result);
//        }
//    }

    public static void print (long[][] s) {
        /**1
         * TODO: 합배열 완성으로 구간 합 구하기.
         * 0 0 0 0 0
         * 0 1 3 6 10
         * 0 3 8 15 24
         * 0 6 15 27 42
         * 0 10 24 42 64
         */

        for (long[] i : s) {
            for (long j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
