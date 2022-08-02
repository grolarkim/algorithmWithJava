package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static int N;
	static int M;
	static int[][] map;
	static int r;
	static int c;
	static int d;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean possible = true;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation();

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					result++;
				}
			}
		}
		System.out.println(result);

	}

	public static void simulation() {
		while (possible) {
			sim();
		}

	}

	public static void sim() {
		map[r][c] = 2;
		for (int i = 3; i >= 0; i--) {
			int nr = r + dr[(i + d) % 4];
			int nc = c + dc[(i + d) % 4];
			int nd = (i + d) % 4;
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if (map[nr][nc] == 0) {
					r = nr;
					c = nc;
					d = nd;
					return;
				}
			}
		}
		int nr = r + dr[(d + 2) % 4];
		int nc = c + dc[(d + 2) % 4];
		if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
			r = nr;
			c = nc;
			return;
		} else {
			possible = false;
			return;
		}

	}
}
