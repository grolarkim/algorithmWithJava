package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_헌터 {
	static int N;
	static int[][] table;
	static int[][] monster;
	static int[][] customer;

	static boolean[] mon;
	static boolean[] cus;
	static int x;
	static int y;
	static int num;

	static int dis;
	static int minDis;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			table = new int[N + 1][N + 1];
			monster = new int[5][2];
			customer = new int[5][2];
			num = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					table[i][j] = sc.nextInt();
					if (table[i][j] > 0) {
						monster[table[i][j]][0] = i;
						monster[table[i][j]][1] = j;
						num = Math.max(num, table[i][j]);
					} else if (table[i][j] < 0) {
						customer[-table[i][j]][0] = i;
						customer[-table[i][j]][1] = j;
					}
				}
			}

			x = 1;
			y = 1;
			mon = new boolean[5];
			cus = new boolean[5];
			for (int i = 0; i < 5; i++) {
				if (monster[i][0] != 0) {
					mon[i] = true;
				}
			}

			dis = 0;
			minDis = Integer.MAX_VALUE;

			dfs(0);
			System.out.println("#" + tc + " " + minDis);

		}
	}

	static void dfs(int depth) {
		if (depth == num * 2) {
			minDis = Math.min(minDis, dis);
			return;
		}

		for (int i = 1; i <= 4; i++) {
			if (mon[i] == true) {
				mon[i] = false;
				cus[i] = true;
				int d = getDis(1, i);
				dis += d;
				int tx = x;
				int ty = y;
				x = monster[i][0];
				y = monster[i][1];

				dfs(depth + 1);

				mon[i] = true;
				cus[i] = false;
				dis -= d;
				x = tx;
				y = ty;
			}
		}

		for (int i = 1; i <= 4; i++) {
			if (cus[i] == true) {
				cus[i] = false;
				int d = getDis(0, i);
				dis += d;
				int tx = x;
				int ty = y;
				x = customer[i][0];
				y = customer[i][1];

				dfs(depth + 1);
				cus[i] = true;
				dis -= d;
				x = tx;
				y = ty;
			}

		}

	}

	static int getDis(int moncus, int a) {
		int result = 0;
		if (moncus == 1) {
			result += Math.abs(monster[a][0] - x);
			result += Math.abs(monster[a][1] - y);
		} else {
			result += Math.abs(customer[a][0] - x);
			result += Math.abs(customer[a][1] - y);
		}
		return result;
	}
}
