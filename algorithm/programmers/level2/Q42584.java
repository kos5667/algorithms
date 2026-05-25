package level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * @title 주식가격
 * @tag 스택/큐
 *
 * 문제 설명
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * prices의 길이는 2 이상 100,000 이하입니다.
 *
 * 입출력 예
 * prices	       | return
 * [1, 2, 3, 2, 3] | [4, 3, 1, 1, 0]
 *
 * 입출력 예 설명
 * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
 * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
 * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
 * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
 * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
 */
public class Q42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<prices.length; i++){
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index]++;
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(answer));

        for (int index : stack) {
            answer[index] = prices.length - 1 - index;
        }
        System.out.println(stack + " " + Arrays.toString(answer));

        return answer;
    }

    /**
     * 정확성  테스트
     * 테스트 1 〉	통과 (0.03ms, 59.4MB)
     * 테스트 2 〉	통과 (0.25ms, 63.6MB)
     * 테스트 3 〉	통과 (0.95ms, 62.1MB)
     * 테스트 4 〉	통과 (0.95ms, 60.6MB)
     * 테스트 5 〉	통과 (0.98ms, 62.5MB)
     * 테스트 6 〉	통과 (0.11ms, 62.1MB)
     * 테스트 7 〉	통과 (0.85ms, 62.9MB)
     * 테스트 8 〉	통과 (1.24ms, 64.5MB)
     * 테스트 9 〉	통과 (0.14ms, 62.3MB)
     * 테스트 10 〉	통과 (1.18ms, 62.3MB)
     * 효율성  테스트
     * 테스트 1 〉	통과 (22.03ms, 76.7MB)
     * 테스트 2 〉	통과 (20.42ms, 72.2MB)
     * 테스트 3 〉	통과 (23.58ms, 77MB)
     * 테스트 4 〉	통과 (24.37ms, 79.3MB)
     * 테스트 5 〉	통과 (20.38ms, 72MB)
     */
//    public int[] solution(int[] prices) {
//        Queue<int[]> queue = new ArrayDeque<>();
//        for (int i = 0; i < prices.length; i++) {
//            queue.add(new int[] {i, prices[i], 0});
//        }
//
//        int[] answer = new int[prices.length];
//        while (!queue.isEmpty()) {
//            int[] price = queue.poll();
//
//            for (int[] p : queue) {
////                if (price[1] <= p[1]) price[2]++;
//
//                price[2]++;
//                if (price[1] > p[1]) {
//                    break;
//                }
//            }
//            answer[price[0]] = price[2];
//        }
//        return answer;
//    }

    /**
     * GPT
     *
     * 정확성  테스트
     * 테스트 1 〉	통과 (0.10ms, 61.3MB)
     * 테스트 2 〉	통과 (0.62ms, 59.7MB)
     * 테스트 3 〉	통과 (0.83ms, 61.7MB)
     * 테스트 4 〉	통과 (0.89ms, 61.1MB)
     * 테스트 5 〉	통과 (0.87ms, 61.1MB)
     * 테스트 6 〉	통과 (0.16ms, 65.8MB)
     * 테스트 7 〉	통과 (0.81ms, 61.2MB)
     * 테스트 8 〉	통과 (0.85ms, 60.4MB)
     * 테스트 9 〉	통과 (0.15ms, 63.1MB)
     * 테스트 10 〉	통과 (0.97ms, 61.7MB)
     * 효율성  테스트
     * 테스트 1 〉	통과 (14.50ms, 76.6MB)
     * 테스트 2 〉	통과 (12.47ms, 74.8MB)
     * 테스트 3 〉	통과 (31.60ms, 81.7MB)
     * 테스트 4 〉	통과 (11.91ms, 73MB)
     * 테스트 5 〉	통과 (8.71ms, 66.7MB)
     */
//    public int[] solution(int[] prices) {
//        int n = prices.length;
//        int[] answer = new int[n];
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
//                int index = stack.pop();
//                answer[index] = i - index;
//            }
//
//            stack.push(i);
////            System.out.println(Arrays.toString(answer) + " " + stack);
////            System.out.println(Arrays.toString(answer));
////            System.out.println(stack);
//            System.out.println(stack + " " + Arrays.toString(answer));
//        }
//
////        System.out.println(Arrays.toString(answer) + " " + stack);
//
//        while (!stack.isEmpty()) {
//            int index = stack.pop();
//            answer[index] = n - 1 - index;
//        }
//        System.out.println(Arrays.toString(answer));
//        return answer;
//    }

    public static void main(String[] args) {
//        new Q42584().solution(new int[] {1, 2, 3, 2, 3});
        new Q42584().solution(new int[] {2, 3, 1, 2, 3});
//        new Q42584().solution(new int[] {1, 1});
//        new Q42584().solution(new int[] {5, 4, 3, 2, 1});
    }
}
