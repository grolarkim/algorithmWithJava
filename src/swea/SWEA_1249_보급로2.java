package swea;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1249_보급로2 {
	static int N;
	static int[][] table;
	static int[][] costs;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			table = new int[N][N];
			costs = new int[N][N];

			String inputs;
			for (int i = 0; i < N; i++) {
				inputs = sc.next();
				for (int j = 0; j < N; j++) {
					table[i][j] = Character.getNumericValue(inputs.charAt(j));
				}
			}

			System.out.println("#" + test_case + " " + dijkstra());
		}
		sc.close();

	}

	private static int dijkstra() {
		for(int[] co : costs) Arrays.fill(co, Integer.MAX_VALUE);
		costs[0][0] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int nowX = e.x;
			int nowY = e.y;
			int nowCost = e.cost;
			
			if(costs[nowX][nowY] < nowCost) {
				continue;
			}
			
			for(int dir = 0;dir<4;dir++) {
				int nextX = nowX + dx[dir];
				int nextY = nowY + dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
					continue;
				}
				
				if(costs[nextX][nextY] > nowCost + table[nextX][nextY]) {
					costs[nextX][nextY] = nowCost + table[nextX][nextY];
					pq.offer(new Edge(nextX, nextY, costs[nextX][nextY]));
				}
			}			
		}		
		
		return costs[N-1][N-1];
	}
	
	public static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int cost;
		
		public Edge(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
		
	}
}
