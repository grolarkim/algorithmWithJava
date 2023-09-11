package boj.y2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12015_가장긴증가하는부분수열2 {
	static int N;
	static int[] arr;
	static int[] lis;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		lis = new int[N];
		Arrays.fill(lis, Integer.MAX_VALUE);
		max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		getLIS();
		System.out.println(max);
	}

	private static void getLIS() {
		for (int i = 0; i < N; i++) {
			int idx = Arrays.binarySearch(lis, arr[i]);
			if (idx < 0) {
				lis[(-idx - 1)] = arr[i];
				max = Math.max(max, (-idx - 1) + 1);
			}
		}
	}
}
