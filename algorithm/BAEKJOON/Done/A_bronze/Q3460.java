package Done.A_bronze;

import java.util.Scanner;

/**
 * 이진수
 * 3460 : 브론즈Ⅲ
 */
public class Q3460 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int t = scan.nextInt();

            for(int i=0; i < t; i++){
                int n = scan.nextInt();
                String bi = Integer.toBinaryString(n);
                bi = new StringBuilder(bi).reverse().toString();

                for(int j=0; j<bi.length(); j++){
                    if(bi.charAt(j) == '1')
                        System.out.print(j+" ");
                }
                System.out.println();
            }
        }
    }
}
