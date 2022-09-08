package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_13549_숨바꼭질3 {
	static int N;
	static int K;
	static int[] arr = new int[120_000];
	static int[] dp = new int[120_000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();

		LinkedList<Integer> q = new LinkedList<Integer>();
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
				q.offerFirst(next);
				arr[next] = arr[now];
			}
			next = now + 1;
			if (next < 120_000 && next >= 0 && arr[next] == -1) {
				q.offer(next);
				arr[next] = arr[now] + 1;
			}
			next = now - 1;
			if (next < 120_000 && next >= 0 && arr[next] == -1) {
				q.offer(next);
				arr[next] = arr[now] + 1;
			}
		}
		System.out.println(arr[K]);
	}
}
