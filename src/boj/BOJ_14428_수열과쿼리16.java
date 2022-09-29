package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14428_수열과쿼리16 {
	static int N, M;
	static int[] arr;
	static int[][] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		tree = new int[4 * N][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		treeInit(1, N, 1);

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				arr[b] = c;
				update(1, N, 1, b, c);
			} else {
				bw.write(getMinIdx(1, N, 1, b, c)[0] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int[] treeInit(int left, int right, int node) {
		if (left == right) {
			return tree[node] = new int[] { left, arr[left] };
		}

		int mid = (left + right) / 2;
		int[] l = treeInit(left, mid, node * 2);
		int[] r = treeInit(mid + 1, right, node * 2 + 1);

		return tree[node] = getMinArr(l, r);
	}

	private static int[] update(int left, int right, int node, int idx, int target) {
		if (idx < left || right < idx) {
			return tree[node];
		}

		if (left == right) {
			return tree[node] = new int[] { idx, target };
		}

		int mid = (left + right) / 2;
		int[] l = update(left, mid, node * 2, idx, target);
		int[] r = update(mid + 1, right, node * 2 + 1, idx, target);

		return tree[node] = getMinArr(l, r);
	}

	private static int[] getMinIdx(int left, int right, int node, int startIdx, int endIdx) {
		if (right < startIdx || endIdx < left) {
			return new int[] { -1, Integer.MAX_VALUE };
		}

		if (startIdx <= left && right <= endIdx) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int[] l = getMinIdx(left, mid, node * 2, startIdx, endIdx);
		int[] r = getMinIdx(mid + 1, right, node * 2 + 1, startIdx, endIdx);

		return getMinArr(l, r);
	}

	private static int[] getMinArr(int[] l, int[] r) {
		int[] result = new int[2];
		if (l[1] < r[1]) {
			result[0] = l[0];
			result[1] = l[1];
		} else if (r[1] < l[1]) {
			result[0] = r[0];
			result[1] = r[1];
		} else if (l[1] == r[1] && l[0] < r[0]) {
			result[0] = l[0];
			result[1] = l[1];
		} else {
			result[0] = r[0];
			result[1] = r[1];
		}
		return result;
	}

}
