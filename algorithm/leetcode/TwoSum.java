import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * @hidden Hash Table
 */

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];

            if (map.containsKey(num) && map.get(num) != i) {
                answer[0] = i;
                answer[1] = map.get(num);
                return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        int[] result = new TwoSum().twoSum(new int[]{11, 7, 2, 15}, 9);
        int[] result = new TwoSum().twoSum(new int[]{3,2,4}, 6);
//        int[] result = new TwoSum().twoSum(new int[]{3,3}, 6);
        System.out.println(Arrays.toString(result));
    }
}
