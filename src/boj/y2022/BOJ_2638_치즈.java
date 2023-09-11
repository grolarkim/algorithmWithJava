package boj.y2022;

import java.util.*;

public class BOJ_2638_치즈 {
	static int N;
	static int M;
	static int[][] table;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int result;
	static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		table = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				table[i][j] = sc.nextInt();
			}
		}
		sc.close();

		simulate();
		System.out.println(result);
	}

	static void simulate() {
		list = new ArrayList<Integer>();
		bfs(0, 0);

		result = 0;
		list = new ArrayList<Integer>();
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				if (table[i][j] == 1) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (table[nx][ny] == 2) {
							cnt++;
						}
					}
					if (cnt >= 2) {
						list.add(i);
						list.add(j);
					}
				}

			}
		}

		while (true) {
			for (int i = 0; i < list.size(); i += 2) {
				int x = list.get(i);
				int y = list.get(i + 1);
				table[x][y] = 2;
			}

			for (int i = 0; i < list.size(); i += 2) {
				int x = list.get(i);
				int y = list.get(i + 1);
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					if (table[nx][ny] == 0) {
						bfs(nx, ny);
					}
				}
			}

			List<Integer> newList = new ArrayList<Integer>();
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (table[i][j] == 1) {
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];

							if (table[nx][ny] == 2) {
								cnt++;
							}
						}
						if (cnt >= 2) {
							newList.add(i);
							newList.add(j);
						}
					}

				}
			}

			if (list.size() == 0) {
				break;
			}

			result++;
			list = newList;
		}

	}

	private static void bfs(int r, int c) {
		visited = new boolean[N][M];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(r);
		q.offer(c);
		visited[r][c] = true;
		table[r][c] = 2;

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == false && table[nx][ny] == 0) {
					visited[nx][ny] = true;
					table[nx][ny] = 2;
					q.offer(nx);
					q.offer(ny);
					list.add(nx);
					list.add(ny);
				}

			}
		}
	}

	public static void printTable() {
		for (int[] t : table) {
			System.out.println(Arrays.toString(t));
		}
		System.out.println();
	}
}
