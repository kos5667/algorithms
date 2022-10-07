package algorithm;

import java.util.Arrays;

public class Codility_Demo {
    public static void main(String[] args) {
        // int[] A = {1, 3, 6, 4, 1, 2};
        // int[] A = {1, 2, 3};
        int[] A = {-1, -3};

        System.out.println(run(A));
    }

    // static int run(int[] A) {
    //     Arrays.sort(A);
    //     int an = 0;
    //     int x = 0;
    //     for(int i=0; i<A.length; i++) {

    //         if((x+1) < A[i] && x != A[i] && 0 < A[A.length-1] && (x+1) > 0) {
    //             System.out.println(x+1);
    //         } else if((i+1) == A.length  && 0 < A[A.length-1]) {
    //             System.out.println(A[i]+1);
    //         } else if((i+1) == A.length  && 0 > A[A.length-1]) {
    //             System.out.println(1);
    //         }

    //         x = A[i];
    //     }

        
    //     return x;
    // }

    static int run(int[] A) {
        int x = 1;

        Arrays.sort(A);
        for(int i=0; i<A.length; i++) {
            if(A[i] == x) {
                x++;
            }
        }

        return x;
    }

}
