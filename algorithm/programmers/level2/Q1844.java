package level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

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
        queue.offer(new int[]{0, 0}); // 시작은 (0, 0);

        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            // action은 4방향 위 아래 왼쪽 오른쪽
            for (int i=0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                /**
                 * nx는 0보다 작을 수 없다.
                 * ny는 0보다 작을 수 없다.
                 * n, y 또한 현재보다 커야 함.
                 */
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 방문했으면 pass
                if (visited[nx][ny]) {
                    continue;
                }

                // 막힌 길 pass
                if (maps[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                maps[nx][ny] = maps[x][y] + 1;

                queue.offer(new int[]{nx, ny});
            }
        }

        for (int[] i : maps) {
            System.out.println(Arrays.toString(i));
        }
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }

    public static void main(String[] args) {
        new Q1844().solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
//        new Q1844().solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}});
    }
}
