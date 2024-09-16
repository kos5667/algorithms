package Done.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @questionNo 11720
 * @questionTitle 숫자의 합 구하기
 * @questionLevel 브론즈4
 * @isComplete true
 * @since 2024-08-18
 */
public class B4_Q11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String num = br.readLine();

        // 방법 1
        int result = num.chars().map(Character::getNumericValue).sum();

        // 방법 2
//        int result = 0;
//        for (char i : num.toCharArray()) {
//            result += i-'0';
//        }
        System.out.println(result);
    }
}
