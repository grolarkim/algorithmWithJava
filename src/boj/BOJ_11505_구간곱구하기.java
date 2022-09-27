package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11505_구간곱구하기 {
	static long MOD = 1000000007;
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

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				arr[b] = c;
				update(1, N, 1, b, c);
			} else if (a == 2) {
				sb.append(multi(1, N, 1, b, (int) c) + "\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static long init(int left, int right, int node) {
		if (left == right) {
			return tree[node] = arr[left];
		}

		int mid = (left + right) / 2;

		return tree[node] = (init(left, mid, node * 2) * init(mid + 1, right, node * 2 + 1)) % MOD;
	}

	private static long multi(int left, int right, int node, int startIdx, int endIdx) {
		if (endIdx < left || right < startIdx) {
			return 1;
		}

		if (startIdx <= left && right <= endIdx) {
			return tree[node];
		}

		int mid = (left + right) / 2;

		return (multi(left, mid, node * 2, startIdx, endIdx) * multi(mid + 1, right, node * 2 + 1, startIdx, endIdx))
				% MOD;
	}

	private static long update(int left, int right, int node, int idx, long val) {
		if (idx < left || right < idx) {
			return tree[node];
		}

		if (left == right) {
			return tree[node] = val;
		}

		int mid = (left + right) / 2;

		return tree[node] = (update(left, mid, node * 2, idx, val) * update(mid + 1, right, node * 2 + 1, idx, val))
				% MOD;
	}
}
