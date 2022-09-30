package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1249_보급로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] table = new int[N][N];

			String inputs;
			for (int i = 0; i < N; i++) {
				inputs = sc.next();
				for (int j = 0; j < N; j++) {
					table[i][j] = Character.getNumericValue(inputs.charAt(j));
				}
			}

			System.out.println("#" + test_case + " " + bfs(table));
		}
		sc.close();
	}

	public static int bfs(int[][] table) {
		Queue<Integer> queue = new LinkedList<>();
		int result = 0;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int[][] dpTable = new int[table.length][table.length];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				dpTable[i][j] = Integer.MAX_VALUE;
			}
		}
		dpTable[0][0] = 0;
		queue.offer(0);
		queue.offer(0);
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int y = queue.poll();
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] < table.length && x + dx[i] >= 0 && y + dy[i] < table.length && y + dy[i] >= 0) {
					if (dpTable[x + dx[i]][y + dy[i]] > dpTable[x][y] + table[x + dx[i]][y + dy[i]]) {
						dpTable[x + dx[i]][y + dy[i]] = dpTable[x][y] + table[x + dx[i]][y + dy[i]];
						queue.offer(x + dx[i]);
						queue.offer(y + dy[i]);
					}
				}
			}
		}
		result = dpTable[table.length - 1][table.length - 1];
		return result;
	}
}
