package boj;

import java.util.Scanner;

public class BOJ_11727_2xn타일링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		}

		System.out.println(dp[N]);
	}
}
