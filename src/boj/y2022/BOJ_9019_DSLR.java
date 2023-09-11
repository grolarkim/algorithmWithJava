package boj.y2022;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9019_DSLR {
	static int A;
	static int B;
	static String[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			A = sc.nextInt();
			B = sc.nextInt();
			arr = new String[10000];
			bfs();
			System.out.println(arr[B]);

		}
		sc.close();

	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(A);
		arr[A] = "";
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == B) {
				break;
			}

			// D
			int d = (2 * now) % 10000;
			if (arr[d] == null) {
				q.offer(d);
				arr[d] = arr[now] + "D";
			}
			// S
			int s = (now + 9999) % 10000;
			if (arr[s] == null) {
				q.offer(s);
				arr[s] = arr[now] + "S";
			}
			// L
			int l = (now * 10) % 10000 + (now / 1000);
			if (arr[l] == null) {
				q.offer(l);
				arr[l] = arr[now] + "L";
			}
			// R
			int r = (now / 10) + (now % 10) * 1000;
			if (arr[r] == null) {
				q.offer(r);
				arr[r] = arr[now] + "R";
			}

		}

	}
}
