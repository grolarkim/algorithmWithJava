package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2243_사탕상자 {
	static int N;
	static int[] arr;
	static int[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[1_000_001];
		tree = new int[4_000_000];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			if (a.equals("1")) {
				int b = Integer.parseInt(st.nextToken());
				bw.write(getCandy(b) + "\n");
			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				arr[b] += c;
				update(1, 1_000_000, 1, b, arr[b]);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int update(int left, int right, int node, int idx, int val) {
		if (idx < left || right < idx) {
			return tree[node];
		}

		if (left == right) {
			return tree[node] = val;
		}

		int mid = (left + right) / 2;
		return tree[node] = update(left, mid, node * 2, idx, val) + update(mid + 1, right, node * 2 + 1, idx, val);
	}

	private static int getCandy(int target) {
		int left = 1;
		int right = 1000000;
		int idx = 0;
		int node = 1;
		while (node < 4000000) {
			if (left == right) {
				idx = left;
				break;
			}

			int l = tree[node * 2];
			int r = tree[node * 2 + 1];
			if (l < target) {
				target -= l;
				node = node * 2 + 1;
				left = (left + right) / 2 + 1;
			} else {
				node = node * 2;
				right = (left + right) / 2;
			}
		}

		arr[idx] -= 1;
		update(1, 1_000_000, 1, idx, arr[idx]);

		return idx;
	}

}
