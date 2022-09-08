package boj;

import java.io.*;
import java.util.*;

public class BOJ_1504_특정한최단경로 {
	static int N;
	static int E;
	static int start;
	static int end;
	static ArrayList<Edge1504>[] lists;
	static int v1;
	static int v2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = 1;
		end = N;
		lists = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			lists[i] = new ArrayList<Edge1504>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			lists[from].add(new Edge1504(to, weight));
			lists[to].add(new Edge1504(from, weight));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		int a1 = dijkstra(start, v1);
		int a2 = dijkstra(start, v2);
		int b1 = dijkstra(v1, end);
		int b2 = dijkstra(v2, end);
		int c = dijkstra(v1, v2);

		if (c == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		} else if ((a1 == Integer.MAX_VALUE || b2 == Integer.MAX_VALUE)
				&& (a2 == Integer.MAX_VALUE || b1 == Integer.MAX_VALUE)) {
			System.out.println(-1);
			return;
		}

		System.out.println(Math.min(c + a1 + b2, c + a2 + b1));

	}

	static int dijkstra(int from, int to) {
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		PriorityQueue<Edge1504> pq = new PriorityQueue<>();
		pq.offer(new Edge1504(from, 0));
		distance[from] = 0;

		int result = 0;

		while (!pq.isEmpty()) {
			Edge1504 e = pq.poll();
			if (distance[e.node] < e.weight) {
				continue;
			}

			for (Edge1504 ne : lists[e.node]) {
				if (distance[ne.node] > e.weight + ne.weight) {
					distance[ne.node] = e.weight + ne.weight;
					pq.offer(new Edge1504(ne.node, e.weight + ne.weight));
				}
			}

		}
		result = distance[to];
		return result;
	}
}

class Edge1504 implements Comparable<Edge1504> {
	public int node;
	public int weight;

	public Edge1504(int node, int weight) {
		super();
		this.node = node;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge1504 o) {
		return this.weight - o.weight;
	}

}