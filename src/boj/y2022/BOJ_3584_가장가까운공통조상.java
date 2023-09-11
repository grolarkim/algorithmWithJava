package boj.y2022;

import java.io.*;
import java.util.*;

public class BOJ_3584_가장가까운공통조상 {
	static int N;
	static List<List<Integer>> lists;
	static int[] parents;
	static int[] depth;
	static int root;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			lists = new ArrayList<List<Integer>>();
			for (int i = 0; i <= N; i++) {
				lists.add(new ArrayList<Integer>());
			}
			parents = new int[N + 1];
			depth = new int[N + 1];

			StringTokenizer st;
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				lists.get(a).add(b);
				parents[b] = a;
			}

			getRoot();
			getDepth(root, 0);

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			getLCA(a, b);

			System.out.println(result);
		}

	}

	private static void getLCA(int a, int b) {
		if (depth[a] > depth[b]) {
			int aa = getParent(a, depth[a] - depth[b]);
			getLCA(aa, b);
		} else if (depth[a] < depth[b]) {
			int bb = getParent(b, depth[b] - depth[a]);
			getLCA(a, bb);
		} else if (a == b) {
			result = a;
		} else {
			getLCA(parents[a], parents[b]);
		}
	}

	private static int getParent(int a, int dep) {
		if (dep == 1) {
			return parents[a];
		}
		return getParent(parents[a], dep - 1);
	}

	private static void getDepth(int idx, int dep) {
		depth[idx] = dep;
		for (int child : lists.get(idx)) {
			getDepth(child, dep + 1);
		}
	}

	private static void getRoot() {
		for (int i = 1; i <= N; i++) {
			if (parents[i] == 0) {
				root = i;
			}
		}
	}
}
