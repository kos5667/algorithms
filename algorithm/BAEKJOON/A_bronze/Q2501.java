import java.util.Scanner;

/**
 * 약수 구하기
 * 2501 : 브론즈Ⅲ
 */
public class Q2501 {
    
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