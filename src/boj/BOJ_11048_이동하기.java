package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048_이동하기 {
	static int N, M;
	static int[][] tbl, dp;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tbl = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tbl[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][M];
		search();

		System.out.println(dp[N - 1][M - 1]);
	}

	private static void search() {
		dp[0][0] = tbl[0][0];
		for (int j = 1; j < M; j++) {
			dp[0][j] = dp[0][j - 1] + tbl[0][j];
		}
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + tbl[i][0];
			for (int j = 1; j < M; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])) + tbl[i][j];
			}
		}

	}

}
