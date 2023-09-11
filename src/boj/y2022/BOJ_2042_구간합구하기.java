package boj.y2022;

import java.io.*;
import java.util.*;

public class BOJ_2042_구간합구하기 {
	static int N, M, K;
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		tree = new long[N * 4];

		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		init(1, N, 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				arr[b] = c;
				update(1, N, 1, b);
			} else {
				bw.write(sum(1, N, 1, b, (int) c) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static long sum(int left, int right, int node, int startIdx, int endIdx) {
		if (endIdx < left || right < startIdx) {
			return 0;
		}

		if (startIdx <= left && right <= endIdx) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		return sum(left, mid, node * 2, startIdx, endIdx) + sum(mid + 1, right, node * 2 + 1, startIdx, endIdx);
	}

	private static long update(int left, int right, int node, int idx) {

		if (idx < left || right < idx) {
			return tree[node];
		}

		if (left == right) {
			return tree[node] = arr[idx];
		}

		int mid = (left + right) / 2;

		return tree[node] = update(left, mid, node * 2, idx) + update(mid + 1, right, node * 2 + 1, idx);
	}

	private static long init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;

		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}
}
