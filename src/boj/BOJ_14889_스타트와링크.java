package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	public static StringTokenizer st;
	public static int N;
	public static boolean[] arr;
	public static int[][] map;
	public static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr = new boolean[N];
		dfs(0, 0);
		System.out.println(minValue);

	}

	public static void dfs(int idx, int step) {
		if (step == N / 2) {
			getValue();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!arr[i]) {
				arr[i] = true;
				dfs(i + 1, step + 1);
				arr[i] = false;
			}
		}

	}

	public static void getValue() {

		int startTeam = 0;
		int linkTeam = 0;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] && arr[j]) {
					startTeam += map[i][j] + map[j][i];
				} else if (!arr[i] && !arr[j]) {
					linkTeam += map[i][j] + map[j][i];
				}
			}
		}

		int v = Math.abs(startTeam - linkTeam);
		if (v == 0) {
			System.out.println(0);
			System.exit(0);
		}
		minValue = Math.min(v, minValue);
	}

}
