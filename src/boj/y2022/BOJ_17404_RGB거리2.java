package boj.y2022;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17404_RGB거리2 {
	static int N;
	static int[][] map;
	static int[][] dpR;
	static int[][] dpG;
	static int[][] dpB;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][3];
		dpR = new int[N][3];
		dpG = new int[N][3];
		dpB = new int[N][3];

		for (int i = 0; i < N; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			map[i][2] = sc.nextInt();
		}

		dpR[0][0] = map[0][0];
		dpR[0][1] = dpR[0][2] = 100_000_000;
		dpG[0][1] = map[0][1];
		dpG[0][0] = dpG[0][2] = 100_000_000;
		dpB[0][2] = map[0][2];
		dpB[0][0] = dpB[0][1] = 100_000_000;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				dpR[i][j] = map[i][j] + Math.min(dpR[i - 1][(j + 1) % 3], dpR[i - 1][(j + 2) % 3]);
				dpG[i][j] = map[i][j] + Math.min(dpG[i - 1][(j + 1) % 3], dpG[i - 1][(j + 2) % 3]);
				dpB[i][j] = map[i][j] + Math.min(dpB[i - 1][(j + 1) % 3], dpB[i - 1][(j + 2) % 3]);
			}
		}

		int minR = Math.min(dpR[N - 1][1], dpR[N - 1][2]);
		int minG = Math.min(dpG[N - 1][0], dpG[N - 1][2]);
		int minB = Math.min(dpB[N - 1][0], dpB[N - 1][1]);

		int result = Math.min(minR, Math.min(minG, minB));

		System.out.println(result);

	}
}
