package boj;

import java.util.Scanner;

public class BOJ_6064_카잉달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;

			int result = -1;
			for (int i = 0; i <= N; i++) {
				if ((i * M + x) % N == y) {
					result = i * M + x + 1;
					break;
				}
			}
			System.out.println(result);

		}

	}
}
