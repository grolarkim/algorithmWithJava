package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {
	static int N;
	static ArrayList<int[]>[] graph;
	static boolean[] visited;
	static int dis;
	static int max;
	static int far;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<int[]>();
		}
		visited = new boolean[N + 1];
		StringTokenizer st;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			int[] yw = { y, w };
			int[] xw = { x, w };

			graph[x].add(yw);
			graph[y].add(xw);
		}
		if (N == 1) {
			System.out.println(0);
			return;
		}

		dis = 0;
		max = 0;
		far = -1;

		visited[1] = true;
		dfs(1);

		dis = 0;
		max = 0;
		visited = new boolean[N + 1];
		visited[far] = true;
		dfs(far);

		System.out.println(max);

	}

	static void dfs(int x) {
		boolean end = true;

		for (int[] arr : graph[x]) {
			int y = arr[0];
			int w = arr[1];

			if (!visited[y]) {
				end = false;
				dis += w;
				visited[y] = true;
				dfs(y);
				dis -= w;
				visited[y] = false;
			}
		}

		if (end) {
			if (dis > max) {
				max = dis;
				far = x;
			}
			return;
		}
	}
}
