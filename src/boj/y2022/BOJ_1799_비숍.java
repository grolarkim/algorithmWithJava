package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1799_비숍 {
	static int N;
	static int[][] table;
	static boolean[][] possible;
	static int result1 = 0;
	static int result2 = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfsB(0, 0, 0);
		dfsW(0, 1, 0);
		System.out.println(result1+result2);

	}

	static void dfsB(int x, int y, int bishops) {
		if (x >= N) {
			result1 = Math.max(result1, bishops);
			return;
		}

		if (y >= N) {
			dfsB(x + 1, (x+1)%2, bishops);
			return;
		}

		if (isPossible(x, y)) {
			table[x][y] = 2;
			dfsB(x, y + 2, bishops + 1);
			table[x][y] = 1;
		}
		dfsB(x, y + 2, bishops);

	}

	static void dfsW(int x, int y, int bishops) {
		if (x >= N) {
			result2 = Math.max(result2, bishops);
			return;
		}
		
		if (y >= N) {
			dfsW(x + 1, x%2, bishops);
			return;
		}
		
		if (isPossible(x, y)) {
			table[x][y] = 2;
			dfsW(x, y + 2, bishops + 1);
			table[x][y] = 1;
		}
		dfsW(x, y + 2, bishops);
		
	}

	static boolean isPossible(int x, int y) {
		if (table[x][y] == 0) {
			return false;
		}

		int[] dx = { 1, 1, -1, -1 };
		int[] dy = { -1, 1, -1, 1 };
		for (int i = 0; i < 4; i++) {
			int cnt = 0;
			while (true) {
				int nx = x + dx[i] * cnt;
				int ny = y + dy[i] * cnt;
				if (nx >= N || nx < 0 || ny >= N || ny < 0) {
					break;
				}
				if (table[nx][ny] == 2) {
					return false;
				}
				cnt++;
			}
		}
		return true;
	}

}
