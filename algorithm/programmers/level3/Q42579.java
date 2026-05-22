package level3;

import java.util.*;

class Q42579 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreTotal = new HashMap<>();
        int[][] songs = new int[plays.length][2];

        for (int i = 0; i < genres.length; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
            songs[i][0] = i;
            songs[i][1] = plays[i];
        }

        String[] sortedGenres = genreTotal.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        Arrays.sort(songs, (a, b) -> {
            if (b[1] != a[1]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        ArrayList<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            int count = 0;

            for (int[] song : songs) {
                if (count == 2) break;

                int songId = song[0];

                if (genre.equals(genres[songId])) {
                    result.add(songId);
                    count++;
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        new Q42579().solution(genres, plays);
    }
}
