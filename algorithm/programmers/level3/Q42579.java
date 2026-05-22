package level3;

import java.util.*;

public class Q42579 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreSort = new HashMap<>();

        int[][] sort = new int[genres.length][2];
        for (int i = 0; i < plays.length; i++) {
            sort[i][0] = i;
            sort[i][1] = plays[i];

            genreSort.put(genres[i], genreSort.getOrDefault(genres[i], 0) + plays[i]);
        }

        String[] sortedG = genreSort.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        Arrays.sort(sort, ((o1, o2) -> o2[1] - o1[1]));

        int idx = 0;
        int[] answer = new int[sortedG.length * 2];

        for (String genre : sortedG) {
            for (int[] ints : sort) {
                if (idx == sortedG.length * 2)
                    break;

                if (genre.equals(genres[ints[0]])) {
                    answer[idx] = ints[0];
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
