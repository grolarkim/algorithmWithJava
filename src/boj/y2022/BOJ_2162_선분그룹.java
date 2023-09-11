package boj.y2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_2162_선분그룹 {
	static int N;
	static int[][] lines;
	static int[] dSet;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		lines = new int[N][4];
		dSet = new int[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				lines[i][j] = sc.nextInt();
			}
			dSet[i] = i;
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				union(i, j);
			}
		}

		int max = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			int p = parent(i);
			if (map.containsKey(p)) {
				map.put(p, map.get(p) + 1);
			} else {
				map.put(p, 1);
			}
			max = Math.max(map.get(p), max);
		}

		System.out.println(map.size());
		System.out.println(max);
	}

	private static int parent(int x) {
		if (dSet[x] == x) {
			return x;
		}
		return dSet[x] = parent(dSet[x]);
	}

	private static void union(int x, int y) {
		if (cross(x, y)) {
			int rx = parent(x);
			int ry = parent(y);
			if (rx > ry) {
				dSet[rx] = ry;
			} else {
				dSet[ry] = rx;
			}
		}
	}

	private static boolean cross(int x, int y) {
		int a = ccw(lines[x][0], lines[x][1], lines[x][2], lines[x][3], lines[y][0], lines[y][1]);
		int b = ccw(lines[x][0], lines[x][1], lines[x][2], lines[x][3], lines[y][2], lines[y][3]);
		int c = ccw(lines[y][0], lines[y][1], lines[y][2], lines[y][3], lines[x][0], lines[x][1]);
		int d = ccw(lines[y][0], lines[y][1], lines[y][2], lines[y][3], lines[x][2], lines[x][3]);
		if (a * b == 0 && c * d == 0) {
			return overlap(x, y);
		}

		if (a * b <= 0 && c * d <= 0) {
			return true;
		}

		return false;
	}

	private static boolean overlap(int x, int y) {
		if (Math.max(lines[x][0], lines[x][2]) < Math.min(lines[y][0], lines[y][2]))
			return false;
		if (Math.max(lines[y][0], lines[y][2]) < Math.min(lines[x][0], lines[x][2]))
			return false;
		if (Math.max(lines[x][1], lines[x][3]) < Math.min(lines[y][1], lines[y][3]))
			return false;
		if (Math.max(lines[y][1], lines[y][3]) < Math.min(lines[x][1], lines[x][3]))
			return false;

		return true;
	}

	private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
		long a = x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1;
		if (a < 0) {
			return 1;
		} else if (a > 0) {
			return -1;
		}
		return 0;
	}
}
