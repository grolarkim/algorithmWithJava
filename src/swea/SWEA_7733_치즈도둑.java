package swea;

import java.util.Scanner;

public class SWEA_7733_치즈도둑 {
	static int T, N;
	static int[][] map;
	static boolean[][] visited;
	static int cntMax;
	static int cnt;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			cntMax = 0;
			
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int k = 0; k <= 100; k++) {
				visited = new boolean[N][N];
				cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && map[i][j] > k) {
							visited[i][j] = true;
							dfs(i, j, k);
							cnt++;
						}
					}
				}
				cntMax = Math.max(cntMax, cnt);
			}

			System.out.println("#" + tc + " " + cntMax);
		}
		sc.close();
	}

	private static void dfs(int x, int y, int day) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			if (!visited[nx][ny] && map[nx][ny] > day) {
				visited[nx][ny] = true;
				dfs(nx, ny, day);
			}
		}

	}
}
