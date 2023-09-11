package boj.y2022;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2098_외판원순회 {
	static int N;
	static int[][] tbl;
	static int[][] dp;
	static final int INF = 100000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tbl = new int[N][N];
		dp = new int[1 << (N)][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tbl[i][j] = sc.nextInt();
			}
		}

		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}

		int result = getDp(1, 0);

		System.out.println(result);
	}

	private static int getDp(int bit, int idx) {
		if (bit == (1 << N) - 1) {
			return tbl[idx][0] == 0 ? INF : tbl[idx][0];
		}
		if (dp[bit][idx] != -1)
			return dp[bit][idx];
		dp[bit][idx] = INF;

		for (int i = 0; i < N; i++) {
			if ((bit & 1 << i) == 0 && tbl[idx][i] != 0) {
				dp[bit][idx] = Math.min(dp[bit][idx], getDp(bit | (1 << i), i) + tbl[idx][i]);
			}
		}

		return dp[bit][idx];
	}

}
