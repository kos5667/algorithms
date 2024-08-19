import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11659 | 구간 합 구하기 4
 * 시간 제한 0.5초(5000만 연산 이하) | 메모리 제한 128 MB | 실버3
 * 128 MB = 128000 KB, 0.5s = 500000 ms
 */
public class Q11659 {
    /**
     * 직접 구현
     * 메모리: 257.948 MB, 시간: 1824 MS, 코드 길이: 917 B
     * 메모리 제한이 128을 넘김.
     */
//    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt(); // 수의 개수
//        int m = scan.nextInt(); // 합을 구해야 하는 횟수
//
//        // a : 수 배열, s : 합 배열
//        int[] a = new int[n], s = new int[n];
//        for (int i=0; i<n; i++) {
//            a[i] = scan.nextInt();
//            s[i] = (i == 0) ? a[i] : s[i-1] + a[i];
//        }
//
//        for (int p=0; p<m; p++) {
//            int i = scan.nextInt()-1 , j = scan.nextInt()-1;
//            if (i == 0) {
//                System.out.println(s[j]);
//            } else {
//                System.out.println(s[j] - s[i-1]);
//            }
//        }
//    }

    /**
     * 교제
     * 메모리: 58.412 MB, 시간: 1072 MS, 코드 길이: 1144 B
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        long[] s = new long[n+1];
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            s[i] = s[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int q=0; q<m; q++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(s[j] - s[i-1]);
        }
    }
}
