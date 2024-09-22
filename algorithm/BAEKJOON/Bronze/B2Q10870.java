package Bronze;

import java.util.*;

/**
 * @questionNo 10870
 * @questionTitle 피보나치 수 5
 * @questionLevel 2
 * @isComplete true
 * @since 2022-03-13
 */
public class B2Q10870 {
    public static void main(String[] args) {
        // answer1();
        answer2();
    }

    public static void answer1() {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            for(int i=0; i<=n; i++) {
                if(i==n)
                    System.out.println(fibo(i));
            }
        }
    }

    public static void answer2() {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<=n; i++) {
                System.out.print(list.get(i));
                if(i <= 1)
                    list.add(i);
                else
                    list.add((list.get(i) - 2) + (list.get(i) - 1));

            }
        }
    }

    public static int fibo(int n) {
        if(n <= 1)
            return n;
        else {
            return fibo(n-1) + fibo(n-2);
        }
    }
}
