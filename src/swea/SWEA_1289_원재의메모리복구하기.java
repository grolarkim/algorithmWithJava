package swea;

import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			char now = '0';
			char[] arr = sc.next().toCharArray();
			for (char c : arr) {
				if (c != now) {
					cnt++;
					now = c;
				}
			}

			System.out.println("#" + tc + " " + cnt);

		}
	}
}
