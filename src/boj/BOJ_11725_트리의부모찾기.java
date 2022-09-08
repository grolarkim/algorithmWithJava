package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<>());
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		int[] result = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			List<Integer> list = graph.get(now);
			for (int i : list) {
				if (!visited[i]) {
					result[i] = now;
					visited[i] = true;
					q.offer(i);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(result[i]).append('\n');
		}
		System.out.print(sb.toString());

	}
}
