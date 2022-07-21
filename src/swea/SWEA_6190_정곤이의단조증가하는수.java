package swea;

import java.util.Scanner;

public class SWEA_6190_정곤이의단조증가하는수 {
	public static boolean isDanjo(int num) {
		int[] pow = {1,10,100,1000,10000,100000,1000000,10000000,100000000};
		for (int i = 0; i < 8; i++) {
			if (num / pow[i+1] % 10 > num / pow[i] % 10) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int result = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (isDanjo(arr[i] * arr[j])) {
						result = Math.max(result, arr[i] * arr[j]);
					}
				}
			}
			if (result != 0) {
				System.out.println("#" + test_case + " " + result);
			} else {
				System.out.println("#" + test_case + " -1");
			}
		}
	}

}
