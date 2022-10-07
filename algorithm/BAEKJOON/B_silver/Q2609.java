import java.util.*;

/**
 * 최대공약수와 최소공배수
 * 2609 : 실버Ⅴ
 */
public class Q2609 {
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