package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @questionNo 2744
 * @questionTitle 대소문자 바꾸기
 * @questionLevel 5
 * @isComplete true
 * @since 2024-03-12
 */
public class B5Q2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();

        StringBuilder empty = new StringBuilder();
        for(char m : n.toCharArray()) {
            empty.append(Character.isUpperCase(m) ? Character.toLowerCase(m) : Character.toUpperCase(m));
        }
        System.out.println(empty);
    }
}
