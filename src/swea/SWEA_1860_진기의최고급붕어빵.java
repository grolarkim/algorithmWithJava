package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1860_진기의최고급붕어빵 {
	public static boolean isPossible(int[] customers, int M, int K) {
		for (int i = 0; i < customers.length; i++) {
			int breads = customers[i] / M * K;
			if (breads < i + 1) {
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
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] customers = new int[N];
			for (int i = 0; i < N; i++) {
				customers[i] = sc.nextInt();
			}
			Arrays.sort(customers);
			if (isPossible(customers, M, K)) {
				System.out.println("#" + test_case + " Possible");
			} else {
				System.out.println("#" + test_case + " Impossible");
			}
		}
	}
}
