package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {
	static int N;
	static double[][] stars;
	static double[][] dis;
	static PriorityQueue<Star> pq;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		stars = new double[N][2];
		dis = new double[N][N];
		pq = new PriorityQueue<>();
		parents = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			stars[i][0] = a;
			stars[i][1] = b;
			for (int j = 0; j < i; j++) {
				double distance = Math.sqrt((stars[j][0] - stars[i][0]) * (stars[j][0] - stars[i][0])
						+ (stars[j][1] - stars[i][1]) * (stars[j][1] - stars[i][1]));
				pq.add(new Star(i, j, distance));
			}
		}

		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}

		double result = kruskal();

		System.out.printf("%.2f\n", result);
	}

	public static double kruskal() {
		double result = 0;
		while (!pq.isEmpty()) {
			Star s = pq.poll();
			if (union(s.from, s.to)) {
				result += s.distance;
			}
		}
		return result;
	}

	public static int findRoot(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = findRoot(parents[x]);
	}

	public static boolean union(int x, int y) {
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

	public static class Star implements Comparable<Star> {
		public int from;
		public int to;
		public double distance;

		public Star(int from, int to, double distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Star o) {
			return Double.compare(this.distance, o.distance);
		}

	}
}
