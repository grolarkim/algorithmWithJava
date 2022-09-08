package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.offer(i);
		}
		for (int i = 1; i < N; i++) {
			list.poll();
			list.offer(list.poll());
		}
		System.out.println(list.poll());

	}
}
