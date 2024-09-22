package Bronze;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * @questionNo 11660
 * @questionTitle 쉽게 푸는 문제
 * @questionLevel 1
 * @isComplete true
 * @since 2022-03-16
 */
public class B1Q1292 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 속도 비교
        answer1(); // 156ms
        // answer2(); // 292ms
    }

    /**
     * BufferedReader, BufferedWriter
     * @throws IOException
     */
    public static void answer1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int t=1, r=0;
        for(int i=1,c=1; i<=b; i++) {
            for(int j=1; j<=t; j++,c++) {
                if(a <= c && b >= c) r += t;
            }
            t++;
        }

        bw.write(r+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * Scanner, System.out.print
     */
    public static void answer2() {
        try (Scanner scan = new Scanner(System.in)) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            int t=1, r=0;
            for(int i=1,c=1; i<=b; i++) {
                for(int j=1; j<=t; j++,c++) {
                    if(a <= c && b >= c) r += t;
                }
                t++;
            }
            System.out.println(r);
        }
    }
}
