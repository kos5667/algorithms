import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 11660 | 구간 합 구하기 2
 * 시간 제한 1초(1억 연산 이하) | 메모리 제한 128 MB | 실버1
 * 128 MB = 128,000 KB, 1s = 1,000,000 ms
 */
public class Q11660 {

    /**
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        /**
         * [1,1] [1,2] [1,3] [1,4]  설명)
         * [2,1] [2,2] [2,3] [2,4]  1. i == 0 && j == 0 1행 구하고 j > 0 이후로 1행 합 배열 구하기
         * [3,1] [3,2] [3,3] [3,4]  2-1. i > 0 && j == 0 1열 구하기
         * [4,1] [4,2] [4,3] [4,4]  2-2. ex) [3,2] == [3,1] + [2,2] + num - [2,1]
         */
        int[][] s = new int[n][n];
        for (int i=0; i<n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int num = Integer.parseInt(tokenizer.nextToken());
                if (i == 0) {
                    s[i][j] = (j == 0) ? num : s[i][j-1] + num;
                } else {
                    s[i][j] = (j == 0) ? s[i-1][j] + num : s[i][j-1] + s[i-1][j] + num - s[i-1][j-1];
                }
            }
        }






        // print
        for (int[] i : s) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
