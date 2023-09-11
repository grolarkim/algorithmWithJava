package boj.y2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {
	static int N;
	static int K;
	static int[] arr = new int[120_000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		Arrays.fill(arr, -1);
		arr[N] = 0;
		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == K) {
				break;
			}

			int next = now * 2;
			if (next < 120_000 && next >= 0 && arr[next] == -1) {
				q.offer(next);
				arr[next] = arr[now] + 1;
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
