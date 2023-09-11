package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {
	static int N;
	static int M;
	static int K;
	static int result = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] operate;
	static boolean[] operated;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		operate = new int[K][3];
		operated = new boolean[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				operate[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(result);

	}

	public static void dfs(int depth) {
		if (depth == K) {
			int min = minValue();
			result = Math.min(min, result);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!operated[i]) {
				rotate(operate[i], true);
				operated[i] = true;

				dfs(depth + 1);

				rotate(operate[i], false);
				operated[i] = false;
			}
		}
	}

	public static int minValue() {
		int min = Integer.MAX_VALUE;
		for (int[] ar : arr) {
			int temp = 0;
			for (int a : ar) {
				temp += a;
			}
			min = Math.min(min, temp);
		}
		return min;
	}

	public static void rotate(int[] rcs, boolean d) {
		int r = rcs[0] - 1;
		int c = rcs[1] - 1;
		int s = rcs[2];

		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		if (d) {
			for (int step = 1; step <= s; step++) {
				for (int i = 0; i < step * 2; i++) {
					temp[r - step][c - step + 1 + i] = arr[r - step][c - step + i];
					temp[r - step + 1 + i][c + step] = arr[r - step + i][c + step];
					temp[r + step][c - step + i] = arr[r + step][c - step + i + 1];
					temp[r - step + i][c - step] = arr[r - step + i + 1][c - step];
				}

			}
		} else {
			for (int step = 1; step <= s; step++) {
				for (int i = 0; i < step * 2; i++) {
					temp[r - step][c - step + i] = arr[r - step][c - step + i + 1];
					temp[r - step + i][c + step] = arr[r - step + i + 1][c + step];
					temp[r + step][c - step + i + 1] = arr[r + step][c - step + i];
					temp[r - step + i + 1][c - step] = arr[r - step + i][c - step];
				}

			}
		}
		arr = temp;

	}
}
