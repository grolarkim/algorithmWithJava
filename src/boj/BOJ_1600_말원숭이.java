package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말원숭이 {
	static int K;
	static int W;
	static int H;
	static int[][] map;
	static boolean[][][] steps;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		steps = new boolean[H][W][31];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
	}

	public static void bfs() {
		int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1, 2, 2, -2, -2 };
		int[] dy = { 0, 0, 1, -1, 2, -2, 2, -2, 1, -1, 1, -1 };

		Queue<Node> q = new LinkedList<>();
		Node start = new Node(0, 0, 0, K);
		q.offer(start);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int step = cur.step;
			int horse = cur.horse;
			if (steps[x][y][horse]) {
				continue;
			}
			steps[x][y][horse] = true;

			if (x == H - 1 && y == W - 1) {
				System.out.println(step);
				return;
			}

			int direction = 4;
			if (horse != 0) {
				direction = 12;
			}
			for (int i = 0; i < direction; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nextHorse = horse;
				if (i >= 4) {
					nextHorse -= 1;
				}
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0 && !(steps[nx][ny][nextHorse])) {
					Node next = new Node(nx, ny, step + 1, nextHorse);
					q.offer(next);
				}
			}

		}
		System.out.println(-1);
		return;
	}

	public static class Node {
		int x;
		int y;
		int step;
		int horse;

		public Node(int x, int y, int step, int horse) {
			super();
			this.x = x;
			this.y = y;
			this.step = step;
			this.horse = horse;
		}
	}
}
