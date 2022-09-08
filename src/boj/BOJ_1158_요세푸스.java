package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1158_요세푸스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while (!list.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				list.offer(list.poll());
			}
			int man = list.poll();
			sb.append(man).append(", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append('>');
		System.out.println(sb.toString());

	}
}
