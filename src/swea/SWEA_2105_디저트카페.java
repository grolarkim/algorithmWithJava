package swea;

import java.util.Scanner;

public class SWEA_2105_디저트카페 {
	static int N;
	static int[][] tbl;
	static boolean[] visited;
	static int max;

	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static int originalX;
	static int originalY;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			tbl = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tbl[i][j] = sc.nextInt();
				}
			}
			max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 디저트카페의 종류
					visited = new boolean[101];
					// 시작점
					originalX = i;
					originalY = j;

					visited[tbl[i][j]] = true;
					dfs(i, j, 0, 0);
					visited[tbl[i][j]] = false;
				}
			}

			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}

	private static void dfs(int x, int y, int depth, int direction) {
		// 기저조건 시작이 아니고 시작점에 돌아왔을때
		if (x == originalX && y == originalY && depth != 0) {
			max = Math.max(max, depth);
			return;
		}

		// 사각형 모양으로 탐색해야하므로 현재방향을 유지하던가 다음 방향으로 바뀌던가 2가지의 경우가 있다
		for (int nextDirection = direction; nextDirection <= direction + 1 && nextDirection < 4; nextDirection++) {
			int nextX = x + dx[nextDirection];
			int nextY = y + dy[nextDirection];

			// 다음 탐색하는 곳이 원점일 때 visited에서 막히므로 따로 처리
			if (nextX == originalX && nextY == originalY) {
				dfs(nextX, nextY, depth + 1, nextDirection);
				continue;
			}

			// 테이블을 벗어날 때
			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				continue;
			}

			// 방문한적 없는 종류의 디저트 카페일때
			if (!visited[tbl[nextX][nextY]]) {
				visited[tbl[nextX][nextY]] = true;
				dfs(nextX, nextY, depth + 1, nextDirection);
				visited[tbl[nextX][nextY]] = false;
			}

		}

	}
}
