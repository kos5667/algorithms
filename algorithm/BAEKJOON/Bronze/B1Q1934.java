package Bronze;

import java.util.Scanner;

/**
 * @questionNo 1934
 * @questionTitle 최소공배수
 * @questionLevel 1
 * @isComplete true
 * @since 2022-03-16
 */
public class B1Q1934 {
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
