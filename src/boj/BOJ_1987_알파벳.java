package boj;

import java.util.*;

public class BOJ_1987_알파벳 {
	static int R;
	static int C;
	static char[][] table;
	static boolean[][] visitedTable;
	static boolean[] visitedAlpha = new boolean[26];
	static int result = Integer.MIN_VALUE;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		table = new char[R][C];
		visitedTable = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			table[i] = sc.next().toCharArray();
		}

		visitedTable[0][0] = true;
		visitedAlpha[table[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(result);

	}

	static void dfs(int x, int y, int step) {
		boolean isPossible = false;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < R && ny < C && visitedTable[nx][ny] == false
					&& visitedAlpha[table[nx][ny] - 'A'] == false) {
				isPossible = true;
			}
		}

		if (!isPossible) {
			result = Math.max(result, step);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < R && ny < C && visitedTable[nx][ny] == false
					&& visitedAlpha[table[nx][ny] - 'A'] == false) {
				visitedTable[nx][ny] = true;
				visitedAlpha[table[nx][ny] - 'A'] = true;
				dfs(nx, ny, step + 1);
				visitedTable[nx][ny] = false;
				visitedAlpha[table[nx][ny] - 'A'] = false;
			}
		}
	}
}
