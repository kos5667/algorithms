import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1152 | 단어의 개수
 * 시간 제한 2초 | 메모리 제한 128 MB | 브론즈2
 */
public class Q10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String word = st.nextToken();
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(word.indexOf(c) + " ");
        }
    }
}
