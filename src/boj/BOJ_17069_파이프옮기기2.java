package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069_파이프옮기기2 {
	static int N;
	static int[][] table;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };
	static long[][][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());

		table = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new long[N][N][3];
		dp[0][1][0] = 1;
		search();

		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
	}

	private static void search() {
		for (int j = 2; j < N; j++) {
			if (table[0][j] == 0) {
				dp[0][j][0] = dp[0][j - 1][0];
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (table[i][j] == 0) {
					dp[i][j][0] = dp[i][j - 1][1] + dp[i][j - 1][0];
					dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];
				}
				if (table[i][j] == 0 && table[i - 1][j] == 0 && table[i][j - 1] == 0) {
					dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}

	}

}
