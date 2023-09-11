package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3197_백조의호수 {
	static int R, C;
	static char[][] map;
	static List<int[]> ls;
	static int[][][] parent;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<int[]> now;
	static int day = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		ls = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L')
					ls.add(new int[] { i, j });
			}
		}
		parent = new int[R][C][2];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				parent[i][j][0] = i;
				parent[i][j][1] = j;
			}
		}

		simulate();
		System.out.println(day);
	}

	private static void simulate() {
		now = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 'X' && !visited[i][j]) {
					visited[i][j] = true;
					firstSearch(i, j);
				}
			}
		}

		while (findParent(ls.get(0)) != findParent(ls.get(1))) {
			day++;
			ArrayList<int[]> next = new ArrayList<>();
			for (int[] arr : now) {
				map[arr[0]][arr[1]] = '.';
				for (int dir = 0; dir < 4; dir++) {
					int nx = arr[0] + dx[dir];
					int ny = arr[1] + dy[dir];
					if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
						continue;
					}
					if (map[nx][ny] != 'X') {
						union(arr, new int[] { nx, ny });
					}
					if (map[nx][ny] == 'X' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						next.add(new int[] { nx, ny });
					}
				}
			}
			now = next;
		}

	}

	private static void firstSearch(int x, int y) {
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
				continue;
			}
			if (map[nx][ny] == 'X' && !visited[nx][ny]) {
				visited[nx][ny] = true;
				now.add(new int[] { nx, ny });
			}

			if (map[nx][ny] != 'X' && !visited[nx][ny]) {
				union(new int[] { x, y }, new int[] { nx, ny });
				visited[nx][ny] = true;
				firstSearch(nx, ny);
			}
		}
	}

	static int[] findParent(int[] xy) {
		if (parent[xy[0]][xy[1]][0] == xy[0] && parent[xy[0]][xy[1]][1] == xy[1]) {
			return xy;
		}

		return parent[xy[0]][xy[1]] = findParent(parent[xy[0]][xy[1]]);
	}

	static void union(int[] a1, int[] a2) {
		int[] r1 = findParent(a1);
		int[] r2 = findParent(a2);
		parent[r2[0]][r2[1]] = r1;
	}
}
