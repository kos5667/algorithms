package Bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @questionNo 15552
 * @questionTitle 빠른 A+B
 * @questionLevel 4
 * @isComplete true
 * @since 2022-03-16
 */
public class B4Q15552 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(a+b+"\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
