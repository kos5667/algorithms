package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @questionNo 2023
 * @questionTitle 신기한 소수 찾기
 * @questionLevel 5
 * @isComplete true
 * @since 2026-05-26
 */
public class G5Q2023 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 2, 3, 5, 7
        // 4자리 소수 구하기.
        // 자릿수를 하나씩 붙여가며 소수 검증.

        DFS(2 ,1);
        DFS(3 ,1);
        DFS(5 ,1);
        DFS(7 ,1);
    }

    static void DFS(int num, int digit) throws IOException {
        if (digit == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }

            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, digit + 1);
            }
        }
    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
