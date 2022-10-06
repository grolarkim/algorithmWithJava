package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {
	static int N, M;
	static int[][] tbl;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		tbl = new int[N + 1][N + 1];
		for (int[] t : tbl) {
			Arrays.fill(t, 1_000_000_000);
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			tbl[a][b] = Math.min(tbl[a][b], c);
		}
		for (int i = 1; i <= N; i++) {
			tbl[i][i] = 0;
		}

		floydWarshall();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (tbl[i][j] == 1_000_000_000) {
					tbl[i][j] = 0;
				}
				bw.write(tbl[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

	private static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (tbl[i][j] > tbl[i][k] + tbl[k][j]) {
						tbl[i][j] = tbl[i][k] + tbl[k][j];
					}
				}
			}
		}
	}
}
