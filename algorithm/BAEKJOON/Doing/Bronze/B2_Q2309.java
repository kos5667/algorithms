package Doing.Bronze;

import java.util.*;

/**
 * @questionNo 2309
 * @questionTitle 일곱 난쟁이
 * @questionLevel 2
 * @isComplete true
 * @since 2022-03-14
 */
public class B2_Q2309 {
    public static void main(String[] args) {
        // answer1();
        answer2();
        answer3();
    }

    private static void answer2() {
        try (Scanner scan = new Scanner(System.in)) {
            int arr[] = new int[9];
            int total = 0;
            for (int i = 0; i < 9; i++) {
                arr[i] = scan.nextInt();
                total += arr[i];
            }
            scan.close();
            Loop : for (int i = 0; i < 9; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if(i==j) continue;
                    if (total - arr[i] - arr[j] == 100) {
                        arr[i] = 0;
                        arr[j] = 0;
                        break Loop;
                    }
                }
            }
            Arrays.sort(arr);
            for(int i=0; i<arr.length; i++)
                if(arr[i]!=0)
                    System.out.println(arr[i]);
        }
    }

    public static void answer1() {
        try (Scanner scan = new Scanner(System.in)) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<9; i++) {
                int n = scan.nextInt();
                list.add(n);
            }

            Loop1 :
            for(int i=0; i<list.size(); i++) {
                for(int j=0; j<list.size(); j++) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.addAll(list);

                    int sum = temp.stream().mapToInt(Integer::intValue).sum();
                    int cur = 0;
                    sum -= temp.get(i);
                    if(i==j) {
                        if((j+1) >= list.size()) {
                            sum -= temp.get(j-1);
                            cur = j-1;
                        }
                        else {
                            sum -= temp.get(j+1);
                            cur = j+1;
                        }
                    } else {
                        sum -= temp.get(j);
                        cur = j;
                    }

                    if(sum == 100) {
                        if(i > cur) {
                            temp.remove(i);
                            temp.remove(cur);
                        } else {
                            temp.remove(cur);
                            temp.remove(i);
                        }
                        temp.sort(Comparator.naturalOrder());
                        for(int n : temp)
                            System.out.println(n);
                        break Loop1;
                    }
                }
            }
        }
    }

    public static void answer3() {
        try (Scanner scan = new Scanner(System.in)) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<9; i++) {
                int n = scan.nextInt();
                list.add(n);
            }

            Loop1 :
            for(int i=0; i<list.size(); i++) {
                for(int j=0; j<list.size(); j++) {
                    int sum = list.stream().mapToInt(Integer::intValue).sum();

                    if(i==j) continue;
                    if(sum - list.get(i) - list.get(j) == 100) {
                        list.set(i, 0);
                        list.set(j, 0);
                        list.sort(Comparator.naturalOrder());

                        for(int n : list) {
                            if(n != 0)
                                System.out.println(n);
                        }
                        break Loop1;
                    }
                }
            }
        }

    }
}
