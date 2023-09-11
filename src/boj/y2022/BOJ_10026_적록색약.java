package boj.y2022;

import java.util.Scanner;

public class BOJ_10026_적록색약 {
	static int N;
	static char[][] table;
	static boolean[][] visitedN;
	static boolean[][] visitedB;
	static int normal = 0;
	static int cb = 0;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		table = new char[N][N];
		visitedN = new boolean[N][N];
		visitedB = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			table[i] = sc.next().toCharArray();
		}
		sc.close();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedN[i][j]) {
					dfsN(i, j);
					normal++;
				}
				if (!visitedB[i][j]) {
					dfsB(i, j);
					cb++;
				}
			}
		}

		System.out.println(normal + " " + cb);

	}

	private static void dfsN(int x, int y) {
		char c = table[x][y];
		visitedN[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || table[nx][ny] != c || visitedN[nx][ny]) {
				continue;
			}
			dfsN(nx, ny);
		}

	}

	private static void dfsB(int x, int y) {
		char c = table[x][y];
		visitedB[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || diff(c, table[nx][ny]) || visitedB[nx][ny]) {
				continue;
			}
			dfsB(nx, ny);
		}
	}

	private static boolean diff(char c, char d) {
		if (c == 'R' && d == 'B') {
			return true;
		} else if (c == 'G' && d == 'B') {
			return true;
		} else if (c == 'B' && d != 'B') {
			return true;
		}
		return false;
	}

}
