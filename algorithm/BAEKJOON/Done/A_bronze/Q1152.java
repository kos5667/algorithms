package Done.A_bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1152 | 단어의 개수
 * 시간 제한 2초 | 메모리 제한 128 MB | 브론즈2
 */
public class Q1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        System.out.println(st.countTokens());
    }
}
