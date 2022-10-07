package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10868_최솟값 {
	static int N, M;
	static int[] arr;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		tree = new int[4 * N];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		init(1, N, 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(getMin(1, N, 1, a, b) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

	static int init(int left, int right, int node) {
		if (left == right) {
			return tree[node] = arr[left];
		}

		int mid = (left + right) / 2;
		return tree[node] = Math.min(init(left, mid, node * 2), init(mid + 1, right, node * 2 + 1));
	}

	static int getMin(int left, int right, int node, int start, int end) {
		if (end < left || right < start) {
			return Integer.MAX_VALUE;
		}

		if (start <= left && right <= end) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		return Math.min(getMin(left, mid, node * 2, start, end), getMin(mid + 1, right, node * 2 + 1, start, end));
	}
}
