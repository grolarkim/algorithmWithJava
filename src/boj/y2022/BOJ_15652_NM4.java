package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_NM4 {
	public static int N;
	public static int M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		dfs(1, 0);
		System.out.println(sb);

	}

	public static void dfs(int now, int depth) {
		if (depth == M) {
			for (int i : arr) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = now; i <= N; i++) {
			arr[depth] = i;
			dfs(i, depth+1);
		}
	}
}
