package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
	static int N;
	static int E;
	static int start;
	static int end;
	static ArrayList<Bus1916>[] lists;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		lists = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			lists[i] = new ArrayList<Bus1916>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			lists[from].add(new Bus1916(to, cost));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dijkstra();
		System.out.println(result);

	}

	static void dijkstra() {
		int[] costs = new int[N + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);

		PriorityQueue<Bus1916> pq = new PriorityQueue<>();
		pq.offer(new Bus1916(start, 0));
		costs[start] = 0;

		while (!pq.isEmpty()) {
			Bus1916 b = pq.poll();
			if (costs[b.node] < b.cost) {
				continue;
			}

			for (Bus1916 nb : lists[b.node]) {
				if (costs[nb.node] > b.cost + nb.cost) {
					costs[nb.node] = b.cost + nb.cost;
					pq.offer(new Bus1916(nb.node, b.cost + nb.cost));
				}
			}
		}

		result = costs[end];
	}
}

class Bus1916 implements Comparable<Bus1916> {
	int node;
	int cost;

	public Bus1916(int node, int cost) {
		super();
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compareTo(Bus1916 o) {
		return this.cost - o.cost;
	}

}
