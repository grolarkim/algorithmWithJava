package boj.y2022;

import java.util.Scanner;

public class BOJ_4963_섬의개수 {
	static int W, H;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;

	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();

			if (H == 0 && W == 0) {
				break;
			}

			map = new int[H][W];
			visited = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			cnt = 0;
			
			// 이중포문을 돌면서 세지 않은 땅이 있으면 이어진 땅 탐색 후 섬의 개수 추가
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
		sc.close();
	}

	private static void dfs(int x, int y) {
		for(int i = 0;i<8;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx < 0 || ny < 0 || nx >= H || ny >= W) {
				continue;
			}
			
			if(map[nx][ny] == 1 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx,ny);
			}
		}
	}
}
