package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_NM1 {
	public static int N;
	public static int M;
	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N + 1];

		dfs(0);
		System.out.println(sb);

	}

	public static void dfs(int i) {
		if (i == M) {
			for (int j : arr) {
				sb.append(j).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int j = 1; j <= N; j++) {
			if (!visited[j]) {
				visited[j] = true;
				arr[i] = j;
				dfs(i + 1);
				visited[j] = false;
			}
		}

	}

}
