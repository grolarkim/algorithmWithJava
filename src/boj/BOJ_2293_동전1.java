package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2293_동전1 {
	static int N;
	static int K;
	static int[] arr;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		map = new int[N][K + 1];

		dp();

		System.out.println(map[N - 1][K]);

	}

	static void dp() {
		for (int i = 0; i <= K; i++) {
			if (i % arr[0] == 0) {
				map[0][i] = 1;
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				if (j < arr[i]) {
					map[i][j] = map[i - 1][j];
				} else {
					map[i][j] = map[i][j - arr[i]] + map[i - 1][j];
				}
			}
		}

	}

}
