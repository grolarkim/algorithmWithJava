package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_17472_다리만들기2 {
	static int N, M;
	static int[][] tbl;
	static int islandIdx;
	static int[][] graph;
	static int[] parent;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		tbl = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tbl[i][j] = sc.nextInt();
			}
		}

		sc.close();

		// 섬 탐색
		islandIdx = 2; // 0과 1은 기존 테이블에 사용됨
		searchIslands();

		// 그래프 생성
		graph = new int[islandIdx][islandIdx];
		for (int[] g : graph) {
			Arrays.fill(g, Integer.MAX_VALUE);
		}
		getGraph();

		// 크루스칼
		int result = kruskal();

		System.out.println(result);

	}

	private static void searchIslands() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tbl[i][j] == 1) {
					tbl[i][j] = islandIdx;
					dfs(i, j);
					islandIdx++;
				}
			}
		}
	}

	private static void dfs(int x, int y) {
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			if (tbl[nx][ny] == 1) {
				tbl[nx][ny] = islandIdx;
				dfs(nx, ny);
			}
		}
	}

	private static void getGraph() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tbl[i][j] != 0) {
					int oIdx = tbl[i][j];
					for (int dir = 0; dir < 4; dir++) {
						int length = 1;
						while (true) {
							int nx = i + dx[dir] * length;
							int ny = j + dy[dir] * length;
							if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
								break;
							}

							int nIdx = tbl[nx][ny];

							if (nIdx != 0) {
								if (length > 2 && oIdx != nIdx) {
									graph[oIdx][nIdx] = Math.min(graph[oIdx][nIdx], length - 1);
									graph[nIdx][oIdx] = Math.min(graph[nIdx][oIdx], length - 1);
								}
								break;
							}
							length++;
						}
					}
				}
			}
		}

	}

	private static int kruskal() {
		parent = new int[islandIdx];
		for (int i = 0; i < islandIdx; i++) {
			parent[i] = i;
		}
		int result = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for (int i = 2; i < islandIdx; i++) {
			for (int j = 2; j < islandIdx; j++) {
				if (graph[i][j] != Integer.MAX_VALUE) {
					pq.offer(new int[] { i, j, graph[i][j] });
				}
			}
		}

		while (!pq.isEmpty()) {
			int[] edge = pq.poll();

			if (union(edge[0], edge[1])) {
				result += edge[2];
			}
		}

		for (int i = 2; i < islandIdx; i++) {
			if (findParent(i) != findParent(2)) {
				return -1;
			}
		}

		return result;
	}

	private static int findParent(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = findParent(parent[x]);
	}

	private static boolean union(int x, int y) {
		int rootX = findParent(x);
		int rootY = findParent(y);
		
		if(rootX == rootY) {
			return false;
		}
		
		if(rootX < rootY) {
			parent[rootY] = rootX;
		} else {
			parent[rootX] = rootY;
		}	
		
		return true;
	}

}
