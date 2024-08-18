import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11720
 * 숫자의 합 구하기
 * 시간 제한 1초(1억 번 이하 연산)| 보론즈2
 */
public class Q11720 {
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
