package boj.y2022;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_10815_숫자카드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(sc.nextInt(), 1);
		}
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			if (map.containsKey(sc.nextInt())) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}

	}

}
