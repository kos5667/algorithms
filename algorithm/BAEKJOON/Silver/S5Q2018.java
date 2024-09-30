package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @questionNo 2018
 * @questionTitle 수들의 합
 * @questionLevel 5
 * @isComplete false
 * @since 2024-09-30
 */
public class S5Q2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cnt = 1;
        int sum = 1;
        int start = 1, end = 1;
        while (end != n) {
            System.out.println(start + " " + end + " " + sum);
            if (sum == n) {
                cnt++;
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        System.out.println(cnt);
    }
}
