package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	static int N;
	static int[] dp;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();

		if (N == 1) {
			System.out.println(0);
			return;
		}

		dp = new int[N + 1];
		Arrays.fill(dp, 1000000);
		dp[N] = 0;

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		while (!q.isEmpty()) {
			int x = q.poll();

			if (x % 3 == 0 && dp[x / 3] > dp[x] + 1) {
				dp[x / 3] = dp[x] + 1;
				if (x / 3 == 1) {
					break;
				}
				q.add(x / 3);
			}
			if (x % 2 == 0 && dp[x / 2] > dp[x] + 1) {
				dp[x / 2] = dp[x] + 1;
				if (x / 2 == 1) {
					break;
				}
				q.add(x / 2);
			}
			if (dp[x - 1] > dp[x] + 1) {
				dp[x - 1] = dp[x] + 1;
				if (x - 1 == 1) {
					break;
				}
				q.add(x - 1);

			}
		}

		System.out.println(dp[1]);

	}
}
