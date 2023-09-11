package boj.y2022;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_14002_가장긴증가하는부분수열4 {
	static int N;
	static int[] arr;
	static int[] dp;
	static int[] from;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		dp = new int[N];
		from = new int[N];

		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			from[i] = i;

			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					from[i] = j;
				}
			}
		}

		int max = 0;
		int maxIdx = -1;
		for (int i = 0; i < N; i++) {
			if (dp[i] > max) {
				max = dp[i];
				maxIdx = i;
			}
		}

		Stack<Integer> stack = new Stack<>();
		while (true) {
			stack.add(arr[maxIdx]);
			int i = from[maxIdx];
			if (i == maxIdx) {
				break;
			}
			maxIdx = i;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));

		System.out.println(max);
		System.out.println(sb.toString());

	}
}
