package level3;

import java.util.*;

public class Q42579 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        int[][] playsSorted = new int[plays.length][2];
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

            playsSorted[i][0] = i;
            playsSorted[i][1] = plays[i];
        }

        String[] sorted = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2 - o1))
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        Arrays.sort(playsSorted, ((o1, o2) -> o2[1] - o1[1]));

        int[] answer = new int[sorted.length * 2];
        int a = 0;
        for (int s=0; s < sorted.length; s++) {
            int idx = 0;
            for (int i=0; i < plays.length; i++) {
                if (idx == 2) break;

                if (sorted[s].equals(genres[playsSorted[i][0]])) {
                    answer[a++] = playsSorted[i][0];
                    idx++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        new Q42579().solution(genres, plays);
    }
}
