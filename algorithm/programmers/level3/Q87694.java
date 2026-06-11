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
        int[][] map = new int[102][102];

        // 좌표 2배 확장해서 사각형 그리기
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    // 내부는 무조건 1
                    if (x > x1 && x < x2 && y > y1 && y < y2) {
                        map[x][y] = 1;
                    } else {
                        // 내부가 아닌 곳만 테두리
                        if (map[x][y] != 1) {
                            map[x][y] = 2;
                        }
                    }
                }
            }
        }

        for (int[] m: map) {
            System.out.println(Arrays.toString(m));
        }

        return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    private int bfs(int[][] map, int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[102][102];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            if (x == targetX && y == targetY) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 102 || ny >= 102) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                // 테두리만 이동 가능
                if (map[nx][ny] != 2) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
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
