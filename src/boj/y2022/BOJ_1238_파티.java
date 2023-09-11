package boj.y2022;

import java.io.*;
import java.util.*;

public class BOJ_1238_파티 {
	static int N;
	static int M;
	static int X;
	static ArrayList<Road>[] goX;
	static ArrayList<Road>[] comeH;
	static int[] goDis;
	static int[] comeDis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		goX = new ArrayList[N + 1];
		comeH = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			goX[i] = new ArrayList<Road>();
			comeH[i] = new ArrayList<Road>();
		}
		goDis = new int[N + 1];
		comeDis = new int[N + 1];
		Arrays.fill(goDis, Integer.MAX_VALUE);
		Arrays.fill(comeDis, Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			comeH[from].add(new Road(to, cost));
			goX[to].add(new Road(from, cost));
		}

		dijkstra();

		int result = 0;
		for (int i = 1; i <= N; i++) {
			result = Math.max(result, goDis[i] + comeDis[i]);
		}
		System.out.println(result);
	}

	static void dijkstra() {
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.offer(new Road(X, 0));
		comeDis[X] = 0;

		while (!pq.isEmpty()) {
			Road r = pq.poll();

			if (comeDis[r.town] < r.distance) {
				continue;
			}

			for (Road nr : comeH[r.town]) {
				if (comeDis[nr.town] > r.distance + nr.distance) {
					comeDis[nr.town] = r.distance + nr.distance;
					pq.offer(new Road(nr.town, r.distance + nr.distance));
				}
			}
		}

		pq.clear();
		pq.offer(new Road(X, 0));
		goDis[X] = 0;

		while (!pq.isEmpty()) {
			Road r = pq.poll();

			if (goDis[r.town] < r.distance) {
				continue;
			}

			for (Road nr : goX[r.town]) {
				if (goDis[nr.town] > r.distance + nr.distance) {
					goDis[nr.town] = r.distance + nr.distance;
					pq.offer(new Road(nr.town, r.distance + nr.distance));
				}
			}
		}
	}
}

class Road implements Comparable<Road> {
	int town;
	int distance;

	public Road(int town, int distance) {
		super();
		this.town = town;
		this.distance = distance;
	}

	@Override
	public int compareTo(Road o) {
		return this.distance - o.distance;
	}
}
