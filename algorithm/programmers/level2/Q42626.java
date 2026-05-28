package level2;

import java.util.PriorityQueue;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42626">...</a>
 * @title 더 맵게
 * @tag 힙(Heap)
 */
public class Q42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : scoville) {
            pq.offer(x);
        }

        while (pq.peek() < K) {
            if (pq.size() < 2)
                return -1;

            int x = pq.poll();
            int y = pq.poll();

            pq.offer(x + y * 2);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        new Q42626().solution(new int[] {1, 2, 3, 9, 10, 12}, 7);
    }
}
