package boj.y2022;

import java.util.Scanner;

public class BOJ_17386_선분교차 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x1 = sc.nextInt();
		long y1 = sc.nextInt();
		long x2 = sc.nextInt();
		long y2 = sc.nextInt();
		long x3 = sc.nextInt();
		long y3 = sc.nextInt();
		long x4 = sc.nextInt();
		long y4 = sc.nextInt();

		int c1 = ccw(x1, y1, x2, y2, x3, y3);
		int c2 = ccw(x1, y1, x2, y2, x4, y4);
		int c3 = ccw(x3, y3, x4, y4, x1, y1);
		int c4 = ccw(x3, y3, x4, y4, x2, y2);

		if (c1 * c2 < 0 && c3 * c4 < 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		if (x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1 < 0) {
			return 1;
		}
		return -1;
	}
}
