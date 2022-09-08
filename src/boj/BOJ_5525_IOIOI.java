package boj;

import java.util.Scanner;

public class BOJ_5525_IOIOI {
	static String str;
	static char[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		str = sc.next();
		arr = str.toCharArray();
		sc.close();

		int result = 0;
		int idx = 0;
		int cnt = 0;

		while (idx < M - 2) {
			if (arr[idx] == 'I' && arr[idx + 1] == 'O' && arr[idx + 2] == 'I') {
				idx += 2;
				cnt++;
				if(cnt==N) {
					result++;
					cnt--;
				}
			} else {
				idx++;
				cnt = 0;
			}
		}
		System.out.println(result);

	}

	public static boolean isPossible(int idx, int N) {
		for (int i = 0; i < N; i++) {
			if (arr[idx + 2 * i + 1] != 'O') {
				return false;
			}
			if (arr[idx + 2 * i + 2] != 'I') {
				return false;
			}
		}
		return true;
	}
}
