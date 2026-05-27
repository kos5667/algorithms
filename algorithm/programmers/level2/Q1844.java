package level2;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java">...</a>
 * @title 게임 맵 최단거리
 * @tag 깊이/너비 우선 탐색(DFS/BFS)
 */
public class Q1844 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + x;
                int nextY = dy[i] + y;

                // 벽 외로 이동 금지.
                if (nextY < 0 || nextX < 0 || nextX >= n || nextY >= m) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                // 막힌 벽 금지.
                if (maps[nextX][nextY] == 0) {
                    continue;
                }

                visited[nextX][nextY] = true;
                maps[nextX][nextY] = maps[x][y] + 1;

                queue.offer(new int[]{nextX, nextY});
            }
        }

        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }

    public static void main(String[] args) {
        new Q1844().solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
        new Q1844().solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}});
    }
}
