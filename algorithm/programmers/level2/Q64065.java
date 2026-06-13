package level2;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/64065">...</a>
 * @title 2019 카카오 개발자 겨울 인턴십 튜플
 *
 */
public class Q64065 {
    public int[] solution(String s) {
        String[] groups = s.substring(2, s.length() - 2)
                .split("\\},\\{");

        Arrays.sort(groups, Comparator.comparingInt(String::length));

        List<Integer> result = new ArrayList<>();
        Set<Integer> used = new HashSet<>();

        for (String group : groups) {
            String[] numbers = group.split(",");

            for (String number : numbers) {
                int value = Integer.parseInt(number);

                if (!used.contains(value)) {
                    used.add(value);
                    result.add(value);
                }
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    public static void main(String[] args) {
        Q64065 q64065 = new Q64065();
        q64065.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        q64065.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        q64065.solution("{{20,111},{111}}");
        q64065.solution("{{123}}");
        q64065.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }
}
