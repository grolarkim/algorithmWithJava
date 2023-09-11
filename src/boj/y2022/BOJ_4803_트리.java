package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_4803_트리 {
	static int N;
	static int M;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		while (true) {
			tc++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) {
				break;
			}

			graph = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			visited = new boolean[N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				graph[to].add(from);
			}

			cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					search(i);
				}
			}

			if (cnt == 0) {
				System.out.printf("Case %d: No trees.", tc).println();
			} else if (cnt == 1) {
				System.out.printf("Case %d: There is one tree.", tc).println();
			} else {
				System.out.printf("Case %d: A forest of %d trees.", tc, cnt).println();
			}

		}

	}

	static void search(int root) {
		Stack<Edge4803> stack = new Stack<>();
		boolean isTree = true;

		visited[root] = true;
		for (int a : graph[root]) {
			stack.push(new Edge4803(root, a));
			visited[a] = true;
		}

		while (!stack.isEmpty()) {
			Edge4803 now = stack.pop();
			for (int a : graph[now.c]) {
				if (!visited[a]) {
					stack.push(new Edge4803(now.c, a));
					visited[a] = true;
				} else if (a != now.p) {
					isTree = false;
				}
			}

		}

		if (isTree) {
			cnt++;
		}
	}
}

class Edge4803 {
	public int p;
	public int c;

	public Edge4803(int p, int c) {
		super();
		this.p = p;
		this.c = c;
	}

}
