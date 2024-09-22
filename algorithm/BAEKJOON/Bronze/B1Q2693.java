package Bronze;

import java.util.*;

/**
 * @questionNo 2693
 * @questionTitle N번째 큰 수
 * @questionLevel 1
 * @isComplete true
 * @since 2024-03-15
 */
public class B1Q2693 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            int[] a = new int[10];
            int[] b = new int[n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<10; j++) {
                    a[j] = scan.nextInt();
                }
                Arrays.sort(a);
                b[i] = a[7];
            }

            for(int i=0; i<n; i++) {
                System.out.println(b[i]);
            }
        }
    }
}
