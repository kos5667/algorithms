import java.util.*;

/**
 * 1978
 * 소수 찾기
 * 실버Ⅳ
 */
public class Q1978 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int r = 0;
            for(int i=0; i<n; i++) {
                int a = scan.nextInt();
                int b = 0;
                for(int j=1; j<=a; j++) {
                    if(a%j == 0) b++;
                }
                if(b == 2) r++;
            }
            System.out.println(r);
        }
    }

    public static boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i=2; i*i<num; i++) {
            if(num % i ==0) return false;
        }
        return true;
    }
}
