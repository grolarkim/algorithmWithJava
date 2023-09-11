package boj.y2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11438_LCA2 {
	static int N, M;
	static List<List<Integer>> lists;
	static int[][] parents;
	static int[] depths;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		lists = new ArrayList<List<Integer>>();
		for (int i = 0; i <= N; i++) {
			lists.add(new ArrayList<>());
		}
		parents = new int[20][N + 1];
		depths = new int[N + 1];
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lists.get(a).add(b);
			lists.get(b).add(a);
		}

		makeTree(1, -1, 1);

		findAllParents();

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(lca(a, b) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static void makeTree(int cur, int par, int depth) {
		depths[cur] = depth;

		if (lists.get(cur).size() == 1 && cur != 1) {
			return;
		}

		for (int node : lists.get(cur)) {
			if (node != parents[0][cur]) {
				parents[0][node] = cur;
				makeTree(node, cur, depth + 1);
			}
		}
	}

	private static void findAllParents() {
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j <= N; j++) {
				parents[i][j] = parents[i - 1][parents[i - 1][j]];
			}
		}

	}

	private static int lca(int a, int b) {
		if (depths[a] > depths[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		if (depths[a] != depths[b]) {
			for (int i = 19; i >= 0; i--) {
				if (depths[parents[i][b]] >= depths[a]) {
					b = parents[i][b];
				}
			}
		}
		if (a == b)
			return a;
		for (int i = 19; i >= 0; i--) {
			if (parents[i][b] != parents[i][a]) {
				a = parents[i][a];
				b = parents[i][b];
			}
		}

		return parents[0][a];
	}

}
