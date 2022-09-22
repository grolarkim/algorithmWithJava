package swea;

import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반 {
	static int N;
	static int B;
	static int[] arr;
	static boolean[] check;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			arr = new int[N];
			check = new boolean[N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			search(0);
			System.out.println("#" + tc + " " + min);
		}
		sc.close();
	}

	private static void search(int depth) {
		if (depth == N) {
			getMin();
			return;
		}
		search(depth + 1);
		check[depth] = true;
		search(depth + 1);
		check[depth] = false;
	}

	private static void getMin() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (check[i]) {
				result += arr[i];
			}
		}
		if (result >= B) {
			min = Math.min(min, result - B);
		}
	}
}
