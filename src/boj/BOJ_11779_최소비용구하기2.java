package boj;

import java.io.*;
import java.util.*;

public class BOJ_11779_최소비용구하기2 {
	static int N;
	static int M;
	static ArrayList<Bus2>[] buses;
	static int start;
	static int end;
	static int[] costs;
	static int[] froms;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		buses = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			buses[i] = new ArrayList<Bus2>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			buses[from].add(new Bus2(to, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		costs = new int[N + 1];
		froms = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			costs[i] = Integer.MAX_VALUE;
		}

		dijkstra();
		StringBuilder sb = new StringBuilder();
		sb.append(costs[end]).append('\n');

		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		while (true) {
			int a = froms[stack.peek()];
			stack.push(a);
			if (a == start) {
				break;
			}
		}
		int cnt = stack.size();
		sb.append(cnt).append('\n');
		while (!stack.isEmpty()) {
			int a = stack.pop();
			sb.append(a).append(' ');
		}

		System.out.println(sb.toString());

	}

	static void dijkstra() {
		PriorityQueue<Bus2> pq = new PriorityQueue<>();
		pq.offer(new Bus2(start, 0));

		costs[start] = 0;

		while (!pq.isEmpty()) {
			Bus2 b = pq.poll();

			if (costs[b.bus] < b.cost) {
				continue;
			}

			for (Bus2 nb : buses[b.bus]) {
				if (costs[nb.bus] > b.cost + nb.cost) {
					costs[nb.bus] = b.cost + nb.cost;
					froms[nb.bus] = b.bus;
					pq.offer(new Bus2(nb.bus, b.cost + nb.cost));
				}
			}

		}

	}
}

class Bus2 implements Comparable<Bus2> {
	public int bus;
	public int cost;

	public Bus2(int bus, int cost) {
		super();
		this.bus = bus;
		this.cost = cost;
	}

	@Override
	public int compareTo(Bus2 o) {
		return this.cost - o.cost;
	}

}
