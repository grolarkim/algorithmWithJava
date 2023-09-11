package boj.y2022;

import java.util.*;

public class BOJ_2304_창고다각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int max0 = 0;
		int max1 = 0;
		int maxIdx = 0;
		int[][] arrs = new int[N][2];
		for (int i = 0; i < N; i++) {
			arrs[i][0] = sc.nextInt();
			arrs[i][1] = sc.nextInt();
			max0 = Math.max(arrs[i][0], max0);
			if (max1 < arrs[i][1]) {
				max1 = Math.max(arrs[i][1], max1);
				maxIdx = arrs[i][0];
			}
		}

		int[] heights = new int[max0 + 1];
		for (int[] arr : arrs) {
			heights[arr[0]] = arr[1];
		}

		int h = 0;
		int result = 0;
		for (int i = 0; i < maxIdx; i++) {
			h = Math.max(h, heights[i]);

			result += h;
		}

		h = 0;
		for (int i = max0; i >= maxIdx; i--) {
			h = Math.max(h, heights[i]);

			result += h;
		}

		System.out.println(result);

	}
}
