package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_9251_LCS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		char[] aa = new char[a.length() + 1];
		char[] bb = new char[b.length() + 1];

		for (int i = 0; i < a.length(); i++) {
			aa[i + 1] = a.charAt(i);
		}
		for (int i = 0; i < b.length(); i++) {
			bb[i + 1] = b.charAt(i);
		}

		int[][] dp = new int[a.length() + 1][b.length() + 1];

		for (int i = 1; i < aa.length; i++) {
			for (int j = 1; j < bb.length; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

				if (aa[i] == bb[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}

		System.out.println(dp[a.length()][b.length()]);

	}
}
