package boj.y2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195_친구네트워크 {
	static int T;
	static int N;
	static int[][] oper;
	static HashMap<String, Integer> map;
	static int[] parents;
	static int[] sizes;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken());
			oper = new int[N][2];
			map = new HashMap<String, Integer>();

			int idx = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				if (!map.containsKey(a)) {
					map.put(a, idx++);
				}
				String b = st.nextToken();
				if (!map.containsKey(b)) {
					map.put(b, idx++);
				}

				oper[i][0] = map.get(a);
				oper[i][1] = map.get(b);

			}

			parents = new int[idx];
			sizes = new int[idx];

			for (int i = 0; i < idx; i++) {
				parents[i] = i;
				sizes[i] = 1;
			}

			for (int i = 0; i < N; i++) {
				union(oper[i][0], oper[i][1]);
			}

			bw.write(sb.toString());

		}
		bw.flush();
		bw.close();
		br.close();
	}

	static void union(int x, int y) throws IOException {
		int rx = findRoot(x);
		int ry = findRoot(y);

		if (rx == ry) {
			sb.append(sizes[rx]).append('\n');
			return;
		} else if (rx < ry) {
			sizes[rx] += sizes[ry];
			parents[ry] = rx;
			sb.append(sizes[rx]).append('\n');
		} else {
			sizes[ry] += sizes[rx];
			parents[rx] = ry;
			sb.append(sizes[ry]).append('\n');
		}
	}

	static int findRoot(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = findRoot(parents[x]);
	}
}
