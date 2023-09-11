package boj.y2022;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14891_톱니바퀴 {
	static int[] up = { 0, 0, 0, 0 };
	static int[][] gears;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		gears = new int[4][8];
		// 0,2,6 상,우,좌
		for (int i = 0; i < 4; i++) {
			char[] str = sc.next().toCharArray();
			for (int j = 0; j < 8; j++) {
				gears[i][j] = str[j] - '0';
			}
		}
		int K = sc.nextInt();

		for (int i = 0; i < K; i++) {
			rotate(sc.nextInt() - 1, sc.nextInt());
		}
		sc.close();

		int sum = gears[0][up[0]] * 1 + gears[1][up[1]] * 2 + gears[2][up[2]] * 4 + gears[3][up[3]] * 8;
		System.out.println(sum);

	}

	static void rotate(int gear, int direction) {
		if (gear > 0) {
			rot(gear, gear - 1, direction);
		}
		if (gear < 3) {
			rot(gear, gear + 1, direction);
		}
		up[gear] = (up[gear] + 8 - direction) % 8;

	}

	static void rot(int fromGear, int toGear, int direction) {
		if (fromGear > toGear) {
			int f = gears[fromGear][(up[fromGear] + 6) % 8];
			int t = gears[toGear][(up[toGear] + 2) % 8];
			if (f != t) {
				if (toGear > 0) {
					rot(toGear, toGear - 1, -direction);
				}
				up[toGear] = (up[toGear] + 8 + direction) % 8;
			}
		} else {
			int f = gears[fromGear][(up[fromGear] + 2) % 8];
			int t = gears[toGear][(up[toGear] + 6) % 8];
			if (f != t) {
				if (toGear < 3) {
					rot(toGear, toGear + 1, -direction);
				}
				up[toGear] = (up[toGear] + 8 + direction) % 8;

			}
		}
	}
}
