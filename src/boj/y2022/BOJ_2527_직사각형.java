package boj.y2022;

import java.util.Scanner;

public class BOJ_2527_직사각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 0; test_case < 4; test_case++) {
			int smallXFirst = sc.nextInt();
			int smallYFirst = sc.nextInt();
			int bigXFirst = sc.nextInt();
			int bigYFirst = sc.nextInt();
			int smallXSecond = sc.nextInt();
			int smallYSecond = sc.nextInt();
			int bigXSecond = sc.nextInt();
			int bigYSecond = sc.nextInt();

			boolean isXs = (smallXSecond == bigXFirst || bigXSecond == smallXFirst);
			boolean isYs = (smallYSecond == bigYFirst || bigYSecond == smallYFirst);

			boolean xx = (smallXFirst > bigXSecond || smallXSecond > bigXFirst);
			boolean yy = (smallYFirst > bigYSecond || smallYSecond > bigYFirst);

			if (xx || yy) {
				System.out.println("d");
			} else if (isXs && isYs) {
				System.out.println("c");
			} else if (isXs || isYs) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}

		}
	}
}
