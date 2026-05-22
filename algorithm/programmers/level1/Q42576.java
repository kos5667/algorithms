package level1;

import java.util.*;

public class Q42576 {
    public static void main(String[] args) {
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};

//        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa", "z"};
//        String[] completion = {"josipa", "filipa", "marina", "nikola", "vinko"};

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = solution(participant, completion);
        System.out.println(answer);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String p : participant)
            map.put(p, map.getOrDefault(p, 0) + 1);

        for (String p : completion)
            map.put(p, map.get(p) -1);

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        for (;iterator.hasNext();) {
            var s = iterator.next();
            if (s.getValue() != 0)
                answer = s.getKey();
        }

        return answer;
    }
}
