package boj.y2022;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502_연구소 {
	static int N;
	static int M;
	static int[][] table;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		table = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				table[i][j] = sc.nextInt();
			}
		}
		sc.close();
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int depth) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		if (depth == 3) {
			int[][] copy = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(table[i], 0, copy[i], 0, M);
			}
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy[i][j] == 2) {
						q.offer(i);
						q.offer(j);
					}
				}
			}

			while (!q.isEmpty()) {
				int x = q.poll();
				int y = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx >= 0 && nx < N && ny >= 0 && ny < M && copy[nx][ny] == 0) {
						q.offer(nx);
						q.offer(ny);
						copy[nx][ny] = 2;
					}

				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy[i][j] == 0) {
						cnt++;
					}
				}
			}
			max = Math.max(cnt, max);
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (table[i][j] == 0) {
					table[i][j] = 1;
					dfs(depth + 1);
					table[i][j] = 0;
				}
			}
		}
	}
}
