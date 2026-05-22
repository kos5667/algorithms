package level2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Q42578 {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(Collectors.groupingBy(clo -> clo[1], Collectors.counting()))
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .reduce(1, (x, y) -> x * (y + 1)) - 1;
    }

    public static void main(String[] args) {
        String[][][] clothes = {
                {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}},
                {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}},
                {{"hat", "headgear"}},
                {{"hat", "headgear"}, {"cap", "headgear"}},
                {{"hat", "headgear"}, {"sunglasses", "eyewear"}},
                {{"hat", "headgear"}, {"cap", "headgear"}, {"sunglasses", "eyewear"}, {"mask", "face"}},
                {{"a", "type1"}, {"b", "type1"}, {"c", "type2"}, {"d", "type2"}, {"e", "type3"}},
                {{"item1", "kind1"}, {"item2", "kind2"}, {"item3", "kind3"}, {"item4", "kind4"}},
                {{"a", "same"}, {"b", "same"}, {"c", "same"}, {"d", "same"}, {"e", "same"}},
                {{"red_hat", "headgear"}, {"blue_hat", "headgear"}, {"green_hat", "headgear"}, {"black_glasses", "eyewear"}, {"white_glasses", "eyewear"}, {"jeans", "pants"}, {"coat", "outer"}}
        };

        for (String[][] param : clothes) {
            System.out.println(new Q42578().solution(param));
            System.out.println("-------------------------");
        }
    }
}
