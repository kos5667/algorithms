package Done.B_silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** (진행중)
 * 1934 그림
 * 시간 제한 2초(2억 연산 이하) | 메모리 제한 128 MB | 실버 1
 * 128 MB = 128000 KB, 0.5s = 500000 ms
 */
public class Q1926 {
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
//        ArrayList<int[][]> painting = painting();

//        result = getPainting(painting);
//        int max = Collections.max(result);
//        int min = Collections.min(result);

//        System.out.println(result);
    }

    public static ArrayList<Integer> getPainting (ArrayList<int[][]> painting) {
        for (int i=0; i<painting.size(); i++) {
            int sum = 0;

            // 높이 만큼.
//            for (int j=0; j<painting.get(i).length; j++) {
//
//                for ()
//                if (painting.get(i)[j] == 1) {
//                    find(painting.get(i)[j], i, j);
//                } else {
//
//                }
//            }
        }
        return null;
    }

    public static int height () {
        return 0;
    }

    public static int width () {
        return 0;
    }

    public static int find(ArrayList<int[]> painting, int i, int m) {
        int sum = 0;

        while (true) {
            if (painting.get(i)[m] == 1) {
                sum += find(painting, i, m++);
            } else {
                break;
            }
        }
        return sum;
    }

    /**
     * 0 {1,0} {1,1} {0,2} {1,3}
     * 1 {1,0} {0,1} {0,2} {1,3}
     * 2 {0,0} {0,1} {0,2} {1,3}
     * 3 {0,0} {1,1} {1,2} {0,3}
     */
    public static ArrayList<int[]> painting() {
        ArrayList<int[]> list = new ArrayList<>();

        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt(); // 세로
            int m = scan.nextInt(); // 가로

//            int[][][] array = new int[0][n][m];
//            for (int i = 0; i < n; i++) {
//                // 그림 입력
//                for (int j = 0; j < m; j++) {
//                    int o = scan.nextInt();
//                    array[0][i][j] = new int[] {o,j};
//                }
//            }
        }
        return list;
    };
}
