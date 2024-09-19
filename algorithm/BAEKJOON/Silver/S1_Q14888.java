package Silver;

import java.util.*;

/**
 * 14888 | 연산자 끼워넣기
 * 시간 제한 1초(1억 연산 이하) | 메모리 제한 128 MB | 실버1
 * 128 MB = 128,000 KB, 1s = 1,000,000 ms
 */
public class S1_Q14888 {

	/**
	 * @since 2023-03-28
	 */
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int O = N - 1;

		List<Integer> seq = new ArrayList<Integer>();
		List<Integer> ope = new ArrayList<Integer>();

		// 수열 입력
//		for (int i=0; i<N; i++) seq.add(scan.nextInt());

		// 연산자 입력
		for (int i=0; i<4; i++) ope.add(scan.nextInt());

		if (O != ope.stream().mapToInt(Integer::intValue).sum())
			throw new Exception("연산자의 수는 N-1 입니다. 입력한 수 : "+ope.stream().mapToInt(Integer::intValue).sum());


	}

	// + - × ÷
	// 0 0 0 0
	public int func() {
		return 0;
	}

//    public static int MAX = Integer.MIN_VALUE;	// 최댓값
//	public static int MIN = Integer.MAX_VALUE;	// 최솟값
//	public static int[] operator = new int[4];	// 연산자 개수
//	public static int[] number;					// 숫자
//	public static int N;						// 숫자 개수

//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		N = Integer.parseInt(br.readLine());
//		number = new int[N];
//
//		// 숫자 입력
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		for (int i = 0; i < N; i++) {
//			number[i] = Integer.parseInt(st.nextToken());
//		}
//
//		// 연산자 입력
//		st = new StringTokenizer(br.readLine(), " ");
//		for (int i = 0; i < 4; i++) {
//			operator[i] = Integer.parseInt(st.nextToken());
//		}
//
//		dfs(number[0], 1);
//
//		System.out.println(MAX);
//		System.out.println(MIN);
//    }

//    public static void dfs(int num, int idx) {
//		if (idx == N) {
//			MAX = Math.max(MAX, num);
//			MIN = Math.min(MIN, num);
//			return;
//		}
//
//		// Commit Test
//		for (int i = 0; i < 4; i++) {
//			// 연산자 개수가 1개 이상인 경우
//			if (operator[i] > 0) {
//
//				// 해당 연산자를 1 감소시킨다.
//				operator[i]--;
//
//				switch (i) {
//
//				case 0:	dfs(num + number[idx], idx + 1);	break;
//				case 1:	dfs(num - number[idx], idx + 1);	break;
//				case 2:	dfs(num * number[idx], idx + 1);	break;
//				case 3:	dfs(num / number[idx], idx + 1);	break;
//
//				}
//				// 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
//				operator[i]++;
//			}
//		}
//	}
}
