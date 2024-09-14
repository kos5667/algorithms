package Done.B_silver;

import java.util.Scanner;

/**
 * 1934 최소공배수
 * 실버Ⅴ
 */
public class Q1934 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int t = scan.nextInt();
            for(int i=0; i<t; i++) {
                int a = scan.nextInt();
                int b = scan.nextInt();

                System.out.println((a * b) / GCD(a, b));
            }
        }
    }

    public static int GCD(int num1, int num2) {
        if(num1 % num2 == 0) {
            return num2;
        }
        return GCD(num2, num1 % num2);
    }
}
