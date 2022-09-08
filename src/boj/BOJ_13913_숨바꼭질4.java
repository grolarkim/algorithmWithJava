package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_13913_숨바꼭질4 {
	static int N;
	static int K;
	static int[] arr = new int[120_000];
	static int[] dp = new int[120_000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		Arrays.fill(arr, -1);
		Arrays.fill(dp, -1);
		arr[N] = 0;
		dp[N] = N;
		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == K) {
				break;
			}

			int next = now * 2;
			if (next < 120_000 && next >= 0 && arr[next] == -1) {
				q.offer(next);
				arr[next] = arr[now] + 1;
				dp[next] = now;
			}
			next = now + 1;
			if (next < 120_000 && next >= 0 && arr[next] == -1) {
				q.offer(next);
				arr[next] = arr[now] + 1;
				dp[next] = now;
			}
			next = now - 1;
			if (next < 120_000 && next >= 0 && arr[next] == -1) {
				q.offer(next);
				arr[next] = arr[now] + 1;
				dp[next] = now;
			}
		}

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int now = K;
		while (now != dp[now]) {
			stack.add(now);
			now = dp[now];
		}
		stack.add(N);
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));

		System.out.println(arr[K]);
		System.out.println(sb.toString());
	}
}
