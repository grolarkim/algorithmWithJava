package boj.y2022;

import java.util.Scanner;

public class BOJ_2166_다각형의면적 {
	static int N;
	static long[][] arrs;
	static long result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arrs = new long[N + 1][2];
		result = 0;

		for (int i = 0; i < N; i++) {
			arrs[i][0] = sc.nextLong();
			arrs[i][1] = sc.nextLong();
		}
		arrs[N] = arrs[0];
		getResult();

		System.out.printf("%.1f", result / 2.0);

	}

	static void getResult() {
		long r1 = 0;
		long r2 = 0;
		for (int i = 1; i <= N; i++) {
			long x1 = arrs[i - 1][0];
			long y1 = arrs[i - 1][1];
			long x2 = arrs[i][0];
			long y2 = arrs[i][1];

			r1 += x1 * y2;
			r2 += x2 * y1;

		}

		result = Math.abs(r1 - r2);
	}
}
