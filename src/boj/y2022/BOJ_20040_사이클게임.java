package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040_사이클게임 {
	static int N;
	static int M;
	static int[][] oper;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		oper = new int[M][2];
		parents = new int[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			oper[i][0] = Integer.parseInt(st.nextToken());
			oper[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		int result = 0;
		for (int i = 0; i < M; i++) {
			boolean isEnd = union(oper[i][0], oper[i][1]);
			if (isEnd) {
				result = i + 1;
				break;
			}
		}

		System.out.println(result);

	}

	static boolean union(int x, int y) {
		int rx = findRoot(x);
		int ry = findRoot(y);

		if (rx == ry) {
			return true;
		} else if (rx < ry) {
			parents[ry] = rx;
		} else {
			parents[rx] = ry;
		}
		return false;
	}

	static int findRoot(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = findRoot(parents[x]);
	}
}
