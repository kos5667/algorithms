package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/64065">...</a>
 * @title 2019 카카오 개발자 겨울 인턴십 튜플
 *
 */
public class Q64065 {
    public int[] solution(String s) {
        ArrayList<int[]> converted = convertTuple(s);
        converted.sort(Comparator.comparingInt(o -> o.length));

        int[] answer = new int[converted.get(converted.size() - 1).length];
        for (int i = 0; i < converted.size(); i++) {
            for (int j = 0; j < converted.get(i).length; j++) {
                answer[i] = converted.get(i)[j];
            }
        }

        return new int[]{3};
    }

    private ArrayList<int[]> convertTuple(String s) {
        String parse = s.substring(1, s.length() -1);
        String[] target = parse.split("}");

        ArrayList<int[]> converted = new ArrayList<>();
        for (int i = 0; i < target.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j< target[i].length(); j++) {
                if (Character.isDigit(target[i].charAt(j))) {
                    list.add(Integer.parseInt(Character.toString(target[i].charAt(j))));
                }
            }
            converted.add(list.stream().mapToInt(Integer::intValue).toArray());
        }
        return converted;
    }


    public static void main(String[] args) {
        Q64065 q64065 = new Q64065();
        q64065.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
//        q64065.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
//        q64065.solution("{{20,111},{111}}");
//        q64065.solution("{{123}}");
//        q64065.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }
}
