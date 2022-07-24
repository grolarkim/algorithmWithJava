package boj;

import java.util.Scanner;

public class BOJ_10986_나머지합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] remains = new long[M];
		long sum = 0;
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			sum += sc.nextInt();
			remains[(int) (sum % M)] += 1;
		}
		sc.close();
		for(long re : remains) {
			cnt += (re-1)*re/2;
		}
		cnt += remains[0];
		System.out.println(cnt);

	}
}
