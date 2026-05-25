package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @questionNo 11724
 * @questionTitle 연결 요소의 개수 구하기
 * @questionLevel 5
 * @isComplete true
 * @since 2026-05-25
6 5
1 2
2 5
5 1
3 4
4 6
 */
public class S5Q11724 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드
        int M = Integer.parseInt(st.nextToken()); // 에지

        visited = new boolean[N+1]; // 방문 배열
        A = new ArrayList[N+1]; // 에지

        for (int i = 1; i <= N; i++){
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            A[from].add(to);
            A[to].add(from);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++){
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }

    static void DFS(int idx){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(idx);

        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (visited[now])
                continue;

            visited[now] = true;
            for (int next : A[now]) {
                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
    }
}
