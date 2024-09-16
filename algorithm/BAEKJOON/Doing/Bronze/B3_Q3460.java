package Doing.Bronze;

import java.util.Scanner;

/**
 * @questionNo 3460
 * @questionTitle 이진수
 * @questionLevel 3
 * @isComplete true
 * @since 2022-03-12
 */
public class B3_Q3460 {
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
