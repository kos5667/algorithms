package Platinum;

import java.util.Scanner;

/**
 * 1789
 * 수들의 합
 * 실버Ⅴ
 */
public class Q1789_TEST {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            long s = scan.nextLong();
            long m = 0;
            int n = 0;
            while(true) {
                if(s < m) break;
                else {
                    n++;
                    m += n;
                }
            }
            System.out.println(n-1);
        }
    }
}
