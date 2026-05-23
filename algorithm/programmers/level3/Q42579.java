package level3;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42579">...</a>
 *
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
 * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 *
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 */
class Q42579 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresTotal = new HashMap<>();
        Map<String, ArrayList<int[]>> playedSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genresTotal.put(genres[i], genresTotal.getOrDefault(genres[i], 0) + plays[i]);

            playedSongs
                    .computeIfAbsent(genres[i], k -> new ArrayList<>())
                    .add(new int[]{i, plays[i]});
        }

        ArrayList<Integer> answer = new ArrayList<>();
        genresTotal.keySet().stream()
                .sorted((g1, g2) -> genresTotal.get(g2).compareTo(genresTotal.get(g1)))
                .forEach(g -> {
                    playedSongs.get(g).sort((s1, s2) -> {
                        if (s1[1] != s2[1])
                            return s2[1] - s1[1];
                        return s1[0] - s2[0];
                    });

                    playedSongs.get(g).stream()
                            .limit(2)
                            .forEach(play -> answer.add(play[0]));
                });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = new Q42579().solution(genres, plays);
        for (int i : result) System.out.print(i + " ");
    }
}
