package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_Shuffle_O_Matic {
	static int N;
	static int[] arr;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			min = 6;
			dfs(0);
			if (min == 6) {
				min = -1;
			}
			System.out.println("#" + tc + " " + min);
		}
	}

	static void dfs(int depth) {
		if (depth == 6) {
			return;
		}
		if (isSorted(arr)) {
			min = Math.min(depth, min);
			return;
		}
		for (int i = 0; i < N; i++) {
			int[] temp = arr.clone();
			shuffle(i);
			dfs(depth + 1);
			arr = temp.clone();
		}

	}

	static boolean isSorted(int[] narr) {
		boolean ascending = true;
		boolean descending = true;
		for (int i = 0; i < narr.length; i++) {
			if (i + 1 != narr[i]) {
				ascending = false;
			}
			if (i + 1 != narr[narr.length - 1 - i]) {
				descending = false;
			}
		}
		return ascending || descending;
	}

	static void shuffle(int num) {
		for (int i = 0; i <= num; i++) {
			if (i <= N / 2) {
				for (int j = 0; j < i; j++) {
					swap(N / 2 - i + (j * 2), N / 2 - i + (j * 2) + 1);
				}
			} else {
				for (int j = 0; j < N - i; j++) {
					swap(N / 2 - N + i + (j * 2), N / 2 - N + i + (j * 2) + 1);
				}
			}
		}

	}

	static void swap(int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;

	}
}
