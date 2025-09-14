package Silver;

import java.io.*;
import java.util.*;

/**
 * @questionNo 12891
 * @questionTitle DNA 비밀번호
 * @questionLevel 2
 * @isComplete true
 * @since 2025-09-04
 * @desription,
 * 2 초	| 시간복잡도
 * (1 ≤ |P| ≤ |S| ≤ 1,000,000)
 * <p>
 * 평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다. DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다. 예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다. 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.
 * 하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다. 임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다. 그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
 * 임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자. 그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자. 이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.
 * 민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.
 * </p>
 */
public class S5Q12891 {
//    static int[] checkArr;
//    static int[] myArr;
//    static int checkSecret;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
//        int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이
//        char[] password = br.readLine().toCharArray();
//
//        checkArr = new int[4]; // DNA
//        myArr = new int[4]; // password
//        checkSecret = 0;
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < 4; i++) {
//            checkArr[i] = Integer.parseInt(st.nextToken());
//            if (checkArr[i] == 0) checkSecret++;
//        }
//
//        int result = 0;
//        // 초기 P 세팅
//        for (int i = 0; i < P; i++) {
//            add(password[i]);
//        }
//        if (checkSecret == 4) result++;
//
//        // 슬라이딩 윈도우
//        for (int i = P; i < S; i++) {
//            int j = i - P;
//
//            System.out.println(i  + " " + j + " " + checkSecret);
//
//            add(password[i]);
//            remove(password[j]);
//            if (checkSecret == 4) result++;
//        }
//
//        System.out.println(result);
//    }
//
//    private static void add(char c) {
//        switch (c) {
//            case 'A':
//                myArr[0]++;
//                if (myArr[0] == checkArr[0]) checkSecret++;
//                break;
//            case 'C':
//                myArr[1]++;
//                if (myArr[1] == checkArr[1]) checkSecret++;
//                break;
//            case 'G':
//                myArr[2]++;
//                if (myArr[2] == checkArr[2]) checkSecret++;
//                break;
//            case 'T':
//                myArr[3]++;
//                if (myArr[3] == checkArr[3]) checkSecret++;
//                break;
//        }
//    }
//
//    private static void remove(char c) {
//        switch (c) {
//            case 'A':
//                if (myArr[0] == checkArr[0]) checkSecret--;
//                myArr[0]--;
//                break;
//            case 'C':
//                if (myArr[1] == checkArr[1]) checkSecret--;
//                myArr[1]--;
//                break;
//            case 'G':
//                if (myArr[2] == checkArr[2]) checkSecret--;
//                myArr[2]--;
//                break;
//            case 'T':
//                if (myArr[3] == checkArr[3]) checkSecret--;
//                myArr[3]--;
//                break;
//        }
//    }

    // 시간 초과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이
        char[] password = br.readLine().toCharArray();

        int[] DNA = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            DNA[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[4];
        int result = 0;
        for (int i = 0; i <= (S - P); i++) {
            System.out.println(i + " " + (i + S - P));
//            int sum = Arrays.stream(DNA).sum();
//            int[] tempDna = DNA.clone();
        }
//        System.out.println(cnt);
    }
}
