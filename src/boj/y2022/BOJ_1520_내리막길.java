package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {
	public static int[][] matrix;
	public static int[][] dp;
	public static int M;
	public static int N;
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };
	public static HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		matrix = new int[M][N];
		dp = new int[M][N];
		dp[0][0] = 1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				int[] temp = { i, j };
				if (!map.containsKey(matrix[i][j])) {
					map.put(matrix[i][j], new ArrayList<int[]>());
				}
				map.get(matrix[i][j]).add(temp);
			}
		}

		dfs();
		System.out.println(dp[M - 1][N - 1]);
	}

	public static void dfs() {
		for (int h = matrix[0][0]; h > 0; h--) {
			if (map.containsKey(h)) {
				ArrayList<int[]> list = map.get(h);
				for (int[] a : list) {
					int x = a[0];
					int y = a[1];
					if (dp[x][y] != 0) {
						for (int i = 0; i < 4; i++) {
							if (x + dx[i] >= 0 && x + dx[i] < M && y + dy[i] >= 0 && y + dy[i] < N
									&& matrix[x][y] > matrix[x + dx[i]][y + dy[i]]) {
								dp[x + dx[i]][y + dy[i]] += dp[x][y];
							}
						}
					}

				}
			}
		}

	}
}
