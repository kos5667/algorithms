package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @questionNo 11720
 * @questionTitle 숫자의 합 구하기
 * @questionLevel 4
 * @isComplete true
 * @since 2024-08-18
 * 1
 * 10987654321
 */
public class B4Q11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String sNum = br.readLine();

        int sum = sNum.chars().map(Character::getNumericValue).sum();

//        int sum = 0;
//        char[] arr = sNum.toCharArray();
//
//        for (char c : arr) {
//            sum += Integer.parseInt(String.valueOf(c));
//        }
        System.out.println(sum);
    }
}
