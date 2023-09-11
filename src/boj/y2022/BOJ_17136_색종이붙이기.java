package boj.y2022;

import java.util.Scanner;

public class BOJ_17136_색종이붙이기 {
	static int[][] table = new int[10][10];
	static int[] papers = new int[6];
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				table[i][j] = sc.nextInt();
			}
		}
		sc.close();

		dfs(0, 0, 0);

		if (result == Integer.MAX_VALUE) {
			result = -1;
		}

		System.out.println(result);
	}

	static void dfs(int x, int y, int cnt) {
		int nx = x;
		int ny = y + 1;

		if (x > 9) {
			result = Math.min(cnt, result);
			return;
		}
		if (y == 9) {
			nx = x + 1;
			ny = 0;
		}

		if (cnt >= result) {
			return;
		}

		if (table[x][y] == 1) {
			for (int size = 5; size > 0; size--) {
				if (isPossible(x, y, size)) {
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {
							table[x + i][y + j] = 0;
						}
					}
					papers[size]++;
					dfs(nx, ny, cnt + 1);
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {
							table[x + i][y + j] = 1;
						}
					}
					papers[size]--;
				}
			}
		} else {
			dfs(nx, ny, cnt);

		}

	}

	static boolean isPossible(int x, int y, int size) {
		if (x + size > 10 || y + size > 10) {
			return false;
		}
		if (papers[size] >= 5) {
			return false;
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (table[x + i][y + j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
}
