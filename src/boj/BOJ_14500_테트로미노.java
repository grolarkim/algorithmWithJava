package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	static int N;
	static int M;
	static int[][] table;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		table = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] x = { 1, 0, 3, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2 };
		int[] y = { 1, 3, 0, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1 };
		int[][] dx = { { 0, 0, 1, 1 }, { 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 0, 1, 2, 1 },
				{ 1, 0, 1, 2 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 }, { 1, 2, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 2, 0 }, { 0, 1, 2, 2 }, { 0, 0, 1, 2 },
				{ 2, 0, 1, 2 },

		};
		int[][] dy = { { 0, 1, 0, 1 }, { 0, 1, 2, 3 }, { 0, 0, 0, 0 }, { 0, 1, 2, 1 }, { 1, 0, 1, 2 }, { 0, 0, 0, 1 },
				{ 0, 1, 1, 1 }, { 0, 1, 1, 2 }, { 1, 2, 0, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 0, 1, 2, 0 },
				{ 0, 1, 2, 2 }, { 0, 0, 1, 2 }, { 2, 0, 1, 2 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 1, 1, 1 },
				{ 0, 1, 1, 1 },

		};

		for (int k = 0; k < 19; k++) {
			for (int i = 0; i < N - x[k]; i++) {
				for (int j = 0; j < M - y[k]; j++) {
					int temp = 0;
					for (int a = 0; a < 4; a++) {
						temp += table[i + dx[k][a]][j + dy[k][a]];
					}
					max = Math.max(max, temp);
				}
			}
		}
		System.out.println(max);

	}

}
