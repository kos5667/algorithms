package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @questionNo 2178
 * @questionTitle 미로 탐색하기
 * @questionLevel 1
 * @isComplete true
 * @since 2026-05-26
 */
public class S1Q2178 {
    // 상하좌우를 탐색하기 위한 배열 선언하기.
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }

    static void BFS(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];
                // 좌표 유형성 검사
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (A[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                        A[nextX][nextY] = A[curr[0]][curr[1]] + 1;
                        queue.offer(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
