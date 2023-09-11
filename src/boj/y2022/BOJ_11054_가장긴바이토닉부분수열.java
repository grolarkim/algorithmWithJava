package boj.y2022;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int[] dpf = new int[N];
		int[] dpb = new int[N];

		for (int i = 0; i < N; i++) {
			dpf[i] = 1;
			dpb[N - 1 - i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dpf[i] = Math.max(dpf[i], dpf[j] + 1);
				}
				if (arr[N - 1 - i] > arr[N - 1 - j]) {
					dpb[N - 1 - i] = Math.max(dpb[N - 1 - i], dpb[N - 1 - j] + 1);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, dpf[i] + dpb[i] - 1);
		}
		System.out.println(result);
	}
}
