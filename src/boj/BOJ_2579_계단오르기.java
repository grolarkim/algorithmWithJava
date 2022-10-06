package boj;

import java.util.Scanner;

public class BOJ_2579_계단오르기 {
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		dp = new int[N + 1];
		if(N == 1) {
			System.out.println(arr[1]);
			return;
		}

		dp[1] = arr[1];
		dp[2] = dp[1] + arr[2];

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2]) + arr[i];
		}
		
		System.out.println(dp[N]);

	}
}
