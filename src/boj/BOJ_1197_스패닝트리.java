package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_스패닝트리 {
	static int V;
	static int E;
	static PriorityQueue<Edge> pq;
	static int[] parents;
	static int dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		makeSet();
		kruskal();

		System.out.println(dis);
	}

	static void makeSet() {
		parents = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
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

	static void kruskal() {
		dis = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			boolean u = union(e.from, e.to);
			if (u) {
				dis += e.weight;
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		public int from;
		public int to;
		public int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}
}
