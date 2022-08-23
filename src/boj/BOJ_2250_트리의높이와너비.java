package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2250_트리의높이와너비 {
	static int N;
	static int[][] tree;
	static boolean[] notRoot;
	static int[] in;
	static ArrayList<Integer>[] levels;
	static int idx;
	static int level = Integer.MIN_VALUE;
	static int width = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[N + 1][2];
		notRoot = new boolean[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			tree[x][0] = l;
			tree[x][1] = r;
			if (l != -1) {
				notRoot[l] = true;
			}
			if (r != -1) {
				notRoot[r] = true;
			}
		}

		in = new int[N + 1];
		levels = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			levels[i] = new ArrayList<>();
		}

		int root = -1;

		for (int i = 1; i <= N; i++) {
			if (!notRoot[i]) {
				root = i;
				break;
			}
		}

		idx = 1;
		inorder(root, 1);

		getWidth();
		System.out.println(level + " " + width);
	}

	static void getWidth() {
		int maxLevel = 0;
		int maxWidth = 0;

		for (int i = 1; i <= N; i++) {
			int min = N + 1;
			int max = 0;
			for (int j : levels[i]) {
				min = Math.min(min, in[j]);
				max = Math.max(max, in[j]);
			}
			if (max - min + 1 > maxWidth) {
				maxLevel = i;
				maxWidth = max - min + 1;
			}
		}

		level = maxLevel;
		width = maxWidth;

	}

	static void inorder(int x, int depth) {
		if (tree[x][0] != -1) {
			inorder(tree[x][0], depth + 1);
		}

		in[x] = idx++;
		levels[depth].add(x);

		if (tree[x][1] != -1) {
			inorder(tree[x][1], depth + 1);
		}
	}
}
