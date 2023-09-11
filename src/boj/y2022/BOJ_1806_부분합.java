package boj.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		int l = -1;
		int r = 0;
		int min = Integer.MAX_VALUE;
		if (arr[N - 1] < S) {
			System.out.println(0);
			return;
		}
		while (r < N) {
			if (l == -1 && arr[r] < S) {
				r++;
			} else if (l == -1 && arr[r] >= S) {
				min = Math.min(min, r - l);
				l++;
			} else if (arr[r] - arr[l] >= S) {
				min = Math.min(min, r - l);
				l++;
			} else {
				r++;
			}
		}
		System.out.println(min);
	}
}
