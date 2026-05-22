package level1;

class Q7302 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] b = {4,7,12};
        boolean[] a = {true, false, true};
        new Q7302().solution(b, a);
    }
}
