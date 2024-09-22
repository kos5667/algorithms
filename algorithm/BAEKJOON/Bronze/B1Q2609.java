package Bronze;

import java.util.*;

/**
 * @questionNo 2609
 * @questionTitle 최대공약수와 최소공배수
 * @questionLevel 1
 * @isComplete true
 * @since 2022-03-14
 */
public class B1Q2609 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();

            int gcd = GCD(num1, num2);
            System.out.println(gcd);
            System.out.println((num1 * num2) / gcd);
        }
    }

    public static int GCD(int num1, int num2) {
        if(num1 % num2 == 0) {
            return num2;
        }
        return GCD(num2, num1 % num2);
    }
}
