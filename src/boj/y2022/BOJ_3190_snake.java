package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_3190_snake {
	static int N;
	static int[][] map;

	static int d = 0;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static LinkedList<xy> snake = new LinkedList<>();

	static int K;
	static int L;
	static int[] times;
	static char[] directions;
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		L = Integer.parseInt(in.readLine());
		times = new int[L];
		directions = new char[L];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			directions[i] = st.nextToken().charAt(0);
		}

		map[0][0] = 2;
		snake.offer(new xy(0, 0));
		simulation();
		System.out.println(result + 1);

	}

	public static void simulation() {
		int cnt = 0;
		while (result < 10500) {
			xy cur = snake.peekLast();
			if (cnt < L && times[cnt] == result) {
				if (directions[cnt] == 'L') {
					d = (d + 3) % 4;
				} else {
					d = (d + 1) % 4;
				}
				cnt++;
			}

			int nx = cur.x + dx[d];
			int ny = cur.y + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2) {
				return;
			}
			snake.offerLast(new xy(nx, ny));
			if (map[nx][ny] != 1) {
				xy last = snake.pollFirst();
				map[last.x][last.y] = 0;
			}
			map[nx][ny] = 2;

			result++;

		}

	}
}

class xy {
	int x;
	int y;

	xy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
