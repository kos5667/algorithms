package level2;

import java.util.Arrays;

public class Q147354 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) -> {
            if (a[col-1] != b[col-1]) {
                return a[col - 1] - b[col - 1];
            }
            return b[0] - a[0];
        });

        int answer = 0;
        for (;row_begin <= row_end; row_begin++) {
            int sum = 0;
            for (int i : data[row_begin - 1]) {
                sum += i % row_begin;
            }
            answer ^= sum;
        }
        return answer;
    }


    public static void main(String[] args) {
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        new Q147354().solution(data, 2, 2 ,3);
    }
}
