package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @questionNo 1427
 * @questionTitle 내림차순으로 자릿수 정렬하기
 * @questionLevel 1
 * @isComplete true
 * @since 2026-05-25
 */
public class S5Q1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] nums = new int[N.length()];

        for (int i = 0; i < N.length(); i++) {
            nums[i] = Integer.parseInt(N.substring(i, i + 1));
        }

        for (int i = 0; i < nums.length; i++) {
            int max = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
            }
            if (nums[i] < nums[max]) {
                int temp = nums[i];
                nums[i] = nums[max];
                nums[max] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
