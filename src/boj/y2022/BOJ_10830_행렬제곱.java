package boj.y2022;

import java.util.Scanner;

public class BOJ_10830_행렬제곱 {
	public static int[][] matrix;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long B = sc.nextLong();

		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt() % 1000;
			}
		}
		sc.close();

		int[][] result = multi(B);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]);
				sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());

	}

	public static int[][] multi(long b) {
		if (b == (long) 1) {
			return matrix;
		}

		int[][] half = multi(b / 2);

		int[][] result;
		if (b % 2 == 0) {
			result = multiplication(half, half);
		} else {
			result = multiplication(multiplication(half, half), matrix);
		}

		return result;
	}

	public static int[][] multiplication(int[][] one, int[][] two) {
		int[][] result = new int[one.length][one.length];
		for (int i = 0; i < one.length; i++) {
			for (int j = 0; j < one.length; j++) {
				int sum = 0;
				for (int k = 0; k < one.length; k++) {
					sum += one[i][k] * two[k][j] % 1000;
				}
				result[i][j] = sum % 1000;
			}

		}

		return result;
	}

}
