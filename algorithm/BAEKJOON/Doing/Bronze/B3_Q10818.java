package Doing.Bronze;

import java.util.*;

/**
 * @questionNo 10818
 * @questionTitle 최소, 최대
 * @questionLevel 브론즈3
 * @isComplete true
 * @since 2022-03-10
 */
public class B3_Q10818 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int t = scan.nextInt();
            List<Integer> list = new ArrayList<Integer>();

            for(int i=0; i< t; i++){
                int n = scan.nextInt();
                list.add(n);
            }

            int min = 1000000,max = -1000000;
            for(int i : list) {
                if(min > i)
                    min = i;
                if(max < i)
                    max = i;
            }
            System.out.println(min + " " + max);
        }
    }
}
