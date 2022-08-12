package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	static int N;
	static int K;
	static int[] w;
	static int[] v;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		w = new int[N];
		v = new int[N];
		map = new int[N][K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		dp();
		System.out.println(map[N - 1][K]);
	}

	static void dp() {
		for (int j = 0; j <= K; j++) {
			if (j >= w[0]) {
				map[0][j] = v[0];
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				if (j < w[i]) {
					map[i][j] = map[i - 1][j];
				} else {
					map[i][j] = Math.max(map[i - 1][j], map[i - 1][j - w[i]] + v[i]);
				}
			}
		}
	}
}
