package Bronze;

import java.util.*;

/**
 * @questionNo 2581
 * @questionTitle 소수
 * @questionLevel 2
 * @isComplete true
 * @since 2022-03-16
 */
public class B2Q2581 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int m=scan.nextInt();
            int n=scan.nextInt();

            List<Integer> list = new ArrayList<Integer>();
            for(int i=m; i<=n; i++){
                if(isPrime(i)) list.add(i);
            }

            System.out.println(list.size() != 0 ? list.stream().mapToInt(Integer::intValue).sum()+"\n"+list.get(0) : -1);
        }
    }

    public static boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i=2; i<num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
