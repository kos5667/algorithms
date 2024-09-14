package Doing.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2024-09-14
 * 10986 | 나머지 합
 * 시간 제한 1초(1억 연산 이하) | 메모리 제한 256 MB | 골드3
 * 128 MB = 128,000 KB, 1s = 1,000,000 ms
 */
public class G3_Q10986 {

    /**
     * 직접 구현
     */
    public static void main(String[] args) {

    }

    public static void print (long[][] s) {
        for (long[] i : s) {
            for (long j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
