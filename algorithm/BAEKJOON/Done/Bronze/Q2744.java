package Done.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2744 {
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
