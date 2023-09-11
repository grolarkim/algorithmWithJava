package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {

	public static int[][][] matrix;
	public static int[] dz = { 0, 0, 0, 0, 1, -1 };
	public static int[] dx = { 1, -1, 0, 0, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		matrix = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < M; k++) {
					matrix[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (matrix[i][j][k] == 1) {
						int[] temp = { i, j, k, 0 };
						q.add(temp);
					}
				}
			}
		}
		int stepMax = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int z = now[0];
			int x = now[1];
			int y = now[2];
			int step = now[3];

			for (int i = 0; i < 6; i++) {
				if (z + dz[i] >= 0 && z + dz[i] < H && x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0
						&& y + dy[i] < M) {
					if (matrix[z + dz[i]][x + dx[i]][y + dy[i]] == 0) {
						int[] temp = { z + dz[i], x + dx[i], y + dy[i], step + 1 };
						q.add(temp);
						matrix[z + dz[i]][x + dx[i]][y + dy[i]] = 1;
						stepMax = Math.max(step + 1, stepMax);
					}
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (matrix[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(stepMax);

	}
}
