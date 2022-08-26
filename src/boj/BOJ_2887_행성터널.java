package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2887_행성터널 {
	static int N;
	static int[][] planets;
	static PriorityQueue<Planet> pq;
	static int[] parents;
	static int k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		pq = new PriorityQueue<>();
		planets = new int[N][4];
		parents = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 4; j++) {
				planets[i][j] = Integer.parseInt(st.nextToken());
			}
			planets[i][0] = i;
		}

		for (k = 1; k < 4; k++) {
			Arrays.sort(planets, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[k] - o2[k];
				}
			});

			for (int i = 1; i < N; i++) {
				int distance = Math.abs(planets[i - 1][k] - planets[i][k]);
				pq.add(new Planet(planets[i - 1][0], planets[i][0], distance));
			}
		}

		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}

		int result = kruskal();

		System.out.println(result);
	}

	static int kruskal() {
		int result = 0;
		while (!pq.isEmpty()) {
			Planet p = pq.poll();
			if (union(p.from, p.to)) {
				result += p.distance;
			}

		}
		return result;
	}

	static int findRoot(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = findRoot(parents[x]);
	}

	static boolean union(int x, int y) {
		int rx = findRoot(x);
		int ry = findRoot(y);

		if (rx == ry) {
			return false;
		}
		if (rx < ry) {
			parents[ry] = rx;
		} else {
			parents[rx] = ry;
		}
		return true;
	}

	public static class Planet implements Comparable<Planet> {
		public int from;
		public int to;
		public int distance;

		public Planet(int from, int to, int distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Planet o) {
			return Integer.compare(this.distance, o.distance);
		}

	}
}
