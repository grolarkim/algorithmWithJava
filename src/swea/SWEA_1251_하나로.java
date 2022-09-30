package swea;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1251_하나로 {
	static int T, N;
	static double[][] islands;
	static double E;
	static double[][] graph;
	static int[] parent;
	static double result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			islands = new double[N][2];
			// 첫줄 X
			for (int i = 0; i < N; i++) {
				islands[i][0] = sc.nextDouble();
			}
			// 두번째 줄 Y
			for (int i = 0; i < N; i++) {
				islands[i][1] = sc.nextDouble();
			}
			// 세율
			E = sc.nextDouble();

			// 인접 행렬 초기화
			graph = new double[N][N];
			getGraph();

			result = 0;
			// 서로소집합 초기화
			parent = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			kruskal();

			System.out.printf("#%d %d", tc, Math.round(result)).println();
		}
		sc.close();
	}

	private static void getGraph() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					// c^2 = a^2+b^2 여기서 더블이 아니면 오버플로우일어남
					graph[i][j] = (islands[i][0] - islands[j][0]) * (islands[i][0] - islands[j][0])
							+ (islands[i][1] - islands[j][1]) * (islands[i][1] - islands[j][1]);
				}
			}
		}

	}

	private static void kruskal() {
		// 거리 기준 우선순위 큐
		PriorityQueue<Edges> pq = new PriorityQueue<>();
		// 양방향 그래프이므로 인접 행렬의 절반만 사용해도 된다
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				pq.add(new Edges(i, j, graph[i][j]));
			}
		}

		double sum = 0;

		while (!pq.isEmpty()) {
			Edges e = pq.poll();
			// 합쳐지는 경우에만 거리 더함
			if (union(e.from, e.to)) {
				sum += e.dis;
			}
		}

		result = sum * E;

	}

	private static boolean union(int from, int to) {
		// 두 입력의 부모
		int pF = findParent(from);
		int pT = findParent(to);

		// 이미 하나의 set이면 false 반환
		if (pF == pT)
			return false;
		// union by rank - 부모 중 숫자가 작은 쪽으로 합침
		if (pF < pT) {
			parent[pT] = pF;
		} else {
			parent[pF] = pT;
		}

		// 합쳐졌다는 의미로 true 반환
		return true;
	}

	private static int findParent(int x) {
		if (parent[x] == x) {
			return x;
		}
		// path compression - 경로 압축
		return parent[x] = findParent(parent[x]);
	}

	public static class Edges implements Comparable<Edges> {
		int from;
		int to;
		double dis;

		public Edges(int from, int to, double dis) {
			this.from = from;
			this.to = to;
			this.dis = dis;
		}

		@Override
		public int compareTo(Edges o) {
			return Double.compare(this.dis, o.dis);
		}
	}
}
