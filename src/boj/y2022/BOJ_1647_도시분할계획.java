package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
	static int N;
	static int M;

	static int[] parent;
	static PriorityQueue<Node> pq;
	static int max = 0;
	static int distances = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();
		parent = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		kruskal();
		System.out.println(distances - max);
	}

	public static void kruskal() {
		while (!pq.isEmpty()) {
			Node no = pq.poll();
			if (union(no.from, no.to)) {
				distances += no.dis;
				max = Math.max(max, no.dis);
			}
		}

	}

	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static boolean union(int x, int y) {
		int rx = find(x);
		int ry = find(y);

		if (rx == ry) {
			return false;
		} else if (rx < ry) {
			parent[ry] = rx;
		} else {
			parent[rx] = ry;
		}
		return true;
	}

	public static class Node implements Comparable<Node> {
		public int from;
		public int to;
		public int dis;

		public Node(int from, int to, int dis) {
			this.from = from;
			this.to = to;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
	}
}
