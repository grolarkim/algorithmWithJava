package boj.y2022;

import java.io.*;
import java.util.*;

public class BOJ_1717_집합의표현 {
	static int[] parr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parr = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parr[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (x == 0) {
				int aa = get(a);
				int bb = get(b);
				int p = Math.min(aa, bb);
				parr[aa] = p;
				parr[bb] = p;
			} else {
				if (isSame(a, b)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	static boolean isSame(int a, int b) {
		if (get(a) == get(b)) {
			return true;
		}
		return false;
	}

	static int get(int a) {
		if (parr[a] == a) {
			return a;
		}

		return parr[a] = get(parr[a]);
	}
}
