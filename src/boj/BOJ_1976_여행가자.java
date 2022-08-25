package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
	static int N;
	static int M;
	static int[][] map;
	static int[] cities;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		cities = new int[M];
		for (int i = 0; i < M; i++) {
			cities[i] = Integer.parseInt(st.nextToken());
		}
		parents = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			makeSet(i);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1) {
					union(i, j);
				}
			}
		}

//		System.out.println(Arrays.toString(parents));

		int root = findRoot(cities[0]);
		for (int i : cities) {
			if (findRoot(i) != root) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}

	static void makeSet(int x) {
		parents[x] = x;
	}

	static int findRoot(int x) {
		if (x == parents[x]) {
			return x;
		} else {
			return parents[x] = findRoot(parents[x]);
		}
	}

	static void union(int x, int y) {
		int rx = findRoot(x);
		int ry = findRoot(y);

		if (rx == ry) {
			return;
		} else if (rx < ry) {
			parents[ry] = rx;
		} else {
			parents[rx] = ry;
		}
	}
}
