import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1546 | 평균 구하기
 * 시간 제한 2초 | 메모리 제한 128 MB | 브론즈1
 */
public class Q1546 {
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
