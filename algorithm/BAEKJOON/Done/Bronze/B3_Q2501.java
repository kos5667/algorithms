package Done.Bronze;

import java.util.Scanner;

/**
 * @questionNo 2501
 * @questionTitle 약수 구하기
 * @questionLevel 브론즈3
 * @isComplete true
 * @since 2022-03-10
 */
public class B3_Q2501 {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            int C = 0;

            if(1 <= N && 10000 >= N) {
                if(1 <= K && N >= K) {

                    for(int i=1; i <= N; i++) {
                        if(N%i == 0) {
                            C++;

                            if(K==C) {
                                System.out.println(i);
                            } else if(i == N && K>C){
                                System.out.println(0);
                            }
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
