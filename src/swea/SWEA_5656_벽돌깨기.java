package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5656_벽돌깨기 {
	static int T, N, W, H;
	static int[][] tbl;
	static int min;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			min = Integer.MAX_VALUE;
			tbl = new int[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					tbl[i][j] = sc.nextInt();
				}
			}

			// W^N DFS완전탐색
			for (int i = 0; i < W; i++) {
				dfs(i, 0, tbl);
			}

			System.out.println("#" + tc + " " + min);
		}
		sc.close();
	}

	private static void dfs(int target, int depth, int[][] map) {
		// 기저조건 도달 시 남은 블록 개수 세기 (DFS에서 중복으로 세는 대신 처음 한번만 셈)
		if (depth == N) {
			if (target == 0) {
				min = Math.min(min, countBlock(map));
			}
			return;
		}

		// 테이블 복사
		int[][] nextMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				nextMap[i][j] = map[i][j];
			}
		}

		// 블록부수기
		nextMap = simulateBFS(target, nextMap);
		// 부순뒤 블록 떨어짐
		nextMap = blockFall(nextMap);

		// 다음 블록으로 DFS
		for (int i = 0; i < W; i++) {
			dfs(i, depth + 1, nextMap);
		}
	}

	private static int[][] blockFall(int[][] map) {
		for (int j = 0; j < W; j++) {
			// 블록들을 큐에 넣었다가 뺴면서 아래로 옮김
			Queue<Integer> q = new LinkedList<>();
			for (int i = H - 1; i >= 0; i--) {
				if (map[i][j] != 0) {
					q.add(map[i][j]);
					map[i][j] = 0;
				}
			}
			int i = H - 1;
			while (!q.isEmpty()) {
				map[i][j] = q.poll();
				i--;
			}
		}
		return map;
	}

	private static int[][] simulateBFS(int y, int[][] map) {
		Queue<int[]> q = new LinkedList<int[]>();
		// 첫블록 큐에 넣기
		int x = 0;
		while (x < H) {
			if (map[x][y] != 0) {
				q.offer(new int[] { x, y, map[x][y] });
				map[x][y] = 0;
				break;
			}
			x++;
		}

		while (!q.isEmpty()) {
			int[] xy = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				for (int i = 0; i < xy[2]; i++) {
					int nx = xy[0] + dx[dir] * i;
					int ny = xy[1] + dy[dir] * i;

					if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
						continue;
					}

					// 블록이 있으면 큐에 넣기
					if (map[nx][ny] != 0) {
						q.offer(new int[] { nx, ny, map[nx][ny] });
						map[nx][ny] = 0;
					}
				}
			}
		}

		return map;
	}

	private static int countBlock(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
