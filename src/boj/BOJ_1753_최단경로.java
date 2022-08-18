package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] arr = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			arr[i] = new ArrayList<Edge>();
		}
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[x].add(new Edge(y, w));
		}

		int[] distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;
		PriorityQueue<Edge> q = new PriorityQueue<>();

		q.offer(new Edge(start, 0));

		while (!q.isEmpty()) {
			Edge e = q.poll();

			if (distance[e.y] < e.w)
				continue;

			for (Edge ne : arr[e.y]) {
				if (distance[ne.y] > ne.w + e.w) {
					distance[ne.y] = ne.w + e.w;
					q.offer(new Edge(ne.y, e.w + ne.w));
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (distance[i] != Integer.MAX_VALUE) {
				sb.append(distance[i]).append('\n');
			} else {
				sb.append("INF").append('\n');
			}
		}

		System.out.print(sb.toString());

	}
}

class Edge implements Comparable<Edge> {
	public int y;
	public int w;

	public Edge(int y, int w) {
		super();
		this.y = y;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.w, o.w);
	}

}