package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_12852_1로만들기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		if (N == 1) {
			System.out.println(0);
			System.out.println(1);
			return;
		}

		int[] arr = new int[N + 1];
		arr[N] = N;

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == 1) {
				break;
			}

			if (now % 3 == 0 && arr[now / 3] == 0) {
				q.offer(now / 3);
				arr[now / 3] = now;
			}
			if (now % 2 == 0 && arr[now / 2] == 0) {
				q.offer(now / 2);
				arr[now / 2] = now;
			}
			if (arr[now - 1] == 0) {
				q.offer(now - 1);
				arr[now - 1] = now;
			}

		}

		Stack<Integer> stack = new Stack<>();
		int r = 1;
		stack.push(1);
		while (true) {
			if (arr[stack.peek()] == N) {
				stack.push(N);
				break;
			}

			stack.push(arr[stack.peek()]);
		}
		int size = stack.size();
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));

		System.out.println(size - 1);
		System.out.println(sb.toString());

	}
}
