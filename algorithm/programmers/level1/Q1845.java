package level1;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Q1845 {
    public int solution(int[] nums) {
        int max = nums.length / 2;

        Integer a = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toSet(),
                        p -> Math.min(p.size(), max)
                ));

        String phone_number = "123123123123123";

        System.out.println(phone_number);
//        sdf.replace(, "*");

        return a;
//        return Math.min(a.size(), max);
    }

    public static void main(String[] args) {
        int[][] num = {{3, 1, 2, 3}, {3, 3, 3, 2, 2, 4}, {3, 3, 3, 2, 2, 2}};
        for (int[] arr : num) {
            System.out.println(new Q1845().solution(arr));
        }
    }
}
