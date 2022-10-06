package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		int[] dp = new int[N];
		dp[0] = arr[0];
		max = Math.max(dp[0], max);
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1], 0) + arr[i];
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
