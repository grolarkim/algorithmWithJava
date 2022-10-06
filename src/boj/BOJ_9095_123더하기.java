package boj;

import java.util.Scanner;

public class BOJ_9095_123더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dp = new int[12];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < 12; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			System.out.println(dp[N]);

		}
		sc.close();
	}

}
