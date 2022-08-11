package swea;

import java.util.Scanner;

public class SWEA_1961_2 {
	public static int[][] rotate(int[][] arr) {
		int[][] result = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				result[i][j] = arr[arr.length - j - 1][i];
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arrays = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arrays[i][j] = sc.nextInt();
				}
			}

			int[][] resultNinety = rotate(arrays);
			int[][] resultOneeighty = rotate(resultNinety);
			int[][] resultTwoseventy = rotate(resultOneeighty);

			StringBuilder sb = new StringBuilder();
			sb.append('#').append(test_case).append('\n');
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(resultNinety[i][j]);
				}
				sb.append(' ');
				for (int j = 0; j < N; j++) {
					sb.append(resultOneeighty[i][j]);
				}
				sb.append(' ');
				for (int j = 0; j < N; j++) {
					sb.append(resultTwoseventy[i][j]);
				}
				sb.append('\n');
			}
			System.out.print(sb.toString());
		}
	}
}
