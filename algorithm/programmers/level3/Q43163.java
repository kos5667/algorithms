package level3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java">...</a>
 * @title 네트워크
 * @tag 깊이/너비 우선 탐색(DFS/BFS)
 * @recovery 0
 *
 * 문제 설명
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 *
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 * 2. words에 있는 단어로만 변환할 수 있습니다.
 * 예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
 *
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
 * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
 * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
 * begin과 target은 같지 않습니다.
 * 변환할 수 없는 경우에는 0를 return 합니다.
 *
 * 입출력 예
 * begin	target	words	                                    return
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	        0
 *
 * 입출력 예 설명
 * 예제 #1
 * 문제에 나온 예와 같습니다.
 *
 * 예제 #2
 * target인 "cog"는 words 안에 없기 때문에 변환할 수 없습니다.
 */
public class Q43163 {
    public int solution(String begin, String target, String[] words) {
        // 방문한 words 체크.
        boolean[] visited = new boolean[words.length];

        // DFS를 위한 Queue
        Queue<Node> queue = new ArrayDeque<>();

        // 시작 데이터 삽입.
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // node의 변환 word가 target과 같은때 while을 멈추고 count를 return
            if (node.word.equals(target)) {
                return node.count;
            }

            // words를 반복하여 알파벳 하나씩 비교하여 방문한다.
            for (int i = 0; i < words.length; i++) {
                // 이미 방문한 단어는 pass
                if (visited[i]) {
                    continue;
                }

                // 변환이 가능하면, 단어가 있다는 것임으로 카운터를 +1하고, 단어를 삽입 및 방문 등록.
                if (canConvert(node.word, words[i])) {
                    queue.offer(new Node(words[i], node.count + 1));
                    visited[i] = true;
                }
            }
        }

        return 0;
    }

    boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }

            if (diff > 1)
                return false;
        }
        return diff == 1;
    }

    static class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        new Q43163().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
//        new Q43163().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
    }
}
