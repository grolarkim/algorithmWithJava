package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14438_수열과쿼리17 {
	static int N, M;
	static int[] arr;
	static int[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		tree = new int[4 * N];
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
				bw.write(getMin(1, N, 1, b, c) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int treeInit(int left, int right, int node) {
		if (left == right) {
			return tree[node] = arr[left];
		}
		int mid = (left + right) / 2;
		return tree[node] = Math.min(treeInit(left, mid, node * 2), treeInit(mid + 1, right, node * 2 + 1));

	}

	private static int update(int left, int right, int node, int idx, int val) {
		if (idx < left || right < idx) {
			return tree[node];
		}
		if (left == right) {
			return tree[node] = val;
		}

		int mid = (left + right) / 2;
		return tree[node] = Math.min(update(left, mid, node * 2, idx, val),
				update(mid + 1, right, node * 2 + 1, idx, val));

	}

	private static int getMin(int left, int right, int node, int startIdx, int endIdx) {
		if (right < startIdx || endIdx < left) {
			return Integer.MAX_VALUE;
		}

		if (startIdx <= left && right <= endIdx) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		return Math.min(getMin(left, mid, node * 2, startIdx, endIdx),
				getMin(mid + 1, right, node * 2 + 1, startIdx, endIdx));
	}
}
