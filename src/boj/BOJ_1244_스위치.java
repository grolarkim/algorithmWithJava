package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1244_스위치 {
	static int N;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int H = sc.nextInt();
		int[][] oper = new int[H][2];
		for (int i = 0; i < H; i++) {
			operate(sc.nextInt(), sc.nextInt());
		}
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		StringBuilder sb5 = new StringBuilder();
		for (int i = 0; i < 20 && i < N; i++) {
			sb1.append(arr[i]).append(' ');
		}
		System.out.println(sb1.toString());
		if (N > 20) {
			for (int i = 20; i < 40 && i < N; i++) {
				sb2.append(arr[i]).append(' ');
			}

			System.out.println(sb2.toString());
		}
		if (N > 40) {
			for (int i = 40; i < 60 && i < N; i++) {
				sb3.append(arr[i]).append(' ');
			}

			System.out.println(sb3.toString());
		}
		if (N > 60) {
			for (int i = 60; i < 80 && i < N; i++) {
				sb4.append(arr[i]).append(' ');
			}

			System.out.println(sb4.toString());
		}
		if (N > 80) {
			for (int i = 80; i < 100 && i < N; i++) {
				sb5.append(arr[i]).append(' ');
			}

			System.out.println(sb5.toString());
		}
	}

	public static void operate(int mf, int k) {
		if (mf == 1) {
			for (int i = 0; i < N; i++) {
				if ((i + 1) % k == 0) {
					onOff(i);
				}
			}
		} else {
			onOff(k - 1);
			int step = 1;
			while (k - 1 - step >= 0 && k - 1 + step < N) {
				if (arr[k - 1 - step] != arr[k - 1 + step]) {
					break;
				}
				onOff(k - 1 - step);
				onOff(k - 1 + step);
				step++;
			}
		}

	}

	public static void onOff(int i) {
		if (arr[i] == 0) {
			arr[i] = 1;
		} else {
			arr[i] = 0;
		}
	}

}
