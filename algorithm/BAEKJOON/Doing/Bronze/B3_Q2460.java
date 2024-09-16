package Doing.Bronze;

import java.util.*;

/**
 * @questionNo 2460
 * @questionTitle 지능형 기차 2
 * @questionLevel 3
 * @isComplete true
 * @since 2022-03-13
 */
public class B3_Q2460 {
    public static void main(String[] args) {
        // answer1();
        answer2();
    }

    public static void answer1() {
        try (Scanner scan = new Scanner(System.in)) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);

            for(int i=0; i<10; i++) {
                int a=scan.nextInt(),b=scan.nextInt();
                list.add((list.get(i) - a) + b);
            }

            list.remove(0);
            int max=0;
            for(int i : list){
                if(i > max)
                    max = i;
            }
            System.out.println(max);
        }
    }

    public static void answer2() {
        try (Scanner scan = new Scanner(System.in)) {
            int n=0,m=0;

            for(int i=0; i<10; i++) {
                int a=scan.nextInt(),b=scan.nextInt();

                n += (-a) + b;
                m = Math.max(n,m);
            }
            System.out.println(m);
        }
    }
}
