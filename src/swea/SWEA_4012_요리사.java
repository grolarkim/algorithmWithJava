package swea;

import java.util.Scanner;

public class SWEA_4012_요리사 {
	static int N;
	static int[][] tbl;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			tbl = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tbl[i][j] = sc.nextInt();
				}
			}
			visited = new boolean[N];
			min = Integer.MAX_VALUE;

			dfs(0);

			System.out.println("#" + tc + " " + min);
		}
	}

	private static void dfs(int depth) {
		if (depth == N) {
			int cnt = 0;
			for (boolean b : visited) {
				if (b)
					cnt++;
			}
			if (cnt == N / 2) {
				getScore();
			}
			return;
		}

		dfs(depth + 1);
		visited[depth] = true;
		dfs(depth + 1);
		visited[depth] = false;
	}

	private static void getScore() {
		int a = 0;
		int b = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i] && visited[j]) {
					a += tbl[i][j];
				}
				if (!visited[i] && !visited[j]) {
					b += tbl[i][j];
				}
			}
		}
		min = Math.min(min, Math.abs(a - b));
	}
}
