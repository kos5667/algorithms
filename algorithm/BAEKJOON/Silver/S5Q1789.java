package Silver;

import java.util.*;

/**
 * @questionNo 1789
 * @questionTitle 수들의 합
 * @questionLevel 5
 * @isComplete true
 * @since 2022-03-15
 */
public class S5Q1789 {
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
