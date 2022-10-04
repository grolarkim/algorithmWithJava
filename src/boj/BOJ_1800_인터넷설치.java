package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1800_인터넷설치 {
	static int N, P, K;
	static List<List<Edge>> graph;
	static int[] costs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new ArrayList<List<Edge>>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}

		costs = new int[N + 1];

		int left = 0;
		int right = 1000001;
		int result = Integer.MAX_VALUE;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (dijkstra(mid)) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}

		System.out.println(result);

	}

	private static boolean dijkstra(int mid) {
		Arrays.fill(costs, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		costs[1] = 0;

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int now = e.to;
			int cost = e.cost;

			if (costs[now] < cost) {
				continue;
			}

			for (Edge ne : graph.get(now)) {
				int next = ne.to;
				int nextCost = ne.cost > mid ? cost + 1 : cost;

				if (costs[next] > nextCost) {
					costs[next] = nextCost;
					pq.offer(new Edge(next, nextCost));
				}
			}

		}

		return costs[N] <= K;
	}

	static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}
}
