package swea;

import java.util.Scanner;

public class SWEA_1961_숫자배열회전 {
	public static int[][] RotateNinety(int[][] arrays) {
		int[][] result = new int[arrays.length][arrays.length];
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays.length; j++) {
				result[i][j] = arrays[arrays.length - j - 1][i];
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int size = sc.nextInt();
			int[][] arrays = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arrays[i][j] = sc.nextInt();
				}
			}

			int[][] resultNinety = RotateNinety(arrays);
			int[][] resultOneeighty = RotateNinety(resultNinety);
			int[][] resultTwoseventy = RotateNinety(resultOneeighty);

			System.out.println("#" + test_case);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(resultNinety[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < size; j++) {
					System.out.print(resultOneeighty[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < size; j++) {
					System.out.print(resultTwoseventy[i][j]);
				}
				System.out.println();
			}
		}
	}
}
