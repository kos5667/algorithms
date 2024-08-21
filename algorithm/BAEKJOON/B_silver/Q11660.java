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

        int[][] s = new int[n][n];
        for (int i=0; i<n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                s[i][j] = Integer.parseInt(tokenizer.nextToken());
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
