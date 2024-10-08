package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @questionNo 10809
 * @questionTitle 알파벳 찾기
 * @questionLevel 2
 * @isComplete true
 * @since 2024-08-18
 */
public class B2Q10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String word = st.nextToken();
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(word.indexOf(c) + " ");
        }
    }
}
