package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
	static int N;
	static int K;
	static int[] arr;
	static boolean[] robots;

	static int step = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[2 * N];
		robots = new boolean[2 * N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 2 * N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		simulation();
		System.out.println(step);

	}

	private static void simulation() {
		int start = 0;
		int end = N - 1;
		int cnt = 0;
		while (cnt < K) {
			step++;
			start += 2 * N - 1;
			end += 2 * N - 1;
			if (robots[end % (2 * N)]) {
				robots[end % (2 * N)] = false;
			}

			for (int i = end; i >= start; i--) {
				if (robots[i % (2 * N)] && !robots[(i + 1) % (2 * N)] && arr[(i + 1) % (2 * N)] != 0) {
					robots[i % (2 * N)] = false;
					robots[(i + 1) % (2 * N)] = true;
					arr[(i + 1) % (2 * N)] -= 1;
				}
			}
			if (robots[end % (2 * N)]) {
				robots[end % (2 * N)] = false;
			}
			if (arr[start % (2 * N)] != 0) {
				robots[start % (2 * N)] = true;
				arr[start % (2 * N)] -= 1;
			}
			cnt = 0;
			for (int a : arr) {
				if (a == 0) {
					cnt++;
				}
			}
		}

	}
}
