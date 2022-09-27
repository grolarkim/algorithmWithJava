package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2357_최소값과최대값 {
	static int N, M;
	static int[] arr, minTree, maxTree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		minTree = new int[N * 4];
		maxTree = new int[N * 4];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		minInit(1, N, 1);
		maxInit(1, N, 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			bw.write(getMin(1, N, 1, a, b) + " " + getMax(1, N, 1, a, b) + "\n");

		}

		bw.flush();
		bw.close();
		br.close();

	}

	private static int minInit(int left, int right, int node) {
		if (left == right) {
			return minTree[node] = arr[left];
		}

		int mid = (left + right) / 2;
		return minTree[node] = Math.min(minInit(left, mid, node * 2), minInit(mid + 1, right, node * 2 + 1));
	}

	private static int maxInit(int left, int right, int node) {
		if (left == right) {
			return maxTree[node] = arr[left];
		}

		int mid = (left + right) / 2;
		return maxTree[node] = Math.max(maxInit(left, mid, node * 2), maxInit(mid + 1, right, node * 2 + 1));
	}

	private static int getMin(int left, int right, int node, int startIdx, int endIdx) {
		if (endIdx < left || right < startIdx) {
			return Integer.MAX_VALUE;
		}

		if (startIdx <= left && right <= endIdx) {
			return minTree[node];
		}

		int mid = (left + right) / 2;
		return Math.min(getMin(left, mid, node * 2, startIdx, endIdx),
				getMin(mid + 1, right, node * 2 + 1, startIdx, endIdx));
	}

	private static int getMax(int left, int right, int node, int startIdx, int endIdx) {
		if (endIdx < left || right < startIdx) {
			return Integer.MIN_VALUE;
		}

		if (startIdx <= left && right <= endIdx) {
			return maxTree[node];
		}

		int mid = (left + right) / 2;
		return Math.max(getMax(left, mid, node * 2, startIdx, endIdx),
				getMax(mid + 1, right, node * 2 + 1, startIdx, endIdx));
	}

}
