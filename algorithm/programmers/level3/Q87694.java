package level3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/87694?language=java">...</a>
 * @title 아이템 줍기
 * @tag 깊이/너비 우선 탐색(DFS/BFS)
 * @recovery 0
 */
public class Q87694 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new ArrayDeque<>();
//        int[][] polygon = new int[50][50];
        int[][] polygon = new int[10][10];

        // 오른쪽, 왼쪽, 위, 아래
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};

        // 다각형 만들기
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];

            queue.offer(new int[]{x1, y1});
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int currX = poll[0];
                int currY = poll[1];

                if (currX != x1 && currY != y1 && currX != x2 && currY != y2) {
                    polygon[currX][currY] = 0;
                } else {
//                    System.out.println(polygon[currX][currY]);
                    polygon[currX][currY] = 1;
                }

                if (currX != x2) {
                    queue.offer(new int[]{currX+1, currY});
                }
                if (currY != y2) {
                    queue.offer(new int[]{currX, currY+1});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Q87694 q = new Q87694();

        System.out.println(q.solution(
                new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},
                1, 3, 7, 8
        )); // 17
//
//        System.out.println(q.solution(
//                new int[][]{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},
//                9, 7, 6, 1
//        )); // 11

//        System.out.println(q.solution(
//                new int[][]{{1,1,5,7}},
//                1, 1, 4, 7
//        )); // 9

//        System.out.println(q.solution(
//                new int[][]{{2,1,7,5},{6,4,10,10}},
//                3, 1, 7, 10
//        )); // 15
//
//        System.out.println(q.solution(
//                new int[][]{{2,2,5,5},{1,3,6,4},{3,1,4,6}},
//                1, 4, 6, 3
//        )); // 10
    }
}
