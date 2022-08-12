package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2629_양팔저울 {
	static int N;
	static int[] c;
	static int M;
	static int[] w;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		c = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		w = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		map = new boolean[N][40001];

		dp();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			if (map[N - 1][w[i]]) {
				sb.append('Y').append(' ');
			} else {
				sb.append('N').append(' ');
			}
		}

		System.out.println(sb.toString());
	}

	static void dp() {
		for (int j = 0; j <= 40000; j++) {
			if (j == c[0]) {
				map[0][j] = true;
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= 40000; j++) {
				boolean isPossible = (map[i - 1][j]) || (j == c[i]) || (j + c[i] <= 40000 && map[i - 1][j + c[i]])
						|| (j - c[i] >= 0 && map[i - 1][j - c[i]]) || (c[i] - j >= 0 && map[i - 1][c[i] - j]);
				if (isPossible) {
					map[i][j] = true;
				}
			}
		}

	}
}
