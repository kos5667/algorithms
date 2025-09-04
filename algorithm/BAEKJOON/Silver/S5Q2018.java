package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @questionNo 2018
 * @questionTitle 수들의 합
 * @questionLevel 5
 * @isComplete true
 * @since 2024-09-30
 * @desription
 * 어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서,
 * 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.
 * 예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.
 * N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.
 *
 * @example
 * 15 | 4
 */
public class S5Q2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cnt = 1;
        int sum = 1;
        int start = 1, end = 1;
        int index = 1;
        while (end != n) {
            if (sum == n) {
                cnt++;
                end++;
                sum += end;
            } else if (sum > n) {
                start++;
                sum -= start;
            } else {
                end++;
                sum += end;
            }

            System.out.println(index + " " + ((sum == n) ? "end++" : (sum > n) ? "start++":"el end++") + " | " + start + ", " + end + ", sum = " + sum + " : " + ((sum == n) ? "O" : "X"));
            /**
             * 1 + 2 = 3 (1 + 2)
             * 3 + 3 = 6 (1 + 2 + 3) cnt++
             * 6 + 4 = 10 (sum > n) --> sum(10) - start(2)
             * 10 - 2 = 8 (sum > n) --> sum(8) - start(3)
             * 8 - 3 = 5
             *
             */

            index++;

            /**
             * 1 2 : 3 (end++, sum = 2)
             * 1 2 3 : 6 > 5
             * 2 3 : 5 == 5
             * 2 + 3 + 4 : 6 > 5
             * 3 4 : 6
             */
        }
        System.out.println(cnt);
    }
}
