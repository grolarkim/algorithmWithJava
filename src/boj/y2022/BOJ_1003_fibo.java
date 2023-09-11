package boj.y2022;

import java.util.Scanner;

public class BOJ_1003_fibo {
	static int[] dp = new int[41];

	public static void main(String[] args) {
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= 40; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x == 0) {
				System.out.println(1 + " " + 0);
			} else {
				System.out.println(dp[x - 1] + " " + dp[x]);
			}
		}

	}
}
