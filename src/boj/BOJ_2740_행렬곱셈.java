package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2740_행렬곱셈 {
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] a = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] b = new int[M][K];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < K; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();

		int[][] result = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				int sum = 0;
				for (int k = 0; k < M; k++) {
					sum += a[i][k] * b[k][j];
				}
				result[i][j] = sum;
				sb.append(sum);
				sb.append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());

	}
}
