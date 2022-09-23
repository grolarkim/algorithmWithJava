package swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SWEA_1767_프로세서 {
	static int T;
	static int N;
	static int[][] table;
	static List<int[]> processors;
	static int[] minArr;
	static int maxConnected;
	static int result;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			table = new int[N][N];
			processors = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
					if (table[i][j] == 1) {
						processors.add(new int[] { i, j });
					}
				}
			}
			minArr = new int[processors.size() + 1];
			Arrays.fill(minArr, Integer.MAX_VALUE);
			maxConnected = 0;

			dfs(0, 0, 0);

			getResult();

			System.out.println("#" + tc + " " + result);

		}
		sc.close();
	}

	private static void getResult() {
		for (int i = minArr.length - 1; i >= 0; i--) {
			if (minArr[i] != Integer.MAX_VALUE) {
				result = minArr[i];
				return;
			}
		}

	}

	private static void dfs(int depth, int sum, int connected) {
		if (depth == processors.size()) {
			minArr[connected] = Math.min(minArr[connected], sum);
			return;
		}

		int[] processor = processors.get(depth);
		int x = processor[0];
		int y = processor[1];

		if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
			dfs(depth + 1, sum, connected + 1);
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			if (isPossible(x, y, dir)) {
				int length = connect(x, y, dir, 2);
				dfs(depth + 1, sum + length, connected + 1);
				connect(x, y, dir, 0);
			} else {
				dfs(depth + 1, sum, connected);
			}
		}

	}

	private static int connect(int x, int y, int dir, int target) {
		int cnt = 0;
		int i = 0;
		while (++i <= N) {
			int nextX = x + dx[dir] * i;
			int nextY = y + dy[dir] * i;

			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				break;
			}

			table[nextX][nextY] = target;
			cnt++;
		}
		return cnt;
	}

	private static boolean isPossible(int x, int y, int dir) {
		int i = 1;
		while (i <= N) {
			int nextX = x + dx[dir] * i;
			int nextY = y + dy[dir] * i;

			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
				break;
			}

			if (table[nextX][nextY] != 0) {
				return false;
			}

			i++;
		}
		return true;
	}

}
