package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름 {
	static int N;
	static ArrayList<Node1167>[] graph;
	static boolean[] visited;
	static int max;
	static int far;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node1167>();
		}
		visited = new boolean[N + 1];
		StringTokenizer st;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int cnt = st.countTokens()/2;
			for(int j = 0;j<cnt;j++) {
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				Node1167 yw = new Node1167(to, weight);
				graph[from].add(yw);
			}
		}

		max = 0;
		far = -1;
		visited[1] = true;
		dfs(1, 0);

		max = 0;
		visited = new boolean[N + 1];
		visited[far] = true;
		dfs(far, 0);

		System.out.println(max);

	}

	static void dfs(int x, int dis) {
		if (dis > max) {
			max = dis;
			far = x;
		}

		for (Node1167 arr : graph[x]) {
			int y = arr.y;
			int w = arr.w;

			if (!visited[y]) {
				visited[y] = true;
				dfs(y, dis+w);
			}
		}

	}
}

class Node1167 {
	int y;
	int w;
	public Node1167(int y, int w) {
		super();
		this.y = y;
		this.w = w;
	}
}
