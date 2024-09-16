package Done.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @questionNo 1546
 * @questionTitle 평균 구하기
 * @questionLevel 브론즈1
 * @isComplete true
 * @since 2024-08-18
 */
public class B1_Q1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        double[] array = new double[n];
//        for (int i=0; i < n; i++) {
//            array[i] = Integer.parseInt(st.nextToken());
//        }
//         double m = Arrays.stream(array).max().orElseThrow(() -> new RuntimeException("Error"));

        // 제출 1 14776 KB, 112 ms
        // double r = Arrays.stream(array).sum() * 100 / m / n;
        // System.out.println(r);

        // 제출 2 14724 KB, 116 ms
        // double r = Arrays.stream(array).map(num -> ((num / m) * 100)).average().orElseThrow();
        // System.out.println(r);

        // 제출 3 14332 KB, 103 ms
        long sum = 0;
        long max = 0;

        for (int i=0; i<n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > max) max = temp;
            sum += temp;
        }
        System.out.println(sum * 100.0 / max / n);
    }
}
