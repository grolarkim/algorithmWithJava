package swea;

import java.util.Scanner;

public class SWEA_2806_NQueen {
	static int N;
	static int[][] tbl;
	static boolean[][] check;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			tbl = new int[N][N];
			check = new boolean[N][N];
			cnt = 0;

			search(0);

			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();

	}

	private static void search(int row) {
		if (row == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isPossible(row, i)) {
				tbl[row][i] = 1;
				search(row + 1);
				tbl[row][i] = 0;
			}
		}

	}

	private static boolean isPossible(int row, int col) {
		int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
		int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
		for (int i = 0; i < 8; i++) {
			int j = 0;
			while (j <= N) {
				int nx = row + dx[i] * j;
				int ny = col + dy[i] * j;
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					break;
				}
				if (tbl[nx][ny] == 1) {
					return false;
				}
				j++;
			}
		}
		return true;
	}

}
