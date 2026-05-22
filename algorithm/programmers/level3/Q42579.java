package level3;

import java.util.*;

class Q42579 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + plays[i]);

            genreSongs
                    .computeIfAbsent(genre, k -> new ArrayList<>())
                    .add(new int[]{i, plays[i]});
        }

        List<Integer> answer = new ArrayList<>();
        genreTotal.keySet().stream()
                .sorted((g1, g2) -> genreTotal.get(g2) - genreTotal.get(g1))
                .forEach(genre -> {
                    genreSongs.get(genre).sort((s1, s2) -> {
                        if (s1[1] != s2[1]) {
                            return s2[1] - s1[1];
                        }
                        return s1[0] - s2[0];
                    });

                    genreSongs.get(genre).stream()
                            .limit(2)
                            .forEach(song -> answer.add(song[0]));
                });

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        new Q42579().solution(genres, plays);
    }
}
